package view;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.*;

import controller.ActionMenuController;
import controller.ConfigurationController;
import controller.CustomerController;
import controller.LoginController;
import controller.SystemController;
import data_control.BaseDAO;
import model.SystemNMBS;
import model.User;
import utilities.Encryptor;
import utilities.Language;

import javax.swing.border.LineBorder;

public class LoginView extends JPanel {
	private final JTextField txtUsername = new JTextField();;
	private final JPasswordField txtPassword = new JPasswordField(15);
	private final JLabel lblStatus = new JLabel("");
	public LoginView() {
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		springLayout.putConstraint(SpringLayout.NORTH, panel, 10, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, panel, 10, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, panel, -10, SpringLayout.EAST, this);
		add(panel);
		
		JLabel lblNewLabel = new JLabel(Language.getString("appname"));
		panel.add(lblNewLabel);
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel, 50, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel, 0, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel, 0, SpringLayout.EAST, this);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Simplified Arabic", Font.BOLD, 17));
		

		JLabel lblGebruikersnaam = new JLabel(Language.getString("username"));
		springLayout.putConstraint(SpringLayout.NORTH, lblGebruikersnaam, 70, SpringLayout.SOUTH, panel);
		springLayout.putConstraint(SpringLayout.WEST, lblGebruikersnaam, 106, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, lblGebruikersnaam, 90, SpringLayout.SOUTH, panel);
		add(lblGebruikersnaam);
		
		springLayout.putConstraint(SpringLayout.NORTH, txtUsername, 0, SpringLayout.NORTH, lblGebruikersnaam);
		springLayout.putConstraint(SpringLayout.WEST, txtUsername, 25, SpringLayout.EAST, lblGebruikersnaam);
		springLayout.putConstraint(SpringLayout.SOUTH, txtUsername, 0, SpringLayout.SOUTH, lblGebruikersnaam);
		springLayout.putConstraint(SpringLayout.EAST, txtUsername, 150, SpringLayout.EAST, lblGebruikersnaam);
		add(txtUsername);
		txtUsername.setColumns(10);
		
		JLabel lblPaswoord = new JLabel(Language.getString("password"));
		springLayout.putConstraint(SpringLayout.NORTH, lblPaswoord, 5, SpringLayout.SOUTH, lblGebruikersnaam);
		springLayout.putConstraint(SpringLayout.WEST, lblPaswoord, 5, SpringLayout.WEST, lblGebruikersnaam);
		springLayout.putConstraint(SpringLayout.SOUTH, lblPaswoord, 25, SpringLayout.SOUTH, lblGebruikersnaam);
		add(lblPaswoord);
		
		springLayout.putConstraint(SpringLayout.NORTH, txtPassword, 0, SpringLayout.NORTH, lblPaswoord);
		springLayout.putConstraint(SpringLayout.WEST, txtPassword, 0, SpringLayout.WEST, txtUsername);
		springLayout.putConstraint(SpringLayout.SOUTH, txtPassword, 0, SpringLayout.SOUTH, lblPaswoord);
		springLayout.putConstraint(SpringLayout.EAST, txtPassword, 0, SpringLayout.EAST, txtUsername);
		add(txtPassword);
		txtPassword.setColumns(10);
		
		JButton btnMeldAan = new JButton(Language.getString("login"));
		springLayout.putConstraint(SpringLayout.NORTH, btnMeldAan, 6, SpringLayout.SOUTH, txtPassword);
		springLayout.putConstraint(SpringLayout.EAST, btnMeldAan, 0, SpringLayout.EAST, txtUsername);
		btnMeldAan.addActionListener(new ActionListener() {
			@Override
            public void actionPerformed(ActionEvent e) {
            	if (LoginController.login()) {
            		SystemController.defaultPasswordCheck();
            	} else {
            		lblStatus.setForeground(Color.RED);
                    lblStatus.setText(Language.getString("unvalidcombo"));
            	}
            }
		});
		add(btnMeldAan);
		
		JButton btnSluiten = new JButton(Language.getString("close"));
		btnSluiten.setBackground(new Color(250, 128, 114));
		springLayout.putConstraint(SpringLayout.NORTH, btnSluiten, 6, SpringLayout.SOUTH, txtPassword);
		springLayout.putConstraint(SpringLayout.WEST, btnSluiten, -20, SpringLayout.WEST, lblGebruikersnaam);
		springLayout.putConstraint(SpringLayout.EAST, btnSluiten, -260, SpringLayout.EAST, this);
		btnSluiten.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
            	try {
					BaseDAO.getConnection().close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            	System.exit(0);
            }
		});
		add(btnSluiten);
		
		springLayout.putConstraint(SpringLayout.SOUTH, lblStatus, -6, SpringLayout.NORTH, lblGebruikersnaam);
		springLayout.putConstraint(SpringLayout.WEST, lblStatus, 0, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, lblStatus, 0, SpringLayout.EAST, this);
		lblStatus.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblStatus);
		
		txtUsername.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					txtPassword.requestFocusInWindow();
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {}
        });
        
        txtPassword.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					if (LoginController.login()) {
						SystemController.defaultPasswordCheck();
	            	} else {
	            		lblStatus.setForeground(Color.RED);
	                    lblStatus.setText(Language.getString("unvalidcombo"));
	            	}
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {}
        });
	}
	
    public ArrayList<JTextField> getTextFields() {
		ArrayList<JTextField> array = new ArrayList<JTextField>();
		array.add(txtUsername);
		array.add(txtPassword);
		
		return array;
	}
    
    public void reset() {
    	txtUsername.setText("");
    	txtPassword.setText("");
    	lblStatus.setText("");
    	txtUsername.requestFocusInWindow();
    }
}