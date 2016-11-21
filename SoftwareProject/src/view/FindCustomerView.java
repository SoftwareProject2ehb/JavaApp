package view;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.border.EmptyBorder;

import controller.CustomerController;
import controller.SubscriptionController;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FindCustomerView extends JPanel {

	private JTextField txtVoornaam;
	private JTextField txtAchternaam;
	private JTextField txtEmail;
	private JTextField txtTelN;
	private JTextField txtStraatnaam;
	private JTextField txtPostcode;
	private JTextField txtGemeente;
	/**
	 * Create the panel.
	 */
	public FindCustomerView() {
		setBounds(100, 100, 450, 300);
		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		SpringLayout sl_contentPane = new SpringLayout();
		this.setLayout(sl_contentPane);
		
		JLabel lblKlantZoeken = new JLabel("Klant Zoeken");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblKlantZoeken, 10, SpringLayout.NORTH, this);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblKlantZoeken, 20, SpringLayout.WEST, this);
		lblKlantZoeken.setFont(new Font("Arial Black", Font.PLAIN, 17));
		this.add(lblKlantZoeken);
		
		JLabel lblVoornaam = new JLabel("Voornaam:");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblVoornaam, 26, SpringLayout.SOUTH, lblKlantZoeken);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblVoornaam, 39, SpringLayout.WEST, this);
		this.add(lblVoornaam);
		
		txtVoornaam = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, txtVoornaam, -4, SpringLayout.NORTH, lblVoornaam);
		sl_contentPane.putConstraint(SpringLayout.WEST, txtVoornaam, 16, SpringLayout.EAST, lblVoornaam);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, txtVoornaam, 4, SpringLayout.SOUTH, lblVoornaam);
		sl_contentPane.putConstraint(SpringLayout.EAST, txtVoornaam, 166, SpringLayout.EAST, lblVoornaam);
		this.add(txtVoornaam);
		txtVoornaam.setColumns(10);
		
		JLabel lblAchternaam = new JLabel("Achternaam:");
		sl_contentPane.putConstraint(SpringLayout.EAST, lblAchternaam, 0, SpringLayout.EAST, lblVoornaam);
		this.add(lblAchternaam);
		
		JLabel lblEmail = new JLabel("E-mail:");
		sl_contentPane.putConstraint(SpringLayout.EAST, lblEmail, 0, SpringLayout.EAST, lblVoornaam);
		this.add(lblEmail);
		
		JLabel lblTelN = new JLabel("Tel. N.:");
		sl_contentPane.putConstraint(SpringLayout.EAST, lblTelN, 0, SpringLayout.EAST, lblVoornaam);
		this.add(lblTelN);
		
		txtAchternaam = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.EAST, txtAchternaam, 0, SpringLayout.EAST, txtVoornaam);
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblAchternaam, 3, SpringLayout.NORTH, txtAchternaam);
		sl_contentPane.putConstraint(SpringLayout.NORTH, txtAchternaam, 6, SpringLayout.SOUTH, txtVoornaam);
		sl_contentPane.putConstraint(SpringLayout.WEST, txtAchternaam, 0, SpringLayout.WEST, txtVoornaam);
		this.add(txtAchternaam);
		txtAchternaam.setColumns(10);
		
		txtEmail = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.EAST, txtEmail, 0, SpringLayout.EAST, txtVoornaam);
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblEmail, 3, SpringLayout.NORTH, txtEmail);
		sl_contentPane.putConstraint(SpringLayout.NORTH, txtEmail, 6, SpringLayout.SOUTH, txtAchternaam);
		sl_contentPane.putConstraint(SpringLayout.WEST, txtEmail, 0, SpringLayout.WEST, txtVoornaam);
		this.add(txtEmail);
		txtEmail.setColumns(10);
		
		txtTelN = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.EAST, txtTelN, 0, SpringLayout.EAST, txtVoornaam);
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblTelN, 3, SpringLayout.NORTH, txtTelN);
		sl_contentPane.putConstraint(SpringLayout.NORTH, txtTelN, 6, SpringLayout.SOUTH, txtEmail);
		sl_contentPane.putConstraint(SpringLayout.WEST, txtTelN, 0, SpringLayout.WEST, txtVoornaam);
		this.add(txtTelN);
		txtTelN.setColumns(10);
		
		txtStraatnaam = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, txtStraatnaam, 6, SpringLayout.SOUTH, txtTelN);
		sl_contentPane.putConstraint(SpringLayout.WEST, txtStraatnaam, 0, SpringLayout.WEST, txtVoornaam);
		sl_contentPane.putConstraint(SpringLayout.EAST, txtStraatnaam, 0, SpringLayout.EAST, txtVoornaam);
		this.add(txtStraatnaam);
		txtStraatnaam.setColumns(10);
		
		JLabel lblStraatnaam = new JLabel("Straatnaam:");
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblStraatnaam, 0, SpringLayout.SOUTH, txtStraatnaam);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblStraatnaam, 0, SpringLayout.EAST, lblVoornaam);
		this.add(lblStraatnaam);
		
		txtPostcode = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, txtPostcode, 6, SpringLayout.SOUTH, txtStraatnaam);
		sl_contentPane.putConstraint(SpringLayout.WEST, txtPostcode, 0, SpringLayout.WEST, txtVoornaam);
		sl_contentPane.putConstraint(SpringLayout.EAST, txtPostcode, 0, SpringLayout.EAST, txtVoornaam);
		this.add(txtPostcode);
		txtPostcode.setColumns(10);
		
		JLabel lblPostcode = new JLabel("Postcode:");
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblPostcode, 0, SpringLayout.SOUTH, txtPostcode);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblPostcode, 0, SpringLayout.EAST, lblVoornaam);
		this.add(lblPostcode);
		
		txtGemeente = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, txtGemeente, 6, SpringLayout.SOUTH, txtPostcode);
		sl_contentPane.putConstraint(SpringLayout.WEST, txtGemeente, 0, SpringLayout.WEST, txtVoornaam);
		sl_contentPane.putConstraint(SpringLayout.EAST, txtGemeente, 0, SpringLayout.EAST, txtVoornaam);
		this.add(txtGemeente);
		txtGemeente.setColumns(10);
		
		JLabel lblGemeente = new JLabel("Gemeente:");
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblGemeente, 0, SpringLayout.SOUTH, txtGemeente);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblGemeente, 0, SpringLayout.EAST, lblVoornaam);
		this.add(lblGemeente);
		
		JButton button = new JButton("<<  Terug");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SubscriptionController.switchToBuySubscriptionView();
			}
		});
		sl_contentPane.putConstraint(SpringLayout.WEST, button, 0, SpringLayout.WEST, lblKlantZoeken);
		this.add(button);
		
		JButton btnKlantGebruiken = new JButton("Klant Gebruiken");
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnKlantGebruiken, -10, SpringLayout.SOUTH, this);
		sl_contentPane.putConstraint(SpringLayout.NORTH, button, 0, SpringLayout.NORTH, btnKlantGebruiken);
		this.add(btnKlantGebruiken);
		
		JList list = new JList();
		sl_contentPane.putConstraint(SpringLayout.WEST, btnKlantGebruiken, 0, SpringLayout.WEST, list);
		sl_contentPane.putConstraint(SpringLayout.NORTH, list, 0, SpringLayout.NORTH, txtVoornaam);
		sl_contentPane.putConstraint(SpringLayout.WEST, list, 10, SpringLayout.EAST, txtVoornaam);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, list, 0, SpringLayout.SOUTH, txtGemeente);
		sl_contentPane.putConstraint(SpringLayout.EAST, list, -20, SpringLayout.EAST, this);
		this.add(list);
		
		JLabel lblGevondenKlanten = new JLabel("Gevonden klanten:");
		sl_contentPane.putConstraint(SpringLayout.WEST, lblGevondenKlanten, 0, SpringLayout.WEST, list);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblGevondenKlanten, -6, SpringLayout.NORTH, list);
		this.add(lblGevondenKlanten);
		
		JButton btnMaakNieuweKlant = new JButton("Maak Nieuwe Klant");
		btnMaakNieuweKlant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomerController.switchToCreateCustomerView();
			}
		});
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnMaakNieuweKlant, 0, SpringLayout.NORTH, button);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnMaakNieuweKlant, 0, SpringLayout.EAST, txtVoornaam);
		add(btnMaakNieuweKlant);
	}

}
