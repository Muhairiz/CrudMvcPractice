<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>  
<%@ page import="java.util.*" %>
<%@ page import="com.muha.dao.CustomerDao" %>
<%@ page import="com.muha.models.Customer" %>
    
<!DOCTYPE html>
<html>
<head>
<link href="bootstrap/css/bootstrap.css" rel="stylesheet">
<meta charset="ISO-8859-1">
<title>employee information</title>
</head>
<body>
<%
List<Customer> list=CustomerDao.getAllCustomer();
%>
	<a href="vieworder.jsp">View Order</a><br><a href="orderform.jsp">Add Order</a><br><br>
	<a href="viewcust.jsp">View Customer</a><br><a href="custform.jsp">Add Customer</a><br><br>
	<a href="viewitem.jsp">View Items</a><br><a href="itemform.jsp">Add Item</a><br><br>
	
	<h1 class="text-center">List of Customers</h1>
	<table class="table table-striped">
		<thead>
			<tr>
				<th>Name</th>
				<th>Phone Number</th>
				<th>Delete</th>
				<th>Update</th>
			</tr>
		</thead>
		<tbody>
			<% for(Customer cus:list){ %>
			<tr>
				<td><%= cus.getCustname()%></td>
				<td><%= cus.getPhone() %></td>
				<td><a href="../DeleteCustomer?id=<%= cus.getId() %>">Delete</a></td>
				<td><a href="updatecustform.jsp?id=<%= cus.getId() %>">Update</a></td>
			</tr>
			<% } %>
		</tbody>
	</table>
</body>
</html>