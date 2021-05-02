<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
<%@ page import="com.muha.dao.ItemDao" %>
<%@ page import="com.muha.models.Item" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%
		String sid=request.getParameter("id");
	    int id=Integer.parseInt(sid);	
	    Item it=ItemDao.getItemById(id);
	%>
	<a href="vieworder.jsp">View Order</a><br><a href="orderform.jsp">Add Order</a><br><br>
	<a href="viewcust.jsp">View Customer</a><br><a href="custform.jsp">Add Customer</a><br><br>
	<a href="viewitem.jsp">View Items</a><br><a href="itemform.jsp">Add Item</a><br><br>
	
	<h1>Update Item</h1>
	<form action="../UpdateItem" method="post">
		<input type="hidden" name="item_id" value=<%=it.getId() %>>
		Name<input type="text" name="iname" value=<%=it.getItemName() %>><br><br>
		Price<input type="text" name="iprice" value=<%=it.getPrice() %>><br><br>
		<button type="submit">Update</button>
	</form>
	<a href="viewitem.jsp">Cancel</a>

</body>
</html>