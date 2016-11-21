package view;

import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.text.AbstractDocument;
import javax.swing.text.DateFormatter;

import controller.ActionMenuController;
import controller.RouteController;
import utilities.DateConverter;
import utilities.PatternFilter;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;

public class SearchRouteView extends JPanel {
	public JComboBox cbbVan;
	public JComboBox cbbTot;
	public JCheckBox chckbxHeenterug;
	public JRadioButton rdbtnVertrek;
	public JRadioButton rdbtnAankomst;
	public JTextField txtUur;
	public JTextField txtDatum;
	
	
	
	/**
	 * Create the panel.
	 */
	public SearchRouteView() {
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		
		JLabel lblRoutevinder = new JLabel("Routevinder");
		springLayout.putConstraint(SpringLayout.NORTH, lblRoutevinder, 10, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, lblRoutevinder, 20, SpringLayout.WEST, this);
		lblRoutevinder.setFont(new Font("Arial Black", Font.PLAIN, 17));
		this.add(lblRoutevinder);
		
		JLabel lblVan = new JLabel("Van");
		springLayout.putConstraint(SpringLayout.WEST, lblVan, 10, SpringLayout.WEST, this);
		add(lblVan);
		
		//textField = new JTextField();
		cbbVan = new JComboBox();
		springLayout.putConstraint(SpringLayout.NORTH, cbbVan, 61, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, cbbVan, 27, SpringLayout.EAST, lblVan);
		springLayout.putConstraint(SpringLayout.NORTH, lblVan, 5, SpringLayout.NORTH, cbbVan);
		cbbVan.setModel(new DefaultComboBoxModel(new String[] {"Aalst", "Aalst-Kerrebroek", "Aalter", "Aarschot", "Aarsele"}));
		add(cbbVan);
		//textField.setColumns(10);
		
		//textField_1 = new JTextField();
		cbbTot = new JComboBox();
		springLayout.putConstraint(SpringLayout.NORTH, cbbTot, 104, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, cbbTot, 0, SpringLayout.WEST, cbbVan);
		add(cbbTot);
		cbbTot.setModel(new DefaultComboBoxModel(new String[] {"Aalst", "Aalst-Kerrebroek", "Aalter", "Aarschot", "Aarsele"}));
		//textField_1.setColumns(10);
		
		JLabel lblTot = new JLabel("Tot");
		springLayout.putConstraint(SpringLayout.NORTH, lblTot, 5, SpringLayout.NORTH, cbbTot);
		springLayout.putConstraint(SpringLayout.WEST, lblTot, 0, SpringLayout.WEST, lblVan);
		add(lblTot);
		
		JLabel lblDatum = new JLabel("Datum (dd/mm/jjjj)");
		springLayout.putConstraint(SpringLayout.WEST, lblDatum, 10, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.NORTH, lblDatum, 31, SpringLayout.SOUTH, cbbTot);
		add(lblDatum);
		
		JLabel lblUur = new JLabel("Uur");
		springLayout.putConstraint(SpringLayout.WEST, lblUur, 10, SpringLayout.WEST, this);
		add(lblUur);
		
		rdbtnVertrek = new JRadioButton("Vertrek");
		springLayout.putConstraint(SpringLayout.NORTH, rdbtnVertrek, -4, SpringLayout.NORTH, lblUur);
		add(rdbtnVertrek);
		rdbtnVertrek.setSelected(true);
		
		rdbtnAankomst = new JRadioButton("Aankomst");
		springLayout.putConstraint(SpringLayout.NORTH, rdbtnAankomst, -4, SpringLayout.NORTH, lblUur);
		springLayout.putConstraint(SpringLayout.WEST, rdbtnAankomst, 19, SpringLayout.EAST, rdbtnVertrek);
		add(rdbtnAankomst);
		
		ButtonGroup groupAankomstVertrek = new ButtonGroup();
	    groupAankomstVertrek.add(rdbtnVertrek);
	    groupAankomstVertrek.add(rdbtnAankomst);
		
		JButton btnTerug = new JButton("Terug");
		btnTerug.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ActionMenuController.switchToActionMenuView();
			}
		});
		springLayout.putConstraint(SpringLayout.WEST, btnTerug, 10, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, rdbtnAankomst, -22, SpringLayout.NORTH, btnTerug);
		springLayout.putConstraint(SpringLayout.SOUTH, rdbtnVertrek, -22, SpringLayout.NORTH, btnTerug);
		springLayout.putConstraint(SpringLayout.SOUTH, lblUur, -25, SpringLayout.NORTH, btnTerug);
		springLayout.putConstraint(SpringLayout.SOUTH, btnTerug, -10, SpringLayout.SOUTH, this);
		add(btnTerug);
		
		JButton btnZoek = new JButton("Zoek");
		btnZoek.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RouteController.findRoute();
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, btnZoek, 0, SpringLayout.NORTH, btnTerug);
		springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, btnZoek, 0, SpringLayout.HORIZONTAL_CENTER, this);
		add(btnZoek);
		
		txtUur = new JTextField();
		springLayout.putConstraint(SpringLayout.WEST, txtUur, 28, SpringLayout.EAST, lblUur);
		springLayout.putConstraint(SpringLayout.SOUTH, txtUur, -20, SpringLayout.NORTH, btnTerug);
		springLayout.putConstraint(SpringLayout.WEST, rdbtnVertrek, 30, SpringLayout.EAST, txtUur);
		txtUur.setText(DateConverter.getTime());
		((AbstractDocument) txtUur.getDocument()).setDocumentFilter(PatternFilter.uurFilter);
		add(txtUur);
		
		txtDatum = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, txtDatum, -5, SpringLayout.NORTH, lblDatum);
		springLayout.putConstraint(SpringLayout.WEST, txtDatum, 41, SpringLayout.EAST, lblDatum);
		txtDatum.setText(DateConverter.getDate());
		((AbstractDocument) txtDatum.getDocument()).setDocumentFilter(PatternFilter.datumFilter);
		add(txtDatum);
		
		chckbxHeenterug = new JCheckBox("Heen-terug");
		springLayout.putConstraint(SpringLayout.WEST, chckbxHeenterug, 0, SpringLayout.WEST, rdbtnAankomst);
		springLayout.putConstraint(SpringLayout.SOUTH, chckbxHeenterug, 0, SpringLayout.SOUTH, lblVan);
		add(chckbxHeenterug);
	}
}
