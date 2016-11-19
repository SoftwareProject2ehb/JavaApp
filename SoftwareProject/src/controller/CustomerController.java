package controller;

import java.security.InvalidParameterException;
import java.util.ArrayList;

import javax.swing.JTextField;

import view.*;

public abstract class CustomerController {
	static CreateCustomerView create_customer;
	static FindCustomerView find_customer;
	
	public CustomerController(CreateCustomerView create_customer, FindCustomerView find_customer) {
		CustomerController.create_customer = create_customer;
		CustomerController.find_customer = find_customer;
	}
	
	public static void switchToCreateCustomerView() {
		//TODO
	}
	
	public static void switchToFindCustomerView() {
		//TODO
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
			if (array.get(i) == null || array.get(i).getText() == "") {
				throw new InvalidParameterException("Een van de gegeven waarden voor de klant is ongeldig.");
			}
		}
		
		first_name = array.get(1).getText();
		last_name = array.get(2).getText();
		email = array.get(3).getText();
		phone_number = array.get(4).getText();
		street_name = array.get(5).getText();
		postal_code = array.get(6).getText();
		community = array.get(7).getText();
		
		SystemController.createCustomer(first_name, last_name, street_name + ", " + postal_code + " " + community, email, phone_number);
	}
}
