package view;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.border.EmptyBorder;
import javax.swing.text.AbstractDocument;

import controller.ActionMenuController;
import controller.SystemController;
import controller.TicketController;
import utilities.DateConverter;
import utilities.Language;
import utilities.PatternFilter;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class BuyTicketView extends JPanel {
	public JTextField txtDatum;
	public JTextField txtPrijs;
	public JComboBox cbbBeginstation;
	public JComboBox cbbEindstation;
	public JComboBox cbbType;
	public JCheckBox checkBox;
	private ArrayList<String> station_list = null;
	/**
	 * Create the panel.
	 */
	public BuyTicketView() {
		
		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		SpringLayout sl_contentPane = new SpringLayout();
		this.setLayout(sl_contentPane);
		
		JLabel lblTicketKopen = new JLabel(Language.getString("buytickettitle"));
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblTicketKopen, 10, SpringLayout.NORTH, this);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblTicketKopen, 20, SpringLayout.WEST, this);
		lblTicketKopen.setFont(new Font("Arial Black", Font.PLAIN, 17));
		this.add(lblTicketKopen);
		
		JLabel lblBeginstation = new JLabel(Language.getString("startstation"));
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblBeginstation, 33, SpringLayout.SOUTH, lblTicketKopen);
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
		
		JLabel lblDatum = new JLabel(Language.getString("date"));
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblDatum, 2, SpringLayout.NORTH, lblEindstation);
		add(lblDatum);
		
		txtDatum = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, txtDatum, -3, SpringLayout.NORTH, lblEindstation);
		sl_contentPane.putConstraint(SpringLayout.WEST, txtDatum, 6, SpringLayout.EAST, lblDatum);
		sl_contentPane.putConstraint(SpringLayout.EAST, txtDatum, 106, SpringLayout.EAST, lblDatum);
		txtDatum.setText(DateConverter.getDate());
		((AbstractDocument) txtDatum.getDocument()).setDocumentFilter(PatternFilter.datumFilter);
		add(txtDatum);
		txtDatum.setColumns(10);
		
		JLabel lblHeenenterugreis = new JLabel(Language.getString("returnjourney"));
		sl_contentPane.putConstraint(SpringLayout.WEST, lblDatum, 0, SpringLayout.WEST, lblHeenenterugreis);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblHeenenterugreis, 30, SpringLayout.EAST, cbbBeginstation);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblHeenenterugreis, 3, SpringLayout.SOUTH, lblBeginstation);
		add(lblHeenenterugreis);
		
		checkBox = new JCheckBox("");
		sl_contentPane.putConstraint(SpringLayout.SOUTH, checkBox, 0, SpringLayout.SOUTH, cbbBeginstation);
		sl_contentPane.putConstraint(SpringLayout.EAST, checkBox, 0, SpringLayout.EAST, txtDatum);
		add(checkBox);
		
		JLabel lblTypeTicket = new JLabel(Language.getString("tickettype"));
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblTypeTicket, 16, SpringLayout.SOUTH, lblEindstation);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblTypeTicket, 0, SpringLayout.EAST, lblBeginstation);
		add(lblTypeTicket);
		
		cbbType = new JComboBox();
		cbbType.setModel(new DefaultComboBoxModel(new String[] {Language.getString("standard"), Language.getString("weekend")}));
		sl_contentPane.putConstraint(SpringLayout.WEST, cbbType, 0, SpringLayout.WEST, cbbBeginstation);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, cbbType, 9, SpringLayout.SOUTH, lblTypeTicket);
		sl_contentPane.putConstraint(SpringLayout.EAST, cbbType, 106, SpringLayout.EAST, lblTypeTicket);
		add(cbbType);
		
		JButton btnOfferte = new JButton(Language.getString("priceoffer"));
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnOfferte, 25, SpringLayout.SOUTH, cbbType);
		btnOfferte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TicketController.calculatePrice();
			}
		});
		sl_contentPane.putConstraint(SpringLayout.EAST, btnOfferte, 0, SpringLayout.EAST, cbbBeginstation);
		add(btnOfferte);
		
		JButton btnKoopTicket = new JButton(Language.getString("buyticket"));
		btnKoopTicket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TicketController.buyTicket();
			}
		});
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnKoopTicket, 13, SpringLayout.SOUTH, btnOfferte);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnKoopTicket, 0, SpringLayout.EAST, cbbBeginstation);
		add(btnKoopTicket);
		
		txtPrijs = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.WEST, txtPrijs, 0, SpringLayout.WEST, lblDatum);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, txtPrijs, -55, SpringLayout.SOUTH, btnOfferte);
		add(txtPrijs);
		txtPrijs.setColumns(10);
		txtPrijs.setEditable(false);
		
		JLabel lblPrijs = new JLabel(Language.getString("price"));
		sl_contentPane.putConstraint(SpringLayout.WEST, lblPrijs, 0, SpringLayout.WEST, lblDatum);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblPrijs, -35, SpringLayout.NORTH, txtPrijs);
		add(lblPrijs);
		
		JButton btnTerugNaarMenu = new JButton(Language.getString("return"));
		sl_contentPane.putConstraint(SpringLayout.WEST, btnTerugNaarMenu, 5, SpringLayout.WEST, this);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnTerugNaarMenu, -5, SpringLayout.SOUTH, this);
		btnTerugNaarMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ActionMenuController.switchToActionMenuView();
			}
		});
		add(btnTerugNaarMenu);

	}
}
