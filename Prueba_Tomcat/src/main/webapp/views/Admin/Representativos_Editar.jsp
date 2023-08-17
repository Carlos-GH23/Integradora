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

<!-- Formulario de edición de representativo -->
<div class="container">
  <h2>Edición de Representativo</h2>
  <form action="/actualizar_representativo" method="POST">
    <div class="form-group">
      <label for="rep_name">Nombre:</label>
      <input type="text" class="form-control" id="rep_name" name="rep_name" required>
    </div>
    <div class="form-group">
      <label for="last_name">Apellido Paterno:</label>
      <input type="text" class="form-control" id="last_name" name="last_name" required>
    </div>
    <div class="form-group">
      <label for="last_name2">Apellido Materno:</label>
      <input type="text" class="form-control" id="last_name2" name="last_name2">
    </div>
    <div class="form-group">
      <label for="num_phone">Número de Teléfono:</label>
      <input type="text" class="form-control" id="num_phone" name="num_phone" required>
    </div>
    <div class="form-group">
      <label for="rep_user">Usuario:</label>
      <input type="text" class="form-control" id="rep_user" name="rep_user" required>
    </div>
    <div class="form-group">
      <label for="rep_pass">Contraseña:</label>
      <input type="password" class="form-control" id="rep_pass" name="rep_pass" required>
    </div>
    <div class="form-group">
      <label for="fk_team">Equipo *</label>
      <input type="number" class="form-control" id="fk_team" name="fk_team" min="1" max="10" required>
    </div>
    <button type="submit" class="btn btn-primary">Guardar Cambios</button>
  </form>
</div>
<br>
<br>

<!--Aqui comienza el footer-->
<div class="footer-dark">
  <footer>
    <div class="container">
      <div class="row">
        <div class="col-sm-6 col-md-3 item">
          <h3>Servicios</h3>
          <ul>
            <li><a href="#">Diseño web</a></li>
            <li><a href="#">Desarrollo</a></li>
            <li><a href="#">Host</a></li>
          </ul>
        </div>
        <div class="col-sm-6 col-md-3 item">
          <h3>Acerca de</h3>
          <ul>
            <li><a href="Compai.jsp">Compañia</a></li>
            <li><a href="Equipoi.jsp">Equipo</a></li>
            <li><a href="Carrerai.jsp">Carrera</a></li>
          </ul>
        </div>
        <div class="col-md-6 item text">
          <h3>Los Padrinos Toys</h3>
          <p>
            En algún rincón de la bulliciosa ciudad, un grupo de amigos
            programadores se unieron para formar un equipo con un nombre
            peculiar: Los Padrinos Toys. Aunque puede parecer extraño, su nombre
            reflejaba la combinación perfecta de su pasión por la programación
            y su sentido del humor.
          </p>
        </div>
        <div class="col item social">
          <a href="https://www.facebook.com/UTEZ.Morelos/?locale=es_LA">
            <i class="icon ion-social-facebook"></i>
          </a>
          <a href="https://twitter.com/utez_morelos?ref_src=twsrc%5Egoogle%7Ctwcamp%5Eserp%7Ctwgr%5Eauthor">
            <i class="icon ion-social-twitter"></i>
          </a>
          <!--<a href="#"><i class="icon ion-social-snapchat"></i></a>-->
          <a href="https://www.instagram.com/utezmorelos/?hl=es">
            <i class="icon ion-social-instagram"></i>
          </a>
        </div>
      </div>
      <p class="copyright">Los Padrinos Toys © 2023</p>
    </div>
  </footer>
</div>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/js/bootstrap.bundle.min.js"></script>
<jsp:include page="/layouts/footer.jsp"/>
</body>
</html>
