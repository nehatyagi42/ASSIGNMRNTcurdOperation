package com.rtpl.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.rtpl.bean.User;

public class UserDao {
	public static Connection getConnection(){  
	    Connection con=null;  
	    try{  
	        Class.forName("com.mysql.jdbc.Driver");  
	        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/rtpl","root","root");  
	    }catch(Exception e){System.out.println(e);}  
	    return con;  
	}  
	
	//for inserting the data in database
		public static int save(User user){  
		    int status=0;  
		    try{  
		        Connection con=getConnection();  
		        PreparedStatement ps=con.prepareStatement(  
		"insert into register(name,password,email,sex,country) values(?,?,?,?,?)"); 
		     ps.setString(1, user.getName());
		        ps.setString(2, user.getEmail());
		        ps.setString(3, user.getPassword());
		        ps.setString(4, user.getSex());
		        ps.setString(5, user.getCountry());
				status=ps.executeUpdate();
			} catch (Exception e) {
				System.out.println(e);
				
			}
					return status;
		}
		/*********************************************************/
		
		
	// Update the data
		public static int update(User user){
			int status=0;
			try {
				 Connection con=getConnection();  
			        PreparedStatement ps=con.prepareStatement(  
			"update register set name=?,password=?,email=?,sex=?,country=? where id=?");
			        ps.setString(1, user.getName());
			        ps.setString(2, user.getEmail());
			        ps.setString(3, user.getPassword());
			        ps.setString(4, user.getSex());
			        ps.setString(5, user.getCountry());
			        ps.setInt(6,user.getId());  
					status=ps.executeUpdate();
			}catch (Exception e) {
				System.out.println(e);
			}
			return status; 
		}
	/*	**********************************************************/
		
			//Delete the data
			public static int delete(User user){  
			    int status=0;  
			    try{  
			        Connection con=getConnection();  
			        PreparedStatement ps=con.prepareStatement("delete from register where id=?");  
			ps.setInt(1, user.getId());
			status=ps.executeUpdate();  
			    }catch (Exception e) {
			    	System.out.println(e);
				}
				return status;
		}
		//List
			public static List<User>getAllRecords(){
				List<User>list=new ArrayList<User>();
				try {
					 Connection con=getConnection();  
				        PreparedStatement ps=con.prepareStatement("select * from register");  
				        ResultSet rs=ps.executeQuery();  
				        while (rs.next()) {
							User user=new User();
							user.setId(rs.getInt("id"));
							user.setEmail(rs.getString("name"));
							user.setCountry(rs.getString("country"));
							user.setName(rs.getString("name"));
							user.setPassword(rs.getString("password"));
							user.setSex(rs.getString("sex"));
							list.add(user);	
						}
				}catch (Exception e) {
				System.out.println(e);
				}
				System.out.println(list);
				return list;
		
			}
			
	/*	**************************************************/	
			public static User getRecordById(int id){
				User user=null;  
				try{  
			        Connection con=getConnection();  
			        PreparedStatement ps=con.prepareStatement("select * from register where id=?");  
			        ps.setInt(1,id);  
			        ResultSet rs=ps.executeQuery();
			        while(rs.next()){  
				user=new User();
				user.setId(rs.getInt("id"));
				user.setEmail(rs.getString("name"));
				user.setCountry(rs.getString("country"));
				user.setName(rs.getString("name"));
				user.setPassword(rs.getString("password"));
				user.setSex(rs.getString("sex"));
			        }
			        
					}catch (Exception e) {
						System.out.println(e);
				}
			
			return user;
	}
	//************************************************************//*	
	
}
