<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Cookie</title>
	</head>
	<body>
		<c:out value="${ prenom }" />
		<form method="post" action="bonjour">
    		<p>
	            <label for="nom">Nom: </label>
	            <input type="text" name="nom" id="nom" />
        	</p>
        	
        	<p>
	            <label for="prenom">Pr�nom : </label>
	            <input type="text" name="prenom" id="prenom" />
	        </p>
	        
	        <input type="submit" />
    	</form>
	</body>
</html>