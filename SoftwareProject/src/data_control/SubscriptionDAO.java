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
	
	public static int createSubscription(Subscription sub) {
		PreparedStatement ps = null;
		Statement st = null;
		ResultSet res = null;
		int id = -1;

		String sql = "INSERT INTO Subscription VALUES (?,?,?,?,?,?,?,?,1)";

		try {

			if (getConnection().isClosed()) {
				throw new IllegalStateException("error unexpected");
			}
			ps = getConnection().prepareStatement(sql);

			ps.setInt(1, sub.getId());
			ps.setString(2, sub.getSubscriptionType());
			ps.setDouble(3, sub.getPrice());
			ps.setInt(4, sub.getCustomerId());
			ps.setString(5, sub.getStartStation());
			ps.setString(6, sub.getEndStation());
			ps.setDate(7, sub.getStartDate());
			ps.setDate(8, sub.getEndDate());

			ps.executeUpdate();
			
	        st = getConnection().createStatement();
	        res = st.executeQuery("SELECT id FROM Subscription ORDER BY id DESC LIMIT 1");
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
	            if (res != null)
	                res.close();
				if (!getConnection().isClosed())
					getConnection().close();

			} catch (SQLException e) {
				System.out.println(e.getMessage());
				
				throw new RuntimeException(e.getMessage());
			}
		}
		return id;
	}
	
	public static ArrayList<Subscription> getAllSubs() {
		ArrayList<Subscription> lijst = new ArrayList<Subscription>();
		Statement st = null;
		ResultSet res = null;
		try {
			if (getConnection() == null || getConnection().isClosed()) {
				// afhandelen zoals je zelf wilt
				throw new IllegalStateException("Connection onverwacht beeindigd");
			}
			st = getConnection().createStatement();
			res = st.executeQuery("SELECT * FROM Subscription");

			while (res.next()) {
				Subscription sb = new Subscription(res.getInt("id"), 
						res.getString("type"),
						res.getDouble("price"), 
						res.getInt("customer"),
						res.getString("startstation"),
						res.getString("endstation"),
						res.getDate("startdatum"),
						res.getDate("enddatum"),
						res.getInt("active"));
				lijst.add(sb);
			}
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
				
				throw new RuntimeException(e.getMessage());
			}
		}

		return lijst;
	}
	
	public static Subscription findSubById(int id) {
		Statement st = null;
		Subscription sb = null;
		ResultSet res = null;
		try {
			
			if (getConnection() == null || getConnection().isClosed()) {
				// afhandelen zoals je zelf wilt
				throw new IllegalStateException("Connection onverwacht beeindigd");
			}
			st = getConnection().createStatement();
			res = st.executeQuery("SELECT * FROM Subscription where id=" + id);
			
	
			while (res.next()) {
				sb = new Subscription(res.getInt("id"), 
						res.getString("type"),
						res.getDouble("price"), 
						res.getInt("customer"),
						res.getString("startstation"),
						res.getString("endstation"),
						res.getDate("startdatum"),
						res.getDate("enddatum"),
						res.getInt("active"));
			}
	
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
				
				throw new RuntimeException(e.getMessage());
			}
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

			ps.setString(1, sub.getSubscriptionType());
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
				if (!getConnection().isClosed())
					getConnection().close();

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
			throw new RuntimeException(e.getMessage());
		} finally {
			try {
				if (ps != null)
					ps.close();
				if (!getConnection().isClosed())
					getConnection().close();

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
			throw new RuntimeException(e.getMessage());
		} finally {
			try {
				if (ps != null)
					ps.close();
				if (!getConnection().isClosed())
					getConnection().close();

			} catch (SQLException e) {
				System.out.println(e.getMessage());
				
				throw new RuntimeException(e.getMessage());
			}
		}
	}
	
	
	public static ArrayList<Subscription> getSubsByCustomerID(int id) {
		ArrayList<Subscription> lijst = new ArrayList<Subscription>();
		Statement st = null;
		ResultSet res = null;
		try {
			
			if (getConnection() == null || getConnection().isClosed()) {
				// afhandelen zoals je zelf wilt
				throw new IllegalStateException("Connection onverwacht beeindigd");
			}
			st = getConnection().createStatement();
			res = st.executeQuery("SELECT * FROM Subscription WHERE customer = " + id);
			
			while (res.next()) {
				Subscription sb = new Subscription(res.getInt("id"), 
						res.getString("type"),
						res.getDouble("price"), 
						res.getInt("customer"),
						res.getString("startstation"),
						res.getString("endstation"),
						res.getDate("startdatum"),
						res.getDate("enddatum"),
						res.getInt("active"));
				lijst.add(sb);
			}
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
				
				throw new RuntimeException(e.getMessage());
			}
		}

		return lijst;
	}
}
