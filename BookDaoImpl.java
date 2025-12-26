package com.library.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.library.connection.jdbc.ConnectionJdbc;
import com.library.dao.BookDao;
import com.library.pojo.Author;
import com.library.pojo.Book;
import com.library.pojo.BookCategory;
import com.library.pojo.Librarain;
import com.library.pojo.User;

public class BookDaoImpl implements BookDao{

	
 ConnectionJdbc  db=new ConnectionJdbc();

 Connection con = db.getCon(); // here is call con variable from db.getCon(). connection jdbc. 


 @Override
 public List<Book> searchBooks(String keyword) {

     List<Book> list = new ArrayList<>();

     String sql = "SELECT * FROM book WHERE book_name LIKE '%" + keyword +
             "%' OR author_editor LIKE '%" + keyword + "%'";

   try{
    	 Statement stm = con.createStatement();
	 	 ResultSet rs = stm.executeQuery(sql);

	 

 

         while (rs.next()) {
             Book bookData = new Book();
            
         	int authorId = rs.getInt("author_id");
			int bookId = rs.getInt("book_id");
			int categoryId=rs.getInt("category_id");
			String BookName=rs.getString("book_name");
			String language=rs.getString("language");
			String authorEditor=rs.getString("author_editor");
			String editorVolume=rs.getString("editor_volume");
			String  yearOfpublishing=rs.getString("year_of_publishing");
			String isbn=rs.getString("isbn");
			String noOfpages=rs.getString("number_of_pages");
			String remarks=rs.getString("remarks");
			
			bookData = new Book();
			
			bookData.setAuthorId(authorId);
			bookData.setBookId(bookId);
			bookData.setCategoryId(categoryId);

			bookData.setBookName(BookName);
			bookData.setLanguage(language);
			bookData.setAuthorEditor(authorEditor);
			bookData.setIsbn(isbn);
			bookData.setEditorVolume(editorVolume);
			bookData.setNumberOfpages(noOfpages);
			bookData.setYearOfpublishing(yearOfpublishing);
			bookData.setRemarks(remarks);
		
             list.add(bookData);
         }

     } catch (Exception e) {
         e.printStackTrace();
     }

     return list;
 
 
 }// end of method. 
@Override
public List<Book> getbookNamelist() {
	 	
	     Connection con = db.getCon(); // here is call con variable from db.getCon(). connection jdbc. 

	     List<Book> books = new ArrayList<>();
	     String sql = "SELECT * FROM  book";

	   
	   try{
	     	Statement stm = con.createStatement();
	 		ResultSet rs = stm.executeQuery(sql);
	         while (rs.next()) {
	        	 
	        	 
	        	 Book book = new Book();
	            
	        	 book.setBookId(rs.getInt("book_id"));
	        	 book.setBookName(rs.getString("book_name"));
	        	 
	        	 books.add(book);
	        	 
	         }

	     } catch (Exception e) {
	         e.printStackTrace();
	     }

	     return books;
	     
	     
}// end of method.	
		
	
 
 
 @Override
 public List<Author> getAllAuthors() {
 	
     Connection con = db.getCon(); // here is call con variable from db.getCon(). connection jdbc. 

     List<Author> authors = new ArrayList<>();
     String sql = "SELECT * FROM author";

   
   try{
     	Statement stm = con.createStatement();
 		ResultSet rs = stm.executeQuery(sql);
         while (rs.next()) {
             Author author = new Author();
             author.setAuthorId(rs.getInt("author_id"));
             author.setFirstName(rs.getString("first_name"));
             author.setLastName(rs.getString("last_name"));
             authors.add(author);
         }

     } catch (Exception e) {
         e.printStackTrace();
     }

     return authors;
 }
 
 
 
@Override
public void insertBookdata(int authorId, int bookCategoryId,  String bookName, String language, String authorEditor,
			String editorVolume, String yearOfpublishing, String isbn, String noOfpages, String remarks) {
		
		
		Connection con = db.getCon(); // here is call con variable from db.getCon(). connection jdbc. 
	   // Teacher teach=new Teacher();
		   
		String query="insert into book( author_id, category_id ,  book_name, language, author_editor, editor_volume, year_of_publishing, isbn,  number_of_pages,  remarks) values ('"+authorId+"',  '"+bookCategoryId+"',   '"+bookName+"', '"+language+"', '"+authorEditor+"', '"+editorVolume+"',  '"+yearOfpublishing+"',   '"+isbn+"', '"+noOfpages+"', '"+remarks+"') ";
		
	    System.out.println("Query:"+query);
	    Statement st=null;
	    int row=0;
	    try{
	        
	    	st=con.createStatement();
	     //   System.out.println(teach);
	        row=st.executeUpdate(query);
	        if(row>=1) 
	        	System.out.println("Data Save");
	        else 
	        	System.out.println("Data Not Save");
	     
	        
	       //return rows;  
	                
	    }catch(Exception e){
	    	e.printStackTrace();
	    }
		
		
		
	}



@Override	
public List<Book> geAllbookData() {
	
	Connection con = db.getCon(); // here is call con variable from db.getCon(). connection jdbc. 
    Book bookData=null;
	List<Book> list = new ArrayList<Book>();
	String sql = "select * from book"; /// here is write sql query? 
	System.out.print(sql);
  
	
	try {
		Statement stm = con.createStatement();
		ResultSet rs = stm.executeQuery(sql);
		
		while(rs.next()){
					    
			int authorId = rs.getInt("author_id");
			int bookId = rs.getInt("book_id");
			int categoryId=rs.getInt("category_id");
			String BookName=rs.getString("book_name");
			String language=rs.getString("language");
			String authorEditor=rs.getString("author_editor");
			String editorVolume=rs.getString("editor_volume");
			String  yearOfpublishing=rs.getString("year_of_publishing");
			String isbn=rs.getString("isbn");
			String noOfpages=rs.getString("number_of_pages");
			String remarks=rs.getString("remarks");
			
			bookData = new Book();
			
			bookData.setAuthorId(authorId);
			bookData.setBookId(bookId);
			bookData.setCategoryId(categoryId);

			bookData.setBookName(BookName);
			bookData.setLanguage(language);
			bookData.setAuthorEditor(authorEditor);
			bookData.setIsbn(isbn);
			bookData.setEditorVolume(editorVolume);
			bookData.setNumberOfpages(noOfpages);
			bookData.setYearOfpublishing(yearOfpublishing);
			bookData.setRemarks(remarks);
		
			
			list.add(bookData);
	
	     }
	}catch(Exception e) {
		e.printStackTrace();
	}
	return list;

	
}///end of List<Teacher> showTeacherdata method.
@Override	
public  Book getBookbyId(int id) {
	
	Connection con = db.getCon(); // here is call connection jdbc. 

	   Book bookData=null;
    String  query = "select * from  book where book_id="+id;
    System.out.println(query);
	
	try {
		Statement stm = con.createStatement();
		ResultSet rs = stm.executeQuery(query);
		
		while(rs.next()){
					    
			int authorId = rs.getInt("author_id");
			int bookId = rs.getInt("book_id");
			int categoryId=rs.getInt("category_id");
			//String )
			String BookName=rs.getString("book_name");
			String language=rs.getString("language");
			String authorEditor=rs.getString("author_editor");
			String editorVolume=rs.getString("editor_volume");
			String  yearOfpublishing=rs.getString("year_of_publishing");
			String isbn=rs.getString("isbn");
			String noOfpages=rs.getString("number_of_pages");
			String remarks=rs.getString("remarks");
			
			bookData = new Book();
			
			bookData.setAuthorId(authorId);
			bookData.setBookId(bookId);
			bookData.setCategoryId(categoryId);
			bookData.setBookName(BookName);
			bookData.setLanguage(language);
			bookData.setAuthorEditor(authorEditor);
			bookData.setIsbn(isbn);
			bookData.setEditorVolume(editorVolume);
			bookData.setNumberOfpages(noOfpages);
			bookData.setYearOfpublishing(yearOfpublishing);
			bookData.setRemarks(remarks);
		
			
			
	
	     }
	}catch(Exception e) {
		e.printStackTrace();
	}
	return bookData;
  		
}
public void  updateookdata(int authorId, int bookId, String bookName, String language, String authorEditor,  String editorVolume,  String yearOfpublishing,  String isbn,  String noOfpages,  String  remarks) {
	
	Connection con = db.getCon(); // here is call con variable from db.getCon(). connection jdbc. 
  
	   
	String query="Update book Set author_id='"+authorId+"', book_name='"+bookName+"', language='"+language+"',  author_editor='"+authorEditor+"', editor_volume='"+editorVolume+"', year_of_publishing='"+yearOfpublishing+"', isbn='"+isbn+"', number_of_pages='"+noOfpages+"', remarks='"+remarks+"' where book_id='"+bookId+"'  ";
    System.out.println("Query:"+query);
    Statement st=null;
    int row=0;
    try{
        
    	st=con.createStatement();
    	row=st.executeUpdate(query);
    	if(row>=1) 
    	   System.out.println("Data Update");
    	else 
    		System.out.println("Data Not Update");
 
                
    }catch(Exception e){
    	e.printStackTrace();
    }
	
	
	
}// end of insertTeacherdata.

public void deleteBookdataByid(int id) {
    
	Connection con = db.getCon();
	String query="delete from book where book_id="+id;
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




@Override		
public int addBookcategory(String bookCategory) {
		
Connection con = db.getCon(); // here is call con variable from db.getCon(). connection jdbc. 
String query="insert into category (book_category) values ('"+bookCategory+"') ";
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
		  
}catch(Exception e){
  e.printStackTrace();
}
			
 return row;
		
}// end of addBookcategory method.



@Override	
public List<BookCategory> getBookcategoryData() {

Connection con = db.getCon(); // here is call con variable from db.getCon(). connection jdbc. 
 BookCategory bookCategory=null;
List<BookCategory> categories = new ArrayList<BookCategory>();


String sql = "select * from category"; /// here is write sql query? 
System.out.print(sql);


try {
	Statement stm = con.createStatement();
	ResultSet rs = stm.executeQuery(sql);
	
	while(rs.next()){
	  	
		  BookCategory category = new BookCategory();
          category.setCategoryId(rs.getInt("category_id"));
          category.setBookCategory(rs.getString("book_category"));
          categories.add(category);
          
		
         
	}
	
}catch(Exception e) {
	e.printStackTrace();
	
}
return categories;


}///// end of method.


@Override
public BookCategory getBookcategoryByid(int bookCategoryid) {


Connection con = db.getCon();
String query="select * from category where category_id="+bookCategoryid;
System.out.println(query);

Statement st=null;
//int row=0;

BookCategory bookCetegory=new BookCategory();

try{
	
	  st=con.createStatement();
		ResultSet rs = st.executeQuery(query);
	  while(rs.next()) { 
		  
		  int categoryId=rs.getInt("category_id");
		  String categoryName=rs.getString("book_category");
		  
		  bookCetegory.setCategoryId(categoryId);
		  bookCetegory.setBookCategory(categoryName);			  
		  
		  
	    
	  }
	  
	}catch(Exception e){
		e.printStackTrace();
	}
	

return bookCetegory;




}/// end of  getBookcategoryByid(int bookCategoryid) method.







	
}