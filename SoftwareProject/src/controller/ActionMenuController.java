package controller;

import view.ActionMenuView;

public class ActionMenuController {

public static ActionMenuView action_menu;
	
	public ActionMenuController() {
		
	}
	
	public static void initialize(ActionMenuView action_menu) {
		ActionMenuController.action_menu = action_menu;
	}
	
	public static void switchToActionMenuView() {
		FrameController.getFrame().switchTo("ACTION_MENU");
		FrameController.changeSize(500, 300);
	}
}
