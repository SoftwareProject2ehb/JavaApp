package view;

import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class ChangeLanguageView extends JPanel{
	public ChangeLanguageView() {
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		
		JLabel lblNewLabel = new JLabel("Edit system language");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel, 10, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel, 10, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel, 35, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel, 236, SpringLayout.WEST, this);
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		springLayout.putConstraint(SpringLayout.NORTH, comboBox, 31, SpringLayout.SOUTH, lblNewLabel);
		springLayout.putConstraint(SpringLayout.WEST, comboBox, 0, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, comboBox, -10, SpringLayout.EAST, lblNewLabel);
		add(comboBox);
		
		JButton btnNewButton = new JButton("Confirm");
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton, 6, SpringLayout.SOUTH, comboBox);
		springLayout.putConstraint(SpringLayout.EAST, btnNewButton, 0, SpringLayout.EAST, comboBox);
		add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Choose language");
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_1, 0, SpringLayout.WEST, lblNewLabel);
		springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel_1, -6, SpringLayout.NORTH, comboBox);
		add(lblNewLabel_1);
	}
}
