package view;

import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CreateSubView extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public CreateSubView() {
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		
		JLabel lblChooseType = new JLabel("Choose Type");
		springLayout.putConstraint(SpringLayout.WEST, lblChooseType, 10, SpringLayout.WEST, this);
		add(lblChooseType);
		
		JComboBox comboBox = new JComboBox();
		springLayout.putConstraint(SpringLayout.NORTH, lblChooseType, 4, SpringLayout.NORTH, comboBox);
		springLayout.putConstraint(SpringLayout.NORTH, comboBox, 35, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, comboBox, 107, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, comboBox, -334, SpringLayout.EAST, this);
		add(comboBox);
		
		JLabel lblStartdate = new JLabel("Startdate");
		springLayout.putConstraint(SpringLayout.NORTH, lblStartdate, 28, SpringLayout.SOUTH, lblChooseType);
		springLayout.putConstraint(SpringLayout.WEST, lblStartdate, 0, SpringLayout.WEST, lblChooseType);
		add(lblStartdate);
		
		textField = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, textField, -5, SpringLayout.NORTH, lblStartdate);
		springLayout.putConstraint(SpringLayout.WEST, textField, 39, SpringLayout.EAST, lblStartdate);
		textField.setToolTipText("yyyy/mm/dd");
		add(textField);
		textField.setColumns(10);
		
		JLabel lblMonths = new JLabel("# Months");
		springLayout.putConstraint(SpringLayout.NORTH, lblMonths, 35, SpringLayout.SOUTH, lblStartdate);
		springLayout.putConstraint(SpringLayout.WEST, lblMonths, 10, SpringLayout.WEST, this);
		add(lblMonths);
		
		JComboBox comboBox_1 = new JComboBox();
		springLayout.putConstraint(SpringLayout.NORTH, comboBox_1, -4, SpringLayout.NORTH, lblMonths);
		springLayout.putConstraint(SpringLayout.WEST, comboBox_1, 0, SpringLayout.WEST, comboBox);
		springLayout.putConstraint(SpringLayout.EAST, comboBox_1, 108, SpringLayout.EAST, lblMonths);
		add(comboBox_1);
		
		JLabel lblStartstation = new JLabel("Startstation");
		springLayout.putConstraint(SpringLayout.NORTH, lblStartstation, 0, SpringLayout.NORTH, lblChooseType);
		springLayout.putConstraint(SpringLayout.WEST, lblStartstation, 38, SpringLayout.EAST, comboBox);
		add(lblStartstation);
		
		textField_1 = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, textField_1, -5, SpringLayout.NORTH, lblChooseType);
		springLayout.putConstraint(SpringLayout.WEST, textField_1, 6, SpringLayout.EAST, lblStartstation);
		add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblEndstation = new JLabel("Endstation");
		springLayout.putConstraint(SpringLayout.NORTH, lblEndstation, 28, SpringLayout.SOUTH, lblStartstation);
		springLayout.putConstraint(SpringLayout.WEST, lblEndstation, 0, SpringLayout.WEST, lblStartstation);
		add(lblEndstation);
		
		textField_2 = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, textField_2, 18, SpringLayout.SOUTH, textField_1);
		springLayout.putConstraint(SpringLayout.WEST, textField_2, 0, SpringLayout.WEST, textField_1);
		add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblPreview = new JLabel("Preview:");
		springLayout.putConstraint(SpringLayout.NORTH, lblPreview, 32, SpringLayout.SOUTH, lblMonths);
		springLayout.putConstraint(SpringLayout.WEST, lblPreview, 10, SpringLayout.WEST, this);
		add(lblPreview);
		
		table = new JTable();
		springLayout.putConstraint(SpringLayout.NORTH, table, -134, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.WEST, table, 10, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, table, -94, SpringLayout.SOUTH, this);
		add(table);
		
		JButton btnCancel = new JButton("Cancel");
		springLayout.putConstraint(SpringLayout.WEST, btnCancel, 10, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, btnCancel, -10, SpringLayout.SOUTH, this);
		add(btnCancel);
		
		JButton btnNewButton = new JButton("Accept");
		springLayout.putConstraint(SpringLayout.EAST, table, 0, SpringLayout.EAST, btnNewButton);
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton, -106, SpringLayout.EAST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, btnNewButton, -10, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.EAST, btnNewButton, -10, SpringLayout.EAST, this);
		add(btnNewButton);

	}
}
