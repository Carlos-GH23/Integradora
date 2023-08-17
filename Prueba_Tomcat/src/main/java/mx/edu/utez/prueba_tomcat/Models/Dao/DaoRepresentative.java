package mx.edu.utez.prueba_tomcat.Models.Dao;

import mx.edu.utez.prueba_tomcat.Models.Objetos.Representative;
import mx.edu.utez.prueba_tomcat.Utils.MySQLConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoRepresentative implements DaoRepository<Representative> {

    private Connection conn;
    private PreparedStatement pstm;
    private ResultSet rs;

    @Override
    public List<Representative> findAll() {
        List<Representative> representatives = null;
        try {
            representatives = new ArrayList<>();
            conn = new MySQLConnection().connect();

            String query = "SELECT * FROM REPRESENTATIVES;";
            pstm = conn.prepareStatement(query);
            rs = pstm.executeQuery();
            while (rs.next()) {
                Representative representative = new Representative();
                representative.setId(rs.getInt("Id_rep"));
                representative.setName(rs.getString("Rep_name"));
                representative.setLastName(rs.getString("Last_name"));
                representative.setLastName2(rs.getString("Last_name2"));
                representative.setPhoneNumber(rs.getString("Phone_number"));
                representative.setUsername(rs.getString("Rep_user"));
                representative.setPassword(rs.getString("Rep_pass"));
                representative.setTeamId(rs.getInt("fk_team"));
                representative.setRole("Role");
                representatives.add(representative);
            }
        } catch (SQLException e) {
            Logger.getLogger(Representative.class.getName()).log(Level.SEVERE, "Error findAll: " + e.getMessage());
        } finally {
            closeResources();
        }
        return representatives;
    }

    @Override
    public Representative findOne(int id) {
        try {
            conn = new MySQLConnection().connect();

            String query = "SELECT * FROM REPRESENTATIVES WHERE Id_rep = ?;";
            pstm = conn.prepareStatement(query);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            Representative representative = new Representative();
            if (rs.next()) {
                representative.setId(rs.getInt("Id_rep"));
                representative.setName(rs.getString("Name_representative"));
                representative.setLastName(rs.getString("Last_name"));
                representative.setLastName2(rs.getString("Last_name2"));
                representative.setPhoneNumber(rs.getString("Phone_number"));
                representative.setUsername(rs.getString("Rep_user"));
                representative.setPassword(rs.getString("Rep_pass"));
                representative.setTeamId(rs.getInt("fk_team"));
                representative.setRole(rs.getString("Role"));
            }
            return representative;
        } catch (SQLException e) {
            Logger.getLogger(Representative.class.getName()).log(Level.SEVERE, "Error findOne: " + e.getMessage());
        } finally {
            closeResources();
        }
        return null;
    }
    @Override
    public boolean save(Representative representative) {
        try {
            conn = new MySQLConnection().connect();

            String query = "INSERT INTO REPRESENTATIVES (Rep_name, Last_name, Last_name2, " +
                    "Num_phone, Rep_user, Rep_pass, Role, fk_team) VALUES (?, ?, ?, ?, ?, ?, ?,?);";
            pstm = conn.prepareStatement(query);
            pstm.setString(1, representative.getName());
            pstm.setString(2, representative.getLastName());
            pstm.setString(3, representative.getLastName2());
            pstm.setString(4, representative.getPhoneNumber());
            pstm.setString(5, representative.getUsername());
            pstm.setString(6, representative.getPassword());
            pstm.setInt(7, representative.getTeamId());
            pstm.setString(8,representative.getRole());
            return pstm.executeUpdate() > 0;
        } catch (SQLException e) {
            Logger.getLogger(Representative.class.getName()).log(Level.SEVERE, "Error save: " + e.getMessage());
        } finally {
            closeResources();
        }
        return false;
    }

    public Representative loadUserByUsernameAndPassword(String username, String password) {
        Representative representative = null;

        try {
            conn = new MySQLConnection().connect();
            String query = "SELECT * FROM REPRESENTATIVES WHERE Rep_user = ? AND Rep_pass = ?";
            pstm = conn.prepareStatement(query);
            pstm.setString(1, username);
            pstm.setString(2, password);
            rs = pstm.executeQuery();

            if (rs.next()) {
                representative = new Representative();
                representative.setId(rs.getInt("Id_rep"));
                representative.setName(rs.getString("Rep_name"));
                representative.setLastName(rs.getString("Last_name"));
                representative.setLastName2(rs.getString("Last_name2"));
                representative.setPhoneNumber(rs.getString("Num_phone"));
                representative.setUsername(rs.getString("Rep_user"));
                representative.setPassword(rs.getString("Rep_pass"));
                representative.setTeamId(rs.getInt("Fk_team"));
                representative.setRole(rs.getString("Rep_role"));
                System.out.println("ROLE FROM DB:"+rs.getString("Rep_role"));
            }
        } catch (SQLException e) {
            Logger.getLogger(DaoRepresentative.class.getName())
                    .log(Level.SEVERE, "Error en el usuario o contraseña " + e.getMessage());
        } finally {
            closeResources();
        }

        return representative;
    }



    @Override
    public boolean update(Representative representative) {
        try {
            conn = new MySQLConnection().connect();

            String query = "UPDATE REPRESENTATIVES SET Rep_name = ?, Last_name = ?, Last_name2 = ?, " +
                    "Num_phone = ?, rep_user = ?, rep_pass = ?,Role= ? fk_team = ? WHERE Id_rep= ?;";
            pstm = conn.prepareStatement(query);
            pstm.setString(1, representative.getName());
            pstm.setString(2, representative.getLastName());
            pstm.setString(3, representative.getLastName2());
            pstm.setString(4, representative.getPhoneNumber());
            pstm.setString(5, representative.getUsername());
            pstm.setString(6, representative.getPassword());
            pstm.setInt(7, representative.getTeamId());
            pstm.setString(8, representative.getRole());
            pstm.setInt(9, representative.getId());
            return pstm.executeUpdate() > 0;
        } catch (SQLException e) {
            Logger.getLogger(Representative.class.getName()).log(Level.SEVERE, "Error update: " + e.getMessage());
        } finally {
            closeResources();
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        try {
            conn = new MySQLConnection().connect();

            String query = "DELETE FROM REPRESENTATIVES WHERE Id_rep = ?;";
            pstm = conn.prepareStatement(query);
            pstm.setInt(1, id);
            return pstm.executeUpdate() > 0;
        } catch (SQLException e) {
            Logger.getLogger(Representative.class.getName()).log(Level.SEVERE, "Error delete: " + e.getMessage());
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
            Logger.getLogger(Representative.class.getName()).log(Level.SEVERE, "Error closing resources: " + e.getMessage());
        }
    }
}
