package controller;

import model.*;

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
	
	public String buyTicket() {
		return null;
	}

	public String buySubscription() {
		return null;
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
	public String addLostObject(int user_id, String name, String station, String time) {
		//LostObject obj = new LostObject(user_id, name, station, time);
		//LostObjectDAO.createLostObject(obj);
		return "Succesvol toegevoegd.";
	}
	
	public String searchLostObject() {
		return null;
	}
	
	public String addUser(String first_name, String last_name, String email, String phone, String password, String role) {
		String login = first_name + "_" + last_name;
		User new_user = new User(first_name, last_name, email, phone, login, password, role);
		return null;
	}
	
	public String changePrice() {
		return null;
	}
}
