<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
<%@ page import="com.muha.dao.CustomerDao, com.muha.dao.ItemDao" %>
<%@ page import="com.muha.models.Customer, com.muha.models.Item" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>order form</title>
</head>
<body>
	<%
	List<Customer> clist=CustomerDao.getAllCustomer();
	List<Item> ilist=ItemDao.getAllItem();
	%>
	
	<a href="vieworder.jsp">View Order</a><br><a href="orderform.jsp">Add Order</a><br><br>
	<a href="viewcust.jsp">View Customer</a><br><a href="custform.jsp">Add Customer</a><br><br>
	<a href="viewitem.jsp">View Items</a><br><a href="itemform.jsp">Add Item</a><br><br>
	
	<h1>Order Form</h1>
	<form action="../SaveOrder" method="post">
		Name<input type="text" name ="oname"><br><br>
		Customer Id
		<select name="custId">
			<% for(Customer cus:clist){ %>
			<option><%= cus.getId() %></option>
			<%} %>
		</select><br><br>
		Item Id<select name="itemId">
			<% for(Item it:ilist){ %>
			<option><%= it.getId() %></option>
			<%} %>
		</select><br><br>
		<button type="submit" >Submit</button>
	</form>
	
</body>
</html>