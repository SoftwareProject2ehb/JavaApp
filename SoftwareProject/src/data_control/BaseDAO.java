

package data_control;


import java.sql.Connection;
import java.sql.SQLException;

public class BaseDAO {

<<<<<<< HEAD
	private static Connection con = null;
=======
	protected Connection conn;
>>>>>>> refs/heads/master
	
	public static Connection getConnection() {
		try {
			conn = DatabaseConnect.getInstance().getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
<<<<<<< HEAD
		return con;
=======
	}

	public Connection getCon() {
		return conn;
>>>>>>> refs/heads/master
	}

<<<<<<< HEAD
	public static void setConnection(Connection con) {
		BaseDAO.con = con;
=======
	public void setCon(Connection con) {
		this.conn = con;
>>>>>>> refs/heads/master
	}
	
	
	
	
}
