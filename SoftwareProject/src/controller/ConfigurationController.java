package controller;

import java.security.InvalidParameterException;

import data_control.UserDAO;
import model.Price.betalingsType;
import model.User;
import model.User.Role;
import view.*;

public class ConfigurationController {
	public static ReportView report;
	public static PriceConfigView price_config;
	public static UserView find_user;
	public static CreateUserView create_user;
	public static EditUserView edit_user;
	public static ConfigurationView configuration;
	
	public static void initialize(ReportView report, PriceConfigView price_config, UserView find_user,EditUserView edit_user, CreateUserView create_user, ConfigurationView configuration) {
		ConfigurationController.report = report;
		ConfigurationController.price_config = price_config;
		ConfigurationController.find_user = find_user;
		ConfigurationController.create_user = create_user;
		ConfigurationController.edit_user = edit_user;
		ConfigurationController.configuration = configuration;
	}
	
	public static void switchToReportView() {
		FrameController.getFrame().switchTo("REPORT");
	}
	
	public static void switchToPriceConfigView() {
		FrameController.getFrame().switchTo("PRICE_CONFIG");
	}
	
	public static void switchToFindUserView() {
		find_user.refreshTable(find_user.tableModel);
		FrameController.getFrame().switchTo("FIND_USER");
	}
	
	public static void switchToCreateUserView() {
		FrameController.getFrame().switchTo("CREATE_USER");
	}
	
	public static void switchToEditUserView() {
		FrameController.getFrame().switchTo("EDIT_USER");
	}
	
	public static void switchToConfigurationView() {
		FrameController.getFrame().switchTo("CONFIGURATION");
	}
	
	public static void createPrice() {
		SystemController.makeTicketType(price_config.getTxtSoort(), betalingsType.PER_HOUR.toString(), 1);
	}
	
	public static void updatePrice() {
		SystemController.updateTicketType(price_config.getPrice());
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
	
	public static void editUser() throws InvalidParameterException{
		int column = 0;
		int row = find_user.table.getSelectedRow();
		String value = find_user.table.getModel().getValueAt(row, column).toString();
		User u = UserDAO.findUserByLogin(value);
		create_user.txtVoornaam.setText(u.getFirstName());
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
	
	
	
	public static void deletePrice() {
		SystemController.deleteTicketType(price_config.getPrice());
	}
}