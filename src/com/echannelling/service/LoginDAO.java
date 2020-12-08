package com.echannelling.service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.echannelling.util.DBconnXML;
import com.echannelling.util.DBconnectionUtil;
import com.echannelling.util.QueryConstants;

/**
 * implements method read inputs and validate login 
 *  
 *
 */


public class LoginDAO implements iLoginDAO{
	
	/** initialize logger **/
	public static final Logger logger = Logger.getLogger(LoginDAO.class.getName());
	
	/** method for connection **/
	private static Connection conn;
	
	private PreparedStatement preparedStatement;
	
	/**
	 * entered user name email or password is validating and confirm login
	 * 
	 * @return true or false
	 * 
	 * 
	 * @param userName,password
	 * 
	 * @throws SQLException
	 * @throws SAXException 
	 * @throws IOException 
	 * @throws ParserConfigurationException
	 * @throws ClassNotFoundException e
	 */
	@Override
	public boolean check(String userName, String password)
	{
	
		try {
		
			conn = DBconnectionUtil.getConnection();

			preparedStatement = conn.prepareStatement(DBconnXML.getIdByQuery(QueryConstants.LOGIN));
		
			//pass username or email and password for validating
			preparedStatement.setString(QueryConstants.COLUMN_ONE, userName );
			preparedStatement.setString(QueryConstants.COLUMN_TWO, userName);
			preparedStatement.setString(QueryConstants.COLUMN_THREE, password);

			ResultSet resultSet = preparedStatement.executeQuery();
				
			if(resultSet.next())
			{
				return true;
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
		
		return false;
	}
	
	
	

}
