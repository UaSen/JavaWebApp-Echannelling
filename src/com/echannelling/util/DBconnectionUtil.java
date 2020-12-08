package com.echannelling.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * This DBconnectionUtil create database connection
 * 
 * @see #DBconnProperty
 */

public class DBconnectionUtil extends DBconnProperty{

	
	private static Connection conn;
	
	//works according to singleton pattern
	private DBconnectionUtil()
	{
		
	}
	
	/**
	 * Create Database connection for the given URL, user name and password
	 * 
	 * @return sql connection for MySql database
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException
	{
		/**
		 * create new connection when connection is close or null
		 */
		
		if( conn == null || conn.isClosed() )
		{
			Class.forName(properties.getProperty(QueryConstants.DRIVER_NAME));
			conn = DriverManager.getConnection(properties.getProperty(QueryConstants.URL),
					properties.getProperty(QueryConstants.USERNAME),
					properties.getProperty(QueryConstants.PASSWORD));
					
		}
		
		return conn;
	}	

	
}



