package view;

import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;

import controller.ConfigurationController;
import utilities.Language;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class CreateUserView extends JPanel {
	public JTextField txtVoornaam;
	public JTextField txtAchternaam;
	public JTextField txtEmail;
	public JTextField txtPhone;
	public JTextField txtStreet;
	public JTextField txtBus;
	public JTextField txtNumber;
	public JTextField txtCountry;
	public JTextField txtPostalCode;
	public JTextField txtCity;
	public JComboBox role;
	/**
	 * Create the panel.
	 */
	public CreateUserView() {
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		
		JLabel lblCreateUser = new JLabel(Language.getString("usertitle"));
		springLayout.putConstraint(SpringLayout.NORTH, lblCreateUser, 10, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, lblCreateUser, 32, SpringLayout.WEST, this);
		lblCreateUser.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(lblCreateUser);
		
		JLabel lblNewLabel = new JLabel(Language.getString("firstname") + "*");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel, 31, SpringLayout.SOUTH, lblCreateUser);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel, 69, SpringLayout.WEST, this);
		add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel(Language.getString("email") + "*");
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_2, 0, SpringLayout.WEST, lblNewLabel);
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel_2, -727, SpringLayout.EAST, this);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel(Language.getString("telephone") + "*");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_3, 21, SpringLayout.SOUTH, lblNewLabel_2);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_3, 0, SpringLayout.WEST, lblNewLabel);
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel_3, 37, SpringLayout.EAST, lblCreateUser);
		add(lblNewLabel_3);
		
		JLabel lblNewLabel_5 = new JLabel(Language.getString("role"));
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_5, 28, SpringLayout.SOUTH, lblNewLabel_3);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_5, 0, SpringLayout.WEST, lblNewLabel);
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel_5, -657, SpringLayout.EAST, this);
		add(lblNewLabel_5);
		
		txtVoornaam = new JTextField();
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel, -1, SpringLayout.WEST, txtVoornaam);
		springLayout.putConstraint(SpringLayout.WEST, txtVoornaam, 194, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, txtVoornaam, 399, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.NORTH, txtVoornaam, 60, SpringLayout.NORTH, this);
		add(txtVoornaam);
		txtVoornaam.setColumns(10);
		
		txtAchternaam = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, txtAchternaam, 19, SpringLayout.SOUTH, txtVoornaam);
		add(txtAchternaam);
		txtAchternaam.setColumns(10);
		
		txtEmail = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, txtEmail, -3, SpringLayout.NORTH, lblNewLabel_2);
		springLayout.putConstraint(SpringLayout.WEST, txtEmail, 0, SpringLayout.WEST, txtVoornaam);
		springLayout.putConstraint(SpringLayout.EAST, txtEmail, 0, SpringLayout.EAST, txtVoornaam);
		add(txtEmail);
		txtEmail.setColumns(10);
		
		txtPhone = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, txtPhone, -3, SpringLayout.NORTH, lblNewLabel_3);
		springLayout.putConstraint(SpringLayout.WEST, txtPhone, 0, SpringLayout.WEST, txtVoornaam);
		springLayout.putConstraint(SpringLayout.EAST, txtPhone, 0, SpringLayout.EAST, txtVoornaam);
		txtPhone.setColumns(10);
		add(txtPhone);
		
		JButton btnBack = new JButton("Terug");
		springLayout.putConstraint(SpringLayout.NORTH, btnBack, 37, SpringLayout.SOUTH, lblNewLabel_5);
		springLayout.putConstraint(SpringLayout.WEST, btnBack, 69, SpringLayout.WEST, this);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConfigurationController.switchToFindUserView();
			}
		});
		add(btnBack);
		
		role = new JComboBox();
		springLayout.putConstraint(SpringLayout.NORTH, role, -3, SpringLayout.NORTH, lblNewLabel_5);
		springLayout.putConstraint(SpringLayout.WEST, role, 0, SpringLayout.WEST, txtVoornaam);
		springLayout.putConstraint(SpringLayout.EAST, role, 206, SpringLayout.EAST, lblNewLabel_5);
		role.addItem(Language.getString("user"));
		role.addItem(Language.getString("admin"));
		add(role);
		
		JButton btnCreate = new JButton(Language.getString("create"));
		springLayout.putConstraint(SpringLayout.WEST, btnCreate, 650, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, btnCreate, -100, SpringLayout.EAST, this);
		springLayout.putConstraint(SpringLayout.EAST, btnBack, -505, SpringLayout.WEST, btnCreate);
		springLayout.putConstraint(SpringLayout.NORTH, btnCreate, 0, SpringLayout.NORTH, btnBack);
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConfigurationController.createUser();
				
			}
		});
		add(btnCreate);
		
		JLabel lblStreet = new JLabel(Language.getString("street") + "*");
		springLayout.putConstraint(SpringLayout.NORTH, lblStreet, 0, SpringLayout.NORTH, lblNewLabel);
		springLayout.putConstraint(SpringLayout.WEST, lblStreet, 34, SpringLayout.EAST, txtVoornaam);
		add(lblStreet);
		
		JLabel lblNewLabel_4 = new JLabel(Language.getString("housenumber") + "*");
		springLayout.putConstraint(SpringLayout.WEST, txtAchternaam, -239, SpringLayout.WEST, lblNewLabel_4);
		springLayout.putConstraint(SpringLayout.EAST, txtAchternaam, -34, SpringLayout.WEST, lblNewLabel_4);
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_4, 25, SpringLayout.SOUTH, lblStreet);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_4, 0, SpringLayout.WEST, lblStreet);
		add(lblNewLabel_4);
		
		JLabel lblNewLabel_7 = new JLabel(Language.getString("zip") + "*");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_7, 0, SpringLayout.NORTH, lblNewLabel_2);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_7, 0, SpringLayout.WEST, lblStreet);
		add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel(Language.getString("city") + "*");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_8, 21, SpringLayout.SOUTH, lblNewLabel_7);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_8, 0, SpringLayout.WEST, lblStreet);
		add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel(Language.getString("country") + "*");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_9, 0, SpringLayout.NORTH, lblNewLabel_5);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_9, 0, SpringLayout.WEST, lblStreet);
		add(lblNewLabel_9);
		
		txtStreet = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, txtStreet, 60, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, txtStreet, 75, SpringLayout.EAST, lblStreet);
		springLayout.putConstraint(SpringLayout.EAST, txtStreet, -100, SpringLayout.EAST, this);
		add(txtStreet);
		txtStreet.setColumns(10);
		
		txtBus = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, txtBus, 19, SpringLayout.SOUTH, txtStreet);
		springLayout.putConstraint(SpringLayout.EAST, txtBus, 0, SpringLayout.EAST, btnCreate);
		add(txtBus);
		txtBus.setColumns(10);
		
		txtNumber = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, txtNumber, 98, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.SOUTH, txtStreet, -18, SpringLayout.NORTH, txtNumber);
		springLayout.putConstraint(SpringLayout.WEST, txtNumber, 0, SpringLayout.WEST, txtStreet);
		springLayout.putConstraint(SpringLayout.EAST, txtNumber, -240, SpringLayout.EAST, this);
		add(txtNumber);
		txtNumber.setColumns(10);
		
		txtCountry = new JTextField();
		springLayout.putConstraint(SpringLayout.WEST, txtCountry, 0, SpringLayout.WEST, txtStreet);
		springLayout.putConstraint(SpringLayout.EAST, txtCountry, -100, SpringLayout.EAST, this);
		add(txtCountry);
		txtCountry.setColumns(10);
		
		txtPostalCode = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, txtPostalCode, 134, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.SOUTH, txtBus, -15, SpringLayout.NORTH, txtPostalCode);
		springLayout.putConstraint(SpringLayout.WEST, txtPostalCode, 0, SpringLayout.WEST, txtStreet);
		springLayout.putConstraint(SpringLayout.EAST, txtPostalCode, -100, SpringLayout.EAST, this);
		add(txtPostalCode);
		txtPostalCode.setColumns(10);
		
		txtCity = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, txtCountry, 22, SpringLayout.SOUTH, txtCity);
		springLayout.putConstraint(SpringLayout.NORTH, txtCity, 15, SpringLayout.SOUTH, txtPostalCode);
		springLayout.putConstraint(SpringLayout.WEST, txtCity, 0, SpringLayout.WEST, txtStreet);
		springLayout.putConstraint(SpringLayout.EAST, txtCity, -100, SpringLayout.EAST, this);
		add(txtCity);
		txtCity.setColumns(10);
		
		JLabel lblAchternaam = new JLabel(Language.getString("lastname") + "*");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_2, 22, SpringLayout.SOUTH, lblAchternaam);
		springLayout.putConstraint(SpringLayout.NORTH, lblAchternaam, 24, SpringLayout.SOUTH, lblNewLabel);
		springLayout.putConstraint(SpringLayout.WEST, lblAchternaam, 0, SpringLayout.WEST, lblNewLabel);
		add(lblAchternaam);
		
		JLabel lblBus = new JLabel(Language.getString("bus") + "*");
		springLayout.putConstraint(SpringLayout.WEST, txtBus, 26, SpringLayout.EAST, lblBus);
		springLayout.putConstraint(SpringLayout.NORTH, lblBus, 22, SpringLayout.SOUTH, txtStreet);
		springLayout.putConstraint(SpringLayout.WEST, lblBus, 18, SpringLayout.EAST, txtNumber);
		add(lblBus);
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
		array.add(txtCity);
		
		return array;
	}
}
