package com.echannelling.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.echannelling.model.Doctor;
import com.echannelling.service.DoctorService;
import com.echannelling.service.iDoctorService;

/**
 * Servlet implementation class UpdateDoctorServlet
 */
@WebServlet("/UpdateDoctorServlet")
public class UpdateDoctorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateDoctorServlet() {
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
		
		//create doctor using default constructor
		Doctor doc = new Doctor();
		
		//get login type by parameter
		String type = request.getParameter("type");

		//method for if login doctor type
		if(type.equalsIgnoreCase("DOCTOR")) {
			
			//get parameters
			String dID = request.getParameter("dID");
			String docName = request.getParameter("docName");
			String NIC = request.getParameter("NIC");
			String specialization = request.getParameter("specialization");	
			
			//assign parameters to doc object variables
			doc.setdID(dID);
			doc.setDocName(docName);
			doc.setNIC(NIC);
			doc.setPhone(request.getParameter("phone"));
			doc.setEmail(request.getParameter("email"));
			doc.setUserName(request.getParameter("userName"));
			doc.setPassword(request.getParameter("password"));
			doc.setSpecialization(specialization);
			
			//create service class object and store in interface variable and call update method using interface
			iDoctorService iDoctorService = new DoctorService();
			iDoctorService.updateDoctor( dID,doc);
			
			//direct to given jsp page
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/AccountDetails.jsp");
			dispatcher.forward(request, response);
		
		}else if(type.equalsIgnoreCase("ADMIN")){
			//method for if login admin type
			
			//get parameters
			String dID = request.getParameter("dID");
			String docName = request.getParameter("docName");
			String NIC = request.getParameter("NIC");
			String userName = request.getParameter("userName");	
			
			//assign parameters to doc object variables
			doc.setdID(dID);
			doc.setDocName(docName);
			doc.setNIC(NIC);
			doc.setPhone(request.getParameter("phone"));
			doc.setEmail(request.getParameter("email"));
			doc.setUserName(userName);
			doc.setPassword(request.getParameter("password"));
			doc.setSpecialization(request.getParameter("specialization"));
			
			//create service class object and store in interface variable and call update method using interface
			iDoctorService iDoctorService = new DoctorService();
			iDoctorService.updateDoctor( dID,doc);
			
			//direct to given jsp page
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Admin-Account.jsp");
			dispatcher.forward(request, response);
		
		}
	
	
	}

}
