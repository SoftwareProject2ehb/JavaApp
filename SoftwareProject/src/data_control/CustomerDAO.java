package data_control;

import model.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Statement;

public class CustomerDAO extends BaseDAO {
	
	public static void createCustomer(Customer customer) {
		PreparedStatement ps = null;
		
		String sql = "INSERT INTO Customer VALUES(?,?,?,?,?,?)";
		
		try {

	        if (getConnection().isClosed()) {
	            throw new IllegalStateException("error unexpected");
	        }
	        ps = getConnection().prepareStatement(sql);
	        
	        ps.setInt(1, customer.getId());
	        ps.setString(2, customer.getFirstName());
	        ps.setString(3, customer.getLastName());
	        ps.setString(4, customer.getAddress());
	        ps.setString(5, customer.getEmail());
	        ps.setString(6, customer.getPhone());
	  
	        
	       ps.executeUpdate();
	    } catch (SQLException e) {
	        System.out.println(e.getMessage());
	        throw new RuntimeException(e.getMessage());
	    } finally {
	        try {
	            if (ps != null)
	                ps.close();

	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	            throw new RuntimeException("error.unexpected");
	        }
	    }
	}
	
	public static void removeCustomer(Customer customer) {
		PreparedStatement ps = null;
		
		String sql = "DELETE FROM Customer WHERE id = ?";
		
		try {

	        if (getConnection().isClosed()) {
	            throw new IllegalStateException("error unexpected");
	        }
	        ps = getConnection().prepareStatement(sql);
	        
	        ps.setInt(1, customer.getId());
	        
	        ps.executeUpdate();
	        
	    } catch (SQLException e) {
	        System.out.println(e.getMessage());
	        throw new RuntimeException(e.getMessage());
	    } finally {
	        try {
	            if (ps != null)
	                ps.close();

	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	            throw new RuntimeException("error.unexpected");
	        }
	    }
	}
	
	public static void updateCustomer(Customer customer) {
		PreparedStatement ps = null;
		
		String sql = "UPDATE Customer SET ID = ?, first_name = ?, last_name = ?, address = ?, email = ?, phone = ?";
		
		try {

	        if (getConnection().isClosed()) {
	            throw new IllegalStateException("error unexpected");
	        }
	        ps = getConnection().prepareStatement(sql);
	        
	        ps.setInt(1, customer.getId());
	        ps.setString(2, customer.getFirstName());
	        ps.setString(3, customer.getLastName());
	        ps.setString(4, customer.getAddress());
	        ps.setString(5, customer.getEmail());
	        ps.setString(6, customer.getPhone());
	  
	        
	       ps.executeUpdate();
	    } catch (SQLException e) {
	        System.out.println(e.getMessage());
	        throw new RuntimeException(e.getMessage());
	    } finally {
	        try {
	            if (ps != null)
	                ps.close();

	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	            throw new RuntimeException("error.unexpected");
	        }
	    }
	}
	
	public static Customer findCustomerById(int id) {
		
		Customer cust = null;
		
		Statement st = null;
		
		try {

	        if (getConnection().isClosed()) {
	            throw new IllegalStateException("error unexpected");
	        }
	        
	        st = (Statement) getConnection().createStatement();
	        ResultSet res = st.executeQuery("SELECT * FROM Customer WHERE ID = " + id + " LIMIT 1");
	        
	        if (res.next()) {
	        	cust = new Customer(res.getInt(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getString(6));

			}
	        
	    } catch (SQLException e) {
	        System.out.println(e.getMessage());
	        throw new RuntimeException(e.getMessage());
	    } finally {
	        try {
	            if (st != null)
	            	st.close();

	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	            throw new RuntimeException("error.unexpected");
	        }
	    }
		
		return cust;
	}
	
}
