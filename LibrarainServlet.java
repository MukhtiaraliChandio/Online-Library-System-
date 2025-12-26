package com.library.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.library.dao.impl.LibrarainDaoImpl;
import com.library.pojo.Author;
import com.library.pojo.BookCategory;
import com.library.pojo.Librarain;
import com.library.pojo.Teacher;
import com.library.pojo.User;
import com.library.dao.*;

/**
 * Servlet implementation class LibrarainServlet
 */
@WebServlet("/LibrarainServlet")
public class LibrarainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LibrarainServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    LibrarainDao libDao=new LibrarainDaoImpl();
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
		 

		    if(option.equals("insertdatalib")) {
		    	
		    	try {
		    		
		    		insertlibraraindata(request, response);
		    	}catch(Exception e) {
		    		e.printStackTrace();
		    	}
		    	
		    }else if(option.equals("showData")) {
		    	
		    	try {
		    		listLibrarainData(request, response);
		    	}catch(Exception e) {
		    		e.printStackTrace();
		    	}
		    	
		    	
		    }
		    else if(option.equals("getDatabyIdeditForm")) {
		    	
		    	try {
		    		  getLibraraindataByid(request, response);
		    	}catch(Exception e) {
		    		e.printStackTrace();
		    	}
		    	
		    }else if(option.equals("updateDatalib")) {
		    	
		    	try {
		    		  //updateTeacherData(request, response);
		    		    updateLibraraindata(request, response);
		    	}catch(Exception e) {
		    		e.printStackTrace();
		    	}
		    	
		    }else if(option.equals("deleteDatalib")) {
		    	try {
		    		  //deleteTeacherdataByid(request, response);
		    		deleteLibraraindata(request, response);
		    	}catch(Exception e) {
		    		e.printStackTrace();
		    		
		    	}
		    	
		    	
		    	
		    }
		
		
	
}/// end of method.  
private void insertlibraraindata(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
	 Librarain  lib=new Librarain();
	 User    user=new User();
		  
	 String firstName= request.getParameter("firstname");
	 String lastName= request.getParameter("lastname");
	 String fatherName=request.getParameter("fatherName");
	 String surname= request.getParameter("surname");
	 String cnic=request.getParameter("cnicNumber");
	 String contactNumber=request.getParameter("contactNumber");
	 String gender=request.getParameter("gender");
	 String emailId=request.getParameter("emailId");
	 String address=request.getParameter("address");
	 String userName=request.getParameter("userId");
	 String userPassword=request.getParameter("userPassword");
		     
	 System.out.println("UserId:"+"FirstName:"+firstName+"\nLastName:"+ lastName+"\nFatherName:"+fatherName+"\nSurname:"+surname+"\nCnic:"+ cnic+"\nContactNo:"+contactNumber+"\nEmailId:"+emailId+"\nAddress:"+address);

			 
	 libDao.saveUserLibraraintdata(userName, userPassword, "LIBRARAIN");
			 
	 User  LatestUser=libDao.getLatestUser();// this is not working method. 
			 
	 libDao.insertLibraraindata(LatestUser.getUserid(), firstName, lastName, fatherName, surname, cnic, contactNumber, gender, emailId, address);
			 response.sendRedirect("addnewlibrarainform.html");
			 
						
}// end of insertTeacherdata.  	
private void listLibrarainData(HttpServletRequest request, HttpServletResponse response)throws Exception, IOException, ServletException {

    Librarain libData=new Librarain();
	List <Librarain> listlibData =libDao.showLibraraindata();
    request.setAttribute("libData", listlibData);
    System.out.print(listlibData);
    RequestDispatcher dispatcher = request.getRequestDispatcher("viewlibraraindata.jsp");
    dispatcher.forward(request, response);///The server processes the request, but instead of responding directly, it forwards the request to another resource, and the response is generated from that resource.
    


}// end of listTeacherData method		

private void getLibraraindataByid(HttpServletRequest request, HttpServletResponse response) throws Exception, IOException {

    Librarain libData=new Librarain();
    
    String id=request.getParameter("librarainId");
	System.out.println(id);
	int libId = Integer.parseInt(id);

	libData=libDao.getLibrarainbyId(libId);/// here is call getStudentdataByid(stdId);  stdDao object for StudentDao stddao StudentDaoImpl class.
	
	System.out.print(libData);// here is print object student pojo to display value.
	List<String> genders = libDao.getAllLibrarainGendersfromLibrarain(); // Fetch all available genders
    String selectedGender = libDao.getLibrarainselectedGender(libId); // Fetch the user's current gender

        
	request.setAttribute("libData",libData);
	


    request.setAttribute("librarainallgenders", genders);// here set attribute gender. 
    System.out.println(genders);
    System.out.println(selectedGender);
    request.setAttribute("libraryselectedGender", selectedGender);

	
    request.getRequestDispatcher("editlibrarainform.jsp").forward(request, response);

	
}// end of getTeacherdataByid method.

private  void updateLibraraindata(HttpServletRequest request, HttpServletResponse response) throws Exception, IOException {

	
     String id=request.getParameter("librarainId");
	 System.out.println(id);
	 int libId = Integer.parseInt(id);
	 String firstName= request.getParameter("firstname");
	 String lastName= request.getParameter("lastname");
	 String fatherName=request.getParameter("fathername");
	 String surname= request.getParameter("surname");
	 String cnic=request.getParameter("cnic");
	 String contactNumber=request.getParameter("contactNo");
	 String gender=request.getParameter("gender");
	 String emailId=request.getParameter("email");
	 String address=request.getParameter("address");

	 System.out.println("UserId:"+"FirstName:"+firstName+"\nLastName:"+ lastName+"\nFatherName:"+fatherName+"\nSurname:"+surname+"\nCnic:"+ cnic+"\nContactNo:"+contactNumber+"\nEmailId:"+emailId+"\nAddress:"+address);

	
	   libDao.updateLibraraindata(libId, firstName, lastName, fatherName, surname, cnic, contactNumber, emailId, gender, emailId, address);
	 

	   RequestDispatcher dispatcher = request.getRequestDispatcher("editlibrarainform.jsp");
	   dispatcher.forward(request, response);


}
private void deleteLibraraindata(HttpServletRequest request, HttpServletResponse response) throws Exception, IOException {
	
	
	Librarain libData=new Librarain();
	String libId=request.getParameter("librarainId");
	int  id=Integer.parseInt(libId);
	

	libDao.deleteLibraraindataByid(id);
	

	
	List <Librarain> listlibData =libDao.showLibraraindata();
    request.setAttribute("libData", listlibData);
    System.out.print(listlibData);
   
    RequestDispatcher dispatcher = request.getRequestDispatcher("viewlibraraindata.jsp");
    dispatcher.forward(request, response);
    
	
	
}// end of deleteLibraraindata method.





}