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
		return null;
	}
	
	public String getTicketInfo() {
		return null;
	}
	
	public String getSubscriptionInfo() {
		return null;
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
		return null;
	}
	
	public String makeTicketType() {
		return null;
	}
	
	public String makeSubscriptionType() {
		return null;
	}
	
	//TODO Date still set as time
	public String addLostObject(int user_id, String name, String station, Timestamp date) {
		LostObject obj = new LostObject(-1, user_id, name, station, date, false, -1, null, null, null);
		LostObjectDAO.createLostObject(obj);
		return "Succesvol toegevoegd.";
	}
	
	public String searchLostObject() {
		return null;
	}
	
	public String addUser(String first_name, String last_name, String email, String phone, String password, Role role) {
		String login = first_name + "_" + last_name;
		User new_user = new User(first_name, last_name, email, phone, login, Encryptor.encrypt(password), role);
		UserDAO.createUser(new_user);
		return null;
	}
	
	public String changePrice() {
		return null;
	}
}
