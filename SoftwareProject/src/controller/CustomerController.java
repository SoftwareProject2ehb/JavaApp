package controller;

import java.awt.event.MouseEvent;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.DefaultTableModel;

import model.Customer;
import model.LostObject;
import view.*;

public abstract class CustomerController {
	public static CreateCustomerView create_customer;
	public static FindCustomerView find_customer;
	static ArrayList<Customer> lijstCustomers;
	
	public static void initialize(CreateCustomerView create_customer, FindCustomerView find_customer) {
		CustomerController.create_customer = create_customer;
		CustomerController.find_customer = find_customer;
	}
	
	public static void refresh() {
		CustomerController.create_customer = null;
		CustomerController.find_customer = null;
	}
	
	public static void switchToCreateCustomerView() {
		FrameController.getFrame().switchTo("CREATE_CUSTOMER");
	}
	
	public static void switchToFindCustomerView() {
		FrameController.getFrame().switchTo("FIND_CUSTOMER");
		FrameController.changeSize(984, 485);
	}
	
	public static void createCustomer() throws InvalidParameterException{
		ArrayList<JTextField> array = create_customer.getTextFields();
		String first_name;
		String last_name;
		String email;
		String phone_number;
		String street_name;
		String postal_code;
		String community;
		
		for (int i = 0; i < 7; i++) {
			if (array.get(i) == null || array.get(i).getText().equals("")) {
				throw new InvalidParameterException("Een van de gegeven waarden voor de klant is ongeldig.");
			}
		}
		
		first_name = array.get(0).getText();
		last_name = array.get(1).getText();
		email = array.get(2).getText();
		phone_number = array.get(3).getText();
		street_name = array.get(4).getText();
		postal_code = array.get(5).getText();
		community = array.get(6).getText();
		
		SystemController.createCustomer(first_name, last_name, street_name + ", " + postal_code + " " + community, email, phone_number);
		JOptionPane.showConfirmDialog(null, "Er is een klant toegevoegd met naam " + first_name + " " + last_name + ".", "Klant toegevoegd", JOptionPane.WARNING_MESSAGE);
	}
	
public static void findCustomers(DefaultTableModel tableModel) {
		String address  = null;
		// find_customer.txtStraatnaam.getText()+" " + find_customer.txtPostcode.getText()+" "+ find_customer.txtGemeente.getText();
		if (find_customer.txtStraatnaam.getText() != null && !find_customer.txtStraatnaam.getText().equals("")) {
			address =find_customer.txtStraatnaam.getText();
		}
		if (find_customer.txtPostcode.getText() != null && !find_customer.txtPostcode.getText().equals("")) {
			address =" "+find_customer.txtPostcode.getText();
		}
		if (find_customer.txtGemeente.getText() != null && !find_customer.txtGemeente.getText().equals("")) {
			address =" "+find_customer.txtGemeente.getText();
		}
		lijstCustomers = SystemController.findCustomers( 
				 find_customer.txtVoornaam.getText(),
				 find_customer.txtAchternaam.getText(),
				 address,
				 find_customer.txtTelN.getText(),
				 find_customer.txtEmail.getText()
				 
				);
		
		for (int x = 0; x < lijstCustomers.size(); x++) {
			
			tableModel.addRow(lijstCustomers.get(x).toArray());
		}
	}
	
static int lastcol;
static SortOrder currentOrder = SortOrder.UNSORTED;
public static int sortCustomers(MouseEvent e)
{
	
	//int rowClicked , int colClicked,
	int row = find_customer.table.rowAtPoint(e.getPoint());
	int col = find_customer.table.columnAtPoint(e.getPoint());
	
	//int row =rowClicked;
	//int col = colClicked;

	if (row == 0 && col >= 0) {

		col = find_customer.table.convertColumnIndexToModel(col);
		if (col != lastcol) {
			currentOrder = SortOrder.UNSORTED;
			lastcol = col;
		}
		

		RowSorter<?> sorter = find_customer.table.getRowSorter();
		List sortKeys = new ArrayList();
		// table.setAutoCreateRowSorter(true);

		if (e.getButton() == MouseEvent.BUTTON1) {
			switch (currentOrder) {
			case UNSORTED:
				sortKeys.add(new RowSorter.SortKey(col, currentOrder = SortOrder.ASCENDING));
				break;
			case ASCENDING:
				sortKeys.add(new RowSorter.SortKey(col, currentOrder = SortOrder.DESCENDING));
				break;
			case DESCENDING:
				sortKeys.add(new RowSorter.SortKey(col, currentOrder = SortOrder.UNSORTED));
				break;

			}
			sorter.setSortKeys(sortKeys);
			row = find_customer.table.convertRowIndexToModel(row);
		}
	}
	return lastcol;
}
public static void useKlant() {
	Customer customer;
	String naam;
	
	customer = lijstCustomers.get(find_customer.table.convertRowIndexToModel(find_customer.table.getSelectedRow()));
	naam = customer.getFirstName() +" " + customer.getLastName();
	SubscriptionController.setGebruikerField(naam);
}

public static int useKlantId() {
	return lijstCustomers.get(find_customer.table.convertRowIndexToModel(find_customer.table.getSelectedRow())).getId();
}
}
