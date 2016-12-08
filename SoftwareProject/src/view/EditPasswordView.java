package view;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import controller.ConfigurationController;

import com.jgoodies.forms.layout.FormSpecs;
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
		
		JLabel lblNewLabel = new JLabel("Password *:");
		springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel, -152, SpringLayout.SOUTH, this);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Confirm Password *:");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 177, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel, 0, SpringLayout.WEST, lblNewLabel_1);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_1, 73, SpringLayout.WEST, this);
		add(lblNewLabel_1);
		
		JLabel lblChangeYourDefault = new JLabel("New password for your account");
		springLayout.putConstraint(SpringLayout.WEST, lblChangeYourDefault, 102, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, lblChangeYourDefault, -55, SpringLayout.NORTH, lblNewLabel);
		lblChangeYourDefault.setFont(new Font("Tahoma", Font.PLAIN, 17));
		add(lblChangeYourDefault);
		
		JButton btnNewButton = new JButton("Change");
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
		
	}
}
