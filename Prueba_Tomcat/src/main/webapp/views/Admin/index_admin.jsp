<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" xmlns="http://www.w3.org/1999/xhtml">
<head>
  <meta charset="utf-8">
  <link rel="stylesheet" href="../CSS/style.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/css/bootstrap.min.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
  <link rel="shortcut icon" href="../Imagenes/mxlogo.png" />
  <link rel="stylesheet" href="../CSS/styleIndex.css"/>
  <title>Inicio</title>
  <jsp:include page="/layouts/header.jsp"/>
</head>
<body>
<jsp:include page="/layouts/nav3.jsp"/>

<div class="estilofondo">
  <p class="estilo1">Bienvenido, Admin!</p>

  <h1 class="estilo2">Panel de Control</h1>

  <p class="estilo3">
    ¡Bienvenido al Panel de Control de la Liga de Fútbol de Temixco!
    <br />
    Desde aquí podrás gestionar todos los aspectos importantes de la liga.
    <br />
    Controla los equipos, los horarios, las estadísticas y más, para asegurar
    <br />
    que los partidos se lleven a cabo sin problemas y los aficionados disfruten
    <br />
    de emocionantes encuentros futbolísticos. ¡Que empiece la competición!
  </p>
  <a href="Horarios.html"><button>Resumen de la liga</button></a>
  <!-- Aquí puedes agregar más contenido para el panel de administrador según tus necesidades -->
</div>
<jsp:include page="../../layouts/footer.jsp"/>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/js/bootstrap.bundle.min.js"></script>
</body>
</html>
