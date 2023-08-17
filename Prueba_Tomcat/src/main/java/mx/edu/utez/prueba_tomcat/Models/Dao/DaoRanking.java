package mx.edu.utez.prueba_tomcat.Models.Dao;

import mx.edu.utez.prueba_tomcat.Models.Objetos.RankingPlayer;
import mx.edu.utez.prueba_tomcat.Utils.MySQLConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoRanking implements DaoRepository<RankingPlayer>{

    private Connection conn;
    private PreparedStatement pstm;
    private ResultSet rs;


    @Override
    public List<RankingPlayer> findAll() {
        List<RankingPlayer> rankings = null;
        try {
            rankings = new ArrayList<>();
            conn = new MySQLConnection().connect();

            String query = "SELECT * FROM RANKING_PLAYERS;";
            pstm = conn.prepareStatement(query);
            rs = pstm.executeQuery();
            while (rs.next()) {
                RankingPlayer rankingPlayer = new RankingPlayer();
                rankingPlayer.setId(rs.getInt("Id_ranking"));
                rankingPlayer.setRedCard(rs.getInt("Red_card"));
                rankingPlayer.setYellowCard(rs.getInt("Yel_card"));
                rankingPlayer.setGoals(rs.getInt("Goals"));
                rankingPlayer.setAssistances(rs.getInt("Assistences"));
                rankingPlayer.setPlayerId(rs.getInt("Fk_player"));
                rankings.add(rankingPlayer);
            }
        } catch (SQLException e) {
            Logger.getLogger(RankingPlayer.class.getName()).log(Level.SEVERE, "Error findAll: " + e.getMessage());
        } finally {
            closeResources();
        }
        return rankings;
    }

    @Override
    public RankingPlayer findOne(int id) {
        try {
            conn = new MySQLConnection().connect();

            String query = "SELECT * FROM RANKING_PLAYERS WHERE Id_ranking = ?;";
            pstm = conn.prepareStatement(query);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            RankingPlayer rankingPlayer = new RankingPlayer();
            if (rs.next()) {
                rankingPlayer.setId(rs.getInt("Id_ranking"));
                rankingPlayer.setRedCard(rs.getInt("Red_card"));
                rankingPlayer.setYellowCard(rs.getInt("Yel_card"));
                rankingPlayer.setGoals(rs.getInt("Goals"));
                rankingPlayer.setAssistances(rs.getInt("Assistences"));
                rankingPlayer.setPlayerId(rs.getInt("Fk_player"));
            }
            return rankingPlayer;
        } catch (SQLException e) {
            Logger.getLogger(RankingPlayer.class.getName()).log(Level.SEVERE, "Error findOne: " + e.getMessage());
        } finally {
            closeResources();
        }
        return null;
    }

    @Override
    public boolean save(RankingPlayer rankingPlayer) {
        try {
            conn = new MySQLConnection().connect();

            String query = "INSERT INTO RANKING_PLAYERS (Red_card, Yel_card, Goals, Assistences, Fk_player) " +
                    "VALUES (?, ?, ?, ?, ?);";
            pstm = conn.prepareStatement(query);
            pstm.setInt(1, rankingPlayer.getRedCard());
            pstm.setInt(2, rankingPlayer.getYellowCard());
            pstm.setInt(3, rankingPlayer.getGoals());
            pstm.setInt(4, rankingPlayer.getAssistances());
            pstm.setInt(5, rankingPlayer.getPlayerId());
            return pstm.executeUpdate() > 0;
        } catch (SQLException e) {
            Logger.getLogger(RankingPlayer.class.getName()).log(Level.SEVERE, "Error save: " + e.getMessage());
        } finally {
            closeResources();
        }
        return false;
    }

    @Override
    public boolean update(RankingPlayer rankingPlayer) {
        try {
            conn = new MySQLConnection().connect();

            String query = "UPDATE RANKING_PLAYERS SET Red_card = ?, Yel_card = ?, Goals = ?, " +
                    "Assistences = ?, Fk_player = ? WHERE Id_ranking = ?;";
            pstm = conn.prepareStatement(query);
            pstm.setInt(1, rankingPlayer.getRedCard());
            pstm.setInt(2, rankingPlayer.getYellowCard());
            pstm.setInt(3, rankingPlayer.getGoals());
            pstm.setInt(4, rankingPlayer.getAssistances());
            pstm.setInt(5, rankingPlayer.getPlayerId());
            pstm.setInt(6, rankingPlayer.getId());
            return pstm.executeUpdate() > 0;
        } catch (SQLException e) {
            Logger.getLogger(RankingPlayer.class.getName()).log(Level.SEVERE, "Error update: " + e.getMessage());
        } finally {
            closeResources();
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        try {
            conn = new MySQLConnection().connect();

            String query = "DELETE FROM RANKING_PLAYERS WHERE Id_ranking = ?;";
            pstm = conn.prepareStatement(query);
            pstm.setInt(1, id);
            return pstm.executeUpdate() > 0;
        } catch (SQLException e) {
            Logger.getLogger(RankingPlayer.class.getName()).log(Level.SEVERE, "Error delete: " + e.getMessage());
        } finally {
            closeResources();
        }
        return false;
    }

    private void closeResources() {
        try {
            if (rs != null) {
                rs.close();
            }
            if (pstm != null) {
                pstm.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            Logger.getLogger(RankingPlayer.class.getName()).log(Level.SEVERE, "Error closing resources: " + e.getMessage());
        }
    }

}
