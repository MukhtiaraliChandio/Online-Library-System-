package com.library.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.library.connection.jdbc.ConnectionJdbc;
import com.library.dao.TeacherDao;
import com.library.pojo.Student;
import com.library.pojo.Teacher;
import com.library.pojo.User;
import com.mysql.*;

public class TeacherDaoImpl implements TeacherDao{

	ConnectionJdbc  db=new ConnectionJdbc();

@Override	
public int saveUserTeacherdata(String  userName, String userPassword, String role) {

	Connection con = db.getCon(); // here is call con variable from db.getCon(). connection jdbc. 
	    Student std=new Student();
		   
		String query="insert into app_user(user_name, user_password,  role) values ('"+userName+"', '"+userPassword+"', '"+role+"' ) ";
		
		//String query="insert into app_user(user_name, user_password,  role) values ('"+userName+"', '"+userPassword+"', '"+role+"') ";

		
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
public void insertTeacherdata(int userId, String firstName, String lastName, String fatherName, String surname,
		String cnic, String contactNumber, String gender, String emailId, String dateOfbirth, String department,
		String address, String userEmailid, String userPassword){
	
	Connection con = db.getCon(); // here is call con variable from db.getCon(). connection jdbc. 
    Teacher teach=new Teacher();
	   
	String query="insert into teacher(user_id, first_name, last_name, father_name,  surname, cnic, contact_no, gender,  email, date_of_birth, department, address) values ( '"+userId+"', '"+firstName+"', '"+lastName+"', '"+fatherName+"', '"+surname+"',   '"+cnic+"', '"+contactNumber+"', '"+gender+"',  '"+ emailId+"', '"+dateOfbirth+"', '"+department+"', '"+address+"' ) ";
	
    System.out.println("Query:"+query);
    Statement st=null;
    int row=0;
    try{
        
    	st=con.createStatement();
        System.out.println(teach);
        row=st.executeUpdate(query);
        if(row>=1) 
        	System.out.println("Data Save");
        else 
        	System.out.println("Data Not Save");
     
        
       //return rows;  
                
    }catch(Exception e){
    	e.printStackTrace();
    }
	
	
	
	
}// end of insertTeacherdata.

public List<Teacher> showTeacherdata() {
	
	Connection con = db.getCon(); // here is call con variable from db.getCon(). connection jdbc. 
    Teacher teachData=null;
	List<Teacher> list = new ArrayList<Teacher>();
	String sql = "select * from teacher"; /// here is write sql query? 
	System.out.print(sql);
  
	
	try {
		Statement stm = con.createStatement();
		ResultSet rs = stm.executeQuery(sql);
		
		while(rs.next()){
					    
			
			int userId=rs.getInt("user_id");
			int teacherId = rs.getInt("teacher_id");
	        String firstName=rs.getString("first_name");
			String lastName=rs.getString("last_name");
			String fatherName=rs.getString("father_name");
			String surname=rs.getString("surname");
			String cnic=rs.getString("cnic");
			String contactNo=rs.getString("contact_no");
			String gender=rs.getString("gender");
			String emailId=rs.getString("email");
			String dateOfbirth=rs.getString("date_of_birth");
			String depart=rs.getString("department");
			String address=rs.getString("address");
			
			teachData = new Teacher();
			
		    teachData.setUserId(userId);
			teachData.setTeacherId(teacherId);
			teachData.setFirstName(firstName);
			teachData.setLastName(lastName);
			teachData.setFatherName(fatherName);
			teachData.setSurname(surname);
			teachData.setCnic(cnic);
			teachData.setContactNo(contactNo);
			teachData.setGender(gender);
			teachData.setEmailId(emailId);
            teachData.setDateOfbirth(dateOfbirth);
            teachData.setDepartment(depart);
            teachData.setAddress(address);
			
			list.add(teachData);
	
	     }
	}catch(Exception e) {
		e.printStackTrace();
	}
	return list;

	
}///end of List<Teacher> showTeacherdata method.

public  Teacher getTeacherbyId(int id) {
	
	Connection con = db.getCon(); // here is call connection jdbc. 

	 Teacher teachData  = null;
    String  query = "select * from  teacher where  teacher_id="+id;
    System.out.println(query);
  		
    try {
         
  	    Statement st = con.createStatement();
  	    ResultSet rs = st.executeQuery(query);
  	    st=con.createStatement();
  	    
	        if(rs.next()){
	  	
	        	int userId = rs.getInt("user_id");
	  			int teachId = rs.getInt("teacher_id");
	  	        String firstName=rs.getString("first_name");
	  			String lastName=rs.getString("last_name");
	  			String fatherName=rs.getString("father_name");
	  			String surname=rs.getString("surname");
	  			String cnic=rs.getString("cnic");
	  			String contactNo=rs.getString("contact_no");
	  			String gender=rs.getString("gender");
	  			String emailId=rs.getString("email");
	  			String dateOfbirth=rs.getString("date_of_birth");
	  			String department=rs.getString("department");
	  			String address=rs.getString("address");
	  			
	  			teachData = new Teacher();
	  			
	  			teachData.setUserId(userId);
	  			teachData.setTeacherId(id);
	  			teachData.setFirstName(firstName);
	  			teachData.setLastName(lastName);
	  			teachData.setFatherName(fatherName);
	  			teachData.setSurname(surname);
	  			teachData.setContactNo(contactNo);
	  			teachData.setGender(gender);
	  			teachData.setCnic(cnic);
	  			teachData.setEmailId(emailId);
	  			teachData.setDateOfbirth(dateOfbirth);
	  			teachData.setDepartment(department);
	  			teachData.setAddress(address);


	        }
    }catch(Exception e) {
  	  e.printStackTrace();
    }
    
	return teachData;
	        
		
}//// end of  Teacher getTeacherbyId().
	
public List<String> getAllTeacherGendersfromTeacher() {
	Connection con = db.getCon();
    List<String> genders = new ArrayList<>();
    String query = "SELECT DISTINCT gender FROM teacher";
    System.out.println("To Show All Gender from Teacher: " + query);

    try{ 
         Statement st = con.createStatement();
         ResultSet rs = st.executeQuery(query);

        while (rs.next()) {
            genders.add(rs.getString("gender"));
        }

    } catch (Exception e) {
        e.printStackTrace();
    }
    return genders;
}


// Method to retrieve a specific user's gender (based on user_id)
public String getTeacherselectedGender(int id) {
	Connection con = db.getCon(); // here is call connection jdbc. 
    String gender = null;
    String sqlQuery = "SELECT gender FROM teacher WHERE teacher_id ='"+id+"'";
    System.out.println("To Selected gender Teacher"+sqlQuery);

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


public   int  updateTeacherdata(int userId, int id, String firstName, String lastName, String fatherName,  String surname, String cnic,
	      String contactNumber, String email,  String dateOfbirth, String department, String address) {
		
		Connection con =db.getCon();
		//Student stdData=new Student();
		 
		String query="Update teacher Set user_id='"+userId+"', first_name='"+firstName+"', last_name='"+lastName+"', surname='"+surname+"',  father_name='"+fatherName+"', cnic='"+cnic+"', contact_no='"+contactNumber+"', email='"+email+"',  department='"+department+"',   address='"+address+"'  where teacher_id='"+id+"' "; 
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

}/// end of update Teacher data.

public void deleteTeacherdataByid(int id) {
    
	Connection con = db.getCon();
	String query="delete from teacher where teacher_id="+id;
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








	
}