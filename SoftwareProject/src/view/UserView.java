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
		String col[] = {"ID","Voornaam","Achternaam","Email","Telefoon Nr.","Username","Role"};

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
		add(table);
		
		txtSearch = new JTextField();
		springLayout.putConstraint(SpringLayout.WEST, txtSearch, 10, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, txtSearch, -6, SpringLayout.NORTH, table);
		add(txtSearch);
		txtSearch.setColumns(10);
		
		searchAtt = new JComboBox();
		springLayout.putConstraint(SpringLayout.EAST, txtSearch, -6, SpringLayout.WEST, searchAtt);
		springLayout.putConstraint(SpringLayout.WEST, searchAtt, 449, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, searchAtt, -6, SpringLayout.NORTH, table);
		searchAtt.addItem("ID");
		searchAtt.addItem("Voornaam");
		searchAtt.addItem("Achternaam");
		searchAtt.addItem("Email");
		searchAtt.addItem("Telefoon Nr.");
		searchAtt.addItem("Username");
		searchAtt.addItem("Role");
		add(searchAtt);
		
		JButton btnSearch = new JButton("Search");
		springLayout.putConstraint(SpringLayout.EAST, searchAtt, -12, SpringLayout.WEST, btnSearch);
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			ConfigurationController.searchUser();
			}
		});
		springLayout.putConstraint(SpringLayout.SOUTH, btnSearch, -6, SpringLayout.NORTH, table);
		springLayout.putConstraint(SpringLayout.EAST, table, 0, SpringLayout.EAST, btnSearch);
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
		
		JButton btnRefresh = new JButton("Refresh");
		springLayout.putConstraint(SpringLayout.NORTH, btnRefresh, 0, SpringLayout.NORTH, btnNewButton);
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refreshTable(tableModel);
			}
		});
		add(btnRefresh);
		
		JButton button = new JButton("<<  Terug");
		springLayout.putConstraint(SpringLayout.WEST, btnRefresh, 7, SpringLayout.EAST, button);
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
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, btnResetPassword, 6, SpringLayout.SOUTH, table);
		springLayout.putConstraint(SpringLayout.EAST, btnResetPassword, -6, SpringLayout.WEST, btnInactive);
		add(btnResetPassword);
	}
	
	public void refreshTable(DefaultTableModel tableModel){
		tableModel.setRowCount(0);
		ArrayList<User> users = UserDAO.getAllActiveUsers();
		for (int i = 0; i < users.size(); i++){
			int id = users.get(i).getUserID();
			String voornaam = users.get(i).getFirstName();
			String achternaam = users.get(i).getLastName();
			String email = users.get(i).getEmail();
			String phone = users.get(i).getPhone();
			String login = users.get(i).getLogin();
			String role = users.get(i).getRolen();
			Boolean active = users.get(i).isActive();
					 
			Object[] data = {id,voornaam,achternaam,email,phone,login,role};
			tableModel.addRow(data);
		}
	}

}
