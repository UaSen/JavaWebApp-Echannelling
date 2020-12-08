package com.echannelling.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.echannelling.model.Hospital;
import com.echannelling.service.HospitalService;
import com.echannelling.service.IHospitalService;

/**
 * Servlet implementation class AddHospitalServlet
 */
@WebServlet("/AddHospitalServlet")
public class AddHospitalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddHospitalServlet() {
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
		
		//create new hospital using default constructor
		Hospital hospital = new Hospital();
	
		//get  parameters when submitted
		String dID = request.getParameter("dID");
		String docName = request.getParameter("docName");
		String specialization = request.getParameter("specialization");
		
		//assign get parameters
		hospital.setdID(dID);
		hospital.setDocName(docName);
		hospital.setSpecialization(specialization);
		hospital.sethName(request.getParameter("hName"));
		
		//create service class object and store in interface variable and call add method using interface
		IHospitalService IHospitalService = new HospitalService();
		IHospitalService.enterHospital(hospital);

		request.setAttribute("hospital",hospital );
		
		//direct response to the given jsp page
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/showHospitalList.jsp");
		dispatcher.forward(request, response);	
	}

}
