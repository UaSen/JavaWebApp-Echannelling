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

import com.echannelling.model.Feedback;
import com.echannelling.util.DBconnXML;
import com.echannelling.util.DBconnectionUtil;
import com.echannelling.util.QueryConstants;
import com.echannelling.util.DBconnProperty;

public class FeedbackService implements iFeedbackService{
	
	/** initialize logger **/
	public static final Logger logger = Logger.getLogger(FeedbackService.class.getName());
	
	/** method for connection **/
	private static Connection conn;
	
	private PreparedStatement preparedStatement;
	

	/**
	 * no return value
	 * inserted feedbacks send to database
	 * 
	 * @param feedback object
	 * 
	 * @throws SQLException
	 * @throws SAXException 
	 * @throws IOException 
	 * @throws ParserConfigurationException
	 * @throws ClassNotFoundException e
	 * 
	 */
	@Override
	public void giveFeedback( Feedback fdbk )
	{
		String feedbackID = DBconnProperty.remakeFeedbackID( gettingFeedbackID() );
		
		try {
			conn = DBconnectionUtil.getConnection();
		
			preparedStatement = conn.prepareStatement(DBconnXML.getIdByQuery(QueryConstants.INSERT_FEEDBACK));
			conn.setAutoCommit(false);
			
			fdbk.setFeedbackID(feedbackID);
			
			preparedStatement.setString(QueryConstants.COLUMN_ONE, fdbk.getFeedbackID());
			preparedStatement.setString(QueryConstants.COLUMN_TWO, fdbk.getEmail());
			preparedStatement.setString(QueryConstants.COLUMN_THREE, fdbk.getSubject());
			preparedStatement.setString(QueryConstants.COLUMN_FOUR, fdbk.getComment());
			
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
	 * @return String ArrayList which contain feedback ids
	 * 
	 * 
	 * @throws SQLException
	 * @throws SAXException 
	 * @throws IOException 
	 * @throws ParserConfigurationException
	 * @throws ClassNotFoundException e
	 */
	
	private ArrayList<String> gettingFeedbackID(){
	
		ArrayList<String> arrayList = new ArrayList<String>();
	
		try {
			conn = DBconnectionUtil.getConnection();
		
			preparedStatement = conn.prepareStatement(DBconnXML.getIdByQuery(QueryConstants.GET_FEEDBACK_IDS));
		
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
	 * get all feedback list to a array list and return
	 * 
	 * 
	 * @return ArrayList<Feedback>
	 * 
	 * @see #viewFeedbackAction()
	 * 
	 */
	@Override
	public ArrayList<Feedback> viewFeedback()
	{
		return viewFeedbackAction();
	}

	/**
	 * show all feedback list
	 * 
	 * 
	 * @return fdbkList
	 * 
	 * @see #viewFeedback()
	 * 
	 */
	private ArrayList<Feedback> viewFeedbackAction() {
		
		ArrayList<Feedback> fdbkList = new ArrayList<Feedback>();
		
			try {
				conn = DBconnectionUtil.getConnection();
			
				//query to get all feedback list
				preparedStatement = conn.prepareStatement(DBconnXML.getIdByQuery(QueryConstants.SELECT_FEEDBACK));
				
				ResultSet resultSet = preparedStatement.executeQuery();
				
				while(resultSet.next()) {
					
					Feedback feedback = new Feedback();
					feedback.setFeedbackID(resultSet.getString(QueryConstants.COLUMN_ONE));
					feedback.setEmail(resultSet.getString(QueryConstants.COLUMN_TWO));
					feedback.setSubject(resultSet.getString(QueryConstants.COLUMN_THREE));
					feedback.setComment(resultSet.getString(QueryConstants.COLUMN_FOUR));
					
					//add all get data to array list using object
					fdbkList.add(feedback);
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
			
			return fdbkList;
		}
				
	
}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	




	

















