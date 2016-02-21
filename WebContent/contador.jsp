<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Contador</title>
</head>
<body>
<table border='1px' cellpadding="5px">
	<thead>
		<tr>
			<td>Página</td>
			<td>Quantidade de Acessos</td>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="pageMap" items="${contaAcessos}">
			<tr>
				<td>${pageMap.getKey()}</td>
				<td>${pageMap.getValue()}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
</body>
</html>