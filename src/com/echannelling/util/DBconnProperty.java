package com.echannelling.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.echannelling.service.iFeedbackService;

/** 
 * This is the database connection property class.
 * Load all property details at once when initializing
 * Connect to db.properties
 *  
 * 
 */

public class DBconnProperty {
	
	/** initialize logger **/
	public static final Logger logger = Logger.getLogger(iFeedbackService.class.getName());
	
	/** assign a property variable to load property **/
	public static final Properties properties = new Properties();
	
	
	static {
		
		try 
		{
			/** Read the property when load the class **/
			properties.load(DBconnXML.class.getResourceAsStream(QueryConstants.DB_PROPERTY));
			
		} catch (IOException e) {
			
		    logger.log(Level.SEVERE, e.getMessage());
			
		}
	}
	
	
	/**
	 * add new Feedback ID
	 * 
	 * 
	 * @param aryList
	 * @return
	 */
		
	public static String remakeFeedbackID( ArrayList<String> aryList )
	{
		String madeID;
		
		int count = aryList.size();
		count++;
		
		madeID = QueryConstants.FEEDBACK_ID_GENERATE + count;
		
		if ( aryList.contains(madeID) )
		{
			count++;
			madeID = QueryConstants.FEEDBACK_ID_GENERATE + count;
		
		}
		
		return madeID;
		
	}
	
	
	/**
	 * add new Doctor ID
	 * 
	 * @param aryList
	 * @return
	 */
	
	public static String remakeDoctorID( ArrayList<String> aryList )
	{
		String madeID;
		
		int count = aryList.size();
		count++;
		
		madeID = QueryConstants.DOCTOR_ID_GENERATE + count;
		
		if ( aryList.contains(madeID) )
		{
			count++;
			madeID = QueryConstants.DOCTOR_ID_GENERATE + count;
		
		}
		
		return madeID;
	
	}
	

	/**
	 * add new Hospital ID
	 * 
	 * 
	 * @param aryList
	 * @return
	 */
	
	public static String remakeHospitalID( ArrayList<String> aryList )
	{
		String hosID;
		
		int count = aryList.size();
		
		count++;
		
		hosID = QueryConstants.HOSPITAL_ID_GENERATE + count;
		
		if ( aryList.contains(hosID) )
		{
			count++;
			hosID = QueryConstants.HOSPITAL_ID_GENERATE + count;
		
		}
		
		return hosID;
		
	}
	
	
	/**
	 * add new Session ID
	 * 
	 * 
	 * @param aryList
	 * @return
	 */
	
	public static String remakeSessionID( ArrayList<String> aryList )
	{
		String sesID;
		
		int count = aryList.size();
		
		count++;
		
		sesID = QueryConstants.SESSION_ID_GENERATE + count;
		
		if ( aryList.contains(sesID) )
		{
			count++;
			sesID = QueryConstants.SESSION_ID_GENERATE + count;
		
		}
		
		return sesID;
		
	}
	
	
	/**
	 * add new Booking ID
	 * 
	 * 
	 * @param aryList
	 * @return
	 */
	
	public static String remakeBookingID( ArrayList<String> aryList )
	{
		String bookID;
		
		int count = aryList.size();
		
		count++;
		
		bookID = QueryConstants.BOOKING_ID_GENERATE + count;
		
		if ( aryList.contains(bookID) )
		{
			count++;
			bookID = QueryConstants.BOOKING_ID_GENERATE + count;
		
		}
		
		return bookID;
		
	}



}
