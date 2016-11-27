

package data_control;


import java.sql.Connection;
import java.sql.SQLException;

public class BaseDAO {

	private static Connection con = null;

	public static Connection getRawConnection() {
		return con;
	}
	
	public static Connection getConnection() {
		try {
			if (con == null || con.isClosed()) {
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
