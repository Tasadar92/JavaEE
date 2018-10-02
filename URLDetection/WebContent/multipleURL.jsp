<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Envio de Fichero</title>
		<link type="text/css" rel="stylesheet" href="<c:url value='/WEB-INF/static/style.css'/>" />
	</head>
	<body>
		<form action="<c:url value='/upload' />" method="post" enctype="multipart/form-data">
			<fieldset>
				<legend>Envio de Fichero</legend>
				
				<label for="description">Nombre del fichero</label>
				<input type="text" id="description" name="description"/>
				<span class="erreur">${form.erreurs['description']}</span>
				<br>
				
				<label for="fichier">Emplacement du fichier<span class="requis">*</span></label>
				<input type="file" id="fichier" name="fichier"/>
				<span class="erreur">${form.erreurs['fichier']}</span>
				<br>
				
				<input type="submit" value="Enviar" class="sansLabel" />
				<br>
				
				<p class="${empty form.erreurs ? 'succes' : 'erreur'}">${form.resultat}</p>				
			</fieldset>
		</form>
	</body>
</html>