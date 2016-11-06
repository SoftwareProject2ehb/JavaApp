package data_control;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.LogFile;

public class LogFileDAO {
	public void createLogFile(LogFile logfile)
	{
		PreparedStatement ps = null;
		
		String sql = "INSERT INTO LogFile VALUES(?,?,?,?)";
		
		try {

	        if (getCon().isClosed()) {
	            throw new IllegalStateException("error unexpected");
	        }
	        ps = getCon().prepareStatement(sql);
	        
	        ps.setInt(1, logfile.getLogFileID());
	        ps.setString(2, logfile.getDescription());
	        java.sql.Date sqlTime = new java.sql.Date(logfile.getTime().getTime());
	        ps.setDate(3, sqlTime);
	        ps.setInt(4, logfile.getUserID());
	        
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
	
	public void updateLogfile(LogFile logfile) {
		PreparedStatement ps = null;	
		String update = "UPDATE LogFile SET logFileID=?, description=?, time=?, userID=?, WHERE logFileID=?";
		
		try {
		if (getCon().isClosed()) {
			throw new IllegalStateException("error unexpected");
		}
			ps = getCon().prepareStatement(update);
		
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
}

	public LogFile findLogFileById(int id) {
	Statement st = null;
	LogFile l = null;
	
	try {
		if (getCon().isClosed()) {
			throw new IllegalStateException("error unexpected");
		}
		st = (Statement) getCon().createStatement();
		ResultSet res = st.executeQuery("SELECT * FROM LogFile WHERE logFileID = " + id);

		while (res.next()) {
			s = new LogFile(res.getInt(1), res.getString(2),res.getDate(3), res.getInt(4));

		}
	} catch (SQLException e) {
		e.printStackTrace();
	}

	return l;
}

	public ArrayList<Stop> getAllStops() {
	ArrayList<Stop> list = new ArrayList<Stop>();
	
	Statement st = null;
	try {
		if (getCon().isClosed()) {
			throw new IllegalStateException("error unexpected");
		}
		st = (Statement) getCon().createStatement();
		ResultSet res = st.executeQuery("SELECT * FROM Stop");

		while (res.next()) {
			Stop s = new Stop(res.getInt(1), res.getInt(2),res.getString(3), res.getInt(4));
			list.add(s);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}

	return list;
}
}
