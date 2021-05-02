package com.muha.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.muha.dao.ItemDao;
import com.muha.models.Item;

/**
 * Servlet implementation class UpdateItem
 */
@WebServlet("/UpdateItem")
public class UpdateItem extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateItem() {
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
		
		 String id=request.getParameter("item_id");
	     int item_id=Integer.parseInt(id);
		 String name=request.getParameter("iname");
		 String price=request.getParameter("iprice");
		 int iprice=Integer.parseInt(price);
		 
		 Item it=new Item();
		 
		 it.setItemName(name);
		 it.setPrice(iprice);
		 it.setId(item_id);
		 
		 int result=ItemDao.updateItem(it);
	        if(result>0){
	            out.print("<p>Record updated successfully!</p>");
	            response.sendRedirect("views/viewitem.jsp");
	        }else{
	            out.println("Sorry! unable to save record");
	            response.sendRedirect("views/viewitem.jsp");
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
