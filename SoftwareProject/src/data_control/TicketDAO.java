package data_control;

import model.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Statement;

public class TicketDAO extends BaseDAO {
	public static void createTicket(Ticket ticket) {
		PreparedStatement ps = null;
		
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
			ps.setInt(7, ticket.getID());
			
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new RuntimeException(e.getMessage());
		}
	}
	
	public static Ticket findTicketById(int id) {
		Statement st = null;
		Ticket t = null;
		try {
			if (getConnection().isClosed()) {
				throw new IllegalStateException("error unexpected");
			}
			st = (Statement) getConnection().createStatement();
			ResultSet res = st.executeQuery("SELECT * FROM Ticket WHERE ID = " + id);

			while (res.next()) {
				t = new Ticket(res.getInt(1), res.getString(2), res.getBoolean(3), res.getDouble(4), res.getString(5), res.getString(6), res.getDate(7));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return t;
	}
	
	public static ArrayList<Ticket> getAllTickets() {
		ArrayList<Ticket> list = new ArrayList<Ticket>();
		
		Statement st = null;
		try {
			if (getConnection().isClosed()) {
				throw new IllegalStateException("error unexpected");
			}
			st = (Statement) getConnection().createStatement();
			ResultSet res = st.executeQuery("SELECT * FROM Ticket");

			while (res.next()) {
				Ticket t = new Ticket(res.getInt(1), res.getString(2), res.getBoolean(3), res.getDouble(4), res.getString(5), res.getString(6), res.getDate(7));
				list.add(t);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}
	
	public static int findNextId() {
		int id = 0;
		Statement st = null;
		
		try {

	        if (getConnection().isClosed()) {
	            throw new IllegalStateException("error unexpected");
	        }
	        
	        st = (Statement) getConnection().createStatement();
	        ResultSet res = st.executeQuery("SELECT MAX(ID) FROM Ticket");
	        
	        if (res.next()) {
	        	id = res.getInt(0);

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