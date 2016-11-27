package data_control;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Subscription;
import model.SubscriptionType;

public class SubscriptionTypeDAO extends BaseDAO{
	public static SubscriptionType findSubTypeById(int id) {
		Statement st = null;
		SubscriptionType sbt = null;
		ResultSet res = null;
		try {
			
			if (getConnection() == null || getConnection().isClosed()) {
				// afhandelen zoals je zelf wilt
				throw new IllegalStateException("Connection onverwacht beeindigd");
			}
			st = getConnection().createStatement();
			res = st.executeQuery("SELECT * FROM SubscriptionType where id=" + id);
			
	
			while (res.next()) {
				sbt = new SubscriptionType(res.getInt("id"), 
						res.getString("name"),
						res.getDouble("factor"));
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
		return sbt;

	}
	
	public static int createSubscriptionType(SubscriptionType subType) {
		PreparedStatement ps = null;
		Statement st = null;
		ResultSet res = null;
		int id = -1;

		String sql = "INSERT INTO SubscriptionType VALUES (?,?,?)";

		try {

			if (getConnection().isClosed()) {
				throw new IllegalStateException("error unexpected");
			}
			ps = getConnection().prepareStatement(sql);

			ps.setInt(1, subType.getId());
			ps.setString(2, subType.getName());
			ps.setDouble(3, subType.getFactor());

			ps.executeUpdate();
			
	        st = getConnection().createStatement();
	        res = st.executeQuery("SELECT id FROM SubscriptionType ORDER BY id DESC LIMIT 1");
	        if (res.next()) {
	        	id = res.getInt(1);
	        }
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			;
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
	
	
	
	public static ArrayList<SubscriptionType> getAllSubTypes() {
		ArrayList<SubscriptionType> lijst = new ArrayList<SubscriptionType>();
		Statement st = null;
		ResultSet res = null;
		try {
			if (getConnection() == null || getConnection().isClosed()) {
				// afhandelen zoals je zelf wilt
				throw new IllegalStateException("Connection onverwacht beeindigd");
			}
			st = getConnection().createStatement();
			res = st.executeQuery("SELECT * FROM SubscriptionType");

			while (res.next()) {
				SubscriptionType sb = new SubscriptionType(res.getInt("id"), 
						res.getString("name"),
						res.getDouble("price") 
						);
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
	
	public static void updateSubType(SubscriptionType subType) {
		PreparedStatement ps = null;
		String sql = "UPDATE SubscriptionType SET name=?, factor=? WHERE id = " + subType.getId();

		try {

			if (getConnection().isClosed()) {
				throw new IllegalStateException("error unexpected");
			}
			ps = getConnection().prepareStatement(sql);
			ps.setString(1, subType.getName());
			ps.setDouble(2, subType.getFactor());
			
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
}
