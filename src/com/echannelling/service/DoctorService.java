package com.echannelling.service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.echannelling.model.Doctor;
import com.echannelling.util.DBconnProperty;
import com.echannelling.util.DBconnXML;
import com.echannelling.util.DBconnectionUtil;
import com.echannelling.util.QueryConstants;



/**
 * implements methods insert,view,delete Doctor 
 * 
 *
 */

public class DoctorService implements iDoctorService {

	/** initialize logger **/
	public static final Logger logger = Logger.getLogger(DoctorService.class.getName());
	
	/** method for connection **/
	private static Connection conn;
	
	private PreparedStatement preparedStatement;
	
	
	/**
	 * doctor enter from this method
	 * 
	 * no return type
	 * 
	 * 
	 * @param doc
	 * 
	 * @throws SQLException
	 * @throws SAXException 
	 * @throws IOException 
	 * @throws ParserConfigurationException
	 * @throws ClassNotFoundException e
	 */
	@Override
	public void enterDoctor(Doctor doc)
	{
		//this method only for insert data
		String doctorID = DBconnProperty.remakeDoctorID(gettingDoctorID());
		
		try {
			conn = DBconnectionUtil.getConnection();
		
			preparedStatement = conn.prepareStatement(DBconnXML.getIdByQuery(QueryConstants.INSERT_DOCTOR));
			conn.setAutoCommit(false);
			
			doc.setdID(doctorID);
			
			preparedStatement.setString(QueryConstants.COLUMN_ONE, doc.getdID());
			preparedStatement.setString(QueryConstants.COLUMN_TWO, doc.getDocName());
			preparedStatement.setString(QueryConstants.COLUMN_THREE, doc.getNIC() );
			preparedStatement.setString(QueryConstants.COLUMN_FOUR, doc.getPhone());
			preparedStatement.setString(QueryConstants.COLUMN_FIVE, doc.getEmail());
			preparedStatement.setString(QueryConstants.COLUMN_SIX, doc.getUserName());
			preparedStatement.setString(QueryConstants.COLUMN_SEVEN, doc.getPassword());
			preparedStatement.setString(QueryConstants.COLUMN_EIGTH, doc.getSpecialization());
			
			//insert data into database
			preparedStatement.execute();
			conn.commit();
		
		}catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e)
		{
			logger.log(Level.SEVERE, e.getMessage());
		}finally {
			
			try {
				if(preparedStatement != null) {
					preparedStatement.close();
				}
				if(conn != null) {
					conn.close();
				}
			}catch (SQLException e) {
				logger.log(Level.SEVERE, e.getMessage());
			}
		}
	}
	
	
	/**
	 * 
	 * 
	 * @throws SQLException
	 * @throws SAXException 
	 * @throws IOException 
	 * @throws ParserConfigurationException
	 * @throws ClassNotFoundException e
	 * 
	 * @return ArrayList which contain doctor ID
	 */
	private ArrayList<String> gettingDoctorID(){
		
		ArrayList<String> arrayList = new ArrayList<String>();
	
		try {
			conn = DBconnectionUtil.getConnection();
		
			preparedStatement = conn.prepareStatement(DBconnXML.getIdByQuery(QueryConstants.GET_DOCTOR_IDS));
		
			ResultSet resultSet = preparedStatement.executeQuery();
		
			while(resultSet.next())
			{
				arrayList.add(resultSet.getString(QueryConstants.COLUMN_ONE));
			}
		} catch (SQLException | SAXException | IOException | ParserConfigurationException| ClassNotFoundException e)
			{
				logger.log(Level.SEVERE, e.getMessage());
		} finally {
		
			try {
				if(preparedStatement != null) {
					preparedStatement.close();
				}
				if(conn != null) {
					conn.close();
				}
			}catch (SQLException e) {
				logger.log(Level.SEVERE, e.getMessage());
			} 
		} 
		return arrayList;
	}
	
	/**
	 * view doctor for given id
	 * 
	 * 
	 * 
	 * @param doctor ID
	 * 
	 * @throws SQLException
	 * @throws SAXException 
	 * @throws IOException 
	 * @throws ParserConfigurationException
	 * @throws ClassNotFoundException e
	 * 
	 * @see #viewDcotorAction
	 * 
	 */
	@Override
	public Doctor getDoctorByGivenID(String doctorID) {
		
		return viewDcotorAction(doctorID).get(0);
	}

	/**
	 * view all doctors list
	 * 
	 * 
	 * 
	 * @param
	 * 
	 * @throws SQLException
	 * @throws SAXException 
	 * @throws IOException 
	 * @throws ParserConfigurationException
	 * @throws ClassNotFoundException e
	 * 
	 * @see #viewDcotorAction
	 */
	@Override
	public ArrayList<Doctor> viewDoctors()
	{
		return viewDcotorAction(null);
	}
	
	/**
	 * view doctors by given id or all doctor list
	 * 
	 * 
	 * @param doctorID
	 * 
	 * @throws SQLException
	 * @throws SAXException 
	 * @throws IOException 
	 * @throws ParserConfigurationException
	 * @throws ClassNotFoundException e
	 * 
	 * @see #viewDoctors
	 * @see #getDoctorByGivenID
	 * 
	 * @return docList
	 */ 
	private ArrayList<Doctor> viewDcotorAction(String doctorID) {
	
		ArrayList<Doctor> docList = new ArrayList<Doctor>();
		
		try {
			conn = DBconnectionUtil.getConnection();
			
			//check doctor id is null or empty
			if( doctorID != null && !doctorID.isEmpty()) {
				
				preparedStatement = conn.prepareStatement(DBconnXML.getIdByQuery(QueryConstants.SELECT_DOCTOR_BY_ID));
				preparedStatement.setString(QueryConstants.COLUMN_ONE, doctorID);
				
			}else {
			
			preparedStatement = conn.prepareStatement(DBconnXML.getIdByQuery(QueryConstants.SELECT_DOCTOR));
			}
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				
				//create doctor object using default constructor
				Doctor doctor = new Doctor();
				
				doctor.setdID(resultSet.getString(QueryConstants.COLUMN_ONE));
				doctor.setDocName(resultSet.getString(QueryConstants.COLUMN_TWO));
				doctor.setNIC(resultSet.getString(QueryConstants.COLUMN_THREE));
				doctor.setPhone(resultSet.getString(QueryConstants.COLUMN_FOUR));
				doctor.setEmail(resultSet.getString(QueryConstants.COLUMN_FIVE));
				doctor.setUserName(resultSet.getString(QueryConstants.COLUMN_SIX));
				doctor.setPassword(resultSet.getString(QueryConstants.COLUMN_SEVEN));
				doctor.setSpecialization(resultSet.getString(QueryConstants.COLUMN_EIGTH));
							
				docList.add(doctor);
			}
		}catch (SQLException | SAXException | IOException | ParserConfigurationException| ClassNotFoundException e)
		{
			logger.log(Level.SEVERE, e.getMessage());
		} finally {
			
			try {
				if(preparedStatement != null) {
					preparedStatement.close();
				}
				if(conn != null) {
					conn.close();
				}
			}catch (SQLException e) {
				logger.log(Level.SEVERE, e.getMessage());
			} 
		} 
		return docList;
	}
		
	/**
	 * delete doctors by given id
	 * delete doctor form database
	 * 
	 * 
	 * @param doctorID
	 * 
	 * @throws SQLException
	 * @throws SAXException 
	 * @throws IOException 
	 * @throws ParserConfigurationException
	 * @throws ClassNotFoundException e
	 * 
	 */
	@Override
	public void removeDoctor(String doctorID) {
		
		//check doctor id is null or empty
		if (doctorID != null && !doctorID.isEmpty()) {
			
			//call remove hospital method to remove particular hospital that doctor assigned
			//when removing hospital sessions and bookings are deleted using passing type
			IHospitalService iHospitalService =new HospitalService();
			iHospitalService.removeHospital(doctorID,"doctorID");
			
			try {
				
				conn = DBconnectionUtil.getConnection();
			
				preparedStatement = conn.prepareStatement(DBconnXML.getIdByQuery(QueryConstants.DELETE_DOCTOR));
				preparedStatement.setString(QueryConstants.COLUMN_ONE, doctorID);

				//query is execute in here
				preparedStatement.executeUpdate();
	
				
			}catch (SQLException | SAXException | IOException | ParserConfigurationException| ClassNotFoundException e)
			{
				logger.log(Level.SEVERE, e.getMessage());
			} finally {
				
				try {
					if(preparedStatement != null) {
						preparedStatement.close();
					}
					if(conn != null) {
						conn.close();
					}
				}catch (SQLException e) {
					logger.log(Level.SEVERE, e.getMessage());
				} 
			}
		}
	}


	/**
	 * login doctors,admin by given id
	 * login details validate form database
	 * 
	 * 
	 * @param value,type
	 * 
	 * @throws SQLException
	 * @throws SAXException 
	 * @throws IOException 
	 * @throws ParserConfigurationException
	 * @throws ClassNotFoundException e
	 * 
	 * @return doctor
	 * 
	 */
	@Override
	public Doctor loginByType(String value, String type) {
	
		//create doctor using default constructor
		Doctor doctor = new Doctor();
		
		try {
			conn = DBconnectionUtil.getConnection();
		
			String query = null;
		
			//if user enter user name login by validating user name
			if (type.equalsIgnoreCase("userName")) {
				query = DBconnXML.getIdByQuery(QueryConstants.LOGIN_USERNAME);
			
			}
			else {
			
				//if user enter email login by validating email
				query = DBconnXML.getIdByQuery(QueryConstants.LOGIN_EMAIL);
				
			}

			preparedStatement = conn.prepareStatement(query);
			
			preparedStatement.setString(QueryConstants.COLUMN_ONE, value);
			ResultSet resultSet = preparedStatement.executeQuery();
					
			if(resultSet.next()) {
			
				doctor.setdID(resultSet.getString("dID"));
				doctor.setDocName(resultSet.getString("docName"));
				doctor.setNIC(resultSet.getString("NIC"));
				doctor.setPhone(resultSet.getString("phone"));
				doctor.setEmail(resultSet.getString("email"));
				doctor.setUserName(resultSet.getString("userName"));
				doctor.setPassword(resultSet.getString("password"));
				doctor.setSpecialization(resultSet.getString("specialization"));				
				
			}
		else {
				
				doctor = null;
			}
		}catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e)
		{
			logger.log(Level.SEVERE, e.getMessage());
		}finally {
			
			try {
				if(preparedStatement != null) {
					preparedStatement.close();
				}
				if(conn != null) {
					conn.close();
				}
			}catch (SQLException e) {
				logger.log(Level.SEVERE, e.getMessage());
			} 
		}
		return doctor;
	}

	/**
	 * update doctor by given id
	 * update doctor in database
	 * 
	 * 
	 * @param dID, doc
	 * 
	 * @throws SQLException
	 * @throws SAXException 
	 * @throws IOException 
	 * @throws ParserConfigurationException
	 * @throws ClassNotFoundException e
	 * 
	 * @see #getDoctorByGivenID
	 * 
	 * 
	 */
	@Override
	public Doctor updateDoctor(String dID, Doctor doc) {
		
		//check bID is null or empty
		if( dID != null && !dID.isEmpty()) {
			
			try {
				conn = DBconnectionUtil.getConnection();
				
				preparedStatement = conn.prepareStatement(DBconnXML.getIdByQuery(QueryConstants.UPDATE_DOCTOR));
				
				preparedStatement.setString(QueryConstants.COLUMN_ONE, doc.getDocName());
				preparedStatement.setString(QueryConstants.COLUMN_TWO, doc.getNIC() );
				preparedStatement.setString(QueryConstants.COLUMN_THREE, doc.getPhone());
				preparedStatement.setString(QueryConstants.COLUMN_FOUR, doc.getEmail());
				preparedStatement.setString(QueryConstants.COLUMN_FIVE, doc.getUserName());
				preparedStatement.setString(QueryConstants.COLUMN_SIX, doc.getPassword());
				preparedStatement.setString(QueryConstants.COLUMN_SEVEN, doc.getSpecialization());
				preparedStatement.setString(QueryConstants.COLUMN_EIGTH, doc.getdID());
				
				//query is execute in here
				preparedStatement.executeUpdate();
				
			}catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e)
			{
				logger.log(Level.SEVERE, e.getMessage());
			}finally {
				
				try {
					if(preparedStatement != null) {
						preparedStatement.close();
					}
					if(conn != null) {
						conn.close();
					}
				}catch (SQLException e) {
					logger.log(Level.SEVERE, e.getMessage());
				}
			
			}
		
		}
		return getDoctorByGivenID(dID);
	
	}
	

}
	
	
	
		
	
