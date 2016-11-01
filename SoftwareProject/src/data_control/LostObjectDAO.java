package data_control;

import model.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LostObjectDAO extends BaseDAO{

	
	
	
	
	
	public void CreatLostObject (LostObject object)
	{
		 PreparedStatement ps = null;

		    String sql = "INSERT INTO LostObject VALUES(null,?,?,?,?)";

		    try {

		        if (getCon().isClosed()) {
		            throw new IllegalStateException("error unexpected");
		        }
		        ps = getCon().prepareStatement(sql);
		        
		        ps.setInt(1, object.getUserID());
		        ps.setString(2, object.getName());
		        ps.setString(3, object.getPlace());
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


 
   public static void main(String[] args) {
       
	   LostObjectDAO lost = new LostObjectDAO();
       LostObject u = new LostObject(1,"daoud","ehb","19/10/2001");
       lost.CreatLostObject(u);
       //User u = ud.find(1);
     
      //System.out.println(u.getEmail());
   }
   

}