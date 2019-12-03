<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Display Users</title>
</head>
<body>
<table border="1">
 <tr>
 <th>Id</th>
 <th>Name</th>
 <th>Email</th>
 </tr>
	<c:forEach items="${users}" var="user">
	<tr>
		<td>${user.id}</td>
		<td>${user.name}</td>
		<td>${user.email}</td>
	</tr>
	</c:forEach>
</table>
</body>
</html>