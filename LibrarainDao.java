package com.library.dao;

import java.util.List;

import com.library.pojo.Librarain;
import com.library.pojo.User;

public interface LibrarainDao {

	
	
	
public List<Librarain> getlibrarainNamelist(); 	
	
public int saveUserLibraraintdata(String  userName, String userPassword,  String role);	
	

public User getLatestUser();


public void  insertLibraraindata(int userId, String firstName, String lastName, String fatherName,  String surname,  String cnic , String contactNumber, String gender, String  emailId,     String address);


public List<Librarain> showLibraraindata();

public  Librarain getLibrarainbyId(int id);

public List<String> getAllLibrarainGendersfromLibrarain();

public String getLibrarainselectedGender(int id);

public   int  updateLibraraindata(int id, String firstName, String lastName, String fatherName,  String surname, String cnic,
	      String contactNumber, String email,  String dateOfbirth, String department, String address); 


public void deleteLibraraindataByid(int id);







	
}