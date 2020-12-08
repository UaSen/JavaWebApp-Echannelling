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

import com.echannelling.model.Session;
import com.echannelling.util.DBconnProperty;
import com.echannelling.util.DBconnXML;
import com.echannelling.util.DBconnectionUtil;
import com.echannelling.util.QueryConstants;

/**
 * implements methods delete,update,insert,view Sessions
 *
 * 
 *
 */

public class SessionService implements ISessionService{

	/** initialize logger **/
	public static final Logger logger = Logger.getLogger(SessionService.class.getName());
	
	/** method for connection **/
	private static Connection conn;
	
	private PreparedStatement preparedStatement;
	
	/**
	 * no return value
	 * inserted sessions to database
	 * 
	 * 
	 * @param session object
	 * 
	 * @throws SQLException
	 * @throws SAXException 
	 * @throws IOException 
	 * @throws ParserConfigurationException
	 * @throws ClassNotFoundException e
	 * 
	 */
	@Override
	public void enterSession(Session session)
	{
		String sID = DBconnProperty.remakeSessionID(gettingSessionID());

		try {
			conn = DBconnectionUtil.getConnection();
		
			preparedStatement = conn.prepareStatement(DBconnXML.getIdByQuery(QueryConstants.INSERT_SESSION));
			conn.setAutoCommit(false);
			
			session.setsID(sID);
			
			preparedStatement.setString(QueryConstants.COLUMN_ONE, session.getsID());
			preparedStatement.setString(QueryConstants.COLUMN_TWO, session.gethID());
			preparedStatement.setString(QueryConstants.COLUMN_THREE, session.getdID());
			preparedStatement.setString(QueryConstants.COLUMN_FOUR, session.getDocName());
			preparedStatement.setString(QueryConstants.COLUMN_FIVE, session.getDay());
			preparedStatement.setString(QueryConstants.COLUMN_SIX, session.getTime());
			preparedStatement.setString(QueryConstants.COLUMN_SEVEN, session.getAvalability());
			preparedStatement.setString(QueryConstants.COLUMN_EIGTH, session.getFee());
			
			
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
	 * @return String ArrayList which contain session ids
	 * 
	 * 
	 * @throws SQLException
	 * @throws SAXException 
	 * @throws IOException 
	 * @throws ParserConfigurationException
	 * @throws ClassNotFoundException e
	 */
	private ArrayList<String> gettingSessionID(){
		
		ArrayList<String> arrayList = new ArrayList<String>();
	
		try {
			conn = DBconnectionUtil.getConnection();

			preparedStatement = conn.prepareStatement(DBconnXML.getIdByQuery(QueryConstants.GET_SESSION_IDS));
		
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
	 * display all sessions
	 * 
	 * 
	 * @param 
	 * 
	 * @return ArrayList<Session>
	 * 
	 * @throws SQLException
	 * @throws SAXException 
	 * @throws IOException 
	 * @throws ParserConfigurationException
	 * @throws ClassNotFoundException e
	 */
	@Override
	public ArrayList<Session> viewSessions() {
	
		ArrayList<Session> sesList = new ArrayList<Session>();
		
		try {
			conn = DBconnectionUtil.getConnection();
		
			preparedStatement = conn.prepareStatement(DBconnXML.getIdByQuery(QueryConstants.SELECT_SESSION));
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				
				//create session object using default constructor
				Session session = new Session();
				
				session.setsID(resultSet.getString(QueryConstants.COLUMN_ONE));
				session.sethID(resultSet.getString(QueryConstants.COLUMN_TWO));
				session.setdID(resultSet.getString(QueryConstants.COLUMN_THREE));
				session.setDocName(resultSet.getString(QueryConstants.COLUMN_FOUR));
				session.setDay(resultSet.getString(QueryConstants.COLUMN_FIVE));
				session.setTime(resultSet.getString(QueryConstants.COLUMN_SIX));
				session.setAvalability(resultSet.getString(QueryConstants.COLUMN_SEVEN));
				session.setFee(resultSet.getString(QueryConstants.COLUMN_EIGTH));
				sesList.add(session);

				
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
		return sesList;
	}

	/**
	 * session is delete for given id
	 * no return type
	 * 
	 * 
	 * @param sID,type
	 * 
	 * @throws SQLException
	 * @throws SAXException 
	 * @throws IOException 
	 * @throws ParserConfigurationException
	 * @throws ClassNotFoundException e
	 */
	@Override
	public void removeSession(String sID, String type) {
		
		//check sId is null or empty
		if ( sID != null && !sID.isEmpty()) {
			
			//call booking class to remove booking by doctor id
			//when removing sessions bookings for that session must be deleted
			IBookingService iBookingService = new BookingService();
			iBookingService.removeBoking(sID, "dID" );
			
			//call booking class to remove booking by hospital id
			//when removing sessions bookings for that session must be deleted
			IBookingService iBookingServices = new BookingService();
			iBookingService.removeBoking(sID, "hID" );
			
			//call booking class to remove booking by session id
			//when removing sessions bookings for that session must be deleted
			IBookingService iBookingServicess = new BookingService();
			iBookingService.removeBoking(sID, "sID" );
			
			try {
				
				conn = DBconnectionUtil.getConnection();
	
				if(type.equalsIgnoreCase("sID")) {
					
					
					preparedStatement = conn.prepareStatement(DBconnXML.getIdByQuery(QueryConstants.DELETE_SESSION_BY_sID));
					preparedStatement.setString(QueryConstants.COLUMN_ONE, sID);
				}
				else if(type.equalsIgnoreCase("dID")) {
					
					preparedStatement = conn.prepareStatement(DBconnXML.getIdByQuery(QueryConstants.DELETE_SESSION_BY_dID));
					preparedStatement.setString(QueryConstants.COLUMN_ONE, sID);
					
				}
				else {
					
					preparedStatement = conn.prepareStatement(DBconnXML.getIdByQuery(QueryConstants.DELETE_SESSION_BY_hID));
					preparedStatement.setString(QueryConstants.COLUMN_ONE, sID);
				}
				
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
	 * sessions are update in this method for given id
	 * no return type
	 * 
	 * 
	 * @param sID, day, time, avalability, fee
	 * 
	 * @throws SQLException
	 * @throws SAXException 
	 * @throws IOException 
	 * @throws ParserConfigurationException
	 * @throws ClassNotFoundException e
	 */
	@Override
	public void updateSession(String sID, String day, String time, String avalability, String fee) {
	
		//check sId is null or empty
		if( sID != null && !sID.isEmpty()) {
			
			try {
				conn = DBconnectionUtil.getConnection();
				preparedStatement = conn.prepareStatement(DBconnXML.getIdByQuery(QueryConstants.UPDATE_SESSION));
				
				preparedStatement.setString(QueryConstants.COLUMN_ONE, day );
				preparedStatement.setString(QueryConstants.COLUMN_TWO, time );
				preparedStatement.setString(QueryConstants.COLUMN_THREE, avalability );
				preparedStatement.setString(QueryConstants.COLUMN_FOUR, fee );
				preparedStatement.setString(QueryConstants.COLUMN_FIVE, sID);
			
				//query is execute in her
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
