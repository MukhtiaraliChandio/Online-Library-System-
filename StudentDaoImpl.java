package com.library.dao.impl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.library.connection.jdbc.ConnectionJdbc;
import com.library.dao.StudentDao;
import com.library.pojo.Student;
import com.library.pojo.User;

public class StudentDaoImpl implements StudentDao{

ConnectionJdbc db = new ConnectionJdbc();// here is make obj for  ConnectionJdbc().

@Override	
public int saveUserStudentdata(String  userName, String userPassword,  String role) {

Connection con = db.getCon(); // here is call con variable from db.getCon(). connection jdbc. 
    Student std=new Student();
	   
	String query="insert into app_user(user_name, user_password,  role) values ('"+userName+"', '"+userPassword+"', '"+role+"') ";
	
    System.out.println(query);
    Statement st=null;
    int row=0;
    try{
        st=con.createStatement();
        System.out.println(std);
        row=st.executeUpdate(query);
        if(row>=1) 
        	System.out.println("Data Save");
        else 
        	System.out.println("Data Not Save");
     
        
       //return rows;  
                
    }catch(Exception e){
    	e.printStackTrace();
    }
	return row;
	

}// end of userData save method.

@Override	
public User getLatestUser() {
	
	Connection con = db.getCon(); // here is call con variable from db.getCon(). connection jdbc. 

    User user = null;
    String sql = "SELECT * FROM app_user ORDER BY id DESC LIMIT 1";  // assuming 'id' is primary key

    try {
    	
    
         Statement stmt = con.createStatement();
         ResultSet rs = stmt.executeQuery(sql); 
        		 

        if (rs.next()) {
        	
            user = new User();
            user.setUserid(rs.getInt("id"));
        
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return user;
}


	
@Override	
public int saveStudentdata(int userId,  String firstName, String lastName, String fatherName,  String surname, String gender,  String cnic, String contactNumber, String emailId, String  address) {

	Connection con = db.getCon(); // here is call con variable from db.getCon(). connection jdbc. 
	    Student std=new Student();
		   
		String query="insert into student(user_id,first_name, last_name, father_name, surname, gender,  cnic, contact_number, email_id, address) values ( "+userId+", '"+firstName+"', '"+lastName+"', '"+fatherName+"', '"+surname+"',  '"+gender+"',  '"+cnic+"', '"+contactNumber+"', '"+ emailId+"', '"+address+"' ) ";
		
	    System.out.println(query);
	    Statement st=null;
	    int row=0;
	    try{
	        st=con.createStatement();
	        System.out.println(std);
	        row=st.executeUpdate(query);
	        if(row>=1) 
	        	System.out.println("Data Save");
	        else 
	        	System.out.println("Data Not Save");
	     
	        
	       //return rows;  
	                
	    }catch(Exception e){
	    	e.printStackTrace();
	    }
		return row;
		

}// end of student save method.



@Override
public List<Student> getAllstudentdata(){

	Connection con = db.getCon(); // here is call con variable from db.getCon(). connection jdbc. 
    Student std=null;
	List<Student> list = new ArrayList<Student>();
	String sql = "select * from student"; /// here is write sql query? 
	System.out.print(sql);
  
	
	try {
		Statement stm = con.createStatement();
		ResultSet rs = stm.executeQuery(sql);
		
		while(rs.next()){
					    
			int userId = rs.getInt("user_id");
			int stdId = rs.getInt("std_id");
	        String firstName=rs.getString("first_name");
			String lastName=rs.getString("last_name");
			String fatherName=rs.getString("father_name");
			String surname=rs.getString("surname");
			String gender=rs.getString("gender");
			String cnic=rs.getString("cnic");
			String contactNo=rs.getString("contact_number");
			String emailId=rs.getString("email_id");			
			String address=rs.getString("address");
			std = new Student();
			
			std.setUserId(userId);
			std.setStdId(stdId);
			std.setFirstName(firstName);
			std.setLastName(lastName);
			std.setFatherName(fatherName);
			std.setSurname(surname);
			std.setGender(gender);
			std.setCnic(cnic);
			std.setContactNo(contactNo);
			std.setEmailId(emailId);
			std.setAddress(address);
			
			list.add(std);
	
	     }
	}catch(Exception e) {
		e.printStackTrace();
	}
	return list;
	
}/// end of List<Student> getAllstudentdata() method.




@Override
public Student getStudentdataByid(int  id) {
	
	Connection con = db.getCon(); // here is call connection jdbc. 

	  Student stdData  = null;
      String  query = "select * from student where std_id="+id;
      System.out.println(query);
    		
      try {
           
    	    Statement st = con.createStatement();
    	    ResultSet rs = st.executeQuery(query);
    	    st=con.createStatement();
    	    
  	        if(rs.next()){
  	        	
  	      	    int userId = rs.getInt("user_id");
	  			int stdId = rs.getInt("std_id");
	  	        String firstName=rs.getString("first_name");
	  			String lastName=rs.getString("last_name");
	  			String fatherName=rs.getString("father_name");
	  			String surname=rs.getString("surname");
	  			String gender=rs.getString("gender");
	  			String cnic=rs.getString("cnic");
	  			String contactNo=rs.getString("contact_number");
	  			String emailId=rs.getString("email_id");
	  			String address=rs.getString("address");
	  			
	  			stdData = new Student();
	  			
	  			stdData.setUserId(userId);
	  			stdData.setStdId(stdId);
	  			stdData .setFirstName(firstName);
	  			stdData .setLastName(lastName);
	  			stdData.setFatherName(fatherName);
	  			stdData.setSurname(surname);
	  			stdData.setGender(gender);
	  			stdData.setContactNo(contactNo);
	  			stdData.setCnic(cnic);
	  			stdData.setEmailId(emailId);
	  			stdData.setAddress(address);


  	        }
      }catch(Exception e) {
    	  e.printStackTrace();
      }
      
	return stdData;
  	        
  	        
}/// end of Student  getStudentdataByid(String  id) by id method.

public List<String> getAllStudentGendersfromStudent() {
	
	Connection con = db.getCon(); // here is call connection jdbc. 

	 //Teacher teachData  = null;
    List<String> genders = new ArrayList<>();
    String query = "SELECT DISTINCT gender FROM student";  // Assuming gender values like 'Male', 'Female', etc.
    System.out.println("To Show All Gender from Student"+query);
    
    try  {
    	   Statement st = con.createStatement();
     	    ResultSet rs = st.executeQuery(query);
     	    st=con.createStatement();
        while (rs.next()) {
            genders.add(rs.getString("gender"));
        }
    } catch (Exception e) {
        e.printStackTrace(); // Handle errors properly in production code
    }
    return genders;


}

// Method to retrieve a specific user's gender (based on user_id)
public String getStudentselectedGender(int id) {
	Connection con = db.getCon(); // here is call connection jdbc. 
    String gender = null;
    String sqlQuery = "SELECT gender FROM student WHERE std_id='"+id+"'";
    System.out.println("To Selected gender Student"+sqlQuery);

    try {
        
    	 Statement st = con.createStatement();
  	    ResultSet rs = st.executeQuery(sqlQuery);
  	    st=con.createStatement();

        if (rs.next()) {
            gender = rs.getString("gender");
        }
    } catch (Exception e) {
        e.printStackTrace(); // Handle errors properly in production code
    }
    return gender;
}




public   int  updateStudentdata(int userId, int id, String firstName, String lastName, String fatherName, String gender,  String surname, String cnic,
		      String contactNumber, String email, String address) {

	Connection con =db.getCon();
	//Student stdData=new Student();
	   
	String query="Update student Set user_id='"+userId+"', first_name='"+firstName+"', last_name='"+lastName+"', father_name='"+fatherName+"', surname='"+surname+"',  gender='"+gender+"' , cnic='"+cnic+"', contact_number='"+contactNumber+"', email_id='"+email+"', address='"+address+"'  where std_id='"+id+"' "; 
    System.out.println("UpdateQuery:"+query);
    Statement st=null;
    int row=0;
    try{
        st=con.createStatement();
       // System.out.println(stdData);
        row=st.executeUpdate(query);
        if(row>=1) 
           System.out.println("Data Update");
        else 
        	System.out.println("Data Not Update");
     
        
       //return rows;  
                
    }catch(Exception e){
    	e.printStackTrace();
    }
	return row;
	
}/// end of update updateStudentdata.


public void deleteStudentdataByid(int id) {
     
	Connection con = db.getCon();
	String query="delete from student where std_id="+id;
    System.out.println(query);

	Statement st=null;
	int row=0;
	try{
		
		  st=con.createStatement();
		  row=st.executeUpdate(query);
		  if(row>=1) 
		   System.out.println("Data Delete");
		   else 
		    System.out.println("Data Not Delete");
		     

		}catch(Exception e){
			e.printStackTrace();
		}
		
	
}
/////////////////////// end of delete code //////////////////////////////////////////////////



























}// end of Student dao impl class.
      