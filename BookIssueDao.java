package com.library.dao;

import java.time.LocalDate;
import java.util.List;


import com.library.pojo.BookCategory;
import com.library.pojo.BookIssue;

public interface BookIssueDao {


	

public void insertBookissueData(  String bookId, String  librarainId ,  
		 String dateOfissue, String dateOfdueDate,  String remarks);
	


public List<BookIssue> getAllBookIssueHistory();



public void updateReturnbookIssue(String bookIssueid, String returneDate, int fine, String remarks);














	
	
}