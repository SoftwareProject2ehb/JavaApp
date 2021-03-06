package view;

import java.awt.Color;
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
import javax.swing.text.AbstractDocument;

import controller.ActionMenuController;
import controller.CustomerController;
import controller.SubscriptionController;
import controller.SystemController;
import data_control.SubscriptionPriceDAO;
import utilities.DateConverter;
import utilities.Language;
import utilities.PatternFilter;

import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class BuySubscriptionView extends JPanel {
	public JTextField txtPrijs;
	public JTextField txtBegindatum;
	public JComboBox cbbBeginstation;
	public JComboBox cbbEindstation;
	public JComboBox cbbType;
	public JComboBox cbbGeldigheid;
	public JTextField txtGebruiker;
	
	/**
	 * Create the panel.
	 */
	public BuySubscriptionView() {
		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		SpringLayout sl_contentPane = new SpringLayout();
		this.setLayout(sl_contentPane);
		
		JLabel lblAbonnementKopen = new JLabel(Language.getString("subtitle"));
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblAbonnementKopen, 10, SpringLayout.NORTH, this);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblAbonnementKopen, 20, SpringLayout.WEST, this);
		lblAbonnementKopen.setFont(new Font("Arial Black", Font.PLAIN, 17));
		this.add(lblAbonnementKopen);
		
		JLabel lblBeginstation = new JLabel(Language.getString("startstation"));
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblBeginstation, 33, SpringLayout.SOUTH, lblAbonnementKopen);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblBeginstation, 20, SpringLayout.WEST, this);
		add(lblBeginstation);
		
		JLabel lblEindstation = new JLabel(Language.getString("endstation"));
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblEindstation, 16, SpringLayout.SOUTH, lblBeginstation);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblEindstation, 0, SpringLayout.EAST, lblBeginstation);
		add(lblEindstation);
		
		cbbBeginstation = new JComboBox();
		sl_contentPane.putConstraint(SpringLayout.NORTH, cbbBeginstation, -3, SpringLayout.NORTH, lblBeginstation);
		sl_contentPane.putConstraint(SpringLayout.WEST, cbbBeginstation, 6, SpringLayout.EAST, lblBeginstation);
		sl_contentPane.putConstraint(SpringLayout.EAST, cbbBeginstation, 106, SpringLayout.EAST, lblBeginstation);
		cbbBeginstation.setModel(new DefaultComboBoxModel(SystemController.getStations()));
		add(cbbBeginstation);
		
		cbbEindstation = new JComboBox();
		sl_contentPane.putConstraint(SpringLayout.NORTH, cbbEindstation, -3, SpringLayout.NORTH, lblEindstation);
		sl_contentPane.putConstraint(SpringLayout.WEST, cbbEindstation, 6, SpringLayout.EAST, lblEindstation);
		sl_contentPane.putConstraint(SpringLayout.EAST, cbbEindstation, 106, SpringLayout.EAST, lblEindstation);
		cbbEindstation.setModel(new DefaultComboBoxModel(SystemController.getStations()));
		add(cbbEindstation);
		
		JLabel lblGeldigheid = new JLabel(Language.getString("validity"));
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblGeldigheid, 0, SpringLayout.NORTH, lblEindstation);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblGeldigheid, 30, SpringLayout.EAST, cbbEindstation);
		add(lblGeldigheid);
		
		JLabel lblTypeAbonnement = new JLabel(Language.getString("subtype"));
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblTypeAbonnement, 16, SpringLayout.SOUTH, lblEindstation);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblTypeAbonnement, 0, SpringLayout.EAST, lblBeginstation);
		add(lblTypeAbonnement);
		
		cbbType = new JComboBox();
		cbbType.setModel(new DefaultComboBoxModel(SubscriptionPriceDAO.getAllSubTypes().toArray())); // new String[] {"Standaard", "Student"})
		sl_contentPane.putConstraint(SpringLayout.WEST, cbbType, 0, SpringLayout.WEST, cbbBeginstation);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, cbbType, 0, SpringLayout.SOUTH, lblTypeAbonnement);
		sl_contentPane.putConstraint(SpringLayout.EAST, cbbType, 106, SpringLayout.EAST, lblTypeAbonnement);
		add(cbbType);
		
		JButton btnOfferte = new JButton(Language.getString("priceoffer"));
		btnOfferte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SubscriptionController.calculatePrice();
			}
		});
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnOfferte, 51, SpringLayout.SOUTH, cbbType);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnOfferte, 0, SpringLayout.EAST, cbbBeginstation);
		add(btnOfferte);
		
		JButton btnKoopTicket = new JButton(Language.getString("buysub"));
		btnKoopTicket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (checkTextFields())
					SubscriptionController.buySubscription();
			}
		});
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnKoopTicket, 13, SpringLayout.SOUTH, btnOfferte);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnKoopTicket, 0, SpringLayout.EAST, cbbBeginstation);
		add(btnKoopTicket);
		
		txtPrijs = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.WEST, txtPrijs, 0, SpringLayout.WEST, lblGeldigheid);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, txtPrijs, 0, SpringLayout.SOUTH, btnOfferte);
		add(txtPrijs);
		txtPrijs.setColumns(10);
		txtPrijs.setEditable(false);
		
		JLabel lblPrijs = new JLabel(Language.getString("price"));
		sl_contentPane.putConstraint(SpringLayout.WEST, lblPrijs, 0, SpringLayout.WEST, lblGeldigheid);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblPrijs, -6, SpringLayout.NORTH, txtPrijs);
		add(lblPrijs);
		
		txtBegindatum = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, txtBegindatum, -3, SpringLayout.NORTH, lblBeginstation);
		sl_contentPane.putConstraint(SpringLayout.EAST, txtBegindatum, -69, SpringLayout.EAST, this);
		txtBegindatum.setText(DateConverter.getDate());
		((AbstractDocument) txtBegindatum.getDocument()).setDocumentFilter(PatternFilter.datumFilter);
		add(txtBegindatum);
		txtBegindatum.setColumns(10);
		
		JLabel lblBegindatum = new JLabel(Language.getString("startdate"));
		sl_contentPane.putConstraint(SpringLayout.WEST, txtBegindatum, 6, SpringLayout.EAST, lblBegindatum);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblBegindatum, 0, SpringLayout.SOUTH, lblBeginstation);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblBegindatum, 0, SpringLayout.EAST, lblGeldigheid);
		add(lblBegindatum);
		
		cbbGeldigheid = new JComboBox();
		cbbGeldigheid.setModel(new DefaultComboBoxModel(SubscriptionPriceDAO.getLengthsForType((String) cbbType.getSelectedItem()).toArray())); // new String[] {"1 maand", "2 maanden", "3 maanden", "6 maanden", "1 jaar"}
		sl_contentPane.putConstraint(SpringLayout.WEST, cbbGeldigheid, 6, SpringLayout.EAST, lblGeldigheid);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, cbbGeldigheid, 0, SpringLayout.SOUTH, lblEindstation);
		add(cbbGeldigheid);
		
		JLabel lblMaand = new JLabel(Language.getString("month"));
		sl_contentPane.putConstraint(SpringLayout.WEST, lblMaand, 6, SpringLayout.EAST, cbbGeldigheid);
		sl_contentPane.putConstraint(SpringLayout.VERTICAL_CENTER, lblMaand, 0, SpringLayout.VERTICAL_CENTER, lblEindstation);
		add(lblMaand);
		
		JButton btnTerugNaarMenu = new JButton(Language.getString("return"));
		btnTerugNaarMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ActionMenuController.switchToActionMenuView();
			}
		});
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnTerugNaarMenu, 5, SpringLayout.SOUTH, btnKoopTicket);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnTerugNaarMenu, 10, SpringLayout.WEST, this);
		add(btnTerugNaarMenu);
		
		JLabel lblGebruiker = new JLabel(Language.getString("user"));
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblGebruiker, 0, SpringLayout.SOUTH, lblTypeAbonnement);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblGebruiker, 0, SpringLayout.EAST, lblGeldigheid);
		add(lblGebruiker);
		
		txtGebruiker = new JTextField();
		txtGebruiker.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				CustomerController.switchToFindCustomerView();
				
			}
		});
		sl_contentPane.putConstraint(SpringLayout.WEST, txtGebruiker, 0, SpringLayout.WEST, txtBegindatum);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, txtGebruiker, 0, SpringLayout.SOUTH, lblTypeAbonnement);
		sl_contentPane.putConstraint(SpringLayout.EAST, txtGebruiker, 0, SpringLayout.EAST, txtBegindatum);
		add(txtGebruiker);
		txtGebruiker.setColumns(10);
		
		cbbType.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent event) {
				if (event.getStateChange() == ItemEvent.SELECTED) {
					cbbGeldigheid.setModel(new DefaultComboBoxModel(SubscriptionPriceDAO.getLengthsForType((String) event.getItem()).toArray()));
				}
			}
		});
		
		cbbGeldigheid.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent event) {
				if (event.getStateChange() == ItemEvent.SELECTED) {
					if (event.getItem().toString().equals("1.0"))
						lblMaand.setText(Language.getString("month"));
					else 
						lblMaand.setText(Language.getString("months"));
				}
			}
		});
	}
	
	public boolean checkTextFields() {
		boolean check = true;
		
		if (!checkDatum())
		{
			txtBegindatum.setBackground(Color.RED);
			check = false;
		}
		else
			txtBegindatum.setBackground(Color.WHITE);
		
		return check;
	}
	
	public boolean checkDatum() {
		if (txtBegindatum.getText().equals("") || txtBegindatum.getText().length() != 10)
			return false;
		
		String day = txtBegindatum.getText().substring(0, 2);
		if(toInteger(day) > 31 || toInteger(day) < 1)
			return false;
		
		if (!txtBegindatum.getText().substring(2, 3).equals("/"))
			return false;
		
		String month = txtBegindatum.getText().substring(3, 5);
		if(toInteger(month) > 12 || toInteger(month) < 1)
			return false;
		
		if (!txtBegindatum.getText().substring(5, 6).equals("/"))
			return false;
		
		String year = txtBegindatum.getText().substring(6, 10);
		if(toInteger(year) < 1)
			return false;
		
		return true;
	}
	
	public int toInteger(String s) {
		try {
			return Integer.parseInt(s);
		}
		catch(Exception e) {
			return -1;
		}
	}
}