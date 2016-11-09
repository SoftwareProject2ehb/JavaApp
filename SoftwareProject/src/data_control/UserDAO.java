package data_control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.User;
import model.User.Role;

public class UserDAO extends BaseDAO{
	
	public static void addUser(User user) {
		PreparedStatement ps = null;

		String sql = "INSERT INTO User VALUES(?,?,?,?,?,?,?,?,?)";

		try {

			if (getConnection().isClosed()) {
				throw new IllegalStateException("error unexpected");
			}
			ps = getConnection().prepareStatement(sql);

			ps.setInt(1, user.getUserID());
			ps.setString(2, user.getFirstName());
			ps.setString(3, user.getLastName());
			ps.setString(4, user.getEmail());
			ps.setString(5, user.getPhone());
			//ps.setInt(6, user.getAddress());
			ps.setString(6, user.getLogin());
			ps.setString(7, user.getPassword());
			ps.setString(8, user.getRolen());
			ps.setBoolean(9, user.isActive());

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
	
	
	public static void updateUser(User user) {
		
		PreparedStatement ps = null;	
		String update = "UPDATE User SET first_name=?, last_name=?, email=?, phone=?, login=?, password=? role=? active=? WHERE ID = ?";
		
		try {
		if (getConnection().isClosed()) {
			throw new IllegalStateException("error unexpected");
		}
			ps = getConnection().prepareStatement(update);
		
	
			ps.setInt(1, user.getUserID());
			ps.setString(2, user.getFirstName());
			ps.setString(3, user.getLastName());
			ps.setString(4, user.getEmail());
			ps.setString(5, user.getPhone());
			//ps.setString(6, user.getAddress());
			ps.setString(6, user.getLogin());
			ps.setString(7, user.getPassword());
			ps.setString(8, user.getRolen());
			ps.setBoolean(9, user.isActive());
		
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			
			throw new RuntimeException(e.getMessage());
		}      
	}
	
	public static User delUser(int userID) {
		Statement st = null;
		User user = null;
		try {
			if (getConnection() == null || getConnection().isClosed()) {
				// afhandelen zoals je zelf wilt
				throw new IllegalStateException("Connection onverwacht beeindigd");
			}
			st = getConnection().createStatement();
			String SQL = "DELETE FROM User WHERE ID = " + userID;
			st.executeUpdate(SQL);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
	
	public static ArrayList<User> searchUserByLastName(String lastName ) {
		ArrayList<User> lijst = new ArrayList<User>();
		Statement st = null;
		try {
			if (getConnection() == null || getConnection().isClosed()) {
				// afhandelen zoals je zelf wilt
				throw new IllegalStateException("Connection onverwacht beeindigd");
			}
			st = getConnection().createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM User WHERE last_name IN ('" + lastName + "') ");

			while (rs.next()) {
				User u = new User(
						rs.getInt("ID"), 
						rs.getString("first_name"),
						rs.getString("last_name"), 
						rs.getString("email"),
						rs.getString("phone"),
						//rs.getString("address"), 
						rs.getString("login"),
						rs.getString("password"), 
						Role.valueOf(rs.getString("role")), 
						rs.getBoolean("active"));
				lijst.add(u);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return lijst;
	}
	
	public static ArrayList<User> getAllUsers() {
		ArrayList<User> lijst = new ArrayList<User>();
		Statement st = null;
		try {
			if (getConnection() == null || getConnection().isClosed()) {
				// afhandelen zoals je zelf wilt
				throw new IllegalStateException("Connection onverwacht beeindigd");
			}
			st = getConnection().createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM User");

			while (rs.next()) {
				User u = new User(rs.getInt("ID"), 
						rs.getString("first_name"),
						rs.getString("last_name"), 
						rs.getString("email"),
						rs.getString("phone"),
						//rs.getString("address"), 
						rs.getString("login"),
						rs.getString("password"), 
						Role.valueOf(rs.getString("role")), 
						rs.getBoolean("active"));
				lijst.add(u);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return lijst;
	}
}
