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
import java.awt.event.ActionEvent;

public class PriceConfigView extends JPanel {
	private JTextField txtNaam;

	/**
	 * Create the panel.
	 */
	public PriceConfigView() {
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
		springLayout.putConstraint(SpringLayout.NORTH, txtNaam, 12, SpringLayout.SOUTH, lblPrijsConfiguratie);
		springLayout.putConstraint(SpringLayout.WEST, txtNaam, 14, SpringLayout.EAST, lblNieuwSoortBiljet);
		txtNaam.setText("soort biljet");
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
		
		ArrayList<Price> list = PriceDAO.getAll();
		int offset;
		int begin = 100;
		for (int i = 0; i < list.size(); i++) {
			offset = i * 40;
			JLabel lblTypeBiljet = new JLabel(list.get(i).getTypeTicket());
			springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, lblTypeBiljet, begin + offset, SpringLayout.NORTH, this);
			springLayout.putConstraint(SpringLayout.WEST, lblTypeBiljet, 10, SpringLayout.WEST, this);
			add(lblTypeBiljet);

			JFormattedTextField formattedTextField = new JFormattedTextField();
			springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, formattedTextField, begin + offset, SpringLayout.NORTH, this);
			springLayout.putConstraint(SpringLayout.WEST, formattedTextField, 20, SpringLayout.EAST, lblTypeBiljet);
			formattedTextField.setText(Double.toString(list.get(i).getCostPerUnit()));
			add(formattedTextField);

			JLabel lblPer = new JLabel("per");
			springLayout.putConstraint(SpringLayout.WEST, lblPer, 26, SpringLayout.EAST, formattedTextField);
			springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, lblPer, begin + offset, SpringLayout.NORTH, this);
			add(lblPer);

			JComboBox comboBox = new JComboBox();
			springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, comboBox, begin + offset, SpringLayout.NORTH, this);
			springLayout.putConstraint(SpringLayout.WEST, comboBox, 22, SpringLayout.EAST, lblPer);
			comboBox.setModel(new DefaultComboBoxModel(betalingsType.values()));
			comboBox.setSelectedItem(list.get(i).getTypeBetaling());
			add(comboBox);
		}
	}
	
	public static void run() {
	      JPanel p = new PriceConfigView();
	       
	      JFrame f = new JFrame();
	      f.getContentPane().add(p);
	      f.setVisible(true);
	      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      f.setSize(450, 300);
	      f.setResizable(false);
	      f.setLocationRelativeTo(null);
	  }
}
