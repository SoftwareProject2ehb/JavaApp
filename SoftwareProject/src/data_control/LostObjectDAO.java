package data_control;
import databaseConnect.*;
import databaseConnectDAO.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LostObjectDAO extends BaseDAO{

	protected ResultSet rs;
    protected PreparedStatement ps;
    protected Connection conn;
	public LostObjectDAO() {
	    conn = null;
        rs = null;
        ps = null;
        getConnection();
	}
	
	
	public void getConnection(){
    	DatabaseConnect db = new DatabaseConnect();
        this.conn = db.getInstance().getConnection();
    }
	
	
	public int CreatLostObject (LostObject object)
	{
		 PreparedStatement ps = null;

		    String sql = "INSERT INTO User VALUES(?,?,?,?)";

		    try {

		        if (conn.isClosed()) {
		            throw new IllegalStateException("error unexpected");
		        }
		        ps = conn.prepareStatement(sql);
		        
		        ps.setInt(1, object.getUserID());
		        ps.setString(2, object.getName());
		        ps.setString(3, object.getPlace());
		        ps.setDate(3, object.getDate());
		  
		        
		        return ps.executeUpdate();
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


 
/*
    
 public User find(int userId) {
     User user = new User();      
       
     try {
       ResultSet result = this.conn.createStatement(
         ResultSet.TYPE_SCROLL_INSENSITIVE,
         ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM User WHERE id = " + userId);
       if(result.first())
         user = new User(
                 result.getInt("ID"),
                 result.getString("name"),
                 result.getString("email"),
                 result.getString("phone"),
                 result.getString("address"),
                 result.getString("login"),
                 result.getString("passwoord"),
                 result.getString("role"),
                 result.getBoolean("actif"));         
     } catch (SQLException e) {
       e.printStackTrace();
     }
     return user;
   }
   */
   public static void main(String[] args) {
       
     
       LostObject u = new LostObject(1,"daoud","ehb","19/10/2001");
       
       //User u = ud.find(1);
     
      //System.out.println(u.getEmail());
   }
   

}