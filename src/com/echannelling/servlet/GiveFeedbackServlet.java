package com.echannelling.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.echannelling.model.Feedback;
import com.echannelling.service.FeedbackService;
import com.echannelling.service.iFeedbackService;



/**
 * Servlet implementation class Feedback
 */

@WebServlet("/GiveFeedbackServlet")
public class GiveFeedbackServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GiveFeedbackServlet() {      
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
		
		//create new feedback object using default constructor
		Feedback fdbk = new Feedback();
	
		//assign add data to variables using parameter
		fdbk.setEmail(request.getParameter("email"));
		fdbk.setSubject(request.getParameter("subject"));
		fdbk.setComment(request.getParameter("comment"));
		
		//create service class object and store in interface variable and 
		//call method to insert feedback using interface
		iFeedbackService iFeedbackService = new FeedbackService();
		iFeedbackService.giveFeedback(fdbk);
		
		
		request.setAttribute("fdbk", fdbk);
		
	    
		//direct request results to given jsp page
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/userGiveFeedback.jsp");
		dispatcher.forward(request, response);
		
	}
	


}
