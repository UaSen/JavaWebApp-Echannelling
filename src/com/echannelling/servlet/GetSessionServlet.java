package com.echannelling.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetSessionServlet
 */
@WebServlet("/GetSessionServlet")
public class GetSessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetSessionServlet() {
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
		
		//get parameters
		String sID = request.getParameter("sID");
 		String docName = request.getParameter("docName");
 		String day = request.getParameter("day");
 		String time = request.getParameter("time");
 		String avalability = request.getParameter("avalability");
 		String fee = request.getParameter("fee");
 		
 		//set parameters
 		request.setAttribute("sID",sID );
 		request.setAttribute("docName",docName );
 		request.setAttribute("day", day);
 		request.setAttribute("time", time);
 		request.setAttribute("avalability", avalability );
 		request.setAttribute("fee",fee );
 		
 		//direct to given jsp page	
 		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/UpdateSession.jsp");
		dispatcher.forward(request, response);
		
	}

}
