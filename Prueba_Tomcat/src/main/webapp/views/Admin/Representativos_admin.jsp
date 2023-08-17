<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en" xmlns="http://www.w3.org/1999/xhtml">
<head>
  <meta charset="utf-8">
  <link rel="stylesheet" href="../../../Integradora_SERIF/src/main/webapp/CSS/style.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/css/bootstrap.min.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
  <link rel="shortcut icon" href="../Imagenes/mxlogo.png" />
  <link rel="stylesheet" href="../../../Integradora_SERIF/src/main/webapp/CSS/styleIndex.css"/>
  <title>Inicio</title>
  <jsp:include page="/layouts/header.jsp"/>
</head>
<body>
<jsp:include page="/layouts/nav3.jsp"/>

<table class="estilotabla">
  <thead>
  <tr>
    <th>ID</th>
    <th>Nombre del Representante</th>
    <th>Nombre del Equipo</th>
    <th>Teléfono</th>
    <th>Estado de Pago de Arbitraje</th>
    <th>Estado de Registro de Liga</th>
    <th>Acciones</th>
  </tr>
  </thead>
  <tbody>
  <tr>
    <td>1</td>
    <td>Juan Pérez</td>
    <td>Los Tigres</td>
    <td>555-1234</td>
    <td>Saldado</td>
    <td>Pendiente</td>
    <td><button onclick="editarRepresentativo(1)">Editar</button></td>
  </tr>
  <!-- Agregar más registros aquí -->
  </tbody>
</table>
<br>
<br>
<div style="text-align: center;">
  <button href="../html/admin/Representativos_Altas.html" onclick="agregarRepresentativo()">Dar de alta Representativo</button>
  <button href="../html/admin/Representativos_Bajas.html" onclick="darDeBaja()">Dar de baja</button>
</div>
<h1 class="estilo5">ESTADISTICAS GENERALES</h1>
<p class="estilo6">
  &nbsp; &nbsp;Para Mantenerte Al <br />
  Tanto De Nuestra Liga!
</p>


</div>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/js/bootstrap.bundle.min.js"></script>
<script>
  function agregarRepresentativo() {
    // Aquí puedes agregar la lógica para dar de alta un representativo
    console.log("Dar de alta Representativo");
  }

  function darDeBaja() {
    // Aquí puedes agregar la lógica para dar de baja un representativo
    console.log("Dar de baja Representativo");
  }

  function editarRepresentativo(id) {
    // Aquí puedes agregar la lógica para editar un representativo con el id proporcionado
    console.log("Editar Representativo con ID:", id);
  }
</script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/js/bootstrap.bundle.min.js"></script>
<jsp:include page="/layouts/footer.jsp"/>
</body>
</html>
