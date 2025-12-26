package com.library.servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.library.dao.BookIssueDao;
import com.library.dao.impl.BookIssueDaoImpl;
import com.library.pojo.BookIssue;

/**
 * Servlet implementation class UpdateResturneIssueBookServlet
 */
@WebServlet("/UpdateResturneIssueBookServlet")
public class UpdateResturneIssueBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateResturneIssueBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
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
	
		
		String bookIssueid = request.getParameter("bookIssueid");

		String returneDate = request.getParameter("dateOfReturne"); // <-- Correct
		String fineStr = request.getParameter("fine");
		String remarks = request.getParameter("remarks");

		
		System.out.println("Return Date = " + returneDate);


		//LocalDate returnDate = LocalDate.parse(returneDate);

		int fine = Integer.parseInt(fineStr);
		
		if (returneDate != null && !returneDate.isEmpty()) {
		    LocalDate returnDate = LocalDate.parse(returneDate);
		    // use returnDate
		    issueDao.updateReturnbookIssue(bookIssueid, returneDate,  fine, remarks);
		} else {
		    System.out.println("date_of_returne is null or empty");
		    // handle error (redirect or show message)
		}
				
		
		
		
		//int latefine=fine*2;

		
	    System.out.println("\nbookIssueId"+bookIssueid +"\nreturneDate:"+ returneDate+"\nfine"+fine+"\nRemarks:"+remarks);

	    
	    
	    //bookReturnDao.submitReturn(br);
	    

	    response.sendRedirect("bookreturnform.jsp");

		
	
	
	
	}

}
