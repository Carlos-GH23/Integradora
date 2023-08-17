<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en" xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>Inicio</title>
    <jsp:include page="/layouts/header.jsp"/>
</head>
<body>
<jsp:include page="/layouts/nav.jsp"/>
<nav class="navbar">
    <!-- LOGO -->
    <div class="logo"><img src="mxlogo.png" width="100px" height="75px" alt="Aqui salia un chango (yo)"/></div>

    <!-- NAVIGATION MENU -->
    <ul class="nav-links">

        <!-- NAVIGATION MENUS -->
        <div class="menu">
            <li><a href="inicio.jsp">Inicio</a></li>
            <li><a href="Horarios.jsp">Horarios</a></li>

            <li class="services">
                <a href="/">Servicios</a>

                <!-- DROPDOWN MENU -->
                <ul class="dropdown">
                    <li><a href="Noticias.jsp">Noticias</a></li>
                    <li><a href="Jugadores.jsp">Jugadores</a></li>
                    <li><a href="Credenciales.jsp">Credenciales</a></li>
                    <li><a href="Equipo.jsp">Equipos</a></li>
                    <li><a href="Memes.jsp">Memes</a></li>
                </ul>
            </li>

            <li><a href="paggoles.jsp">Ranking</a></li>
            <li><a href="Inicio_sesion.jsp">Iniciar Sesion</a></li>
        </div>
    </ul>
</nav>
<!--Hasta aqui termina navbar-->

<!--Codigo dentro de la pagina principal-->
<table>
    <tr>
        <th>Posición</th>
        <th>Jugador</th>
        <th>Goles</th>
    </tr>
    <tr>
        <td>1</td>
        <td class="player-details">
            <img src="Imagenes/vega.jpg" alt="Foto Jugador 1" class="player-photo">
            <div>
                <p>Alexis Vega</p>
                <img src="Imagenes/guadalajara.png" alt="Logo Equipo 1" width="30" height="30">
                <p>Guadalajara</p>
            </div>
        </td>
        <td>10</td>
    </tr>
    <tr>
        <td>2</td>
        <td class="player-details">
            <img src="Imagenes/macias.jpg" alt="Foto Jugador 2" class="player-photo">
            <div>
                <p>José Juan Macias</p>
                <img src="Imagenes/guadalajara.png" alt="Logo Equipo 2" width="30" height="30">
                <p>Guadalajara</p>
            </div>
        </td>
        <td>8</td>
    </tr>
    <tr>
        <td>3</td>
        <td class="player-details">
            <img src="Imagenes/briseño.jpg" alt="Foto Jugador 3" class="player-photo">
            <div>
                <p>Antonio Briseño</p>
                <img src="Imagenes/guadalajara.png" alt="Logo Equipo 3" width="30" height="30">
                <p>Guadalajara</p>
            </div>
        </td>
        <td>6</td>
    </tr>
</table>


<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/js/bootstrap.bundle.min.js"></script>
<jsp:include page="/layouts/footer.jsp"/>
</body>
</html>
