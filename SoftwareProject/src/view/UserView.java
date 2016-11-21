package view;

import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

import controller.ConfigurationController;
import data_control.UserDAO;
import model.User;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFrame;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class UserView extends JPanel {
	private JTable table;
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public UserView() {
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		
		String col[] = {"Login","Role"};

		
		
		
		DefaultTableModel tableModel = new DefaultTableModel(col, 0);
		table = new JTable(tableModel);
		springLayout.putConstraint(SpringLayout.NORTH, table, 36, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, table, 10, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, table, 440, SpringLayout.WEST, this);
		add(table);
		UserDAO ud = new UserDAO();
		ArrayList<User> users = ud.getAllUsers();
		
		for (int i = 0; i < users.size(); i++){
			int id = users.get(i).getUserID();
			String voornaam = users.get(i).getFirstName();
			String achternaam = users.get(i).getLastName();
			String email = users.get(i).getEmail();
			String phone = users.get(i).getPhone();
			String login = users.get(i).getLogin();
			String role = users.get(i).getRolen();
			Boolean active = users.get(i).isActive();
					   
			Object[] data = {login ,role};
			tableModel.addRow(data);
		}
		
		textField = new JTextField();
		springLayout.putConstraint(SpringLayout.WEST, textField, 10, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, textField, -6, SpringLayout.NORTH, table);
		springLayout.putConstraint(SpringLayout.EAST, textField, -195, SpringLayout.EAST, this);
		add(textField);
		textField.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		springLayout.putConstraint(SpringLayout.WEST, comboBox, 6, SpringLayout.EAST, textField);
		springLayout.putConstraint(SpringLayout.SOUTH, comboBox, -6, SpringLayout.NORTH, table);
		add(comboBox);
		
		JButton btnSearch = new JButton("Search");
		springLayout.putConstraint(SpringLayout.EAST, comboBox, -12, SpringLayout.WEST, btnSearch);
		springLayout.putConstraint(SpringLayout.SOUTH, btnSearch, -6, SpringLayout.NORTH, table);
		springLayout.putConstraint(SpringLayout.EAST, btnSearch, -10, SpringLayout.EAST, this);
		add(btnSearch);
		
		JButton btnNewButton = new JButton("ADD");
		springLayout.putConstraint(SpringLayout.WEST, btnSearch, -18, SpringLayout.WEST, btnNewButton);
		springLayout.putConstraint(SpringLayout.EAST, btnNewButton, -10, SpringLayout.EAST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, table, -6, SpringLayout.NORTH, btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ConfigurationController.switchToCreateUserView();
			}
		});
		springLayout.putConstraint(SpringLayout.SOUTH, btnNewButton, -10, SpringLayout.SOUTH, this);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("EDIT");
		springLayout.putConstraint(SpringLayout.SOUTH, btnNewButton_1, 0, SpringLayout.SOUTH, btnNewButton);
		springLayout.putConstraint(SpringLayout.EAST, btnNewButton_1, -6, SpringLayout.WEST, btnNewButton);
		add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("REMOVE");
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton_2, 0, SpringLayout.NORTH, btnNewButton);
		springLayout.putConstraint(SpringLayout.EAST, btnNewButton_2, -6, SpringLayout.WEST, btnNewButton_1);
		add(btnNewButton_2);
		
		JButton btnRefresh = new JButton("Refresh");
		springLayout.putConstraint(SpringLayout.NORTH, btnRefresh, 0, SpringLayout.NORTH, btnNewButton);
		springLayout.putConstraint(SpringLayout.EAST, btnRefresh, -6, SpringLayout.WEST, btnNewButton_2);
		add(btnRefresh);
		
		JButton button = new JButton("<<  Terug");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConfigurationController.switchToConfigurationView();
			}
		});
		springLayout.putConstraint(SpringLayout.WEST, button, 0, SpringLayout.WEST, table);
		springLayout.putConstraint(SpringLayout.SOUTH, button, 0, SpringLayout.SOUTH, btnNewButton);
		add(button);
	}

}
