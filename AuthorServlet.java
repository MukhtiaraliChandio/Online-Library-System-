package com.library.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.library.dao.*;
import com.library.dao.impl.*;
import com.library.pojo.Author;
import com.library.pojo.Teacher;

/**
 * Servlet implementation class AuthorServlet
 */
@WebServlet("/AuthorServlet")
public class AuthorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AuthorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    AuthorDao authorDao=new AuthorDaoImpl();
    
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
	   
	     if(option.equals("insertdataauthor")) {
	    	
	    	try {
	    		
	    		  insertAuthordata(request, response);
	    	}catch(Exception e) {
	    		e.printStackTrace();
	    	}
	    	
	    }else if(option.equals("showDataauthor")) {
	    	
	    	try {
	    		
	    		  listAuthorData(request, response);
	    		
	    	}catch(Exception e) {
	    		e.printStackTrace();
	    	}
	    	
	    	
	    }else if(option.equals("getAuthordatabyIdeditForm")) {
	    	
	    	try {
	    		 getAuthordataByid(request, response);
	    	}catch(Exception e) {
	    		e.printStackTrace();
	    	}
	    	
	    }else if(option.equals("updateData")) {
	    	
	    	try {
	    		  //updateTeacherData(request, response);
	    		updateAuthordata(request, response);
	    	}catch(Exception e) {
	    		e.printStackTrace();
	    	}
	    	
	    }else if(option.equals("deleteAuthordataByid")) {
	    	try {
	    		deleteAuthordataByid(request, response);
	    	}catch(Exception e) {
	    		e.printStackTrace();
	    		
	    	}
	    	
	    	
	    	
	    }
	    
		
		
	
	
	
	}

private void insertAuthordata(HttpServletRequest request, HttpServletResponse response)throws Exception, IOException{
	
		 String firstName= request.getParameter("firstname");
		 String lastName= request.getParameter("lastname");
		 String fatherName=request.getParameter("fatherName");
		 String surname= request.getParameter("surname");
		 String cnic=request.getParameter("cnicNumber");
		 String contactNumber=request.getParameter("contactNumber");
		 String gender=request.getParameter("gender");
		 String emailId=request.getParameter("emailId");
		 String address=request.getParameter("address");
	
		 System.out.println("FirstName:"+firstName+"\nLastName:"+ lastName+"\nFatherName:"+fatherName+"\nSurname:"+surname+"\nCnic:"+ cnic+"\nContactNo:"+contactNumber+"\nEmailId:"+emailId+"\nAddress:"+address);

		 //techDao.insertTeacherdata(firstName, lastName, fatherName, surname, cnic, contactNumber,  gender, emailId, dateOfbirth, depart, address);
		 
		 authorDao.insertAuthordata(firstName, lastName, fatherName, surname, cnic, contactNumber, gender, emailId, gender, emailId, address);
		 
		 response.sendRedirect("addanewauthor.html");
		 
		
		
}
private void listAuthorData(HttpServletRequest request, HttpServletResponse response)throws Exception, IOException, ServletException {

	    Author  authorData=new Author();
		List <Author> listauthorData=authorDao.showAlldataAuthor();
	    
	    request.setAttribute("authorData", listauthorData);
		
	    System.out.print(listauthorData);
	    RequestDispatcher dispatcher = request.getRequestDispatcher("authorviewdata.jsp");
	    dispatcher.forward(request, response);///The server processes the request, but instead of responding directly, it forwards the request to another resource, and the response is generated from that resource.
	    

   
}// end of listTeacherData method			

private void getAuthordataByid(HttpServletRequest request, HttpServletResponse response) throws Exception, IOException {

    Author authorData=new Author();
    
    String id=request.getParameter("authorId");
	System.out.println(id);
	int authorId = Integer.parseInt(id);

	//teachData=techDao.getTeacherbyId(teachId);/// here is call getStudentdataByid(stdId);  stdDao object for StudentDao stddao StudentDaoImpl class.
	
    authorData=authorDao.getAuthorbyId(authorId);
    
	
	System.out.print(authorData);// here is print object student pojo to display value.

	List<String> genders = authorDao.getAllAuthorGendersfromAuthor(); // Fetch all available genders
	
    String selectedGender = authorDao.getAuthorselectedGender(authorId); // Fetch the user's current gender
        
	request.setAttribute("authorData",authorData);
	
	

      
    request.setAttribute("authorallgenders", genders);// here set attribute gender. 
    request.setAttribute("authorselectedGender", selectedGender);


    request.getRequestDispatcher("editauthorform.jsp").forward(request, response);

	
}// end of getTeacherdataByid method.

private void updateAuthordata(HttpServletRequest request, HttpServletResponse response)throws Exception, IOException{
	
	 String id=request.getParameter("authorId");
	 int authorId = Integer.parseInt(id);

	 String firstName= request.getParameter("firstname");
	 String lastName= request.getParameter("lastname");
	 String fatherName=request.getParameter("fatherName");
	 String surname= request.getParameter("surname");
	 String cnic=request.getParameter("cnicNumber");
	 String contactNumber=request.getParameter("contactNumber");
	 String gender=request.getParameter("gender");
	 String emailId=request.getParameter("emailId");
	 String address=request.getParameter("address");

	 System.out.println("AuthorId:"+authorId+"FirstName:"+firstName+"\nLastName:"+ lastName+"\nFatherName:"+fatherName+"\nSurname:"+surname+"\nCnic:"+ cnic+"\nContactNo:"+contactNumber+"\nEmailId:"+emailId+"\nAddress:"+address);

	 
	 //authorDao.insertAuthordata(firstName, lastName, fatherName, surname, cnic, contactNumber, gender, emailId, gender, emailId, address);
	 
	 authorDao.updateAuthordata(authorId, firstName, lastName, fatherName, surname, cnic, contactNumber, gender, emailId, address);
	 //response.sendRedirect("addanewauthor.html");
	 request.getRequestDispatcher("editauthorform.jsp").forward(request, response);
	
	
}

private void deleteAuthordataByid(HttpServletRequest request, HttpServletResponse response) throws Exception, IOException{
	
	Author authorData=new Author();
	String authorId=request.getParameter("authorId");
	int  id=Integer.parseInt(authorId);
	
	authorDao.deleteAuthordataByid(id);
	 //techDao.deleteTeacherdataByid(id);
	//List < Teacher > listTeacher =stdDao.getAllstudentdata();
	List<Author> listAuthor=authorDao.showAlldataAuthor();
    request.setAttribute("authorData", listAuthor);
    System.out.print(listAuthor);
   
    RequestDispatcher dispatcher = request.getRequestDispatcher("authorviewdata.jsp");
    dispatcher.forward(request, response);
    
	
	
	
}/// end of deleteTeacherdata.



	

}
