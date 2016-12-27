package view;

import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import javax.swing.JSplitPane;
import javax.swing.JTextField;



import controller.ActionMenuController;
import controller.ConfigurationController;
import utilities.Language;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class AccountInfoView extends JPanel {
	public JLabel lblStatus;
	public JLabel lblRole;
	public JLabel lblNaam;
	public JLabel lblEmail;
	public JLabel lblStraat;
	public JLabel lblPhone;

	/**
	 * Create the panel.
	 */
	public AccountInfoView() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel(Language.getString("name"));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setBounds(24, 82, 61, 16);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel(Language.getString("email"));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setBounds(24, 109, 61, 16);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel(Language.getString("address"));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2.setBounds(24, 137, 61, 16);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel(Language.getString("telephone"));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3.setBounds(24, 165, 91, 16);
		add(lblNewLabel_3);
		
		JLabel lblAccountDetails = new JLabel(Language.getString("accountdetails"));
		lblAccountDetails.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblAccountDetails.setBounds(24, 22, 182, 23);
		add(lblAccountDetails);
		
		lblStatus = new JLabel(Language.getString("active"));
		lblStatus.setHorizontalAlignment(SwingConstants.LEFT);
		lblStatus.setBounds(24, 193, 61, 16);
		add(lblStatus);
		
		lblRole = new JLabel(Language.getString("user"));
		lblRole.setBounds(128, 193, 61, 16);
		add(lblRole);
		
		lblNaam = new JLabel(Language.getString("name"));
		lblNaam.setBounds(128, 82, 45, 16);
		add(lblNaam);
		
		lblEmail = new JLabel(Language.getString("email"));
		lblEmail.setBounds(128, 109, 61, 16);
		add(lblEmail);
		
		lblStraat = new JLabel(Language.getString("street"));
		lblStraat.setBounds(128, 137, 278, 16);
		add(lblStraat);
		
		lblPhone = new JLabel(Language.getString("telephone"));
		lblPhone.setBounds(127, 165, 61, 16);
		add(lblPhone);
		
		JButton btnTerug = new JButton(Language.getString("return"));
		btnTerug.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ActionMenuController.switchToActionMenuView();
			}
		});
		btnTerug.setBounds(24, 254, 117, 29);
		add(btnTerug);
		
		JButton btnChangePassword = new JButton(Language.getString("editpassword"));
		btnChangePassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConfigurationController.switchToEditPasswordView();
			}
		});
		btnChangePassword.setBounds(282, 22, 144, 29);
		add(btnChangePassword);
				

	}
	
	public ArrayList<JLabel> getLabels() {
		ArrayList<JLabel> array = new ArrayList<JLabel>();
		array.add(lblEmail);
		array.add(lblPhone);
		array.add(lblRole);
		array.add(lblStatus);
		array.add(lblStraat);
		array.add(lblNaam);
		
		return array;
	}
}
