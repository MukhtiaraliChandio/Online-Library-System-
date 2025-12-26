package com.library.dao;

import java.util.List;

import com.library.pojo.Author;

public interface AuthorDao {
	



public void  insertAuthordata(String firstName, String lastName, String fatherName,  String surname,  String cnic , String contactNumber, String gender, String  emailId,   String  dateOfbirth,  String department ,  String address); 

public List<Author> showAlldataAuthor();

public  Author getAuthorbyId(int id);

public List<String> getAllAuthorGendersfromAuthor();



public String getAuthorselectedGender(int authorId);


public void  updateAuthordata(int authorId, String firstName, String lastName, String fatherName,  String surname,  String cnic , String contactNumber, String gender, String  emailId,    String address); 


public void deleteAuthordataByid(int id);



	
	
}