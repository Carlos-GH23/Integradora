<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha1/css/bootstrap.min.css"
          integrity="sha384-r4NyP46KrjDleawBgD5tp8Y7UzmLA05oM1iAEQ17CSuDqnUK2+k9luXQOfXJCJ4I" crossorigin="anonymous">
    <style>
        .form-container {
            text-align: center;
            margin-top: 20px;
        }
    </style>
    <title>Obtener Credencial</title>
    <jsp:include page="/layouts/header.jsp"/>  
</head>
<body> 
<jsp:include page="/layouts/nav2.jsp"/> 
<div class="form-container">
    <form action="${pageContext.request.contextPath}/representatives/ver" method="get">
        <label for="player">Player ID:</label>
        <input type="text" id="player" name="player" value="1">
        <br>
        <br>
        <br>
        <button type="submit">Obtener Credencial</button>
    </form>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
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


