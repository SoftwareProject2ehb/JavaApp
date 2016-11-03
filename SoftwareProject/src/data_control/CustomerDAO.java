package data_control;

import model.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Statement;

public class CustomerDAO extends BaseDAO {
	
	public void createCustomer(Customer customer) {
		PreparedStatement ps = null;
		
		String sql = "INSERT INTO Customer VALUES(?,?,?,?,?,?)";
		
		try {

	        if (getCon().isClosed()) {
	            throw new IllegalStateException("error unexpected");
	        }
	        ps = getCon().prepareStatement(sql);
	        
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
	
	public void removeCustomer(Customer customer) {
		
	}
	
	public void updateCustomer(Customer customer) {
		
	}
	
	public Customer findCustomerById(int id) {
		
		return null;
	}
	
}
