package com.echannelling.service;

import java.util.ArrayList;
import java.util.logging.Logger;

import com.echannelling.model.Hospital;

/**
 * interface for the HospitalService class
 * 
 */

public interface IHospitalService {
	
	/** initialize logger **/
	public static final Logger logger = Logger.getLogger(IHospitalService.class.getName());

	/**
	 * get entered hospitals
	 * Add hospitals to database
	 * 
	 * 
	 * @param hospital object
	 * 
	 * no return type
	 */
	public void enterHospital(Hospital hospital);	
	
	/**
	 * display hospitals list
	 * read hospitals list from database
	 * 
	 * 
	 * @param 
	 * 
	 * @return ArrayList<Hospital>
	 */
	public ArrayList<Hospital> viewHospital();

	/**
	 * delete entered hospitals
	 * delete hospitals in database
	 * 
	 * 
	 * @param id,type
	 * 
	 * no return type
	 */
	public void removeHospital(String iD,String type);
	
	/**
	 * update entered hospitals
	 * update hospitals in database
	 * 
	 * 
	 * @param hID, hName
	 * 
	 * no return type
	 */
	public void updateHospital(String hID, String hName);
		
	
}
