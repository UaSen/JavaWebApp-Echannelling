package com.echannelling.util;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *  load the the sql queries in the QueryXML
 *  
 * 
 * @see #DBconnProperty
 */

public class DBconnXML extends DBconnProperty{
	
	/**
	 * This method read the QueryXML.xml file and retrieve the query by "query ids"
	 * @param id
	 * 
	 * @return 
	 * 
	 * @throws SAXException
	 * @throws IOException
	 * @throws ParserConfigurationException
	 * 
	 */

	public static String getIdByQuery( String id ) throws SAXException, IOException, ParserConfigurationException {
		
		
		NodeList nodeList;
		Element element = null;
		
		/** read queryXML 
		 * refer tag name
		 * **/
		nodeList = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new File(System.getProperty("catalina.base") + "\\wtpwebapps\\echannelling\\WEB-INF\\QueryXML.xml" ))
				.getElementsByTagName(QueryConstants.TAG_NAME);
		
		
		/**
		 * extract the node from node list using query id
		 */
		
		for( int length = 0; length < nodeList.getLength(); length++ )
		{
			element = (Element) nodeList.item(length);
			
			if( element.getAttribute(QueryConstants.GET_ID).equals(id))
				break;
		}
		
		/**
		 * return queries which get from TAG_NAME + GET_ID
		 */
		return element.getTextContent().trim();
		
	}
	
}
