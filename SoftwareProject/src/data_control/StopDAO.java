package data_control;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Stop;

public class StopDAO extends BaseDAO{
	public void createStop(Stop stop)
	{
		PreparedStatement ps = null;
		
		String sql = "INSERT INTO Stop VALUES(?,?,?,?)";
		
		try {

	        if (getCon().isClosed()) {
	            throw new IllegalStateException("error unexpected");
	        }
	        ps = getCon().prepareStatement(sql);
	        
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
	
	public void updateStop(Stop stop) {
		PreparedStatement ps = null;	
		String update = "UPDATE Stop SET trainID=?, stopID=?, name=?, platform=?, WHERE stopID=?";
		
		try {
		if (getCon().isClosed()) {
			throw new IllegalStateException("error unexpected");
		}
			ps = getCon().prepareStatement(update);
		
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
}
