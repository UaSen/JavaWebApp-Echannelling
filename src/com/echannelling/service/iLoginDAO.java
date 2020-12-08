package com.echannelling.service;

import java.util.logging.Logger;

/**
 * interface for the LoginDAO class
 * 
 */

public interface iLoginDAO {

	/** initialize logger **/
	public static final Logger logger = Logger.getLogger(iLoginDAO.class.getName());
	
	/**
	 * 
	 * check username or email and password and validate login
	 * 
	 * 
	 * @param userName
	 * @param password
	 * 
	 * @return true or false
	 */
	public boolean check(String userName, String password);
	
	
}
