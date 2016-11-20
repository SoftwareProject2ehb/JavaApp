package controller;

import view.BuyTicketView;

public class TicketController {

	public static BuyTicketView buy_ticket;
	
	public TicketController() {
		
	}
	
	public static void initialize(BuyTicketView buy_ticket) {
		TicketController.buy_ticket = buy_ticket;
	}
	
	public static void switchToBuyTicketView() {
		SystemController.frame.switchTo("BUY_TICKET");
	}
}
