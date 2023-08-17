package mx.edu.utez.prueba_tomcat.Controllers.Login;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import mx.edu.utez.prueba_tomcat.Models.Dao.DaoRepresentative;
import mx.edu.utez.prueba_tomcat.Models.Objetos.Representative;


import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@WebServlet(name = "ServletUser",
        urlPatterns = {"/page/inicio",
                "/page/Rep",
                "/page/sesion",
                "/page/logout",
                "/page/user/one",
                "/page/user/save",
                "/page/user/create",
                "/page/user/modify",
                "/page/user/update",
                "/page/user/enable-disabled"
        })
public class ServletLogin extends HttpServlet {
    String action, redirect = "/page/inicio";
    Representative representative;
    HttpSession session;
    String id, username, password, teamId;
    String name, lastname, lastname2, phoneNumber, role;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        action = req.getServletPath();
        switch (action) {
            case "/page/inicio":
                redirect = "/views/Jerry/Menu.jsp";
                break;
            case "/page/logout":
                session = req.getSession();
                session.invalidate();
                redirect = "/index.jsp";
                break;
            case "/page/sesion":
                redirect= "/views/Jerry/Inicio_sesion.jsp";
                    break;
            case "/page/Rep":
                redirect = "/views/Representatives/Index.jsp";
                break;
        }
        req.getRequestDispatcher(redirect)
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");
        action = req.getServletPath();
        switch (action) {
            case "/page/sesion":
                username = req.getParameter("username");
                password = req.getParameter("password");
                try {
                    representative = new DaoRepresentative().loadUserByUsernameAndPassword(username, password);
                    if (representative != null) {
                        session = req.getSession();
                        session.setAttribute("representative", representative);
                        System.out.println("ROL...."+representative.getName());
                        System.out.println("ROL...."+representative.getLastName2());
                        System.out.println("ROL...."+representative.getPhoneNumber());
                        System.out.println("ROL...."+representative.getRole());
                        if(representative.getRole() == "admin"){
                            redirect= "/page/Rep";
                        } else if (representative.getRole() == "rep") {
                            redirect= "/page/Rep";
                        } else {
                            redirect= "/page/Rep";
                        }
                    } else {
                        throw new Exception("Credentials mismatch");
                    }
                } catch (Exception e) {
                    redirect = "/page/sesion?result=false&message=" +
                            URLEncoder.encode("Usuario y/o contraseña incorrecta", StandardCharsets.UTF_8);
                }
                break;
        }
        resp.sendRedirect(req.getContextPath()
                + redirect);
    }
}

