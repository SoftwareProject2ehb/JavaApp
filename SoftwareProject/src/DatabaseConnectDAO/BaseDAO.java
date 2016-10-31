package DatabaseConnectDAO;

package databaseConnectDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import databaseConnect.*;
public class BaseDAO {
	protected ResultSet rs;
    protected PreparedStatement ps;
    protected Connection conn;
    
    public BaseDAO(){
        conn = null;
        rs = null;
        ps = null;
        getConnection();
    }
    
    public void getConnection(){
    	DatabaseConnect db = new DatabaseConnect();
        this.conn = db.getInstance().getConnection();
    }
}
