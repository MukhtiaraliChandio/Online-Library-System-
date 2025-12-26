package com.library.dao;

import com.library.pojo.User;

public interface UserDao {

	
	

	User ValedateUser(String emailId, String userPassword, String role);

	

	
	
}