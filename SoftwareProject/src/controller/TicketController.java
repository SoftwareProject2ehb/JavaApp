package controller;

import javax.swing.JOptionPane;

import model.Ticket;
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
	
	public static void calculatePrice() {
		String start_station = buy_ticket.cbbBeginstation.getSelectedItem().toString();
		String end_station = buy_ticket.cbbEindstation.getSelectedItem().toString();
		String type = buy_ticket.cbbType.getSelectedItem().toString();
		boolean one_way = buy_ticket.checkBox.isSelected();
		
		double price = Ticket.calculatePrice(type, !one_way, start_station, end_station);
		if (price == 0) {
			JOptionPane.showMessageDialog(null, "Geen route gevonden tussen deze twee stations");
		} else {
			buy_ticket.txtPrijs.setText(String.valueOf(price).substring(0, 4));
		}
	}
}
