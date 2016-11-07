package data_control;

import model.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Statement;

public class LostObjectDAO extends BaseDAO{

	enum ZoekLostObject {ID,userid,name,place,timeFound,claimed ,nameClaimed,timeClaimed};
	
	
	
	
	public void creatLostObject (LostObject object)
	{
		 PreparedStatement ps = null;

		    String sql = "INSERT INTO LostObject VALUES(null,?,?,?,?,false,null,null)";

		    try {

		        if (getCon().isClosed()) {
		            throw new IllegalStateException("error unexpected");
		        }
		        ps = getCon().prepareStatement(sql);
		        
		        ps.setInt(1, object.getUserID());
		        ps.setString(2, object.getName());
		        ps.setString(3, object.getPlace());
		        // TO DO SET DATE
		        ps.setString(4, object.getDate());
		  
		        
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


public void updateLostObect(LostObject object) {
		
		PreparedStatement ps = null;	
		String update = "UPDATE LostObject SET claimed = true, nameClaimed=?, time=? WHERE ID = ?";
		
		try {
		if (getCon().isClosed()) {
			throw new IllegalStateException("error unexpected");
		}
			ps = getCon().prepareStatement(update);
		
	
			
			ps.setString(1, object.getNameClaimed());
			ps.setString(2, object.getDateClaimed());
			ps.setInt(3, object.getID());
			 // TO DO SET DATE
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			
			throw new RuntimeException(e.getMessage());
		}      
	}

public LostObject getLostObjectFromRS(ResultSet res) throws SQLException{
	
	return new LostObject(res.getInt(1), res.getInt(2),res.getString(3), res.getString(4), res.getString(5), res.getBoolean(6),res.getString(7),res.getString(8));
}


public LostObject getLostObjectById(int objectID) {
	Statement st = null;
	LostObject lost = null;
	try {
		if (getCon().isClosed()) {
			throw new IllegalStateException("error unexpected");
		}
		st = (Statement) getCon().createStatement();
		ResultSet res = st.executeQuery("SELECT * FROM LostObject WHERE ID = " + objectID);

		while (res.next()) {
			lost = new LostObject(res.getInt(1), res.getInt(2),res.getString(3), res.getString(4), res.getString(5), res.getBoolean(6),res.getString(7),res.getString(8));

		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}


	return lost;
}



public ArrayList<LostObject> getAllLostObject() {
	ArrayList<LostObject> lijst = new ArrayList<LostObject>();
	Statement st = null;
	try {
		if (getCon().isClosed()) {
			throw new IllegalStateException("error unexpected");
		}
		st = (Statement) getCon().createStatement();
		ResultSet res = st.executeQuery("SELECT * FROM LostObject");

		while (res.next()) {
			LostObject lost = new LostObject(res.getInt(1), res.getInt(2),res.getString(3), res.getString(4), res.getString(5), res.getBoolean(6),res.getString(7),res.getString(8));
			lijst.add(lost);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	return lijst;
}
public ArrayList<LostObject> getAllLostObjectNotClaimed() {
	ArrayList<LostObject> lijst = new ArrayList<LostObject>();
	Statement st = null;
	try {
		if (getCon().isClosed()) {
			throw new IllegalStateException("error unexpected");
		}
		st = (Statement) getCon().createStatement();
		ResultSet res = st.executeQuery("SELECT * FROM LostObject WHERE claimed = false");

		while (res.next()) {
			LostObject lost = new LostObject(res.getInt(1), res.getInt(2),res.getString(3), res.getString(4), res.getString(5), res.getBoolean(6),res.getString(7),res.getString(8));
			lijst.add(lost);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	return lijst;
}

public ArrayList<LostObject> getAllLostObjectClaimed() {
	ArrayList<LostObject> lijst = new ArrayList<LostObject>();
	Statement st = null;
	try {
		if (getCon().isClosed()) {
			throw new IllegalStateException("error unexpected");
		}
		st = (Statement) getCon().createStatement();
		ResultSet res = st.executeQuery("SELECT * FROM LostObject WHERE claimed = true");

		while (res.next()) {
			LostObject lost = new LostObject(res.getInt(1), res.getInt(2),res.getString(3), res.getString(4), res.getString(5), res.getBoolean(6),res.getString(7),res.getString(8));
			lijst.add(lost);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	return lijst;
}


//ZOEK op attribuut werkt niet
public ArrayList<LostObject> getLostObjectOpAttribut(ZoekLostObject attribuut,String zoekop) {
	ArrayList<LostObject> lijst = new ArrayList<LostObject>();
	Statement st = null;
	try {
		if (getCon().isClosed()) {
			throw new IllegalStateException("error unexpected");
		}
		st = (Statement) getCon().createStatement();
		ResultSet res = st.executeQuery("SELECT * FROM LostObject WHERE" + attribuut +"='" + zoekop + "'");

		while (res.next()) {
			LostObject lost = new LostObject(res.getInt(1), res.getInt(2),res.getString(3), res.getString(4), res.getString(5), res.getBoolean(6),res.getString(7),res.getString(8));
			lijst.add(lost);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	return lijst;
}

   public static void main(String[] args) {
       
	   LostObjectDAO lost = new LostObjectDAO();
       //LostObject u = new LostObject(1,"daoud","ehb","19/10/2001");
       //lost.creatLostObject(u);
      
       ArrayList<LostObject> lijst = new ArrayList<LostObject>();
       lijst = lost.getAllLostObjectClaimed();
       System.out.println(lijst.toString());
      
    
   }
   

}