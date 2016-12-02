package data_control;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Price.betalingsType;
import model.Subscription;
import model.SubscriptionPrice;
import model.Ticket;

public class SubscriptionPriceDAO extends BaseDAO{
	public static SubscriptionPrice findSubPriceById(int id) {
		Statement st = null;
		SubscriptionPrice sbp = null;
		ResultSet res = null;
		try {
			
			if (getConnection() == null || getConnection().isClosed()) {
				throw new IllegalStateException("Connection onverwacht beeindigd");
			}
			st = getConnection().createStatement();
			res = st.executeQuery("SELECT * FROM SubscriptionPrice where id=" + id);
			
			while (res.next()) {
				sbp = new SubscriptionPrice(res.getInt("id"),
						res.getString("typeSubscription"),
						betalingsType.stringToBetalingsType(res.getString("typeBetaling")),
						res.getDouble("costPerUnit"),
						res.getDouble("lengthInMonths"));
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
	
	public static SubscriptionPrice findSubPriceByTypeAndLength(String type, double length) {
		PreparedStatement ps = null;
		SubscriptionPrice sbp = null;
		ResultSet res = null;
		try {
			
			if (getConnection() == null || getConnection().isClosed()) {
				throw new IllegalStateException("Connection onverwacht beeindigd");
			}
			
			//st = getConnection().createStatement();
			//res = st.executeQuery("SELECT * FROM SubscriptionPrice where id=" + id);
			
			ps = getConnection().prepareStatement("SELECT * FROM SubscriptionPrice where typeSubscription=? and lengthInMonths=?");
			ps.setString(1, type);
			ps.setDouble(2, length);
			
			res = ps.executeQuery();
			
			while (res.next()) {
				sbp = new SubscriptionPrice(res.getInt("id"),
						res.getString("typeSubscription"),
						betalingsType.stringToBetalingsType(res.getString("typeBetaling")),
						res.getDouble("costPerUnit"),
						res.getDouble("lengthInMonths"));
			}
	
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
		
		String sql = "INSERT INTO SubscriptionPrice VALUES (?,?,?,?,?)";

		try {

			if (getConnection().isClosed()) {
				throw new IllegalStateException("error unexpected");
			}
			ps = getConnection().prepareStatement(sql);

			ps.setInt(1, subPrice.getId());
			ps.setString(2, subPrice.getTypeSubscription());
			ps.setString(3, subPrice.getTypeBetaling().toCapsString());
			ps.setDouble(4, subPrice.getCostPerUnit());
			ps.setDouble(5, subPrice.getLengthInMonths());

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
				throw new IllegalStateException("Connection onverwacht beeindigd");
			}
			st = getConnection().createStatement();
			res = st.executeQuery("SELECT * FROM SubscriptionPrice");

			while (res.next()) {
				SubscriptionPrice sbp = new SubscriptionPrice(res.getInt("id"), 
						res.getString("typeSubscription"),
						betalingsType.stringToBetalingsType(res.getString("typeBetaling")),
						res.getDouble("lengthInMonths"),
						res.getDouble("costPerUnit") 
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
		String sql = "UPDATE SubscriptionPrice SET typeSubscription=?, typeBetaling=?, lengthInMonths=?, price=? WHERE id = " + subPrice.getId();

		try {

			if (getConnection().isClosed()) {
				throw new IllegalStateException("error unexpected");
			}
			ps = getConnection().prepareStatement(sql);
			ps.setString(1, subPrice.getTypeSubscription());
			ps.setString(2, subPrice.getTypeBetaling().toCapsString());
			ps.setDouble(3, subPrice.getLengthInMonths());
			ps.setDouble(4, subPrice.getCostPerUnit());
			
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
	
	public static ArrayList<String> getAllSubTypes() {
		ArrayList<String> list = new ArrayList<String>();
		ResultSet res = null;
		Statement st = null;
		try {
			if (getConnection().isClosed()) {
				throw new IllegalStateException("error unexpected");
			}
			st = (Statement) getConnection().createStatement();
			res = st.executeQuery("SELECT DISTINCT typeSubscription FROM SubscriptionPrice");

			while (res.next()) {
				list.add(res.getString(1));
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
	            throw new RuntimeException("error.unexpected");
	        }
	    }

		return list;
	}
	
	public static ArrayList<Double> getLengthsForType(String type) {
		ArrayList<Double> list = new ArrayList<Double>();
		ResultSet res = null;
		PreparedStatement ps = null;
		try {
			if (getConnection().isClosed()) {
				throw new IllegalStateException("error unexpected");
			}
			
			//st = (Statement) getConnection().createStatement();
			//res = st.executeQuery("SELECT lengthInMonths FROM SubscriptionPrice WHERE type=?");

			ps = getConnection().prepareStatement("SELECT lengthInMonths FROM SubscriptionPrice WHERE typeSubscription=?");
			ps.setString(1, type);
			
			res = ps.executeQuery();
			
			while (res.next()) {
				list.add(res.getDouble(1));
			}
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

		return list;
	}
	
	public static void removeSubscriptionPrice(int id) {
		PreparedStatement ps = null;	
		String update = "DELETE FROM SubscriptionPrice WHERE id = ?";
		
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
}
