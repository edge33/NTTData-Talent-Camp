<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista Prodotti</title>
</head>
<body>
	<p>benvenuto: <c:out value="${sessionScope.auth}" /></p>
	<table>
		<tbody>
			<tr>
				<th>Nome</th>
				<th>Categoria</th>
				<th>Prezzo</th>
			</tr>
			<c:forEach items="${productsList}" var="item">
    			<tr>
    				<td>${item.getName()}</td>
    				<td>${item.getCategory()}</td>
    				<td>${item.getPrice()}</td>
    			</tr>
			</c:forEach>
			
			<tr>
				<td></td>
			</tr>
		</tbody>
	</table>

</body>
</html>