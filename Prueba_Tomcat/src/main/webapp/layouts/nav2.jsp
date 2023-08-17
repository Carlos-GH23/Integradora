<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!-- Nav Representativo -->
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="../CSS/style.css">
<link rel="shortcut icon" href="../Imagenes/mxlogo.png" />
<link rel="stylesheet" href="../CSS/styleIndex.css"/>
<title>Representante</title>
</head>
<nav class="navbar">
    <!-- LOGO -->
    <div class="logo"><img src="../Imagenes/mxlogo.png" width="100px" height="75px" alt="Aqui salia un chango (yo)"></div>

    <!-- NAVIGATION MENU -->
    <ul class="nav-links">

        <!-- NAVIGATION MENUS -->
        <div class="menu">

            <li><a href="jerry/index.jsp">Inicio(Representativo)</a></li>
            <li><a href="page/user/Horarios.jsp">Horarios</a></li>

            <li class="services">
                <a href="/">Servicios</a>

                <!-- DROPDOWN MENU -->
                <ul class="dropdown">

                    <li><a href="/jugador/jugadores">Jugadores</a></li>
                    <li><a href="/representatives/ver">Credenciales</a></li>
                    <li><a href="/equipo/equipos">Equipos</a></li>

                </ul>
            </li>

            <li><a href="Ranking.jsp">Ranking</a></li>
            <li><a href="/page/logout">Cerrar sesión</a></li>
        </div>
    </ul>
</nav>
