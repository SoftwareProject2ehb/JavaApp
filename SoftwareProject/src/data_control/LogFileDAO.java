package data_control;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.*;

public class LogFileDAO extends BaseDAO{
	public static void createLogFile(LogFile logfile)
	{
		PreparedStatement ps = null;
		
		String sql = "INSERT INTO LogFile VALUES(null,?,?,?)";
		
		try {

	        if (getConnection().isClosed()) {
	            throw new IllegalStateException("error unexpected");
	        }
	        ps = getConnection().prepareStatement(sql);
	        
	        ps.setString(1, logfile.getDescription());
	        //java.sql.Date sqlTime = new java.sql.Date(logfile.getTime().getTime());
	        ps.setTimestamp(2, logfile.getTime());
	        ps.setInt(3, logfile.getUserID());
	        
	        ps.executeUpdate();
	    } catch (SQLException e) {
	        System.out.println(e.getMessage());
	        throw new RuntimeException(e.getMessage());
	    } finally {
	        try {
	            if (ps != null)
	                ps.close();

	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	            throw new RuntimeException("error.unexpected");
	        }
	    }
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
			ps.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new RuntimeException(e.getMessage());
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
			java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
			l = new LogFile(res.getInt(1), res.getString(2), date, res.getInt(4));

		}
	} catch (SQLException e) {
		e.printStackTrace();
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
			java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
			LogFile l = new LogFile(res.getInt(1), res.getString(2), date, res.getInt(4));
			list.add(l);
		}
	} catch (SQLException e) {
		e.printStackTrace();
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
				java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
				l = new LogFile(res.getInt(1), res.getString(2), date, res.getInt(4));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return l;
	}
}
