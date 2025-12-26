package com.library.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.library.connection.jdbc.ConnectionJdbc;
import com.library.dao.LibrarainDao;
import com.library.pojo.Author;
import com.library.pojo.Librarain;
import com.library.pojo.Student;
import com.library.pojo.Teacher;
import com.library.pojo.User;

public class LibrarainDaoImpl  implements  LibrarainDao{

	ConnectionJdbc  db=new ConnectionJdbc();

@Override
public List<Librarain> getlibrarainNamelist() {
	 	
	     Connection con = db.getCon(); // here is call con variable from db.getCon(). connection jdbc. 

	     List<Librarain> lib = new ArrayList<>();
	     String sql = "SELECT * FROM  librarain";

	   
	   try{
	     	Statement stm = con.createStatement();
	 		ResultSet rs = stm.executeQuery(sql);
	         while (rs.next()) {
	        	 
	        	 
	        	 Librarain librarain = new Librarain();
	            
	        	 librarain.setLibrarainId(rs.getInt("librarain_id"));
	        	 librarain.setFirstName(rs.getString("first_name"));
	        	 librarain.setLastName(rs.getString("last_name"));
	        	 
	        	 lib.add(librarain);
	        	 
	         }

	     } catch (Exception e) {
	         e.printStackTrace();
	     }

	     return lib;
	     
	     
}// end of method.	
		
	
	
@Override	
public int saveUserLibraraintdata(String  userName, String userPassword,  String role) {

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


public void  insertLibraraindata(int userId, String firstName, String lastName, String fatherName,  String surname,  String cnic , String contactNumber, String gender, String  emailId,     String address) {
		
		Connection con = db.getCon(); // here is call con variable from db.getCon(). connection jdbc. 
	   // Teacher teach=new Teacher();
		   
		String query="insert into librarain(user_id,  first_name, last_name, father_name,  surname, cnic, contact_number, gender,  email_id,  address) values ('"+userId+"',  '"+firstName+"', '"+lastName+"', '"+fatherName+"', '"+surname+"',   '"+cnic+"', '"+contactNumber+"', '"+gender+"',  '"+ emailId+"',  '"+address+"' ) ";
		
	    System.out.println("Query:"+query);
	    Statement st=null;
	    int row=0;
	    try{
	        
	    	st=con.createStatement();
	     //   System.out.println(teach);
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

public List<Librarain> showLibraraindata() {
	
	Connection con = db.getCon(); // here is call con variable from db.getCon(). connection jdbc. 
    Librarain libData=null;
	List<Librarain> list = new ArrayList<Librarain>();
	String sql = "select * from librarain"; /// here is write sql query? 
	System.out.print(sql);
  
	
	try {
		Statement stm = con.createStatement();
		ResultSet rs = stm.executeQuery(sql);
		
		while(rs.next()){
					    
			
			int librarainId = rs.getInt("librarain_id");
			
	        String firstName=rs.getString("first_name");
			String lastName=rs.getString("last_name");
			String fatherName=rs.getString("father_name");
			String surname=rs.getString("surname");
			String cnic=rs.getString("cnic");
			String contactNo=rs.getString("contact_number");
			String gender=rs.getString("gender");
			String emailId=rs.getString("email_id");
			String address=rs.getString("address");
			
			libData = new Librarain();
			
			libData.setLibrarainId(librarainId);
		
			libData.setFirstName(firstName);
			libData.setLastName(lastName);
			libData.setFatherName(fatherName);
			libData.setSurname(surname);
			libData.setCnic(cnic);
			libData.setContactNumber(contactNo);
			libData.setGender(gender);
			libData.setEmailId(emailId);
         
			libData.setAddress(address);
			
			list.add(libData);
	
	     }
	}catch(Exception e) {
		e.printStackTrace();
	}
	return list;

	
}///end of List<Teacher> showTeacherdata method.

public  Librarain getLibrarainbyId(int id) {
	
	Connection con = db.getCon(); // here is call connection jdbc. 

	 Librarain libData  = null;
    String  query = "select * from  librarain where librarain_id="+id;
    System.out.println(query);
  		
    try {
         
  	    Statement st = con.createStatement();
  	    ResultSet rs = st.executeQuery(query);
  	    st=con.createStatement();
  	    
	        if(rs.next()){
	  	
	  			int libId = rs.getInt("librarain_id");
	  	        String firstName=rs.getString("first_name");
	  			String lastName=rs.getString("last_name");
	  			String fatherName=rs.getString("father_name");
	  			String surname=rs.getString("surname");
	  			String cnic=rs.getString("cnic");
	  			String contactNo=rs.getString("contact_number");
	  			String gender=rs.getString("gender");
	  			String emailId=rs.getString("email_id");
	  			String address=rs.getString("address");
	  			
	  			libData = new Librarain();
	  			
	  			libData.setLibrarainId(libId);
	  			libData.setFirstName(firstName);
	  			libData.setLastName(lastName);
	  			libData.setFatherName(fatherName);
	  			libData.setSurname(surname);
	  			libData.setContactNumber(contactNo);
	  			libData.setGender(gender);
	  			libData.setCnic(cnic);
	  			libData.setEmailId(emailId);
	  			//teachData.setDateOfbirth(dateOfbirth);
	  			//teachData.setDepartment(department);
	  			libData.setAddress(address);


	        }
    }catch(Exception e) {
  	  e.printStackTrace();
    }
    
	return libData;
	        
		
}//// end of  Teacher getTeacherbyId().
	
public List<String> getAllLibrarainGendersfromLibrarain() {
	
	Connection con = db.getCon(); // here is call connection jdbc. 

	 //Teacher teachData  = null;
    List<String> genders = new ArrayList<>();
    String query = "SELECT DISTINCT gender FROM librarain";  // Assuming gender values like 'Male', 'Female', etc.
    System.out.println("To Show All Gender from Librarain"+query);
    
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
public String getLibrarainselectedGender(int id) {
	Connection con = db.getCon(); // here is call connection jdbc. 
    String gender = null;
    String sqlQuery = "SELECT gender FROM librarain WHERE librarain_id='"+id+"'";
    System.out.println("To Selected gender Librarain"+sqlQuery);

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

public   int  updateLibraraindata(int id, String firstName, String lastName, String fatherName,  String surname, String cnic,
	      String contactNumber, String email,  String dateOfbirth, String department, String address) {
			
			Connection con =db.getCon();
			//Student stdData=new Student();
			
			String query="Update librarain Set first_name='"+firstName+"', last_name='"+lastName+"', surname='"+surname+"',  father_name='"+fatherName+"', cnic='"+cnic+"', contact_number='"+contactNumber+"', email_id='"+email+"',  address='"+address+"'  where librarain_id='"+id+"' "; 
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


public void deleteLibraraindataByid(int id) {
    
	Connection con = db.getCon();
	String query="delete from librarain where librarain_id="+id;
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


	
}// end of LibrarainDaoImpl class.