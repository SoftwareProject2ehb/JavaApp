package view;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.border.EmptyBorder;

import controller.ActionMenuController;
import controller.ConfigurationController;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConfigurationView extends JPanel {

	/**
	 * Create the panel.
	 */
	public ConfigurationView() {
		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		SpringLayout sl_contentPane = new SpringLayout();
		this.setLayout(sl_contentPane);
		
		JLabel lblConfiguratie = new JLabel("Configuratiescherm");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblConfiguratie, 10, SpringLayout.NORTH, this);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblConfiguratie, 20, SpringLayout.WEST, this);
		lblConfiguratie.setFont(new Font("Arial Black", Font.PLAIN, 17));
		this.add(lblConfiguratie);
		
		JButton btnRapporten = new JButton("Rapporten");
		btnRapporten.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConfigurationController.switchToReportView();
			}
		});
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnRapporten, 65, SpringLayout.SOUTH, lblConfiguratie);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnRapporten, 72, SpringLayout.WEST, this);
		add(btnRapporten);
		
		JButton btnPrijsconfg = new JButton("Prijsconfiguratie");
		btnPrijsconfg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConfigurationController.switchToPriceConfigView();
			}
		});
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnPrijsconfg, 0, SpringLayout.NORTH, btnRapporten);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnPrijsconfg, -85, SpringLayout.EAST, this);
		add(btnPrijsconfg);
		
		JButton btnGebruikers = new JButton("Gebruikersoverzicht");
		btnGebruikers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConfigurationController.switchToFindUserView();
			}
		});
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnGebruikers, 37, SpringLayout.SOUTH, btnRapporten);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnGebruikers, 141, SpringLayout.WEST, this);
		add(btnGebruikers);
		
		JButton btnTerug = new JButton("<<  Terug");
		btnTerug.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ActionMenuController.switchToActionMenuView();
			}
		});
		sl_contentPane.putConstraint(SpringLayout.WEST, btnTerug, 10, SpringLayout.WEST, this);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnTerug, -10, SpringLayout.SOUTH, this);
		add(btnTerug);
	}

}
