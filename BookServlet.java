package com.library.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.library.dao.impl.*;
import com.library.pojo.Author;
import com.library.pojo.Book;
import com.library.pojo.BookCategory;
import com.library.pojo.Librarain;
import com.library.dao.*;


/**
 * Servlet implementation class BookServlet
 */
@WebServlet("/BookServlet")
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    BookDao bookDao=new BookDaoImpl();
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		 this.doPost(request, response);
		 
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
	
		 String option=request.getParameter("option");
		 if(option.equals("insertbookcategory")) {
	    	   
	    	   addBookCategory(request, response);
	    	   
	       }
		    
	     else if(option.equals("insertbookdata")) {
			    	
			    	try {
			    		///listLibrarainData(request, response);
			    		addNewBookvalues(request, response);
			    	}catch(Exception e) {
			    		e.printStackTrace();
			    	}
			    	
			    	
			    }else if(option.equals("showbookdata")) {
		    	
		    	try {
		    		///listLibrarainData(request, response);
		    		listAllbookData(request, response);
		    	}catch(Exception e) {
		    		e.printStackTrace();
		    	}
		    	
		    	
		    }
			    else if(option.equals("getDatabookByIdeditForm")) {
			    	
			    	try {
			    		//showBookCategoryinUpdateBookForm(request, response);
			    		getBookdataByid(request, response);
			    	}catch(Exception e) {
			    		e.printStackTrace();
			    	}
			    	
			    }else if(option.equals("updatebookdata")) {
			    	
			    	try {
			    		updateBookdata(request, response);
			    	}catch(Exception e) {
			    		e.printStackTrace();
			    	}
			    	
			    }else if(option.equals("deleteBookdataByid")) {
			    	try {
			    		  
			    		 deleteBookdataByid(request, response);
			    	}catch(Exception e) {
			    		e.printStackTrace();
			    		
			    	}
			    	
			    	
			    	
			    }else if(option.equals("showbookcategory")) {
			    	
			    	showBookCategoryinAddBookForm(request, response);
			    	
			    }
		 
		
		
		
}// end of method.
private void addNewBookvalues(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	 
	 Book book=new Book();

	 int authorId = Integer.parseInt(request.getParameter("author"));
	 int  bookCategoryId=Integer.parseInt(request.getParameter("category"));
     String bookName=request.getParameter("bookName");
 	 String language= request.getParameter("language");
	 String  authorEditor=request.getParameter("authoreditor");
	 String editorVolume=request.getParameter("editorVolume");
	 String yearOfpublishing=request.getParameter("yearOfpublishing");
	 String isbn=request.getParameter("isbn");
	 String noOfpages=request.getParameter("noOfpages"); 
	 String remarks=request.getParameter("remarks");
      
	 System.out.println("\nAuthorId"+authorId+"\nBookCategoryId"+ bookCategoryId+"\nauthorId"+authorId+"\nBookName:"+bookName+"\nLanguage:"+ language+"\nAuthorEditor:"+authorEditor+"\nyearOfpublishing"+yearOfpublishing+"\nIsbn:"+isbn+"\nNoOfPages:"+noOfpages+"\nRemarks:"+remarks);
  
     
	 
	bookDao.insertBookdata(authorId,  bookCategoryId, bookName, language, authorEditor, editorVolume, yearOfpublishing, isbn, noOfpages, remarks);

	
	response.sendRedirect("addnewbookform.jsp");
	
	
}// end of addBookCategory method.



private void addBookCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String bookCategory=request.getParameter("bookCategory");
		
		bookDao.addBookcategory(bookCategory);
		
		response.sendRedirect("addnewbookcategory.html");
		
		
}// end of addBookCategory method.
	
private void showBookCategoryinAddBookForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		  List<BookCategory> categories=bookDao.getBookcategoryData();
		  System.out.print(categories);

		  List<Author> listauthors=bookDao.getAllAuthors();
		  
	      request.setAttribute("categories", categories);
	      
	      request.setAttribute("authors", listauthors);

		
	      RequestDispatcher dispatcher = request.getRequestDispatcher("addnewbookform.jsp");
	      dispatcher.forward(request, response);
		


}// end of addBookCategory method.



