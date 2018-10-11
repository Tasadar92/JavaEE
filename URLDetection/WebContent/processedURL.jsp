<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Result of the processing of the URL</title>
		<link type="text/css" rel="stylesheet" href="<c:url value='/WEB-INF/static/style.css'/>" />
	</head>
	<body>
		<c:import url="/WEB-INF/static/menu.jsp" />
		<div id="corps">
            <p class="info">${form.resultat}</p>
            <p>URL submitted by you is: <c:out value="${url.string}"/></p>
            <p>URL features processed: <c:out value="${url.features}"/></p>
            <p>My prediction is: <c:out value="${url.tag}"/></p>
        </div>
	</body>
</html>