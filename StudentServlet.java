package com.library.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.library.dao.StudentDao;
import com.library.dao.impl.StudentDaoImpl;
import com.library.pojo.Student;
import com.library.pojo.User;



/**
 * Servlet implementation class StudentServlet
 */
@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    StudentDao stdDao= new StudentDaoImpl(); 

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
		
//PrintWriter out=response.getWriter();
		

		String option=request.getParameter("option");
		
		
	 if(option.equals("insertData")) {
			
			try {
				  insertStudentdata(request, response);
				 // 
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	 }else if(option.equals("showData")) {
			
			try {
				  listStudentData(request, response);
			      //response.sendRedirect("NewStudentListData.jsp");
			}  catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
		}else if(option.equals("getDatabyIdeditForm")) {
			
			try {
				
				   
				getStudentdataByid(request, response);
				 // response.sendRedirect("EditStudentFormjsp.jsp");


			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
		}else if(option.equals("updateData")) {
			
			try {
				updateStudentdataByid(request,response);
			}  catch (Exception e) {
			
				e.printStackTrace();
			}
		}
		else if(option.equals("deleteData")) {
			
			try {
				 deleteStudentdataByid(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
			
		
		
		
		


}// end of doPost method. 
private void  insertStudentdata(HttpServletRequest request, HttpServletResponse response) throws Exception, IOException {
		
     Student std=new Student();
	 User    user=new User();
     
	 String firstName= request.getParameter("firstname");
	 String lastName= request.getParameter("lastname");
	 String fatherName=request.getParameter("fatherName");
	 String surname= request.getParameter("surname");
	 String gender=request.getParameter("gender");
	 String cnic=request.getParameter("cnicNumber");
	 String contactNumber=request.getParameter("contactNumber");
	 String emailId=request.getParameter("emailId");
	 String address=request.getParameter("address");
	 String userName=request.getParameter("userId");
	 String userPassword=request.getParameter("userPassword");
	 
	 System.out.println("\nUserId:"+userName+"\nUserPassword:"+userPassword+"\nFirstName:"+firstName+"\nLastName:"+lastName+"\nSurname:"+ surname+"\nCnic:"+ cnic+"\nContactNo:"+contactNumber+"\nEmailId:"+emailId+"\nAddress:"+address);
	 
	 stdDao.saveUserStudentdata(userName, userPassword, "STUDENT");
	 
	 User  LatestUser=stdDao.getLatestUser();// this is not working method. 


	 stdDao.saveStudentdata(LatestUser.getUserid(),   firstName, lastName, fatherName, surname, gender, cnic, contactNumber, emailId, address);
	 
	// saveStudentdata
	 
	 response.sendRedirect("addnewstudentform.html");
		
}//end of insertUser method.


private void listStudentData(HttpServletRequest request, HttpServletResponse response)throws Exception, IOException, ServletException {

	  Student std=new Student();
	  List <Student> liststdData =stdDao.getAllstudentdata();
	  request.setAttribute("stdData", liststdData);
	  System.out.print(liststdData);
	  RequestDispatcher dispatcher = request.getRequestDispatcher("studentviewdata.jsp");
	  dispatcher.forward(request, response);///The server processes the request, but instead of responding directly, it forwards the request to another resource, and the response is generated from that resource.
	    

}// end of list Employee method	
		


private void getStudentdataByid(HttpServletRequest request, HttpServletResponse response) throws Exception, IOException {

    Student std=new Student();

    String id=request.getParameter("stdId");
	System.out.println(id);
	int stdId = Integer.parseInt(id);

	std=stdDao.getStudentdataByid(stdId);/// here is call getStudentdataByid(stdId);  stdDao object for StudentDao stddao StudentDaoImpl class.
	
	List<String> genders = stdDao.getAllStudentGendersfromStudent(); // Fetch all available genders
    String selectedGender = stdDao.getStudentselectedGender(stdId); // Fetch the user's current gender
        
	System.out.print(std);// here is print object student pojo to display value.

	request.setAttribute("stdData",std);

	request.setAttribute("studallgenders", genders);// here set attribute gender. 
	
	System.out.println("To All Gender Value of Students"+genders);// here is print object student pojo to display value.

	request.setAttribute("studselectedGender", selectedGender);
	
	System.out.println("To Selected Gender Value of Students"+genders);// here is print object student pojo to display value.

	
    request.getRequestDispatcher("editstudentform.jsp").forward(request, response);

	
	
}// end of getCustomerdataByid method.

private void updateStudentdataByid(HttpServletRequest request, HttpServletResponse response) throws Exception, IOException {

	
	 String id1=request.getParameter("userId");
	 System.out.println(id1);
	 int userId=Integer.parseInt(id1);
     String id=request.getParameter("stdId");
 	 System.out.println(id);
 	 int stdId = Integer.parseInt(id);
 	 String firstName= request.getParameter("firstname");
 	 String lastName= request.getParameter("lastname");
	 String fatherName= request.getParameter("fathername");
 	 String surname= request.getParameter("surname");
 	 String gender=request.getParameter("gender");
	 String cnic=request.getParameter("cnic");
	 String contactNumber=request.getParameter("contactNo");
	 String email=request.getParameter("email");
	 String address=request.getParameter("address");
	 
	 stdDao.updateStudentdata(userId, stdId, firstName, lastName, fatherName, surname, gender, cnic, contactNumber, email, address);
	 System.out.println("FirstName:"+firstName+"\nLastName:"+ lastName+"\nSurname:"+ surname+"\nCnic:"+ cnic+"\nContactNo:"+contactNumber+"\nEmailId:"+email+"\nAddress:"+address);

	 
	
     RequestDispatcher dispatcher = request.getRequestDispatcher("editstudentform.jsp");
     dispatcher.forward(request, response);
     

}// end of 

	
private void deleteStudentdataByid(HttpServletRequest request, HttpServletResponse response) throws Exception, IOException  {

	Student std=new Student();
	String stdId=request.getParameter("stdId");
	int  id=Integer.parseInt(stdId);
	
	stdDao.deleteStudentdataByid(id);
	List < Student > listStudent =stdDao.getAllstudentdata();
    request.setAttribute("stdData", listStudent);
    System.out.print(listStudent);
   
    RequestDispatcher dispatcher = request.getRequestDispatcher("studentviewdata.jsp");
    dispatcher.forward(request, response);
    
    //response.sendRedirect("studentviewdata.jsp");
	
	//
	
}



	
}//// end of  Student  Servlet class.	