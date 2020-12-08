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
 * Servlet implementation class CancelBookingServlet
 */
@WebServlet("/CancelBookingServlet")
public class CancelBookingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CancelBookingServlet() {
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
		
		//get booked id from parameter
		String bID = request.getParameter("refNO");			

		//create service class object and store in interface variable and call remove method using interface
		IBookingService iBookingService = new BookingService();
		iBookingService.removeBoking(bID,"bID" );
		
		//direct to given jsp page
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/home.jsp");
		dispatcher.forward(request, response);
		
	}

}
