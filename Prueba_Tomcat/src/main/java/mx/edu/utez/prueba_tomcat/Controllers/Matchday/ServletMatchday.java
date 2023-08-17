package mx.edu.utez.prueba_tomcat.Controllers.Matchday;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mx.edu.utez.prueba_tomcat.Models.Objetos.Matchday;
import mx.edu.utez.prueba_tomcat.Models.User.DaoMatchday;
import mx.edu.utez.prueba_tomcat.Models.User.DaoMatchday;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.sql.Date;
import java.sql.Time;
import java.util.List;

@WebServlet(name = "ServletMatchday", urlPatterns = {
        "/matchday/matchdays",
        "/matchday/save",
        "/matchday/create",
        "/matchday/modify",
        "/matchday/update",
        "/matchday/delete",
})
public class ServletMatchday extends HttpServlet {

    private String action;
    private String redirect = "/matchday/matchdays";
    private Matchday matchday;
    private int id;
    private String match_field;
    private Time starthour;
    private Time endhour;
    private Date date_match;
    private String points;
    private int draws;
    private int wins;
    private int loses;
    private int goal_difference;
    private int goals_scored;
    private int goals_against;
    private int clasification;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        this.action = req.getServletPath();
        switch (this.action) {
            case "/matchday/create":
                req.getRequestDispatcher("/views/Admin/RegistroMatchday.jsp").forward(req, resp);
                break;
            case "/matchday/matchdays":
                List<Matchday> matchdays = (new DaoMatchday()).findAll();
                req.setAttribute("matchdays", matchdays); // Change to plural "matchdays"
                req.getRequestDispatcher("/views/User/Matchday.jsp").forward(req, resp);
                break;
            case "/matchday/modify":
                this.id = Integer.parseInt(req.getParameter("Id_matchday"));
                this.matchday = (new DaoMatchday()).findOne(this.id != 0 ? this.id : 0);
                if (this.matchday != null) {
                    req.setAttribute("matchday", matchday);
                    req.getRequestDispatcher("/views/Admin/EditarMatchday.jsp").forward(req, resp);
                } else {
                    // Manejo de error si no se encuentra el matchday...
                }
                break;
            default:
                System.out.println(this.action);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");
        this.action = req.getServletPath();
        switch (this.action) {
            case "/matchday/save":
                this.match_field = req.getParameter("match_field");
                String starthourStr = req.getParameter("starthour");
                String endhourStr = req.getParameter("endhour");

                try {
                    this.starthour = Time.valueOf(starthourStr + ":00");
                    this.endhour = Time.valueOf(endhourStr + ":00");
                } catch (IllegalArgumentException e) {
                    e.printStackTrace(); // Imprime la excepción para depuración
                    // Aquí puedes manejar el error, como mostrar un mensaje de error en la página
                    // Por ejemplo: req.setAttribute("error_message", "El formato de hora es incorrecto");
                    // Luego redirigir a la página de registro con el mensaje de error
                    req.getRequestDispatcher("/views/Admin/RegistroMatchday.jsp").forward(req, resp);
                    return; // Importante: termina la ejecución del método
                }


                this.date_match = Date.valueOf(req.getParameter("date_match"));
                this.points = req.getParameter("points");
                this.draws = Integer.parseInt(req.getParameter("draws"));
                this.wins = Integer.parseInt(req.getParameter("wins"));
                this.loses = Integer.parseInt(req.getParameter("loses"));
                this.goal_difference = Integer.parseInt(req.getParameter("goal_difference"));
                this.goals_scored = Integer.parseInt(req.getParameter("goals_scored"));
                this.goals_against = Integer.parseInt(req.getParameter("goals_against"));
                this.clasification = Integer.parseInt(req.getParameter("clasification"));

                this.matchday = new Matchday(0, this.match_field, this.starthour, this.endhour, this.date_match,
                        this.points, this.draws, this.wins, this.loses, this.goal_difference,
                        this.goals_scored, this.goals_against, this.clasification);

                boolean result = (new DaoMatchday()).save(this.matchday);

                if (result) {
                    this.redirect = "/matchday/matchdays?result=true&message=" +
                            URLEncoder.encode("Jornada registrada exitosamente", StandardCharsets.UTF_8);
                } else {
                    this.redirect = "/matchday/matchdays?result=false&message=" +
                            URLEncoder.encode("Error al registrar la jornada", StandardCharsets.UTF_8);
                }
                break;
            case "/matchday/update":
                this.id = Integer.parseInt(req.getParameter("Id_matchday"));
                this.match_field = req.getParameter("match_field");

                try {
                    this.starthour = Time.valueOf(req.getParameter("starthour") + ":00");
                    this.endhour = Time.valueOf(req.getParameter("endhour") + ":00");
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                    req.setAttribute("error_message", "El formato de hora es incorrecto");
                    req.getRequestDispatcher("/views/Admin/EditarMatchday.jsp").forward(req, resp);
                    return;
                }

                try {
                    this.date_match = Date.valueOf(req.getParameter("date_match"));
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                    req.setAttribute("error_message", "El formato de fecha es incorrecto");
                    req.getRequestDispatcher("/views/Admin/EditarMatchday.jsp").forward(req, resp);
                    return;
                }

                this.points = req.getParameter("points");
                this.draws = Integer.parseInt(req.getParameter("draws"));
                this.wins = Integer.parseInt(req.getParameter("wins"));
                this.loses = Integer.parseInt(req.getParameter("loses"));
                this.goal_difference = Integer.parseInt(req.getParameter("goal_difference"));
                this.goals_scored = Integer.parseInt(req.getParameter("goals_scored"));
                this.goals_against = Integer.parseInt(req.getParameter("goals_against"));
                this.clasification = Integer.parseInt(req.getParameter("clasification"));

                this.matchday = new Matchday(this.id, this.match_field, this.starthour, this.endhour, this.date_match,
                        this.points, this.draws, this.wins, this.loses, this.goal_difference,
                        this.goals_scored, this.goals_against, this.clasification);

                if ((new DaoMatchday()).update(this.matchday)) {
                    this.redirect = "/matchday/matchdays?result=true&message=" +
                            URLEncoder.encode("Jornada actualizada exitosamente", StandardCharsets.UTF_8);
                } else {
                    this.redirect = "/matchday/matchdays?result=false&message=" +
                            URLEncoder.encode("Error al actualizar la jornada", StandardCharsets.UTF_8);
                }
                break;


            // Agregar otros casos aquí según sea necesario
        }
        resp.sendRedirect(req.getContextPath() + this.redirect);
    }
}
