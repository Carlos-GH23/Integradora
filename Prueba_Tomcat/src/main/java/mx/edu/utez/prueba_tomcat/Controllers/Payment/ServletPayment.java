package mx.edu.utez.prueba_tomcat.Controllers.Payment;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mx.edu.utez.prueba_tomcat.Models.Dao.DaoPayment;
import mx.edu.utez.prueba_tomcat.Models.Dao.DaoTeam;
import mx.edu.utez.prueba_tomcat.Models.Objetos.Payment;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

@WebServlet(name = "Servletpay",
        urlPatterns = {"/pago/pago",
                "/pago/pagos",
                "/pago/save",
                "/pago/create",
                "/pago/modify",
                "/pago/update",
                "/pago/delete",

        })

public class ServletPayment extends HttpServlet {
    private String action;
    private String redirect = "/pago/pagos";

    Payment payment;
    private int id;
    private String paymentType;
    private boolean paymentCheckout;
    private int teamId;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        this.action = req.getServletPath();
        switch (this.action) {
            case "/pago/pagos":
                List<Payment> Pagos = (new DaoPayment()).findAll();
                req.setAttribute("pago", Pagos);
                redirect = "/views/Admin/Pagos.jsp";
                break;
            case "/pago/pago":
                redirect = "/views/Admin/Pago.jsp";
                break;
            case "/pago/create":
                this.id = Integer.parseInt(req.getParameter("Id_team"));
                this.payment = (new DaoPayment()).findOne(this.id != 0 ? Integer.parseInt(String.valueOf(this.id)) : 0);
                if (this.payment != null) {
                    req.setAttribute("pago", this.payment);
                    redirect = "/views/Admin/Editarpago.jsp";
                } else {
                    redirect = "/pago/create?result= false&message=" + URLEncoder.encode(" Error al actualizar ", StandardCharsets.UTF_8);
                }
                break;
            default:
                System.out.println(this.action);
        }

        req.getRequestDispatcher(this.redirect).forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");
        this.action = req.getServletPath();
        switch (this.action) {
            case "/pago/delete":
                id = Integer.parseInt(req.getParameter("Id_payment"));
                if ((new DaoTeam()).delete( Integer.parseInt(String.valueOf(this.id)))) {
                    redirect = "/pago/pagos?result= true&message=" + URLEncoder.encode("Pago eliminado de forma exitosa", StandardCharsets.UTF_8);
                } else {
                    redirect = "/pago/pagos?result= false&message=" + URLEncoder.encode("Error al realizar la acción", StandardCharsets.UTF_8);
                }
                break;
            case "/pago/save":
                this.id = Integer.parseInt(req.getParameter("Id_payment"));
                this.paymentType = req.getParameter("Payment_type");
                this.paymentCheckout = Boolean.parseBoolean(req.getParameter("Payment_checkout"));
                this.teamId = Integer.parseInt(req.getParameter("Fk_team"));
                this.payment = new Payment(0 , this.paymentType, this.paymentCheckout, this.teamId);
                boolean result = (new DaoPayment()).save(this.payment);
                if (result) {
                    this.redirect = "/pago/pagos?result=true&message=" + URLEncoder.encode("Pago registrado de forma exitosa", StandardCharsets.UTF_8);
                } else {
                    this.redirect = "/pago/pagos?result= false&message=" + URLEncoder.encode("Error al realizar la acción", StandardCharsets.UTF_8);
                }
                break;
            case "/pago/update":
                this.id = Integer.parseInt(req.getParameter("Id_payment"));
                this.paymentType = req.getParameter("Payment_type");
                this.paymentCheckout = Boolean.parseBoolean(req.getParameter("Payment_checkout"));
                this.teamId = Integer.parseInt(req.getParameter("Fk_team"));
                this.payment = new Payment(0 , this.paymentType, this.paymentCheckout, this.teamId);
                if ((new DaoPayment()).update(this.payment)) {
                    redirect = "/pago/pagos?result=true&message=" + URLEncoder.encode("Pago actualizado correctamente ", StandardCharsets.UTF_8);
                } else {
                    redirect = "/pago/pagos?result= false&message=" + URLEncoder.encode("Error al realizar la acción", StandardCharsets.UTF_8);
                }
        }

        String var10001 = req.getContextPath();
        resp.sendRedirect(var10001 + this.redirect);
    }

}
