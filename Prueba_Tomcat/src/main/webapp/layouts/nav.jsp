<!-- Nav usuario -->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <meta charset="utf-8">
    <link rel="stylesheet" href="..//CSS/style.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
    <link rel="shortcut icon" href="../Imagenes/mxlogo.png" />
    <link rel="stylesheet" href="..//CSS/styleIndex.css"/>

</head>

<nav class="navbar">
    <!-- LOGO -->
    <div class="logo"><img src="../Imagenes/mxlogo.png" width="100px" height="75px" alt="Aqui salia un chango (yo)"></img></div>

    <!-- NAVIGATION MENU -->
    <ul class="nav-links">

        <!-- NAVIGATION MENUS -->
        <div class="menu">

            <li><a href="index.html">Inicio</a></li>
            <li><a href="Horarios.html">Horarios</a></li>

            <li class="services">
                <a href="/">Servicios</a>

                <!-- DROPDOWN MENU -->
                <ul class="dropdown">
                    <li><a href="Jugadores.html">Jugadores</a></li>
                    <li><a href="/representatives/obtener">Credenciales</a></li>
                    <li><a href="Equipo.html">Equipos</a></li>
                </ul>
            </li>

            <li><a href="paggoles.html">Ranking</a></li>
            <li><a href="/page/sesion">Iniciar Sesion</a></li>
        </div>
    </ul>
</nav>
</html>
