package com.library.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.library.connection.jdbc.ConnectionJdbc;
import com.library.dao.AuthorDao;
import com.library.pojo.Author;
import com.library.pojo.Teacher;


public class AuthorDaoImpl implements AuthorDao{

	ConnectionJdbc  db=new ConnectionJdbc();


@Override
public void  insertAuthordata(String firstName, String lastName, String fatherName,  String surname,  String cnic , String contactNumber, String gender, String  emailId,   String  dateOfbirth,  String department ,  String address) {
	
	Connection con = db.getCon(); // here is call con variable from db.getCon(). connection jdbc. 
    Author author=new Author();
	   
	String query="insert into author(first_name, last_name, father_name,  surname,  contact_number, cnic,   email_id, gender , address) values ('"+firstName+"', '"+lastName+"', '"+fatherName+"', '"+surname+"',   '"+cnic+"', '"+contactNumber+"', '"+ emailId+"', '"+gender+"', '"+address+"' ) ";
	
    System.out.println("Query:"+query);
    Statement st=null;
    int row=0;
    try{
        
    	st=con.createStatement();
        System.out.println(author);
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

@Override
public List<Author> showAlldataAuthor() {
	
	Connection con = db.getCon(); // here is call con variable from db.getCon(). connection jdbc. 
    Author authorData=null;
	List<Author> list = new ArrayList<Author>();
	String sql = "select * from  author"; /// here is write sql query? 
	System.out.print(sql);
  
	
	try {
		Statement stm = con.createStatement();
		ResultSet rs = stm.executeQuery(sql);
		
		while(rs.next()){
					    
			
			int authorId = rs.getInt("author_id");
			//int userId=rs.getInt("user_id");
	        String firstName=rs.getString("first_name");
			String lastName=rs.getString("last_name");
			String fatherName=rs.getString("father_name");
			String surname=rs.getString("surname");
			String cnic=rs.getString("cnic");
			String contactNo=rs.getString("contact_number");
			String gender=rs.getString("gender");
			String emailId=rs.getString("email_id");
		
			String address=rs.getString("address");
			
			authorData = new Author();
			
			authorData.setAuthorId(authorId);
			//teachData.setUserId(userId);
			authorData.setFirstName(firstName);
			authorData.setLastName(lastName);
			authorData.setFatherName(fatherName);
			authorData.setSurname(surname);
			authorData.setCnic(cnic);
			authorData.setContactNo(contactNo);
			authorData.setGender(gender);
			authorData.setEmailId(emailId);
    
            authorData.setAddress(address);
			
			list.add(authorData);
	
	     }
	}catch(Exception e) {
		e.printStackTrace();
	}
	return list;

	
}///end of List<Teacher> showTeacherdata method.
	


@Override
public  Author getAuthorbyId(int id) {
	
	Connection con = db.getCon(); // here is call connection jdbc. 

	 Author  authorData  = null;
    String  query = "select * from  author where  author_id="+id;
    System.out.println(query);
  		
    try {
         
  	    Statement st = con.createStatement();
  	    ResultSet rs = st.executeQuery(query);
  	    st=con.createStatement();
  	    
	        if(rs.next()){
	  	
	        	//int userId = rs.getInt("user_id");
	  			int authorId = rs.getInt("author_id");
	  	        String firstName=rs.getString("first_name");
	  			String lastName=rs.getString("last_name");
	  			String fatherName=rs.getString("father_name");
	  			String surname=rs.getString("surname");
	  			String cnic=rs.getString("cnic");
	  			String contactNo=rs.getString("contact_number");
	  			
	  			String emailId=rs.getString("email_id");
	  			String gender=rs.getString("gender");
	  			String address=rs.getString("address");
	  			
	  			authorData = new  Author();
	  			
	  			authorData.setAuthorId(authorId);
	  			
	  			authorData.setFirstName(firstName);
	  			authorData.setLastName(lastName);
	  			authorData.setFatherName(fatherName);
	  			authorData.setSurname(surname);
	  			authorData.setContactNo(contactNo);
	  		    authorData.setCnic(cnic);
	  			authorData.setEmailId(emailId);
	  			authorData.setGender(gender);
	  			authorData.setAddress(address);


	        }
    }catch(Exception e) {
  	  e.printStackTrace();
    }
    
	return authorData;
	        
		
}//// end of  Teacher getTeacherbyId().
	


@Override
public List<String> getAllAuthorGendersfromAuthor() {
	
	Connection con = db.getCon(); // here is call connection jdbc. 

	 //Teacher teachData  = null;
    List<String> genders = new ArrayList<>();
    String query = "SELECT DISTINCT gender FROM author";  // Assuming gender values like 'Male', 'Female', etc.
    System.out.println("To Show All Gender from Author"+query);
    
    try  {
    	   Statement st = con.createStatement();
     	    ResultSet rs = st.executeQuery(query);
     	    st=con.createStatement();
        if (rs.next()) {
            genders.add(rs.getString("gender"));
        }
    } catch (Exception e) {
        e.printStackTrace(); // Handle errors properly in production code
    }
    return genders;


}

// Method to retrieve a specific user's gender (based on user_id)
public String getAuthorselectedGender(int id) {
	Connection con = db.getCon(); // here is call connection jdbc. 
    String gender = null;
    String sqlQuery = "SELECT gender FROM author WHERE author_id ='"+id+"'";
    System.out.println("To Selected gender Author"+sqlQuery);

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



public void  updateAuthordata(int authorId, String firstName, String lastName, String fatherName,  String surname,  String cnic , String contactNumber, String gender, String  emailId,    String address) {
	
	Connection con = db.getCon(); // here is call con variable from db.getCon(). connection jdbc. 
    Author author=new Author();
	   
    String query="Update author Set  first_name='"+firstName+"', last_name='"+lastName+"', surname='"+surname+"',  father_name='"+fatherName+"', cnic='"+cnic+"', contact_number='"+contactNumber+"', email_id='"+emailId+"',    address='"+address+"'  where author_id='"+authorId+"' "; 
    System.out.println("UpdateQuery:"+query);
    Statement st=null;
    int row=0;
    try{
        
    	st=con.createStatement();
        System.out.println(author);
        row=st.executeUpdate(query);
        if(row>=1) 
        	System.out.println("Data Update");
        else 
        	System.out.println("Data Not Update");
     
        
       //return rows;  
                
    }catch(Exception e){
    	e.printStackTrace();
    }
	
	
	
	
}// end of update Author data.


public void deleteAuthordataByid(int id) {
    
	Connection con = db.getCon();
	String query="delete from author where author_id="+id;
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