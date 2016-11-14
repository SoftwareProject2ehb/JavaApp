package data_control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Customer;
import model.User;
import model.User.Role;

public class UserDAO extends BaseDAO{
	
<<<<<<< HEAD
	public void createUser(User user) {
=======
	
	public void addUser(User user) {
>>>>>>> refs/heads/master
		PreparedStatement ps = null;

		String sql = "INSERT INTO User VALUES(?,?,?,?,?,?,?,?,?)";

		try {

			if (getCon().isClosed()) {
				throw new IllegalStateException("error unexpected");
			}
			ps = getCon().prepareStatement(sql);

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
	
	
	public void updateUser(User user) {
		
		PreparedStatement ps = null;	
		String update = "UPDATE User SET first_name=?, last_name=?, email=?, phone=?, login=?, password=?, role=?, active=? WHERE ID = ?";
		
		try {
		if (getCon().isClosed()) {
			throw new IllegalStateException("error unexpected");
		}
			ps = getCon().prepareStatement(update);
		
	
			
			ps.setString(1, user.getFirstName());
			ps.setString(2, user.getLastName());
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getPhone());
			//ps.setString(6, user.getAddress());
			ps.setString(5, user.getLogin());
			ps.setString(6, user.getPassword());
			ps.setString(7, user.getRolen());
			ps.setBoolean(8, user.isActive());
			ps.setInt(9, user.getUserID());
		
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			
			throw new RuntimeException(e.getMessage());
		}      
	}
	
	public User removeUser(int userID) {
		Statement st = null;
		User user = null;
		try {
			if (getCon() == null || getCon().isClosed()) {
				// afhandelen zoals je zelf wilt
				throw new IllegalStateException("Connection onverwacht beeindigd");
			}
			st = getCon().createStatement();
			String SQL = "DELETE FROM User WHERE ID = " + userID;
			st.executeUpdate(SQL);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
	
	public User findUserById(int id) {
		User user = null;
		Statement st = null;
		try {
	        if (getCon().isClosed()) {
	            throw new IllegalStateException("error unexpected");
	        }
	        st = (Statement) getCon().createStatement();
	        ResultSet rs = st.executeQuery("SELECT * FROM User WHERE ID = " + id);
	        if (rs.next()) {
	        	user = new User(
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
		return user;
	}
	
	public ArrayList<User> getAllUsers() {
		ArrayList<User> lijst = new ArrayList<User>();
		Statement st = null;
		try {
			if (getCon() == null || getCon().isClosed()) {
				// afhandelen zoals je zelf wilt
				throw new IllegalStateException("Connection onverwacht beeindigd");
			}
			st = getCon().createStatement();
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

	enum FindUser {ID,first_name,last_name,email,phone,login ,password,role,active};

	public ArrayList<User> findUserByAttribute(FindUser attribuut,String zoekop) { //Find user by attribute and string
		ArrayList<User> lijst = new ArrayList<User>();
		Statement st = null;
		try {
			if (getCon().isClosed()) {
				throw new IllegalStateException("error unexpected");
			}
			st = (Statement) getCon().createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM User WHERE " + attribuut + " IN ('" + zoekop + "') ");

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
	
	public ArrayList<User> findUserByAttribute(FindUser attribuut,int zoekop) { //Find user by attribute and integer
		ArrayList<User> lijst = new ArrayList<User>();
		Statement st = null;
		try {
			if (getCon().isClosed()) {
				throw new IllegalStateException("error unexpected");
			}
			st = (Statement) getCon().createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM User WHERE " + attribuut + " = " + zoekop);

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
	
<<<<<<< HEAD

	public static void main(String[] args) {
		UserDAO ud = new UserDAO();
		//User u = new User("Mohamed","Blabla","mohamed.blabla@student.ehb.be","03812391","mohb", "test",Role.valueOf("USER")); 
		//ud.createUser(u);
		  
		ArrayList<User> list = ud.findUserByAttribute(FindUser.valueOf("role"),"USER");
		for(User bn: list){
			System.out.println(bn.getFirstName() + " , " + bn.getLastName() + " , " + bn.getEmail() + " , " + bn.getRolen());
		}
		
	  }
=======
	
>>>>>>> refs/heads/master
	  

}
