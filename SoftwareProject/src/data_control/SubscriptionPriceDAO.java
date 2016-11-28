package data_control;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.SubscriptionPrice;
import model.SubscriptionType;

public class SubscriptionPriceDAO extends BaseDAO{
	public static SubscriptionPrice findSubPriceById(int id) {
		Statement st = null;
		SubscriptionPrice sbp = null;
		ResultSet res = null;
		try {
			
			if (getConnection() == null || getConnection().isClosed()) {
				// afhandelen zoals je zelf wilt
				throw new IllegalStateException("Connection onverwacht beeindigd");
			}
			st = getConnection().createStatement();
			res = st.executeQuery("SELECT * FROM SubscriptionPrice where id=" + id);
			
			while (res.next()) {
				sbp = new SubscriptionPrice(res.getInt("id"), 
						res.getDouble("lengthInMonths"),
						res.getDouble("price"));
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
		
		return sbp;

	}
	
	public static int createSubscriptionPrice(SubscriptionPrice subPrice) {
		PreparedStatement ps = null;
		Statement st = null;
		ResultSet res = null;
		int id = -1;
		
		String sql = "INSERT INTO SubscriptionPrice VALUES (?,?,?)";

		try {

			if (getConnection().isClosed()) {
				throw new IllegalStateException("error unexpected");
			}
			ps = getConnection().prepareStatement(sql);

			ps.setInt(1, subPrice.getId());
			ps.setDouble(2, subPrice.getLengthInMonths());
			ps.setDouble(3, subPrice.getPrice());

			ps.executeUpdate();
			
			st = getConnection().createStatement();
	        res = st.executeQuery("SELECT id FROM SubscriptionPrice ORDER BY id DESC LIMIT 1");
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
	
	
	
	public static ArrayList<SubscriptionPrice> getAllSubPrices() {
		ArrayList<SubscriptionPrice> lijst = new ArrayList<SubscriptionPrice>();
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
				SubscriptionPrice sbp = new SubscriptionPrice(res.getInt("id"), 
						res.getDouble("lengthInMonths"),
						res.getDouble("price") 
						);
				lijst.add(sbp);
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
	
	public static void updateSubType(SubscriptionPrice subPrice) {
		PreparedStatement ps = null;
		String sql = "UPDATE SubscriptionPrice SET lengthInMonths=?, price=? WHERE id = " + subPrice.getId();

		try {

			if (getConnection().isClosed()) {
				throw new IllegalStateException("error unexpected");
			}
			ps = getConnection().prepareStatement(sql);
			ps.setDouble(1, subPrice.getLengthInMonths());
			ps.setDouble(2, subPrice.getPrice());
			
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
