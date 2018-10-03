<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Checking string URL</title>
		<link type="text/css" rel="stylesheet" href="<c:url value='/WEB-INF/static/style.css'/>" />
	</head>
	<body>
		<c:import url="/WEB-INF/static/menu.jsp" />
		<div>
			<form method="post" action="<c:url value='/singleURL'/>" >
				<fieldset>
					<legend>Checking string URL</legend>
					
					<p> Please enter URL with protocol specified i.e https://www.youtube.com</p>
					<label for="stringURL">Enter the URL:<span class="requis">*</span></label>
					<input type="text" id="stringURL" name="stringURL" value="<c:out value='${url.string}'/>" size="100" maxlength="100" />
					<input type="submit" value="Next"  />
					<span class="erreur">${form.erreurs['stringURL']}</span>
					<br>
					<p class="info">${ form.resultat }</p>						
				</fieldset>
			</form>
		</div>
	</body>
</html>