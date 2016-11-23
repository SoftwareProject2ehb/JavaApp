package data_control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseConnect {


	private static DatabaseConnect ref;
	private Connection connect;
	private  DatabaseConnect(){
	        
	            try {
	                Class.forName("com.mysql.jdbc.Driver").newInstance();
	            } catch (ClassNotFoundException e) {
	                //System.out.println(e.getMessage());
	            	e.printStackTrace();
	            } catch (InstantiationException e) {
	                //System.out.println(e.getMessage());
	            } catch (IllegalAccessException e) {
	                //System.out.println(e.getMessage());
	            }
	        
	}
	
	public static DatabaseConnect getInstance(){
	        if(ref == null)
	            ref = new DatabaseConnect();
	        return ref;
	}
	
	public Connection getConnection() throws SQLException{
		
	        if (connect == null || connect.isClosed()) 
	        {
	        	
	        	try {
	        		connect = DriverManager.getConnection("jdbc:mysql://dt5.ehb.be/SP2GR2", 
	        				DatabaseConnectProperties.USER, 
	        				DatabaseConnectProperties.PSW);
	        	} catch (SQLException e) {
	        		System.out.println("SQLException: " + e.getMessage());
					System.out.println("SQLState: " + e.getSQLState());
					System.out.println("VendorError: " + e.getErrorCode());
	        }
	        }
	        return connect;
	 }
	    
	}