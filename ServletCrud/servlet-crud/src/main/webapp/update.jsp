<%@page import="com.js.sc.Product"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>UPDATE THE DETAILS YOU WANT</h1>
<% Product product = (Product)request.getAttribute("pro"); %>
<form action="updateproduct">
	PRODUCT ID : <input type="text" name="id" value="<%= product.getId()%>" readonly="readonly"> <br> <br>
	PRODUCT NAME : <input type="text" name="name" value="<%= product.getName()%>"> <br> <br>
	PRODUCT BRAND : <input type="text" name="brand" value="<%= product.getBrand()%>"> <br> <br>
	PRODUCT QUANTITY : <input type="text" name="quantity" value="<%= product.getQuantity()%>"> <br> <br>
	PRODUCT PRICE : <input type="text" name="price" value="<%= product.getPrice()%>"> <br> <br>
	<input type="submit" value="update">
	</form>
</body>
</html>