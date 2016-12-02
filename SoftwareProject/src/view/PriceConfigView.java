package view;

import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.text.AbstractDocument;

import controller.ConfigurationController;
import data_control.PriceDAO;
import data_control.SubscriptionPriceDAO;
import model.Price;
import model.Price.betalingsType;
import model.SubscriptionPrice;
import utilities.PatternFilter;

import javax.swing.JScrollPane;
import javax.swing.JTextField;

import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DecimalFormat;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;

public class PriceConfigView extends JPanel {
	public final String EURO = "\u20ac";
	
	private JTextField txtSoort;
	private JTextField txtPrijs;
	private int index = 0;
	private ArrayList<Price> priceList;
	private String defaultTxt = "Naam van het nieuw soort biljet";
	private JComboBox comboBox_type;
	private JComboBox comboBox_soort;
	private JButton btnDelete;
	
	private JTextField sub_txtSoort;
	private JTextField sub_txtPrijs;
	private int sub_index = 0;
	private ArrayList<SubscriptionPrice> sub_priceList;
	private String sub_defaultTxt = "Naam van het nieuw soort abonnement";
	private JComboBox cbb_maandenVoegToe;
	private JComboBox sub_comboBox_type;
	private JComboBox sub_comboBox_soort;
	private JComboBox sub_comboBox_maanden;
	private JButton sub_btnDelete;

	/**
	 * Create the panel.
	 */
	public PriceConfigView() {
		priceList = PriceDAO.getAll();
		sub_priceList = SubscriptionPriceDAO.getAllSubPrices();
		
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		
		JLabel lblPrijsConfiguratie = new JLabel("Prijs configuratie");
		springLayout.putConstraint(SpringLayout.NORTH, lblPrijsConfiguratie, 10, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, lblPrijsConfiguratie, 20, SpringLayout.WEST, this);
		lblPrijsConfiguratie.setFont(new Font("Arial Black", Font.PLAIN, 17));
		add(lblPrijsConfiguratie);
		
		JLabel lblTicketten = new JLabel("Ticketten");
		springLayout.putConstraint(SpringLayout.NORTH, lblTicketten, 10, SpringLayout.SOUTH, lblPrijsConfiguratie);
		springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, lblTicketten, 0, SpringLayout.HORIZONTAL_CENTER, this);
		lblTicketten.setFont(new Font("Arial Black", Font.PLAIN, 13));
		add(lblTicketten);
		
		JLabel lblNieuwSoortBiljet = new JLabel("Nieuw soort biljet toevoegen");
		springLayout.putConstraint(SpringLayout.NORTH, lblNieuwSoortBiljet, 20, SpringLayout.SOUTH, lblTicketten);
		springLayout.putConstraint(SpringLayout.WEST, lblNieuwSoortBiljet, 10, SpringLayout.WEST, this);
		add(lblNieuwSoortBiljet);
		
