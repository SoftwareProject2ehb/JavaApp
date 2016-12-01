package view;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JButton;

public class EditPasswordView extends JPanel {
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the panel.
	 */
	public EditPasswordView() {
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		
		textField = new JTextField();
		springLayout.putConstraint(SpringLayout.SOUTH, textField, -183, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.EAST, textField, -105, SpringLayout.EAST, this);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, textField_1, 34, SpringLayout.SOUTH, textField);
		springLayout.putConstraint(SpringLayout.EAST, textField_1, -105, SpringLayout.EAST, this);
		add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("New Password");
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel, -282, SpringLayout.EAST, this);
		springLayout.putConstraint(SpringLayout.WEST, textField, 63, SpringLayout.EAST, lblNewLabel);
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel, 3, SpringLayout.NORTH, textField);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Confirm Password");
		springLayout.putConstraint(SpringLayout.WEST, textField_1, 47, SpringLayout.EAST, lblNewLabel_1);
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 3, SpringLayout.NORTH, textField_1);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_1, 0, SpringLayout.WEST, lblNewLabel);
		add(lblNewLabel_1);
		
		JButton btnChange = new JButton("Change");
		springLayout.putConstraint(SpringLayout.NORTH, btnChange, 46, SpringLayout.SOUTH, textField_1);
		springLayout.putConstraint(SpringLayout.WEST, btnChange, 151, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, btnChange, -60, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.EAST, btnChange, -161, SpringLayout.EAST, this);
		add(btnChange);
		
	}

}
