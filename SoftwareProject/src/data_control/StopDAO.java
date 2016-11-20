package data_control;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Stop;
import model.Ticket;

public class StopDAO extends BaseDAO{
	public static void createStop(Stop stop)
	{
		PreparedStatement ps = null;
		
		String sql = "INSERT INTO Stop VALUES(?,?,?,?)";
		
		try {

	        if (getConnection().isClosed()) {
	            throw new IllegalStateException("error unexpected");
	        }
	        ps = getConnection().prepareStatement(sql);
	        
	        ps.setInt(1, stop.getTrainID());
	        ps.setInt(2, stop.getStopID());
	        ps.setString(2, stop.getName());
	        ps.setInt(3, stop.getPlatform());
	        
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
	
	public static void updateStop(Stop stop) {
		PreparedStatement ps = null;	
		String update = "UPDATE Stop SET trainID=?, stopID=?, name=?, platform=?, WHERE stopID=?";
		
		try {
		if (getConnection().isClosed()) {
			throw new IllegalStateException("error unexpected");
		}
			ps = getConnection().prepareStatement(update);
		
			ps.setInt(1, stop.getTrainID());
			ps.setInt(2, stop.getStopID());
			ps.setString(3, stop.getName());
			ps.setInt(4, stop.getPlatform());
			ps.setInt(5, stop.getStopID());
			
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new RuntimeException(e.getMessage());
		}
	}


public static Stop findStopById(int id) {
	Statement st = null;
	Stop s = null;
	
	try {
		if (getConnection().isClosed()) {
			throw new IllegalStateException("error unexpected");
		}
		st = (Statement) getConnection().createStatement();
		ResultSet res = st.executeQuery("SELECT * FROM Stop WHERE ID = " + id);

		while (res.next()) {
			s = new Stop(res.getInt(1), res.getInt(2),res.getString(3), res.getInt(4));

		}
	} catch (SQLException e) {
		e.printStackTrace();
	}

	return s;
}

public static ArrayList<Stop> getAllStops() {
	ArrayList<Stop> list = new ArrayList<Stop>();
	
	Statement st = null;
	try {
		if (getConnection().isClosed()) {
			throw new IllegalStateException("error unexpected");
		}
		st = (Statement) getConnection().createStatement();
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
