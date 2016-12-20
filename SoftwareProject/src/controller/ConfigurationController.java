package controller;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.security.InvalidParameterException;
import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import data_control.UserDAO;
import model.Price.betalingsType;
import model.User;
import model.User.Role;
import utilities.Encryptor;
import utilities.Language;
import utilities.Language.LANGUAGE;
import view.*;

public class ConfigurationController {
	public static ReportView report;
	public static PriceConfigView price_config;
	public static UserView find_user;
	public static CreateUserView create_user;
	public static EditUserView edit_user;
	public static EditPasswordView edit_password_view;
	public static ConfigurationView configuration;
	
	public static void initialize(ReportView report, PriceConfigView price_config, UserView find_user, EditUserView edit_user, CreateUserView create_user,EditPasswordView edit_password_view , ConfigurationView configuration) {
		ConfigurationController.report = report;
		ConfigurationController.price_config = price_config;
		ConfigurationController.find_user = find_user;
		ConfigurationController.edit_user = edit_user;
		ConfigurationController.edit_password_view = edit_password_view;
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
		FrameController.changeSize(800,450);
		find_user.refreshTable(find_user.tableModel);
		FrameController.getFrame().switchTo("FIND_USER");
	}
	public static void switchToEditPasswordView() {
		edit_password_view.txtPass1.setText("");
		edit_password_view.txtPass2.setText("");
		FrameController.getFrame().switchTo("EDIT_PASSWORD");
	}
	
	public static void switchToCreateUserView() {
		FrameController.changeSize(850,350);
		FrameController.getFrame().switchTo("CREATE_USER");
	}
	
	public static void switchToEditUserView() {
		User user = getSelectedUser();
		edit_user.txtVoornaam.setText(user.getFirstName());
		edit_user.txtAchternaam.setText(user.getLastName());
		edit_user.txtEmail.setText(user.getEmail());
		edit_user.txtPhone.setText(user.getPhone());
		edit_user.txtStreet.setText(user.getStreet());
		edit_user.txtNumber.setText(user.getNumber());
		edit_user.txtBus.setText(user.getBus());
		edit_user.txtPostalCode.setText(Integer.toString(user.getPostalCode()));
		edit_user.txtCity.setText(user.getCity());
		edit_user.txtCountry.setText(user.getCountry());
		if(user.getRolen() == "ADMIN"){
			edit_user.comboRole.setSelectedItem("ADMIN");
		}
		else{
			edit_user.comboRole.setSelectedItem("USER");
		}
		FrameController.changeSize(850,350);
		FrameController.getFrame().switchTo("EDIT_USER");
	}
	
	public static User getSelectedUser(){
		int column = 0;
		int row = find_user.table.getSelectedRow();
		User user = null;
		if (row == -1){ // no row selected 
			JOptionPane.showMessageDialog(find_user, "No row was selected");
		}else{
			int value = Integer.parseInt(find_user.table.getModel().getValueAt(row, column).toString());
			user = UserDAO.findUserById(value);
		}
		return user;
	}
	
	public static void switchToConfigurationView() {
		FrameController.getFrame().switchTo("CONFIGURATION");
		FrameController.changeSize(500, 300);
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
		String street = create_user.txtStreet.getText();
		String number = create_user.txtNumber.getText();
		String bus = create_user.txtBus.getText();
		int postalCode = Integer.parseInt(create_user.txtPostalCode.getText());
		String city = create_user.txtCity.getText();
		String country = create_user.txtCountry.getText();
		Role rol = null;
		Object chosenRole = create_user.role.getSelectedItem();
		if (chosenRole == "USER") {
			rol = Role.USER;
		}
		if (chosenRole == "ADMIN") {
			rol = Role.ADMIN;
		}
		if(allFieldsEmptyCreate()){
			SystemController.addUser(voornaam,achternaam,email,phone, rol, street, number, bus, postalCode, city, country);
			create_user.txtVoornaam.setText("");
			create_user.txtAchternaam.setText("");
			create_user.txtEmail.setText("");
			create_user.txtPhone.setText("");
			create_user.txtStreet.setText("");
			create_user.txtNumber.setText("");
			create_user.txtBus.setText("");
			create_user.txtPostalCode.setText("");
			create_user.txtCity.setText("");
			create_user.txtCountry.setText("");
			switchToFindUserView();
		}		
	}
	public static boolean allFieldsEmptyCreate() {
		ArrayList<JTextField> array = create_user.getTextFields();
			for (JTextField textbox : array) {
	            if (textbox.getText().trim().isEmpty()) {
	            	JOptionPane.showMessageDialog(create_user, "Field(s) missing !");
	                return false;
	            }
	        }
        return true;
    }
	public static boolean AllFieldsEmptyEdit() {
		ArrayList<JTextField> array = edit_user.getTextFields();
        for (JTextField textbox : array) {
            if (textbox.getText().trim().isEmpty() ) {
            	JOptionPane.showMessageDialog(edit_user, "Field(s) missing !");
                return false;
            }
        }
        return true;
    }
		
