package databaseConnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseConnect {

	private DatabaseConnect ref;
	
	public  DatabaseConnect(){
	        
	            try {
	                Class.forName("com.jdbc.mysql.Driver").newInstance();
	            } catch (ClassNotFoundException e) {
	                //System.out.println(e.getMessage());
	            } catch (InstantiationException e) {
	                //System.out.println(e.getMessage());
	            } catch (IllegalAccessException e) {
	                //System.out.println(e.getMessage());
	            }
	        
	    }
	    public DatabaseConnect getInstance(){
	        if(ref == null)
	            ref = new DatabaseConnect();
	        return ref;
	    }
	    public Connection getConnection(){
	        Connection conn = null;
	        try {
	            conn = DriverManager.getConnection("jdbc:mysql://dt5.ehb.be/SP2GR2", 
	            		DatabaseConnectProperties.USER, 
	            		DatabaseConnectProperties.PSW);
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
	        return conn;
	    }
	    
	}