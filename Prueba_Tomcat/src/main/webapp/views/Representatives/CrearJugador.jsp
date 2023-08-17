<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Crear Jugador</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <jsp:include page="/layouts/header.jsp"/>
</head>
<body>
<jsp:include page="/layouts/nav2.jsp"/>
<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <div class="card">
                <div class="card-header text-center">
                    <h4>Registrar Jugador</h4>
                </div>
                <div class="card-body">
                    <form action="/jugador/save" method="post" enctype="multipart/form-data">
                        <div class="form-group">
                            <label>Nombre:</label>
                            <input type="text" name="name" class="form-control" required>
                        </div>
                        <div class="form-group">
                            <label>Apellido Paterno:</label>
                            <input type="text" name="Surname" class="form-control" required>
                        </div>
                        <div class="form-group">
                            <label>Apellido Materno:</label>
                            <input type="text" name="Surname2" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Posición:</label>
                            <input type="text" name="Position" class="form-control" required>
                        </div>
                        <div class="form-group">
                            <label>Dorsal:</label>
                            <input type="text" name="Dorsal" class="form-control" required>
                        </div>
                        <div class="form-group">
                            <label>Imagen:</label>
                            <input type="file" name="playerImage" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>ID del Equipo:</label>
                            <input type="number" name="TeamId" min="1" class="form-control" required>
                        </div>
                        <div class="form-group text-center">
                            <button type="submit" class="btn btn-primary">Actualizar</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
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