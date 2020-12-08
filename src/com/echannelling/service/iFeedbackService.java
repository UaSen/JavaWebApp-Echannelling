package com.echannelling.service;

import java.util.ArrayList;
import java.util.logging.Logger;

import com.echannelling.model.Feedback;

/**
 * interface for the FeedbackService class
 * 
 */

public interface iFeedbackService {

	/** initialize logger **/
	public static final Logger logger = Logger.getLogger(iFeedbackService.class.getName());
	
	/**
	 * get feedback from user
	 * Add feedback to database
	 *  
	 * 
	 * @param fdbk
	 */
	public void giveFeedback(Feedback fdbk);
	
	
	/**
	 * view all list of feedback
	 * 
	 * 
	 * @return ArrayList<Feedback>
	 */
	public ArrayList<Feedback> viewFeedback();
	
	
	
}
