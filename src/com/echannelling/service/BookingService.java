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

import com.echannelling.model.Booking;
import com.echannelling.util.DBconnProperty;
import com.echannelling.util.DBconnXML;
import com.echannelling.util.DBconnectionUtil;
import com.echannelling.util.QueryConstants;

/**
 * implements methods insert,view,delete and update Booking
 */


public class BookingService implements IBookingService {

	/** initialize logger **/
	public static final Logger logger = Logger.getLogger(BookingService.class.getName());
	
	/** method for connection **/
	private static Connection conn;
	
	private PreparedStatement preparedStatement;
	
	/**
	 * no return value
	 * inserted feedbacks send to database
	 *  
	 * 
	 * @param booking object
	 * 
	 * @throws SQLException
	 * @throws SAXException 
	 * @throws IOException 
	 * @throws ParserConfigurationException
	 * @throws ClassNotFoundException e
	 * 
	 */
	@Override
	public void getBookingDetails( Booking booking )
	{
			String bID = DBconnProperty.remakeBookingID(gettingBookID());
				
			try {
				conn = DBconnectionUtil.getConnection();
				
				preparedStatement = conn.prepareStatement(DBconnXML.getIdByQuery(QueryConstants.INSERT_BOOKING ));
				conn.setAutoCommit(false);
					
				booking.setbID(bID);
					
				preparedStatement.setString(QueryConstants.COLUMN_ONE, booking.getbID());
				preparedStatement.setString(QueryConstants.COLUMN_TWO, booking.gethID());
				preparedStatement.setString(QueryConstants.COLUMN_THREE, booking.getsID() );
				preparedStatement.setString(QueryConstants.COLUMN_FOUR, booking.getdID() );
				preparedStatement.setString(QueryConstants.COLUMN_FIVE, booking.getcName());
				preparedStatement.setString(QueryConstants.COLUMN_SIX, booking.getcEmail());
				preparedStatement.setString(QueryConstants.COLUMN_SEVEN, booking.getcNIC());
				preparedStatement.setString(QueryConstants.COLUMN_EIGTH, booking.getCardName());
				preparedStatement.setString(QueryConstants.COLUMN_NINE, booking.getCardNo());
				preparedStatement.setString(QueryConstants.COLUMN_TEN, booking.getExpDate());
				preparedStatement.setString(QueryConstants.COLUMN_ELEVEN, booking.getCvc());
				preparedStatement.setString(QueryConstants.COLUMN_TWELVE, booking.getFee());
					
				//insert data into database,query execute in here
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
	 * @return String ArrayList which contain booking ids
	 *  
	 * 
	 * @throws SQLException
	 * @throws SAXException 
	 * @throws IOException 
	 * @throws ParserConfigurationException
	 * @throws ClassNotFoundException e
	 */
	
	private ArrayList<String> gettingBookID() {
	
		ArrayList<String> arrayList = new ArrayList<String>();
		
		try {
			conn = DBconnectionUtil.getConnection();
		
			preparedStatement = conn.prepareStatement(DBconnXML.getIdByQuery(QueryConstants.GET_BOOKING_IDS));
		
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
	 * booking is delete in this method
	 * no return type
	 * 
	 * 
	 * @param bID,type
	 * 
	 * @throws SQLException
	 * @throws SAXException 
	 * @throws IOException 
	 * @throws ParserConfigurationException
	 * @throws ClassNotFoundException e
	 */
	@Override
	public void removeBoking(String bID, String type) {
		
		//check bID is null or empty
		if ( bID != null && !bID.isEmpty()) {
					
			try {
				
				conn = DBconnectionUtil.getConnection();
	
				if(type.equalsIgnoreCase("dID")) {
					
					//when doctor is deleted bookings for that doctor must be delete
					//delete particuler doctor booking using passing type parameter
					preparedStatement = conn.prepareStatement(DBconnXML.getIdByQuery(QueryConstants.DELETE_BOOKING_BY_dID));
					preparedStatement.setString(QueryConstants.COLUMN_ONE, bID);
				
				}
				else if(type.equalsIgnoreCase("hID")) {
					
					//when hospital is deleted bookings for that hospita must be delete
					//delete particuler hospital booking using passing type parameter
					preparedStatement = conn.prepareStatement(DBconnXML.getIdByQuery(QueryConstants.DELETE_BOOKING_BY_hID));
					preparedStatement.setString(QueryConstants.COLUMN_ONE, bID);
					
				}
				else if(type.equalsIgnoreCase("sID")) {
					
					//when session is deleted bookings for that session must be delete
					//delete particular session booking using passing type parameter
					preparedStatement = conn.prepareStatement(DBconnXML.getIdByQuery(QueryConstants.DELETE_BOOKING_BY_sID));
					preparedStatement.setString(QueryConstants.COLUMN_ONE, bID);
					
				}
				else {
					
					//delete booking when patient cancel booking
					preparedStatement = conn.prepareStatement(DBconnXML.getIdByQuery(QueryConstants.DELETE_BOOKING_BY_bID));
					preparedStatement.setString(QueryConstants.COLUMN_ONE, bID);
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
	 * show all booking for given doctor id
	 * 
	 * 
	 * @param ddID
	 * 
	 * @return bookList
	 * 
	 * @throws SQLException
	 * @throws SAXException 
	 * @throws IOException 
	 * @throws ParserConfigurationException
	 * @throws ClassNotFoundException e
	 */
	
	@Override
	public ArrayList<Booking> viewNoOfBooking(String ddID) {
		
		ArrayList<Booking> bookList = new ArrayList<Booking>();
		
		try {
			conn = DBconnectionUtil.getConnection();
			
			//check doctor id is empty or null
			if (ddID != null && !ddID.isEmpty()) {
				
				preparedStatement = conn.prepareStatement(DBconnXML.getIdByQuery(QueryConstants.GET_NO_OF_BOOKING));
				preparedStatement.setString(QueryConstants.COLUMN_ONE, ddID);
			}
			
			ResultSet resultSet = preparedStatement.executeQuery();	
			
			while(resultSet.next()) {
				
				Booking booking = new Booking();
				
				booking.setbID(resultSet.getString(QueryConstants.COLUMN_ONE));
				booking.sethID(resultSet.getString(QueryConstants.COLUMN_TWO));
				booking.setsID(resultSet.getString(QueryConstants.COLUMN_THREE));
				booking.setdID(resultSet.getString(QueryConstants.COLUMN_FOUR));
				booking.setcName(resultSet.getString(QueryConstants.COLUMN_FIVE));
				booking.setcEmail(resultSet.getString(QueryConstants.COLUMN_SIX));
				booking.setcNIC(resultSet.getString(QueryConstants.COLUMN_SEVEN));
				booking.setCardName(resultSet.getString(QueryConstants.COLUMN_EIGTH));
				booking.setCardNo(resultSet.getString(QueryConstants.COLUMN_NINE));
				booking.setExpDate(resultSet.getString(QueryConstants.COLUMN_TEN));
				booking.setCvc(resultSet.getString(QueryConstants.COLUMN_ELEVEN));
				booking.setFee(resultSet.getString(QueryConstants.COLUMN_TWELVE));
				booking.setNoOfBooking(resultSet.getString(QueryConstants.COLUMN_THIRTEEN));
				
				//add booking object to array list 
				bookList.add(booking);
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
			
		return bookList;
	}


	/**
	 * booking is update in this method
	 * no return type
	 * 
	 * 
	 * @param bID,cName,cEmail,cNIC
	 * 
	 * @throws SQLException
	 * @throws SAXException 
	 * @throws IOException 
	 * @throws ParserConfigurationException
	 * @throws ClassNotFoundException e
	 */
	@Override
	public void updatecustomer(String bID, String cName, String cEmail, String cNIC) {
		
		//check given booking id is null or empty
		if (bID != null && !bID.isEmpty()) {
		
			try {
				conn = DBconnectionUtil.getConnection();
				preparedStatement = conn.prepareStatement(DBconnXML.getIdByQuery(QueryConstants.UPDATE_BOOKING));
			
				preparedStatement.setString(QueryConstants.COLUMN_ONE,cName );
				preparedStatement.setString(QueryConstants.COLUMN_TWO,cEmail );
				preparedStatement.setString(QueryConstants.COLUMN_THREE,cNIC );
				preparedStatement.setString(QueryConstants.COLUMN_FOUR, bID );
													
				//query is execute in here
				preparedStatement.executeUpdate();

		} catch (SQLException | SAXException | IOException | ParserConfigurationException
				| ClassNotFoundException e) {
			logger.log(Level.SEVERE, e.getMessage());
		} finally {
			
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				logger.log(Level.SEVERE, e.getMessage());
				}
			}
	
		}
	
	}


}







