<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="java.io.*,java.util.*,java.sql.*" %>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ page import="com.muha.dao.CustomerDao" %>
<%@ page import="com.muha.models.Customer" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>update employee</title>
</head>
<body>
	<%
		String sid=request.getParameter("id");
	    int id=Integer.parseInt(sid);	
	    Customer cus=CustomerDao.getCustomerById(id);
	%>
	<a href="vieworder.jsp">View Order</a><br><a href="orderform.jsp">Add Order</a><br><br>
	<a href="viewcust.jsp">View Customer</a><br><a href="custform.jsp">Add Customer</a><br><br>
	<a href="viewitem.jsp">View Items</a><br><a href="itemform.jsp">Add Item</a><br><br>
	
	<h1>Update Customer</h1>
	<form action="../UpdateCustomer" method="post">
		<input type="hidden" name="cust_id" value=<%=cus.getId() %>>
		Name<input type="text" name="fname" value=<%=cus.getCustname() %>><br><br>
		Phone Number<input type="text" name="phone" value=<%=cus.getPhone() %>><br><br>
		<button type="submit">Update</button>
	</form>
	<a href="viewcust.jsp">Cancel</a>
</body>
</html>