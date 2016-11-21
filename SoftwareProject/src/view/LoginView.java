package view;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.*;

import controller.ActionMenuController;
import controller.CustomerController;
import controller.LoginController;
import controller.SystemController;
import data_control.BaseDAO;

public class LoginView extends JPanel {
	private final JLabel lblUsername = new JLabel("Gebruikersnaam");
    private final JLabel lblPassword = new JLabel("Paswoord");
    private final JTextField txtUsername = new JTextField(15);
    private final JPasswordField txtPassword = new JPasswordField(15);
    private final JButton btnOk = new JButton("OK");
    private final JButton btnExit = new JButton("Sluiten");
    private final JLabel lblStatus = new JLabel("Vul uw gebruikersgegevens in.", JLabel.CENTER);

    public LoginView() {
    	super();
    	
    	setLayout(new GridBagLayout());
    	
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        add(lblUsername, gbc);
        
        gbc.gridx = 1;
        add(txtUsername, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(lblPassword, gbc);
        
        gbc.gridx = 1;
        add(txtPassword, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(lblStatus, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        add(btnOk, gbc);
        
        gbc.gridx = 1;
        add(btnExit, gbc);
        
        setVisible(true);

        btnOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	if (LoginController.login()) {
            		ActionMenuController.switchToActionMenuView();
            	} else {
            		lblStatus.setForeground(Color.RED);
                    lblStatus.setText("Ongeldige combinatie.");
            	}
            }
        });
        
        btnExit.addActionListener(new ActionListener() {
            @Override
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
    }
    
    public ArrayList<JTextField> getTextFields() {
		ArrayList<JTextField> array = new ArrayList<JTextField>();
		array.add(txtUsername);
		array.add(txtPassword);
		
		return array;
	}
}