private void listAllbookData(HttpServletRequest request, HttpServletResponse response)throws Exception, IOException, ServletException {

	List <Book> listBookData =bookDao.geAllbookData( );

	  for(Book book:listBookData) {
	  
	   BookCategory bookCategory=bookDao.getBookcategoryByid(book.getCategoryId());
	   book.setBookCategory(bookCategory.getBookCategory()); 
	  
	  }
	
	
    request.setAttribute("bookData", listBookData);
    System.out.print(listBookData);
    RequestDispatcher dispatcher = request.getRequestDispatcher("bookviewdata.jsp");
    dispatcher.forward(request, response);///The server processes the request, but instead of responding directly, it forwards the request to another resource, and the response is generated from that resource.
    
    
    


}// end of listTeacherData method*/		
	
	
private void getBookdataByid(HttpServletRequest request, HttpServletResponse response) throws Exception, IOException {

    Book bookData=new Book();
    
    String id=request.getParameter("bookId");
	System.out.println(id);
	int bookId = Integer.parseInt(id);

	bookData=bookDao.getBookbyId(bookId);/// here is call getStudentdataByid(stdId);  stdDao object for StudentDao stddao StudentDaoImpl class.
	
	BookCategory bookCategory=bookDao.getBookcategoryByid(bookData.getCategoryId());
	bookData.setBookCategory(bookCategory.getBookCategory()); 
	
	
	
	System.out.print(bookData);// here is print object student pojo to display value.
	//libData=libDao.getLibrarainbyId(libId);/// here is call getStudentdataByid(stdId);  stdDao object for StudentDao stddao StudentDaoImpl class.
	
	 List<BookCategory> categories=bookDao.getBookcategoryData();
	 System.out.print(categories);
	  
   
	
	request.setAttribute("bookData",bookData);
	request.setAttribute("categories", categories);
	
	
	
    request.getRequestDispatcher("editbookform.jsp").forward(request, response);
    
    
	
}

private void updateBookdata(HttpServletRequest request, HttpServletResponse response) throws Exception, IOException {

     String id=request.getParameter("bookId");
	 System.out.println(id);
	 int bookId = Integer.parseInt(id);
	 int authorId = Integer.parseInt(request.getParameter("authorId"));
	 String bookName=request.getParameter("bookName");
 	 String language= request.getParameter("language");
	 String  authorEditor=request.getParameter("authoreditor");
	 String editorVolume=request.getParameter("editorVolume");
	 String yearOfpublishing=request.getParameter("yearOfpublishing");
	 String isbn=request.getParameter("isbn");
	 String noOfpages=request.getParameter("noOfpages");
	 String remarks=request.getParameter("remarks");
      
	 System.out.println("BookName:"+bookName+"\nLanguage:"+ language+"\nAuthorEditor:"+authorEditor+"\n:yearOfpublishing"+yearOfpublishing+"\nIsbn:"+isbn+"\nNoOfPages:"+noOfpages+"\nRemarks:"+remarks);

	 
	bookDao.updateookdata(authorId, bookId,bookName, language, authorEditor, editorVolume, yearOfpublishing, isbn, noOfpages, remarks);
	
	RequestDispatcher dispatcher = request.getRequestDispatcher("editbookform.jsp");
	dispatcher.forward(request, response);
	
	
}

private void deleteBookdataByid(HttpServletRequest request, HttpServletResponse response) throws Exception, IOException {
	
	
	Book bookData=new Book();
	String bookId=request.getParameter("bookId");
	int  id=Integer.parseInt(bookId);
	
	
	bookDao.deleteBookdataByid(id);
	
	List <Book> listbookData =bookDao.geAllbookData();
	request.setAttribute("bookData",listbookData);
    System.out.print(listbookData);
   
     RequestDispatcher dispatcher = request.getRequestDispatcher("bookviewdata.jsp");
     dispatcher.forward(request, response);
    


	//response.sendRedirect("bookviewdata.jsp");

 
	
}/// end of  deleteBookdataByid method.

private void showAllbookNames(HttpServletRequest request, HttpServletResponse response) throws Exception, IOException {


	 

		//request.setAttribute("bookListdata", bookListdata);
	    
	    
	    
	    

}// end of method.






	
}
