package com.library.connection.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionJdbc {

	public ConnectionJdbc(){
		 
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver Loaded");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_system_online","root","");
			System.out.println("Connection Created");
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
    private  Connection con;
    

    private static void init() throws Exception{

    	
    }// end of static init method .

	public  Connection getCon() {
		return con;
	}
	
	

	
	
	
	
	
	
	
}