package mx.edu.utez.prueba_tomcat.Models.Dao;
import mx.edu.utez.prueba_tomcat.Models.Objetos.Player;
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

public class DaoPlayer  implements DaoRepository<Player> {
    private Connection conn ;
    private PreparedStatement pstm;
    private ResultSet rs;
    @Override
    public List<Player> findAll() {
        List<Player> players = null;
        try {
            players = new ArrayList<>();
            conn = new MySQLConnection().connect(); // Crear instancia y llamar al método connect()

            String query = "SELECT * FROM PLAYERS;";
            pstm = conn.prepareStatement(query);
            rs = pstm.executeQuery();
            while (rs.next()) {
                Player player = new Player();
                player.setId(rs.getInt("Id_player"));
                player.setName(rs.getString("Name_player"));
                player.setSurname(rs.getString("Surname"));
                player.setSurname2(rs.getString("Surname2"));
                player.setPosition(rs.getString("Player_position"));
                player.setDorsal(rs.getString("Dorsal"));
                player.setTeamId(rs.getInt("fk_team"));
                players.add(player);
            }
        } catch (SQLException e) {
            Logger.getLogger(Player.class.getName()).log(Level.SEVERE, "Error findAll: " + e.getMessage());
        } finally {
            closeResources();
        }
        return players;
    }

    @Override
    public Player findOne(int id) {
        Player player = null; // Declarar el objeto Player fuera del bucle

        try {
            conn = new MySQLConnection().connect();

            String query = "SELECT p.Id_player, p.Name_player, p.Surname, p.Surname2, p.Player_position, p.Dorsal, p.fk_team, t.Id_team, t.Name_team, t.Members, t.fk_matchday, p.image_data FROM PLAYERS p" +
                    " INNER JOIN TEAMS t ON p.fk_team = t.Id_team WHERE p.Id_player = ?";
            pstm = conn.prepareStatement(query);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();

            while (rs.next()) {
                    player = new Player();
                    player.setId(rs.getInt("Id_player"));
                    player.setName(rs.getString("Name_player"));
                    player.setSurname(rs.getString("Surname"));
                    player.setSurname2(rs.getString("Surname2"));
                    player.setPosition(rs.getString("Player_position"));
                    player.setDorsal(rs.getString("Dorsal"));
                    player.setTeamId(rs.getInt("fk_team"));
                    player.setFile(rs.getString("image_data"));
                    Team team = new Team();
                    team.setId(rs.getInt("Id_team"));
                    team.setName(rs.getString("Name_team"));
                    team.setMembers(rs.getInt("Members"));
                    team.setMatchdayId(rs.getInt("fk_matchday"));
                    player.setTeam(team);
                System.out.println(player.getFile());
            }

        } catch (SQLException e) {
            Logger.getLogger(Player.class.getName()).log(Level.SEVERE, "Error findOne: " + e.getMessage());
        } finally {
            closeResources();
        }

        return player;
    }


    @Override
    public boolean save(Player player) {
        try {
            conn = new MySQLConnection().connect(); // Crear instancia y llamar al método connect()

            String query = "INSERT INTO PLAYERS (Name_player, Surname, Surname2, Player_position, Dorsal, fk_team, image_data) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?);";
            pstm = conn.prepareStatement(query);
            pstm.setString(1, player.getName());
            pstm.setString(2, player.getSurname());
            pstm.setString(3, player.getSurname2());
            pstm.setString(4, player.getPosition());
            pstm.setString(5, player.getDorsal());
            pstm.setInt(6, player.getTeamId());
            pstm.setString(7, player.getFile());
            return pstm.executeUpdate() > 0;
        } catch (SQLException e) {
            Logger.getLogger(Player.class.getName()).log(Level.SEVERE, "Error save: " + e.getMessage());
        } finally {
            closeResources();
        }
        return false;
    }

    @Override
    public boolean update(Player player) {
        try {
            conn = new MySQLConnection().connect(); // Crear instancia y llamar al método connect()

            String query = "UPDATE PLAYERS SET Name_player = ?, Surname = ?, Surname2 = ?, " +
                    "Player_position = ?, Dorsal = ?, fk_team = ? WHERE Id_player = ?;";
            pstm = conn.prepareStatement(query);
            pstm.setString(1, player.getName());
            pstm.setString(2, player.getSurname());
            pstm.setString(3, player.getSurname2());
            pstm.setString(4, player.getPosition());
            pstm.setString(5, player.getDorsal());
            pstm.setInt(6, player.getTeamId());
            pstm.setInt(7, player.getId());
            return pstm.executeUpdate() > 0;
        } catch (SQLException e) {
            Logger.getLogger(Player.class.getName()).log(Level.SEVERE, "Error update: " + e.getMessage());
        } finally {
            closeResources();
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        try {
            conn = new MySQLConnection().connect(); // Crear instancia y llamar al método connect()

            String query = "DELETE FROM PLAYERS WHERE Id_player = ?;";
            pstm = conn.prepareStatement(query);
            pstm.setInt(1, id);
            return pstm.executeUpdate() > 0;
        } catch (SQLException e) {
            Logger.getLogger(Player.class.getName()).log(Level.SEVERE, "Error delete: " + e.getMessage());
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
            Logger.getLogger(MySQLConnection.class.getName()).log(Level.SEVERE, "Error closing resources: " + e.getMessage());
        }
    }

}
