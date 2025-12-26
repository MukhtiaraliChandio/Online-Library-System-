package com.library.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.library.dao.TeacherDao;
import com.library.dao.impl.TeacherDaoImpl;
import com.library.pojo.Student;
import com.library.pojo.Teacher;
import com.library.pojo.User;

/**
 * Servlet implementation class TeacherServlet
 */
@WebServlet("/TeacherServlet")
public class TeacherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeacherServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
     TeacherDao techDao=new TeacherDaoImpl();
     
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
	    
	    if(option.equals("insertdata")) {
	    	
	    	try {
	    		
	    		  insertTeacherdata(request, response);
	    	}catch(Exception e) {
	    		e.printStackTrace();
	    	}
	    	
	    }else if(option.equals("showData")) {
	    	
	    	try {
	    		  listTeacherData(request, response);
	    	}catch(Exception e) {
	    		e.printStackTrace();
	    	}
	    	
	    	
	    }else if(option.equals("getDatabyIdeditForm")) {
	    	
	    	try {
	    		  getTeacherdataByid(request, response);
	    	}catch(Exception e) {
	    		e.printStackTrace();
	    	}
	    	
	    }else if(option.equals("updateData")) {
	    	
	    	try {
	    		  updateTeacherData(request, response);
	    	}catch(Exception e) {
	    		e.printStackTrace();
	    	}
	    	
	    }else if(option.equals("deleteData")) {
	    	try {
	    		  deleteTeacherdataByid(request, response);
	    	}catch(Exception e) {
	    		e.printStackTrace();
	    		
	    	}
	    	
	    	
	    	
	    }
	    
	
}//end of doPost method.
private void insertTeacherdata(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	  
	
	   // int userId = Integer.parseInt(request.getParameter("userId"));
	
		 String firstName= request.getParameter("firstname");
		 String lastName= request.getParameter("lastname");
		 String fatherName=request.getParameter("fatherName");
		 String surname= request.getParameter("surname");
		 String cnic=request.getParameter("cnicNumber");
		 String contactNumber=request.getParameter("contactNumber");
		 String dateOfbirth=request.getParameter("birthday");
		 String gender=request.getParameter("gender");
		 String emailId=request.getParameter("emailId");
		 String depart=request.getParameter("depart");
		 String address=request.getParameter("address");
		 String userName=request.getParameter("userId");
		 String userPassword=request.getParameter("userPassword");
		 
	
		 System.out.println("UserId:"+"FirstName:"+firstName+"\nLastName:"+ lastName+"\nFatherName:"+fatherName+"\nSurname:"+surname+"\nCnic:"+ cnic+"\nContactNo:"+contactNumber+"\nEmailId:"+emailId+"\nDepart:"+depart+"\nAddress:"+address);

		 techDao.saveUserTeacherdata(userName, userPassword, "INSTRUCTOR");
		 
		 User  LatestUser=techDao.getLatestUser();// this is not working method. 
		 
		 techDao.insertTeacherdata(LatestUser.getUserid(),  firstName, lastName, fatherName, surname, cnic, contactNumber,  gender, emailId, dateOfbirth, depart, address, userName, userPassword);
		 
		 response.sendRedirect("addnewteacherregisterationform.html");
		 
		
		
		
}// end of insertTeacherdata.  	
private void listTeacherData(HttpServletRequest request, HttpServletResponse response)throws Exception, IOException, ServletException {

	    Teacher teachData=new Teacher();
		List <Teacher> listtechData =techDao.showTeacherdata();
	    request.setAttribute("teachData", listtechData);
	    System.out.print(listtechData);
	    RequestDispatcher dispatcher = request.getRequestDispatcher("teacherviewdata.jsp");
	    dispatcher.forward(request, response);///The server processes the request, but instead of responding directly, it forwards the request to another resource, and the response is generated from that resource.
	    

   
}// end of listTeacherData method			
private void getTeacherdataByid(HttpServletRequest request, HttpServletResponse response) throws Exception, IOException {

	    Teacher teachData=new Teacher();
        
	    String id=request.getParameter("teacherId");
		System.out.println(id);
		int teachId = Integer.parseInt(id);

		teachData=techDao.getTeacherbyId(teachId);/// here is call getStudentdataByid(stdId);  stdDao object for StudentDao stddao StudentDaoImpl class.
		
		System.out.print(teachData);// here is print object student pojo to display value.

		List<String> genders = techDao.getAllTeacherGendersfromTeacher(); // Fetch all available genders
	    String selectedGender = techDao.getTeacherselectedGender(teachId); // Fetch the user's current gender
	        
		request.setAttribute("teacherData",teachData);
		
		

		System.out.println("To All Gender Value of Teacherss"+genders);// here is print object student pojo to display value.

	        // Set the data as request attributes
	    request.setAttribute("teacherallgenders", genders);// here set attribute gender. 
	    
		System.out.println("To Selected Gender Value of Teachers"+genders);// here is print object student pojo to display value.

	    request.setAttribute("teacherselectedGender", selectedGender);


	    request.getRequestDispatcher("editteacherform.jsp").forward(request, response);

		 //response.sendRedirect("editteacherform.jsp");
		
}// end of getTeacherdataByid method.
	
private void updateTeacherData(HttpServletRequest request, HttpServletResponse response) throws Exception, IOException {
	
	
     int userId = Integer.parseInt(request.getParameter("userId"));	
	 String id=request.getParameter("teacherId");
	 int teachId = Integer.parseInt(id);
	 String firstName= request.getParameter("firstname");
	 String lastName= request.getParameter("lastname");
	 String fatherName=request.getParameter("fatherName");
	 String surname= request.getParameter("surname");
	 String cnic=request.getParameter("cnicNumber");
	 String contactNumber=request.getParameter("contactNumber");
	 String dateOfbirth=request.getParameter("birthday");
	 String gender=request.getParameter("gender");
	 String emailId=request.getParameter("emailId");
	 String depart=request.getParameter("depart");
	 String address=request.getParameter("address");

	 System.out.println("\nTeacherId:"+teachId+"\nFirstName:"+firstName+"\nLastName:"+ lastName+"\nFatherName:"+fatherName+"\nSurname:"+surname+"\nCnic:"+ cnic+"\nContactNo:"+contactNumber+"\nBirthday"+dateOfbirth+"\nGender"+gender+"\nEmailId:"+emailId+"\nDepart:"+depart+"\nAddress:"+address);

	 techDao.updateTeacherdata(userId,teachId, firstName, lastName, fatherName, surname, cnic, contactNumber, emailId, dateOfbirth, depart, address); 
	 
	
	 
	
	
	
}/// end of updateTeacherData.
	
private void deleteTeacherdataByid(HttpServletRequest request, HttpServletResponse response) throws Exception, IOException{
	
	Teacher teachData=new Teacher();
	String stdId=request.getParameter("teacherId");
	int  id=Integer.parseInt(stdId);
	
	 techDao.deleteTeacherdataByid(id);
	//List < Teacher > listTeacher =stdDao.getAllstudentdata();
	List<Teacher> listTeacher=techDao.showTeacherdata();
    request.setAttribute("teachData", listTeacher);
    System.out.print(listTeacher);
   
    RequestDispatcher dispatcher = request.getRequestDispatcher("teacherviewdata.jsp");
    dispatcher.forward(request, response);

    
}/// end of deleteTeacherdata.



	
}