package data_control;

import model.*;
import controller.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;

public class LostObjectDAO extends BaseDAO{

	public enum SearchLostObject {
		ID, userid, name, place, timeFound, claimed, userClaimed, nameClaimed, LocationClaimed, timeClaimed, description
	};
	
		public static int createLostObject (LostObject object)
	{
		 PreparedStatement ps = null;
		 Statement st = null;
		 ResultSet res = null;
		 int id = -1;

		    String sql = "INSERT INTO LostObject VALUES(null,?,?,?,?,false,null,null,null,null)";

		    try {

		        if (getConnection().isClosed()) {
		            throw new IllegalStateException("error unexpected");
		        }
		        ps = getConnection().prepareStatement(sql);
		        
		        ps.setInt(1, object.getUserID());
		        ps.setString(2, object.getName());
		        ps.setString(3, object.getPlace());
		        // TODO SET DATE
		        java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
		        ps.setTimestamp(4, date);
		        
		        ps.executeUpdate();
		        
		        // Maken van de logfile met text
				String s = "Een lost object werdt toegevoed door user " + SystemController.system.logged_user.getFirstName()
				+" "+SystemController.system.logged_user.getLastName()+ " met ID : " +SystemController.system.logged_user.getUserID();
				LogFile log = new LogFile(s, SystemController.system.logged_user.getUserID());
				LogFileDAO.createLogFile(log);
			
				// Eind maken van logfile
		        
		        st = getConnection().createStatement();
		        res = st.executeQuery("SELECT ID FROM LostObject ORDER BY ID DESC LIMIT 1");
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
		            if (res != null)
		                res.close();
		            if (st != null)
		                st.close();
		            if (!getConnection().isClosed())
						getConnection().close();

		        } catch (SQLException e) {
		            System.out.println(e.getMessage());
		            throw new RuntimeException("error.unexpected");
		        }
		    }
		    return id;
	}


public static void updateLostObject(LostObject object) {
		
		PreparedStatement ps = null;	
		String update = "UPDATE LostObject SET claimed = true, userClaimed = ?, locationClaimed = ? ,nameClaimed=?, timeClaimed =? WHERE ID = ?";
		
		try {
		if (getConnection().isClosed()) {
			throw new IllegalStateException("error unexpected");
		}
			ps = getConnection().prepareStatement(update);
		
			ps.setInt(1, object.getUserIDClaimed());
			ps.setString(2, object.getLocationClaimed());
			ps.setString(3, object.getNameClaimed());
			java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
	        ps.setTimestamp(4, date);
			
			ps.setInt(5, object.getID());
			 // TODO SET DATE
			ps.executeUpdate();
			
			// Maken van de logfile met text
				String s = "Een lost object werdt gewijzigd door user " + SystemController.system.logged_user.getFirstName()
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
	            throw new RuntimeException("error.unexpected");
	        }
	    }      
	}

public static LostObject getLostObjectFromRS(ResultSet res) throws SQLException{
	
	return new LostObject(res.getInt(1), res.getInt(2),res.getString(3), res.getString(4), res.getTimestamp(5), res.getBoolean(6),res.getInt(7),res.getString(8),res.getString(9),res.getTimestamp(10));
}