		txtSoort = new JTextField();
		txtSoort.setText(defaultTxt);
		txtSoort.setForeground(Color.LIGHT_GRAY);
		txtSoort.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtSoort.getText().equals(defaultTxt))
				{
					txtSoort.setText("");
					txtSoort.setForeground(null);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (txtSoort.getText().equals(""))
				{
					txtSoort.setForeground(Color.LIGHT_GRAY);
					txtSoort.setText(defaultTxt);
				}
			}
		});

		springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, txtSoort, 0, SpringLayout.VERTICAL_CENTER, lblNieuwSoortBiljet);
		springLayout.putConstraint(SpringLayout.WEST, txtSoort, 14, SpringLayout.EAST, lblNieuwSoortBiljet);
		add(txtSoort);
		txtSoort.setColumns(10);
		
		JButton btnVoegToe = new JButton("Voeg toe");
		springLayout.putConstraint(SpringLayout.EAST, txtSoort, -6, SpringLayout.WEST, btnVoegToe);
		springLayout.putConstraint(SpringLayout.NORTH, btnVoegToe, -5, SpringLayout.NORTH, lblNieuwSoortBiljet);
		springLayout.putConstraint(SpringLayout.EAST, btnVoegToe, -10, SpringLayout.EAST, this);
		add(btnVoegToe);
		
		comboBox_soort = new JComboBox();
		springLayout.putConstraint(SpringLayout.WEST, comboBox_soort, 0, SpringLayout.WEST, lblNieuwSoortBiljet);
		springLayout.putConstraint(SpringLayout.NORTH, comboBox_soort, 25, SpringLayout.SOUTH, lblNieuwSoortBiljet);
		comboBox_soort.setModel(new DefaultComboBoxModel(priceList.toArray()));
		comboBox_soort.setSelectedItem(priceList.get(index));
		add(comboBox_soort);
		
		JLabel lblEuro = new JLabel(EURO);
		springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, lblEuro, 0, SpringLayout.VERTICAL_CENTER, comboBox_soort);
		springLayout.putConstraint(SpringLayout.WEST, lblEuro, 6, SpringLayout.EAST, comboBox_soort);
		add(lblEuro);
		
		txtPrijs = new JTextField();
		springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, txtPrijs, 0, SpringLayout.VERTICAL_CENTER, comboBox_soort);
		springLayout.putConstraint(SpringLayout.WEST, txtPrijs, 6, SpringLayout.EAST, lblEuro);
		txtPrijs.setText(Double.toString(priceList.get(index).getCostPerUnit()));
		txtPrijs.setColumns(4);
		((AbstractDocument) txtPrijs.getDocument()).setDocumentFilter(PatternFilter.prijsFilter);
		add(txtPrijs);
		
		JLabel lblPer = new JLabel("per");
		springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, lblPer, 0, SpringLayout.VERTICAL_CENTER, comboBox_soort);
		springLayout.putConstraint(SpringLayout.WEST, lblPer, 6, SpringLayout.EAST, txtPrijs);
		add(lblPer);
		
		comboBox_type = new JComboBox();
		springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, comboBox_type, 0, SpringLayout.VERTICAL_CENTER, comboBox_soort);
		springLayout.putConstraint(SpringLayout.WEST, comboBox_type, 6, SpringLayout.EAST, lblPer);
		comboBox_type.setModel(new DefaultComboBoxModel(betalingsType.values()));
		comboBox_type.setSelectedItem(priceList.get(index).getTypeBetaling());
		add(comboBox_type);
		
		btnDelete = new JButton("VERWIJDER");
		btnDelete.setForeground(Color.RED);
		springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, btnDelete, 0, SpringLayout.VERTICAL_CENTER, comboBox_soort);
		springLayout.putConstraint(SpringLayout.WEST, btnDelete, 6, SpringLayout.EAST, comboBox_type);
		add(btnDelete);
		
		JSeparator sep = new JSeparator(SwingConstants.HORIZONTAL);
		springLayout.putConstraint(SpringLayout.NORTH, sep, 25, SpringLayout.SOUTH, btnDelete);
		springLayout.putConstraint(SpringLayout.WEST, sep, 25, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, sep, -25, SpringLayout.EAST, this);
		add(sep);
		
		JLabel lblAbonnementen = new JLabel("Abonnementen");
		springLayout.putConstraint(SpringLayout.NORTH, lblAbonnementen, 10, SpringLayout.SOUTH, sep);
		springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, lblAbonnementen, 0, SpringLayout.HORIZONTAL_CENTER, this);
		lblAbonnementen.setFont(new Font("Arial Black", Font.PLAIN, 13));
		add(lblAbonnementen);
		
		JLabel sub_lblNieuwSoortBiljet = new JLabel("Nieuw abonnement toevoegen");
		springLayout.putConstraint(SpringLayout.NORTH, sub_lblNieuwSoortBiljet, 20, SpringLayout.SOUTH, lblAbonnementen);
		springLayout.putConstraint(SpringLayout.WEST, sub_lblNieuwSoortBiljet, 10, SpringLayout.WEST, this);
		add(sub_lblNieuwSoortBiljet);
		
		sub_txtSoort = new JTextField();
		sub_txtSoort.setText(sub_defaultTxt);
		sub_txtSoort.setForeground(Color.LIGHT_GRAY);
		sub_txtSoort.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				if (sub_txtSoort.getText().equals(sub_defaultTxt))
				{
					sub_txtSoort.setText("");
					sub_txtSoort.setForeground(null);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (sub_txtSoort.getText().equals(""))
				{
					sub_txtSoort.setForeground(Color.LIGHT_GRAY);
					sub_txtSoort.setText(sub_defaultTxt);
				}
			}
		});

		springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, sub_txtSoort, 0, SpringLayout.VERTICAL_CENTER, sub_lblNieuwSoortBiljet);
		springLayout.putConstraint(SpringLayout.WEST, sub_txtSoort, 14, SpringLayout.EAST, sub_lblNieuwSoortBiljet);
		add(sub_txtSoort);
		sub_txtSoort.setColumns(10);
		
		cbb_maandenVoegToe = new JComboBox();
		springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, cbb_maandenVoegToe, 0, SpringLayout.VERTICAL_CENTER, sub_lblNieuwSoortBiljet);
		springLayout.putConstraint(SpringLayout.WEST, cbb_maandenVoegToe, 15, SpringLayout.EAST, sub_txtSoort);
		cbb_maandenVoegToe.setModel(new DefaultComboBoxModel(new String[] {"1", "3", "6", "12"}));
		add(cbb_maandenVoegToe);
		
		JLabel lblMaandVoegToe = new JLabel("maanden");
		springLayout.putConstraint(SpringLayout.WEST, lblMaandVoegToe, 6, SpringLayout.EAST, cbb_maandenVoegToe);
		springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, lblMaandVoegToe, 0, SpringLayout.VERTICAL_CENTER, sub_lblNieuwSoortBiljet);
		add(lblMaandVoegToe);
		
		JButton sub_btnVoegToe = new JButton("Voeg toe");
		//springLayout.putConstraint(SpringLayout.EAST, sub_txtSoort, -6, SpringLayout.WEST, sub_btnVoegToe);
		springLayout.putConstraint(SpringLayout.NORTH, sub_btnVoegToe, -5, SpringLayout.NORTH, sub_lblNieuwSoortBiljet);
		springLayout.putConstraint(SpringLayout.WEST, sub_btnVoegToe, 15, SpringLayout.EAST, lblMaandVoegToe);
		add(sub_btnVoegToe);
		 
		sub_comboBox_soort = new JComboBox();
		springLayout.putConstraint(SpringLayout.WEST, sub_comboBox_soort, 0, SpringLayout.WEST, sub_lblNieuwSoortBiljet);
		springLayout.putConstraint(SpringLayout.NORTH, sub_comboBox_soort, 25, SpringLayout.SOUTH, sub_lblNieuwSoortBiljet);
		sub_comboBox_soort.setModel(new DefaultComboBoxModel(sub_priceList.toArray()));
		sub_comboBox_soort.setSelectedItem(sub_priceList.get(sub_index));
		add(sub_comboBox_soort);
		
		JLabel sub_lblEuro = new JLabel(EURO);
		springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, sub_lblEuro, 0, SpringLayout.VERTICAL_CENTER, sub_comboBox_soort);
		springLayout.putConstraint(SpringLayout.WEST, sub_lblEuro, 6, SpringLayout.EAST, sub_comboBox_soort);
		add(sub_lblEuro);
		
		sub_txtPrijs = new JTextField();
		springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, sub_txtPrijs, 0, SpringLayout.VERTICAL_CENTER, sub_comboBox_soort);
		springLayout.putConstraint(SpringLayout.WEST, sub_txtPrijs, 6, SpringLayout.EAST, sub_lblEuro);
		sub_txtPrijs.setText(Double.toString(sub_priceList.get(sub_index).getLengthInMonths()));
		sub_txtPrijs.setColumns(4);
		((AbstractDocument) sub_txtPrijs.getDocument()).setDocumentFilter(PatternFilter.prijsFilter);
		add(sub_txtPrijs);
		
		JLabel sub_lblPer = new JLabel("per");
		springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, sub_lblPer, 0, SpringLayout.VERTICAL_CENTER, sub_comboBox_soort);
		springLayout.putConstraint(SpringLayout.WEST, sub_lblPer, 6, SpringLayout.EAST, sub_txtPrijs);
		add(sub_lblPer);
		
		sub_comboBox_type = new JComboBox();
		springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, sub_comboBox_type, 0, SpringLayout.VERTICAL_CENTER, sub_comboBox_soort);
		springLayout.putConstraint(SpringLayout.WEST, sub_comboBox_type, 6, SpringLayout.EAST, sub_lblPer);
		sub_comboBox_type.setModel(new DefaultComboBoxModel(betalingsType.values()));
		sub_comboBox_type.setSelectedItem(sub_priceList.get(sub_index).getTypeBetaling());
		add(sub_comboBox_type);
		
		JLabel sub_lblVoor = new JLabel("voor");
		springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, sub_lblVoor, 0, SpringLayout.VERTICAL_CENTER, sub_comboBox_soort);
		springLayout.putConstraint(SpringLayout.WEST, sub_lblVoor, 6, SpringLayout.EAST, sub_comboBox_type);
		add(sub_lblVoor);
		
		sub_comboBox_maanden = new JComboBox();
		springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, sub_comboBox_maanden, 0, SpringLayout.VERTICAL_CENTER, sub_comboBox_soort);
		springLayout.putConstraint(SpringLayout.WEST, sub_comboBox_maanden, 6, SpringLayout.EAST, sub_lblVoor);
		sub_comboBox_maanden.setModel(new DefaultComboBoxModel(SubscriptionPriceDAO.getLengthsForType(sub_comboBox_soort.getSelectedItem().toString()).toArray()));
		/*
		SubscriptionPriceDAO.getLengthsForType((String) sub_comboBox_soort.getSelectedItem()).toArray()
		SubscriptionPriceDAO.getLengthsForType((String) sub_comboBox_type.getSelectedItem()).toArray()
		*/
		add(sub_comboBox_maanden);
		
		JLabel lblMaand = new JLabel("maanden");
		springLayout.putConstraint(SpringLayout.WEST, lblMaand, 6, SpringLayout.EAST, sub_comboBox_maanden);
		springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, lblMaand, 0, SpringLayout.VERTICAL_CENTER, sub_comboBox_soort);
		add(lblMaand);
		
		sub_btnDelete = new JButton("VERWIJDER");
		sub_btnDelete.setForeground(Color.RED);
		springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, sub_btnDelete, 0, SpringLayout.VERTICAL_CENTER, sub_comboBox_soort);
		springLayout.putConstraint(SpringLayout.WEST, sub_btnDelete, 6, SpringLayout.EAST, lblMaand);
		add(sub_btnDelete);
		 
		JLabel lblInfo = new JLabel("");
		springLayout.putConstraint(SpringLayout.NORTH, lblInfo, 20, SpringLayout.SOUTH, sub_comboBox_soort);
		springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, lblInfo, 0, SpringLayout.HORIZONTAL_CENTER, this);
		add(lblInfo);
		
		JButton btnTerug = new JButton("<<  Terug");
		btnTerug.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConfigurationController.switchToConfigurationView();
			}
		});
		springLayout.putConstraint(SpringLayout.WEST, btnTerug, 0, SpringLayout.WEST, lblNieuwSoortBiljet);
		springLayout.putConstraint(SpringLayout.SOUTH, btnTerug, -10, SpringLayout.SOUTH, this);
		add(btnTerug);
		
		JButton btnOk = new JButton("Wijzig");
		springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, btnOk, 0, SpringLayout.HORIZONTAL_CENTER, this);
		springLayout.putConstraint(SpringLayout.SOUTH, btnOk, 0, SpringLayout.SOUTH, btnTerug);
		add(btnOk);
		
		btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ArrayList<String> options = new ArrayList<String>();
			    options.add("JA"); // 0
			    options.add("NEE"); // 1
				int choice = JOptionPane.showOptionDialog(null, "Bent u zeker dat u de prijs " + priceList.get(index).getTypeTicket() + " wilt verwijderen?", "Prijs verwijderen", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options.toArray(), "NEE");
				if (choice == 0) {
					ConfigurationController.deletePrice();
					updatePriceList(0);
					lblInfo.setText("Prijs verwijderd");
				}
				else 
					lblInfo.setText("");
			}
		});
		
		sub_btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ArrayList<String> options = new ArrayList<String>();
			    options.add("JA"); // 0
			    options.add("NEE"); // 1
				int choice = JOptionPane.showOptionDialog(null, "Bent u zeker dat u de prijs " + sub_priceList.get(sub_index).getTypeSubscription() + " wilt verwijderen?", "Prijs verwijderen", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options.toArray(), "NEE");
				if (choice == 0) {
					ConfigurationController.deleteSubPrice();
					updateSubPriceList(0);
					lblInfo.setText("Prijs verwijderd");
				}
				else 
					lblInfo.setText("");
			}
		});
		
		comboBox_soort.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent event) {
				if (event.getStateChange() == ItemEvent.SELECTED) {
					index = priceList.indexOf(event.getItem());
					comboBox_soort.setSelectedItem(priceList.get(index));
					txtPrijs.setText(Double.toString(priceList.get(index).getCostPerUnit()));
					comboBox_type.setSelectedItem(priceList.get(index).getTypeBetaling());
				}
			}
		});
		
		sub_comboBox_soort.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent event) {
				if (event.getStateChange() == ItemEvent.SELECTED) {
					sub_index = sub_priceList.indexOf(event.getItem());
					sub_comboBox_soort.setSelectedItem(sub_priceList.get(sub_index));
					sub_txtPrijs.setText(Double.toString(sub_priceList.get(sub_index).getCostPerUnit()));
					sub_comboBox_type.setSelectedItem(sub_priceList.get(sub_index).getTypeBetaling());
				}
			}
		});
		
		btnVoegToe.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {}
			@Override
			public void mousePressed(MouseEvent e) {
				lblInfo.setText("Even geduld ...");
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				ConfigurationController.createPrice();
				txtSoort.setForeground(Color.LIGHT_GRAY);
				txtSoort.setText(defaultTxt);
				updatePriceList(-1);
				lblInfo.setText("Ticket soort toegevoegd");
			}
			@Override
			public void mouseEntered(MouseEvent e) {}
			@Override
			public void mouseExited(MouseEvent e) {}
		});
		
		btnOk.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {}
			@Override
			public void mousePressed(MouseEvent e) {
				lblInfo.setText("Even geduld ...");
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				ConfigurationController.updatePrice();
				ConfigurationController.updateSubPrice();
				updatePriceList(index);
				updateSubPriceList(sub_index);
				lblInfo.setText("Prijs gewijzigd");
			}
			@Override
			public void mouseEntered(MouseEvent e) {}
			@Override
			public void mouseExited(MouseEvent e) {}
		});
	}
	
	/**
	 * Updates the array PriceList and shows the new info of price at index i (takes the latest index if i < 0)
	 */
	public void updatePriceList(int i) {
		priceList = PriceDAO.getAll(); // Refresh the list
		comboBox_soort.setModel(new DefaultComboBoxModel(priceList.toArray())); // Refresh the combobox
		index = (i < 0)?(priceList.size() - 1):i; // put index on latest item
		comboBox_soort.setSelectedItem(priceList.get(index));
		txtPrijs.setText(Double.toString(priceList.get(index).getCostPerUnit()));
		comboBox_type.setSelectedItem(priceList.get(index).getTypeBetaling());
	}
	
	public void updateSubPriceList(int i) {
		sub_priceList = SubscriptionPriceDAO.getAllSubPrices(); // Refresh the list
		sub_comboBox_soort.setModel(new DefaultComboBoxModel(sub_priceList.toArray())); // Refresh the combobox
		sub_index = (i < 0)?(sub_priceList.size() - 1):i; // put index on latest item
		sub_comboBox_soort.setSelectedItem(sub_priceList.get(sub_index));
		sub_txtPrijs.setText(Double.toString(sub_priceList.get(sub_index).getCostPerUnit()));
		sub_comboBox_type.setSelectedItem(sub_priceList.get(sub_index).getTypeBetaling());
	}
	
	public String getTxtSoort() {
		return txtSoort.getText();
	}
	
	public String getSubTxtSoort() {
		return sub_txtSoort.getText();
	}
	
	public Price getPrice() {
		return new Price(priceList.get(index).getId(),
				priceList.get(index).getTypeTicket(),
				betalingsType.stringToBetalingsType(comboBox_type.getSelectedItem().toString()),
				Double.valueOf(txtPrijs.getText()));
	}
	
	public SubscriptionPrice getSubscriptionPrice() {
		return new SubscriptionPrice(sub_priceList.get(sub_index).getId(),
				sub_priceList.get(sub_index).getTypeSubscription(),
				betalingsType.stringToBetalingsType(sub_comboBox_type.getSelectedItem().toString()),
				Double.valueOf(sub_txtPrijs.getText()),
				1.0);
	}
}