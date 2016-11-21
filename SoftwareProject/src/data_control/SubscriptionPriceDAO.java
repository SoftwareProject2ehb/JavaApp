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
		try {
			
			if (getConnection() == null || getConnection().isClosed()) {
				// afhandelen zoals je zelf wilt
				throw new IllegalStateException("Connection onverwacht beeindigd");
			}
			st = getConnection().createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM SubscriptionPrice where id=" + id);
			
	
			while (rs.next()) {
				sbp = new SubscriptionPrice(rs.getInt("id"), 
						rs.getDouble("lengthInMonths"),
						rs.getDouble("price"));
			}
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sbp;

	}
	
	public static void createSubscriptionPrice(SubscriptionPrice subPrice) {
		PreparedStatement ps = null;

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
	
	
	
	public static ArrayList<SubscriptionPrice> getAllSubPrices() {
		ArrayList<SubscriptionPrice> lijst = new ArrayList<SubscriptionPrice>();
		Statement st = null;
		try {
			if (getConnection() == null || getConnection().isClosed()) {
				// afhandelen zoals je zelf wilt
				throw new IllegalStateException("Connection onverwacht beeindigd");
			}
			st = getConnection().createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM SubscriptionType");

			while (rs.next()) {
				SubscriptionPrice sbp = new SubscriptionPrice(rs.getInt("id"), 
						rs.getDouble("lengthInMonths"),
						rs.getDouble("price") 
						);
				lijst.add(sbp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
	
	public static int findNextId() {
		int id = 0;
		Statement st = null;
		
		try {

	        if (getConnection().isClosed()) {
	            throw new IllegalStateException("error unexpected");
	        }
	        
	        st = (Statement) getConnection().createStatement();
	        ResultSet res = st.executeQuery("SELECT MAX(id) FROM SubscriptionPrice");
	        
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
