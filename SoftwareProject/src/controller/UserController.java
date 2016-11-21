package controller;

import view.*;

public class UserController {
	public static CreateUserView create_user;
	
	public static void initialize(CreateUserView create_user){
		UserController.create_user = create_user;
	}
	
	public static void switchToCreateUserView(){
		SystemController.frame.switchTo("CREATE_USER");
	}
	
	
}
