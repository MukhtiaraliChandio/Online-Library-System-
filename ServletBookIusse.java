package com.library.servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.library.dao.*;
import com.library.dao.impl.*;
import com.library.pojo.*;


/**
 * Servlet implementation class ServletBookIusse
 */
@WebServlet("/ServletBookIusse")
public class ServletBookIusse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletBookIusse() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    LibrarainDao libDao=new LibrarainDaoImpl();
    BookDao bookDao=new BookDaoImpl();
    BookIssueDao issueDao=new BookIssueDaoImpl();
    
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
		     if(option.equals("getbookissuenamelist")) {
		    	   try {
		    	  
		    		   //System.out.println("Calling bookissue dropdown");
		    		   showTablesnamelistBookissue(request, response);
		    		   
		    	   }catch(Exception e) {
		    		   e.printStackTrace();
		    	   }
		      }
		     else if(option.equals("insertIssuebookvalue")) {
		    	 try{ 
				      issueNewBookvaluesSave(request, response);
		    	   
		    	 }catch(Exception e) {
		    		 e.printStackTrace();
		    	 }
		      }else if(option.equals("bookIssuelistData")) {
		    	  
		    	  try{
		    		     
		    		  getAllbookIssuedata(request, response);
		    		    
		    	  }catch(Exception e) {
		    		  e.printStackTrace();
		    	  }
		    	  
		    	  
		      }else if(option.equals("getbookreturnnamelist")) {
		    	  
		    	  try {
					
		    		   showTablesnamelistBookreturne(request, response);
				   
		    	   }catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				   } 
		    	
		    	  
		      }else {
		    	  System.out.println("Not Found");
		    	  
		      }
		    	  
		    	  
		    	
	
	
}// end of doPost method.
	

private void issueNewBookvaluesSave(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	 String  bookId=request.getParameter("bookId");
     String librarainId=request.getParameter("librarianId");
     String dateOfissue=request.getParameter("dateOfIssue");
	 String  dateOfdueDate=request.getParameter("dateOfDueDate"); 
	 String remarks=request.getParameter("remarks");
     
	 System.out.println("LibrarainId"+librarainId+"\nBookId:"+bookId+"\n:DateOfissue"+dateOfissue+"\ndateOfdueDate:"+ dateOfdueDate+"\nRemarks:"+remarks);

	
	 issueDao.insertBookissueData(bookId,  librarainId,  dateOfissue,  dateOfdueDate , remarks);
	
	 response.sendRedirect("issuebookform.jsp");
	
	
}// end of addBookCategory method.


private void getAllbookIssuedata(HttpServletRequest request, HttpServletResponse response) throws Exception, IOException{

	
	 List<BookIssue> historyList = issueDao.getAllBookIssueHistory();
	 request.setAttribute("historyList", historyList);
	 
	 RequestDispatcher dispatcher = request.getRequestDispatcher("viewbookissuehistory.jsp");
	 dispatcher.forward(request, response);//
	
	
}
private void showTablesnamelistBookissue(HttpServletRequest request, HttpServletResponse response) throws Exception, IOException{

	
	 
    List<Librarain> libListdata=libDao.getlibrarainNamelist();
	System.out.print("LibrarainShowNameList"+libListdata);

	request.setAttribute("libListdata", libListdata);


	
	 List<Book> bookListdata=bookDao.getbookNamelist();
	 System.out.print("BookShowNameList"+bookListdata);

	  request.setAttribute("bookListdata", bookListdata);
	  
	
	
	
	RequestDispatcher dispatcher = request.getRequestDispatcher("issuebookform.jsp");
    dispatcher.forward(request, response);///The server processes the request, but instead of responding directly, it forwards the request to another resource, and the response is generated from that resource.

	    
    
    
    
}// end of showLibrarainnamelist method.

private void showTablesnamelistBookreturne(HttpServletRequest request, HttpServletResponse response) throws Exception, IOException{

	
	 
    List<Librarain> libListdata=libDao.getlibrarainNamelist();
	System.out.print("LibrarainShowNameList"+libListdata);

	request.setAttribute("libListdata", libListdata);


	
	 List<Book> bookListdata=bookDao.getbookNamelist();
	 System.out.print("BookShowNameList"+bookListdata);

	  request.setAttribute("bookListdata", bookListdata);
	  
	
	
	
	RequestDispatcher dispatcher = request.getRequestDispatcher("bookreturnform.jsp");
    dispatcher.forward(request, response);///The server processes the request, but instead of responding directly, it forwards the request to another resource, and the response is generated from that resource.

	    
    
    
    
}// end of showLibrarainnamelist method.

	

}// end of ServletBookIusse class.



