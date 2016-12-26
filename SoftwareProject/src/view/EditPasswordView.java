package view;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import controller.ActionMenuController;
import controller.ConfigurationController;
import utilities.Language;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class EditPasswordView extends JPanel {
	public JPasswordField txtPass1;
	public JPasswordField txtPass2;

	/**
	 * Create the panel.
	 */
	public EditPasswordView() {
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		
		JLabel lblNewLabel = new JLabel(Language.getString("password") + "*");
		springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel, -152, SpringLayout.SOUTH, this);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel(Language.getString("confirmpassword") + "*");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 177, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel, 0, SpringLayout.WEST, lblNewLabel_1);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_1, 73, SpringLayout.WEST, this);
		add(lblNewLabel_1);
		
		JLabel lblChangeYourDefault = new JLabel(Language.getString("newpassword"));
		springLayout.putConstraint(SpringLayout.WEST, lblChangeYourDefault, 102, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, lblChangeYourDefault, -55, SpringLayout.NORTH, lblNewLabel);
		lblChangeYourDefault.setFont(new Font("Tahoma", Font.PLAIN, 17));
		add(lblChangeYourDefault);
		
		JButton btnNewButton = new JButton(Language.getString("change"));
		springLayout.putConstraint(SpringLayout.EAST, btnNewButton, -75, SpringLayout.EAST, this);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ConfigurationController.editDefaultPassword();
			}
		});
		springLayout.putConstraint(SpringLayout.SOUTH, btnNewButton, -39, SpringLayout.SOUTH, this);
		add(btnNewButton);
		
		txtPass1 = new JPasswordField();
		springLayout.putConstraint(SpringLayout.NORTH, txtPass1, -3, SpringLayout.NORTH, lblNewLabel);
		springLayout.putConstraint(SpringLayout.EAST, txtPass1, 0, SpringLayout.EAST, btnNewButton);
		add(txtPass1);
		
		txtPass2 = new JPasswordField();
		springLayout.putConstraint(SpringLayout.WEST, txtPass2, 51, SpringLayout.EAST, lblNewLabel_1);
		springLayout.putConstraint(SpringLayout.EAST, txtPass2, -75, SpringLayout.EAST, this);
		springLayout.putConstraint(SpringLayout.WEST, txtPass1, 0, SpringLayout.WEST, txtPass2);
		springLayout.putConstraint(SpringLayout.NORTH, txtPass2, -3, SpringLayout.NORTH, lblNewLabel_1);
		add(txtPass2);
		
		JButton btnCancel = new JButton(Language.getString("cancel"));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ActionMenuController.switchToActionMenuView();
			}
		});
		springLayout.putConstraint(SpringLayout.WEST, btnCancel, 0, SpringLayout.WEST, lblNewLabel);
		springLayout.putConstraint(SpringLayout.SOUTH, btnCancel, 0, SpringLayout.SOUTH, btnNewButton);
		add(btnCancel);
		
	}
}
