package controller;

import model.*;
import model.User.Role;
import utilities.Encryptor;

import java.sql.Date;
import java.sql.Timestamp;

import data_control.*;

public class SystemController {
	SystemNMBS system;
	
	public SystemController() {
		system = new SystemNMBS();
	}
	
	public String giveRouteInfo() {
		//TODO Implementation
		return null;
	}
	
	public String getTicketInfo() {
		//TODO Implementation
		return null;
	}
	
	public String getSubscriptionInfo() {
		//TODO Implementation
		return null;
	}
	
	public String createCustomer(String first_name, String last_name, String address, String email, String phone) {
		Customer new_customer = new Customer(first_name, last_name, email, phone, address);
		CustomerDAO.createCustomer(new_customer);
		return "Customer created.";
	}
	
	public String buyTicket(String type_ticket, boolean is_one_way_ticket, double ticket_price, String start_station, String end_station, Date date) {
		Ticket new_ticket = new Ticket(type_ticket, is_one_way_ticket, ticket_price, start_station, end_station, date);
		TicketDAO.createTicket(new_ticket);
		return "Ticket bought.";
	}

	public String buySubscription(String type_subscription, double subscription_price, int customer_id, String end_station, String start_station,
			Date start_date, Date end_date) {
		
		Subscription new_subscription = new Subscription(type_subscription, subscription_price, customer_id, end_station, start_station, start_date, end_date);
		SubscriptionDAO.createSubscription(new_subscription);
		return "Subscription bought.";
	}
	
	public String getReports() {
		//TODO Implementation
		return null;
	}
	
	public String makeTicketType() {
		//TODO Implementation
		return null;
	}
	
	public String makeSubscriptionType() {
		//TODO Implementation
		return null;
	}
	
	public String addLostObject(int user_id, String name, String station, Timestamp date) {
		LostObject obj = new LostObject(-1, user_id, name, station, date, false, -1, null, null, null);
		LostObjectDAO.createLostObject(obj);
		return "Succesvol toegevoegd.";
	}
	
	public String searchLostObject() {
		//TODO Implementation
		return null;
	}
	
	
	public String addUser(String first_name, String last_name, String email, String phone, String password, Role role) {
		String login = first_name + "_" + last_name;
		User new_user = new User(first_name, last_name, email, phone, login, Encryptor.encrypt(password), role);
		UserDAO.createUser(new_user);
		return null;
	}
	
	public String changePrice(String measure_unit, double cost_per_unit) {
		//TODO Implementation
		return null;
	}
}
