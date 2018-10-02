<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title></title>
	</head>
	<body>
		<h1>Bienvenido al sistema de deteccion de URLs maliciosas</h1>
		<h2>¿Como desea hacer la comprobacion?</h2>
		<div>
			<form method="post" action="<c:url value="Index"/>">
				<select name="option">
			      <option value="singleURL">Una URL.
			      <option value="multipleURL">Varias URLs.
			    </select>
		    	<br/>
		    	<button type="submit">Elegir</button>
		    </form>
		</div>
	</body>
</html>