package com.echannelling.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.echannelling.service.DoctorService;
import com.echannelling.service.iDoctorService;

/**
 * Servlet implementation class DeleteDoctorServlet
 */
@WebServlet("/DeleteDoctorServlet")
public class DeleteDoctorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteDoctorServlet() {
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

		//assign parameters
		String doctorID = request.getParameter("doctorID");			

		//create service class object and store in interface variable and call add method using interface
		iDoctorService iDoctorService = new DoctorService();
		iDoctorService.removeDoctor(doctorID);

		//direct to given jsp page
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/showdcotorList.jsp");
		dispatcher.forward(request, response);

	}

}
