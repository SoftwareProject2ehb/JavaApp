package view;

import javax.swing.JPanel;
import javax.swing.SpringLayout;

import controller.ConfigurationController;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class EditUserView extends JPanel {
	public JTextField txtVoornaam;
	public JTextField txtEmail;
	public JTextField txtPhone;
	public JTextField txtStreet;
	public JTextField txtNumber;
	public JTextField txtBus;
	public JTextField txtPostalCode;
	public JTextField txtCity;
	public JTextField txtCountry;
	public JComboBox comboRole;
	public JTextField txtAchternaam;
	public JPasswordField txtPass1;
	public JPasswordField txtPass2;
	

	/**
	 * Create the panel.
	 */
	public EditUserView() {
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		
		JLabel lblEditUser = new JLabel("Edit User");
		springLayout.putConstraint(SpringLayout.NORTH, lblEditUser, 10, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, lblEditUser, 26, SpringLayout.WEST, this);
		lblEditUser.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(lblEditUser);
		
		JLabel lblNewLabel = new JLabel("Voornaam *: ");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel, 27, SpringLayout.SOUTH, lblEditUser);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel, 59, SpringLayout.WEST, this);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Achternaam *: ");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 94, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_1, 59, SpringLayout.WEST, this);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Email *: ");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_2, 26, SpringLayout.SOUTH, lblNewLabel_1);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_2, 59, SpringLayout.WEST, this);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Telefoon Nr. *: ");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_3, 21, SpringLayout.SOUTH, lblNewLabel_2);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_3, 0, SpringLayout.WEST, lblNewLabel);
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel_3, 144, SpringLayout.WEST, this);
		add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Role: ");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_4, 204, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_4, 0, SpringLayout.WEST, lblNewLabel);
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel_4, 144, SpringLayout.WEST, this);
		add(lblNewLabel_4);
		
		txtVoornaam = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, txtVoornaam, 56, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, txtVoornaam, 211, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel, -67, SpringLayout.WEST, txtVoornaam);
		springLayout.putConstraint(SpringLayout.EAST, txtVoornaam, 409, SpringLayout.WEST, this);
		add(txtVoornaam);
		txtVoornaam.setColumns(10);
		
		txtEmail = new JTextField();
		springLayout.putConstraint(SpringLayout.SOUTH, txtVoornaam, -55, SpringLayout.NORTH, txtEmail);
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel_2, -67, SpringLayout.WEST, txtEmail);
		springLayout.putConstraint(SpringLayout.NORTH, txtEmail, -3, SpringLayout.NORTH, lblNewLabel_2);
		springLayout.putConstraint(SpringLayout.WEST, txtEmail, 0, SpringLayout.WEST, txtVoornaam);
		springLayout.putConstraint(SpringLayout.EAST, txtEmail, 0, SpringLayout.EAST, txtVoornaam);
		add(txtEmail);
		txtEmail.setColumns(10);
		
		txtPhone = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, txtPhone, -3, SpringLayout.NORTH, lblNewLabel_3);
		springLayout.putConstraint(SpringLayout.WEST, txtPhone, 67, SpringLayout.EAST, lblNewLabel_3);
		add(txtPhone);
		txtPhone.setColumns(10);
		
		comboRole = new JComboBox();
		springLayout.putConstraint(SpringLayout.NORTH, comboRole, -3, SpringLayout.NORTH, lblNewLabel_4);
		springLayout.putConstraint(SpringLayout.WEST, comboRole, 67, SpringLayout.EAST, lblNewLabel_4);
		comboRole.addItem("USER");
		comboRole.addItem("ADMIN");
		add(comboRole);
		
		
		JButton btnTerug = new JButton("Terug");
		btnTerug.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConfigurationController.switchToFindUserView();
			}
		});
		add(btnTerug);
		
		JLabel lblStreet = new JLabel("Street *: ");
		springLayout.putConstraint(SpringLayout.NORTH, lblStreet, 0, SpringLayout.NORTH, lblNewLabel);
		springLayout.putConstraint(SpringLayout.WEST, lblStreet, 463, SpringLayout.WEST, this);
		add(lblStreet);
		
		JLabel lblNewLabel_5 = new JLabel("Number *: ");
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel_1, -319, SpringLayout.WEST, lblNewLabel_5);
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_5, 0, SpringLayout.NORTH, lblNewLabel_1);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_5, 0, SpringLayout.WEST, lblStreet);
		add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Postalcode *: ");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_6, 0, SpringLayout.NORTH, lblNewLabel_2);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_6, 0, SpringLayout.WEST, lblStreet);
		add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("City *: ");
		springLayout.putConstraint(SpringLayout.EAST, txtPhone, -54, SpringLayout.WEST, lblNewLabel_7);
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_7, 0, SpringLayout.NORTH, lblNewLabel_3);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_7, 0, SpringLayout.WEST, lblStreet);
		add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Country *: ");
		springLayout.putConstraint(SpringLayout.EAST, comboRole, -54, SpringLayout.WEST, lblNewLabel_8);
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_8, 0, SpringLayout.NORTH, lblNewLabel_4);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_8, 0, SpringLayout.WEST, lblStreet);
		add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Bus:");
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel_9, -197, SpringLayout.EAST, this);
		add(lblNewLabel_9);
		
		txtStreet = new JTextField();
		springLayout.putConstraint(SpringLayout.WEST, txtStreet, 48, SpringLayout.EAST, lblStreet);
		springLayout.putConstraint(SpringLayout.EAST, txtStreet, -97, SpringLayout.EAST, this);
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_9, 18, SpringLayout.SOUTH, txtStreet);
		springLayout.putConstraint(SpringLayout.NORTH, txtStreet, -3, SpringLayout.NORTH, lblNewLabel);
		springLayout.putConstraint(SpringLayout.SOUTH, txtStreet, 76, SpringLayout.NORTH, this);
		add(txtStreet);
		txtStreet.setColumns(10);
		
		txtNumber = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, txtNumber, -3, SpringLayout.NORTH, lblNewLabel_1);
		springLayout.putConstraint(SpringLayout.WEST, txtNumber, 41, SpringLayout.EAST, lblNewLabel_5);
		springLayout.putConstraint(SpringLayout.EAST, txtNumber, -22, SpringLayout.WEST, lblNewLabel_9);
		add(txtNumber);
		txtNumber.setColumns(10);
		
		txtBus = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, txtBus, 15, SpringLayout.SOUTH, txtStreet);
		springLayout.putConstraint(SpringLayout.WEST, txtBus, 24, SpringLayout.EAST, lblNewLabel_9);
		springLayout.putConstraint(SpringLayout.EAST, txtBus, -97, SpringLayout.EAST, this);
		add(txtBus);
		txtBus.setColumns(10);
		
		txtPostalCode = new JTextField();
		springLayout.putConstraint(SpringLayout.SOUTH, txtBus, -20, SpringLayout.NORTH, txtPostalCode);
		springLayout.putConstraint(SpringLayout.NORTH, txtPostalCode, -3, SpringLayout.NORTH, lblNewLabel_2);
		springLayout.putConstraint(SpringLayout.WEST, txtPostalCode, 0, SpringLayout.WEST, txtStreet);
		springLayout.putConstraint(SpringLayout.EAST, txtPostalCode, -97, SpringLayout.EAST, this);
		add(txtPostalCode);
		txtPostalCode.setColumns(10);
		
		txtCity = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, txtCity, -3, SpringLayout.NORTH, lblNewLabel_3);
		springLayout.putConstraint(SpringLayout.WEST, txtCity, 0, SpringLayout.WEST, txtStreet);
		springLayout.putConstraint(SpringLayout.EAST, txtCity, -97, SpringLayout.EAST, this);
		add(txtCity);
		txtCity.setColumns(10);
		
		txtCountry = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, btnTerug, 33, SpringLayout.SOUTH, txtCountry);
		springLayout.putConstraint(SpringLayout.WEST, txtCountry, 39, SpringLayout.EAST, lblNewLabel_8);
		springLayout.putConstraint(SpringLayout.EAST, txtCountry, -97, SpringLayout.EAST, this);
		springLayout.putConstraint(SpringLayout.NORTH, txtCountry, -3, SpringLayout.NORTH, lblNewLabel_4);
		add(txtCountry);
		txtCountry.setColumns(10);
		
		JButton btnEdit = new JButton("Edit");
		springLayout.putConstraint(SpringLayout.EAST, btnTerug, -82, SpringLayout.WEST, btnEdit);
		springLayout.putConstraint(SpringLayout.WEST, btnEdit, 649, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, btnEdit, -97, SpringLayout.EAST, this);
		springLayout.putConstraint(SpringLayout.NORTH, btnEdit, 33, SpringLayout.SOUTH, txtCountry);
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConfigurationController.editUser();
			}
		});
		add(btnEdit);
		
		txtAchternaam = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, txtAchternaam, -3, SpringLayout.NORTH, lblNewLabel_1);
		springLayout.putConstraint(SpringLayout.WEST, txtAchternaam, 0, SpringLayout.WEST, txtVoornaam);
		springLayout.putConstraint(SpringLayout.EAST, txtAchternaam, 0, SpringLayout.EAST, txtVoornaam);
		add(txtAchternaam);
		txtAchternaam.setColumns(10);
		
		JLabel lblNewPassword = new JLabel("New Password: ");
		springLayout.putConstraint(SpringLayout.WEST, lblNewPassword, 0, SpringLayout.WEST, lblNewLabel);
		add(lblNewPassword);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password: ");
		springLayout.putConstraint(SpringLayout.WEST, btnTerug, 311, SpringLayout.EAST, lblConfirmPassword);
		springLayout.putConstraint(SpringLayout.NORTH, lblNewPassword, -33, SpringLayout.NORTH, lblConfirmPassword);
		springLayout.putConstraint(SpringLayout.SOUTH, lblNewPassword, -19, SpringLayout.NORTH, lblConfirmPassword);
		springLayout.putConstraint(SpringLayout.NORTH, lblConfirmPassword, -55, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.WEST, lblConfirmPassword, 0, SpringLayout.WEST, lblNewLabel);
		springLayout.putConstraint(SpringLayout.SOUTH, lblConfirmPassword, -41, SpringLayout.SOUTH, this);
		add(lblConfirmPassword);
		
		txtPass1 = new JPasswordField();
		springLayout.putConstraint(SpringLayout.NORTH, txtPass1, -3, SpringLayout.NORTH, lblNewPassword);
		springLayout.putConstraint(SpringLayout.WEST, txtPass1, 0, SpringLayout.WEST, txtVoornaam);
		springLayout.putConstraint(SpringLayout.EAST, txtPass1, 0, SpringLayout.EAST, txtVoornaam);
		add(txtPass1);
		
		txtPass2 = new JPasswordField();
		springLayout.putConstraint(SpringLayout.NORTH, txtPass2, -3, SpringLayout.NORTH, lblConfirmPassword);
		springLayout.putConstraint(SpringLayout.WEST, txtPass2, 0, SpringLayout.WEST, txtVoornaam);
		springLayout.putConstraint(SpringLayout.EAST, txtPass2, 0, SpringLayout.EAST, txtVoornaam);
		add(txtPass2);
		
		JLabel lblifPasswordIs = new JLabel("*if password is left empty it will not be edited");
		springLayout.putConstraint(SpringLayout.NORTH, lblifPasswordIs, 5, SpringLayout.NORTH, lblEditUser);
		springLayout.putConstraint(SpringLayout.WEST, lblifPasswordIs, 18, SpringLayout.EAST, lblEditUser);
		add(lblifPasswordIs);

	}
	public ArrayList<JTextField> getTextFields() {
		ArrayList<JTextField> array = new ArrayList<JTextField>();
		array.add(txtVoornaam);
		array.add(txtAchternaam);
		array.add(txtEmail);
		array.add(txtPhone);
		array.add(txtStreet);
		array.add(txtNumber);
		array.add(txtCountry);
		array.add(txtPostalCode);
		array.add(txtCity);
		
		return array;
	}
}
