package com.echannelling.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetSearchSessionIdServlet
 */
@WebServlet("/GetSearchSessionIdServlet")
public class GetSearchSessionIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetSearchSessionIdServlet() {
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
		
		//get passed parameters and store in variables
		String sID = request.getParameter("sID");
		String hID = request.getParameter("hID");
		String dID = request.getParameter("dID");
		String docName = request.getParameter("docName");
 		String hName = request.getParameter("hName");
 		String day = request.getParameter("day");
		String time = request.getParameter("time");
 		String fee = request.getParameter("fee");
 		
 		//send request attributes
 		request.setAttribute("sID",sID );
 		request.setAttribute("hID",hID );
 		request.setAttribute("dID",dID );
 		request.setAttribute("docName",docName );
 		request.setAttribute("hName",hName );
 		request.setAttribute("day",day );
 		request.setAttribute("time",time );
 		request.setAttribute("fee", fee);
 		
 		//direct response to given jsp page
 		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/enterCustomerDetails.jsp");
		dispatcher.forward(request, response);
		
		
		
	}

}
