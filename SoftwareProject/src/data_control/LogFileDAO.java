package data_control;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.*;

public class LogFileDAO extends BaseDAO{
	/**
	 * @param customer The object of type LogFile that should be created in the database.
	 * @return The ID of the record containing the created LogFile. This ID should be used to set the ID of the LogFile object locally.
	 */
	public static int createLogFile(LogFile logfile)
	{
		PreparedStatement ps = null;
		Statement st = null;
		ResultSet res = null;
		int id = -1;
		String sql = "INSERT INTO LogFile VALUES(null,?,?,?)";
		
		try {

	        if (getConnection().isClosed()) {
	            throw new IllegalStateException("error unexpected");
	        }
	        ps = getConnection().prepareStatement(sql);
	        
	        ps.setString(1, logfile.getDescription());
	        java.sql.Date sqlTime = new java.sql.Date(logfile.getTime().getTime());
	        ps.setDate(2, sqlTime);
	        ps.setInt(3, logfile.getUserID());
	        
	        ps.executeUpdate();
	        
	        st = getConnection().createStatement();
		    res = st.executeQuery("SELECT logfileID FROM LogFile ORDER BY logfileID DESC LIMIT 1");
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
	            throw new RuntimeException("error.unexpected");
	        }
	    }
		return id;
	}
	
	public static void updateLogfile(LogFile logfile) {
		PreparedStatement ps = null;	
		String update = "UPDATE LogFile SET logfileID=?, description=?, time=?, userID=? WHERE logfileID=?";
		
		try {
		if (getConnection().isClosed()) {
			throw new IllegalStateException("error unexpected");
		}
			ps = getConnection().prepareStatement(update);
		
			ps.setInt(1, logfile.getLogFileID());
			ps.setString(2, logfile.getDescription());
			java.sql.Date sqlTime = new java.sql.Date(logfile.getTime().getTime());
	        ps.setDate(3, sqlTime);
			ps.setInt(4, logfile.getUserID());
			ps.setInt(5, logfile.getLogFileID());
			
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static LogFile findLogFileById(int id) {
	Statement st = null;
	LogFile l = null;
	
	try {
		if (getConnection().isClosed()) {
			throw new IllegalStateException("error unexpected");
		}
		st = (Statement) getConnection().createStatement();
		ResultSet res = st.executeQuery("SELECT * FROM LogFile WHERE logfileID = " + id);

		while (res.next()) {
			java.sql.Date sqlDate = res.getDate(3);
			java.util.Date date = new java.util.Date(sqlDate.getTime());
			l = new LogFile(res.getInt(1), res.getString(2), date, res.getInt(4));

		}
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		try {
			if (st != null)
				st.close();
			if (!getConnection().isClosed())
				getConnection().close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	return l;
}

	public static ArrayList<LogFile> getAllLogFiles() {
	ArrayList<LogFile> list = new ArrayList<LogFile>();
	
	Statement st = null;
	try {
		if (getConnection().isClosed()) {
			throw new IllegalStateException("error unexpected");
		}
		st = (Statement) getConnection().createStatement();
		ResultSet res = st.executeQuery("SELECT * FROM LogFile");

		while (res.next()) {
			java.sql.Date sqlDate = res.getDate(3);
			java.util.Date date = new java.util.Date(sqlDate.getTime());
			LogFile l = new LogFile(res.getInt(1), res.getString(2), date, res.getInt(4));
			list.add(l);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		try {
			if (st != null)
				st.close();
			if (!getConnection().isClosed())
				getConnection().close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	return list;
}
	
public static int findNextId() {
		int id = 0;
		Statement st = null;
		
		try {

	        if (getConnection().isClosed()) {
	            throw new IllegalStateException("error unexpected");
	        }
	        
	        st = (Statement) getConnection().createStatement();
	        ResultSet res = st.executeQuery("SELECT MAX(ID) FROM Logfile");
	        
	        if (res.next()) {
	        	id = res.getInt(0);

			}
	        
	    } catch (SQLException e) {
	        System.out.println(e.getMessage());
	        throw new RuntimeException(e.getMessage());
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
		
		return id + 1;
	}
	
	public static LogFile getLatestEntry() {
		Statement st = null;
		LogFile l = null;
		
		try {
			if (getConnection().isClosed()) {
				throw new IllegalStateException("error unexpected");
			}
			st = (Statement) getConnection().createStatement();
			ResultSet res = st.executeQuery("SELECT * FROM LogFile ORDER BY logfileID DESC LIMIT 1");

			while (res.next()) {
				java.sql.Date sqlDate = res.getDate(3);
				java.util.Date date = new java.util.Date(sqlDate.getTime());
				l = new LogFile(res.getInt(1), res.getString(2), date, res.getInt(4));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (st != null)
	            	st.close();
	            if (!getConnection().isClosed())
					getConnection().close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}

		return l;
	}
}
