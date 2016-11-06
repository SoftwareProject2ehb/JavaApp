

package data_control;


import java.sql.Connection;
import java.sql.SQLException;

public class BaseDAO {

	private Connection con;
	
	public BaseDAO()
	{
		try {
			con = DatabaseConnect.getInstance().getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}
	
	
	
	
}
