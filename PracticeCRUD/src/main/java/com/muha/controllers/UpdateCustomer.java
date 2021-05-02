package com.muha.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.muha.dao.CustomerDao;
import com.muha.models.Customer;

/**
 * Servlet implementation class UpdateCustomer
 */
@WebServlet("/UpdateCustomer")
public class UpdateCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCustomer() {
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
		
		 String id=request.getParameter("cust_id");
	     int cust_id=Integer.parseInt(id);
		 String name=request.getParameter("fname");
		 String phone=request.getParameter("phone");
		 
		 Customer cus=new Customer();
		 
		 cus.setCustname(name);
		 cus.setPhone(phone);
		 cus.setId(cust_id);
		 
		 int result=CustomerDao.updateCustomer(cus);
	        if(result>0){
	            out.print("<p>Record updated successfully!</p>");
	            response.sendRedirect("views/viewcust.jsp");
	        }else{
	            out.println("Sorry! unable to save record");
	            response.sendRedirect("views/viewcust.jsp");
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
