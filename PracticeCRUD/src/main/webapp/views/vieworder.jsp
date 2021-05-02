<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
<%@ page import="com.muha.dao.OrderDao" %>
<%@ page import="com.muha.models.Order" %>
<!DOCTYPE html>
<html>
<head>
<link href="bootstrap/css/bootstrap.css" rel="stylesheet">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
List<Order> list=OrderDao.getAllOrder();
%>

	<a href="vieworder.jsp">View Order</a><br><a href="orderform.jsp">Add Order</a><br><br>
	<a href="viewcust.jsp">View Customer</a><br><a href="custform.jsp">Add Customer</a><br><br>
	<a href="viewitem.jsp">View Items</a><br><a href="itemform.jsp">Add Item</a><br><br>
	
<h1 class="text-center">List of Orders</h1>
	<table class="table table-striped">
		<thead>
			<tr>
				<th>Order Name</th>
				<th>Customer Id</th>
				<th>Item Id</th>
				<th>Delete</th>
				<th>Update</th>
			</tr>
		</thead>
		<tbody>
			<% for(Order or:list){ %>
			<tr>
				<td><%= or.getOrdername() %></td>
				<td><%= or.getCust() %></td>
				<td><%= or.getItem() %></td>
				<td><a href="../DeleteOrder?id=<%= or.getId() %>">Delete</a></td>
				<td><a href="updateorderform.jsp?id=<%= or.getId() %>">Update</a></td>
			</tr>
			<% } %>
		</tbody>
	</table>
</body>
</html>