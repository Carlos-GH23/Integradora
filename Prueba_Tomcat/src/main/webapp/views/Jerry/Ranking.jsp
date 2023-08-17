<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Ranking Jugadores</title>
    <jsp:include page="/layouts/header.jsp"/>
</head>
<body>
<jsp:include page="/layouts/nav.jsp"/>
<div class="container-fluid">
    <div class="row">
        <div class="col">
            <div class="card mt-5">
                <div class="card-header">Ranking</div>
                <div class="card-body">
                    <table class="table table-bordered">
                        <thead>
                        <tr>
                            <th>Tarjeta Roja</th>
                            <th>Tarjeta Amarilla</th>
                            <th>Goles</th>
                            <th>Asistencias</th>
                            <th>Player id</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="ranking" items="${rankings}">
                            <tr>
                                <td>${ranking.redCard}</td>
                                <td>${ranking.yellowCard}</td>
                                <td>${ranking.goals}</td>
                                <td>${ranking.assistances}</td>
                                <td>${ranking.playerId}</td>
                                <td>
                                    <a href="/ranking/modify?Id_ranking=${ranking.id}" class="btn btn-outline-primary btn-sm">Editar</a>
                                    <a href="/ranking/deleteConfirmation?Id_team=${ranking.id}" id="id" method="post" class="btn btn-outline-danger btn-sm">Eliminar</a>

                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>