public static LostObject getLostObjectById(int objectID) {
	Statement st = null;
	LostObject lost = null;
	ResultSet res = null;
	try {
		if (getConnection().isClosed()) {
			throw new IllegalStateException("error unexpected");
		}
		st = (Statement) getConnection().createStatement();
		res = st.executeQuery("SELECT * FROM LostObject WHERE ID = " + objectID);

		while (res.next()) {
			lost = getLostObjectFromRS(res);

		}
		
		// Maken van de logfile met text
			String s = "Een lost object werdt gezocht op id door user " + SystemController.system.logged_user.getFirstName()
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
	
	return lost;
}



public static ArrayList<LostObject> getAllLostObject(int from , int to) {
	ArrayList<LostObject> lijst = new ArrayList<LostObject>();
	Statement st = null;
	ResultSet res  = null;
	try {
		if (getConnection().isClosed()) {
			throw new IllegalStateException("error unexpected");
		}
		st = (Statement) getConnection().createStatement();
		res = st.executeQuery("SELECT * FROM LostObject where timeFound  BETWEEN NOW() - INTERVAL "+from +" MONTH AND NOW() - INTERVAL "+ to +" MONTH");

		while (res.next()) {
			LostObject lost = getLostObjectFromRS(res);
			lijst.add(lost);
		}
		
		// Maken van de logfile met text
			String s = "Alle lost object not claimed werdt gezocht door user " + SystemController.system.logged_user.getFirstName()
			+" "+SystemController.system.logged_user.getLastName()+ " met ID : " +SystemController.system.logged_user.getUserID();
			LogFile log = new LogFile(s, SystemController.system.logged_user.getUserID());
			LogFileDAO.createLogFile(log);
			
		// Eind maken van logfile
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		e.getMessage();
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
public static ArrayList<LostObject> getAllLostObjectNotClaimed() {
	ArrayList<LostObject> lijst = new ArrayList<LostObject>();
	Statement st = null;
	ResultSet res = null;
	try {
		if (getConnection().isClosed()) {
			throw new IllegalStateException("error unexpected");
		}
		st = (Statement) getConnection().createStatement();
		res = st.executeQuery("SELECT * FROM LostObject WHERE claimed = false");

		while (res.next()) {
			LostObject lost = getLostObjectFromRS(res);
			lijst.add(lost);
		}
		// Maken van de logfile met text
			String s = "Alle lost object not claimed werdt gezocht door user " + SystemController.system.logged_user.getFirstName()
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

public static ArrayList<LostObject> getAllLostObjectClaimed() {
	ArrayList<LostObject> lijst = new ArrayList<LostObject>();
	Statement st = null;
	ResultSet res = null;
	try {
		if (getConnection().isClosed()) {
			throw new IllegalStateException("error unexpected");
		}
		st = (Statement) getConnection().createStatement();
		res = st.executeQuery("SELECT * FROM LostObject WHERE claimed = true");

		while (res.next()) {
			LostObject lost = getLostObjectFromRS(res);
			lijst.add(lost);
		}
		// Maken van de logfile met text
			String s = "Alle lost object claimed werdt gezocht door " + SystemController.system.logged_user.getFirstName()
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


//ZOEK op attribuut werkt niet
public static ArrayList<LostObject> getLostObjectOpAttribut(SearchLostObject attribuut,String zoekop) {
	ArrayList<LostObject> lijst = new ArrayList<LostObject>();
	Statement st = null;
	ResultSet res = null;
	try {
		if (getConnection().isClosed()) {
			throw new IllegalStateException("error unexpected");
		}
		st = (Statement) getConnection().createStatement();
		res = st.executeQuery("SELECT * FROM LostObject WHERE " + attribuut +" =  '" + zoekop + "';");

		while (res.next()) {
			LostObject lost = getLostObjectFromRS(res);
			lijst.add(lost);
		}
		
		// Maken van de logfile met text
			String s = "Een lost object werdt gezocht met attribuut : "+ attribuut+" en value : "+ zoekop+"door user " + SystemController.system.logged_user.getFirstName()
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
public static ArrayList<LostObject> getAllLostObjectOnDateFound(String date) {
	ArrayList<LostObject> lijst = new ArrayList<LostObject>();
	Statement st = null;
	ResultSet res = null;
	try {
		if (getConnection().isClosed()) {
			throw new IllegalStateException("error unexpected");
		}
		st = (Statement) getConnection().createStatement();
		res = st.executeQuery("SELECT * FROM LostObject WHERE timeFound LIKE '%" + date + "%'");

		while (res.next()) {
			LostObject lost = getLostObjectFromRS(res);
			lijst.add(lost);
		}
		// Maken van de logfile met text
						String s = "Alle lost object op datum found : "+ datum +" werdt toegevoed door user " + SystemController.system.logged_user.getFirstName()
						+" "+SystemController.system.logged_user.getLastName()+ " met ID : " +SystemController.system.logged_user.getUserID();
						LogFile log = new LogFile(s, SystemController.system.logged_user.getUserID());
						LogFileDAO.createLogFile(log);
		// Eind maken van logfile
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		e.getMessage();
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
public static ArrayList<LostObject> getAllLostObjectOnDateClaimed(String date) {
	ArrayList<LostObject> lijst = new ArrayList<LostObject>();
	Statement st = null;
	ResultSet res = null;
	try {
		if (getConnection().isClosed()) {
			throw new IllegalStateException("error unexpected");
		}
		st = (Statement) getConnection().createStatement();
		res = st.executeQuery("SELECT * FROM LostObject WHERE timeClaimed LIKE '%" + date + "%'");

		while (res.next()) {
			LostObject lost = getLostObjectFromRS(res);
			lijst.add(lost);
		}
		// Maken van de logfile met text
			String s = "Alle lost object op datum claimed : "+ datum +" werdt toegevoed door user " + SystemController.system.logged_user.getFirstName()
			+" "+SystemController.system.logged_user.getLastName()+ " met ID : " +SystemController.system.logged_user.getUserID();
			LogFile log = new LogFile(s, SystemController.system.logged_user.getUserID());
			LogFileDAO.createLogFile(log);
			// Eind maken van logfile
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		e.getMessage();
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

public static ArrayList<LostObject> getLostObjectByMultipleArgs(String name_user, String place_found, Timestamp time_found, Boolean claimed) {
	ArrayList<LostObject> lijst = new ArrayList<LostObject>();
	
	if (name_user == null && place_found == null && time_found == null && claimed == false) {
		return lijst;
	}
	
	Statement st = null;
	try {
		if (getConnection().isClosed()) {
			throw new IllegalStateException("error unexpected");
		}
		String sql_syntax = "SELECT * FROM LostObject WHERE ";
		
		if (name_user != null && !name_user.equals("")) {
			sql_syntax = sql_syntax.concat("userid = '" + UserDAO.findUserByLogin(name_user).getUserID() + "' AND ");
		}
		
		if (place_found != null && !place_found.equals("")) {
			sql_syntax = sql_syntax.concat("place = '" + place_found + "' AND ");
		}
		
		if (time_found != null) {
			sql_syntax = sql_syntax.concat("timeFound = '" + time_found + "' AND ");
		}
		
		sql_syntax = sql_syntax.concat("userClaimed = " + (claimed ? 1 : 0));
		
		ResultSet res = null;
		try {
			st = (Statement) getConnection().createStatement();
			res = st.executeQuery(sql_syntax);
			while (res.next()) {
				LostObject lost = getLostObjectFromRS(res);
				lijst.add(lost);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			e.getMessage();
		} finally {
			if (res != null)
                res.close();
			if (st != null)
                st.close();
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		e.getMessage();
	} finally {
        try {
            if (st != null)
                st.close();
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