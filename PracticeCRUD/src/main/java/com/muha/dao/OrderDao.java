package com.muha.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.muha.models.Order;

public class OrderDao {

	public static Connection getConnection(){
        Connection con=null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con= DriverManager.getConnection("jdbc:mysql://localhost/shopdb","root","");
        }catch(Exception e){System.out.println(e);}
        return con;   
    }
	
	public static int saveOrder(Order or) {
		int result =0;
		
		try {
			Connection conn=OrderDao.getConnection();
			PreparedStatement ps=conn.prepareStatement("insert into orders(order_name,cust,item) values(?,?,?)");
			ps.setString(1, or.getOrdername());
			ps.setInt(2, or.getCust());
			ps.setInt(3, or.getItem());
			result =ps.executeUpdate();
			conn.close();
		}catch(Exception ex){ex.printStackTrace();}

        return result;
	}
	
	public static List<Order> getAllOrder(){
        List<Order> list=new ArrayList<Order>();
        try{
            Connection con=OrderDao.getConnection();
            PreparedStatement ps=con.prepareStatement("select * from orders");
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
            	Order or=new Order();
            	or.setId(rs.getInt(1));
            	or.setOrdername(rs.getString(2));
            	or.setCust(rs.getInt(3));
            	or.setItem(rs.getInt(4));
                list.add(or);
            }
            con.close();
        }catch(Exception e){e.printStackTrace();}

        return list;
    }
	
	 public static int deleteOrder(int id){
	        int status=0;
	        try{
	            Connection con=OrderDao.getConnection();
	            PreparedStatement ps=con.prepareStatement("delete from orders where order_id=?");
	            ps.setInt(1,id);
	            status=ps.executeUpdate();
	            con.close();
	        }catch(Exception e){e.printStackTrace();}

	        return status;
	    }
	 
	 public static int updateOrder(Order or){
		 
	        int result=0;
	        try{
	            Connection con=OrderDao.getConnection();
	            PreparedStatement ps=con.prepareStatement("update orders set order_name=?, cust=?, item=? where order_id=?");
	            ps.setString(1, or.getOrdername());
				ps.setInt(2, or.getCust());
				ps.setInt(3, or.getItem());
	            ps.setInt(4,or.getId());

	            result=ps.executeUpdate();

	            con.close();
	        }catch(Exception ex){ex.printStackTrace();}

	        return result;
	    }
	 
	 
	 
	 public static Order getOrderById(int id){
		 Order or=new Order();

	        try{
	            Connection con=OrderDao.getConnection();
	            PreparedStatement ps=con.prepareStatement("select * from orders where order_id=?");
	            ps.setInt(1,id);
	            ResultSet rs=ps.executeQuery();
	            if(rs.next()){
	            	or.setId(rs.getInt(1));
	            	or.setOrdername(rs.getString(2));
	            	or.setCust(rs.getInt(3));
	            	or.setItem(rs.getInt(4));
	            }
	            con.close();
	        }catch(Exception ex){ex.printStackTrace();}

	        return or;
	    }

	
}
