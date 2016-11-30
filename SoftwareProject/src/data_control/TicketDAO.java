package data_control;

import model.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import controller.SystemController;

public class TicketDAO extends BaseDAO {
	public static int createTicket(Ticket ticket) {
		PreparedStatement ps = null;
		Statement st = null;
		ResultSet res = null;
		int id = -1;
		
		String sql = "INSERT INTO Ticket(type, oneWayTicket, price, startsation, endstation, date) VALUES(?,?,?,?,?,?)";
		
		try {

	        if (getConnection().isClosed()) {
	            throw new IllegalStateException("error unexpected");
	        }
	        ps = getConnection().prepareStatement(sql);
	        
	        ps.setString(1, ticket.getTypeTicket());
	        ps.setBoolean(2, ticket.isOneWayTicket());
	        ps.setDouble(3, ticket.getPrice());
	        ps.setString(4, ticket.getStartStation());
	        ps.setString(5, ticket.getEndStation());
	        ps.setDate(6, ticket.getDate());
	        
	        ps.executeUpdate();
	        
	        st = getConnection().createStatement();
	        res = st.executeQuery("SELECT ID FROM Price ORDER BY ID DESC LIMIT 1");
	        if (res.next()) {
	        	id = res.getInt(1);
	        }
	        ps.close();
	        res.close();
	        // Maken van de logfile met text
			String s = "Een ticket  met id : "+ id+ " werdt toegevoed door user " + SystemController.system.logged_user.getFirstName()
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
	
	public static void updateTicket(Ticket ticket) {
		PreparedStatement ps = null;	
		String update = "UPDATE Ticket SET type=?, oneWayTicket=?, price=?, startstation=?, endstation=?, date=? WHERE ID = ?";
		
		try {
		if (getConnection().isClosed()) {
			throw new IllegalStateException("error unexpected");
		}
			ps = getConnection().prepareStatement(update);
		
			ps.setString(1, ticket.getTypeTicket());
			ps.setBoolean(2, ticket.isOneWayTicket());
			ps.setDouble(3, ticket.getPrice());
			ps.setString(4, ticket.getStartStation());
			ps.setString(5, ticket.getEndStation());
			ps.setDate(6, ticket.getDate());
			ps.setInt(7, ticket.getId());
			
			ps.executeUpdate();
			ps.close();
			  // Maken van de logfile met text
			String s = "Een ticket  met id : "+ ticket.getId()+ " werdt gewijzigd door user " + SystemController.system.logged_user.getFirstName()
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
	
	public static Ticket findTicketById(int id) {
		Statement st = null;
		Ticket t = null;
		ResultSet res = null;
		
		try {
			if (getConnection().isClosed()) {
				throw new IllegalStateException("error unexpected");
			}
			st = (Statement) getConnection().createStatement();
			res = st.executeQuery("SELECT * FROM Ticket WHERE ID = " + id);

			while (res.next()) {
				t = new Ticket(res.getInt(1), res.getString(2), res.getBoolean(3), res.getDouble(4), res.getString(5), res.getString(6), res.getDate(7));

			}
			// Maken van de logfile met text
						String s = "Een ticket  met id : "+ id+ " werdt gezocht door user " + SystemController.system.logged_user.getFirstName()
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

		return t;
	}
	
	public static ArrayList<Ticket> getAllTickets() {
		ArrayList<Ticket> list = new ArrayList<Ticket>();
		ResultSet res = null;
		Statement st = null;
		try {
			if (getConnection().isClosed()) {
				throw new IllegalStateException("error unexpected");
			}
			st = (Statement) getConnection().createStatement();
			res = st.executeQuery("SELECT * FROM Ticket");

			while (res.next()) {
				Ticket t = new Ticket(res.getInt(1), res.getString(2), res.getBoolean(3), res.getDouble(4), res.getString(5), res.getString(6), res.getDate(7));
				list.add(t);
			}
			// Maken van de logfile met text
						String s = "Alle tickets werdt gezocht door user " + SystemController.system.logged_user.getFirstName()
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
}