<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Editar Ranking</title>
    <jsp:include page="/layouts/header.jsp"/>
</head>
<body>
<jsp:include page="/layouts/nav3.jsp"/>
<div class="container">
    <h2>Editar Ranking</h2>
    <form action="/ranking/update" method="post">
        <input type="hidden" name="id" value="${ranking.id}"> <!-- Campo oculto con el ID del equipo -->
        <div class="form-group">
            <label for="redCard">Tarjeta roja:</label>
            <input type="number" name="redCard" id="redCard" class="form-control" value="${ranking.redCard}" required>
        </div>
        <div class="form-group">
            <label for="yellowCard">Tarjeta Amarilla:</label>
            <input type="number" name="yellowCard" id="yellowCard" class="form-control" value="${ranking.yellowCard}" required>
        </div>
        <div class="form-group">
            <label for="goals">Goles:</label>
            <input type="number" name="goals" id="goals" class="form-control" value="${ranking.goals}" required>
        </div>
        <div class="form-group">
            <label for="assistances">Asistencias:</label>
            <input type="number" name="assistances" id="assistances" class="form-control" value="${ranking.assistances}" required>
        </div>
        <div class="form-group">
            <label for="playerId">Id del jugador:</label>
            <input type="number" name="playerId" id="playerId" class="form-control" value="${ranking.playerId}" required>
        </div>
        <button type="submit" class="btn btn-primary">Guardar Cambios</button>
        <a href="/ranking/rankings" class="btn btn-secondary">Cancelar</a>
    </form>
</div>
</body>
</html>
