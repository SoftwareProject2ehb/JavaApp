package controller;

import java.security.InvalidParameterException;
import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import data_control.UserDAO;
import model.Price.betalingsType;
import model.User;
import model.User.Role;
import utilities.Encryptor;
import view.*;

public class ConfigurationController {
	public static ReportView report;
	public static PriceConfigView price_config;
	public static UserView find_user;
	public static CreateUserView create_user;
	public static EditUserView edit_user;
	public static ConfigurationView configuration;
	
	public static void initialize(ReportView report, PriceConfigView price_config, UserView find_user, EditUserView edit_user, CreateUserView create_user, ConfigurationView configuration) {
		ConfigurationController.report = report;
		ConfigurationController.price_config = price_config;
		ConfigurationController.find_user = find_user;
		ConfigurationController.edit_user = edit_user;
		ConfigurationController.create_user = create_user;
		ConfigurationController.configuration = configuration;
	}
	
	public static void switchToReportView() {
		FrameController.getFrame().switchTo("REPORT");
	}
	
	public static void switchToPriceConfigView() {
		FrameController.getFrame().switchTo("PRICE_CONFIG");
		FrameController.changeSize(700, 400);
	}
	
	public static void switchToFindUserView() {
		FrameController.changeSize(665,430);
		find_user.refreshTable(find_user.tableModel);
		FrameController.getFrame().switchTo("FIND_USER");
	}
	
	public static void switchToCreateUserView() {
		FrameController.changeSize(430,300);
		FrameController.getFrame().switchTo("CREATE_USER");
	}
	
	public static void switchToEditUserView() {
		User user = getSelectedUser();
		edit_user.txtVoornaam.setText(user.getFirstName());
		edit_user.txtAchternaam.setText(user.getLastName());
		edit_user.txtEmail.setText(user.getEmail());
		edit_user.txtPhone.setText(user.getPhone());
		if(user.getRolen() == "ADMIN"){
			edit_user.comboRole.setSelectedItem("ADMIN");
		}
		else{
			edit_user.comboRole.setSelectedItem("USER");
		}
		FrameController.changeSize(430,300);
		FrameController.getFrame().switchTo("EDIT_USER");
	}
	
	public static User getSelectedUser(){
		int column = 0;
		int row = find_user.table.getSelectedRow();
		int value = Integer.parseInt(find_user.table.getModel().getValueAt(row, column).toString());
		User user = UserDAO.findUserById(value);
		return user;
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
		Role rol = null;
		Object chosenRole = create_user.role.getSelectedItem();
		if (chosenRole == "USER") {
			rol = Role.USER;
		}
		if (chosenRole == "ADMIN") {
			rol = Role.ADMIN;
		}
		//TODO empty fields check
		SystemController.addUser(voornaam,achternaam,email,phone, rol);
		create_user.txtVoornaam.setText("");
		create_user.txtAchternaam.setText("");
		create_user.txtEmail.setText("");
		create_user.txtPhone.setText("");
		switchToFindUserView();
	}
		
	public static void editUser() throws InvalidParameterException{
		String voornaam = edit_user.txtVoornaam.getText();
		String achternaam = edit_user.txtAchternaam.getText();
		String email = edit_user.txtEmail.getText();
		String phone = edit_user.txtPhone.getText();
		Role rol = null;
		Object chosenRole = edit_user.comboRole.getSelectedItem();
		if (chosenRole == "USER") {
			rol = Role.USER;
		}
		if (chosenRole == "ADMIN") {
			rol = Role.ADMIN;
		}
		//TODO empty fields check
		SystemController.editUser(voornaam,achternaam,email,phone, rol);
		edit_user.txtVoornaam.setText("");
		edit_user.txtAchternaam.setText("");
		edit_user.txtEmail.setText("");
		edit_user.txtPhone.setText("");
		switchToFindUserView();
	}
	
	public static void searchUser() throws InvalidParameterException{
		String txtSearch = find_user.txtSearch.getText();
		UserDAO.FindUser fUser = null;
		Object chosenAttribute = find_user.searchAtt.getSelectedItem();
		if(chosenAttribute == "ID"){
			fUser = UserDAO.FindUser.ID;
		}
		if(chosenAttribute == "Voornaam"){
			fUser = UserDAO.FindUser.first_name;
		}
		if(chosenAttribute == "Achternaam"){
			fUser = UserDAO.FindUser.last_name;
		}
		if(chosenAttribute == "Email"){
			fUser = UserDAO.FindUser.email;
		}
		if(chosenAttribute == "Telefoon Nr."){
			fUser = UserDAO.FindUser.phone;
		}
		if(chosenAttribute == "Username"){
			fUser = UserDAO.FindUser.login;
		}
		if(chosenAttribute == "Role"){
			fUser = UserDAO.FindUser.role;
		}
		//TODO empty field check
		find_user.tableModel.setRowCount(0);
		ArrayList<User> users = SystemController.searchUser(txtSearch, fUser);
		for (int i = 0; i < users.size(); i++){
			int id = users.get(i).getUserID();
			String voornaam = users.get(i).getFirstName();
			String achternaam = users.get(i).getLastName();
			String email = users.get(i).getEmail();
			String phone = users.get(i).getPhone();
			String login = users.get(i).getLogin();
			String role = users.get(i).getRolen();
					   
			Object[] data = {id,voornaam,achternaam,email,phone,login,role};
			find_user.tableModel.addRow(data);
		}
	}
	
	public static void setInactiveUser(){
    	User u = getSelectedUser();
		 int reply = JOptionPane.showConfirmDialog(null, "Are you sure you want to set " +u.getFirstName() +" "+ u.getLastName() +" to Inactive ?", "User Status", JOptionPane.YES_NO_OPTION);
	        if (reply == JOptionPane.YES_OPTION) {
	    		u.setActive(false);
	    		UserDAO.updateUser(u);
	    		find_user.refreshTable(find_user.tableModel);
	        }
	}
	
	public static void resetPassword(){
    	User u = getSelectedUser();
    	int reply = JOptionPane.showConfirmDialog(null, "Are you sure you want to reset the password of " +u.getFirstName() +" "+ u.getLastName() +" ?", "User Password", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {
        	u.setPassword(Encryptor.encrypt("pass"));
    		UserDAO.updateUser(u);
    		find_user.refreshTable(find_user.tableModel);
        }
	}

	public static void deletePrice() {
		SystemController.deleteTicketType(price_config.getPrice());
	}
	
	public static void createSubPrice() {
		SystemController.makeSubscriptionPrice(price_config.getSubTxtSoort(), betalingsType.PER_HOUR.toString(), 1, price_config.getMonths());
	}
	
	public static void updateSubPrice() {
		SystemController.updateSubscriptionType(price_config.getSubscriptionPrice());
	}
	
	public static void deleteSubPrice() {
		SystemController.deleteSubscriptionType(price_config.getSubscriptionPrice());
	}
}