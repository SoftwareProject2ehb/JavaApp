package view;

import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;

import java.awt.Dimension;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;

public class SearchRouteView extends JPanel {
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the panel.
	 */
	public SearchRouteView() {
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		
		JLabel lblVan = new JLabel("Van");
		springLayout.putConstraint(SpringLayout.WEST, lblVan, 10, SpringLayout.WEST, this);
		add(lblVan);
		
		textField = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, textField, 61, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, textField, 27, SpringLayout.EAST, lblVan);
		springLayout.putConstraint(SpringLayout.NORTH, lblVan, 5, SpringLayout.NORTH, textField);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, textField_1, 104, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, textField_1, 0, SpringLayout.WEST, textField);
		add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblTot = new JLabel("Tot");
		springLayout.putConstraint(SpringLayout.NORTH, lblTot, 5, SpringLayout.NORTH, textField_1);
		springLayout.putConstraint(SpringLayout.WEST, lblTot, 0, SpringLayout.WEST, lblVan);
		add(lblTot);
		
		JRadioButton rdbtnEnkel = new JRadioButton("Enkel");
		springLayout.putConstraint(SpringLayout.WEST, rdbtnEnkel, 72, SpringLayout.EAST, textField);
		springLayout.putConstraint(SpringLayout.EAST, rdbtnEnkel, -222, SpringLayout.EAST, this);
		add(rdbtnEnkel);
		rdbtnEnkel.setSelected(true);
		
		JRadioButton rdbtnHeenEnTerug = new JRadioButton("Heen en terug");
		springLayout.putConstraint(SpringLayout.NORTH, rdbtnHeenEnTerug, 1, SpringLayout.NORTH, textField_1);
		springLayout.putConstraint(SpringLayout.WEST, rdbtnHeenEnTerug, 0, SpringLayout.WEST, rdbtnEnkel);
		add(rdbtnHeenEnTerug);
		
		ButtonGroup groupHeenEnTerug = new ButtonGroup();
	    groupHeenEnTerug.add(rdbtnEnkel);
	    groupHeenEnTerug.add(rdbtnHeenEnTerug);
		
		JLabel lblDatum = new JLabel("Datum (dd/mm/jjjj)");
		springLayout.putConstraint(SpringLayout.WEST, lblDatum, 10, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.NORTH, lblDatum, 31, SpringLayout.SOUTH, textField_1);
		add(lblDatum);
		
		JLabel lblUur = new JLabel("Uur");
		springLayout.putConstraint(SpringLayout.WEST, lblUur, 10, SpringLayout.WEST, this);
		add(lblUur);
		
		JRadioButton rdbtnVertrek = new JRadioButton("Vertrek");
		springLayout.putConstraint(SpringLayout.NORTH, rdbtnVertrek, -4, SpringLayout.NORTH, lblUur);
		add(rdbtnVertrek);
		rdbtnVertrek.setSelected(true);
		
		JRadioButton rdbtnAankomst = new JRadioButton("Aankomst");
		springLayout.putConstraint(SpringLayout.NORTH, rdbtnAankomst, -4, SpringLayout.NORTH, lblUur);
		springLayout.putConstraint(SpringLayout.WEST, rdbtnAankomst, 19, SpringLayout.EAST, rdbtnVertrek);
		add(rdbtnAankomst);
		
		ButtonGroup groupAankomstVertrek = new ButtonGroup();
	    groupAankomstVertrek.add(rdbtnVertrek);
	    groupAankomstVertrek.add(rdbtnAankomst);
		
		JButton btnTerug = new JButton("Terug");
		springLayout.putConstraint(SpringLayout.WEST, btnTerug, 10, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, rdbtnAankomst, -22, SpringLayout.NORTH, btnTerug);
		springLayout.putConstraint(SpringLayout.SOUTH, rdbtnVertrek, -22, SpringLayout.NORTH, btnTerug);
		springLayout.putConstraint(SpringLayout.SOUTH, lblUur, -25, SpringLayout.NORTH, btnTerug);
		springLayout.putConstraint(SpringLayout.SOUTH, btnTerug, -10, SpringLayout.SOUTH, this);
		add(btnTerug);
		
		JButton btnZoek = new JButton("Zoek");
		springLayout.putConstraint(SpringLayout.NORTH, btnZoek, 0, SpringLayout.NORTH, btnTerug);
		springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, btnZoek, 0, SpringLayout.HORIZONTAL_CENTER, this);
		add(btnZoek);
		
		JFormattedTextField frmtdtxtfldUur = new JFormattedTextField();
		springLayout.putConstraint(SpringLayout.WEST, frmtdtxtfldUur, 28, SpringLayout.EAST, lblUur);
		springLayout.putConstraint(SpringLayout.SOUTH, frmtdtxtfldUur, -20, SpringLayout.NORTH, btnTerug);
		springLayout.putConstraint(SpringLayout.WEST, rdbtnVertrek, 30, SpringLayout.EAST, frmtdtxtfldUur);
		frmtdtxtfldUur.setText("12:30");
		add(frmtdtxtfldUur);
		
		JFormattedTextField formattedTextField = new JFormattedTextField();
		springLayout.putConstraint(SpringLayout.NORTH, formattedTextField, -5, SpringLayout.NORTH, lblDatum);
		springLayout.putConstraint(SpringLayout.WEST, formattedTextField, 41, SpringLayout.EAST, lblDatum);
		formattedTextField.setText("21/09/2016");
		add(formattedTextField);
		
		JLabel lblZoekEenRoute = new JLabel("Zoek een route");
		springLayout.putConstraint(SpringLayout.NORTH, rdbtnEnkel, 36, SpringLayout.SOUTH, lblZoekEenRoute);
		springLayout.putConstraint(SpringLayout.NORTH, lblZoekEenRoute, 10, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, lblZoekEenRoute, 0, SpringLayout.HORIZONTAL_CENTER, this);
		add(lblZoekEenRoute);
	}
	
	public static void run() {
      JPanel p = new SearchRouteView();
       
      JFrame f = new JFrame();
      f.getContentPane().add(p);
      f.setVisible(true);
      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      f.setSize(550, 300);
      f.setMinimumSize(new Dimension(550, 300));
      f.setLocationRelativeTo(null);
  }
}
