package view;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableRowSorter;
import javax.swing.text.AbstractDocument;

import controller.CustomerController;
import controller.LostObjectController;
import controller.SubscriptionController;
import controller.SystemController;
import utilities.Language;
import utilities.PatternFilter;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class FindCustomerView extends JPanel {

	public JTextField txtVoornaam;
	public JTextField txtAchternaam;
	public JTextField txtEmail;
	public JTextField txtTelN;
	public JTextField txtStraatnaam;
	public JTextField txtPostcode;
	public JTextField txtGemeente;
	public JTable table;
	/**
	 * Create the panel.
	 */
	public FindCustomerView() {
		setBounds(100, 100, 984, 485);
		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		SpringLayout sl_contentPane = new SpringLayout();
		this.setLayout(sl_contentPane);
		
		JLabel lblKlantZoeken = new JLabel(Language.getString("searchtitle"));
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblKlantZoeken, 10, SpringLayout.NORTH, this);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblKlantZoeken, 20, SpringLayout.WEST, this);
		lblKlantZoeken.setFont(new Font("Arial Black", Font.PLAIN, 17));
		this.add(lblKlantZoeken);
		
		JLabel lblVoornaam = new JLabel(Language.getString("firstname"));
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblVoornaam, 26, SpringLayout.SOUTH, lblKlantZoeken);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblVoornaam, 39, SpringLayout.WEST, this);
		this.add(lblVoornaam);
		
		txtVoornaam = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, txtVoornaam, -4, SpringLayout.NORTH, lblVoornaam);
		sl_contentPane.putConstraint(SpringLayout.WEST, txtVoornaam, 16, SpringLayout.EAST, lblVoornaam);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, txtVoornaam, 4, SpringLayout.SOUTH, lblVoornaam);
		sl_contentPane.putConstraint(SpringLayout.EAST, txtVoornaam, 166, SpringLayout.EAST, lblVoornaam);
		this.add(txtVoornaam);
		txtVoornaam.setColumns(10);
		
		JLabel lblAchternaam = new JLabel(Language.getString("lastname"));
		sl_contentPane.putConstraint(SpringLayout.EAST, lblAchternaam, 0, SpringLayout.EAST, lblVoornaam);
		this.add(lblAchternaam);
		
		JLabel lblEmail = new JLabel(Language.getString("email"));
		sl_contentPane.putConstraint(SpringLayout.EAST, lblEmail, 0, SpringLayout.EAST, lblVoornaam);
		this.add(lblEmail);
		
		JLabel lblTelN = new JLabel(Language.getString("telephone"));
		sl_contentPane.putConstraint(SpringLayout.EAST, lblTelN, 0, SpringLayout.EAST, lblVoornaam);
		this.add(lblTelN);
		
		txtAchternaam = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.EAST, txtAchternaam, 0, SpringLayout.EAST, txtVoornaam);
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblAchternaam, 3, SpringLayout.NORTH, txtAchternaam);
		sl_contentPane.putConstraint(SpringLayout.NORTH, txtAchternaam, 6, SpringLayout.SOUTH, txtVoornaam);
		sl_contentPane.putConstraint(SpringLayout.WEST, txtAchternaam, 0, SpringLayout.WEST, txtVoornaam);
		this.add(txtAchternaam);
		txtAchternaam.setColumns(10);
		
		txtEmail = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.EAST, txtEmail, 0, SpringLayout.EAST, txtVoornaam);
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblEmail, 3, SpringLayout.NORTH, txtEmail);
		sl_contentPane.putConstraint(SpringLayout.NORTH, txtEmail, 6, SpringLayout.SOUTH, txtAchternaam);
		sl_contentPane.putConstraint(SpringLayout.WEST, txtEmail, 0, SpringLayout.WEST, txtVoornaam);
		this.add(txtEmail);
		txtEmail.setColumns(10);
		
		txtTelN = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.EAST, txtTelN, 0, SpringLayout.EAST, txtVoornaam);
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblTelN, 3, SpringLayout.NORTH, txtTelN);
		sl_contentPane.putConstraint(SpringLayout.NORTH, txtTelN, 6, SpringLayout.SOUTH, txtEmail);
		sl_contentPane.putConstraint(SpringLayout.WEST, txtTelN, 0, SpringLayout.WEST, txtVoornaam);
		this.add(txtTelN);
		txtTelN.setColumns(10);
		((AbstractDocument) txtTelN.getDocument()).setDocumentFilter(PatternFilter.cijferFilter);
		
		txtStraatnaam = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, txtStraatnaam, 6, SpringLayout.SOUTH, txtTelN);
		sl_contentPane.putConstraint(SpringLayout.WEST, txtStraatnaam, 0, SpringLayout.WEST, txtVoornaam);
		sl_contentPane.putConstraint(SpringLayout.EAST, txtStraatnaam, 0, SpringLayout.EAST, txtVoornaam);
		this.add(txtStraatnaam);
		txtStraatnaam.setColumns(10);
		
		JLabel lblStraatnaam = new JLabel(Language.getString("street"));
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblStraatnaam, 0, SpringLayout.SOUTH, txtStraatnaam);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblStraatnaam, 0, SpringLayout.EAST, lblVoornaam);
		this.add(lblStraatnaam);
		
		txtPostcode = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, txtPostcode, 6, SpringLayout.SOUTH, txtStraatnaam);
		sl_contentPane.putConstraint(SpringLayout.WEST, txtPostcode, 0, SpringLayout.WEST, txtVoornaam);
		sl_contentPane.putConstraint(SpringLayout.EAST, txtPostcode, 0, SpringLayout.EAST, txtVoornaam);
		this.add(txtPostcode);
		txtPostcode.setColumns(10);
		((AbstractDocument) txtPostcode.getDocument()).setDocumentFilter(PatternFilter.cijferFilter);
		
		JLabel lblPostcode = new JLabel(Language.getString("zip"));
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblPostcode, 0, SpringLayout.SOUTH, txtPostcode);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblPostcode, 0, SpringLayout.EAST, lblVoornaam);
		this.add(lblPostcode);
		
		txtGemeente = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, txtGemeente, 6, SpringLayout.SOUTH, txtPostcode);
		sl_contentPane.putConstraint(SpringLayout.WEST, txtGemeente, 0, SpringLayout.WEST, txtVoornaam);
		sl_contentPane.putConstraint(SpringLayout.EAST, txtGemeente, 0, SpringLayout.EAST, txtVoornaam);
		this.add(txtGemeente);
		txtGemeente.setColumns(10);
		
		JLabel lblGemeente = new JLabel(Language.getString("city"));
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblGemeente, 0, SpringLayout.SOUTH, txtGemeente);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblGemeente, 0, SpringLayout.EAST, lblVoornaam);
		this.add(lblGemeente);
		
		JButton btnTerugNaarMenu = new JButton(Language.getString("return"));
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnTerugNaarMenu, -10, SpringLayout.SOUTH, this);
		btnTerugNaarMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SubscriptionController.switchToBuySubscriptionView();
			}
		});
		sl_contentPane.putConstraint(SpringLayout.WEST, btnTerugNaarMenu, 0, SpringLayout.WEST, lblKlantZoeken);
		this.add(btnTerugNaarMenu);
		
		JButton btnKlantGebruiken = new JButton(Language.getString("usecustomer"));
		btnKlantGebruiken.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(table.getSelectedRow() == -1)
				{
					JOptionPane.showMessageDialog(null,
							Language.getString("customermessageone"),
							Language.getString("customermessagetwo"),
						    JOptionPane.ERROR_MESSAGE);
				}
				else{
				CustomerController.useKlant();
				SubscriptionController.switchToBuySubscriptionView();
				}
			}
		});
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnKlantGebruiken, 0, SpringLayout.NORTH, btnTerugNaarMenu);
		this.add(btnKlantGebruiken);
		
		JLabel lblGevondenKlanten = new JLabel(Language.getString("foundcustomers"));
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblGevondenKlanten, 18, SpringLayout.NORTH, this);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblGevondenKlanten, 204, SpringLayout.EAST, lblKlantZoeken);
		this.add(lblGevondenKlanten);
		
		JButton btnMaakNieuweKlant = new JButton(Language.getString("newcustomer"));
		sl_contentPane.putConstraint(SpringLayout.WEST, btnKlantGebruiken, 6, SpringLayout.EAST, btnMaakNieuweKlant);
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnMaakNieuweKlant, 0, SpringLayout.NORTH, btnTerugNaarMenu);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnMaakNieuweKlant, 6, SpringLayout.EAST, btnTerugNaarMenu);
		btnMaakNieuweKlant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomerController.switchToCreateCustomerView();
			}
		});
		add(btnMaakNieuweKlant);
		String colname[] = {Language.getString("id"),Language.getString("firstname"),Language.getString("lastname"),Language.getString("address"),Language.getString("email"),Language.getString("telephone")};
		DefaultTableModel tableModel = new DefaultTableModel(colname,0)
		{
			@Override
			public boolean isCellEditable(int row,int column)
			{
				// NON EDITABLE CELLS
				return false;
			};
		};
		TableRowSorter sorter = new TableRowSorter(tableModel);
		table = new JTable();
		table.setRowSorter(sorter);
		JTableHeader header = table.getTableHeader();
		header.addMouseListener(new MouseAdapter() {
			int lastcol = -1;
			
			@Override
			public void mouseClicked(MouseEvent e) {
				lastcol = CustomerController.sortCustomers(e);	
			}
		});
		table.setModel(tableModel);
		
		
		JButton btnSearch = new JButton(Language.getString("search"));
		sl_contentPane.putConstraint(SpringLayout.WEST, btnSearch, 15, SpringLayout.EAST, btnKlantGebruiken);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnSearch, -20, SpringLayout.EAST, this);
		btnSearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				table.clearSelection();
				tableModel.setRowCount(0);
				CustomerController.findCustomers(tableModel);
			}
		});
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnSearch, 0, SpringLayout.NORTH, btnTerugNaarMenu);
		add(btnSearch);
		
		
		JScrollPane scrollPane = new JScrollPane();
		sl_contentPane.putConstraint(SpringLayout.NORTH, scrollPane, 15, SpringLayout.SOUTH, lblGevondenKlanten);
		sl_contentPane.putConstraint(SpringLayout.WEST, scrollPane, 25, SpringLayout.EAST, txtVoornaam);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, scrollPane, 3, SpringLayout.SOUTH, txtGemeente);
		sl_contentPane.putConstraint(SpringLayout.EAST, scrollPane, 0, SpringLayout.EAST, btnSearch);
		add(scrollPane);
		scrollPane.setViewportView(table);
	}
}
