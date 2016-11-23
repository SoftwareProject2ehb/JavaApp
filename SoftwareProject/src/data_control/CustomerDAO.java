package data_control;

import model.*;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
public class CustomerDAO extends BaseDAO {
	
	/*
	 * Voorbeeldgebruik van SELECT na INSERT om de auto-increased ID terug te krijgen.
	 * */
	public static int createCustomer(Customer customer) {
		PreparedStatement ps = null;
		Statement st = null;
		int id = 0;
		
		String sql = "INSERT INTO Customer (first_name, last_name, address, email, phone)VALUES(?,?,?,?,?)";
		
		try {

	        if (getOpenConnection().isClosed()) {
	            throw new IllegalStateException("error unexpected");
	        }
	        ps = getOpenConnection().prepareStatement(sql);
	        
	        ps.setString(1, customer.getFirstName());
	        ps.setString(2, customer.getLastName());
	        ps.setString(3, customer.getAddress());
	        ps.setString(4, customer.getEmail());
	        ps.setString(5, customer.getPhone());
	  
	       ps.executeUpdate();
	       
	       if (ps != null)
               ps.close();
	       
	       sql = "SELECT ID FROM Customer ORDER BY ID DESC LIMIT 1";
	       st = getOpenConnection().createStatement();
	       
	       ResultSet res = st.executeQuery(sql);
	        
	        if (res.next()) {
	        	id = res.getInt(1);
			}
	       
	    } catch (SQLException e) {
	        System.out.println(e.getMessage());
	        throw new RuntimeException(e.getMessage());
	    } finally {
	        try {
	            if (ps != null)
	                ps.close();
	            if (st != null)
	                st.close();

	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	            throw new RuntimeException("error.unexpected");
	        }
	    }
		return id;
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
	
	public static int findNextId() {
		int id = 0;
		Statement st = null;
		
		try {

	        if (getConnection().isClosed()) {
	            throw new IllegalStateException("error unexpected");
	        }
	        
	        st = (Statement) getConnection().createStatement();
	        ResultSet res = st.executeQuery("SELECT MAX(ID) FROM Customer");
	        
	        if (res.next()) {
	        	id = res.getInt(1);

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
		
		return id + 1;
	}
}
