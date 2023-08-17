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
  <title>Horarios</title>

  <style>
    /* Estilos para los rectángulos (tarjetas) */
    .rectangulop {
      width: 200px;
      height: 290px;
      background-color: #f2f2f2;
      margin: 10px;
      padding: 10px;
      border-radius: 5px;
      box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
      text-align: center;
      display: inline-block;
      vertical-align: top;
      position: relative; /* Agregamos position relative */
    }

    /* Estilos para los botones dentro de los rectángulos */
    .rectangulop button {
      position: absolute; /* Cambiamos a position absolute */
      bottom: 10px; /* Ajustamos la posición inferior */
      left: 50%; /* Movemos el botón al centro horizontal */
      transform: translateX(-50%); /* Centramos el botón horizontalmente */
      margin-top: 10px;
    }

    /* Estilos para el separador de fecha */
    .separadorp {
      text-align: center;
      border-bottom: 2px solid #ccc;
      margin-bottom: 20px;
      padding-bottom: 10px;
    }

    /* Estilos para el botón "Agregar Partido" */
    .boton-agregar {
      margin: 10px;
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

<!-- Separador de fecha -->
<div class="separadorp">
  <h3>Fecha: 2023-07-24</h3>
  <!-- Aquí puedes agregar el botón "Agregar Partido" para añadir un nuevo partido -->
  <a href="#"><button class="boton-agregar">Agregar Partido</button></a>
</div>

<!-- Rectángulos (tarjetas) de los partidos para la fecha 2023-07-24 -->
<div class="rectangulop">
  <h4>Equipo A vs. Equipo B</h4>
  <img src="ruta_logo_equipo_a.png" alt="Logo Equipo A">
  <h3>VS</h3>
  <img src="ruta_logo_equipo_b.png" alt="Logo Equipo B">
  <p>Hora: 15:00</p>
  <p>Campo: Estadio XYZ</p>
  <button>Editar</button>
</div>

<div class="rectangulop">
  <h4>Equipo C vs. Equipo D</h4>
  <img src="ruta_logo_equipo_c.png" alt="Logo Equipo C">
  <h3>VS</h3>
  <img src="ruta_logo_equipo_d.png" alt="Logo Equipo D">
  <p>Hora: 17:30</p>
  <p>Campo: Estadio ABC</p>
  <button>Editar</button>
</div>

<!-- Separador de fecha -->
<div class="separadorp">
  <h3>Fecha: 2023-07-25</h3>
  <!-- Aquí puedes agregar el botón "Agregar Partido" para añadir un nuevo partido -->
  <a href="#"><button class="boton-agregar">Agregar Partido</button></a>
</div>

<!-- Rectángulos (tarjetas) de los partidos para la fecha 2023-07-25 -->
<div class="rectangulop">
  <h4>Equipo E vs. Equipo F</h4>
  <img src="ruta_logo_equipo_e.png" alt="Logo Equipo E">
  <h3>VS</h3>
  <img src="ruta_logo_equipo_f.png" alt="Logo Equipo F">
  <p>Hora: 19:00</p>
  <p>Campo: Estadio LMN</p>
  <button>Editar</button>
</div>

<div class="rectangulop">
  <h4>America vs. Chivas</h4>
  <img src="../../../Integradora_SERIF/src/main/webapp/Imagenes/America.jpg" alt="Logo Equipo G" width="35px" height="35px">
  <h3>VS</h3>
  <img src="../../../Integradora_SERIF/src/main/webapp/Imagenes/chibas.jpg" alt="Logo Equipo H" width="35px" height="35px">
  <p>Hora: 20:30</p>
  <p>Campo: Estadio XYZ</p>
  <button>Editar</button>
</div>

<!-- Separador de fecha -->
<div class="separadorp">
  <h3>Fecha: 2023-07-29</h3>
</div>