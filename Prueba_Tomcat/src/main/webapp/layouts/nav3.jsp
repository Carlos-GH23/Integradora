<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- Nav Admin -->
<html>
<html lang="en" xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="../CSS/style.css">
    <link rel="shortcut icon" href="../Imagenes/mxlogo.png" />
    <link rel="stylesheet" href="../CSS/styleIndex.css"/>

</head>
<nav class="navbar">
    <!-- LOGO -->
    <div class="logo"><img src="../Imagenes/mxlogo.png" width="100px" height="75px" alt="Aqui salia un chango (yo)"></div>

    <!-- NAVIGATION MENU -->
    <ul class="nav-links">
        <!-- NAVIGATION MENUS -->
        <div class="menu">
            <li><a href="page/Admin/index_admin.jsp">Inicio (Admin)</a></li>
            <li class="services">
                <a href="/">Servicios</a>

                <!-- DROPDOWN MENU -->
                <ul class="dropdown">
                    <li><a href="page/Admin/Representativos_admin.jsp">Representativos</a></li>
                    <li><a href="page/Admin/Equipo_admin.html">Equipos</a></li>
                    <li><a href="page/Admin/Ranking_admin.jsp">Ranking</a></li>
                    <li><a href="page/Admin/Horarios_admin.jsp">Horarios</a></li>
                </ul>
            </li>
            <li><a href="Inicio_sesion.html">Cerrar Sesion</a></li>
        </div>
    </ul>
</nav>
</html>
