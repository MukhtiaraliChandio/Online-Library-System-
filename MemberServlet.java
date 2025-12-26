package com.library.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.library.dao.*;
import com.library.dao.impl.*;
import com.library.pojo.Member;
import com.library.pojo.Student;
import com.library.pojo.Teacher;
import java.io.*;

/**
 * Servlet implementation class MemberServlet
 */
@WebServlet("/MemberServlet")
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

     MemberDao memberDao=new MemberDaoImpl();
     StudentDao stdDao=new StudentDaoImpl();
     TeacherDao  teachDao=new TeacherDaoImpl();
     
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
	    
	    
	    
	    if(option.equals("nameList")) {
	    	
	    	String memberType = request.getParameter("memberType"); // Get the selected member type

	        // Based on the selected member type, call the appropriate DAO method
	        if ("Student".equalsIgnoreCase(memberType)) {
	        	
			           
			            List<Student> studentNames =memberDao.getAllstudentdata();   // Fetch student names
		
			            // Generate the response HTML for the student dropdown
			            StringBuilder options = new StringBuilder();
		
			            for (Student student : studentNames) {
			                options.append("<option value='")
			                       .append(student.getStdId())
			                       .append("'>")
			                       .append(student.getFirstName()).append(" ")
			                       .append(student.getLastName()).append(" ")
			                    
			                       .append("</option>\n");
			            }
		
		              
			            response.setContentType("text/html");
			            PrintWriter out = response.getWriter();
			            out.print(options.toString());
			        
		            
	            
	        } else if ("Teacher".equalsIgnoreCase(memberType)) {
			           // TeacherDAO teacherDAO = new TeacherDAO();
			            
			        	List<Teacher> teacherNames = memberDao.showTeacherdata();   // Fetch teacher names
		
			            // Generate the response HTML for the teacher dropdown
			            StringBuilder options = new StringBuilder();
			            
			            
			            for (Teacher teacher :  teacherNames) {
			                options.append("<option value='")
			                       .append(teacher.getTeacherId())
			                       .append("'>")
			                       .append(teacher.getFirstName()).append(" ")
			                       .append(teacher.getLastName()).append(" ")
			                
			                       .append("</option>\n");
			            }
		
			            
			            
			            
			          
			            response.setContentType("text/html");
			            PrintWriter out = response.getWriter();
			            out.print(options.toString());
			            
			         
			            
	        } else {
	            // If no valid memberType is selected, return an empty dropdown
	            //response.getWriter().print("<option>Select a member</option>");
	        }
	    	
            
	    	
	    	
	    	
	    	
	    }else if(option.equals("getmemberdata")) {
	    	
	    	System.out.println("MemberId");
	    	
	    	StudentDao stdDao=new StudentDaoImpl(); 
	    	
	    	String ids=request.getParameter("memberId");
	    	//String member=request.getParameter("memberId");
            System.out.println("ids:"+ids);
 
	    	int id = Integer.parseInt(request.getParameter("memberId"));
	        String memberType = request.getParameter("selectedMember");
	        
	        System.out.println(id+"\n"+memberType);
	        
	     
	        
	       JSONArray membersArray = new JSONArray();
	    if(memberType.equals("Student")) {	 
    	  
           Student student = stdDao.getStudentdataByid(id);

           JSONObject object = new JSONObject();

           try {
               
        	   object.put("firstname", student.getFirstName());// 
               object.put("lastname", student.getLastName()); // optional
               object.put("fathername", student.getFatherName()); // optional
               object.put("surname", student.getSurname());// 
               object.put("contactnumber", student.getContactNo()); // optional
               object.put("cnicnumber", student.getCnic());
               object.put("emailId", student.getEmailId());
               object.put("address", student.getAddress());
               object.put("gender", student.getGender());
               
               //RequestDispatcher dispatcher = request.getRequestDispatcher("addnewmemberform.jsp");
       	   // dispatcher.forward(request, response);
               

           } catch (JSONException e) {
               e.printStackTrace();
           }

           membersArray.put(object);

           
       }else if(memberType.equals("Teacher")) {
    	   
           Teacher teacher = teachDao.getTeacherbyId(id);

    	   JSONObject object = new JSONObject();
    	   
        try{
        	   
        	 object.put("firstname", teacher.getFirstName());// 
             object.put("lastname", teacher.getLastName()); // optional
             object.put("fathername", teacher.getFatherName()); // optional
             object.put("surname", teacher.getSurname());// 
             object.put("contactnumber", teacher.getContactNo()); // optional
             object.put("cnicnumber", teacher.getCnic());
             object.put("emailId", teacher.getEmailId());
             object.put("address", teacher.getAddress());
			 object.put("gender", teacher.getGender());
			 
			  //  RequestDispatcher dispatcher = request.getRequestDispatcher("addnewmemberform.jsp");
			   // dispatcher.forward(request, response);
		
        } catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        membersArray.put(object); 

    	   
    	   
       }
       
       response.setContentType("application/json");
       response.setCharacterEncoding("UTF-8");
       PrintWriter out = response.getWriter();
       out.print(membersArray.toString());
       out.flush();
       
       
	    	
              
	    }else if(option.equals("insertmembervalue")) {
	    	
	    	insertMemberdata(request, response);
	    	
	    	
	    }
	
	    
		
	
	
	
	
	
	
}//end of method. 
	
private void insertMemberdata(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	    //int memberTypeid = Integer.parseInt(request.getParameter("memberTypeId"));
	
	
	    // Member member=new Member();
	     
	 
	     
	     String memberTypeid= request.getParameter("memberTypeId");
		 String memberType= request.getParameter("memberType");
		 String firstName= request.getParameter("firstname");
		 String lastName= request.getParameter("firstname");
         String fatherName=request.getParameter("fatherName");
		 String surname= request.getParameter("surname");
		 String cnic=request.getParameter("cnicNumber");
		 String contactNumber=request.getParameter("contactNumber");
		 String gender=request.getParameter("gender");
		 String emailId=request.getParameter("emailId");
		 String address=request.getParameter("address");
	
		 String stdId = null;
	     String teacherId = null;

	    // System.out.print("memberTypeId:"+memberTypeid);
	     
	        // Determine whether to set student ID or teacher ID based on userType
	        if ("Student".equals(memberType)) {
	            stdId = memberTypeid;  // Set the student ID
	        } else if ("Teacher".equals(memberType)) {
	            teacherId = memberTypeid;  // Set the teacher ID
	            
	        }
		 
	//	System.out.println("stdId:"+stdId+"\nTeacherId"+teacherId+"\nmemberType:"+memberType+"\nFirstName:"+firstName+"\nLastName:"+lastName+"\nFatherName:"+fatherName+"\nSurname:"+surname+"\nCnic:"+ cnic+"\nContactNo:"+contactNumber+"\nEmailId:"+emailId+"\nAddress:"+address);

		 
		memberDao.insertMemberdata(stdId,  teacherId ,memberType, firstName, lastName, fatherName, surname, cnic, contactNumber, gender, emailId, address);
		 
	
		response.sendRedirect("addnewmemberform.jsp");
		
	
		
}// end of insertTeacherdata.

private void  getAllteachersandStudentsData(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

	

	
}// end of get getAllteachersandStudentsData.



}
	
