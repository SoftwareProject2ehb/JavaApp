package model;

import java.sql.SQLException;

import controller.SubscriptionController;
import controller.SystemController;
import data_control.BaseDAO;
import view.BuySubscriptionView;
import view.FindSubscriptionView;

public class Main {

	public static void main(String[] args) throws SQLException {
		
		SystemController.startUp();
	}
}