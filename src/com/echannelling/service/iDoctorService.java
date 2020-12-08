package com.echannelling.service;

import java.util.ArrayList;
import java.util.logging.Logger;

import com.echannelling.model.Doctor;

/**
 * interface for the DoctorService class
 * 
 */

public interface iDoctorService {
	
	/** initialize logger **/
	public static final Logger logger = Logger.getLogger(iDoctorService.class.getName());
	
	/**
	 * enter doctors from this method
	 * add doctors to database
	 *
	 * 
	 * @param doctor object
	 * 
	 * no return type
	 */
	public void enterDoctor(Doctor doc);

	/**
	 * view all doctors list
	 * read doctor list from database
	 * 
	 * 
	 * @param 
	 * 
	 * @return ArrayList<Doctor>
	 */
	public ArrayList<Doctor> viewDoctors();

	/**
	 * view particular doctor by given id
	 * read particular doctor from database
	 * 
	 * 
	 * @param doctorID
	 * 
	 * @return Doctor 
	 */
	public Doctor getDoctorByGivenID(String doctorID);
	
	/**
	 * delete particular doctor by admin
	 * delete doctor in database
	 * 
	 * 
	 * @param doctorID
	 * 
	 * no return type
	 */
	public void removeDoctor(String doctorID);

	/**
	 * update particular doctor by given id
	 * update particular doctor from database
	 * 
	 * 
	 * @param dID, doctor object
	 * 
	 * @return Doctor
	 */
	public Doctor updateDoctor(String dID, Doctor doc);
	
	/**
	 * login for  particular doctor,admin by given id
	 * login details check from database
	 * 
	 * 
	 * @param value,type
	 * 
	 * @return Doctor
	 */
	public Doctor loginByType(String value, String type);
	
}
