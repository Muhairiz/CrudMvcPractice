<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<a href="vieworder.jsp">View Order</a><br><a href="orderform.jsp">Add Order</a><br><br>
	<a href="viewcust.jsp">View Customer</a><br><a href="custform.jsp">Add Customer</a><br><br>
	<a href="viewitem.jsp">View Items</a><br><a href="itemform.jsp">Add Item</a><br><br>
	<h1>Item form</h1>	
	<form action="../SaveItem" method="post">
		Item Name<input type="text" name="iname"><br><br>
		Item Price<input type="text" name="iprice"><br><br>
		<button type="submit">Submit</button>
	</form>
</body>
</html>