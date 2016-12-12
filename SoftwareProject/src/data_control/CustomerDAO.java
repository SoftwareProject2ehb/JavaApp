package data_control;

import model.*;
import controller.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;

public class CustomerDAO extends BaseDAO {
	/**
	 * @param customer The object of type Customer that should be created in the database.
	 * @return The ID of the record containing the created Customer. This ID should be used to set the ID of the Customer object locally.
	 */
	public static int createCustomer(Customer customer) {
		PreparedStatement ps = null;
		Statement st = null;
		ResultSet res = null;
		int id = -1;
		
		String sql = "INSERT INTO Customer (first_name, last_name, address, email, phone) VALUES(?,?,?,?,?)";
		
		try {

	        if (getConnection().isClosed()) {
	            throw new IllegalStateException("error unexpected");
	        }
	        ps = getConnection().prepareStatement(sql);
	        
	        ps.setString(1, customer.getFirstName());
	        ps.setString(2, customer.getLastName());
	        ps.setString(3, customer.getAddress());
	        ps.setString(4, customer.getEmail());
	        ps.setString(5, customer.getPhone());
	  
	       ps.executeUpdate();
	       
	       st = getConnection().createStatement();
	       res = st.executeQuery("SELECT ID FROM Customer ORDER BY ID DESC LIMIT 1");
	       
	       if (res.next()) {
	        	id = res.getInt(1);
			}
	       
	    // Maken van de logfile met text
			String s = "Een customer met id : "+  id + " werdt aangemaakt door user " + SystemController.system.logged_user.getFirstName()
			+" "+SystemController.system.logged_user.getLastName()+ " met ID : " +SystemController.system.logged_user.getUserID();
			LogFile log = new LogFile(s, SystemController.system.logged_user.getUserID());
			LogFileDAO.createLogFile(log);
		// Eind maken van logfile
	    } catch (SQLException e) {
	        System.out.println(e.getMessage());
	        throw new RuntimeException(e.getMessage());
	    } finally {
	        try {
	            if (ps != null)
	                ps.close();
	            if (st != null)
	                st.close();
	            if (res != null)
	                res.close();
	            if (!getConnection().isClosed())
	            	getConnection().close();

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
	     // Maken van de logfile met text
	     			String s = "Een customer met id : "+  customer.getId() + " werdt verwijderd door user " + SystemController.system.logged_user.getFirstName()
	     			+" "+SystemController.system.logged_user.getLastName()+ " met ID : " +SystemController.system.logged_user.getUserID();
	     			LogFile log = new LogFile(s, SystemController.system.logged_user.getUserID());
	     			LogFileDAO.createLogFile(log);
	     		// Eind maken van logfile
	    } catch (SQLException e) {
	        System.out.println(e.getMessage());
	        throw new RuntimeException(e.getMessage());
	    } finally {
	        try {
	            if (ps != null)
	                ps.close();
	            if (!getConnection().isClosed())
	            	getConnection().close();

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
	    // Maken van de logfile met text
			String s = "Een customer met id : "+  customer.getId() + " werdt verwijderd door user " + SystemController.system.logged_user.getFirstName()
			+" "+SystemController.system.logged_user.getLastName()+ " met ID : " +SystemController.system.logged_user.getUserID();
			LogFile log = new LogFile(s, SystemController.system.logged_user.getUserID());
			LogFileDAO.createLogFile(log);
		// Eind maken van logfile
	    } catch (SQLException e) {
	        System.out.println(e.getMessage());
	        throw new RuntimeException(e.getMessage());
	    } finally {
	        try {
	            if (ps != null)
	                ps.close();
	            if (!getConnection().isClosed())
	            	getConnection().close();

	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	            throw new RuntimeException("error.unexpected");
	        }
	    }
	}
	
	public static Customer findCustomerById(int id) {
		
		Customer cust = null;
		ResultSet res = null;
		Statement st = null;
		
		try {

	        if (getConnection().isClosed()) {
	            throw new IllegalStateException("error unexpected");
	        }
	        
	        st = (Statement) getConnection().createStatement();
	        res = st.executeQuery("SELECT * FROM Customer WHERE ID = " + id + " LIMIT 1");
	        
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
	            if (res != null)
	            	res.close();
	            if (!getConnection().isClosed())
	            	getConnection().close();

	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	            throw new RuntimeException("error.unexpected");
	        }
	    }
		
		return cust;
	}
	public static ArrayList<Customer> getCustomerByMultipleArgs(String Voornaam, String Achternaam,String Adress, String Phone, String Email) {
		ArrayList<Customer> lijst = new ArrayList<Customer>();
		
		if (Voornaam == null && Achternaam == null && Adress == null && Phone == null && Email == null) {
			return lijst;
		}
		
		Statement st = null;
		try {
			if (getConnection().isClosed()) {
				throw new IllegalStateException("error unexpected");
			}
			String sql_syntax = "SELECT * FROM Customer WHERE  ";
			
			if (Voornaam != null && !Voornaam.equals("")) {
				sql_syntax = sql_syntax.concat("first_name LIKE '%" + Voornaam +"%'");
			}
			
			if (Achternaam != null && !Achternaam.equals("")) {
				sql_syntax = sql_syntax.concat(" AND  last_name LIKE '%" + Achternaam +"%'" );
			}
			if (Adress != null && !Adress.equals("")) {
				sql_syntax = sql_syntax.concat(" AND address LIKE '%" + Adress +"%'" );
			}
			if (Phone != null && !Phone.equals("")) {
				sql_syntax = sql_syntax.concat(" AND phone LIKE '%" + Phone+"%'" );
			}
			if (Email != null && !Email.equals("")) {
				sql_syntax = sql_syntax.concat(" AND email LIKE '%" + Email+"%'" );
			}
			
			
			
			
			
			ResultSet res = null;
			try {
				st = (Statement) getConnection().createStatement();
				res = st.executeQuery(sql_syntax);
				while (res.next()) {
					Customer cust = new Customer(res.getInt(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getString(6));
					lijst.add(cust);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				e.getMessage();
			} finally {
				if (res != null)
	                res.close();
				if (st != null)
	                st.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			e.getMessage();
		} finally {
	        try {
	            if (st != null)
	                st.close();
	            if (!getConnection().isClosed())
					getConnection().close();

	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	            throw new RuntimeException("error.unexpected");
	        }
	    }

		return lijst;
		}
	}

