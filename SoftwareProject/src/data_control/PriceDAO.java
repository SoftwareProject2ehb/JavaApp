package data_control;

import model.*;
import model.Price.betalingsType;

import com.mysql.jdbc.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PriceDAO extends BaseDAO {
	public void createPrice(Price price) {
		
		PreparedStatement ps = null;

		String sql = "INSERT INTO Price(typeTicket, typeBetaling, costPerUnit) VALUES(?,?,?)";
		
		try {

	        if (getCon().isClosed()) {
	            throw new IllegalStateException("error unexpected");
	        }
	        ps = getCon().prepareStatement(sql);
	        
	        ps.setString(1, price.getTypeTicket());
	        ps.setString(1, price.getTypeBetaling().toString());
	        ps.setDouble(3, price.getCostPerUnit());
	        
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
	
	public void removePrice(int id) {
		PreparedStatement ps = null;	
		String update = "DELETE FROM Price WHERE ID = ?";
		
		try {
		if (getCon().isClosed()) {
			throw new IllegalStateException("error unexpected");
		}
			ps = getCon().prepareStatement(update);
		
			ps.setInt(1, id);
			
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new RuntimeException(e.getMessage());
		}
	}
	
	public void updatePrice(Price price) {
		PreparedStatement ps = null;	
		String update = "UPDATE Price SET typeTicket=?, typeBetaling=?, costPerUnit=? WHERE ID = ?";
		
		try {
		if (getCon().isClosed()) {
			throw new IllegalStateException("error unexpected");
		}
			ps = getCon().prepareStatement(update);
		
			ps.setString(1, price.getTypeTicket());
			ps.setString(2, price.getTypeBetaling().toString());
			ps.setDouble(3, price.getCostPerUnit());
			ps.setInt(4, price.getId());
			
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new RuntimeException(e.getMessage());
		}
	}
	
	public Price findPriceById(int id) {
		Statement st = null;
		Price p = null;
		try {
			if (getCon().isClosed()) {
				throw new IllegalStateException("error unexpected");
			}
			st = (Statement) getCon().createStatement();
			ResultSet res = st.executeQuery("SELECT * FROM Price WHERE ID = " + id);

			while (res.next()) {
				p = new Price(res.getInt(1), res.getString(2), betalingsType.stringToBetalingsType(res.getString(3)), res.getDouble(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return p;
	}
}