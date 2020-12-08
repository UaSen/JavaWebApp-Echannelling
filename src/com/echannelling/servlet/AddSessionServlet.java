package com.echannelling.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.echannelling.model.Session;
import com.echannelling.service.ISessionService;
import com.echannelling.service.SessionService;

/**
 * Servlet implementation class AddSessionServlet
 */
@WebServlet("/AddSessionServlet")
public class AddSessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddSessionServlet() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		//create session object using default constructor
		Session session = new Session();
	
		//get parameters
		String hID = request.getParameter("hID");
		String dID = request.getParameter("dID");
		String docName = request.getParameter("docName");
		
		//set session object parameter
		session.sethID(hID);
		session.setdID(dID);
		session.setDocName(docName);
		session.setDay(request.getParameter("day"));
		session.setTime(request.getParameter("time"));
		session.setAvalability(request.getParameter("avalability"));
		session.setFee(request.getParameter("fee"));
		
		
		//create service class object and store in interface variable and call method using interface
		ISessionService ISessionService = new SessionService();
		ISessionService.enterSession(session);

		request.setAttribute("session",session );
		
		//direct to given jsp page
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/showSessionList.jsp");
		dispatcher.forward(request, response);	
			
	
	}

}
