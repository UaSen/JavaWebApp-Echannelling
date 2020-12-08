package com.echannelling.service;

import java.util.ArrayList;
import java.util.logging.Logger;

import com.echannelling.model.Hospital;
import com.echannelling.model.Session;

public interface ISearchService {

	/** initialize logger **/
	public static final Logger logger = Logger.getLogger(ISearchService.class.getName());
	
	/**
	 * view search hospital details
	 * 
	 * 
	 * @param
	 * 
	 * @return ArrayList<Hospital>
	 */
	public ArrayList<Hospital> viewSearchDetails();
	
	/**
	 * view search session details for given hospital
	 * 
	 * 
	 * @param hID
	 * 
	 * @return ArrayList<Session>
	 */
	public ArrayList<Session> getSearchSession(String hID);
	
}
