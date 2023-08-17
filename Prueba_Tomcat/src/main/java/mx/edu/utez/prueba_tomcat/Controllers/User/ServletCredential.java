package mx.edu.utez.prueba_tomcat.Controllers.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mx.edu.utez.prueba_tomcat.Models.Dao.DaoPlayer;
import mx.edu.utez.prueba_tomcat.Models.Objetos.Player;

import java.io.IOException;

@WebServlet(name = "ServletCredential", urlPatterns = {
        "/representatives/obtener",
        "/representatives/ver"
})
public class ServletCredential extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private String action;
    private String redirect;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        action = req.getServletPath();
        switch (action) {
            case "/representatives/obtener":
                redirect = "/views/Representatives/PlayerCredentialForm.jsp";
                break;
            case "/representatives/ver":
                try {
                    int Id_player = Integer.parseInt(req.getParameter("player"));
                    Player player = new DaoPlayer().findOne(Id_player);

                    if (player != null) {
                        req.setAttribute("player", player);
                        redirect = "/views/Representatives/PlayerCredential.jsp";
                    } else {
                        req.setAttribute("errorMessage", "Jugador no encontrado");
                        redirect = "../views/Representatives/PlayerCredentialForm.jsp";
                    }
                } catch (NumberFormatException e) {
                    req.setAttribute("errorMessage", "ID de jugador inválido");
                    redirect = "../views/Representatives/PlayerCredentialForm.jsp";
                }
                break;
        }
        req.getRequestDispatcher(redirect).forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");
        action = req.getServletPath();
        switch (action) {
            case "/representatives/obtener":
                redirect = "../views/Representatives/PlayerCredentialForm.jsp";
                break;
            case "/representatives/ver":
                try {
                    int id = Integer.parseInt(req.getParameter("player"));
                    Player player = new DaoPlayer().findOne(id);

                    if (player != null) {
                        req.setAttribute("player", player);
                        redirect = "../views/Representatives/PlayerCredential.jsp";
                    } else {
                        req.setAttribute("errorMessage", "Jugador no encontrado");
                        redirect = "../views/Representatives/PlayerCredentialForm.jsp";
                    }
                } catch (NumberFormatException e) {
                    req.setAttribute("errorMessage", "ID de jugador inválido");
                    redirect = "../views/Representatives/PlayerCredentialForm.jsp";
                }
                break;
        }

        req.getRequestDispatcher(redirect).forward(req, resp);
    }
}













