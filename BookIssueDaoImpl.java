package com.library.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.library.connection.jdbc.ConnectionJdbc;
import com.library.dao.BookIssueDao;
import com.library.pojo.Book;
import com.library.pojo.BookCategory;
import com.library.pojo.BookIssue;
import com.library.pojo.Student;

public class BookIssueDaoImpl implements  BookIssueDao{

	
ConnectionJdbc db = new ConnectionJdbc();// here is make obj for  ConnectionJdbc(). 


@Override
public List<BookIssue> getAllBookIssueHistory() {

	Connection con = db.getCon(); // here is call con variable from db.getCon(). connection jdbc. 

    List<BookIssue> list = new ArrayList<>();

    String sql ="SELECT bi.book_issue_id, bi.book_id, bi.librarian_id, " +
            "b.book_name, " +
            "l.first_name, l.last_name, " +
            "bi.date_of_issue, bi.due_date, bi.date_of_returne, " +
            "bi.fine, bi.remarks " +
            "FROM book_issue bi " +
            "JOIN book b ON bi.book_id = b.book_id " +
            "JOIN librarain l ON bi.librarian_id = l.librarain_id";

    try 
    {
    	Statement stm = con.createStatement();
		ResultSet rs = stm.executeQuery(sql);
    	
        while (rs.next()) {
        	 BookIssue issue = new BookIssue();

             issue.setBookIssueid(rs.getInt("book_issue_id"));
             issue.setBookId(rs.getInt("book_id"));
             issue.setLibrarianId(rs.getInt("librarian_id"));
             issue.setDateOfissue(rs.getString("date_of_issue"));
             issue.setDueDate(rs.getString("due_date"));
             issue.setDateOfreturne(rs.getString("date_of_returne"));
             issue.setFine(rs.getInt("fine"));
             issue.setRemarks(rs.getString("remarks"));

             // ⭐ From BOOK table
             issue.setBookName(rs.getString("book_name"));

             // ⭐ From LIBRARIAN table
             issue.setLibrarianFirstname(rs.getString("first_name"));
             issue.setLibrarianLastname(rs.getString("last_name"));

             list.add(issue);
        }

    } catch (Exception e) {
        e.printStackTrace();
    }

    return list;
}

	
	
	
@Override
public void insertBookissueData(  String bookId, String  librarainId ,  
		 String dateOfissue, String dateOfdueDate,  String remarks) { 

	
	Connection con = db.getCon(); // here is call con variable from db.getCon(). connection jdbc. 
   // Teacher teach=new Teacher();
	   
	String query="insert into book_issue( book_id, librarian_id , date_of_issue,   due_date,  remarks)  values ('"+bookId+"' , '"+librarainId+"',  '"+dateOfissue+"', ' "+dateOfdueDate+"',    '"+remarks+"') ";
	
    System.out.println("Query:"+query);
    Statement st=null;
    int row=0;
    try{
        
    	st=con.createStatement();
        row=st.executeUpdate(query);
        if(row>=1) 
        	System.out.println("Data Save");
        else 
        	System.out.println("Data Not Save");
     
        
       //return rows;  
                
    }catch(Exception e){
    	e.printStackTrace();
    }
	
	
	
}// end of insertTeacherdata.*/

@Override
public void updateReturnbookIssue(String bookIssueid, String returneDate, int fine, String remarks) {


	Connection con = db.getCon(); // here is call con variable from db.getCon(). connection jdbc. 
	  
	   
	String query="Update book_issue  Set  date_of_returne='"+returneDate+"',  fine='"+fine+"', remarks='"+remarks+"' where  book_issue_id='"+bookIssueid+"'  ";
    System.out.println("Query:"+query);
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
	
	
	
	
}// end of 	updateReturnbookIssue method.








}