package com.library.dao;

import java.util.List;

import com.library.pojo.Student;
import com.library.pojo.User;

public interface StudentDao {

public int saveUserStudentdata(String  userName, String userPassword, String  role);

public User getLatestUser(); 
	
public int saveStudentdata(int userId,  String firstName, String lastName, String fatherName,  String surname, String gender,  String cnic, String contactNumber, String emailId, String  address); 


public List<Student> getAllstudentdata();	

public Student getStudentdataByid(int  id); 

public void deleteStudentdataByid(int id);


public List<String> getAllStudentGendersfromStudent();

//public String getStudentselectedGender(int stdId);

public int updateStudentdata(int userId, int stdId, String firstName, String lastName, String fatherName,
		String surname, String gender, String cnic, String contactNumber, String email, String address);

//public Student getStudentdataByid(String studentId);

public String getStudentselectedGender(int stdId);






}//// end of StudentDao.