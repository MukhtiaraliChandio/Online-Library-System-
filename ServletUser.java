package com.library.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.library.dao.*;
import com.library.dao.impl.*;
import com.library.pojo.User;



/**
 * Servlet implementation class ServletUser
 */
@WebServlet("/ServletUser")
public class ServletUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletUser() {
        super();
        // TODO Auto-generated constructor stub
    }
    UserDao userDao= new UserDaoImpl(); 

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		 this.doPost(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//User user=new User();
		User user = null;
		response.setContentType("text/html");

		String emailId = request.getParameter("emailId");
		String userPassword = request.getParameter("psw");
		String role = request.getParameter("option");

		System.out.println("UserId: " + emailId + 
		                   "\nPassword: " + userPassword + 
		                   "\nRole: " + role);

		PrintWriter out = response.getWriter();

		try {

		    user = userDao.ValedateUser(emailId, userPassword, role);

		    if (user != null) {

		        // ✅ Create session
		        HttpSession session = request.getSession();
		        session.setAttribute("user", user);

		        out.println("<script>");
		        out.println("alert('Login successful!');");

		        // ✅ Role-based redirect using JS
		        if ("ADMIN".equalsIgnoreCase(user.getRole())) {
		           // out.println("window.location='admindashboard.html';");
		            response.sendRedirect("admindashboard.html");

		        } else if ("LIBRARAIN".equalsIgnoreCase(user.getRole())) {
		            
		        	//out.println("window.location='librariandashboard.html';");
		            
		            response.sendRedirect("libraraindashboard.html");

		        } else if ("STUDENT".equalsIgnoreCase(user.getRole())) {
		            out.println("window.location='studentdashboard.html';");

		        } else if ("INSTRUCTOR".equalsIgnoreCase(user.getRole())) {
		            out.println("window.location='teacherdashboard.html';");
		        }

		        out.println("</script>");

		    } else {

		        out.println("<script>");
		        out.println("alert('Invalid email or password');");
		        out.println("window.history.back();");
		        out.println("</script>");
		    }

		} catch (Exception e) {
		    e.printStackTrace();
		}
		







	    }
	}
