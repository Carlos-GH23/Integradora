<html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.sql.*" %>
<%@ page import="mx.edu.utez.integradora_serif.Models.Objetos.Player" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<head><title>Jugador</title>
<jsp:include page="/layouts/header.jsp"/>
</head>
<body>
<jsp:include page="/layouts/nav2.jsp"/>
<%
    // Recibir el teamId enviado desde el formulario
    String teamId = request.getParameter("teamId");

// Establecer la conexión a la base de datos
    String url = "jdbc:mysql://localhost:3306/SIREF";
    String user = "tu_usuario";
    String password = "tu_contraseña";

    try {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection(url, user, password);
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM PLAYERS WHERE fk_team = " + teamId);

        // Crear una lista para almacenar los jugadores obtenidos de la consulta
        List<Player> playersList = new ArrayList<>();

        while (rs.next()) {
            int playerId = rs.getInt("Id_player");
            String playerName = rs.getString("Name_player");
            String playerSurname = rs.getString("Surname");
            String playerSurname2 = rs.getString("Surname2");
            String playerPosition = rs.getString("Player_position");
            String playerDorsal = rs.getString("Dorsal");
            int playerTeamId = rs.getInt("fk_team");

            // Crear un objeto Player y configurar sus atributos
            Player player = new Player(playerId, playerName, playerSurname, playerSurname2, playerPosition, playerDorsal, playerTeamId);

            // Agregar el jugador a la lista
            playersList.add(player);
        }

        rs.close();
        stmt.close();
        con.close();

        // Ahora que tenemos la lista de jugadores, vamos a generar las opciones para el menú desplegable "Seleccionar Jugador"
        for (Player player : playersList) {
%>
<option value="<%= player.getId() %>"><%= player.getName() %> <%= player.getSurname() %></option>
<%
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
%>
</div>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/js/bootstrap.bundle.min.js"></script>
<jsp:include page="/layouts/footer.jsp"/>
</body>
</html>