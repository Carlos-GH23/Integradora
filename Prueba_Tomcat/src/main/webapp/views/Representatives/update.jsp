<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Modificación de Equipo</title>
    <jsp:include page="/layouts/header.jsp"/>
</head>
<body>
<jsp:include page="/layouts/nav2.jsp"/>
<div class="container-fluid">
    <div class="row">
        <div class="col">
            <div class="card mt-5">
                <div class="card-header">Actualización de Equipo</div>
                <div class="card-body">
                    <form id="team-form" class="needs-validation" novalidate
                          action="/equipo/update" method="post">
                        <input hidden value="${team.id}" name="Id_team">
                        <div class="form-group mb-3">
                            <div class="row">
                                <div class="col">
                                    <label for="name" class="fw-bold">Nombre:</label>
                                    <input type="text" name="Name_team" id="name" class="form-control"
                                           placeholder="Nombre del equipo" value="${team.name}" required/>
                                    <div class="invalid-feedback">Campo obligatorio</div>
                                </div>
                                <div class="col">
                                    <label for="members" class="fw-bold">Miembros:</label>
                                    <input type="text" name="Members" id="members" class="form-control"
                                           placeholder="Número de miembros" value="${team.members}" required/>
                                    <div class="invalid-feedback">Campo obligatorio</div>
                                </div>
                                <div class="col">
                                    <label for="matchdayId" class="fw-bold">Id de partido:</label>
                                    <input type="text" name="fk_matchday" id="matchdayId" class="form-control"
                                           placeholder="ID del partido" value="${team.matchdayId}" required/>
                                    <div class="invalid-feedback">Campo obligatorio</div>
                                </div>
                            </div>
                        </div>

                        <div class="form-group mb-3">
                            <div class="row">
                                <div class="col text-end">
                                    <a href="/equipo/equipos" class="btn btn-outline-danger btn-sm">
                                        CANCELAR
                                    </a>
                                    <button type="submit" class="btn btn-outline-primary btn-sm">
                                        ACEPTAR
                                    </button>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<jsp:include page="../../layouts/footer.jsp"/>
<script>
    (function () {
        const form = document.getElementById("team-form");
        form.addEventListener("submit", function (event) {
            if (!form.checkValidity()) {
                event.preventDefault();
                event.stopPropagation();
            }
            form.classList.add("was-validated");
        }, false)
    })();
</script>
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

