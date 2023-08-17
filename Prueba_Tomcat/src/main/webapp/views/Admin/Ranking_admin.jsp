<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" xmlns="http://www.w3.org/1999/xhtml">
<head>
  <meta charset="utf-8">
  <link rel="stylesheet" href="../../../Integradora_SERIF/src/main/webapp/CSS/style.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/css/bootstrap.min.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
  <link rel="shortcut icon" href="../Imagenes/mxlogo.png" />
  <link rel="stylesheet" href="../../../Integradora_SERIF/src/main/webapp/CSS/styleIndex.css"/>
  <title>Inicio</title>
  <style>
    /* Estilos para los rectángulos (tarjetas) */
    .rectangulo {
      width: 200px;
      height: 150px;
      background-color: #f2f2f2;
      margin: 10px;
      padding: 10px;
      border-radius: 5px;
      box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
      text-align: center;
      display: inline-block;
      vertical-align: top;
    }

    /* Estilos para los botones dentro de los rectángulos */
    .rectangulo button {
      margin-top: 10px; /* Agregar margen superior */
      display: block; /* Para centrar los botones */
      margin: 0 auto; /* Para centrar los botones */
    }
  </style>
  <jsp:include page="/layouts/header.jsp"/>
</head>
<body>
<jsp:include page="/layouts/nav3.jsp"/>
<nav class="navbar">
  <!-- LOGO -->
  <div class="logo"><img src="../../../Integradora_SERIF/src/main/webapp/Imagenes/mxlogo.png" width="100px" height="75px" alt="Aqui salia un chango (yo)"></div>

  <!-- NAVIGATION MENU -->
  <ul class="nav-links">
    <!-- NAVIGATION MENUS -->
    <div class="menu">
      <li><a href="index_admin.jsp">Inicio (Admin)</a></li>
      <li class="services">
        <a href="/">Servicios</a>

        <!-- DROPDOWN MENU -->
        <ul class="dropdown">
          <li><a href="Representativos_admin.jsp">Representativos</a></li>
          <li><a href="Equipo_admin.html">Equipos</a></li>
          <li><a href="Ranking_admin.jsp">Ranking</a></li>
          <li><a href="Horarios_admin.jsp">Horarios</a></li>
        </ul>
      </li>
      <li><a href="Inicio_sesion.html">Cerrar Sesion</a></li>
    </div>
  </ul>
</nav>

<!-- Rectángulos (tarjetas) de los equipos -->
<div class="rectangulo">
  <h4>Los Tigres</h4>
  <p>Número de Jugadores: 22</p>
  <button>Administrar</button>
</div>

<div class="rectangulo">
  <h4>Los Leones</h4>
  <p>Número de Jugadores: 18</p>
  <button>Administrar</button>
</div>

<div class="rectangulo">
  <h4>Los Halcones</h4>
  <p>Número de Jugadores: 20</p>
  <button>Administrar</button>
</div>

<!-- Agregar más rectángulos aquí para los demás equipos -->
<!-- ... -->

<h1 class="estilo5">ESTADISTICAS GENERALES</h1>
<p class="estilo6">
  &nbsp; &nbsp;Para Mantenerte Al <br />
  Tanto De Nuestra Liga!
</p>

<!--Aqui comienza el footer-->
<!-- ... -->

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/js/bootstrap.bundle.min.js"></script>
<jsp:include page="/layouts/footer.jsp"/>
</body>
</html>
