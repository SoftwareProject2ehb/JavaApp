

package data_control;


import java.sql.Connection;
import java.sql.SQLException;

public class BaseDAO {

	private static Connection con = null;

	public static Connection getConnection() {
		return con;
	}
	
	public static Connection getOpenConnection() {
		try {
			if (getConnection() == null || getConnection().isClosed()) {
				con = DatabaseConnect.getInstance().getConnection();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;

	}

	public static void setConnection(Connection con) {
		BaseDAO.con = con;
	}
	
	
	
	
}
