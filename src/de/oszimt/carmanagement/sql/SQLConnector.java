package de.oszimt.carmanagement.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class SQLConnector {

	
	private static final String USER = "user";
	private static final String PASSWD = "katzen";
	private static final String URL = "jdbc:mysql://localhost:3306/carDB?user="+USER+"&password="+PASSWD+"&serverTimezone=UTC";
	public static String getPasswd() {
		return PASSWD;
	}

	public Statement getStmt() {
		return stmt;
	}

	private Statement stmt;
	private Connection con;

	public SQLConnector() {

		try {
			con = DriverManager.getConnection(URL, USER, PASSWD);
			stmt = con.createStatement();
			String sql = "CREATE DATABASE IF NOT EXISTS carDB;";
	        stmt.executeUpdate(sql);
	        createTables();
	        
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void disconnect(){
		try {
			stmt.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void createTables() {
		String sql = "CREATE TABLE IF NOT EXISTS CAR "
				+ "(car_id INTEGER NOT NULL AUTO_INCREMENT, "
				+ "location VARCHAR(255), "
				+ "type VARCHAR(255), "
				+ "status VARCHAR(255), "
				+ "price DECIMAL(7,2), "
				+ "km DECIMAL(7,2), "
				+ "PRIMARY KEY (car_id))";
		try {
			stmt.executeUpdate(sql);
			
			sql = "CREATE TABLE IF NOT EXISTS BRAND "
					+ "(brand_id INTEGER NOT NULL AUTO_INCREMENT, "
					+ "car_id INTEGER NOT NULL, "
					+ "name VARCHAR(255), "
					+ "PRIMARY KEY (brand_id), "
					+ "FOREIGN KEY (car_id) REFERENCES CAR(car_id))";
			
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Connection getCon() {
		return con;
	}

}
