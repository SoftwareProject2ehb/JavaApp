package data_control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.*;
import model.User.Role;
import utilities.DateConverter;

public class SubscriptionDAO extends BaseDAO{
	
	public static void createSubscription(Subscription sub) {
		PreparedStatement ps = null;

		String sql = "INSERT INTO Subscription VALUES (?,?,?,?,?,?,?,?,1)";

		try {

			if (getConnection().isClosed()) {
				throw new IllegalStateException("error unexpected");
			}
			ps = getConnection().prepareStatement(sql);

			ps.setInt(1, sub.getId());
			ps.setInt(2, sub.getTicketType());
			ps.setDouble(3, sub.getPrice());
			ps.setInt(4, sub.getCustomerId());
			ps.setString(5, sub.getStartStation());
			ps.setString(6, sub.getEndStation());
			
			
			ps.setDate(7, sub.getStartDate());
			ps.setDate(8, sub.getEndDate());

			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			;
			throw new RuntimeException(e.getMessage());
		} finally {
			try {
				if (ps != null)
					ps.close();

			} catch (SQLException e) {
				System.out.println(e.getMessage());
				
				throw new RuntimeException(e.getMessage());
			}
		}

	}
	
	public static ArrayList<Subscription> getAllSubs() {
		ArrayList<Subscription> lijst = new ArrayList<Subscription>();
		PreparedStatement st = null;
		
		String sql = "SELECT * FROM Subscription";
		
		try {
			if (getConnection() == null || getConnection().isClosed()) {
				// afhandelen zoals je zelf wilt
				throw new IllegalStateException("Connection onverwacht beeindigd");
			}
			st = getConnection().prepareStatement(sql);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				Subscription sb = new Subscription(rs.getInt("id"), 
						rs.getInt("type"),
						rs.getDouble("price"), 
						rs.getInt("customer"),
						rs.getString("startstation"),
						rs.getString("endstation"),
						rs.getDate("startdatum"),
						rs.getDate("enddatum"),
						rs.getInt("active"));
				lijst.add(sb);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return lijst;
	}
	
	public static Subscription findSubById(int id) {
		Statement st = null;
		Subscription sb = null;
		try {
			
			if (getConnection() == null || getConnection().isClosed()) {
				// afhandelen zoals je zelf wilt
				throw new IllegalStateException("Connection onverwacht beeindigd");
			}
			st = getConnection().createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM Subscription where id=" + id);
			
	
			while (rs.next()) {
				sb = new Subscription(rs.getInt("id"), 
						rs.getInt("type"),
						rs.getDouble("price"), 
						rs.getInt("customer"),
						rs.getString("startstation"),
						rs.getString("endstation"),
						rs.getDate("startdatum"),
						rs.getDate("enddatum"),
						rs.getInt("active"));
			}
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sb;

	}
	
	public static void updateSub(Subscription sub) {
		PreparedStatement ps = null;

		String sql = "UPDATE Subscription SET type=?, price=?, customer=?, startstation=?, endstationi=?, startdatum=?, enddatum = ? WHERE id = ?";

		try {

			if (getConnection().isClosed()) {
				throw new IllegalStateException("error unexpected");
			}
			ps = getConnection().prepareStatement(sql);

			ps.setInt(1, sub.getTicketType());
			ps.setDouble(2, sub.getPrice());
			ps.setInt(3, sub.getCustomerId());
			ps.setString(4, sub.getStartStation());
			ps.setString(5, sub.getEndStation());
			
			
			ps.setDate(6, sub.getStartDate());
			ps.setDate(7, sub.getEndDate());
			ps.setInt(8,sub.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			;
			throw new RuntimeException(e.getMessage());
		} finally {
			try {
				if (ps != null)
					ps.close();

			} catch (SQLException e) {
				System.out.println(e.getMessage());
				
				throw new RuntimeException(e.getMessage());
			}
		}
	}
	
	public static void setInactive(Subscription sub) {
		PreparedStatement ps = null;

		String sql = "UPDATE Subscription SET active = ? WHERE id = ?";

		try {

			if (getConnection().isClosed()) {
				throw new IllegalStateException("error unexpected");
			}
			ps = getConnection().prepareStatement(sql);

	
			ps.setInt(1, 0);
			ps.setInt(2,sub.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			;
			throw new RuntimeException(e.getMessage());
		} finally {
			try {
				if (ps != null)
					ps.close();

			} catch (SQLException e) {
				System.out.println(e.getMessage());
				
				throw new RuntimeException(e.getMessage());
			}
		}
	}
	
	public static void setActive(Subscription sub) {
		PreparedStatement ps = null;

		String sql = "UPDATE Subscription SET active = ? WHERE id = ?";

		try {

			if (getConnection().isClosed()) {
				throw new IllegalStateException("error unexpected");
			}
			ps = getConnection().prepareStatement(sql);

	
			ps.setInt(1, 1);
			ps.setInt(2,sub.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			;
			throw new RuntimeException(e.getMessage());
		} finally {
			try {
				if (ps != null)
					ps.close();

			} catch (SQLException e) {
				System.out.println(e.getMessage());
				
				throw new RuntimeException(e.getMessage());
			}
		}
	}
	
	
	public static ArrayList<Subscription> getSubsByCustomerID(int id) {
		ArrayList<Subscription> lijst = new ArrayList<Subscription>();
		PreparedStatement st;
		String sql = "SELECT * FROM Subscription WHERE customer = " + id;
		try {
			
			if (getConnection() == null || getConnection().isClosed()) {
				// afhandelen zoals je zelf wilt
				throw new IllegalStateException("Connection onverwacht beeindigd");
			}
			st = getConnection().prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			
			while (rs.next()) {
				Subscription sb = new Subscription(rs.getInt("id"), 
						rs.getInt("type"),
						rs.getDouble("price"), 
						rs.getInt("customer"),
						rs.getString("startstation"),
						rs.getString("endstation"),
						rs.getDate("startdatum"),
						rs.getDate("enddatum"),
						rs.getInt("active"));
				lijst.add(sb);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return lijst;
	}
	
	public static int findNextId() {
		int id = 0;
		Statement st = null;
		
		try {

	        if (getConnection().isClosed()) {
	            throw new IllegalStateException("error unexpected");
	        }
	        
	        st = (Statement) getConnection().createStatement();
	        ResultSet res = st.executeQuery("SELECT MAX(id) FROM Subscription");
	        
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
