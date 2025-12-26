package com.library.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.library.connection.jdbc.ConnectionJdbc;
import com.library.dao.MemberDao;
import com.library.pojo.Member;
import com.library.pojo.Student;
import com.library.pojo.Teacher;

public class MemberDaoImpl implements MemberDao {

	
	ConnectionJdbc  db=new ConnectionJdbc();


@Override	
public void  insertMemberdata(String stdId, String teacherId,   String memberType,   String firstName, String lastName,  String fatherName, String surname,
		String cnic, String contactNumber, String gender, String emailId, String address) {
	
	Connection con = db.getCon(); // here is call con variable from db.getCon(). connection jdbc. 
    Teacher teach=new Teacher();
	   
	String query="insert into member(std_id, teacher_id, member_type, first_name,  last_name,  father_name,  surname, contact_number, cnic,  email_id,  gender , address) values"
			+ " (  "+stdId+",  "+teacherId+",  '"+memberType+"',  '"+firstName+"' , '"+lastName+"', '"+fatherName+"',  '"+surname+"', '"+cnic+"',   '"+contactNumber+"', '"+gender+"', '"+emailId+"',  '"+address+"') ";
	
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




}