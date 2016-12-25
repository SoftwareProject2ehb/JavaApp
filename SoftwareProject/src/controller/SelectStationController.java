package controller;

import view.LoginView;
import view.SelectStationView;

public class SelectStationController {
	public static SelectStationView selectStation;
	
	public SelectStationController() {
		
	}
	
	public static void initialize(SelectStationView view) {
		SelectStationController.selectStation = view;
	}
	
	public static void switchToSelectStationView() {
		FrameController.getFrame().switchTo("SELECT_STATION");
	}
	
	public static void select() {
		//select statements
	}
}
