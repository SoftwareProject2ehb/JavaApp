package data_control;

import model.*;
import model.Price.betalingsType;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import controller.SystemController;
public class PriceDAO extends BaseDAO {
	public static int createPrice(Price price) {
		
		PreparedStatement ps = null;
		Statement st = null;
		ResultSet res = null;
		int id = -1;

		String sql = "INSERT INTO Price(typeTicket, typeBetaling, costPerUnit) VALUES(?,?,?)";
		
		try {

	        if (getConnection().isClosed()) {
	            throw new IllegalStateException("error unexpected");
	        }
	        ps = getConnection().prepareStatement(sql);
	        
	        ps.setString(1, price.getTypeTicket());
	        ps.setString(2, price.getTypeBetaling().toCapsString());
	        ps.setDouble(3, price.getCostPerUnit());
	        
	        ps.executeUpdate();
	        
	        st = getConnection().createStatement();
	        res = st.executeQuery("SELECT ID FROM Price ORDER BY ID DESC LIMIT 1");
	        if (res.next()) {
	        	id = res.getInt(1);
	        }
	        st.close();
	        
	        // Maken van de logfile met text
			String s = "Een prijs met id : "+  id + " werdt aangemaakt door user " + SystemController.system.logged_user.getFirstName()
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
	
	public static void removePrice(int id) {
		PreparedStatement ps = null;	
		String update = "DELETE FROM Price WHERE ID = ?";
		
		try {
		if (getConnection().isClosed()) {
			throw new IllegalStateException("error unexpected");
		}
			ps = getConnection().prepareStatement(update);
		
			ps.setInt(1, id);
			
			ps.executeUpdate();
			ps.close();
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
	
	public static void updatePrice(Price price) {
		PreparedStatement ps = null;	
		String update = "UPDATE Price SET typeTicket=?, typeBetaling=?, costPerUnit=? WHERE ID = ?";
		
		try {
		if (getConnection().isClosed()) {
			throw new IllegalStateException("error unexpected");
		}
			ps = getConnection().prepareStatement(update);
		
			ps.setString(1, price.getTypeTicket());
			ps.setString(2, price.getTypeBetaling().toCapsString());
			ps.setDouble(3, price.getCostPerUnit());
			ps.setInt(4, price.getId());
			
			ps.executeUpdate();
			ps.close();
			// Maken van de logfile met text
						String s = "Een prijs met id : "+ price.getId() + " werdt gewijzigd door user " + SystemController.system.logged_user.getFirstName()
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
	
	public static Price findPriceById(int id) {
		Statement st = null;
		Price p = null;
		ResultSet res = null;
		try {
			if (getConnection().isClosed()) {
				throw new IllegalStateException("error unexpected");
			}
			st = (Statement) getConnection().createStatement();
			res = st.executeQuery("SELECT * FROM Price WHERE ID = " + id);

			while (res.next()) {
				p = new Price(res.getInt(1), res.getString(2), betalingsType.stringToBetalingsType(res.getString(3)), res.getDouble(4));
			}
			
			// Maken van de logfile met text
			String s = "Een prijs met id : "+ id + " werdt gezocht door user " + SystemController.system.logged_user.getFirstName()
			+" "+SystemController.system.logged_user.getLastName()+ " met ID : " +SystemController.system.logged_user.getUserID();
			LogFile log = new LogFile(s, SystemController.system.logged_user.getUserID());
			LogFileDAO.createLogFile(log);
		// Eind maken van logfile
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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

		return p;
	}
	
	public static Price findPriceByType(String type) {
		PreparedStatement ps = null;
		Price p = null;
		ResultSet res = null;
		try {
			if (getConnection().isClosed()) {
				throw new IllegalStateException("error unexpected");
			}
			ps = getConnection().prepareStatement("SELECT * FROM Price WHERE typeTicket LIKE ?");
			
			ps.setString(1, type);
			
			res = ps.executeQuery();

			while (res.next()) {
				p = new Price(res.getInt(1), res.getString(2), betalingsType.stringToBetalingsType(res.getString(3)), res.getDouble(4));
			}
			
			// Maken van de logfile met text
			String s = "Een prijs met find type : "+ type + " werdt geozcht door user " + SystemController.system.logged_user.getFirstName()
			+" "+SystemController.system.logged_user.getLastName()+ " met ID : " +SystemController.system.logged_user.getUserID();
			LogFile log = new LogFile(s, SystemController.system.logged_user.getUserID());
			LogFileDAO.createLogFile(log);
		// Eind maken van logfile
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
	        try {
	            if (ps != null)
	            	ps.close();
	            if (res != null)
	            	res.close();
	            if (!getConnection().isClosed())
					getConnection().close();

	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	            throw new RuntimeException("error.unexpected");
	        }
	    }

		return p;
	}
	
		
	public static ArrayList<String> getAllTicketTypes() {
		ArrayList<String> list = new ArrayList<String>();
		ResultSet res = null;
		Statement st = null;
		try {
			if (getConnection().isClosed()) {
				throw new IllegalStateException("error unexpected");
			}
			st = (Statement) getConnection().createStatement();
			res = st.executeQuery("SELECT typeTicket FROM Price");

			while (res.next()) {
				list.add(res.getString(1));
			}
			// Maken van de logfile met text
			String s = "Alle types tickets werdt gewijzigd door user " + SystemController.system.logged_user.getFirstName()
			+" "+SystemController.system.logged_user.getLastName()+ " met ID : " +SystemController.system.logged_user.getUserID();
			LogFile log = new LogFile(s, SystemController.system.logged_user.getUserID());
			LogFileDAO.createLogFile(log);
		// Eind maken van logfile
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
		
		return list;
	}
	
	public static ArrayList<Price> getAll() {
		ArrayList<Price> list = new ArrayList<Price>();
		ResultSet res = null;
		
		Statement st = null;
		try {
			if (getConnection().isClosed()) {
				throw new IllegalStateException("error unexpected");
			}
			st = (Statement) getConnection().createStatement();
			res = st.executeQuery("SELECT * FROM Price");

			while (res.next()) {
				list.add(new Price(res.getInt(1), res.getString(2), betalingsType.stringToBetalingsType(res.getString(3)), res.getDouble(4)));
			}
			
			// TODO dit werkt niet
			/*
			// Maken van de logfile met text
			String s = "Alle tickets werdt gewijzigd door user " + SystemController.system.logged_user.getFirstName()
			+" "+SystemController.system.logged_user.getLastName()+ " met ID : " +SystemController.system.logged_user.getUserID();
			LogFile log = new LogFile(s, SystemController.system.logged_user.getUserID());
			LogFileDAO.createLogFile(log);
			// Eind maken van logfile
		  	*/
		 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
		
		return list;
	}
}