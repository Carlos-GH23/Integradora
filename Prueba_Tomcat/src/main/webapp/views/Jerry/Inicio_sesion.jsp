<%@ taglib prefix="s" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <link rel="stylesheet" href="../Integradora_SERIF/src/main/webapp/CSS/style.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
    <link rel="shortcut icon" href="../Integradora_SERIF/src/main/webapp/Imagenes/mxlogo.png" />
    <link rel="stylesheet" href="../Integradora_SERIF/src/main/webapp/CSS/styleIndex.css"/>
<title>login</title>
</head>
<body class="bg-dark">
<section>
    <div class="row g-0">
        <div class="col-lg-7 d-none d-lg-block">
            <div id="carouselExampleCaptions" class="carousel slide" data-ride="carousel">
                <ol class="carousel-indicators">
                    <li data-target="#carouselExampleCaptions" data-slide-to="0" class="active"></li>
                    <li data-target="#carouselExampleCaptions" data-slide-to="1"></li>
                </ol>
                <div class="carousel-inner">
                    <div class="carousel-item img-1 min-vh-100 active">
                        <div class="carousel-caption d-none d-md-block">
                            <h5 class="font-weight-bold">La mejor liga</h5>
                            <a class="text-muted text-decoration-none">Convive con tu familia.</a>
                        </div>
                    </div>
                    <div class="carousel-item img-2 min-vh-100">
                        <div class="carousel-caption d-none d-md-block">
                            <h5 class="font-weight-bold">Descubre la nueva generación</h5>
                            <a class="text-muted text-decoration-none">Futuros jugadores</a>
                        </div>
                    </div>
                </div>
                <a class="carousel-control-prev" href="#carouselExampleCaptions" role="button" data-slide="prev">
                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                    <span class="sr-only">Previous</span>
                </a>
                <a class="carousel-control-next" href="#carouselExampleCaptions" role="button" data-slide="next">
                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                    <span class="sr-only">Next</span>
                </a>
            </div>
        </div>
        <div class="col-lg-5 bg-dark d-flex flex-column align-items-end min-vh-100">
            <div class="px-lg-5 pt-lg-4 pb-lg-3 p-4 mb-auto w-100">
                <img src="mxlogo.png" width="100" height="32" viewBox="0 0 100 32" fill="none" class="img-fluid"/>
            </div>
            <div class="align-self-center w-100 px-lg-5 py-lg-4 p-4">
                <h1 class="font-weight-bold mb-4">BIENVENIDO DE VUELTA</h1>
                <form class="mb-5"  id="loginForm" action="/page/sesion" class="needs-validation" novalidate method="post">
                    <div class="mb-4">
                        <input type="text" class="form-control" name="username" id="username"
                               placeholder="juanito123" required>
                        <label for="username">Nombre se usuario</label>
                        <div class="invalid-feedback text-start">
                            Campo obligatorio
                        </div>
                        <div class="mb-4">
                            <input type="password" name="password" class="form-control" id="password"
                                   placeholder="Password" required>
                            <label for="password">Contraseña</label>
                            <div class="invalid-feedback text-start">
                                Campo obligatorio
                            </div>
                            <button type="submit" class="btn btn-primary w-100">Iniciar sesión</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</section>
<!-- Optional JavaScript -->
<!-- Popper.js first, then Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
        integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha1/js/bootstrap.min.js"
        integrity="sha384-oesi62hOLfzrys4LxRF63OJCXdXDipiYWBnvTl9Y9/TRlw5xlKIEHpNyvvDShgf/"
        crossorigin="anonymous"></script>

<script src="https://cdn.jsdelivr.net/npm/feather-icons/dist/feather.min.js"></script>
<script>
    window.addEventListener("DOMContentLoaded", () => {
        feather.replace();
        const form = document.getElementById("loginForm");
        const btn = document.getElementById("login");
        form.addEventListener('submit', event => {
            btn.innerHTML = `<div class="d-flex justify-content-center">
                                <div class="spinner-border" role="status">
                                    <span class="visually-hidden">Loading...</span>
                                </div>
                            </div>`;
            btn.classList.add("disabled");
            if (!form.checkValidity()) {
                event.preventDefault();
                event.stopPropagation();
                btn.classList.remove("disabled");
                btn.innerHTML = `<i data-feather="log-in"></i> INICIAR SESIÓN`;
            }
            form.classList.add('was-validated');
        }, false);
        if (!${param['result'] != null ? param['result']: true}) {
            Swal.fire({
                title: 'Acceso denegado',
                text: '${param['message']}',
                icon: 'error',
                confirmButtonText: 'Aceptar'
            });
        }
    }, false);
</script>
</body>
</html>
