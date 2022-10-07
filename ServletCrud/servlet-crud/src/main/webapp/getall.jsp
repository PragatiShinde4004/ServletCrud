<%@page import="java.util.ArrayList"%>
<%@page import="com.js.sc.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	if (session.getAttribute("start") != null) {
	%>
	<h1>PRODUCTS LIST</h1>
	<table border="5px">
		<tr>
			<th>ID</th>
			<th>NAME</th>
			<th>BRAND</th>
			<th>QUANTITY</th>
			<th>PRICE</th>
			<th>DELETE</th>
			<th>UPDATE</th>
		</tr>

		<%
		List<Product> products = (ArrayList) request.getAttribute("list");
		for (Product product : products) {
		%>
		<tr>
			<td><%=product.getId()%></td>
			<td><%=product.getName()%></td>
			<td><%=product.getBrand()%></td>
			<td><%=product.getQuantity()%></td>
			<td><%=product.getPrice()%></td>
			<td><a href="delete?id=<%=product.getId()%>">delete</a></td>
			<td><a href="update?id=<%=product.getId()%>">update</a></td>
		</tr>
		<%
		}
		%>
	</table>
	<h2>
		<a href="logout">LOGOUT</a>
	</h2>
	<%
	} else {
	response.sendRedirect("login.html");
	}
	%>
</body>
</html>