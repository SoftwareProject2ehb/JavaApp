package controller;

import java.security.InvalidParameterException;

import model.User.Role;
import view.*;

public class ConfigurationController {
	public static ReportView report;
	public static PriceConfigView price_config;
	public static UserView find_user;
	public static CreateUserView create_user;
	public static ConfigurationView configuration;
	
	public static void initialize(ReportView report, PriceConfigView price_config, UserView find_user, CreateUserView create_user, ConfigurationView configuration) {
		ConfigurationController.report = report;
		ConfigurationController.price_config = price_config;
		ConfigurationController.find_user = find_user;
		ConfigurationController.create_user = create_user;
		ConfigurationController.configuration = configuration;
	}
	
	public static void switchToReportView() {
		SystemController.frame.switchTo("REPORT");
	}
	
	public static void switchToPriceConfigView() {
		SystemController.frame.switchTo("PRICE_CONFIG");
	}
	
	public static void switchToFindUserView() {
		SystemController.frame.switchTo("FIND_USER");
	}
	
	public static void switchToCreateUserView() {
		SystemController.frame.switchTo("CREATE_USER");
	}
	
	public static void switchToConfigurationView() {
		SystemController.frame.switchTo("CONFIGURATION");
	}
	
	public static void createUser() throws InvalidParameterException{
		String voornaam = create_user.txtVoornaam.getText();
		String achternaam = create_user.txtAchternaam.getText();
		String email = create_user.txtEmail.getText();
		String phone = create_user.txtPhone.getText();
		String passText = new String(create_user.txtPassword.getPassword());
		String passText1 = new String(create_user.txtPassword1.getPassword());
		Role rol = null;
		Object chosenRole = create_user.role.getSelectedItem();
		if (chosenRole == "USER") {
			rol = Role.USER;
		}
		if (chosenRole == "ADMIN") {
			rol = Role.ADMIN;
		}
		SystemController.addUser(voornaam,achternaam,email,phone,passText, rol);
		
	}
}
