package com.cognizant.bhaskar;

//Author : Bhaskar, Anil (360758)
//Email : anil.bhaskar@cognizant.com

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConfig {
	// JDBC driver name and database URL
	Properties properties = new Properties();
	FileInputStream fileIn = null;

	public Connection getConnection() {
		Connection conn = null;

		// STEP 2: Register JDBC driver
		try {
			fileIn = new FileInputStream("resources/db.properties");
			properties.load(fileIn);
			Class.forName(properties.getProperty("DB_DRIVER_CLASS"));
			
					
			System.out.println("Connecting to database...");

			conn = (Connection) DriverManager.getConnection(properties.getProperty("DB_URL"), properties.getProperty("DB_USERNAME"),
					properties.getProperty("DB_PASSWORD"));
			if(conn!=null){System.out.println("Connected.");}
		} catch (IOException | ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return conn;
	}// end main
}
