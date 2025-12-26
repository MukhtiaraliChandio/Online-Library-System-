package com.library.dao;

import java.util.List;

import com.library.pojo.Teacher;
import com.library.pojo.User;

public interface TeacherDao {

 
	
public int saveUserTeacherdata(String  userName, String userPassword, String role);
	  
public User getLatestUser(); 	

public List<Teacher> showTeacherdata();
  
public  Teacher getTeacherbyId(int id);
  
public List<String> getAllTeacherGendersfromTeacher();
  
public String getTeacherselectedGender(int id);
  
public void deleteTeacherdataByid(int id);

public void  insertTeacherdata(int userId, String firstName, String lastName, String fatherName,  String surname,  String cnic , String contactNumber, String gender, String  emailId,   String  dateOfbirth,  String department ,  String address, String userEmailid, String userPassword);


public int updateTeacherdata(int userId, int teachId, String firstName, String lastName, String fatherName,
		String surname, String cnic, String contactNumber, String emailId, String dateOfbirth, String depart,
		String address);
  
  
  

}