package data_control;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Statement;



public class ReportDAO extends BaseDAO {
	
	public static ArrayList<String> getMostStartStationTicket()
	{
		ArrayList<String> meestVerkocht= new ArrayList<String>();
		Statement st = null;
		ResultSet res = null;
		
		try {
			if (getConnection().isClosed()) {
				throw new IllegalStateException("error unexpected");
			}
			st = (Statement) getConnection().createStatement();
			res = st.executeQuery("select startstation, COUNT(startstation) AS MOST_FREQUENT from Ticket GROUP BY startstation ORDER BY COUNT(startstation) DESC ");

			while (res.next()) {
				String data ="Station: " +  res.getString(1) + " aantal: " + res.getInt(2);
				
				meestVerkocht.add(data);
			}
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
				
		return meestVerkocht;
	}
	
	
	
	public static ArrayList<String> getMostDestinationTicket()
	{
		ArrayList<String> meestVerkocht= new ArrayList<String>();
		Statement st = null;
		ResultSet res = null;
		
		try {
			if (getConnection().isClosed()) {
				throw new IllegalStateException("error unexpected");
			}
			st = (Statement) getConnection().createStatement();
			res = st.executeQuery("select endstation, COUNT(endstation) AS MOST_FREQUENT from Ticket GROUP BY endstation ORDER BY COUNT(endstation) DESC");

			while (res.next()) {
				String data ="Station: " +  res.getString(1) + " aantal: " + res.getInt(2);
				
				meestVerkocht.add(data);
			}
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
				
		return meestVerkocht;
	}
	
	
	public static String getTypeMostSoldTicket(){
		
		String type = null;
		Statement st = null;
		ResultSet res = null;
		
		try {
			if (getConnection().isClosed()) {
				throw new IllegalStateException("error unexpected");
			}
			st = (Statement) getConnection().createStatement();
			res = st.executeQuery("select type, COUNT(type) AS MOST_FREQUENT from Ticket GROUP BY type ORDER BY COUNT(type) DESC LIMIT 1");

			res.next();
			type = res.getString(1);
			
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
				
		return type;
		
		
	}
	public static int getAmountSoldTicket()
	{
		int amount = 0;
		Statement st = null;
		ResultSet res = null;
		
		try {
			if (getConnection().isClosed()) {
				throw new IllegalStateException("error unexpected");
			}
			st = (Statement) getConnection().createStatement();
			res = st.executeQuery("select COUNT(*) from Ticket");

			res.next();
			amount = res.getInt(1);
			
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			
		return amount;
	}
	
	public static ArrayList<String> getMostStartStationSubscription()
	{
		ArrayList<String> meestVerkocht= new ArrayList<String>();
		Statement st = null;
		ResultSet res = null;
		
		try {
			if (getConnection().isClosed()) {
				throw new IllegalStateException("error unexpected");
			}
			st = (Statement) getConnection().createStatement();
			res = st.executeQuery("select startstation, COUNT(startstation) AS MOST_FREQUENT from Subscription GROUP BY startstation ORDER BY COUNT(startstation) DESC ");

			while (res.next()) {
				String data ="Station: " +  res.getString(1) + " aantal: " + res.getInt(2);
				
				meestVerkocht.add(data);
			}
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
				
		return meestVerkocht;
	}
	
	
	
	public static ArrayList<String> getMostDestinationSubscription()
	{
		ArrayList<String> meestVerkocht= new ArrayList<String>();
		Statement st = null;
		ResultSet res = null;
		
		try {
			if (getConnection().isClosed()) {
				throw new IllegalStateException("error unexpected");
			}
			st = (Statement) getConnection().createStatement();
			res = st.executeQuery("select endstation, COUNT(endstation) AS MOST_FREQUENT from Subscription GROUP BY endstation ORDER BY COUNT(endstation) DESC");

			while (res.next()) {
				String data ="Station: " +  res.getString(1) + " aantal: " + res.getInt(2);
				
				meestVerkocht.add(data);
			}
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
				
		return meestVerkocht;
	}
	
	
	public static String getTypeMostSoldSubscription(){
		
		String type = null;
		Statement st = null;
		ResultSet res = null;
		
		try {
			if (getConnection().isClosed()) {
				throw new IllegalStateException("error unexpected");
			}
			st = (Statement) getConnection().createStatement();
			res = st.executeQuery("select type, COUNT(type) AS MOST_FREQUENT from Subscription GROUP BY type ORDER BY COUNT(type) DESC LIMIT 1");

			res.next();
			ResultSet res2 = st.executeQuery("SELECT name FROM `SubscriptionType` WHERE id =" + res.getString(1));
			res2.next();
			type = res2.getString(1);
			
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
				
		return type;
		
		
	}
	
	public static int getAmountSoldSubscripton()
	{
		int amount = 0;
		Statement st = null;
		ResultSet res = null;
		
		try {
			if (getConnection().isClosed()) {
				throw new IllegalStateException("error unexpected");
			}
			st = (Statement) getConnection().createStatement();
			res = st.executeQuery("select COUNT(*) from Subscription");

			res.next();
			amount = res.getInt(1);
			
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
				
		return amount;
	}
	
}
