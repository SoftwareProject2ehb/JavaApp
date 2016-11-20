package controller;

import model.*;
import model.User.Role;
import utilities.*;
import view.*;

import java.security.InvalidParameterException;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import data_control.*;

public abstract class SystemController {
	static SystemNMBS system = new SystemNMBS();
	static CustomerController customer_controller;
	static SystemFrame frame;
		
	public static void startUp() {
		// TODO Hier worden alle views aangemaakt en opgeslagen in hun Controllers
		CustomerController.initialize(new CreateCustomerView(), new FindCustomerView());
		LoginController.initialize(new LoginView());
		ActionMenuController.initialize(new ActionMenuView());
		
		frame = new SystemFrame();
		frame.setVisible(true);
	}
	
	public static boolean login(String user_login, String password) {
		if (system.login(user_login, password) == ErrorCode.NO_ERROR) {
			return true;
		}
		return false;
	}
	
	public static String giveRouteInfo() {
		//TODO Implementation
		return null;
	}
	
	public static String getTicketInfo() {
		//TODO Implementation
		return null;
	}
	
	public static String getSubscriptionInfo() {
		//TODO Implementation
		return null;
	}
	
	public static String createCustomer(String first_name, String last_name, String address, String email, String phone) {
		Customer new_customer = new Customer(first_name, last_name, email, phone, address);
		CustomerDAO.createCustomer(new_customer);
		return "Customer created.";
	}
	
	public static String buyTicket(String type_ticket, boolean is_one_way_ticket, double ticket_price, String start_station, String end_station, Date date) {
		Ticket new_ticket = new Ticket(type_ticket, is_one_way_ticket, ticket_price, start_station, end_station, date);
		TicketDAO.createTicket(new_ticket);
		return "Ticket bought.";
	}

	public static String buySubscription(String subscription_type, int customerId, String endStation, String startStation, Timestamp startDate, Timestamp endDate) {
		
		Subscription subscription;
		double subscription_price = Subscription.calculatePrice();
		
		switch (subscription_type) {
		case "JONGERENTICKET":
			subscription = new Subscription(Subscription.subscription_type.JONGERENTICKET, subscription_price, customerId, endStation, startStation, null, null);
			break;
		case "SENIORENTICKET":
			subscription = new Subscription(Subscription.subscription_type.SENIORENTICKET, subscription_price, customerId, endStation, startStation, null, null);
			break;
		case "FUNHOUR":
			subscription = new Subscription(Subscription.subscription_type.FUNHOUR, subscription_price, customerId, endStation, startStation, null, null);
			break;
		default:
			throw new IllegalArgumentException();
		}
		
		SubscriptionDAO.createSubscription(subscription);
		return "Abonnement gekocht.";
	}
	
	public static String getReports() {
		//TODO Implementation
		return null;
	}
	
	public static String makeTicketType(String ticket_type, String unit, double cost_per_unit) throws IllegalArgumentException{
		Price type;
		switch (unit) {
		case "uur":
			type = new Price(ticket_type, Price.betalingsType.PER_HOUR, cost_per_unit);
			break;
		case "station":
			type = new Price(ticket_type, Price.betalingsType.PER_HOUR, cost_per_unit);
			break;
		case "km":
			type = new Price(ticket_type, Price.betalingsType.PER_HOUR, cost_per_unit);
			break;
		case "zone":
			type = new Price(ticket_type, Price.betalingsType.PER_HOUR, cost_per_unit);
			break;
		default:
			throw new IllegalArgumentException();
		}
		PriceDAO.createPrice(type);
		return "Tickettype succesvol aangemaakt.";
	}
	
	public static String makeSubscriptionType() {
		//TODO
		return null;
	}
	
	public static String addLostObject(int user_id, String name, String station, Timestamp date) {
		LostObject obj = new LostObject(-1, user_id, name, station, date, false, -1, null, null, null);
		LostObjectDAO.createLostObject(obj);
		return "Succesvol toegevoegd.";
	}
	
	public static ArrayList<LostObject> searchLostObject(String name_finder, String place_found, Timestamp time_found, Boolean claimed) {
		ArrayList<LostObject> object_array = LostObjectDAO.getLostObjectByMultipleArgs(name_finder, place_found, time_found, claimed);
		return object_array;
	}
	
	
	public static String addUser(String first_name, String last_name, String email, String phone, String password, Role role) {
		String login = first_name + "_" + last_name;
		User new_user = new User(first_name, last_name, email, phone, login, Encryptor.encrypt(password), role);
		UserDAO.createUser(new_user);
		return null;
	}
	
	public static String changePrice(String measure_unit, double cost_per_unit) {
		//TODO Implementation
		return null;
	}
}
