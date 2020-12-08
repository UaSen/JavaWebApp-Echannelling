package com.echannelling.util;

/**
 * This file include query constants for the java web application 
 * Querys are in QueryXML 
 * Query get by ID
 */

public class QueryConstants {
	
	
	/** query constants to connect database **/
	
	
	/** Constant for db.properties */
	public static final String DB_PROPERTY = "db.properties";
	
	/** Constant for url to connect database in db.properties */
	public static final String URL = "url";
	
	/** Constant for driver to connect MYSQL in db.properties */
	public static final String DRIVER_NAME = "driverName";
	
	/** Constant for username in db.properties*/
	public static final String USERNAME = "uesrName";
	
	/** Constant for password in db.properties */
	public static final String PASSWORD = "password";
	
	/***************************************************************/
	
	
	
	/** Constant for QueryXML */
	
	
	/** Constant for tag name in QueryXML */
	public static final String TAG_NAME = "query";
	
	/** Constant for tag id in QueryXML */
	public static final String GET_ID = "ids";
	
	/***************************************************************/
	

	/**  Constant for Feedback Table  **/
	
	
	/** Constant for feedback id prefix in  Feedback Table */
	public static final String FEEDBACK_ID_GENERATE = "F100";
	
	/** Constant for insert feedback to the Feedback Table */
	public static final String INSERT_FEEDBACK = "insert_feedback";
	
	/** Constant for select all feedback from Feedback Table */
	public static final String SELECT_FEEDBACK = "select_feedback";
	
	/** Constant for get feedback by id**/
	public static final String GET_FEEDBACK_IDS = "get_feedback_id";
	
	/***************************************************************/
	
	
	/**  Constant for Doctor Table  **/
	
	
	/** Constant for doctor id prefix in  doctor Table */
	public static final String DOCTOR_ID_GENERATE = "D100";
	
	/** Constant for insert doctor to the doctor Table */
	public static final String INSERT_DOCTOR = "insert_doctor";
	
	/** Constant for select all doctor from doctor Table */
	public static final String SELECT_DOCTOR = "select_doctor";
	
	/** Constant for get doctor by id**/
	public static final String GET_DOCTOR_IDS = "get_doctor_id";
	
	/** Constant for delete doctor by id**/
	public static final String DELETE_DOCTOR = "delete_doctor";
	
	/** Constant for select doctor by id**/
	public static final String SELECT_DOCTOR_BY_ID = "doctor_by_id";
		
	/** Constant for select update doctor and admin**/
	public static final String UPDATE_DOCTOR = "update_doctor_admin";
	
	/***************************************************************/	
	
	
	
	/**  Constant for Login - doctor, admin  **/
	
	
	/** Constant for login**/
	public static final String LOGIN = "login_doctor_admin";
	
	/** Constant for login by user name**/
	public static final String LOGIN_USERNAME = "login_by_username";
	
	/** Constant for login by email**/
	public static final String LOGIN_EMAIL = "login_by_email";
		
	/***************************************************************/
	

	/**  Constant for Hospital Table  **/
	
	
	/** Constant for hospital id prefix in  hospital Table */
	public static final String HOSPITAL_ID_GENERATE = "H100";
	
	/** Constant for get hospital by id**/
	public static final String GET_HOSPITAL_IDS = "get_hospital_id";
	
	/** Constant for insert hospitals to the hospital Table */
	public static final String INSERT_HOSPITAL = "insert_hospital";
	
	/** Constant for select hospitals from the hospital Table */
	public static final String SELECT_HOSPITAL = "select_hospital";
	
	/** Constant for select hospitals from the hospital Table */
	public static final String SEARCH_HOSPITAL = "search_hospital";
	
	/** Constant for update hospital in the hospital Table */
	public static final String UPDATE_HOSPITAL = "update_hospital";
	
	/** Constant for select hospitals from the hospital Table */
	public static final String DELETE_HOSPITAL = "delete_hospital";
	
	/** Constant for delete hospital by using hospital hID */
	public static final String DELETE_HOSPITAL_BY_hID = "delete_hospital_by_hID";
	
