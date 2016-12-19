package view;

import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

import controller.ConfigurationController;
import controller.FrameController;
import data_control.UserDAO;
import model.User;
import utilities.Language;

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
import javax.swing.JScrollPane;

public class UserView extends JPanel {
	public JTextField txtSearch;
	public JTable table;
	public JComboBox searchAtt;
	public DefaultTableModel tableModel;
	public EditUserView edit_user;

	/**
	 * Create the panel.
	 */
	public UserView() {
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		String col[] = {Language.getString("id"), Language.getString("firstname"),Language.getString("lastname"),Language.getString("email"),Language.getString("city"),Language.getString("username"),Language.getString("role")};

		tableModel = new DefaultTableModel(col, 0){
			@Override
			public boolean isCellEditable(int row,int column)
			{
				// NON EDITABLE CELLS
				return false;
			};
		};


		
		txtSearch = new JTextField();
		springLayout.putConstraint(SpringLayout.WEST, txtSearch, 10, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, txtSearch, -255, SpringLayout.EAST, this);
		add(txtSearch);
		txtSearch.setColumns(10);
		
		searchAtt = new JComboBox();
		springLayout.putConstraint(SpringLayout.WEST, searchAtt, 6, SpringLayout.EAST, txtSearch);
		springLayout.putConstraint(SpringLayout.EAST, searchAtt, -93, SpringLayout.EAST, this);
		searchAtt.addItem(Language.getString("id"));
		searchAtt.addItem(Language.getString("firstname"));
		searchAtt.addItem(Language.getString("lastname"));
		searchAtt.addItem(Language.getString("email"));
		searchAtt.addItem(Language.getString("telephone"));
		searchAtt.addItem(Language.getString("username"));
		searchAtt.addItem(Language.getString("role"));
		searchAtt.addItem(Language.getString("street"));
		searchAtt.addItem(Language.getString("zip"));
		searchAtt.addItem(Language.getString("country"));
		searchAtt.addItem(Language.getString("city"));
		add(searchAtt);
		
		JButton btnSearch = new JButton(Language.getString("search"));
		springLayout.putConstraint(SpringLayout.WEST, btnSearch, 6, SpringLayout.EAST, searchAtt);
		springLayout.putConstraint(SpringLayout.EAST, btnSearch, -10, SpringLayout.EAST, this);
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			ConfigurationController.searchUser();
			}
		});
		add(btnSearch);
		
		JButton btnNewButton = new JButton(Language.getString("create"));
		springLayout.putConstraint(SpringLayout.SOUTH, btnSearch, -362, SpringLayout.NORTH, btnNewButton);
		springLayout.putConstraint(SpringLayout.EAST, btnNewButton, -10, SpringLayout.EAST, this);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ConfigurationController.switchToCreateUserView();
			}
		});
		springLayout.putConstraint(SpringLayout.SOUTH, btnNewButton, -10, SpringLayout.SOUTH, this);
		add(btnNewButton);
		
		JButton btnRefresh = new JButton(Language.getString("refresh"));
		springLayout.putConstraint(SpringLayout.SOUTH, txtSearch, -362, SpringLayout.NORTH, btnRefresh);
		springLayout.putConstraint(SpringLayout.NORTH, btnRefresh, 0, SpringLayout.NORTH, btnNewButton);
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refreshTable(tableModel);
			}
		});
		add(btnRefresh);
		
		JButton button = new JButton(Language.getString("return"));
		springLayout.putConstraint(SpringLayout.WEST, btnRefresh, 7, SpringLayout.EAST, button);
		springLayout.putConstraint(SpringLayout.WEST, button, 10, SpringLayout.WEST, this);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConfigurationController.switchToConfigurationView();
			}
		});
		springLayout.putConstraint(SpringLayout.SOUTH, button, 0, SpringLayout.SOUTH, btnNewButton);
		add(button);
		
		JButton btnNewButton_1 = new JButton(Language.getString("change"));
		springLayout.putConstraint(SpringLayout.SOUTH, searchAtt, -362, SpringLayout.NORTH, btnNewButton_1);
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton_1, 0, SpringLayout.NORTH, btnNewButton);
		springLayout.putConstraint(SpringLayout.EAST, btnNewButton_1, -6, SpringLayout.WEST, btnNewButton);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConfigurationController.switchToEditUserView();
			}
		});
		add(btnNewButton_1);
		
		JButton btnInactive = new JButton(Language.getString("inactive"));
		springLayout.putConstraint(SpringLayout.NORTH, btnInactive, 362, SpringLayout.SOUTH, searchAtt);
		btnInactive.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConfigurationController.setInactiveUser();
			}
		});
		springLayout.putConstraint(SpringLayout.EAST, btnInactive, -6, SpringLayout.WEST, btnNewButton_1);
		add(btnInactive);
		
		JButton btnResetPassword = new JButton(Language.getString("resetpassword"));
		springLayout.putConstraint(SpringLayout.NORTH, btnResetPassword, 362, SpringLayout.SOUTH, txtSearch);
		btnResetPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConfigurationController.resetPassword();
			}
		});
		springLayout.putConstraint(SpringLayout.EAST, btnResetPassword, -6, SpringLayout.WEST, btnInactive);
		add(btnResetPassword);
		
		JScrollPane scrollPane = new JScrollPane();
		springLayout.putConstraint(SpringLayout.NORTH, scrollPane, 6, SpringLayout.SOUTH, txtSearch);
		springLayout.putConstraint(SpringLayout.WEST, scrollPane, 10, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, scrollPane, -6, SpringLayout.NORTH, btnNewButton);
		springLayout.putConstraint(SpringLayout.EAST, scrollPane, -10, SpringLayout.EAST, this);
		add(scrollPane);
		table = new JTable(tableModel);
		scrollPane.setViewportView(table);
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
