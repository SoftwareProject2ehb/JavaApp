package controller;

import java.security.InvalidParameterException;
import java.util.ArrayList;

import javax.swing.*;

import data_control.ReportDAO;
import model.Report;
import view.*;



public class ReportController {

	public static ReportView report;
	
	public static void initialize(ReportView report) {
		ReportController.report = report;
	}
	
	public static void refresh() {
		ReportController.report = null;
	}
	
	public static void switchToReportView() {
		FrameController.getFrame().switchTo("REPORT");
	}
	
	public static String fillOutput(int index){
		
		
		
		ArrayList<String> meestVerkocht;
		String returnString = "";;
		switch(index){
		case 0:
			 meestVerkocht = Report.getMostStartStationTicket();
			
			for (int i = 0; i < meestVerkocht.size(); i++) {
				returnString += meestVerkocht.get(i) + "\n";
			}
			break;
		case 1:
			meestVerkocht = Report.getMostDestinationTicket();
			
			for (int i = 0; i < meestVerkocht.size(); i++) {
				returnString +=meestVerkocht.get(i) + "\n";
			}
			
			break;
		case 2:
			returnString += (ReportDAO.getTypeMostSoldTicket());
			break;
		case 3:
			returnString +=(String.valueOf(ReportDAO.getAmountSoldTicket()));
			break;
		case 4:
			 meestVerkocht = Report.getMostStartStationSubscription();
				
			for (int i = 0; i < meestVerkocht.size(); i++) {
				returnString +=(meestVerkocht.get(i) + "\n");
			}
			break;
		case 5:
			 meestVerkocht = Report.getMostDestinationSubscription();
				
			for (int i = 0; i < meestVerkocht.size(); i++) {
				returnString +=(meestVerkocht.get(i) + "\n");
			}
			break;
		case 6:
			returnString +=(String.valueOf(ReportDAO.getTypeMostSoldSubscription()));
			break;
		case 7:
			returnString +=(String.valueOf(ReportDAO.getAmountSoldSubscripton()));
			
			break;
		}
		return returnString;
		
	}
	

	
}