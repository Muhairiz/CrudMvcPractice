package com.muha.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.muha.dao.OrderDao;
import com.muha.models.Order;

/**
 * Servlet implementation class UpdateOrder
 */
@WebServlet("/UpdateOrder")
public class UpdateOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateOrder() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		response.setContentType("text/html");
	     PrintWriter out=response.getWriter();
		
		 String id=request.getParameter("order_id");
	     int order_id=Integer.parseInt(id);
		 String name=request.getParameter("oname");
		 
		 String cust=request.getParameter("custId");
		 int custId =Integer.parseInt(cust);
		 String item=request.getParameter("itemId");
		 int itemId = Integer.parseInt(item);
		 
		 Order or=new Order();
		 
		 or.setOrdername(name);
		 or.setCust(custId);
		 or.setItem(itemId);
		 or.setId(order_id);
		 
		 int result=OrderDao.updateOrder(or);
	        if(result>0){
	            out.print("<p>Record updated successfully!</p>");
	            response.sendRedirect("views/vieworder.jsp");
	        }else{
	            out.println("Sorry! unable to save record");
	            //response.sendRedirect("views/viewcust.jsp");
	        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
