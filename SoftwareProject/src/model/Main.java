package model;

import controller.*;
import data_control.CustomerDAO;
import view.BuySubscriptionView;
import view.FindSubscriptionView;

public class Main {

	public static void main(String[] args) {
		//SystemController.startUp();
		Customer cust = new Customer("Bernd", "Wethmar", "b@w.Be", "0000", "Straat");
		cust.setId(CustomerDAO.createCustomer(cust));
		
	}
}