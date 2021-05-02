<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
<%@ page import="com.muha.dao.OrderDao" %>
<%@ page import="com.muha.models.Order" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>update order</title>
</head>
<body>
	<%
		String sid=request.getParameter("id");
	    int id=Integer.parseInt(sid);	
	    Order or=OrderDao.getOrderById(id);
	%>
	<a href="vieworder.jsp">View Order</a><br><a href="orderform.jsp">Add Order</a><br><br>
	<a href="viewcust.jsp">View Customer</a><br><a href="custform.jsp">Add Customer</a><br><br>
	<a href="viewitem.jsp">View Items</a><br><a href="itemform.jsp">Add Item</a><br><br>
	
	<h1>Update Employee</h1>
	<form action="../UpdateOrder" method="post">
		<input type="hidden" name="order_id" value=<%=or.getId() %>>
		Order Name<input type="text" name="oname" value=<%=or.getOrdername() %>><br><br>
		Customer Id<input type="text" name="custId" value=<%=or.getCust() %>><br><br>
		Item Id<input type="text" name="itemId" value=<%=or.getItem() %>><br><br>
		<button type="submit">Update</button>
		<a href="vieworder.jsp">Cancel</a>
	</form>
</body>
</html>