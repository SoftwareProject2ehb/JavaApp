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

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CreateUserView extends JPanel {
	public JTextField txtVoornaam;
	public JTextField txtAchternaam;
	public JTextField txtEmail;
	public JTextField txtPhone;
	public JComboBox role;

	/**
	 * Create the panel.
	 */
	public CreateUserView() {
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		
		JLabel lblCreateUser = new JLabel("Create User");
		springLayout.putConstraint(SpringLayout.NORTH, lblCreateUser, 10, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, lblCreateUser, 32, SpringLayout.WEST, this);
		lblCreateUser.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(lblCreateUser);
		
		JLabel lblNewLabel = new JLabel("Voornaam: ");
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel, 175, SpringLayout.WEST, this);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Achternaam: ");
		springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel, -25, SpringLayout.NORTH, lblNewLabel_1);
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel_1, -255, SpringLayout.EAST, this);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel, 0, SpringLayout.WEST, lblNewLabel_1);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Email: ");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_2, 136, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel_1, -20, SpringLayout.NORTH, lblNewLabel_2);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_2, 51, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_1, 0, SpringLayout.WEST, lblNewLabel_2);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Telefoon Nr.: ");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_3, 21, SpringLayout.SOUTH, lblNewLabel_2);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_3, 51, SpringLayout.WEST, this);
		add(lblNewLabel_3);
		
		JLabel lblNewLabel_5 = new JLabel("Role: ");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_5, 28, SpringLayout.SOUTH, lblNewLabel_3);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_5, 51, SpringLayout.WEST, this);
		add(lblNewLabel_5);
		
		txtVoornaam = new JTextField();
		springLayout.putConstraint(SpringLayout.EAST, txtVoornaam, -50, SpringLayout.EAST, this);
		add(txtVoornaam);
		txtVoornaam.setColumns(10);
		
		txtAchternaam = new JTextField();
		springLayout.putConstraint(SpringLayout.WEST, txtVoornaam, 0, SpringLayout.WEST, txtAchternaam);
		springLayout.putConstraint(SpringLayout.SOUTH, txtVoornaam, -19, SpringLayout.NORTH, txtAchternaam);
		springLayout.putConstraint(SpringLayout.EAST, txtAchternaam, -50, SpringLayout.EAST, this);
		add(txtAchternaam);
		txtAchternaam.setColumns(10);
		
		txtEmail = new JTextField();
		springLayout.putConstraint(SpringLayout.WEST, txtAchternaam, 0, SpringLayout.WEST, txtEmail);
		springLayout.putConstraint(SpringLayout.SOUTH, txtAchternaam, -14, SpringLayout.NORTH, txtEmail);
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel_2, -71, SpringLayout.WEST, txtEmail);
		springLayout.putConstraint(SpringLayout.EAST, txtEmail, -50, SpringLayout.EAST, this);
		springLayout.putConstraint(SpringLayout.NORTH, txtEmail, 133, SpringLayout.NORTH, this);
		add(txtEmail);
		txtEmail.setColumns(10);
		
		txtPhone = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, txtPhone, 15, SpringLayout.SOUTH, txtEmail);
		springLayout.putConstraint(SpringLayout.WEST, txtEmail, 0, SpringLayout.WEST, txtPhone);
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel_3, -69, SpringLayout.WEST, txtPhone);
		springLayout.putConstraint(SpringLayout.EAST, txtPhone, -50, SpringLayout.EAST, this);
		txtPhone.setColumns(10);
		add(txtPhone);
		
		JButton btnBack = new JButton("Terug");
		springLayout.putConstraint(SpringLayout.NORTH, btnBack, 26, SpringLayout.SOUTH, lblNewLabel_5);
		springLayout.putConstraint(SpringLayout.WEST, btnBack, 0, SpringLayout.WEST, lblNewLabel);
		springLayout.putConstraint(SpringLayout.EAST, btnBack, 127, SpringLayout.WEST, this);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConfigurationController.switchToFindUserView();
			}
		});
		add(btnBack);
		
		role = new JComboBox();
		springLayout.putConstraint(SpringLayout.NORTH, role, 22, SpringLayout.SOUTH, txtPhone);
		springLayout.putConstraint(SpringLayout.WEST, txtPhone, 0, SpringLayout.WEST, role);
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel_5, -71, SpringLayout.WEST, role);
		springLayout.putConstraint(SpringLayout.WEST, role, 246, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, role, -50, SpringLayout.EAST, this);
		role.addItem("USER");
		role.addItem("ADMIN");
		add(role);
		
		JButton btnCreate = new JButton("Create");
		springLayout.putConstraint(SpringLayout.NORTH, btnCreate, 23, SpringLayout.SOUTH, role);
		springLayout.putConstraint(SpringLayout.WEST, btnCreate, 171, SpringLayout.EAST, btnBack);
		springLayout.putConstraint(SpringLayout.EAST, btnCreate, -50, SpringLayout.EAST, this);
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConfigurationController.createUser();
				
			}
		});
		add(btnCreate);
	}
}
