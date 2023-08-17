package mx.edu.utez.prueba_tomcat.Models.Dao;

import mx.edu.utez.prueba_tomcat.Models.Objetos.Payment;
import mx.edu.utez.prueba_tomcat.Utils.MySQLConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoPayment  implements DaoRepository<Payment> {
    private Connection conn ;
    private PreparedStatement pstm;
    private ResultSet rs;
    @Override
    public List<Payment> findAll() {
        List<Payment> payments = null;
        try {
            payments = new ArrayList<>();
            conn = new MySQLConnection().connect();
            String query = "SELECT * FROM PAYMENT;";
            pstm = conn.prepareStatement(query);
            rs = pstm.executeQuery();
            while (rs.next()) {
                Payment payment = new Payment();
                payment.setId(rs.getInt("Id_payment"));
                payment.setPaymentType(rs.getString("Payment_type"));
                payment.setPaymentCheckout(rs.getBoolean("Payment_checkout"));
                payment.setTeamId(rs.getInt("fk_team"));
                payments.add(payment);
            }
        } catch (SQLException e) {
            Logger.getLogger(mx.edu.utez.prueba_tomcat.Models.Objetos.Payment.class.getName())
                    .log(Level.SEVERE, "Error findAll: " + e.getMessage());
        } finally {
            closeResources();
        }
        return payments;
    }

    @Override
    public Payment findOne(int id) {
        try {
            conn = new MySQLConnection().connect();
            String query = "SELECT * FROM PAYMENT WHERE Id_payment = ?;";
            pstm = conn.prepareStatement(query);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            Payment payment = new Payment();
            if (rs.next()) {
                payment.setId(rs.getInt("Id_payment"));
                payment.setPaymentType(rs.getString("Payment_type"));
                payment.setPaymentCheckout(rs.getBoolean("Payment_checkout"));
                payment.setTeamId(rs.getInt("fk_team"));
            }
            return payment;
        } catch (SQLException e) {
            Logger.getLogger(mx.edu.utez.prueba_tomcat.Models.Objetos.Payment.class.getName())
                    .log(Level.SEVERE, "Error findOne: " + e.getMessage());
        } finally {
            closeResources();
        }
        return null;
    }

    @Override
    public boolean save(Payment payment) {
        try {
            conn = new MySQLConnection().connect();
            String query = "INSERT INTO PAYMENT (Payment_type, Payment_checkout, fk_team) " +
                    "VALUES (?, ?, ?);";
            pstm = conn.prepareStatement(query);
            pstm.setString(1, payment.getPaymentType());
            pstm.setBoolean(2, payment.isPaymentCheckout());
            pstm.setInt(3, payment.getTeamId());
            return pstm.executeUpdate() > 0;
        } catch (SQLException e) {
            Logger.getLogger(mx.edu.utez.prueba_tomcat.Models.Objetos.Payment.class.getName())
                    .log(Level.SEVERE, "Error save: " + e.getMessage());
        } finally {
            closeResources();
        }
        return false;
    }

    @Override
    public boolean update(Payment payment) {
        try {
            conn = new MySQLConnection().connect();
            String query = "UPDATE PAYMENT SET Payment_type = ?, Payment_checkout = ?, fk_team = ? " +
                    "WHERE Id_payment = ?;";
            pstm = conn.prepareStatement(query);
            pstm.setString(1, payment.getPaymentType());
            pstm.setBoolean(2, payment.isPaymentCheckout());
            pstm.setInt(3, payment.getTeamId());
            pstm.setInt(4, payment.getId());
            return pstm.executeUpdate() > 0;
        } catch (SQLException e) {
                Logger.getLogger(mx.edu.utez.prueba_tomcat.Models.Objetos.Payment.class.getName())
                    .log(Level.SEVERE, "Error update: " + e.getMessage());
        } finally {
            closeResources();
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        try {
            conn = new MySQLConnection().connect();
            String query = "DELETE FROM PAYMENT WHERE Id_payment = ?;";
            pstm = conn.prepareStatement(query);
            pstm.setInt(1, id);
            return pstm.executeUpdate() > 0;
        } catch (SQLException e) {
            Logger.getLogger(mx.edu.utez.prueba_tomcat.Models.Objetos.Payment.class.getName())
                    .log(Level.SEVERE, "Error delete: " + e.getMessage());
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
            Logger.getLogger(mx.edu.utez.prueba_tomcat.Utils.MySQLConnection.class.getName()).log(Level.SEVERE, "Error closing resources: " + e.getMessage());
        }
    }
}


