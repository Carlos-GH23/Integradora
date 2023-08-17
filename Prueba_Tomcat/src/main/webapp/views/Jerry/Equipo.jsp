<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Equipos</title>
    <jsp:include page="/layouts/header.jsp"/>
</head>
<body>
<jsp:include page="/layouts/nav.jsp"/>
<div class="container-fluid">
    <div class="row">
        <div class="col">
            <div class="card mt-5">
                <div class="card-header">Equipos</div>
                <div class="card-body">
                    <table class="table table-bordered">
                        <thead>
                        <tr>
                            <th>Nombre</th>
                            <th>Miembros</th>
                            <th>Id del Partido</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="equipo" items="${equipos}">
                            <tr>
                                <td>${equipo.name}</td>
                                <td>${equipo.members}</td>
                                <td>${equipo.matchdayId}</td>
                                <td>
                                    <a href="/equipo/modify?Id_team=${equipo.id}" class="btn btn-outline-primary btn-sm">Editar</a>
                                    <a href="/equipo/deleteConfirmation?Id_team=${equipo.id}" id="id" method="post" class="btn btn-outline-danger btn-sm">Eliminar</a>

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
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/js/bootstrap.bundle.min.js"></script>
<jsp:include page="/layouts/footer.jsp"/>
</body>
</html>