	/** Constant for delete hospital by using doctor ID  */
	public static final String DELETE_HOSPITAL_BY_dID = "delete_hospital_by_dID";
	
	/***************************************************************/


	
	/**  Constant for Session Table  **/
	
	
	/** Constant for session id prefix in session Table */
	public static final String SESSION_ID_GENERATE = "S100";
	
	/** Constant for get session by id**/
	public static final String GET_SESSION_IDS = "get_sessions_id";
	
	/** Constant for insert sessions to the session Table */
	public static final String INSERT_SESSION = "insert_sessions";
	
	/** Constant for select sessions to the session Table */
	public static final String SELECT_SESSION = "select_sessions";
	
	/** Constant for update sessions to the session Table */
	public static final String UPDATE_SESSION = "update_sessions";	
	
	/** Constant for delete session by using session ID  */
	public static final String DELETE_SESSION_BY_sID = "delete_session_by_sID";
	
	/** Constant for delete session by using hospital ID  */
	public static final String DELETE_SESSION_BY_hID = "delete_session_by_hID";
	
	/** Constant for delete session by using doctor ID  */
	public static final String DELETE_SESSION_BY_dID = "delete_session_by_dID";
	
	/***************************************************************/
	
	
	
	/**  Constant for Search  **/
	
	/** Constant for search details  */
	public static final String SEARCH_DETAILS = "search_details";
	
	/** Constant for get session ID in searching */
	public static final String GET_SESSION_BY_ID = "get_session_by_id";
	
	/***************************************************************/
	
	
	
	
	/**  Constant for Booking  **/
	
	/** Constant for booking id prefix in booking Table */
	public static final String BOOKING_ID_GENERATE = "B100";
	
	/** Constant for get booking by id**/
	public static final String GET_BOOKING_IDS = "get_book_id";
	
	/** Constant for insert booking **/
	public static final String INSERT_BOOKING = "insert_booking";
	
	/** Constant for update booking details */
	public static final String UPDATE_BOOKING = "update_booking";
	
	/** Constant for get no of bookings */
	public static final String GET_NO_OF_BOOKING = "get_no_of_booking";
	
	/** Constant for delete bookings by using doctor ID  */
	public static final String DELETE_BOOKING_BY_dID = "delete_booking_by_dID";
	
	/** Constant for delete bookings by using hospital ID  */
	public static final String DELETE_BOOKING_BY_hID = "delete_booking_by_hID";
	
	/** Constant for delete bookings by using session ID  */
	public static final String DELETE_BOOKING_BY_sID = "delete_booking_by_sID";
	
	/** Constant for delete bookings by using booking ID  */
	public static final String DELETE_BOOKING_BY_bID = "delete_booking_by_bID";
	
	/***************************************************************/
	
	
	/**  Constant for column indexes  **/
	
		
	/** Constant for column index 1 */
	public static final int COLUMN_ONE = 1;
	
	/** Constant for column index 2 */
	public static final int COLUMN_TWO = 2;
	
	/** Constant for column index 3 */
	public static final int COLUMN_THREE = 3;
	
	/** Constant for column index 4 */
	public static final int COLUMN_FOUR = 4;
	
	/** Constant for column index 5 */
	public static final int COLUMN_FIVE = 5;
	
	/** Constant for column index 6 */
	public static final int COLUMN_SIX = 6;
	
	/** Constant for column index 7 */
	public static final int COLUMN_SEVEN = 7;
	
	/** Constant for column index 8 */
	public static final int COLUMN_EIGTH = 8;
	
	/** Constant for column index 9 */
	public static final int COLUMN_NINE = 9;
	
	/** Constant for column index 10 */
	public static final int COLUMN_TEN = 10;
	
	/** Constant for column index 11 */
	public static final int COLUMN_ELEVEN = 11;
	
	/** Constant for column index 12 */
	public static final int COLUMN_TWELVE = 12;
	
	/** Constant for column index 13 */
	public static final int  COLUMN_THIRTEEN = 13;
	
	/***************************************************************/
	
	
	
}
