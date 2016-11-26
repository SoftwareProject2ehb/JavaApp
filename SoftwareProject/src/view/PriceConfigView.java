package view;

import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SpringLayout;
import javax.swing.UIManager;

import controller.ConfigurationController;
import data_control.PriceDAO;
import model.Price;
import model.Price.betalingsType;

import javax.swing.JScrollPane;
import javax.swing.JTextField;

import java.util.ArrayList;
import java.util.List;

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
import java.awt.event.ActionEvent;

public class PriceConfigView extends JPanel {
	private JTextField txtSoort;
	private JTextField txtPrijs;
	private int index;
	private ArrayList<Price> priceList;
	private String defaultTxt = "Naam van het nieuw soort biljet";
	private JComboBox comboBox_type;
	private JComboBox comboBox_soort;
	private JButton btnDelete;

	/**
	 * Create the panel.
	 */
	public PriceConfigView() {
		priceList = PriceDAO.getAll();
		
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

		springLayout.putConstraint(SpringLayout.NORTH, txtSoort, 12, SpringLayout.SOUTH, lblPrijsConfiguratie);
		springLayout.putConstraint(SpringLayout.WEST, txtSoort, 14, SpringLayout.EAST, lblNieuwSoortBiljet);
		add(txtSoort);
		txtSoort.setColumns(10);
		
		JButton btnVoegToe = new JButton("Voeg toe");
		springLayout.putConstraint(SpringLayout.EAST, txtSoort, -6, SpringLayout.WEST, btnVoegToe);
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
		
		comboBox_soort = new JComboBox();
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
		txtPrijs.setText(Double.toString(priceList.get(index).getCostPerUnit()));
		txtPrijs.setColumns(4);
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
		
		btnDelete = new JButton("DELETE");
		btnDelete.setForeground(Color.RED);
		springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, btnDelete, 0, SpringLayout.VERTICAL_CENTER, comboBox_soort);
		springLayout.putConstraint(SpringLayout.WEST, btnDelete, 6, SpringLayout.EAST, comboBox_type);
		add(btnDelete);
		
		JLabel lblInfo = new JLabel("");
		springLayout.putConstraint(SpringLayout.NORTH, lblInfo, 65, SpringLayout.SOUTH, comboBox_soort);
		springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, lblInfo, 0, SpringLayout.HORIZONTAL_CENTER, this);
		add(lblInfo);
		
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
				updatePriceList(index);
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
	
	public String getTxtSoort() {
		return txtSoort.getText();
	}
	
	public Price getPrice() {
		return new Price(priceList.get(index).getId(), priceList.get(index).getTypeTicket(), betalingsType.stringToBetalingsType(comboBox_type.getSelectedItem().toString()), Double.valueOf(txtPrijs.getText()));
	}
}