package controller;

import view.CreateCustomerView;
import view.FindCustomerView;
import view.LoginView;

public class LoginController {

	public static LoginView login;
	
	public LoginController() {
		
	}
	
	public static void initialize(LoginView login) {
		LoginController.login = login;
	}
	
	public static void switchToLoginView() {
		SystemController.frame.switchTo("LOGIN");
	}
	
	public static void login() {
		
	}
}
