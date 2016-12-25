package controller;

import java.security.InvalidParameterException;
import java.util.ArrayList;

import javax.swing.JLabel;

import model.User;
import view.AccountInfoView;
import view.ActionMenuView;

public class ActionMenuController {

public static ActionMenuView action_menu;
public static AccountInfoView account_info;
	
	public ActionMenuController() {
		
	}
	
	public static void initialize(ActionMenuView action_menu, AccountInfoView account_info) {
		ActionMenuController.action_menu = action_menu;
		ActionMenuController.account_info = account_info;
	}
	
	public static void refresh() {
		ActionMenuController.action_menu = null;
		ActionMenuController.account_info = null;
	}
	
	public static void switchToActionMenuView() {
		FrameController.getFrame().switchTo("ACTION_MENU");
		FrameController.changeSize(500, 300);
	}
	public static void switchToAccountInfoView() {
		FrameController.getFrame().switchTo("ACCOUNT_INFO");
		FrameController.changeSize(500, 300);
	}
	
	public static void AccountInfo(){
		User user  = SystemController.system.logged_user;
		ArrayList<JLabel> array = account_info.getLabels();
		String status = null;
		if (user.isActive())
			status = "Active";
		else
			status = "Inactive";
		account_info.lblNaam.setText(user.toStringName());
		account_info.lblEmail.setText(user.getEmail());
		account_info.lblEmail.setSize(account_info.lblEmail.getPreferredSize());
		account_info.lblPhone.setText(user.getPhone());
		account_info.lblRole.setText(user.getRolen());
		account_info.lblStatus.setText(status);
		account_info.lblStraat.setText(user.toString());
		for (int i = 0; i < 6; i++) {
			array.get(i).setSize(array.get(i).getPreferredSize());
		}
		switchToAccountInfoView();
	}
	
}
