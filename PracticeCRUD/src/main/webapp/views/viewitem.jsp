<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
<%@ page import="com.muha.dao.ItemDao" %>
<%@ page import="com.muha.models.Item" %>
<!DOCTYPE html>
<html>
<head>
<link href="bootstrap/css/bootstrap.css" rel="stylesheet">
<meta charset="ISO-8859-1">
<title>item info</title>
</head>
<body>
<%
List<Item> list=ItemDao.getAllItem();
%>
	<a href="vieworder.jsp">View Order</a><br><a href="orderform.jsp">Add Order</a><br><br>
	<a href="viewcust.jsp">View Customer</a><br><a href="custform.jsp">Add Customer</a><br><br>
	<a href="viewitem.jsp">View Items</a><br><a href="itemform.jsp">Add Item</a><br><br>
	
<h1 class="text-center">List of Items</h1>
	<table class="table table-striped">
		<thead>
			<tr>
				<th>Item Name</th>
				<th>Item Price</th>
				<th>Delete</th>
				<th>Update</th>
			</tr>
		</thead>
		<tbody>
			<% for(Item it:list){ %>
			<tr>
				<td><%= it.getItemName() %></td>
				<td><%= it.getPrice() %></td>
				<td><a href="../DeleteItem?id=<%= it.getId() %>">Delete</a></td>
				<td><a href="updateitemform.jsp?id=<%= it.getId() %>">Update</a></td>
			</tr>
			<% } %>
		</tbody>
	</table>
</body>
</html>