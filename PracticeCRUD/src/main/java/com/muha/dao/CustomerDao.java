package com.muha.dao;
import java.util.*;
import java.sql.*;

import com.muha.models.Customer;

public class CustomerDao {

	public static Connection getConnection(){
        Connection con=null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con= DriverManager.getConnection("jdbc:mysql://localhost/shopdb","root","");
        }catch(Exception e){System.out.println(e);}
        return con;   
    }
	
	public static int saveCustomer(Customer cus) {
		int result =0;
		
		try {
			Connection conn=CustomerDao.getConnection();
			PreparedStatement ps=conn.prepareStatement("insert into customer(cust_name,cust_phone) values(?,?)");
			ps.setString(1, cus.getCustname());
			ps.setString(2, cus.getPhone());
			result =ps.executeUpdate();
			conn.close();
		}catch(Exception ex){ex.printStackTrace();}

        return result;
	}
	
	 public static List<Customer> getAllCustomer(){
	        List<Customer> list=new ArrayList<Customer>();
	        try{
	            Connection con=CustomerDao.getConnection();
	            PreparedStatement ps=con.prepareStatement("select * from customer");
	            ResultSet rs=ps.executeQuery();
	            while(rs.next()){
	            	Customer cus=new Customer();
	            	cus.setId(rs.getInt(1));
	            	cus.setCustname(rs.getString(2));
	            	cus.setPhone(rs.getString(3));
	                list.add(cus);
	            }
	            con.close();
	        }catch(Exception e){e.printStackTrace();}

	        return list;
	    }
	 
	 public static int delete(int id){
	        int status=0;
	        try{
	            Connection con=CustomerDao.getConnection();
	            PreparedStatement ps=con.prepareStatement("delete from customer where cust_id=?");
	            ps.setInt(1,id);
	            status=ps.executeUpdate();
	            con.close();
	        }catch(Exception e){e.printStackTrace();}

	        return status;
	    }
	 
	 public static int updateCustomer(Customer cus){
		 
	        int result=0;
	        try{
	            Connection con=CustomerDao.getConnection();
	            PreparedStatement ps=con.prepareStatement("update customer set cust_name=?,cust_phone=? where cust_id=?");
	            ps.setString(1, cus.getCustname());
				ps.setString(2, cus.getPhone());
	            ps.setInt(3,cus.getId());

	            result=ps.executeUpdate();

	            con.close();
	        }catch(Exception ex){ex.printStackTrace();}

	        return result;
	    }
	 
	 
	 
	 public static Customer getCustomerById(int id){
		 Customer cus=new Customer();

	        try{
	            Connection con=CustomerDao.getConnection();
	            PreparedStatement ps=con.prepareStatement("select * from customer where cust_id=?");
	            ps.setInt(1,id);
	            ResultSet rs=ps.executeQuery();
	            if(rs.next()){
	            	cus.setId(rs.getInt(1));
	            	cus.setCustname(rs.getString(2));
	            	cus.setPhone(rs.getString(3));
	            }
	            con.close();
	        }catch(Exception ex){ex.printStackTrace();}

	        return cus;
	    }

	
}
