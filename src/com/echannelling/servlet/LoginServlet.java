package com.echannelling.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.echannelling.model.Doctor;
import com.echannelling.service.DoctorService;
import com.echannelling.service.LoginDAO;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	//create doctor service class variable
	private DoctorService doctorService;
	
	//create doctor class variable
	private Doctor doctor;
	
    /**
     * 
     *  default constructor
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        
        //when servlet is called  doctor service class object is create and assign into its variable
        doctorService = new DoctorService();
    }

	/**
	 * 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
	}

	/**
	 * 
	 * @see #LoginDAO.check
	 * 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		//get parameters
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
			
		//create login class object using default constructor
		LoginDAO LoginDAO = new LoginDAO();
		
		//print writer for give alert using java script
		PrintWriter out = response.getWriter(); 
		
		//check inserted username or email and password
		//store result into boolean variable
		boolean x =LoginDAO.check(userName,password);
		
		//set session by considering login type(doctor or admin)
		if(x)
		{
			HttpSession session = request.getSession();
			
			//create doctor object using default construcotr
			doctor = new Doctor();
			
			//call login by type method
			doctor = doctorService.loginByType(userName,"userName");
			
		
			//set session attributes
			session.setAttribute("dID", doctor.getdID());	
			session.setAttribute("userName",userName);	
			
			//login admin and give logged alert and redirect to admin dash board
			if (userName.equalsIgnoreCase("admin")) {
					
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Successfully logged in!');");
			    out.println("location='Admin-Dashboard.jsp';");
			    out.println("</script>");
				
			} 
			else {
				
				//login dcotor and give logged alert and redirect to doctor dash board
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Successfully logged in!');");
			    out.println("location='Doctor-Dashboard.jsp';");
			    out.println("</script>");
				
			}
		} 
		else {
			
			//give alert when user name,email or password is incorrect and redirect to login page
			out.println("<script type=\"text/javascript\">");
			out.println("alert('User Name or Password is invalid!');");
		    out.println("location='login.jsp';");
		    out.println("</script>");

		}
		
	}

}


