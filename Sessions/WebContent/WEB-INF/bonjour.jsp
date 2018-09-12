<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
	</head>
	<body>
		<c:if test="${ !empty sessionScope.prenom && !empty sessionScope.nom }">
        	<p>Vous êtes ${ sessionScope.prenom } ${ sessionScope.nom } !</p>
    	</c:if>
    	
    	<form method="post" action="Test">
    		<p>
	            <label for="nom">Nom: </label>
	            <input type="text" name="nom" id="nom" />
        	</p>
        	
        	<p>
	            <label for="prenom">Prénom : </label>
	            <input type="text" name="prenom" id="prenom" />
	        </p>
	        
	        <input type="submit" />
    	</form>
	</body>
</html>