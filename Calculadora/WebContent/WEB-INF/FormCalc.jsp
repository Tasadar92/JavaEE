<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Calculadora</title>
	</head>
	<body>
		<form action="Calculadora" method="post">
			Operando 1: 
		    <input type="number" name="op1"><span class="blanc1">	${blanc1}</span>
		    <br/>
		    Operando 2: 
		    <input type="number" name="op2"><span class="blanc2">	${blanc2}</span>
		    <br/>
		    
		    <select name="operacion">
		      <option value="suma">+
		      <option value="resta">-
		      <option value="multi">*
		      <option value="div">/
		    </select>
		    <br/>
		    
		    <button type="submit">Calcular</button>
		    
		</form>
		
		<span class="result">Resultado: ${result}</span>
	</body>
</html>