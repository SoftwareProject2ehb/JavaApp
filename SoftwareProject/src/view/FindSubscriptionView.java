package view;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SpringLayout;

import controller.ActionMenuController;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FindSubscriptionView extends JPanel {
	private JTable table;
	private JTextField textField;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Create the panel.
	 */
	public FindSubscriptionView() {
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		
		table = new JTable();
		springLayout.putConstraint(SpringLayout.NORTH, table, 10, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, table, 10, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, table, 147, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.EAST, table, 589, SpringLayout.WEST, this);
		add(table);
		
		textField = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, textField, 23, SpringLayout.SOUTH, table);
		springLayout.putConstraint(SpringLayout.WEST, textField, 10, SpringLayout.WEST, this);
		add(textField);
		textField.setColumns(10);
		
		JRadioButton rdbtnSearchById = new JRadioButton("Search by id");
		buttonGroup.add(rdbtnSearchById);
		springLayout.putConstraint(SpringLayout.NORTH, rdbtnSearchById, 8, SpringLayout.SOUTH, textField);
		springLayout.putConstraint(SpringLayout.WEST, rdbtnSearchById, 0, SpringLayout.WEST, table);
		add(rdbtnSearchById);
		
		JRadioButton rdbtnSearchByCustomer = new JRadioButton("Search by Customer id");
		buttonGroup.add(rdbtnSearchByCustomer);
		springLayout.putConstraint(SpringLayout.NORTH, rdbtnSearchByCustomer, 6, SpringLayout.SOUTH, rdbtnSearchById);
		springLayout.putConstraint(SpringLayout.WEST, rdbtnSearchByCustomer, 0, SpringLayout.WEST, table);
		add(rdbtnSearchByCustomer);
		
		JButton btnFind = new JButton("Find");
		springLayout.putConstraint(SpringLayout.NORTH, btnFind, 6, SpringLayout.SOUTH, rdbtnSearchByCustomer);
		springLayout.putConstraint(SpringLayout.WEST, btnFind, 0, SpringLayout.WEST, table);
		add(btnFind);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ActionMenuController.switchToActionMenuView();
			}
		});
		springLayout.putConstraint(SpringLayout.SOUTH, btnCancel, 0, SpringLayout.SOUTH, btnFind);
		springLayout.putConstraint(SpringLayout.EAST, btnCancel, -10, SpringLayout.EAST, this);
		add(btnCancel);

	}
}
