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
 * Servlet implementation class AddDoctorServlet
 */
@WebServlet("/AddDoctorServlet")
public class AddDoctorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddDoctorServlet() {
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
	
		//assign parameters to doc object variables
		doc.setDocName(request.getParameter("docName"));
		doc.setNIC(request.getParameter("NIC"));
		doc.setPhone(request.getParameter("phone"));
		doc.setEmail(request.getParameter("email"));
		doc.setUserName(request.getParameter("userName"));
		doc.setPassword(request.getParameter("password"));
		doc.setSpecialization(request.getParameter("specialization"));
		
		//create service class object and store in interface variable and call add method using interface
		iDoctorService iDoctorService = new DoctorService();
		iDoctorService.enterDoctor(doc);
		
		
		request.setAttribute("doc", doc);
		
		//direct to given jsp page
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/showdcotorList.jsp");
		dispatcher.forward(request, response);
		
		
		
		
	}

}
