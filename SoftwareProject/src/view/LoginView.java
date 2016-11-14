package view;

import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import javax.swing.*;

public class LoginView extends JFrame {
	private final JLabel lblUsername = new JLabel("Gebruikersnaam");
    private final JLabel lblPassword = new JLabel("Paswoord");
    private final JTextField txtUsername = new JTextField(15);
    private final JPasswordField txtPassword = new JPasswordField(15);
    private final JButton btnOk = new JButton("OK");
    private final JButton btnExit = new JButton("Sluiten");
    private final JLabel lblStatus = new JLabel("Vul uw gebruikersgegevens in.", JLabel.CENTER);
    private final JPanel panel = new JPanel();

    public LoginView() {
    	super("Login");
    	
        panel.setLayout(new GridBagLayout());
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        panel.add(lblUsername, gbc);
        
        gbc.gridx = 1;
        panel.add(txtUsername, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(lblPassword, gbc);
        
        gbc.gridx = 1;
        panel.add(txtPassword, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(lblStatus, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        panel.add(btnOk, gbc);
        
        gbc.gridx = 1;
        panel.add(btnExit, gbc);
        
        getContentPane().add(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        btnOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	lblStatus.setForeground(Color.RED);
                lblStatus.setText("Ongeldige combinatie.");
            }
        });
        
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	System.exit(0);
            }
        });
    }
    
    public static void run() {
        JFrame f = new LoginView();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(600, 300);
        f.setMinimumSize(new Dimension(300, 150));
        f.setLocationRelativeTo(null);
    }
}