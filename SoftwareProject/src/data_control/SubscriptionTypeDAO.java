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
		try {
			
			if (getConnection() == null || getConnection().isClosed()) {
				// afhandelen zoals je zelf wilt
				throw new IllegalStateException("Connection onverwacht beeindigd");
			}
			st = getConnection().createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM SubscriptionType where id=" + id);
			
	
			while (rs.next()) {
				sbt = new SubscriptionType(rs.getInt("id"), 
						rs.getString("name"),
						rs.getDouble("factor"));
			}
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sbt;

	}
	
	public static void createSubscriptionType(SubscriptionType subType) {
		PreparedStatement ps = null;

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
	
	
	
	public static ArrayList<SubscriptionType> getAllSubTypes() {
		ArrayList<SubscriptionType> lijst = new ArrayList<SubscriptionType>();
		Statement st = null;
		try {
			if (getConnection() == null || getConnection().isClosed()) {
				// afhandelen zoals je zelf wilt
				throw new IllegalStateException("Connection onverwacht beeindigd");
			}
			st = getConnection().createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM SubscriptionType");

			while (rs.next()) {
				SubscriptionType sb = new SubscriptionType(rs.getInt("id"), 
						rs.getString("name"),
						rs.getDouble("price") 
						);
				lijst.add(sb);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
	
	
	
	
	
	
	
}
