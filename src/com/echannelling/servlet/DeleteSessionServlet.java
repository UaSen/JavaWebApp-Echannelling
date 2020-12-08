package com.echannelling.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.echannelling.service.ISessionService;
import com.echannelling.service.SessionService;

/**
 * Servlet implementation class DeleteSessionServlet
 */
@WebServlet("/DeleteSessionServlet")
public class DeleteSessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteSessionServlet() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * 
	 * 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
	
		//set parameter
		String sID = request.getParameter("sID");			

		//create service class object and store in interface variable and call add method using interface
		ISessionService iSessionService = new SessionService();
		iSessionService.removeSession(sID,"sID");
		
		//direct to given jsp page
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/showSessionList.jsp");
		dispatcher.forward(request, response);
	
	}

}
