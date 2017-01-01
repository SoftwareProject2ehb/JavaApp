package view;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.border.EmptyBorder;

import controller.ActionMenuController;
import controller.ConfigurationController;
import utilities.Language;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class ConfigurationView extends JPanel {

	String users_icon_path;
	String reports_icon_path;
	String priceconfig_icon_path;
	/**
	 * Create the panel.
	 */
	public ConfigurationView() {
		users_icon_path = this.getClass().getClassLoader().getResource(Language.getString("usersimg")).getFile();
		users_icon_path = users_icon_path.replaceAll("%20", " ");
		reports_icon_path = this.getClass().getClassLoader().getResource(Language.getString("reportsimg")).getFile();
		reports_icon_path = reports_icon_path.replaceAll("%20", " ");
		priceconfig_icon_path = this.getClass().getClassLoader().getResource(Language.getString("priceimg")).getFile();
		priceconfig_icon_path = priceconfig_icon_path.replaceAll("%20", " ");
		
		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		SpringLayout sl_contentPane = new SpringLayout();
		this.setLayout(sl_contentPane);
		
		JLabel lblConfiguratie = new JLabel(Language.getString("configtitle"));
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblConfiguratie, 10, SpringLayout.NORTH, this);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblConfiguratie, 20, SpringLayout.WEST, this);
		lblConfiguratie.setFont(new Font("Arial Black", Font.PLAIN, 17));
		this.add(lblConfiguratie);
		
		JButton btnRapporten = new JButton(new ImageIcon(reports_icon_path));
		sl_contentPane.putConstraint(SpringLayout.WEST, btnRapporten, 0, SpringLayout.WEST, lblConfiguratie);
		btnRapporten.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConfigurationController.switchToReportView();
			}
		});
		add(btnRapporten);
		
		JButton btnPrijsconfg = new JButton(new ImageIcon(priceconfig_icon_path));
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnPrijsconfg, 0, SpringLayout.SOUTH, btnRapporten);
		btnPrijsconfg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConfigurationController.switchToPriceConfigView();
			}
		});
		add(btnPrijsconfg);
		
		JButton btnGebruikers = new JButton(new ImageIcon(users_icon_path));
		sl_contentPane.putConstraint(SpringLayout.EAST, btnPrijsconfg, -69, SpringLayout.WEST, btnGebruikers);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnGebruikers, 0, SpringLayout.SOUTH, btnRapporten);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnGebruikers, -24, SpringLayout.EAST, this);
		btnGebruikers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConfigurationController.switchToFindUserView();
			}
		});
		add(btnGebruikers);
		
		JButton btnTerug = new JButton(Language.getString("return"));
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnRapporten, -64, SpringLayout.NORTH, btnTerug);
		btnTerug.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ActionMenuController.switchToActionMenuView();
			}
		});
		sl_contentPane.putConstraint(SpringLayout.WEST, btnTerug, 10, SpringLayout.WEST, this);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnTerug, -10, SpringLayout.SOUTH, this);
		add(btnTerug);
		
		JComboBox comboBox = new JComboBox();
		sl_contentPane.putConstraint(SpringLayout.WEST, comboBox, 256, SpringLayout.WEST, this);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, comboBox, 0, SpringLayout.SOUTH, btnTerug);
		sl_contentPane.putConstraint(SpringLayout.EAST, comboBox, -6, SpringLayout.EAST, this);
		comboBox.setModel(new DefaultComboBoxModel(Language.getLanguages().toArray()));
		comboBox.addItemListener(new ItemListener() {
	        public void itemStateChanged(ItemEvent event) {
	        	if (event.getStateChange() == ItemEvent.SELECTED) {
	  	          String language = (String) event.getItem();
	  	          ConfigurationController.changeLanguage(language);
	        		}
	        	}
	        });
		comboBox.setMaximumRowCount(10);
		add(comboBox);
		
		JLabel lblSystemLanguage = new JLabel(Language.getString("systemlanguage"));
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblSystemLanguage, 3, SpringLayout.NORTH, btnTerug);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblSystemLanguage, -6, SpringLayout.WEST, comboBox);
		lblSystemLanguage.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		add(lblSystemLanguage);
	}
}

