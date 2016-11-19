package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import event_handlers.CreateCustomer_CreatePressed;

import javax.swing.SpringLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CreateCustomerView extends JPanel {

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
	public CreateCustomerView() {
		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		SpringLayout sl_contentPane = new SpringLayout();
		this.setLayout(sl_contentPane);
		
		JLabel lblKlantMaken = new JLabel("Klant Aanmaken");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblKlantMaken, 10, SpringLayout.NORTH, this);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblKlantMaken, 20, SpringLayout.WEST, this);
		lblKlantMaken.setFont(new Font("Arial Black", Font.PLAIN, 17));
		this.add(lblKlantMaken);
		
		JLabel lblVoornaam = new JLabel("Voornaam:");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblVoornaam, 26, SpringLayout.SOUTH, lblKlantMaken);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblVoornaam, 39, SpringLayout.WEST, this);
		this.add(lblVoornaam);
		
		txtVoornaam = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.WEST, txtVoornaam, 16, SpringLayout.EAST, lblVoornaam);
		sl_contentPane.putConstraint(SpringLayout.EAST, txtVoornaam, -251, SpringLayout.EAST, this);
		this.add(txtVoornaam);
		txtVoornaam.setColumns(10);
		
		txtAchternaam = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.SOUTH, txtVoornaam, -6, SpringLayout.NORTH, txtAchternaam);
		sl_contentPane.putConstraint(SpringLayout.EAST, txtAchternaam, 0, SpringLayout.EAST, txtVoornaam);
		this.add(txtAchternaam);
		txtAchternaam.setColumns(10);
		
		JLabel lblAchternaam = new JLabel("Achternaam:");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblAchternaam, 12, SpringLayout.SOUTH, lblVoornaam);
		sl_contentPane.putConstraint(SpringLayout.WEST, txtAchternaam, 16, SpringLayout.EAST, lblAchternaam);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblAchternaam, 0, SpringLayout.EAST, lblVoornaam);
		this.add(lblAchternaam);
		
		txtEmail = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.SOUTH, txtAchternaam, -6, SpringLayout.NORTH, txtEmail);
		sl_contentPane.putConstraint(SpringLayout.EAST, txtEmail, 0, SpringLayout.EAST, txtVoornaam);
		this.add(txtEmail);
		txtEmail.setColumns(10);
		
		JLabel lblEmail = new JLabel("E-mail:");
		sl_contentPane.putConstraint(SpringLayout.WEST, txtEmail, 16, SpringLayout.EAST, lblEmail);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblEmail, 0, SpringLayout.EAST, lblVoornaam);
		this.add(lblEmail);
		
		txtTelN = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.SOUTH, txtEmail, -6, SpringLayout.NORTH, txtTelN);
		sl_contentPane.putConstraint(SpringLayout.EAST, txtTelN, 0, SpringLayout.EAST, txtVoornaam);
		this.add(txtTelN);
		txtTelN.setColumns(10);
		
		JLabel lblTelNo = new JLabel("Tel. N.:");
		sl_contentPane.putConstraint(SpringLayout.WEST, txtTelN, 16, SpringLayout.EAST, lblTelNo);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblEmail, -12, SpringLayout.NORTH, lblTelNo);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblTelNo, 0, SpringLayout.EAST, lblVoornaam);
		this.add(lblTelNo);
		
		txtStraatnaam = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.SOUTH, txtTelN, -6, SpringLayout.NORTH, txtStraatnaam);
		sl_contentPane.putConstraint(SpringLayout.EAST, txtStraatnaam, 0, SpringLayout.EAST, txtVoornaam);
		this.add(txtStraatnaam);
		txtStraatnaam.setColumns(10);
		
		JLabel lblStraatnaam = new JLabel("Straatnaam:");
		sl_contentPane.putConstraint(SpringLayout.WEST, txtStraatnaam, 16, SpringLayout.EAST, lblStraatnaam);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblTelNo, -12, SpringLayout.NORTH, lblStraatnaam);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblStraatnaam, 0, SpringLayout.EAST, lblVoornaam);
		this.add(lblStraatnaam);
		
		txtPostcode = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.SOUTH, txtPostcode, -132, SpringLayout.SOUTH, this);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, txtStraatnaam, -6, SpringLayout.NORTH, txtPostcode);
		sl_contentPane.putConstraint(SpringLayout.EAST, txtPostcode, 0, SpringLayout.EAST, txtVoornaam);
		this.add(txtPostcode);
		txtPostcode.setColumns(10);
		
		JLabel lblPostcode = new JLabel("Postcode:");
		sl_contentPane.putConstraint(SpringLayout.WEST, txtPostcode, 16, SpringLayout.EAST, lblPostcode);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblStraatnaam, -12, SpringLayout.NORTH, lblPostcode);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblPostcode, 0, SpringLayout.EAST, lblVoornaam);
		this.add(lblPostcode);
		
		txtGemeente = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, txtGemeente, 6, SpringLayout.SOUTH, txtPostcode);
		sl_contentPane.putConstraint(SpringLayout.EAST, txtGemeente, 0, SpringLayout.EAST, txtVoornaam);
		this.add(txtGemeente);
		txtGemeente.setColumns(10);
		
		JLabel lblGemeente = new JLabel("Gemeente:");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblGemeente, 220, SpringLayout.NORTH, this);
		sl_contentPane.putConstraint(SpringLayout.WEST, txtGemeente, 16, SpringLayout.EAST, lblGemeente);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblPostcode, -12, SpringLayout.NORTH, lblGemeente);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblGemeente, 0, SpringLayout.EAST, lblVoornaam);
		this.add(lblGemeente);
		
		JButton button = new JButton("<<  Terug");
		sl_contentPane.putConstraint(SpringLayout.NORTH, button, 33, SpringLayout.SOUTH, lblGemeente);
		sl_contentPane.putConstraint(SpringLayout.WEST, button, 0, SpringLayout.WEST, lblKlantMaken);
		this.add(button);
		
		JButton btnKlantAanmaken = new JButton("Klant Aanmaken");
		btnKlantAanmaken.addActionListener(new CreateCustomer_CreatePressed());
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnKlantAanmaken, 0, SpringLayout.NORTH, button);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnKlantAanmaken, 0, SpringLayout.EAST, txtVoornaam);
		this.add(btnKlantAanmaken);
	}
	
	/**
	 * Returns the textfields as an array
	 */
	
	public ArrayList<JTextField> getTextFields() {
		ArrayList<JTextField> array = new ArrayList<JTextField>();
		array.add(txtVoornaam);
		array.add(txtAchternaam);
		array.add(txtEmail);
		array.add(txtTelN);
		array.add(txtStraatnaam);
		array.add(txtPostcode);
		array.add(txtGemeente);
		
		return array;
	}
	
	

}
