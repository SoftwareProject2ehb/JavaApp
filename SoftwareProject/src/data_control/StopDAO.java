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
		
		String sql = "INSERT INTO Stop VALUES(null,?,?,?)";
		
		try {

	        if (getConnection().isClosed()) {
	            throw new IllegalStateException("error unexpected");
	        }
	        ps = getConnection().prepareStatement(sql);
	        
	        ps.setInt(1, stop.getTrainID());
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
	            if (!getConnection().isClosed())
					getConnection().close();

	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	            throw new RuntimeException("error.unexpected");
	        }
	    }
	}
	
	public static void updateStop(Stop stop) {
		PreparedStatement ps = null;	
		String update = "UPDATE Stop SET trainID=?, stopID=?, name=?, platform=? WHERE stopID=?";
		
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


public static Stop findStopById(int id) {
	Statement st = null;
	Stop s = null;
	ResultSet res = null;
	
	try {
		if (getConnection().isClosed()) {
			throw new IllegalStateException("error unexpected");
		}
		st = (Statement) getConnection().createStatement();
		res = st.executeQuery("SELECT * FROM Stop WHERE stopID = " + id);

		while (res.next()) {
			s = new Stop(res.getInt(2), res.getInt(1),res.getString(3), res.getInt(4));

		}
	} catch (SQLException e) {
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

	return s;
}

public static ArrayList<Stop> getAllStopsByTrainID(int id) {
	ArrayList<Stop> list = new ArrayList<Stop>();
	ResultSet res = null;
	Statement st = null;
	try {
		if (getConnection().isClosed()) {
			throw new IllegalStateException("error unexpected");
		}
		st = (Statement) getConnection().createStatement();
		res = st.executeQuery("SELECT * FROM Stop WHERE trainID = " + id);

		while (res.next()) {
			Stop s = new Stop(res.getInt(2), res.getInt(1),res.getString(3), res.getInt(4));
			list.add(s);
		}
	} catch (SQLException e) {
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

	return list;
}

public static ArrayList<Stop> getAllStops() {
	ArrayList<Stop> list = new ArrayList<Stop>();
	ResultSet res = null;
	Statement st = null;
	try {
		if (getConnection().isClosed()) {
			throw new IllegalStateException("error unexpected");
		}
		st = (Statement) getConnection().createStatement();
		res = st.executeQuery("SELECT * FROM Stop");

		while (res.next()) {
			Stop s = new Stop(res.getInt(2), res.getInt(1),res.getString(3), res.getInt(4));
			list.add(s);
		}
	} catch (SQLException e) {
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

	return list;
}

public static Stop getLatestEntry() {
	Statement st = null;
	Stop s = null;
	ResultSet res = null;
	try {
		if (getConnection().isClosed()) {
			throw new IllegalStateException("error unexpected");
		}
		st = (Statement) getConnection().createStatement();
		res = st.executeQuery("SELECT * FROM Stop ORDER BY stopID DESC LIMIT 1");

		while (res.next()) {
			s = new Stop(res.getInt(2), res.getInt(1),res.getString(3), res.getInt(4));
		}
	} catch (SQLException e) {
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

	return s;
}
}
