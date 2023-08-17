<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registro de Equipo</title>
    <jsp:include page="/layouts/header.jsp"/>
</head>
<body>
<jsp:include page="/layouts/nav3.jsp"/>
<jsp:include page="/layouts/nav3.jsp"/>
<div class="container-fluid">
    <div class="row">
        <div class="col">
            <div class="card mt-5">
                <div class="card-header">Registro de Matchday</div>
                <div class="card-body">
                    <form id="team-form" class="needs-validation" novalidate action="/matchday/save" method="post">
                        <div class="form-group mb-3">
                            <div class="row">
                                <div class="col">
                                    <label for="match_field" class="fw-bold">Nombre de la cancha:</label>
                                    <input type="text" name="match_field" id="match_field" class="form-control" required/>
                                    <div class="invalid-feedback">Campo obligatorio</div>
                                </div>
                                <div class="col">
                                    <label for="starthour" class="fw-bold">Hora de inicio:</label>
                                    <input type="time" name="starthour" id="starthour" class="form-control" required/>
                                    <div class="invalid-feedback">Campo obligatorio</div>
                                </div>
                                <div class="col">
                                    <label for="endhour" class="fw-bold">Hora final:</label>
                                    <input type="time" name="endhour" id="endhour" class="form-control" required/>
                                    <div class="invalid-feedback">Campo obligatorio</div>
                                </div>
                                <div class="col">
                                    <label for="date_match" class="fw-bold">Fecha:</label>
                                    <input type="date" name="date_match" id="date_match" class="form-control" required/>
                                    <div class="invalid-feedback">Campo obligatorio</div>
                                </div>
                                <div class="col">
                                    <label for="points" class="fw-bold">Puntos:</label>
                                    <input type="text" name="points" id="points" class="form-control" required/>
                                    <div class="invalid-feedback">Campo obligatorio</div>
                                </div>
                                <div class="col">
                                    <label for="draws" class="fw-bold">Empate:</label>
                                    <input type="number" name="draws" id="draws" class="form-control" required/>
                                    <div class="invalid-feedback">Campo obligatorio</div>
                                </div>
                                <div class="col">
                                    <label for="wins" class="fw-bold">Victoria:</label>
                                    <input type="number" name="wins" id="wins" class="form-control" required/>
                                    <div class="invalid-feedback">Campo obligatorio</div>
                                </div>
                                <div class="col">
                                    <label for="loses" class="fw-bold">Derrota:</label>
                                    <input type="number" name="loses" id="loses" class="form-control" required/>
                                    <div class="invalid-feedback">Campo obligatorio</div>
                                </div>
                                <div class="col">
                                    <label for="goal_difference" class="fw-bold">Diferencia de goles:</label>
                                    <input type="number" name="goal_difference" id="goal_difference" class="form-control" required/>
                                    <div class="invalid-feedback">Campo obligatorio</div>
                                </div>
                                <div class="col">
                                    <label for="goals_scored" class="fw-bold">Goles anotados:</label>
                                    <input type="number" name="goals_scored" id="goals_scored" class="form-control" required/>
                                    <div class="invalid-feedback">Campo obligatorio</div>
                                </div>
                                <div class="col">
                                    <label for="goals_against" class="fw-bold">Goles en contra:</label>
                                    <input type="number" name="goals_against" id="goals_against" class="form-control" required/>
                                    <div class="invalid-feedback">Campo obligatorio</div>
                                </div>
                                <div class="col">
                                    <label for="clasification" class="fw-bold">Clasificacion:</label>
                                    <input type="number" name="clasification" id="clasification" class="form-control" required/>
                                    <div class="invalid-feedback">Campo obligatorio</div>
                                </div>
                            </div>
                        </div>
                        <div class="form-group mb-3">
                            <div class="row">
                                <div class="col text-end">
                                    <a href="/matchday/matchdays" class="btn btn-outline-danger btn-sm">
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
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/js/bootstrap.bundle.min.js"></script>
<jsp:include page="/layouts/footer.jsp"/>
</body>
</html>
