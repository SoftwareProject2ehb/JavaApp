package view;

import javax.swing.JPanel;
import javax.swing.SpringLayout;

import controller.SystemController;

import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class SelectStationView extends JPanel{
	public SelectStationView() {
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		
		JComboBox comboBox = new JComboBox();
		springLayout.putConstraint(SpringLayout.NORTH, comboBox, 116, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, comboBox, 10, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, comboBox, 269, SpringLayout.WEST, this);
		comboBox.setModel(new DefaultComboBoxModel(SystemController.getStations()));
		add(comboBox);
		
		JLabel lblNewLabel = new JLabel("Choose the station where this system is used");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel, -33, SpringLayout.NORTH, comboBox);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel, 0, SpringLayout.WEST, comboBox);
		springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel, -6, SpringLayout.NORTH, comboBox);
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel, -198, SpringLayout.EAST, comboBox);
		add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Set system station");
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton, 6, SpringLayout.SOUTH, comboBox);
		springLayout.putConstraint(SpringLayout.EAST, btnNewButton, 0, SpringLayout.EAST, comboBox);
		add(btnNewButton);
	}
}
