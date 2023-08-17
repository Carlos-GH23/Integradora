<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registro de Equipo</title>
    <jsp:include page="/layouts/header.jsp"/>
</head>
<body>
<jsp:include page="/layouts/nav2.jsp"/>
<div class="container-fluid">
    <div class="row">
        <div class="col">
            <div class="card mt-5">
                <div class="card-header">Registro de Equipo</div>
                <div class="card-body">
                    <form id="team-form" class="needs-validation" novalidate action="/equipo/save" method="post">
                        <div class="form-group mb-3">
                            <div class="row">
                                <div class="col">
                                    <label for="name" class="fw-bold">Nombre del equipo:</label>
                                    <input type="text" name="name" id="name" class="form-control" required/>
                                    <div class="invalid-feedback">Campo obligatorio</div>
                                </div>
                                <div class="col">
                                    <label for="members" class="fw-bold">Número de miembros:</label>
                                    <input type="number" name="members" id="members" class="form-control" required/>
                                    <div class="invalid-feedback">Campo obligatorio</div>
                                </div>
                                <div class="col">
                                    <label for="matchdayId" class="fw-bold">ID del partido:</label>
                                    <input type="number" name="matchdayId" id="matchdayId" class="form-control" required/>
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
                                    <button type="submit" class="btn btn-outline-success btn-sm">
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
<script>
    (function () {
        const form = document.getElementById("team-form");
        form.addEventListener("submit", function (event) {
            if (!form.checkValidity()) {
                event.preventDefault();
                event.stopPropagation();
            }
            form.classList.add("was-validated");
        }, false);
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
