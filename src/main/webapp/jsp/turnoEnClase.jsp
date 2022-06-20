<%@page import="model.Consulta"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CONSULTAR LOS MARCADOS</title>
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
		<%for (Consulta c : consultas) { %>
		<form action="turnoEnClase.do" method="post">
			<div><label>Turno de:</label> 
			<input type="text" name="nombre" value="<%= c.getName() %>"  readonly="readonly"/>
			<button type="submit" name="validado" class="btn btn-info">Validar</button></div><br>
		</form>
		<%}%>
		<a href="http://localhost:8080/Servlets_Test/index.html">VOLVER AL MENU PRINCIPAL</a>
</body>
</html>