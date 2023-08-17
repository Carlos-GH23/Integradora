package mx.edu.utez.prueba_tomcat.Controllers.Team;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mx.edu.utez.prueba_tomcat.Models.Dao.DaoTeam;
import mx.edu.utez.prueba_tomcat.Models.Objetos.Team;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

@WebServlet(name = "ServletTeam",
        urlPatterns = {"/equipo/equipos",
                "/equipo/equipo",
                "/equipo/save",
                "/equipo/create",
                "/equipo/modify",
                "/equipo/update",
                "/equipo/delete",

        })
public class ServletTeam extends HttpServlet{
    private String action;
    private String redirect = "/equipo/equipos";
    Team team;
    private int id;
    private String name;
    private int members;
    private int matchdayId;


    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        action = req.getServletPath();
        switch (action) {
            case "/equipo/equipos":
                List<Team> equipos = (new DaoTeam()).findAll();
                req.setAttribute("teams", equipos);
                redirect = "/views/Jerry/Teams.jsp";
                break;
            case "/equipo/equipo":
                redirect = "/views/Representatives/Equipo.jsp";
                break;
            case "/equipo/create":
                redirect = "/views/Representatives/RegistroEquipo.jsp";
                break;
            case "/equipo/update":
                id = Integer.parseInt(req.getParameter("Id_team"));
                team = (new DaoTeam()).findOne(this.id);
                if (team != null) {
                    req.setAttribute("team", team);
                    req.getRequestDispatcher("/views/Representatives/update.jsp").forward(req, resp);
                } else {
                    resp.sendRedirect("/equipo/equipos?result=false&message=" + URLEncoder.encode("Error al cargar datos de equipo para edición", StandardCharsets.UTF_8));
                }
                break;
            case "/equipo/modify":
                redirect = "views/Representatives/RepEquipos.jps";
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
            case "/equipo/delete":
                id = Integer.parseInt(req.getParameter("Id_team"));
                if ((new DaoTeam()).delete( Integer.parseInt(String.valueOf(id)))) {
                    redirect = "/equipo/equipos?result= true&message=" + URLEncoder.encode("Equipo eliminado de forma exitosa", StandardCharsets.UTF_8);
                } else {
                    redirect = "/equipo/equipos?result= false&message=" + URLEncoder.encode("Error al realizar la acción", StandardCharsets.UTF_8);
                }
                break;
            case "/equipo/save":
                this.id = Integer.parseInt(req.getParameter("Id_team"));
                this.name = req.getParameter("Name_team");
                this.members = Integer.parseInt(req.getParameter("Members"));
                this.matchdayId = Integer.parseInt(req.getParameter("fk_matchday"));
                 team = new Team(0 , this.name, this.members, this.matchdayId);
                boolean result = (new DaoTeam()).save(team);
                if (result) {
                    redirect = "/equipo/equipos?result=true&message=" + URLEncoder.encode("Equipo registrado de forma exitosa", StandardCharsets.UTF_8);
                } else {
                    redirect = "/equipo/equipos?result= false&message=" + URLEncoder.encode("Error al realizar la acción", StandardCharsets.UTF_8);
                }
                break;
            case "/equipo/update":
                id = Integer.parseInt(req.getParameter("Id_team"));
                team = new Team();
                team.setId(id);
                team.setName(req.getParameter("Name_team"));
                team.setMembers(Integer.parseInt(req.getParameter("Members")));
                team.setMatchdayId(Integer.parseInt(req.getParameter("fk_matchday")));

                if ((new DaoTeam()).update(team)) {
                    resp.sendRedirect("/equipo/equipos?result=true&message=" + URLEncoder.encode("Equipo actualizado correctamente", StandardCharsets.UTF_8));
                } else {
                    resp.sendRedirect("/equipo/equipos?result=false&message=" + URLEncoder.encode("Error al realizar la acción", StandardCharsets.UTF_8));
                }
                break;

        }

        String var10001 = req.getContextPath();
        resp.sendRedirect(var10001 + this.redirect);
    }
}


