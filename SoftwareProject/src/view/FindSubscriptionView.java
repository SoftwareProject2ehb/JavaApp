package view;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SpringLayout;
import javax.swing.table.DefaultTableModel;

import controller.ActionMenuController;
import controller.SubscriptionController;
import data_control.SubscriptionDAO;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FindSubscriptionView extends JPanel {
	private JTextField textField;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Create the panel.
	 */
	public FindSubscriptionView() {
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		
		
		String col[] = {"ID","Type","Price", "Customer ID", "StartStation", "EndStation", "StartDate", "EndDate", "Active"};

		DefaultTableModel tableModel = new DefaultTableModel(col, 0);
		
		JTable table = new JTable(tableModel);
		
		textField = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, textField, 170, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, textField, 10, SpringLayout.WEST, this);
		add(textField);
		textField.setColumns(10);
		
		JRadioButton rdbtnSearchById = new JRadioButton("Search op ID");
		springLayout.putConstraint(SpringLayout.WEST, rdbtnSearchById, 10, SpringLayout.WEST, this);
		buttonGroup.add(rdbtnSearchById);
		springLayout.putConstraint(SpringLayout.NORTH, rdbtnSearchById, 8, SpringLayout.SOUTH, textField);
		add(rdbtnSearchById);
		
		JRadioButton rdbtnSearchByCustomer = new JRadioButton("Search op ID van klant");
		springLayout.putConstraint(SpringLayout.WEST, rdbtnSearchByCustomer, 10, SpringLayout.WEST, this);
		buttonGroup.add(rdbtnSearchByCustomer);
		springLayout.putConstraint(SpringLayout.NORTH, rdbtnSearchByCustomer, 6, SpringLayout.SOUTH, rdbtnSearchById);
		add(rdbtnSearchByCustomer);
		
		JButton btnFind = new JButton("Zoek Abonnement");
		btnFind.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (textField.getText().isEmpty())
					table.setModel(SubscriptionController.buildTableModel(new SubscriptionDAO().getAllSubs(), tableModel));
				else if (rdbtnSearchById.isSelected())
					table.setModel(SubscriptionController.buildTableModel(new SubscriptionDAO().getAllSubs(), tableModel,Integer.parseInt(textField.getText())));
				else if (rdbtnSearchByCustomer.isSelected())
					table.setModel(SubscriptionController.buildTableModel(new SubscriptionDAO().getSubsByCustomerID(Integer.parseInt(textField.getText())), tableModel));
				buttonGroup.clearSelection();

			}
		});
		add(btnFind);
		
		JButton btnCancel = new JButton("Terug naar Menu");
		springLayout.putConstraint(SpringLayout.NORTH, btnFind, 0, SpringLayout.NORTH, btnCancel);
		springLayout.putConstraint(SpringLayout.NORTH, btnCancel, 6, SpringLayout.SOUTH, rdbtnSearchByCustomer);
		springLayout.putConstraint(SpringLayout.WEST, btnCancel, 0, SpringLayout.WEST, textField);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ActionMenuController.switchToActionMenuView();
			}
		});
		add(btnCancel);
		
		JScrollPane scrollPane = new JScrollPane();
		springLayout.putConstraint(SpringLayout.EAST, btnFind, 0, SpringLayout.EAST, scrollPane);
		springLayout.putConstraint(SpringLayout.NORTH, scrollPane, 22, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, scrollPane, 10, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, scrollPane, -30, SpringLayout.NORTH, textField);
		springLayout.putConstraint(SpringLayout.EAST, scrollPane, -10, SpringLayout.EAST, this);
		scrollPane.setViewportView(table);
		add(scrollPane);

	}
}
