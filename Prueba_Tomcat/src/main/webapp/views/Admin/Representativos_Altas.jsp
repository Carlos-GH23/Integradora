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


<!-- Formulario de alta de representativo -->
<div class="container">
  <h2>Alta de Representativo</h2>
  <form action="/guardar_representativo" method="POST">
    <div class="form-group">
      <label for="rep_name">Nombre *</label>
      <input type="text" class="form-control" id="rep_name" name="rep_name" required>
    </div>
    <div class="form-group">
      <label for="last_name">Apellido Paterno *</label>
      <input type="text" class="form-control" id="last_name" name="last_name" required>
    </div>
    <div class="form-group">
      <label for="last_name2">Apellido Materno</label>
      <input type="text" class="form-control" id="last_name2" name="last_name2">
    </div>
    <div class="form-group">
      <label for="num_phone">Número de Teléfono *</label>
      <input type="text" class="form-control" id="num_phone" name="num_phone" required>
    </div>
    <div class="form-group">
      <label for="rep_user">Usuario *</label>
      <input type="text" class="form-control" id="rep_user" name="rep_user" required>
    </div>
    <div class="form-group">
      <label for="rep_pass">Contraseña *</label>
      <input type="password" class="form-control" id="rep_pass" name="rep_pass" required>
    </div>
    <div class="form-group">
      <label for="fk_team">Equipo *</label>
      <input type="number" class="form-control" id="fk_team" name="fk_team" min="1" max="10" required>
    </div>
    <button type="submit" class="btn btn-primary">Guardar</button>
  </form>
</div>
<br>
<br>
</div>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/js/bootstrap.bundle.min.js"></script>
<jsp:include page="/layouts/footer.jsp"/>
</body>
</html>
