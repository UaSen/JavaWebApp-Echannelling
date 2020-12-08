package com.echannelling.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.echannelling.model.Booking;
import com.echannelling.service.BookingService;
import com.echannelling.service.IBookingService;

/**
 * Servlet implementation class AddBookingServlet
 */
@WebServlet("/AddBookingServlet")
public class AddBookingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     * 
     */
    public AddBookingServlet() {
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

		//create new  booking object using default constructor
		Booking booking = new Booking();

		//get parameters form hidden type when submitting
		String sID = request.getParameter("sID");
		String hID = request.getParameter("hID");
		String dID = request.getParameter("dID");
		String fee = request.getParameter("fee");
		
		//assign add data to variables using parameter
		booking.setsID(sID);
		booking.sethID(hID);
		booking.setdID(dID);
		booking.setcName(request.getParameter("cName"));
		booking.setcEmail(request.getParameter("cEmail"));
		booking.setcNIC(request.getParameter("cNIC"));
		booking.setCardName(request.getParameter("cardName"));
		booking.setCardNo(request.getParameter("cardNo"));
		booking.setExpDate(request.getParameter("expDate"));
		booking.setCvc(request.getParameter("cvc"));
		booking.setFee(fee);
		
		//create service class object and store in interface variable and call method using interface
		IBookingService iBookingService = new BookingService();
		iBookingService.getBookingDetails(booking);
		

		request.setAttribute("booking", booking);
		
		//give alert when booking is done and redirect to home page
		PrintWriter out = response.getWriter();
		out.println("<script type=\"text/javascript\">");
		out.println("alert('Your Appointment is Done !!! Check Your Email for reference number');");
		out.println("location='home.jsp';");
	    out.println("</script>");
				
	}

}
