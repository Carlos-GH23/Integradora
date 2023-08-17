package mx.edu.utez.prueba_tomcat.Controllers.RankingPlayer;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mx.edu.utez.prueba_tomcat.Models.Dao.DaoRanking;
import mx.edu.utez.prueba_tomcat.Models.Dao.DaoTeam;
import mx.edu.utez.prueba_tomcat.Models.Objetos.RankingPlayer;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

@WebServlet(name = "ServletRankingPlayers",
        urlPatterns = {"/ranking/rankings",
                "/ranking/create",
                "/ranking/save",
                "/ranking/modify",
                "/ranking/update",
                "/ranking/delete"
        })
public class ServletRankingPlayers extends HttpServlet {

    private String action;
    private String redirect = "/ranking/rankings";
    RankingPlayer ranking;
    private int id;
    private int redCard;
    private int yellowCard;
    private int goals;
    private int assistances;
    private int playerId;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        action = req.getServletPath();

        switch (action) {
            case "/ranking/rankings":
                List<RankingPlayer> rankings = new DaoRanking().findAll();
                req.setAttribute("rankings", rankings); // Cambio de "equipoList" a "equipos"
                req.getRequestDispatcher("/views/User/Ranking.jsp").forward(req, resp);
                break;
            case "/ranking/modify":
                int rankingId = Integer.parseInt(req.getParameter("Id_ranking"));
                RankingPlayer rankingToModify = new DaoRanking().findOne(rankingId);
                if (rankingToModify != null) {
                    req.setAttribute("ranking", rankingToModify);
                    req.getRequestDispatcher("/views/Admin/EditarRanking.jsp").forward(req, resp);
                } else {
                    resp.sendError(HttpServletResponse.SC_NOT_FOUND);
                }
                break;

            // Dentro del método doGet para el caso "/equipo/delete"
            /*case "/equipo/delete":
                int teamIdToDelete = Integer.parseInt(req.getParameter("Id_team"));
                System.out.println("Intentando eliminar equipo con ID: " + teamIdToDelete); // Agrega esta línea
                boolean deleteResult = new DaoTeam().delete(teamIdToDelete);
                if (deleteResult) {
                    System.out.println("Equipo eliminado exitosamente"); // Agrega esta línea
                    resp.sendRedirect(req.getContextPath() + "/equipo/equipos");
                } else {
                    System.out.println("Error al eliminar el equipo"); // Agrega esta línea
                    req.setAttribute("error", "Error al eliminar el equipo");
                    req.getRequestDispatcher("/views/User/Equipo.jsp").forward(req, resp);
                }
                break;*/
            case "/ranking/delete":
                int rankingIdToDelete = Integer.parseInt(req.getParameter("Id_ranking"));
                RankingPlayer rankingToDelete = new DaoRanking().findOne(rankingIdToDelete);
                if (rankingToDelete != null) {
                    req.setAttribute("ranking", rankingToDelete);
                    req.getRequestDispatcher("/Admin/EliminarRanking.jsp").forward(req, resp);
                } else {
                    resp.sendError(HttpServletResponse.SC_NOT_FOUND);
                }
                break;

            case "/ranking/create":
                resp.sendRedirect("/views/Admin/RegistroRanking.jsp");
                break;
            default:
                resp.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getServletPath();

        switch (action) {
            case "/ranking/save":
                int newRedcard = Integer.parseInt("redCard");
                int newYellowcard = Integer.parseInt(req.getParameter("yellowCard"));
                int newGoals = Integer.parseInt(req.getParameter("goals"));
                int newAssistances = Integer.parseInt(req.getParameter("assistances"));
                int newPlayerId = Integer.parseInt(req.getParameter("playerId"));

                RankingPlayer newRanking = new RankingPlayer(0, newRedcard, newYellowcard, newGoals, newAssistances, newPlayerId);
                boolean result = new DaoRanking().save(newRanking);
                if (result) {
                    resp.sendRedirect(req.getContextPath() + "/ranking/rankings");
                } else {
                    req.setAttribute("error", "Error al registrar el equipo");
                    req.getRequestDispatcher("/views/Admin/RegistroRanking.jsp").forward(req, resp);
                }
                break;
            case "/ranking/update":
                int rankingIdToUpdate = Integer.parseInt(req.getParameter("id"));
                int updatedRedcard = Integer.parseInt("redCard");
                int updatedYellowcard = Integer.parseInt(req.getParameter("yellowCard"));
                int updatedGoals = Integer.parseInt(req.getParameter("goals"));
                int updatedAssistances = Integer.parseInt(req.getParameter("assistances"));
                int updatedPlayerId = Integer.parseInt(req.getParameter("playerId"));

                RankingPlayer updatedRanking = new RankingPlayer(rankingIdToUpdate, updatedRedcard, updatedYellowcard, updatedGoals, updatedAssistances, updatedPlayerId);
                boolean updateResult = new DaoRanking().update(updatedRanking);
                if (updateResult) {
                    resp.sendRedirect(req.getContextPath() + "/ranking/rankings");
                } else {
                    req.setAttribute("error", "Error al actualizar el equipo");
                    req.getRequestDispatcher("/views/User/Ranking.jsp").forward(req, resp);
                }
                break;
            case "/equipo/deleteConfirmed":
                String idToDelete = req.getParameter("id");
                if (idToDelete != null && !idToDelete.isEmpty()) {
                    int teamIdToDelete = Integer.parseInt(idToDelete);
                    boolean deleteResult = new DaoTeam().delete(teamIdToDelete);
                    if (deleteResult) {
                        resp.sendRedirect(req.getContextPath() + "/equipo/equipos");
                    } else {
                        req.setAttribute("error", "Error al eliminar el equipo");
                        req.getRequestDispatcher("/views/User/Equipo.jsp").forward(req, resp);
                    }
                } else {
                    resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Parámetro 'id' ausente o inválido");
                }
                break;
            case "/equipo/delete":
                id = Integer.parseInt(req.getParameter("Id_team"));
                if ((new DaoTeam()).delete( Integer.parseInt(String.valueOf(id)))) {
                    redirect = "/equipo/equipos?result= true&message=" + URLEncoder.encode("Equipo eliminado de forma exitosa", StandardCharsets.UTF_8);
                } else {
                    redirect = "/equipo/equipos?result= false&message=" + URLEncoder.encode("Error al realizar la acción", StandardCharsets.UTF_8);
                }
                break;
            case "/equipo/deleteConfirmation":
                int teamIdToDeleteConfirmation = Integer.parseInt(req.getParameter("Id_team"));
                boolean deleteResultConfirmation = new DaoTeam().delete(teamIdToDeleteConfirmation);
                if (deleteResultConfirmation) {
                    resp.sendRedirect(req.getContextPath() + "/equipo/equipos");
                } else {
                    req.setAttribute("error", "Error al eliminar el equipo");
                    req.getRequestDispatcher("/views/User/Equipo.jsp").forward(req, resp);
                }
                break;


            /*case "/equipo/delete":
                String idToDelete = req.getParameter("id");
                if (idToDelete != null && !idToDelete.isEmpty()) {
                    int teamIdToDelete = Integer.parseInt(idToDelete);
                    boolean deleteResult = new DaoTeam().delete(teamIdToDelete);
                    if (deleteResult) {
                        resp.sendRedirect(req.getContextPath() + "/equipo/equipos");
                    } else {
                        req.setAttribute("error", "Error al eliminar el equipo");
                        req.getRequestDispatcher("/views/User/Equipo.jsp").forward(req, resp);
                    }
                } else {
                    resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Parámetro 'id' ausente o inválido");
                }
                break;*/

            default:
                resp.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }

}
