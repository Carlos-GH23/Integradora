<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Editar Equipo</title>
  <jsp:include page="/layouts/header.jsp"/>
</head>
<body>
<jsp:include page="/layouts/nav2.jsp"/>
<div class="container">
  <h2>Editar Equipo</h2>
  <form action="/equipo/update" method="post">
    <input type="hidden" name="id" value="${equipo.id}"> <!-- Campo oculto con el ID del equipo -->
    <div class="form-group">
      <label for="name">Nombre del equipo:</label>
      <input type="text" name="name" id="name" class="form-control" value="${equipo.name}" required>
    </div>
    <div class="form-group">
      <label for="members">Número de miembros:</label>
      <input type="number" name="members" id="members" class="form-control" value="${equipo.members}" required>
    </div>
    <div class="form-group">
      <label for="matchdayId">ID del partido:</label>
      <input type="number" name="matchdayId" id="matchdayId" class="form-control" value="${equipo.matchdayId}" required>
    </div>
    <button type="submit" class="btn btn-primary">Guardar Cambios</button>
    <a href="/equipo/equipos" class="btn btn-secondary">Cancelar</a>
  </form>
</div>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/js/bootstrap.bundle.min.js"></script>
<jsp:include page="/layouts/footer.jsp"/>
</body>
</html>
