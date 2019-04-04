package com.rbms.rest.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnection {

	private Connection conn;

    public DatabaseConnection() {}

    //Establishes Connection
    public void setConnection(String database, String user, String password){
            
        String format = String.format("jdbc:postgresql://localhost/%s", database);
        Properties props = new Properties();
        props.put("user", user);
        props.put("password", password);
        
        try {
        	this.conn = DriverManager.getConnection(format, props);
            this.conn.setAutoCommit(true);
        } 
        catch (SQLException e){
                System.out.println(e.getMessage());
        }
    }

    //Returns Connection Object
    public Connection getConnection(){
    	return this.conn;
    }

    //Closes Connection
    public void closeConnection() {
            
    	try {
    		this.conn.close();
        } 
        catch (SQLException e) {
        	System.out.println(e.getMessage());
        }
    }
    
	//Helps establish connection to the database
	public static Connection establishConnection() throws Exception {
		
		Connection connection = null;
		
		try {
			String url = "jdbc:postgresql://localhost:5432/postgres";
			String username = "postgres";
			String password = "admin";
            Class.forName("org.postgresql.Driver");

            connection = DriverManager.getConnection(url, username, password);
			
		} catch(Exception e) {
			System.out.println("Connection failed. Please reset the connections.");
			e.printStackTrace();
		}
		
		return connection;
	}
	
    
}