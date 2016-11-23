package data_control;

import java.sql.*;

import java.util.ArrayList;

import com.mysql.jdbc.Statement;

import model.*;

public class TrainDAO extends BaseDAO {

	public void addTrain(Train train){
		PreparedStatement ps = null;

		String sql = "INSERT INTO Train VALUES(?,?,?,?,?)";
		try {

	        if (getConnection().isClosed()) {
	            throw new IllegalStateException("error unexpected");
	        }
	        ps = getConnection().prepareStatement(sql);
	        
	        ps.setInt(1, train.getId());
	        ps.setString(2, train.getStart());
	        ps.setString(3, train.getArrival());
	        
	        //Date? 
	        ps.setTimestamp(4, train.getStartTime());
	        ps.setTimestamp(5, train.getArrivalTime());
	        
	        
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
	            System.out.println(e.getMessage());
	            throw new RuntimeException("error.unexpected");
	        }
	    }
	}
	
	public Train getTrainById(int id){
		Train trein = null;
		PreparedStatement ps = null;
		String sql = "Select * from Train where ID=?";
		
		
		try {
			if (getConnection().isClosed()) {
				throw new IllegalStateException("error unexpected");
			}
			 
			 
			ps = getConnection().prepareStatement(sql);
			ps.setInt(1,id);
			ResultSet res = ps.executeQuery("SELECT * FROM Train");
			 
			if (res.next()) {
				trein = new Train(res.getInt(1), res.getString(2),res.getString(3), res.getTimestamp(4), res.getTimestamp(5));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
		

	return trein;
	}
	
	public ArrayList<Train> getAllTrains(){
		
		ArrayList<Train> lijst = new ArrayList<Train>();
		Statement st = null;
		try {
			if (getConnection().isClosed()) {
				throw new IllegalStateException("error unexpected");
			}
			st = (Statement) getConnection().createStatement();
			ResultSet res = st.executeQuery("SELECT * FROM Train");

			while (res.next()) {
				Train trein = new Train(res.getInt(1), res.getString(2),res.getString(3), res.getTimestamp(4), res.getTimestamp(5));
				lijst.add(trein);
			}
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
	            throw new RuntimeException("error.unexpected");
	        }
	    }

		return lijst;
		
	}
	
	public static int findNextId() {
		int id = 0;
		Statement st = null;
		
		try {

	        if (getConnection().isClosed()) {
	            throw new IllegalStateException("error unexpected");
	        }
	        
	        st = (Statement) getConnection().createStatement();
	        ResultSet res = st.executeQuery("SELECT MAX(ID) FROM Train");
	        
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
}
