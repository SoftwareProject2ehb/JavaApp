package model;

import controller.*;
import data_control.CustomerDAO;
import data_control.LostObjectDAO;
import data_control.SubscriptionDAO;
import view.BuySubscriptionView;
import view.FindSubscriptionView;

public class Main {

	public static void main(String[] args) {
		//SystemController.startUp();
		SubscriptionDAO.getAllSubs();
	}
}