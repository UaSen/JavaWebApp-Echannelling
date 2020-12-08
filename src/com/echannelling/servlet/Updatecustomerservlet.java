package com.echannelling.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.echannelling.service.BookingService;
import com.echannelling.service.IBookingService;

/**
 * Servlet implementation class Updatecustomerservlet
 */
@WebServlet("/Updatecustomerservlet")
public class Updatecustomerservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Updatecustomerservlet() {
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
		
		//get parameters form hidden type when submitting
		String bID = request.getParameter("refnumber");	
		String cName =request.getParameter("customer_name");
		String cEmail = request.getParameter("customer_email");
		String cNIC = request.getParameter("customer_nic");
		
		//create service class object and store in interface variable and call add method using interface
		IBookingService iBookingservice = new BookingService();
		iBookingservice.updatecustomer(bID,cName,cEmail,cNIC);

		//direct response to given jsp page
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/updateAppointment.jsp");
		dispatcher.forward(request, response);
		
		
	}

}
