package com.echannelling.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.echannelling.service.HospitalService;
import com.echannelling.service.IHospitalService;


/**
 * Servlet implementation class DeleteHospitalServlet
 */
@WebServlet("/DeleteHospitalServlet")
public class DeleteHospitalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteHospitalServlet() {
        super();
   
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");

		//get parameters
		String hID = request.getParameter("hID");			

		//create service class object and store in interface variable and call add method using interface
		IHospitalService iHospitalService =new HospitalService();
		iHospitalService.removeHospital(hID,"hID");
		
		//direct response to the given jsp page
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/showHospitalList.jsp");
		dispatcher.forward(request, response);
		
		
	}

}
