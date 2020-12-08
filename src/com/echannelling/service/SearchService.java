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
import com.echannelling.model.Session;
import com.echannelling.util.DBconnXML;
import com.echannelling.util.DBconnectionUtil;
import com.echannelling.util.QueryConstants;


public class SearchService implements ISearchService{

	/** initialize logger **/
	public static final Logger logger = Logger.getLogger(SearchService.class.getName());
	
	/** method for connection **/
	private static Connection conn;
	
	private PreparedStatement preparedStatement;
	
	
	/**
	 * view search hospital details
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
	 * 
	 */
	@Override
	public ArrayList<Hospital> viewSearchDetails() {
		
		ArrayList<Hospital> searchList = new ArrayList<Hospital>();
		
		try {
			conn = DBconnectionUtil.getConnection();
		
			preparedStatement = conn.prepareStatement(DBconnXML.getIdByQuery(QueryConstants.SEARCH_HOSPITAL));
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				
				Hospital hospital = new Hospital();
				hospital.sethID(resultSet.getString(QueryConstants.COLUMN_ONE));
				hospital.setDocName(resultSet.getString(QueryConstants.COLUMN_TWO));
				hospital.setSpecialization(resultSet.getString(QueryConstants.COLUMN_THREE));
				hospital.sethName(resultSet.getString(QueryConstants.COLUMN_FOUR));
				searchList.add(hospital);
				
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
		return searchList;
	}
	
	/**
	 * view search session details
	 * 
	 * 
	 * @param hID
	 * 
	 * @return ArrayList<Session>
	 * 
	 * @throws SQLException
	 * @throws SAXException 
	 * @throws IOException 
	 * @throws ParserConfigurationException
	 * @throws ClassNotFoundException e
	 * 
	 */
	@Override
	public ArrayList<Session> getSearchSession(String hID) {

		ArrayList<Session> sessionList = new ArrayList<Session>();
		
		try {
			
			conn = DBconnectionUtil.getConnection();
			
			if ( hID!= null && !hID.isEmpty()) {
				
				preparedStatement = conn.prepareStatement(DBconnXML.getIdByQuery(QueryConstants.GET_SESSION_BY_ID));
				
				preparedStatement.setString(QueryConstants.COLUMN_ONE, hID);

			}
			
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				
				Session session = new Session();
				session.setsID(resultSet.getString(QueryConstants.COLUMN_ONE));
				session.setdID(resultSet.getString(QueryConstants.COLUMN_TWO));
				session.setDocName(resultSet.getString(QueryConstants.COLUMN_THREE));
				session.setDay(resultSet.getString(QueryConstants.COLUMN_FOUR));
				session.setTime(resultSet.getString(QueryConstants.COLUMN_FIVE));
				session.setFee(resultSet.getString(QueryConstants.COLUMN_SIX));
				sessionList.add(session);
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
		
		return sessionList; 
	}
	
	
}
