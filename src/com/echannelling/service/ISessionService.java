package com.echannelling.service;

import java.util.ArrayList;
import java.util.logging.Logger;

import com.echannelling.model.Session;

/**
 * interface for the sessionService class
 * 
 */

public interface ISessionService {

	/** initialize logger **/
	public static final Logger logger = Logger.getLogger(ISessionService.class.getName());
	
	/**
	 * enter new sessions by admin
	 * Add new sessions to database
	 * 
	 * 
	 * @param session object
	 * 
	 * no return type
	 */
	public void enterSession(Session session);

	/**
	 * view all sessions list
	 * read sessions from database
	 * 
	 * 
	 * @param 
	 * 
	 * @return ArrayList<Session> 
	 */
	public ArrayList<Session> viewSessions();

	/**
	 * delete sessions for given id 
	 * delete sessions from database
	 * 
	 * 
	 * @param sID, type
	 * 
	 * no return type
	 */
	public void removeSession(String sID, String type);
	
	/**
	 * update sessions for given parameters
	 * update sessions from database
	 * 
	 * 
	 * @param sID,day,time,avalability, fee
	 * 
	 * no return type
	 */
	public void updateSession(String sID, String day, String time,String avalability,String fee);

}
