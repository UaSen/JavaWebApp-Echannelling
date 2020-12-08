package com.echannelling.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class GetDoctorServlet
 */
@WebServlet("/GetDoctorServlet")
public class GetDoctorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetDoctorServlet() {
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

		//get parameters
 		String doctorID = request.getParameter("doctorID");	
 		String docName = request.getParameter("doctorName");
 		String specialization = request.getParameter("specialization");
		
 		//send parameters to given jsp page 
 		request.setAttribute("doctorID",doctorID );
 		request.setAttribute("docName",docName);
 		request.setAttribute("specialization",specialization);

 		//direct to given Addnewhospital page with particular doctor details
 		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/AddNewHospital.jsp");
		dispatcher.forward(request, response);
		
		
		
	}

}
