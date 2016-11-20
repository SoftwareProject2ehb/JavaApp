package controller;

import view.BuySubscriptionView;

public class SubscriptionController {

public static BuySubscriptionView buy_subscription;
	
	public SubscriptionController() {
		
	}
	
	public static void initialize(BuySubscriptionView buy_subscription) {
		SubscriptionController.buy_subscription = buy_subscription;
	}
	
	public static void switchToBuySubscriptionView() {
		SystemController.frame.switchTo("BUY_SUBSCRIPTION");
	}
}
