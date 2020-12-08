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

import com.echannelling.model.Hospital;
import com.echannelling.util.DBconnProperty;
import com.echannelling.util.DBconnXML;
import com.echannelling.util.DBconnectionUtil;
import com.echannelling.util.QueryConstants;


public class HospitalService implements IHospitalService{

	/** initialize logger **/
	public static final Logger logger = Logger.getLogger(HospitalService.class.getName());
	
	/** method for connection **/
	private static Connection conn;
	
	private PreparedStatement preparedStatement;
	
	
	/**
	 * no return value
	 * inserted hospitals send to database
	 * 
	 * 
	 * @param hospital object
	 * 
	 * @throws SQLException
	 * @throws SAXException 
	 * @throws IOException 
	 * @throws ParserConfigurationException
	 * @throws ClassNotFoundException e
	 * 
	 */
	@Override
	public void enterHospital(Hospital hospital)
	{
		String hID = DBconnProperty.remakeHospitalID(gettingHospitalID());

		try {
			conn = DBconnectionUtil.getConnection();
		
			preparedStatement = conn.prepareStatement(DBconnXML.getIdByQuery(QueryConstants.INSERT_HOSPITAL));
			conn.setAutoCommit(false);
			
			
			hospital.sethID(hID);	
			
			preparedStatement.setString(QueryConstants.COLUMN_ONE, hospital.gethID());
			preparedStatement.setString(QueryConstants.COLUMN_TWO, hospital.getdID());
			preparedStatement.setString(QueryConstants.COLUMN_THREE, hospital.getDocName());
			preparedStatement.setString(QueryConstants.COLUMN_FOUR, hospital.getSpecialization());
			preparedStatement.setString(QueryConstants.COLUMN_FIVE, hospital.gethName());
			
			
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
	 * @return ArrayList which contain hospital ids
	 * 
	 * @throws SQLException
	 * @throws SAXException 
	 * @throws IOException 
	 * @throws ParserConfigurationException
	 * @throws ClassNotFoundException e
	 */
	private ArrayList<String> gettingHospitalID(){
		
		ArrayList<String> arrayList = new ArrayList<String>();
	
		try {
			conn = DBconnectionUtil.getConnection();
			
			preparedStatement = conn.prepareStatement(DBconnXML.getIdByQuery(QueryConstants.GET_HOSPITAL_IDS));
			
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
	 * display hospital list
	 * 
	 * 
	 * @param 
	 * 
	 * @return ArrayList<Hospital>
	 * 
	 * @throws SQLException
	 * @throws SAXException 
	 * @throws IOException 
	 * @throws ParserConfigurationException
	 * @throws ClassNotFoundException e
	 */
	@Override
	public ArrayList<Hospital> viewHospital() {
	
		ArrayList<Hospital> hosList = new ArrayList<Hospital>();
		
		try {
			conn = DBconnectionUtil.getConnection();
		
			preparedStatement = conn.prepareStatement(DBconnXML.getIdByQuery(QueryConstants.SELECT_HOSPITAL));
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				
				Hospital hospital = new Hospital();
				hospital.sethID(resultSet.getString(QueryConstants.COLUMN_ONE));
				hospital.setdID(resultSet.getString(QueryConstants.COLUMN_TWO));
				hospital.setDocName(resultSet.getString(QueryConstants.COLUMN_THREE));
				hospital.sethName(resultSet.getString(QueryConstants.COLUMN_FOUR));
				
				hosList.add(hospital);
				
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
		return hosList;
	}

	/**
	 * hospitals are delete in this method
	 * no return type
	 * 
	 * @param iD,type
	 * 
	 * @throws SQLException
	 * @throws SAXException 
	 * @throws IOException 
	 * @throws ParserConfigurationException
	 * @throws ClassNotFoundException e
	 */		
	@Override
	public void removeHospital(String iD,String type) {
	
		//check passed id is null or empty
		if( iD != null && !iD.isEmpty() )
		{
			//before delete hospital sessions of that hospital must be deleted
			//call session delete method to deleted that session of particular hospital
			//by passing type parameter
			ISessionService iSessionService = new SessionService();
			iSessionService.removeSession(iD, "hID");
		
			//befor delete doctor sessions of that doctor must be deleted
			//call session delete method to deleted that session of particular doctor
			//by passing type parameter
			ISessionService iSessionServices = new SessionService();
			iSessionServices.removeSession(iD, "dID");
		
			try {
			
				conn = DBconnectionUtil.getConnection();
		
					if(type.equalsIgnoreCase("hID")) {
						
						//hospital delete by this query
						preparedStatement = conn.prepareStatement(DBconnXML.getIdByQuery(QueryConstants.DELETE_HOSPITAL_BY_hID));
			
					}
					else {
						
						//hospitals of particular doctor is delete by this query
						preparedStatement = conn.prepareStatement(DBconnXML.getIdByQuery(QueryConstants.DELETE_HOSPITAL_BY_dID));
					}
		
					preparedStatement.setString(QueryConstants.COLUMN_ONE, iD);
			
					//query is execute in here
					preparedStatement.executeUpdate();
	
		
		
			}catch (SQLException | SAXException | IOException | ParserConfigurationException| ClassNotFoundException e)
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
	}

	/**
	 * hospitals are update in this method for given hospital id
	 * no return type
	 * 
	 * 
	 * @param hID,hname
	 * 
	 * @throws SQLException
	 * @throws SAXException 
	 * @throws IOException 
	 * @throws ParserConfigurationException
	 * @throws ClassNotFoundException e
	 */
	@Override
	public void updateHospital(String hID, String hName) {
	
		if( hID != null && !hID.isEmpty()) {
		
			try {
				conn = DBconnectionUtil.getConnection();
				preparedStatement = conn.prepareStatement(DBconnXML.getIdByQuery(QueryConstants.UPDATE_HOSPITAL));
			
				preparedStatement.setString(QueryConstants.COLUMN_ONE, hName);
				preparedStatement.setString(QueryConstants.COLUMN_TWO, hID );
			
			
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
	
	}	
	
	
}
