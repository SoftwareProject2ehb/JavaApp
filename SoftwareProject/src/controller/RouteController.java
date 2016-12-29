package controller;

import javax.swing.JOptionPane;

import view.*;

public class RouteController {
public static SearchRouteView search_route;
	
	public static void initialize(SearchRouteView search_route) {
		RouteController.search_route = search_route;
	}
	
	public static void refresh() {
		RouteController.search_route = null;
	}
	
	public static void switchToSearchRouteView() {
		FrameController.getFrame().switchTo("SEARCH_ROUTE");
		FrameController.changeSize(800, 300);
	}
	
	public static void findRoute() {
		String start_station = search_route.cbbVan.getSelectedItem().toString();
		String end_station = search_route.cbbTot.getSelectedItem().toString();
		
		String reply = SystemController.giveRouteInfo(start_station, end_station, null);
		JOptionPane.showMessageDialog(null, reply);
	}
	
	public static void buyTicket() {
		TicketController.switchToBuyTicketView();
		TicketController.setInfo(search_route.cbbVan.getSelectedItem().toString(), search_route.cbbTot.getSelectedItem().toString(), search_route.txtDatum.getText(), search_route.chckbxHeenterug.isSelected());
	}
	
	public static void buySubscription() {
		SubscriptionController.switchToBuySubscriptionView();
		SubscriptionController.setInfo(search_route.cbbVan.getSelectedItem().toString(), search_route.cbbTot.getSelectedItem().toString(), search_route.txtDatum.getText());
	}
}