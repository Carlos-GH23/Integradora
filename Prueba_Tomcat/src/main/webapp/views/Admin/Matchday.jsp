<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Matchday</title>
    <jsp:include page="/layouts/header.jsp"/>
</head>
<body>
<jsp:include page="/layouts/nav3.jsp"/>
<div class="container-fluid">
    <div class="row">
        <div class="col">
            <div class="card mt-5">
                <div class="card-header">Matchday</div>
                <div class="card-body">
                    <table class="table table-bordered">
                        <thead>
                        <tr>
                            <th>Nombre de la cancha</th>
                            <th>Hora de inicio</th>
                            <th>Hora final</th>
                            <th>Fecha</th>
                            <th>Puntos</th>
                            <th>Empate</th>
                            <th>Victoria</th>
                            <th>Derrotas</th>
                            <th>Diferencia de goles</th>
                            <th>Goles a favor</th>
                            <th>Goles en contra</th>
                            <th>Clasificacion</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:foreach var="matchday" items="${matchdays}">
                            <tr>
                                <td>${matchday.match_field}</td>
                                <td>${matchday.starthour}</td>
                                <td>${matchday.endhour}</td>
                                <td>${matchday.date_match}</td>
                                <td>${matchday.points}</td>
                                <td>${matchday.draws}</td>
                                <td>${matchday.wins}</td>
                                <td>${matchday.loses}</td>
                                <td>${matchday.goal_difference}</td>
                                <td>${matchday.goals_scored}</td>
                                <td>${matchday.goals_against}</td>
                                <td>${matchday.clasification}</td>
                                <td>
                                    <a href="/matchday/modify?Id_matchday=${matchday.id}" class="btn btn-outline-primary btn-sm">Editar</a>
                                    <a href="/matchday/deleteConfirmation?Id_matchday=${matchday.id}" id="id" method="post" class="btn btn-outline-danger btn-sm">Eliminar</a>
                                </td>
                            </tr>
                        </c:foreach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/js/bootstrap.bundle.min.js"></script>
<jsp:include page="/layouts/footer.jsp"/>
</body>
</html>

