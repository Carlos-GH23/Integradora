package mx.edu.utez.prueba_tomcat.Models.Dao;

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

public class DaoTeam implements DaoRepository<Team> {
    private Connection conn;
    private PreparedStatement pstm;
    private ResultSet rs;

    @Override
    public List<Team> findAll() {
        List<Team> teams = new ArrayList<>();
        try {
            conn = new MySQLConnection().connect();

            String query = "SELECT * FROM TEAMS;";
            pstm = conn.prepareStatement(query);
            rs = pstm.executeQuery();
            while (rs.next()) {
                Team team = new Team();
                team.setId(rs.getInt("Id_team"));
                team.setName(rs.getString("Name_team"));
                team.setMembers(rs.getInt("Members"));
                team.setMatchdayId(rs.getInt("fk_matchday"));
                teams.add(team);
            }
        } catch (SQLException e) {
            Logger.getLogger(DaoTeam.class.getName()).log(Level.SEVERE, "Error findAll: " + e.getMessage());
        } finally {
            closeResources();
        }
        return teams;
    }

    @Override
    public Team findOne(int id) {
        try {
            conn = new MySQLConnection().connect();

            String query = "SELECT * FROM TEAMS WHERE Id_team = ?;";
            pstm = conn.prepareStatement(query);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            Team team = new Team();
            if (rs.next()) {
                team.setId(rs.getInt("Id_team"));
                team.setName(rs.getString("Name_team"));
                team.setMembers(rs.getInt("Members"));
                team.setMatchdayId(rs.getInt("fk_matchday"));
            }
            return team;
        } catch (SQLException e) {
            Logger.getLogger(DaoTeam.class.getName()).log(Level.SEVERE, "Error findOne: " + e.getMessage());
        } finally {
            closeResources();
        }
        return null;
    }

    @Override
    public boolean save(Team team) {
        try {
            conn = new MySQLConnection().connect();

            String query = "INSERT INTO TEAMS (Name_team, Members, fk_matchday) VALUES (?, ?, ?);";
            pstm = conn.prepareStatement(query);
            pstm.setString(1, team.getName());
            pstm.setInt(2, team.getMembers());
            pstm.setInt(3, team.getMatchdayId());
            return pstm.executeUpdate() > 0;
        } catch (SQLException e) {
            Logger.getLogger(DaoTeam.class.getName()).log(Level.SEVERE, "Error save: " + e.getMessage());
        } finally {
            closeResources();
        }
        return false;
    }

    @Override
    public boolean update(Team team) {
        try {
            conn = new MySQLConnection().connect();

            String query = "UPDATE TEAMS SET Name_team = ?, Members = ?, fk_matchday = ? WHERE Id_team = ?;";
            pstm = conn.prepareStatement(query);
            pstm.setString(1, team.getName());
            pstm.setInt(2, team.getMembers());
            pstm.setInt(3, team.getMatchdayId());
            pstm.setInt(4, team.getId());
            return pstm.executeUpdate() > 0;
        } catch (SQLException e) {
            Logger.getLogger(DaoTeam.class.getName()).log(Level.SEVERE, "Error update: " + e.getMessage());
        } finally {
            closeResources();
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        try {
            conn = new MySQLConnection().connect();

            String query = "DELETE FROM TEAMS WHERE Id_team = ?;";
            pstm = conn.prepareStatement(query);
            pstm.setInt(1, id);
            return pstm.executeUpdate() > 0;
        } catch (SQLException e) {
            Logger.getLogger(DaoTeam.class.getName()).log(Level.SEVERE, "Error delete: " + e.getMessage());
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
            Logger.getLogger(DaoTeam.class.getName()).log(Level.SEVERE, "Error closing resources: " + e.getMessage());
        }
    }
}
