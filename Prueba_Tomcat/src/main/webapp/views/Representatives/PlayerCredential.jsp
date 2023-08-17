<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha1/css/bootstrap.min.css"
          integrity="sha384-r4NyP46KrjDleawBgD5tp8Y7UzmLA05oM1iAEQ17CSuDqnUK2+k9luXQOfXJCJ4I" crossorigin="anonymous">
    <title>Credencial de Jugador</title>
        <jsp:include page="/layouts/header.jsp"/>  
</head>
<body>
<jsp:include page="/layouts/nav2.jsp"/> 
<div>
    <style>
        .credencial {
            border: 1px solid #ccc;
            padding: 20px;
            text-align: center;
            max-width: 400px;
            margin: 0 auto;
        }
        
        .form-container {
            text-align: center;
            margin-top: 20px;
        }
    </style>   
<h1>Credencial de Jugador</h1>
<div class="credencial">
<c:choose>
    <c:when test="${not empty player}">
        <p>Name: ${player.name}</p>
        <p>Surname: ${player.surname}</p>
        <p>Second Surname: ${player.surname2}</p>
        <p>Position: ${player.position}</p>
        <p>Dorsal: ${player.dorsal}</p>
        <p hidden="teamId">Team ID: ${player.teamId}</p>
        <p> Equipo: ${player.team.name}</p>
    </c:when>
    <c:otherwise>
        <p>${errorMessage}</p>
    </c:otherwise>
</c:choose>
</div>
<br>
<br>
<br>
<br>
<br>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jspdf/2.4.0/jspdf.umd.min.js"></script>
<script>
    document.getElementById("generate-pdf").addEventListener("click", function() {
        // Crear un nuevo objeto jsPDF
        var doc = new jsPDF();

        // Obtener el contenido de la credencial
        var content = document.querySelector(".credencial").innerHTML;

        // Agregar el contenido al PDF
        doc.fromHTML(content, 10, 10, {
            width: 190
        });

        // Guardar el PDF con el nombre "credencial.pdf"
        doc.save("credencial.pdf");
    });
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
