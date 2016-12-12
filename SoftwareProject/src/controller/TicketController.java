package controller;

import java.text.ParseException;

import javax.swing.JOptionPane;

import model.Printer;
import model.Ticket;
import utilities.DateConverter;
import view.BuyTicketView;

public class TicketController {

	public static BuyTicketView buy_ticket;
	
	public TicketController() {
		
	}
	
	public static void initialize(BuyTicketView buy_ticket) {
		TicketController.buy_ticket = buy_ticket;
	}
	
	public static void switchToBuyTicketView() {
		FrameController.getFrame().switchTo("BUY_TICKET");
		FrameController.changeSize(500,300);
	}
	
	public static double calculatePrice() {
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
		return price;
	}
	
	public static void buyTicket() {
		double price = calculatePrice();
		
		String start_station = buy_ticket.cbbBeginstation.getSelectedItem().toString();
		String end_station = buy_ticket.cbbEindstation.getSelectedItem().toString();
		String type = buy_ticket.cbbType.getSelectedItem().toString();
		boolean one_way = buy_ticket.checkBox.isSelected();
		
		if (price == 0) {
			JOptionPane.showMessageDialog(null, "Kon geen ticket kopen.");
		} else {
			try {
				SystemController.buyTicket(type, !one_way, price, start_station, end_station, DateConverter.convert(buy_ticket.txtDatum.getText()));
			} catch (ParseException e) {
				JOptionPane.showMessageDialog(null, "Kon geen ticket kopen.");
			}
		}
	}
	
	public static void setInfo(String begin, String eind, String datum, boolean enkel) {
		buy_ticket.cbbBeginstation.setSelectedItem(begin);
		buy_ticket.cbbEindstation.setSelectedItem(eind);
		buy_ticket.txtDatum.setText(datum);
		buy_ticket.checkBox.setSelected(enkel);
	}
}
