package data_control;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.*;

public class TrainDAO extends BaseDAO {

	public void addTrain(Train train){
		PreparedStatement ps = null;

		String sql = "INSERT INTO Train VALUES(?,?,?,?,?)";
		try {

	        if (getCon().isClosed()) {
	            throw new IllegalStateException("error unexpected");
	        }
	        ps = getCon().prepareStatement(sql);
	        
	        ps.setInt(1, train.getId());
	        ps.setString(2, train.getStart());
	        ps.setString(3, train.getArrival());
	        
	        //Date? 
	        ps.setDate(4, train.getStartTime());
	        ps.setDate(5, train.getArrivalTime());
	        
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
	
	public void getTrain(Train train){
	
	
	
}