	public static void editUser() throws InvalidParameterException{
		Role rol = null;
		Object chosenRole = edit_user.comboRole.getSelectedItem();
		String voornaam = edit_user.txtVoornaam.getText();
		String achternaam = edit_user.txtAchternaam.getText();
		String email = edit_user.txtEmail.getText();
		String phone = edit_user.txtPhone.getText();
		String street = edit_user.txtStreet.getText();
		String number = edit_user.txtNumber.getText();
		String bus = edit_user.txtBus.getText();
		int postalCode = Integer.parseInt(edit_user.txtPostalCode.getText());
		String city = edit_user.txtCity.getText();
		String country = edit_user.txtCountry.getText();
		String pass1 = String.valueOf(edit_user.txtPass1.getPassword());
		String pass2 = String.valueOf(edit_user.txtPass2.getPassword());
		if (chosenRole == "USER") {
			rol = Role.USER;
		}
		if (chosenRole == "ADMIN") {
			rol = Role.ADMIN;
		}
		if(pass1.equals(pass2) || pass1 == null && pass2 == null || pass1 == "" && pass2 == ""){
			if(AllFieldsEmptyEdit()){
				SystemController.editUser(voornaam,achternaam,email,phone, rol,street,number,bus,postalCode,city,country,pass1);
				edit_user.txtPass1.setText("");
				edit_user.txtPass2.setText("");
				switchToFindUserView();
			}
		}
		else {
			JOptionPane.showMessageDialog(edit_user, "Passwords don't match !");
		}
		//TODO empty fields check
		
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
		if(chosenAttribute == "Straat"){
			fUser = UserDAO.FindUser.street;
		}
		if(chosenAttribute == "Postcode"){
			fUser = UserDAO.FindUser.postalcode;
		}
		if(chosenAttribute == "Land"){
			fUser = UserDAO.FindUser.country;
		}
		if(chosenAttribute == "Stad"){
			fUser = UserDAO.FindUser.city;
		}
		//TODO empty field check
		find_user.tableModel.setRowCount(0);
		ArrayList<User> users = SystemController.searchUser(txtSearch, fUser);
		for (int i = 0; i < users.size(); i++){
			int id = users.get(i).getUserID();
			String voornaam = users.get(i).getFirstName();
			String achternaam = users.get(i).getLastName();
			String email = users.get(i).getEmail();
			String login = users.get(i).getLogin();
			String role = users.get(i).getRolen();
			String city = users.get(i).getCity();
					   
			Object[] data = {id,voornaam,achternaam,email,city,login,role};
			find_user.tableModel.addRow(data);
		}
	}
	
	public static ArrayList<User> findUser() throws InvalidParameterException{
		UserDAO.FindUser fd = null;
		ArrayList<User> ArrU = null;
		Object find = find_user.searchAtt.getSelectedItem();
		if (find == "ID") {
			fd = UserDAO.FindUser.ID;
			ArrU = UserDAO.findUserByAttribute(fd, find_user.txtSearch.getText());
		}
		if (find == "FIRSTNAME") {
			fd = UserDAO.FindUser.first_name;
			ArrU = UserDAO.findUserByAttribute(fd, find_user.txtSearch.getText());
		}
		if (find == "LASTNAME") {
			fd = UserDAO.FindUser.last_name;
			ArrU = UserDAO.findUserByAttribute(fd, find_user.txtSearch.getText());
		}
		if (find == "EMAIL") {
			fd = UserDAO.FindUser.last_name;
			ArrU = UserDAO.findUserByAttribute(fd, find_user.txtSearch.getText());
		}
		if (find == "PHONE") {
			fd = UserDAO.FindUser.last_name;
			ArrU = UserDAO.findUserByAttribute(fd, find_user.txtSearch.getText());
		}
		if (find == "USERNAME") {
			fd = UserDAO.FindUser.last_name;
			ArrU = UserDAO.findUserByAttribute(fd, find_user.txtSearch.getText());
		}
		return ArrU;
	}
	public static void editDefaultPassword(){
		User user  = SystemController.system.logged_user;
		String pass1 = String.valueOf(edit_password_view.txtPass1.getPassword());
		String pass2 = String.valueOf(edit_password_view.txtPass2.getPassword());
		if(pass1.equals(pass2) || pass1 == null && pass2 == null || pass1 == "" && pass2 == ""){
			user.setPassword(Encryptor.encrypt(pass1));
			UserDAO.updateUser(user);
			edit_password_view.txtPass1.setText("");
			edit_password_view.txtPass2.setText("");
			ActionMenuController.switchToActionMenuView();
		}
		else {
			JOptionPane.showMessageDialog(edit_password_view, "Passwords do not match!");
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
    	String password = u.getFirstName() + "_" + u.getLastName();
    	int reply = JOptionPane.showConfirmDialog(null, "Are you sure you want to reset the password of " +u.getFirstName() +" "+ u.getLastName() +" ?", "User Password", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {
        	u.setPassword(Encryptor.encrypt(password));
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
	
	public static void changeLanguage(String language)
	{
		LANGUAGE l = Language.getCurrentLanguage();
		System.out.println(language);
		if(language.equals(Language.getString("dutch")))
			l = LANGUAGE.DUTCH;
		if(language.equals(Language.getString("french")))
			l = LANGUAGE.FRENCH;
		if(language.equals(Language.getString("english")))
			l = LANGUAGE.ENGLISH;
		System.out.println("Language to set: " + l.toString());
		Language.setLanguage(l);
		Language.refresh();
		//refresh all views
	}
}