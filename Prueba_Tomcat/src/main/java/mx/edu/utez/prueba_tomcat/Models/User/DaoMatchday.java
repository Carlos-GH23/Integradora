package mx.edu.utez.prueba_tomcat.Models.User;

import mx.edu.utez.prueba_tomcat.Models.Dao.DaoRepository;
import mx.edu.utez.prueba_tomcat.Utils.MySQLConnection;
import mx.edu.utez.prueba_tomcat.Models.Dao.DaoRepository;
import mx.edu.utez.prueba_tomcat.Models.Objetos.Matchday;
import mx.edu.utez.prueba_tomcat.Models.Objetos.Team;
import mx.edu.utez.prueba_tomcat.Utils.MySQLConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoMatchday implements DaoRepository<Matchday> {
    private Connection conn;
    private PreparedStatement pstm;
    private ResultSet rs;

    @Override
    public List<Matchday> findAll() {
        List<Matchday> matchdays = null;
        try {
            matchdays = new ArrayList<>();
            conn = new MySQLConnection().connect();

            String query = "SELECT * FROM MATCHDAY;";
            pstm = conn.prepareStatement(query);
            rs = pstm.executeQuery();
            while (rs.next()){
                Matchday matchday = new Matchday();
                matchday.setId(rs.getInt("Id_matchday"));
                matchday.setMatch_field(rs.getString("Match_field"));
                matchday.setStarthour(rs.getTime("Starthour"));
                matchday.setEndhour(rs.getTime("Endhour"));
                matchday.setDate_match(rs.getDate("Date_match"));
                matchday.setPoints(rs.getString("Points"));
                matchday.setDraws(rs.getInt("Draws"));
                matchday.setWins(rs.getInt("Wins"));
                matchday.setLoses(rs.getInt("Loses"));
                matchday.setGoal_difference(rs.getInt("Goal_difference"));
                matchday.setGoals_scored(rs.getInt("Goals_scored"));
                matchday.setGoals_against(rs.getInt("Goals_against"));
                matchday.setClasification(rs.getInt("Clasification"));
                matchdays.add(matchday);
            }
        } catch (SQLException e) {
            Logger.getLogger(Matchday.class.getName()).log(Level.SEVERE, "Error findAll: " + e.getMessage());
        }finally {
            closeResources();
        }
        return matchdays;
    }

    @Override
    public Matchday findOne(int id) {
        try {
            conn = new MySQLConnection().connect();
            String query = "SELECT * FROM MATCHDAY WHERE Id_matchday = ?;";
            pstm = conn.prepareStatement(query);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            Matchday matchday = new Matchday();
            if(rs.next()){
                matchday.setId(rs.getInt("Id_matchday"));
                matchday.setMatch_field(rs.getString("Match_field"));
                matchday.setStarthour(rs.getTime("Starthour"));
                matchday.setEndhour(rs.getTime("Endhour"));
                matchday.setDate_match(rs.getDate("Date_match"));
                matchday.setPoints(rs.getString("Points"));
                matchday.setDraws(rs.getInt("Draws"));
                matchday.setWins(rs.getInt("Wins"));
                matchday.setLoses(rs.getInt("Loses"));
                matchday.setGoal_difference(rs.getInt("Goal_difference"));
                matchday.setGoals_scored(rs.getInt("Goals_scored"));
                matchday.setGoals_against(rs.getInt("Goals_against"));
                matchday.setClasification(rs.getInt("Clasification"));

            }
            return matchday;
        } catch (SQLException e) {
            Logger.getLogger(Matchday.class.getName()).log(Level.SEVERE, "Error findOne: " + e.getMessage());
        }finally {
            closeResources();
        }
        return null;
    }

    @Override
    public boolean save(Matchday matchday) {
        try{
            conn = new MySQLConnection().connect();
            String query = "INSERT INTO MATCHDAY (Match_field, Starthour, Endhour, Date_match, Points, " +
                    "Draws, Wins, Loses, Goal_difference, Goals_scored, Goals_against, Clasification) VALUES (?, ?, ?, ?, ?, ?, ?, ?, " +
                    ", ?, ?, ?);";
            pstm = conn.prepareStatement(query);
            pstm.setString(1, matchday.getMatch_field());
            pstm.setTime(2, matchday.getStarthour());
            pstm.setTime(3, matchday.getEndhour());
            pstm.setDate(4, matchday.getDate_match());
            pstm.setString(5, matchday.getPoints());
            pstm.setInt(6, matchday.getDraws());
            pstm.setInt(7, matchday.getWins());
            pstm.setInt(8, matchday.getLoses());
            pstm.setInt(9, matchday.getGoal_difference());
            pstm.setInt(10, matchday.getGoals_scored());
            pstm.setInt(11, matchday.getGoals_against());
            return pstm.executeUpdate() > 0;

        } catch (SQLException e) {
            Logger.getLogger(Matchday.class.getName()).log(Level.SEVERE, "Error save: " + e.getMessage());
        }finally {
            closeResources();
        }
        return false;
    }

    @Override
    public boolean update(Matchday matchday) {
        try{
            conn = new MySQLConnection().connect();
            String query = "UPDATE MATCHDAY SET Match_field = ?, Starthour = ?, Endhour = ?, Date_match=?, Points=?," +
                    "Draws=?,Wins=?, Loses=?, Goal_difference=?, Goals_scored=?, Goals_against=?, Clasification=?  WHERE Id_matchday = ?;";
            pstm=conn.prepareStatement(query);
            pstm.setString(1, matchday.getMatch_field());
            pstm.setTime(2, matchday.getStarthour());
            pstm.setTime(3, matchday.getEndhour());
            pstm.setDate(4, matchday.getDate_match());
            pstm.setString(5, matchday.getPoints());
            pstm.setInt(6, matchday.getDraws());
            pstm.setInt(7, matchday.getWins());
            pstm.setInt(8, matchday.getLoses());
            pstm.setInt(9, matchday.getGoal_difference());
            pstm.setInt(10, matchday.getGoals_scored());
            pstm.setInt(11, matchday.getGoals_against());
            pstm.setInt(12,matchday.getId());
            return pstm.executeUpdate() > 0;
        } catch (SQLException e) {
            Logger.getLogger(Matchday.class.getName()).log(Level.SEVERE, "Error update: " + e.getMessage());
        }finally {
            closeResources();
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        try{
            conn = new MySQLConnection().connect();

            String query = "DELETE FROM MATCHDAY WHERE Id_team = ?;";
            pstm = conn.prepareStatement(query);
            pstm.setInt(1, id);
            return pstm.executeUpdate() > 0;

        } catch (SQLException e) {
            Logger.getLogger(Matchday.class.getName()).log(Level.SEVERE, "Error delete: " + e.getMessage());

        }finally {
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
            Logger.getLogger(Team.class.getName()).log(Level.SEVERE, "Error closing resources: " + e.getMessage());
        }
    }

}