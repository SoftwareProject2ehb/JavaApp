

package data_control;


import java.sql.Connection;
import java.sql.SQLException;

public class BaseDAO {

	protected Connection conn;
	
	public BaseDAO()
	{
		try {
			conn = DatabaseConnect.getInstance().getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Connection getCon() {
		return conn;
	}

	public void setCon(Connection con) {
		this.conn = con;
	}
	
	
	
	
}
