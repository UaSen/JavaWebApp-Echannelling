package com.echannelling.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class GetSearchIdServlet
 */
@WebServlet("/GetSearchIdServlet")
public class GetSearchIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetSearchIdServlet() {
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

		//get parameters and store in variables
 		String hID = request.getParameter("hID");
 		String hName = request.getParameter("hName");
 				
 		//send request attributes
 		request.setAttribute("hID",hID );
 		request.setAttribute("hName",hName );
 		
 		//direct response to given jsp page
 		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ViewSession.jsp");
		dispatcher.forward(request, response);
	
	}

}
