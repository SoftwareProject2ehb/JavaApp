package view;

import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.SwingConstants;

import controller.ConfigurationController;
import data_control.UserDAO;
import model.User;
import model.User.Role;
import utilities.Encryptor;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CreateUserView extends JPanel {
	public JTextField txtVoornaam;
	public JTextField txtAchternaam;
	public JTextField txtEmail;
	public JTextField txtPhone;
	public JPasswordField txtPassword;
	public JPasswordField txtPassword1;
	public JComboBox role;

	/**
	 * Create the panel.
	 */
	public CreateUserView() {
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		
		JLabel lblCreateUser = new JLabel("Create User");
		springLayout.putConstraint(SpringLayout.NORTH, lblCreateUser, 11, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, lblCreateUser, 10, SpringLayout.WEST, this);
		lblCreateUser.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(lblCreateUser);
		
		JLabel lblNewLabel = new JLabel("Voornaam: ");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel, 43, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel, 24, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel, 148, SpringLayout.WEST, this);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Achternaam: ");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 74, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_1, 24, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel_1, 148, SpringLayout.WEST, this);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Email: ");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_2, 105, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_2, 24, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel_2, 148, SpringLayout.WEST, this);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Telefoon Nr.: ");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_3, 136, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_3, 24, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel_3, 150, SpringLayout.WEST, this);
		add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Wachtwoord:");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_4, 167, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_4, 24, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel_4, 148, SpringLayout.WEST, this);
		add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Functie:");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_5, 227, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_5, 24, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel_5, 148, SpringLayout.WEST, this);
		add(lblNewLabel_5);
		
		txtVoornaam = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, txtVoornaam, 40, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, txtVoornaam, 212, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, txtVoornaam, 348, SpringLayout.WEST, this);
		add(txtVoornaam);
		txtVoornaam.setColumns(10);
		
		txtAchternaam = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, txtAchternaam, 71, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, txtAchternaam, 212, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, txtAchternaam, 348, SpringLayout.WEST, this);
		add(txtAchternaam);
		txtAchternaam.setColumns(10);
		
		txtEmail = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, txtEmail, 102, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, txtEmail, 212, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, txtEmail, 348, SpringLayout.WEST, this);
		add(txtEmail);
		txtEmail.setColumns(10);
		
		txtPhone = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, txtPhone, 133, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, txtPhone, 212, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, txtPhone, 348, SpringLayout.WEST, this);
		txtPhone.setColumns(10);
		add(txtPhone);
		
		JButton btnBack = new JButton("Terug naar Menu");
		springLayout.putConstraint(SpringLayout.EAST, btnBack, 0, SpringLayout.EAST, lblNewLabel);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConfigurationController.switchToFindUserView();
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, btnBack, 253, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, btnBack, 25, SpringLayout.WEST, this);
		add(btnBack);
		
		
		
		txtPassword = new JPasswordField();
		springLayout.putConstraint(SpringLayout.NORTH, txtPassword, 164, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, txtPassword, 212, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, txtPassword, 348, SpringLayout.WEST, this);
		add(txtPassword);
		
		txtPassword1 = new JPasswordField();
		springLayout.putConstraint(SpringLayout.NORTH, txtPassword1, 196, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, txtPassword1, 212, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, txtPassword1, 348, SpringLayout.WEST, this);
		add(txtPassword1);
		
		JLabel lblConfirmPassword = new JLabel("Bevestig wachtwoord:");
		springLayout.putConstraint(SpringLayout.NORTH, lblConfirmPassword, 202, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, lblConfirmPassword, 24, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, lblConfirmPassword, 148, SpringLayout.WEST, this);
		lblConfirmPassword.setHorizontalAlignment(SwingConstants.LEFT);
		add(lblConfirmPassword);
		
		role = new JComboBox();
		springLayout.putConstraint(SpringLayout.NORTH, role, 227, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, role, 212, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, role, 348, SpringLayout.WEST, this);
		role.addItem("USER");
		role.addItem("ADMIN");
		add(role);
		
		JButton btnCreate = new JButton("Maak gebruiker");
		springLayout.putConstraint(SpringLayout.NORTH, btnCreate, 253, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, btnCreate, 10, SpringLayout.WEST, role);
		springLayout.putConstraint(SpringLayout.EAST, btnCreate, 348, SpringLayout.WEST, this);
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConfigurationController.createUser();
			}
		});
		add(btnCreate);
	}
}
