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
import java.awt.event.ActionEvent;

public class EditUserView extends JPanel {
	public JTextField txtVoornaam;
	public JTextField txtAchternaam;
	public JTextField txtEmail;
	public JTextField txtPhone;
	public JComboBox comboRole;

	/**
	 * Create the panel.
	 */
	public EditUserView() {
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		
		JLabel lblEditUser = new JLabel("Edit User");
		springLayout.putConstraint(SpringLayout.NORTH, lblEditUser, 10, SpringLayout.NORTH, this);
		lblEditUser.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(lblEditUser);
		
		JLabel lblNewLabel = new JLabel("Voornaam");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel, 27, SpringLayout.SOUTH, lblEditUser);
		springLayout.putConstraint(SpringLayout.EAST, lblEditUser, 0, SpringLayout.EAST, lblNewLabel);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Achternaam");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 21, SpringLayout.SOUTH, lblNewLabel);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_1, 49, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel, 0, SpringLayout.WEST, lblNewLabel_1);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Email");
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_2, 0, SpringLayout.WEST, lblNewLabel);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Telefoon Nr.");
		springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel_2, -21, SpringLayout.NORTH, lblNewLabel_3);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_3, 0, SpringLayout.WEST, lblNewLabel);
		add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Role");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_4, 204, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel_3, -21, SpringLayout.NORTH, lblNewLabel_4);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_4, 0, SpringLayout.WEST, lblNewLabel);
		add(lblNewLabel_4);
		
		txtVoornaam = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, txtVoornaam, -3, SpringLayout.NORTH, lblNewLabel);
		springLayout.putConstraint(SpringLayout.WEST, txtVoornaam, 137, SpringLayout.EAST, lblNewLabel);
		add(txtVoornaam);
		txtVoornaam.setColumns(10);
		
		txtAchternaam = new JTextField();
		springLayout.putConstraint(SpringLayout.EAST, txtVoornaam, 0, SpringLayout.EAST, txtAchternaam);
		springLayout.putConstraint(SpringLayout.NORTH, txtAchternaam, -3, SpringLayout.NORTH, lblNewLabel_1);
		springLayout.putConstraint(SpringLayout.WEST, txtAchternaam, 127, SpringLayout.EAST, lblNewLabel_1);
		add(txtAchternaam);
		txtAchternaam.setColumns(10);
		
		txtEmail = new JTextField();
		springLayout.putConstraint(SpringLayout.WEST, txtEmail, 161, SpringLayout.EAST, lblNewLabel_2);
		springLayout.putConstraint(SpringLayout.EAST, txtEmail, -61, SpringLayout.EAST, this);
		springLayout.putConstraint(SpringLayout.EAST, txtAchternaam, 0, SpringLayout.EAST, txtEmail);
		springLayout.putConstraint(SpringLayout.NORTH, txtEmail, -3, SpringLayout.NORTH, lblNewLabel_2);
		add(txtEmail);
		txtEmail.setColumns(10);
		
		txtPhone = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, txtPhone, -3, SpringLayout.NORTH, lblNewLabel_3);
		springLayout.putConstraint(SpringLayout.WEST, txtPhone, 125, SpringLayout.EAST, lblNewLabel_3);
		springLayout.putConstraint(SpringLayout.EAST, txtPhone, 0, SpringLayout.EAST, txtVoornaam);
		add(txtPhone);
		txtPhone.setColumns(10);
		
		comboRole = new JComboBox();
		springLayout.putConstraint(SpringLayout.NORTH, comboRole, -3, SpringLayout.NORTH, lblNewLabel_4);
		springLayout.putConstraint(SpringLayout.WEST, comboRole, 164, SpringLayout.EAST, lblNewLabel_4);
		springLayout.putConstraint(SpringLayout.EAST, comboRole, 0, SpringLayout.EAST, txtVoornaam);
		comboRole.addItem("USER");
		comboRole.addItem("ADMIN");
		add(comboRole);
		
		
		JButton btnTerug = new JButton("Terug");
		springLayout.putConstraint(SpringLayout.WEST, btnTerug, 0, SpringLayout.WEST, lblNewLabel);
		springLayout.putConstraint(SpringLayout.SOUTH, btnTerug, -22, SpringLayout.SOUTH, this);
		btnTerug.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConfigurationController.switchToFindUserView();
			}
		});
		add(btnTerug);
		
		JButton btnEdit = new JButton("Edit");
		springLayout.putConstraint(SpringLayout.NORTH, btnEdit, 0, SpringLayout.NORTH, btnTerug);
		springLayout.putConstraint(SpringLayout.WEST, btnEdit, 178, SpringLayout.EAST, btnTerug);
		springLayout.putConstraint(SpringLayout.EAST, btnEdit, 0, SpringLayout.EAST, txtVoornaam);
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConfigurationController.editUser();
			}
		});
		add(btnEdit);

	}
}
