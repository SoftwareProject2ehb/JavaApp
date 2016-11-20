package view;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.border.EmptyBorder;

import controller.ActionMenuController;

import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BuyTicketView extends JPanel {
	private JTextField textField;
	private JTextField txtPrijs;
	
	/**
	 * Create the panel.
	 */
	public BuyTicketView() {
		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		SpringLayout sl_contentPane = new SpringLayout();
		this.setLayout(sl_contentPane);
		
		JLabel lblTicketKopen = new JLabel("Ticket Kopen");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblTicketKopen, 10, SpringLayout.NORTH, this);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblTicketKopen, 20, SpringLayout.WEST, this);
		lblTicketKopen.setFont(new Font("Arial Black", Font.PLAIN, 17));
		this.add(lblTicketKopen);
		
		JLabel lblBeginstation = new JLabel("Beginstation");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblBeginstation, 33, SpringLayout.SOUTH, lblTicketKopen);
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
		
		JLabel lblDatum = new JLabel("Datum");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblDatum, 0, SpringLayout.NORTH, lblEindstation);
		add(lblDatum);
		
		textField = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, textField, -3, SpringLayout.NORTH, lblEindstation);
		sl_contentPane.putConstraint(SpringLayout.WEST, textField, 6, SpringLayout.EAST, lblDatum);
		sl_contentPane.putConstraint(SpringLayout.EAST, textField, 106, SpringLayout.EAST, lblDatum);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblHeenenterugreis = new JLabel("Heen-en-terugreis");
		sl_contentPane.putConstraint(SpringLayout.WEST, lblDatum, 0, SpringLayout.WEST, lblHeenenterugreis);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblHeenenterugreis, 30, SpringLayout.EAST, comboBox);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblHeenenterugreis, 0, SpringLayout.SOUTH, lblBeginstation);
		add(lblHeenenterugreis);
		
		JCheckBox checkBox = new JCheckBox("");
		sl_contentPane.putConstraint(SpringLayout.SOUTH, checkBox, 0, SpringLayout.SOUTH, comboBox);
		sl_contentPane.putConstraint(SpringLayout.EAST, checkBox, 0, SpringLayout.EAST, textField);
		add(checkBox);
		
		JLabel lblTypeTicket = new JLabel("Type ticket");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblTypeTicket, 16, SpringLayout.SOUTH, lblEindstation);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblTypeTicket, 0, SpringLayout.EAST, lblBeginstation);
		add(lblTypeTicket);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"Type 1"}));
		sl_contentPane.putConstraint(SpringLayout.WEST, comboBox_2, 0, SpringLayout.WEST, comboBox);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, comboBox_2, 0, SpringLayout.SOUTH, lblTypeTicket);
		sl_contentPane.putConstraint(SpringLayout.EAST, comboBox_2, 106, SpringLayout.EAST, lblTypeTicket);
		add(comboBox_2);
		
		JButton btnOfferte = new JButton("Offerte");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnOfferte, 51, SpringLayout.SOUTH, comboBox_2);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnOfferte, 0, SpringLayout.EAST, comboBox);
		add(btnOfferte);
		
		JButton btnKoopTicket = new JButton("Koop Ticket");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnKoopTicket, 13, SpringLayout.SOUTH, btnOfferte);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnKoopTicket, 0, SpringLayout.EAST, comboBox);
		add(btnKoopTicket);
		
		txtPrijs = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.WEST, txtPrijs, 0, SpringLayout.WEST, lblDatum);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, txtPrijs, 0, SpringLayout.SOUTH, btnOfferte);
		add(txtPrijs);
		txtPrijs.setColumns(10);
		
		JLabel lblPrijs = new JLabel("Prijs");
		sl_contentPane.putConstraint(SpringLayout.WEST, lblPrijs, 0, SpringLayout.WEST, lblDatum);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblPrijs, -6, SpringLayout.NORTH, txtPrijs);
		add(lblPrijs);
		
		JButton button = new JButton("<<  Terug");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ActionMenuController.switchToActionMenuView();
			}
		});
		sl_contentPane.putConstraint(SpringLayout.WEST, button, 10, SpringLayout.WEST, this);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, button, -10, SpringLayout.SOUTH, this);
		add(button);

	}
}
