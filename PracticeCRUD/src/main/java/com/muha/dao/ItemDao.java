package com.muha.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.muha.models.Item;

public class ItemDao {

	public static Connection getConnection(){
        Connection con=null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con= DriverManager.getConnection("jdbc:mysql://localhost/shopdb","root","");
        }catch(Exception e){System.out.println(e);}
        return con;   
    }
	
	public static int saveItem(Item it) {
		int result =0;
		
		try {
			Connection conn=ItemDao.getConnection();
			PreparedStatement ps=conn.prepareStatement("insert into items(item_name,item_price) values(?,?)");
			ps.setString(1, it.getItemName());
			ps.setInt(2, it.getPrice());
			result =ps.executeUpdate();
			conn.close();
		}catch(Exception ex){ex.printStackTrace();}

        return result;
	}
	
	public static List<Item> getAllItem(){
        List<Item> list=new ArrayList<Item>();
        try{
            Connection con=ItemDao.getConnection();
            PreparedStatement ps=con.prepareStatement("select * from items");
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
            	Item it=new Item();
            	it.setId(rs.getInt(1));
            	it.setItemName(rs.getString(2));
            	it.setPrice(rs.getInt(3));
                list.add(it);
            }
            con.close();
        }catch(Exception e){e.printStackTrace();}

        return list;
    }
	
	 public static int deleteItem(int id){
	        int status=0;
	        try{
	            Connection con=ItemDao.getConnection();
	            PreparedStatement ps=con.prepareStatement("delete from items where item_id=?");
	            ps.setInt(1,id);
	            status=ps.executeUpdate();
	            con.close();
	        }catch(Exception e){e.printStackTrace();}

	        return status;
	    }
	 
	 public static int updateItem(Item it){
		 
	        int result=0;
	        try{
	            Connection con=ItemDao.getConnection();
	            PreparedStatement ps=con.prepareStatement("update items set item_name=?, item_price=? where item_id=?");
	            ps.setString(1, it.getItemName());
				ps.setInt(2, it.getPrice());
	            ps.setInt(3,it.getId());

	            result=ps.executeUpdate();

	            con.close();
	        }catch(Exception ex){ex.printStackTrace();}

	        return result;
	    }
	 
	 
	 
	 public static Item getItemById(int id){
		 Item it=new Item();

	        try{
	            Connection con=ItemDao.getConnection();
	            PreparedStatement ps=con.prepareStatement("select * from items where item_id=?");
	            ps.setInt(1,id);
	            ResultSet rs=ps.executeQuery();
	            if(rs.next()){
	            	it.setId(rs.getInt(1));
	            	it.setItemName(rs.getString(2));
	            	it.setPrice(rs.getInt(3));
	            }
	            con.close();
	        }catch(Exception ex){ex.printStackTrace();}

	        return it;
	    }

	
}
