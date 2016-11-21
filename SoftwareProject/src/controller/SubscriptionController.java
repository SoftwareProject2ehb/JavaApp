package controller;

import data_control.*;
import model.*;
import view.*;

public class SubscriptionController {

public static BuySubscriptionView buy_subscription;
public static FindSubscriptionView find_subscription;

	public SubscriptionController() {
		
	}
	
	public static void initialize(BuySubscriptionView buy_subscription, FindSubscriptionView find_subscription) {
		SubscriptionController.buy_subscription = buy_subscription;
		SubscriptionController.find_subscription = find_subscription;
	}
	
	public static void switchToBuySubscriptionView() {
		SystemController.frame.switchTo("BUY_SUBSCRIPTION");
	}
	
	public static void switchToFindSubscriptionView() {
		SystemController.frame.switchTo("FIND_SUBSCRIPTION");
	}
	
	public static void calculatePrice() {
		//TODO Dit is verschrikkelijke code, verschrikkelijk. Horrific. Regelrechte onzin. Maar beter ging niet om 23:37. Volledige prijsberekening van Subscription moet aangepast worden.
		int type = 1;
		int price = 1;
		
		switch (buy_subscription.cbbGeldigheid.getSelectedItem().toString()) {
		case "1 maand":
			price = 1;
			break;
			
		case "2 maanden":
			price = 2;
			break;
			
		case "3 maanden":
			price = 3;
			break;
			
		case "6 maanden":
			price = 4;
			break;
			
		case "1 jaar":
			price = 5;
			break;
		}
		
		switch (buy_subscription.cbbType.getSelectedItem().toString()) {
		case "Type 1":
			type = 1;
			break;
			
		case "Type 2":
			type = 2;
			break;
		}
		
		double prijs = Subscription.calculatePrice(SubscriptionTypeDAO.findSubTypeById(type), SubscriptionPriceDAO.findSubPriceById(price));
		buy_subscription.txtPrijs.setText(String.valueOf(prijs));
	}
}
