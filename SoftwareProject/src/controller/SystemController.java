package controller;

import model.*;
import model.User.Role;
import utilities.Encryptor;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;

import data_control.*;

public abstract class SystemController {
	SystemNMBS system;
	
	public SystemController() {
		system = new SystemNMBS();
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

	public static String buySubscription(String type_subscription, double subscription_price, int customer_id, String end_station, String start_station,
			Date start_date, Date end_date) {
		
		Subscription new_subscription = new Subscription(type_subscription, subscription_price, customer_id, end_station, start_station, start_date, end_date);
		SubscriptionDAO.createSubscription(new_subscription);
		return "Subscription bought.";
	}
	
	public static String getReports() {
		//TODO Implementation
		return null;
	}
	
	public static String makeTicketType() {
		//TODO Implementation
		return null;
	}
	
	public static String makeSubscriptionType() {
		//TODO Implementation
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
