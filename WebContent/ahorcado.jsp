<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="main.java.Ahorcado" %>
<!DOCTYPE html>
<html>

<head>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
</head>

<body>
	<% 	
		String pal = request.getParameter("oculta");
		String err = request.getParameter("errores");
		String estado = request.getParameter("estado");
	%>
	<p id="estado">Estado:
		<%=estado %>
	</p>
	<p>Intentos restantes: <%=err %> de 6</p>
	<p>Palabra a descubrir: <%=pal %></p>
	<form action=/ahorcado/ahorcadoServlet method="post">
		<input name="letra" type="text" placeholder="Ingresa una letra...">
		<input name="intentar" type="submit" value="Intentar">
	</form>
</body>

</html>