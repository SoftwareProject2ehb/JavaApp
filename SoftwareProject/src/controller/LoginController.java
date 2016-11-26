package controller;

import java.security.InvalidParameterException;

import data_control.*;
import model.*;
import view.*;

public class LoginController {

	public static LoginView login;
	
	public LoginController() {
		
	}
	
	public static void initialize(LoginView login) {
		LoginController.login = login;
	}
	
	public static void switchToLoginView() {
		SystemController.frame.switchTo("LOGIN");
		login.reset();
	}
	
	public static boolean login() {
		String username = login.getTextFields().get(0).getText();
		String password = login.getTextFields().get(1).getText();
		
		try {
			Boolean bool = SystemController.login(username, password);
			return bool;
				
		} catch (NullPointerException e) {
			// TODO: handle exception
			System.out.println("Mogelijk onbestaande username.");
		}
		
		return false;
	}
}