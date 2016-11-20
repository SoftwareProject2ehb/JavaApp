package view;

import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.border.EmptyBorder;

import controller.ActionMenuController;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BuySubscriptionView extends JPanel {
	private JTextField txtPrijs;
	private JTextField textField_1;
	
	/**
	 * Create the panel.
	 */
	public BuySubscriptionView() {
		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		SpringLayout sl_contentPane = new SpringLayout();
		this.setLayout(sl_contentPane);
		
		JLabel lblAbonnementKopen = new JLabel("Abonnement Kopen");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblAbonnementKopen, 10, SpringLayout.NORTH, this);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblAbonnementKopen, 20, SpringLayout.WEST, this);
		lblAbonnementKopen.setFont(new Font("Arial Black", Font.PLAIN, 17));
		this.add(lblAbonnementKopen);
		
		JLabel lblBeginstation = new JLabel("Beginstation");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblBeginstation, 33, SpringLayout.SOUTH, lblAbonnementKopen);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblBeginstation, 20, SpringLayout.WEST, this);
		add(lblBeginstation);
		
		JLabel lblEindstation = new JLabel("Eindstation");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblEindstation, 16, SpringLayout.SOUTH, lblBeginstation);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblEindstation, 0, SpringLayout.EAST, lblBeginstation);
		add(lblEindstation);
		
		JComboBox comboBox = new JComboBox();
		sl_contentPane.putConstraint(SpringLayout.NORTH, comboBox, -3, SpringLayout.NORTH, lblBeginstation);
		sl_contentPane.putConstraint(SpringLayout.WEST, comboBox, 6, SpringLayout.EAST, lblBeginstation);
		sl_contentPane.putConstraint(SpringLayout.EAST, comboBox, 106, SpringLayout.EAST, lblBeginstation);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Aalst", "Aalst-Kerrebroek", "Aalter", "Aarschot", "Aarsele"}));
		add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		sl_contentPane.putConstraint(SpringLayout.NORTH, comboBox_1, -3, SpringLayout.NORTH, lblEindstation);
		sl_contentPane.putConstraint(SpringLayout.WEST, comboBox_1, 6, SpringLayout.EAST, lblEindstation);
		sl_contentPane.putConstraint(SpringLayout.EAST, comboBox_1, 106, SpringLayout.EAST, lblEindstation);
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Aalst", "Aalst-Kerrebroek", "Aalter", "Aarschot", "Aarsele"}));
		add(comboBox_1);
		
		JLabel lblGeldigheid = new JLabel("Geldigheid");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblGeldigheid, 0, SpringLayout.NORTH, lblEindstation);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblGeldigheid, 30, SpringLayout.EAST, comboBox_1);
		add(lblGeldigheid);
		
		JLabel lblTypeAbonnement = new JLabel("Type abon.");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblTypeAbonnement, 16, SpringLayout.SOUTH, lblEindstation);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblTypeAbonnement, 0, SpringLayout.EAST, lblBeginstation);
		add(lblTypeAbonnement);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"Type 1"}));
		sl_contentPane.putConstraint(SpringLayout.WEST, comboBox_2, 0, SpringLayout.WEST, comboBox);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, comboBox_2, 0, SpringLayout.SOUTH, lblTypeAbonnement);
		sl_contentPane.putConstraint(SpringLayout.EAST, comboBox_2, 106, SpringLayout.EAST, lblTypeAbonnement);
		add(comboBox_2);
		
		JButton btnOfferte = new JButton("Offerte");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnOfferte, 51, SpringLayout.SOUTH, comboBox_2);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnOfferte, 0, SpringLayout.EAST, comboBox);
		add(btnOfferte);
		
		JButton btnKoopTicket = new JButton("Koop Abonnement");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnKoopTicket, 13, SpringLayout.SOUTH, btnOfferte);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnKoopTicket, 0, SpringLayout.EAST, comboBox);
		add(btnKoopTicket);
		
		txtPrijs = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.WEST, txtPrijs, 0, SpringLayout.WEST, lblGeldigheid);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, txtPrijs, 0, SpringLayout.SOUTH, btnOfferte);
		add(txtPrijs);
		txtPrijs.setColumns(10);
		
		JLabel lblPrijs = new JLabel("Prijs");
		sl_contentPane.putConstraint(SpringLayout.WEST, lblPrijs, 0, SpringLayout.WEST, lblGeldigheid);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblPrijs, -6, SpringLayout.NORTH, txtPrijs);
		add(lblPrijs);
		
		textField_1 = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, textField_1, -3, SpringLayout.NORTH, lblBeginstation);
		sl_contentPane.putConstraint(SpringLayout.EAST, textField_1, -69, SpringLayout.EAST, this);
		add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblBegindatum = new JLabel("Begindatum");
		sl_contentPane.putConstraint(SpringLayout.WEST, textField_1, 6, SpringLayout.EAST, lblBegindatum);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblBegindatum, 0, SpringLayout.SOUTH, lblBeginstation);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblBegindatum, 0, SpringLayout.EAST, lblGeldigheid);
		add(lblBegindatum);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"1 maand", "2 maanden", "3 maanden", "6 maanden", "1 jaar"}));
		sl_contentPane.putConstraint(SpringLayout.WEST, comboBox_3, 6, SpringLayout.EAST, lblGeldigheid);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, comboBox_3, 0, SpringLayout.SOUTH, lblEindstation);
		sl_contentPane.putConstraint(SpringLayout.EAST, comboBox_3, 106, SpringLayout.EAST, lblGeldigheid);
		add(comboBox_3);
		
		JButton button = new JButton("<<  Terug");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ActionMenuController.switchToActionMenuView();
			}
		});
		sl_contentPane.putConstraint(SpringLayout.NORTH, button, 5, SpringLayout.SOUTH, btnKoopTicket);
		sl_contentPane.putConstraint(SpringLayout.WEST, button, 10, SpringLayout.WEST, this);
		add(button);
	}

}
