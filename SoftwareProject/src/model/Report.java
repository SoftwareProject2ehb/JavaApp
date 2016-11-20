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
		ArrayList<String> meestVerkocht= ReportDAO.getMostDestinationTicket();
		
				
		return meestVerkocht;
	}
	
	
	public static String getTypeMostSoldTicket(){
		
		String type =ReportDAO.getTypeMostSoldTicket();
		

		
				
		return type;
		
		
	}
	public static int getAmountSoldTicket()
	{
		int amount = ReportDAO.getAmountSoldTicket();
		

				
		return amount;
	}
	
	public static ArrayList<String> getMostStartStationSubscription()
	{
		ArrayList<String> meestVerkocht= ReportDAO.getMostStartStationSubscription();
		
				
		return meestVerkocht;
	}
	
	
	
	public static ArrayList<String> getMostDestinationSubscription()
	{
		ArrayList<String> meestVerkocht= ReportDAO.getMostDestinationSubscription();
		
				
		return meestVerkocht;
	}
	
	
	public static String getTypeMostSoldSubscription(){
		
		String type = ReportDAO.getTypeMostSoldSubscription();
		

		
				
		return type;
		
		
	}
	
	public static int getAmountSoldSubscripton()
	{
		int amount = ReportDAO.getAmountSoldSubscripton();
		

	
		return amount;
	}
	
}
