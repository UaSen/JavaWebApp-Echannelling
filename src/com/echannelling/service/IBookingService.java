package com.echannelling.service;

import java.util.ArrayList;
import java.util.logging.Logger;

import com.echannelling.model.Booking;

/**
 * interface for the BookingService class
 * 
 */

public interface IBookingService {

	/** initialize logger **/
	public static final Logger logger = Logger.getLogger(IBookingService.class.getName());
	
	/**
	 * get bookings from patients
	 * Add bookings to database
	 * 
	 * 
	 * @param booking object
	 * 
	 * no return type
	 */
	public void getBookingDetails(Booking booking);
	
	/**
	 * delete bookings done by patients
	 * delete bookings to database
	 * 
	 * 
	 * @param bID,type
	 * 
	 * no return type
	 */
	public void removeBoking(String bID, String type);
	
	/**
	 * view bookings done by particular patient patients
	 * read booking from database
	 * 
	 * 
	 * @param ddID
	 * 
	 * @return ArrayList<Booking>
	 */
	public ArrayList<Booking> viewNoOfBooking(String ddID);

	/**
	 * update bookings done by patients
	 * updates bookings in database
	 * 
	 * 
	 * @param bID,cName,cEmail,cNIC
	 * 
	 * no return type
	 */
	public void updatecustomer(String bID, String cName, String cEmail, String cNIC);	
	
	
}
