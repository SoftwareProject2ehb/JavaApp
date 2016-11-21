package model;

import controller.*;
import data_control.CustomerDAO;
import view.BuySubscriptionView;
import view.FindSubscriptionView;

public class Main {

	public static void main(String[] args) {
		SystemController.startUp();
		SubscriptionController.initialize(new BuySubscriptionView(), new FindSubscriptionView());
		
	}
}