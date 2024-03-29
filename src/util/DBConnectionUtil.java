package util;

/**
 * @author janith
 *
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionUtil  extends CommonUtil {


	
	private static Connection connection;
	
	private DBConnectionUtil() {
		
		// singleton pattern applied
		
	}
	
	public static Connection getDBConnection() throws ClassNotFoundException, SQLException {
		/*
		 * This create new connection objects when connection is closed or it is null
		 */
		if (connection == null || connection.isClosed()) {

			Class.forName(properties.getProperty(CommonConstants.DRIVER_NAME));
			
			connection = DriverManager.getConnection(properties.getProperty(CommonConstants.URL),
					
					properties.getProperty(CommonConstants.USERNAME), properties.getProperty(CommonConstants.PASSWORD));
		}
		
		return connection;
	}
	
}
