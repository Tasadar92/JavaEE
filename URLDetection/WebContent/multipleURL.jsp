<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Checking multiple URLs</title>
		<link type="text/css" rel="stylesheet" href="<c:url value='/WEB-INF/static/style.css'/>" />
	</head>
	<body>
		<c:import url="/WEB-INF/static/menu.jsp" />
		<div>
			<form action="<c:url value='/upload' />" method="post" enctype="multipart/form-data">
				<fieldset>
					<legend>Send File</legend>
					
					<label for="description">File Name:</label>
					<input type="text" id="description" name="description"/>
					<span class="erreur">${form.erreurs['description']}</span>
					<br>
					
					<label for="doc">File Address:<span class="requis">*</span></label>
					<input type="file" id="doc" name="doc"/>
					<span class="erreur">${form.erreurs['doc']}</span>
					<br>
					
					<input type="submit" value="Enviar" class="sansLabel" />
					<br>
					
					<p class="${empty form.erreurs ? 'succes' : 'erreur'}">${form.resultat}</p>				
				</fieldset>
			</form>
		</div>
	</body>
</html>