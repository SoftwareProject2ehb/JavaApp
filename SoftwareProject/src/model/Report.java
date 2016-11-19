package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import data_control.ReportDAO;
import com.mysql.jdbc.Statement;

public class Report {

	
	public static ArrayList<String> getMostStartStationTicket()
	{
		ArrayList<String> meestVerkocht= ReportDAO.getMostStartStationTicket();
		
				
		return meestVerkocht;
	}
	
	
	
	public static ArrayList<String> getMostDestinationTicket()
	{
		ArrayList<String> meestVerkocht= new ArrayList<String>();
		
				
		return meestVerkocht;
	}
	
	
	public static String getTypeMostSoldTicket(){
		
		String type = null;
		

		
				
		return type;
		
		
	}
	public static int getAmountSoldTicket()
	{
		int amount = ReportDAO.getAmountSoldTicket();
		

				
		return amount;
	}
	
	public static ArrayList<String> getMostStartStationSubscription()
	{
		ArrayList<String> meestVerkocht= new ArrayList<String>();
		
				
		return meestVerkocht;
	}
	
	
	
	public static ArrayList<String> getMostDestinationSubscription()
	{
		ArrayList<String> meestVerkocht= new ArrayList<String>();
		
				
		return meestVerkocht;
	}
	
	
	public static String getTypeMostSoldSubscription(){
		
		String type = null;
		

		
				
		return type;
		
		
	}
	
	public static int getAmountSoldSubscripton()
	{
		int amount = 0;
		

	
		return amount;
	}
	
}
