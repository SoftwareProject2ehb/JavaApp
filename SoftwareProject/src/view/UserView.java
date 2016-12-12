package view;

import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

import controller.ConfigurationController;
import controller.FrameController;
import data_control.UserDAO;
import model.User;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFrame;

import java.awt.Component;
import java.awt.Dimension;

import javax.security.auth.login.Configuration;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;

public class UserView extends JPanel {
	public JTable table;
	public JTextField txtSearch;
	public JComboBox searchAtt;
	public DefaultTableModel tableModel;
	public EditUserView edit_user;

	/**
	 * Create the panel.
	 */
	public UserView() {
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		String col[] = {"ID","Voornaam","Achternaam","Email","Stad","Username","Role"};

		tableModel = new DefaultTableModel(col, 0){
			@Override
			public boolean isCellEditable(int row,int column)
			{
				// NON EDITABLE CELLS
				return false;
			};
		};
		table = new JTable(tableModel);
		springLayout.putConstraint(SpringLayout.NORTH, table, 36, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, table, 10, SpringLayout.WEST, this);
<<<<<<< HEAD
=======
		springLayout.putConstraint(SpringLayout.EAST, table, -10, SpringLayout.EAST, this);
>>>>>>> refs/heads/master
		add(table);
		
		txtSearch = new JTextField();
		springLayout.putConstraint(SpringLayout.WEST, txtSearch, 10, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, txtSearch, -6, SpringLayout.NORTH, table);
		springLayout.putConstraint(SpringLayout.EAST, txtSearch, -195, SpringLayout.EAST, this);
		add(txtSearch);
		txtSearch.setColumns(10);
		
		searchAtt = new JComboBox();
		springLayout.putConstraint(SpringLayout.WEST, searchAtt, 6, SpringLayout.EAST, txtSearch);
		springLayout.putConstraint(SpringLayout.SOUTH, searchAtt, -6, SpringLayout.NORTH, table);
		searchAtt.addItem("ID");
		searchAtt.addItem("Voornaam");
		searchAtt.addItem("Achternaam");
		searchAtt.addItem("Email");
		searchAtt.addItem("Telefoon Nr.");
		searchAtt.addItem("Username");
		searchAtt.addItem("Role");
		searchAtt.addItem("Straat");
		searchAtt.addItem("Postcode");
		searchAtt.addItem("Land");
		searchAtt.addItem("Stad");
		add(searchAtt);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConfigurationController.findUser();
			}
		});
		springLayout.putConstraint(SpringLayout.SOUTH, btnSearch, -6, SpringLayout.NORTH, table);
		springLayout.putConstraint(SpringLayout.EAST, table, 0, SpringLayout.EAST, btnSearch);
		springLayout.putConstraint(SpringLayout.EAST, searchAtt, -12, SpringLayout.WEST, btnSearch);
		springLayout.putConstraint(SpringLayout.EAST, btnSearch, 0, SpringLayout.EAST, table);
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			ConfigurationController.searchUser();
			}
		});
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
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConfigurationController.switchToEditUserView();
			}
		});
		springLayout.putConstraint(SpringLayout.SOUTH, btnNewButton_1, 0, SpringLayout.SOUTH, btnNewButton);
		springLayout.putConstraint(SpringLayout.EAST, btnNewButton_1, -6, SpringLayout.WEST, btnNewButton);
		add(btnNewButton_1);
		
		JButton btnRefresh = new JButton("Refresh");
		springLayout.putConstraint(SpringLayout.NORTH, btnRefresh, 0, SpringLayout.NORTH, btnNewButton);
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refreshTable(tableModel);
			}
		});
		add(btnRefresh);
		
		JButton button = new JButton("<<  Terug");
		springLayout.putConstraint(SpringLayout.WEST, button, 10, SpringLayout.WEST, this);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConfigurationController.switchToConfigurationView();
			}
		});
		springLayout.putConstraint(SpringLayout.SOUTH, button, 0, SpringLayout.SOUTH, btnNewButton);
		add(button);
		
		JButton btnNewButton_1 = new JButton("EDIT");
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton_1, 0, SpringLayout.NORTH, btnNewButton);
		springLayout.putConstraint(SpringLayout.EAST, btnNewButton_1, -6, SpringLayout.WEST, btnNewButton);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConfigurationController.switchToEditUserView();
			}
		});
		add(btnNewButton_1);
		
		JButton btnInactive = new JButton("INACTIVE");
		btnInactive.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConfigurationController.setInactiveUser();
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, btnInactive, 6, SpringLayout.SOUTH, table);
		springLayout.putConstraint(SpringLayout.EAST, btnInactive, -6, SpringLayout.WEST, btnNewButton_1);
		add(btnInactive);
		
		JButton btnResetPassword = new JButton("RESET PASSWORD");
		btnResetPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConfigurationController.resetPassword();
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, btnResetPassword, 6, SpringLayout.SOUTH, table);
		springLayout.putConstraint(SpringLayout.EAST, btnResetPassword, -6, SpringLayout.WEST, btnInactive);
		add(btnResetPassword);
		
		JRadioButton rdbtnShowInactiveUsers = new JRadioButton("Show inactive users ");
		springLayout.putConstraint(SpringLayout.NORTH, rdbtnShowInactiveUsers, 0, SpringLayout.NORTH, btnNewButton);
		springLayout.putConstraint(SpringLayout.WEST, rdbtnShowInactiveUsers, 6, SpringLayout.EAST, btnRefresh);
		add(rdbtnShowInactiveUsers);
	}
	
	public void refreshTable(DefaultTableModel tableModel){
		tableModel.setRowCount(0);
		ArrayList<User> users = UserDAO.getAllActiveUsers();
		for (int i = 0; i < users.size(); i++){
			int id = users.get(i).getUserID();
			String voornaam = users.get(i).getFirstName();
			String achternaam = users.get(i).getLastName();
			String email = users.get(i).getEmail();
			String login = users.get(i).getLogin();
			String role = users.get(i).getRolen();
			String city = users.get(i).getCity();
					   
			Object[] data = {id,voornaam,achternaam,email,city,login,role};
			tableModel.addRow(data);
		}
	}
}
