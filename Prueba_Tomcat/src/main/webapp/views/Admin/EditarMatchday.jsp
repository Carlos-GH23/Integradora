<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Editar Matchday</title>
    <jsp:include page="/layouts/header.jsp"/>
</head>
<body>
<jsp:include page="/layouts/nav3.jsp"/>
<h1>Editar Matchday</h1>
<form action="${pageContext.request.contextPath}/matchday/update" method="post">
    <input type="hidden" name="Id_matchday" value="${matchday.id}">

    <label for="Match_field">Campo:</label>
    <input type="text" name="Match_field" value="${matchday.match_field}">

    <label for="Starthour">Hora de Inicio:</label>
    <input type="time" name="Starthour" value="${matchday.starthour}">

    <label for="Endhour">Hora de Fin:</label>
    <input type="time" name="Endhour" value="${matchday.endhour}">

    <label for="Date_match">Fecha del Partido:</label>
    <input type="date" name="Date_match" value="${matchday.date_match}">

    <label for="Points">Puntos:</label>
    <input type="text" name="Points" value="${matchday.points}">

    <label for="Draws">Empate:</label>
    <input type="number" name="Draws" value="${matchday.draws}">

    <label for="Wins">Victoria:</label>
    <input type="number" name="Wins" value="${matchday.wins}">

    <label for="Loses">Derrota:</label>
    <input type="number" name="Loses" value="${matchday.loses}">

    <label for="Goal_difference">Diferencia de goles:</label>
    <input type="number" name="Goal_difference" value="${matchday.goal_difference}">

    <label for="Goals_scored">Goles anotados:</label>
    <input type="number" name="Goals_scored" value="${matchday.goals_scored}">

    <label for="Goals_against">Goles en contra:</label>
    <input type="number" name="Goals_against" value="${matchday.goals_against}">

    <label for="Clasification">Clasificacion:</label>
    <input type="number" name="Clasification" value="${matchday.clasification}">


    <button href="/matchday/matchdays" type="submit">Actualizar Matchday</button>

</form>
</body>
</html>
