<%@page import="model.Consulta"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>TURNO PARA LA CONSULTA</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<!-- Popper JS -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
	<% ArrayList<Consulta> consultas = (ArrayList<Consulta>) request.getAttribute("consultas"); %>
</head>
<body>
		<form action="turnoDeClase.do" method="post" style="width: 40vw;margin-left: 500px;margin-top:20px">
			<div class="form-group">
				<label>Nombre:</label> <input type="text" name="nombre"
					placeholder="Introduce tu nombre:" class="form-control" /> <small
					class="form-text text-muted">Si ya has pedido turno,
					introduce tu nombre para ver en qué posición estás</small>
			</div>
			<div class="form-check">
				<input type="checkbox" name="salir" class="form-check-input" /> <label
					class="form-check-label">Salir de la cola</label>
			</div>
			<br>
			<small class="form-text text-muted">Marca esta casilla e
				introduce tu nombre para salir de la cola</small><br>
			<div>
				<small class="form-text text-muted">En la lista eres el numero:</small><br>
				<%= consultas.size() %>
			</div>	 <br> 	
			<input type="submit" value="Enviar" name="enviar" class="btn btn-warning waves-effect waves-light">
			<br>
			<br>
			<a href="http://localhost:8080/Servlets_Test/index.html">VOLVER AL MENU PRINCIPAL</a>
		</form>
</body>
</html>