package data_control;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import controller.SystemController;
import model.LogFile;
import model.User;
import model.User.Role;

public class UserDAO extends BaseDAO{
	

	public static int createUser(User user) {

		PreparedStatement ps = null;
		Statement st = null;
		ResultSet res = null;
		int id = -1;

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
			
	        st = getConnection().createStatement();
	        res = st.executeQuery("SELECT ID FROM Price ORDER BY ID DESC LIMIT 1");
	        if (res.next()) {
	        	id = res.getInt(1);
	        }
	        ps.close();
	        res.close();
	        // Maken van de logfile met text
			String s = "Een user met id : "+ id+ " werdt toegevoed door user " + SystemController.system.logged_user.getFirstName()
			+" "+SystemController.system.logged_user.getLastName()+ " met ID : " +SystemController.system.logged_user.getUserID();
			LogFile log = new LogFile(s, SystemController.system.logged_user.getUserID());
			LogFileDAO.createLogFile(log);
		
			// Eind maken van logfile
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
	
	
	public static void updateUser(User user) {
		
		PreparedStatement ps = null;	
		String update = "UPDATE User SET first_name=?, last_name=?, email=?, phone=?, login=?, password=?, role=?, active=? WHERE ID = ?";
		
		try {
		if (getConnection().isClosed()) {
			throw new IllegalStateException("error unexpected");
		}
			ps = getConnection().prepareStatement(update);
		
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
			// Maken van de logfile met text
			String s = "Een user met id : "+  user.getUserID() + " werdt gewijzigd door user " + SystemController.system.logged_user.getFirstName()
			+" "+SystemController.system.logged_user.getLastName()+ " met ID : " +SystemController.system.logged_user.getUserID();
			LogFile log = new LogFile(s, SystemController.system.logged_user.getUserID());
			LogFileDAO.createLogFile(log);
		// Eind maken van logfile
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
	
	public static User removeUser(int userID) {

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
			st.close();
			// Maken van de logfile met text
			String s = "Een user met id : "+ userID + " werdt verwijderd door user " + SystemController.system.logged_user.getFirstName()
			+" "+SystemController.system.logged_user.getLastName()+ " met ID : " +SystemController.system.logged_user.getUserID();
			LogFile log = new LogFile(s, SystemController.system.logged_user.getUserID());
			LogFileDAO.createLogFile(log);
		// Eind maken van logfile
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (st != null)
					st.close();
				if (!getConnection().isClosed())
					getConnection().close();

			} catch (SQLException e) {
				System.out.println(e.getMessage());
				
				throw new RuntimeException(e.getMessage());
			}
		}
		return user;
	}
	

	public static User findUserById(int id) {
		User user = null;
		Statement st = null;
		ResultSet res = null;
		try {
	        if (getConnection().isClosed()) {
	            throw new IllegalStateException("error unexpected");
	        }
	        st = (Statement) getConnection().createStatement();
	        res = st.executeQuery("SELECT * FROM User WHERE ID = " + id);
	        if (res.next()) {
	        	user = new User(
						res.getInt("ID"), 
						res.getString("first_name"),
						res.getString("last_name"), 
						res.getString("email"),
						res.getString("phone"),
						//rs.getString("address"), 
						res.getString("login"),
						res.getString("password"), 
						Role.valueOf(res.getString("role")), 
						res.getBoolean("active"));
			}
	        
	        res.close();
	        st.close();
			// Maken van de logfile met text
			String s = "Een user met id : "+  id + " werdt gezocht door user " + SystemController.system.logged_user.getFirstName()
			+" "+SystemController.system.logged_user.getLastName()+ " met ID : " +SystemController.system.logged_user.getUserID();
			LogFile log = new LogFile(s, SystemController.system.logged_user.getUserID());
			LogFileDAO.createLogFile(log);
		// Eind maken van logfile
	    } catch (SQLException e) {
	        System.out.println(e.getMessage());
	        throw new RuntimeException(e.getMessage());
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
		return user;
	}
	
	public static ArrayList<String> findAllLogins() {
		ArrayList<String> result = new ArrayList<String>();
		ResultSet res = null;
		Statement st = null;
		try {
	        if (getConnection().isClosed()) {
	            throw new IllegalStateException("error unexpected");
	        }
	        st = (Statement) getConnection().createStatement();
	        res = st.executeQuery("SELECT login FROM User");
	        while (res.next()) {
	        	result.add(res.getString("login"));
			}
	        
	        res.close();
	        st.close();
			// Maken van de logfile met text
			String s = "Alle users logins werdt gezocht door user " + SystemController.system.logged_user.getFirstName()
			+" "+SystemController.system.logged_user.getLastName()+ " met ID : " +SystemController.system.logged_user.getUserID();
			LogFile log = new LogFile(s, SystemController.system.logged_user.getUserID());
			LogFileDAO.createLogFile(log);
		// Eind maken van logfile
	    } catch (SQLException e) {
	        System.out.println(e.getMessage());
	        throw new RuntimeException(e.getMessage());
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
		return result;
	}
	
	public static User findUserByLogin(String login){
		User user = null;
		PreparedStatement ps = null;
		String update ="SELECT * FROM User WHERE login LIKE '%' ? '%'";
		ResultSet res = null;
		try {
	        if (getConnection().isClosed()) {
	            throw new IllegalStateException("error unexpected");
	        }
	        ps = getConnection().prepareStatement(update);
	        ps.setString(1, login);
	        res = ps.executeQuery();
	        if (res.next()) {
	        	user = new User(
						res.getInt("ID"), 
						res.getString("first_name"),
						res.getString("last_name"), 
						res.getString("email"),
						res.getString("phone"),
						//rs.getString("address"), 
						res.getString("login"),
						res.getString("password"), 
						Role.valueOf(res.getString("role")), 
						res.getBoolean("active"));
			}
	        
	        res.close();
	        ps.close();
	     // Maken van de logfile met text
	     			String s = "Een gebruiker met id " + user.getUserID() + " probeert in te loggen";
	     			LogFile log = new LogFile(s, user.getUserID());
	     			LogFileDAO.createLogFile(log);
	     		// Eind maken van logfile
	    } catch (SQLException e) {
	        System.out.println(e.getMessage());
	        throw new RuntimeException(e.getMessage());
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
		return user;
	}
	
	
	public String findUserByIdForPassword(int id) {
		String pass = null;
		Statement st = null;
		ResultSet res = null;
		try {
	        if (getConnection().isClosed()) {
	            throw new IllegalStateException("error unexpected");
	        }
	        st = (Statement) getConnection().createStatement();
	        res = st.executeQuery("SELECT * FROM User WHERE ID = " + id);
	        if (res.next()) {
	        	pass = res.getString("password");
	        }
	    } catch (SQLException e) {
	        System.out.println(e.getMessage());
	        throw new RuntimeException(e.getMessage());
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
		return pass;
	}
	
	public static ArrayList<User> getAllUsers() {
		ArrayList<User> lijst = new ArrayList<User>();
		ResultSet res = null;
		Statement st = null;
		try {
			if (getConnection() == null || getConnection().isClosed()) {
				// afhandelen zoals je zelf wilt
				throw new IllegalStateException("Connection onverwacht beeindigd");
			}
			st = getConnection().createStatement();
			res = st.executeQuery("SELECT * FROM User");

			while (res.next()) {
				User u = new User(res.getInt("ID"), 
						res.getString("first_name"),
						res.getString("last_name"), 
						res.getString("email"),
						res.getString("phone"),
						//res.getString("address"), 
						res.getString("login"),
						res.getString("password"), 
						Role.valueOf(res.getString("role")), 
						res.getBoolean("active"));
				lijst.add(u);
			}
			   res.close();
		        st.close();
		  
			
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

		return lijst;
	}

	enum FindUser {ID,first_name,last_name,email,phone,login ,password,role,active};

	public static ArrayList<User> findUserByAttribute(FindUser attribuut,String zoekop) { //Find user by attribute and string
		ArrayList<User> lijst = new ArrayList<User>();
		Statement st = null;
		ResultSet res = null;
		try {
			if (getConnection().isClosed()) {
				throw new IllegalStateException("error unexpected");
			}
			st = (Statement) getConnection().createStatement();
			res = st.executeQuery("SELECT * FROM User WHERE " + attribuut + " IN ('" + zoekop + "') ");

			while (res.next()) {
				User u = new User(res.getInt("ID"), 
						res.getString("first_name"),
						res.getString("last_name"), 
						res.getString("email"),
						res.getString("phone"),
						//res.getString("address"), 
						res.getString("login"),
						res.getString("password"), 
						Role.valueOf(res.getString("role")), 
						res.getBoolean("active"));
				lijst.add(u);
			}
			st.close();
			res.close();
			// Maken van de logfile met text
						String s = "Alle users logins werdt gezocht door user " + SystemController.system.logged_user.getFirstName()
						+" "+SystemController.system.logged_user.getLastName()+ " met ID : " +SystemController.system.logged_user.getUserID();
						LogFile log = new LogFile(s, SystemController.system.logged_user.getUserID());
						LogFileDAO.createLogFile(log);
					// Eind maken van logfile
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
		return lijst;
	}
	
	public static ArrayList<User> findUserByAttribute(FindUser attribuut,int zoekop) { //Find user by attribute and integer
		ArrayList<User> lijst = new ArrayList<User>();
		Statement st = null;
		ResultSet res = null;
		try {
			if (getConnection().isClosed()) {
				throw new IllegalStateException("error unexpected");
			}
			st = (Statement) getConnection().createStatement();
			res = st.executeQuery("SELECT * FROM User WHERE " + attribuut + " = " + zoekop);

			while (res.next()) {
				User u = new User(res.getInt("ID"), 
						res.getString("first_name"),
						res.getString("last_name"), 
						res.getString("email"),
						res.getString("phone"),
						//res.getString("address"), 
						res.getString("login"),
						res.getString("password"), 
						Role.valueOf(res.getString("role")), 
						res.getBoolean("active"));
				lijst.add(u);
			}
			st.close();
			res.close();
			// Maken van de logfile met text
						String s = "Alle users logins werdt gezocht door user " + SystemController.system.logged_user.getFirstName()
						+" "+SystemController.system.logged_user.getLastName()+ " met ID : " +SystemController.system.logged_user.getUserID();
						LogFile log = new LogFile(s, SystemController.system.logged_user.getUserID());
						LogFileDAO.createLogFile(log);
					// Eind maken van logfile
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
		return lijst;
	}
}
