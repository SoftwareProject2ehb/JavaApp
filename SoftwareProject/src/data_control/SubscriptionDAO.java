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

		String sql = "INSERT INTO Subscription VALUES (?,?,?,?,?,?,?,?)";

		try {

			if (getConnection().isClosed()) {
				throw new IllegalStateException("error unexpected");
			}
			ps = getConnection().prepareStatement(sql);

			ps.setInt(1, sub.getId());
			ps.setString(2, sub.getTicketType());
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
	
	public ArrayList<Subscription> getAllSubs() {
		ArrayList<Subscription> lijst = new ArrayList<Subscription>();
		Statement st = null;
		try {
			if (getConnection() == null || getConnection().isClosed()) {
				// afhandelen zoals je zelf wilt
				throw new IllegalStateException("Connection onverwacht beeindigd");
			}
			st = getConnection().createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM Subscription");

			while (rs.next()) {
				Subscription sb = new Subscription(rs.getInt("id"), 
						rs.getString("type"),
						rs.getDouble("price"), 
						rs.getInt("customer"),
						rs.getString("startstation"),
						rs.getString("endstationi"),
						rs.getDate("startdatum"),
						rs.getDate("enddatum"));
				lijst.add(sb);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return lijst;
	}
	


}