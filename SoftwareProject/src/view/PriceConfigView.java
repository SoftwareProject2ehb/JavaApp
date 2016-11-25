package view;

import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SpringLayout;

import controller.ConfigurationController;
import data_control.PriceDAO;
import model.Price;
import model.Price.betalingsType;

import javax.swing.JScrollPane;
import javax.swing.JTextField;

import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.DecimalFormat;
import java.awt.Color;
import java.awt.event.ActionEvent;

public class PriceConfigView extends JPanel {
	private JTextField txtNaam;
	private JTextField txtPrijs;
	public int index;

	/**
	 * Create the panel.
	 */
	public PriceConfigView() {
		ArrayList<Price> priceList = PriceDAO.getAll();
		DecimalFormat df = new DecimalFormat("00.00"); 
		
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		
		JLabel lblPrijsConfiguratie = new JLabel("Prijs configuratie");
		springLayout.putConstraint(SpringLayout.NORTH, lblPrijsConfiguratie, 10, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, lblPrijsConfiguratie, 0, SpringLayout.HORIZONTAL_CENTER, this);
		add(lblPrijsConfiguratie);
		
		JLabel lblNieuwSoortBiljet = new JLabel("Nieuw soort biljet toevoegen");
		springLayout.putConstraint(SpringLayout.NORTH, lblNieuwSoortBiljet, 43, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, lblNieuwSoortBiljet, 10, SpringLayout.WEST, this);
		add(lblNieuwSoortBiljet);
		
		txtNaam = new JTextField();
		String defaultTxt = "Vul de soort van het biljet in.";
		txtNaam.setText(defaultTxt);
		txtNaam.setForeground(Color.LIGHT_GRAY);
		txtNaam.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtNaam.getText().equals(defaultTxt))
				{
					txtNaam.setText("");
					txtNaam.setForeground(null);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (txtNaam.getText().equals(""))
				{
					txtNaam.setForeground(Color.LIGHT_GRAY);
					txtNaam.setText(defaultTxt);
				}
			}
		});

		springLayout.putConstraint(SpringLayout.NORTH, txtNaam, 12, SpringLayout.SOUTH, lblPrijsConfiguratie);
		springLayout.putConstraint(SpringLayout.WEST, txtNaam, 14, SpringLayout.EAST, lblNieuwSoortBiljet);
		add(txtNaam);
		txtNaam.setColumns(10);
		
		JButton btnVoegToe = new JButton("Voeg toe");
		springLayout.putConstraint(SpringLayout.EAST, txtNaam, -6, SpringLayout.WEST, btnVoegToe);
		springLayout.putConstraint(SpringLayout.NORTH, btnVoegToe, -5, SpringLayout.NORTH, lblNieuwSoortBiljet);
		springLayout.putConstraint(SpringLayout.EAST, btnVoegToe, -10, SpringLayout.EAST, this);
		add(btnVoegToe);
		
		JButton btnTerug = new JButton("<<  Terug");
		btnTerug.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConfigurationController.switchToConfigurationView();
			}
		});
		springLayout.putConstraint(SpringLayout.WEST, btnTerug, 0, SpringLayout.WEST, lblNieuwSoortBiljet);
		springLayout.putConstraint(SpringLayout.SOUTH, btnTerug, -10, SpringLayout.SOUTH, this);
		add(btnTerug);
		
		JButton btnOk = new JButton("OK");
		springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, btnOk, 0, SpringLayout.HORIZONTAL_CENTER, this);
		springLayout.putConstraint(SpringLayout.SOUTH, btnOk, 0, SpringLayout.SOUTH, btnTerug);
		add(btnOk);
		
		JComboBox comboBox_soort = new JComboBox();
		springLayout.putConstraint(SpringLayout.WEST, comboBox_soort, 0, SpringLayout.WEST, lblNieuwSoortBiljet);
		springLayout.putConstraint(SpringLayout.SOUTH, comboBox_soort, 107, SpringLayout.NORTH, lblNieuwSoortBiljet);
		comboBox_soort.setModel(new DefaultComboBoxModel(priceList.toArray()));
		comboBox_soort.setSelectedItem(priceList.get(index));
		add(comboBox_soort);
		
		JLabel lblEuro = new JLabel("€");
		springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, lblEuro, 0, SpringLayout.VERTICAL_CENTER, comboBox_soort);
		springLayout.putConstraint(SpringLayout.WEST, lblEuro, 6, SpringLayout.EAST, comboBox_soort);
		add(lblEuro);
		
		txtPrijs = new JTextField();
		springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, txtPrijs, 0, SpringLayout.VERTICAL_CENTER, comboBox_soort);
		springLayout.putConstraint(SpringLayout.WEST, txtPrijs, 6, SpringLayout.EAST, lblEuro);
		txtPrijs.setText(df.format(priceList.get(index).getCostPerUnit()));
		add(txtPrijs);
		
		JLabel lblPer = new JLabel("per");
		springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, lblPer, 0, SpringLayout.VERTICAL_CENTER, comboBox_soort);
		springLayout.putConstraint(SpringLayout.WEST, lblPer, 6, SpringLayout.EAST, txtPrijs);
		add(lblPer);
		
		JComboBox comboBox_type = new JComboBox();
		springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, comboBox_type, 0, SpringLayout.VERTICAL_CENTER, comboBox_soort);
		springLayout.putConstraint(SpringLayout.WEST, comboBox_type, 6, SpringLayout.EAST, lblPer);
		comboBox_type.setModel(new DefaultComboBoxModel(betalingsType.values()));
		comboBox_type.setSelectedItem(priceList.get(index).getTypeBetaling());
		add(comboBox_type);
		
		comboBox_soort.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent event) {
				if (event.getStateChange() == ItemEvent.SELECTED) {
					index = priceList.indexOf(event.getItem());
					comboBox_soort.setSelectedItem(priceList.get(index));
					txtPrijs.setText(df.format(priceList.get(index).getCostPerUnit()));
					comboBox_type.setSelectedItem(priceList.get(index).getTypeBetaling());
				}
			}
		});
	}
}