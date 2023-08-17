<!DOCTYPE html>
<html>
<head>
    <title>Lista de Jugadores</title>
    <jsp:include page="/layouts/header.jsp"/>
</head>
<body>
<jsp:include page="/layouts/nav3.jsp"/>
<h1>Lista de Jugadores</h1>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Red Card</th>
        <th>Yellow Card</th>
        <th>Goals</th>
        <th>Assistances</th>
        <th>Player ID</th>
    </tr>
    <c:forEach var="player" items="${players}">
        <tr>
            <td>${player.id}</td>
            <td>${player.redCard}</td>
            <td>${player.yellowCard}</td>
            <td>${player.goals}</td>
            <td>${player.assistances}</td>
            <td>${player.playerId}</td>
        </tr>
    </c:forEach>
</table>
<a href="/ranking/players">Registrar Jugador</a>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/js/bootstrap.bundle.min.js"></script>
<jsp:include page="/layouts/footer.jsp"/>
</body>
</html>
