package com.library.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.library.connection.jdbc.ConnectionJdbc;
import com.library.dao.UserDao;
import com.library.pojo.User;



public class UserDaoImpl  implements UserDao{

	ConnectionJdbc db = new ConnectionJdbc();
	User user=new User();
	
public User  ValedateUser(String emailId, String userPassword, String userRole) {
	
	Connection con = db.getCon(); // here is call connection jdbc. 


	  User userData  = null;
    String  query = "select * from app_user where  user_name='"+emailId+"' and user_password='"+userPassword +"' and  role='"+userRole+"'  ";
    System.out.println(query);
  		
    try {
         
  	    Statement st = con.createStatement();
  	    ResultSet rs = st.executeQuery(query);
  	    st=con.createStatement();
	       if(rs.next()){
	        	int userId = rs.getInt("id");
	  	        String useremailId=rs.getString("user_name");
	  			String password=rs.getString("user_password");
	  			String role=rs.getString("role");
	  		    
	  			userData= new  User();
	  	        userData.setUserid(userId);
	            userData.setEmailId(useremailId);
	            userData.setUserPassword(password);
	  			userData.setRole(role);
	            
	        }
	        
    }catch(Exception e) {
  	  
  	  e.printStackTrace();
    }
	        
	        
	
	
	
	
	
	
	return userData;
	
	
	
}



/*public User  loginStudent(String emailId, String userPassword ) {
	
	Connection con = db.getCon(); // here is call connection jdbc. 

	  User userData  = null;
      String  query = "select * from user where email_id='"+emailId+"' and user_password='"+userPassword +"' ";
      System.out.println(query);
    		
      try {
           
    	    Statement st = con.createStatement();
    	    ResultSet rs = st.executeQuery(query);
    	    st=con.createStatement();
  	        if(rs.next()){
  	        	int userId = rs.getInt("user_id");
  	  	        String useremailId=rs.getString("email_id");
  	  			String password=rs.getString("user_password");
  	  			
  	  		   userData= new  User();
  	  	       userData.setUserid(userId);
  	           userData.setEmailId(useremailId);
  	           userData.setUserPassword(password);
  	  			
  	        }
  	        
      }catch(Exception e) {
    	  
    	  e.printStackTrace();
      }
  	        
  	        
	
	
	
	
	return userData;
	
	
	
}*/

	
	
}