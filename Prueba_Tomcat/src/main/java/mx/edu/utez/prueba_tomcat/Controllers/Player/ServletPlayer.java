package mx.edu.utez.prueba_tomcat.Controllers.Player;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import mx.edu.utez.prueba_tomcat.Models.Dao.DaoPlayer;
import mx.edu.utez.prueba_tomcat.Models.Objetos.Player;

import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.List;

@WebServlet(name = "ServeletPlayer", urlPatterns = {
        "/jugador/jugadores",
        "/jugador/jugador",
        "/jugador/save",
        "/jugador/create",
        "/jugador/modify",
        "/jugador/delete"
})
@MultipartConfig
public class ServletPlayer extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private String action;
    private String redirect;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        action = req.getServletPath();
        switch (action) {
            case "/jugador/jugadores":
                List<Player> jugadores = (new DaoPlayer()).findAll();
                req.setAttribute("jugadores", jugadores);
                redirect = "/views/Representatives/Jugadores.jsp";
                break;
            case "/jugador/jugador":
                redirect = "/views/Representatives/PlayerCredentialForm.jsp";
            break;
            case "/jugador/create":
                redirect = "/views/Representatives/CrearJugador.jsp";
                break;
            case "/jugador/modify":
                int id = Integer.parseInt(req.getParameter("player"));
                System.out.println(id);
                Player player = new DaoPlayer().findOne(id);
                req.setAttribute("player", player);
                redirect= "/views/Representatives/Playerupd.jsp";
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
            case "/jugador/modify":
                int id = Integer.parseInt(req.getParameter("id"));
                String name = req.getParameter("name");
                String surname = req.getParameter("Surname");
                String surname2 = req.getParameter("Surname2");
                String position = req.getParameter("Position");
                String dorsal = req.getParameter("Dorsal");
                int teamId = Integer.parseInt(req.getParameter("TeamId"));
                Player player = new Player();
                player.setId(id);
                player.setName(name);
                player.setSurname(surname);
                player.setSurname2(surname2);
                player.setPosition(position);
                player.setDorsal(dorsal);
                player.setTeamId(teamId);
                System.out.println(player.toString());
                boolean isSuccess = new DaoPlayer().update(player);
                System.out.println(isSuccess);
                if (isSuccess) {
                    req.setAttribute("successMessage", "Jugador actualizado con éxito");
                    resp.sendRedirect("/jugador/jugadores?message=" + URLEncoder.encode("jugador actualizado correctamente", StandardCharsets.UTF_8));
                } else {
                    req.setAttribute("errorMessage", "Jugador no encontrado para actualizar");
                    resp.sendRedirect("/jugador/modify?player=" + id + "&message="+URLEncoder.encode("Error  al realizar la acción", StandardCharsets.UTF_8));

                }
                return;
            case "/jugador/save":
                Part filePart = req.getPart("playerImage");
                String base64Image = convertToBase64(filePart);


                Player newPlayer = new Player();
                newPlayer.setFile(base64Image);
                newPlayer.setName(req.getParameter("name"));
                newPlayer.setSurname(req.getParameter("Surname"));
                newPlayer.setSurname2(req.getParameter("Surname2"));
                newPlayer.setPosition(req.getParameter("Position"));
                newPlayer.setPosition(req.getParameter("Position"));
                newPlayer.setDorsal(req.getParameter("Dorsal"));
                newPlayer.setTeamId(Integer.parseInt(req.getParameter("TeamId")));
                new DaoPlayer().save(newPlayer);
                req.setAttribute("successMessage", "Jugador creado con éxito");
                redirect = "/jugador/jugadores";
                break;

            case "/jugador/delete":
                int deleteId = Integer.parseInt(req.getParameter("player"));
                boolean isDeleted = new DaoPlayer().delete(deleteId);
                System.out.println(isDeleted);
                if (isDeleted) {
                    req.setAttribute("successMessage", "Jugador eliminado con éxito");
                    redirect = "../views/Representatives/PlayerList.jsp";
                    resp.sendRedirect("/jugador/jugadores?message=" + URLEncoder.encode("jugador actualizado correctamente", StandardCharsets.UTF_8));

                } else {
                    req.setAttribute("errorMessage", "Error al eliminar el jugador");
                    redirect = "../views/Representatives/PlayerList.jsp";
                    resp.sendRedirect("/jugador/jugadores?message=" + URLEncoder.encode("Error al ejecutar la acción", StandardCharsets.UTF_8));

                }
                break;


        }
        req.getRequestDispatcher(redirect).forward(req, resp);
    }
    private String convertToBase64(Part filePart) throws IOException {
        InputStream inputStream = filePart.getInputStream();
        byte[] bytes = new byte[(int) filePart.getSize()];
        inputStream.read(bytes, 0, bytes.length);
        inputStream.close();
        return Base64.getEncoder().encodeToString(bytes);
    }
}
