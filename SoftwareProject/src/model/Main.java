package model;

import controller.*;
import data_control.CustomerDAO;
import data_control.LostObjectDAO;
import view.BuySubscriptionView;
import view.FindSubscriptionView;

public class Main {

	public static void main(String[] args) {
		//SystemController.startUp();
		Customer bernd = new Customer("Bernd", "Wethmar", "b@w.be", "0123", "Straatnaam");
		int bernd_id = CustomerDAO.createCustomer(bernd);
		bernd.setId(bernd_id);
	}
}