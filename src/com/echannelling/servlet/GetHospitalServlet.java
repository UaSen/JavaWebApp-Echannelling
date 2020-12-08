package com.echannelling.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetHospitalServlet
 */
@WebServlet("/GetHospitalServlet")
public class GetHospitalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetHospitalServlet() {
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
		
		//get parameter of the type to view or update hospitals
		String type = request.getParameter("type");
		
		//pass parameters to view hospitals
		if(type.equalsIgnoreCase("VIEW")) {
		
		//get parameters
 		String hID = request.getParameter("hID");
 		String dID = request.getParameter("dID");
 		String docName = request.getParameter("docName");
 		
 		request.setAttribute("hID",hID );
 		request.setAttribute("dID",dID );
 		request.setAttribute("docName",docName );
 		
 		//direct response to given jsp page 	
 		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/AddNewSession.jsp");
		dispatcher.forward(request, response);
		
		}else if(type.equalsIgnoreCase("UPDATE")) {
		
			//pass parameters to update hospitals
			
			//get parameters
			String hID = request.getParameter("hID");
			String dID = request.getParameter("dID");
	 		String docName = request.getParameter("docName");
	 		String hName = request.getParameter("hName");
	 		
	 		request.setAttribute("hID",hID );
	 		request.setAttribute("dID",dID );
	 		request.setAttribute("docName",docName );
	 		request.setAttribute("hName", hName );
	 		
	 		//direct response to given jsp page 
	 		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/UpdateHospital.jsp");
			dispatcher.forward(request, response);
			
			}
		
	}

}
