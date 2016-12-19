package controller;

import model.*;
import model.Price.betalingsType;
import model.User.Role;
import utilities.*;
import utilities.Language.LANGUAGE;
import view.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JOptionPane;

import data_control.*;
import data_control.UserDAO.FindUser;

public abstract class SystemController {
	public final static String EURO = "\u20ac";
	public static SystemNMBS system = new SystemNMBS();
	static CustomerController customer_controller;
	private String system_station;
		
	public static void startUp() {
		//Set language of the application and load all language strings
		Language.setLanguage(LANGUAGE.ENGLISH);
		Language.refresh();
		// TODO Hier worden alle views aangemaakt en opgeslagen in hun Controllers
		CustomerController.initialize(new CreateCustomerView(), new FindCustomerView());
		SelectStationController.initialize(new SelectStationView());
		LoginController.initialize(new LoginView());
		ActionMenuController.initialize(new ActionMenuView(), new AccountInfoView());
		SubscriptionController.initialize(new BuySubscriptionView(), new FindSubscriptionView());
		TicketController.initialize(new BuyTicketView());
		ConfigurationController.initialize(new ReportView(), new PriceConfigView(), new UserView(),new EditUserView(), new CreateUserView(),new EditPasswordView(), new ConfigurationView());
		RouteController.initialize(new SearchRouteView());
		LostObjectController.initialize(new LostObjectView());
		ReportController.initialize(new ReportView());
		
		FrameController.getFrame().addWindowListener(new java.awt.event.WindowAdapter() {
		    @Override
		    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
		        try {
					BaseDAO.getConnection().close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    }
		});
		FrameController.getFrame().setVisible(true);
	}
	
	public static boolean login(String user_login, String password) {
		if (system.login(user_login, password) == ErrorCode.NO_ERROR) {
			return true;
		}
		return false;
	}
	
	public static void meldAf() {
		system.meldAf();
	}
	
	public static String giveRouteInfo(String start_station, String end_station, Timestamp datetime) {
		String[] stops = RouteCalculator.pathRoute(start_station, end_station);
		String result = "Er is een route gevonden met de volgende haltes: ";
		if (stops != null) {
			for (String string : stops) {
				result = result.concat(string + " - ");
			}
			result = result.concat("- TERMINUS");
		}
		return result;
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
		int customer_id = CustomerDAO.createCustomer(new_customer);
		new_customer.setId(customer_id);
		return "Customer created.";
	}
	public static ArrayList<Customer> findCustomers(String Voornaam, String Achternaam,String Adress, String Phone, String Email) {
		ArrayList<Customer> lijstCustomers = new ArrayList<Customer>();
	
		
			 lijstCustomers = CustomerDAO.getCustomerByMultipleArgs(Voornaam, Achternaam, Adress, Phone, Email);
			
			
		
		return  lijstCustomers;
	}
	
	public static String buyTicket(String type_ticket, boolean is_one_way_ticket, double ticket_price, String start_station, String end_station, Date date) {
		Ticket new_ticket = new Ticket(type_ticket, is_one_way_ticket, ticket_price, start_station, end_station, date);
		int ticket_id = TicketDAO.createTicket(new_ticket);
		new_ticket.setId(ticket_id);
		
		if (JOptionPane.showConfirmDialog(null, "Ticket van " + start_station + " naar " + end_station + " gekocht voor " + EURO + String.valueOf(ticket_price).substring(0, 4) + ". Wilt u de ticket afprinten?", "Afprinten?", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
			try {
				Printer.printTicket(new_ticket);
			} catch (IOException e) {
				System.out.println("Probleem met het printen in SystemController.buyTicket");
			}
		}
		
		return "Ticket bought.";
	}

	public static String buySubscription(String subscription_type, int customerId, String endStation, String startStation, Timestamp startDate, Timestamp endDate) {
		Subscription subscription;
		//SubscriptionDAO.createSubscription(subscription);
		return "Abonnement gekocht.";
	}
	
	public static String getReports() {
		//TODO Implementation
		return null;
	}
	
	public static String makeTicketType(String ticket_type, String unit, double cost_per_unit) throws IllegalArgumentException{
		Price type;
		switch (unit) {
		case "hour":
			type = new Price(ticket_type, Price.betalingsType.PER_HOUR, cost_per_unit);
			break;
		case "station":
			type = new Price(ticket_type, Price.betalingsType.PER_STATION, cost_per_unit);
			break;
		case "km":
			type = new Price(ticket_type, Price.betalingsType.PER_KM, cost_per_unit);
			break;
		case "fixed":
			type = new Price(ticket_type, Price.betalingsType.FIXED, cost_per_unit);
			break;
		default:
			throw new IllegalArgumentException();
		}
		int pricetype_id = PriceDAO.createPrice(type);
		type.setId(pricetype_id);
		return "Tickettype succesvol aangemaakt.";
	}
	
	public static void updateTicketType(Price p) {
		PriceDAO.updatePrice(p);
	}
	
	public static void deleteTicketType(Price p) {
		PriceDAO.removePrice(p.getId());
	}

	public static String makeSubscriptionPrice(String subscription_type, String unit, double cost_per_unit, double aantal_maanden) throws IllegalArgumentException{
		SubscriptionPrice price;
		switch (unit) {
		case "hour":
			price = new SubscriptionPrice(subscription_type, Price.betalingsType.PER_HOUR, cost_per_unit, aantal_maanden);
			break;
		case "station":
			price = new SubscriptionPrice(subscription_type, Price.betalingsType.PER_STATION, cost_per_unit, aantal_maanden);
			break;
		case "km":
			price = new SubscriptionPrice(subscription_type, Price.betalingsType.PER_KM, cost_per_unit, aantal_maanden);
			break;
		case "fixed":
			price = new SubscriptionPrice(subscription_type, Price.betalingsType.FIXED, cost_per_unit, aantal_maanden);
			break;
		default:
			throw new IllegalArgumentException();
		}
		int pricetype_id = SubscriptionPriceDAO.createSubscriptionPrice(price);
		price.setId(pricetype_id);
		return "Abonnementtype succesvol aangemaakt.";
	}
	
	public static void updateSubscriptionType(SubscriptionPrice p) {
		SubscriptionPriceDAO.updateSubType(p);
	}
	
	public static void deleteSubscriptionType(SubscriptionPrice p) {
		SubscriptionPriceDAO.removeSubscriptionPrice(p.getId());
	}
	
	public static LostObject addLostObject(String name, String station,String description) {
		LostObject obj = new LostObject(system.logged_user.getUserID(), name, station,description);
		int lost_object_id = LostObjectDAO.createLostObject(obj);
		obj.setID(lost_object_id);
		return obj;
	}
	public static LostObject updateLostObject(String name, String place,LostObject obj)
	{
		
		
		obj.setNameClaimed(name);
		obj.setLocationClaimed(place);
		obj.setDateClaimed(new java.sql.Timestamp(new java.util.Date().getTime()));
		obj.setUserIDClaimed(SystemController.system.logged_user.getUserID());
		LostObjectDAO.updateLostObject(obj);
		return obj;
	}
	/*
	 * public static ArrayList<LostObject> searchLostObject(String name_user,
	 * String place_found, Timestamp time_found, Boolean claimed) {
	 * ArrayList<LostObject> object_array =
	 * LostObjectDAO.getLostObjectByMultipleArgs(name_user, place_found,
	 * time_found, claimed); return object_array; }
	 */
public static ArrayList<LostObject> findAllLostObjects(int select_view,int select_from_date ,int select_to_date )
{
	ArrayList<LostObject> lijstLostobject =new ArrayList<LostObject>();
	switch (select_view) {
	case 0:
		lijstLostobject = LostObjectDAO.getAllLostObject(select_from_date + 1, select_to_date);
		break;
	case 1:
		lijstLostobject =  LostObjectDAO.getAllLostObjectClaimed(select_from_date + 1, select_to_date);
		
		break;
	case 2:
		lijstLostobject = LostObjectDAO.getAllLostObjectNotClaimed(select_from_date + 1, select_to_date);
		
		break;
	}
	return lijstLostobject;
}	



	public static ArrayList<LostObject> searchLostObject(String name_user, String place_found, Timestamp time_found, Boolean claimed) {
		ArrayList<LostObject> object_array = LostObjectDAO.getLostObjectByMultipleArgs(name_user, place_found, time_found, claimed);
		return object_array;
	}
	
	public static ArrayList<LostObject> findLostObjects(int index, String value) {
		ArrayList<LostObject> lijstLostobject =new ArrayList<LostObject>();
		switch (index) {
		case 0:
			lijstLostobject = LostObjectDAO.getLostObjectOpAttribut(LostObjectDAO.SearchLostObject.userid,
					value);
			break;
		case 1:
			lijstLostobject = LostObjectDAO.getLostObjectOpAttribut(LostObjectDAO.SearchLostObject.name,
					value);
			break;
		case 2:
			lijstLostobject = LostObjectDAO.getLostObjectOpAttribut(LostObjectDAO.SearchLostObject.place,
					value);
			

			break;
		case 3:
			lijstLostobject = LostObjectDAO.getLostObjectOpAttribut(LostObjectDAO.SearchLostObject.description,
					value);
			

			break;
		case 4:
			lijstLostobject = LostObjectDAO.getLostObjectOpAttribut(LostObjectDAO.SearchLostObject.timeFound,
					value);
		

			break;
		case 5:
			lijstLostobject = LostObjectDAO.getLostObjectOpAttribut(LostObjectDAO.SearchLostObject.userClaimed,
					value);
			

			break;
		case 6:
			lijstLostobject = LostObjectDAO.getLostObjectOpAttribut(LostObjectDAO.SearchLostObject.nameClaimed,
					value);
			
			break;
		case 7:
			lijstLostobject = LostObjectDAO.getLostObjectOpAttribut(
					LostObjectDAO.SearchLostObject.LocationClaimed, value);
			

			break;
		case 8:
			lijstLostobject = LostObjectDAO.getLostObjectOpAttribut(LostObjectDAO.SearchLostObject.timeClaimed,
					value);
			

			break;

		}
		return lijstLostobject;
	}

	public static String addUser(String first_name, String last_name, String email, String phone,
			Role role, String street, String number, String bus, int postal_code, String city, String country) {
		String login = first_name + "_" + last_name;
		String password = first_name + "_" + last_name;
		boolean activeU = true;
		User new_user = new User(first_name, last_name, email, phone, login, Encryptor.encrypt(password), role, activeU, street, number, bus, postal_code, city, country);
		int user_id = UserDAO.createUser(new_user);
		new_user.setUserID(user_id);
		return null;
	}
	
	public static String editUser(String first_name, String last_name, String email, String phone, Role role, String street, String number, String bus,
			int postal_code, String city, String country,String password) {
		User user = ConfigurationController.getSelectedUser();
		String login = first_name + "_" + last_name;
		user.setFirstName(first_name);
		user.setLastName(last_name);
		user.setLogin(login);
		user.setEmail(email);
		user.setPhone(phone);
		user.setRolen(role.toString());
		user.setStreet(street);
		user.setNumber(number);
		user.setBus(bus);
		user.setPostalCode(postal_code);
		user.setCity(city);
		user.setCountry(country);
		if ((password == "")) {
			user.setPassword(Encryptor.encrypt(password));
		}
		UserDAO.updateUser(user);
		return null;
	}
	
	public static void defaultPasswordCheck(){
		User user = system.logged_user;
		String default_pass = user.getFirstName() + "_" + user.getLastName();
		if(user.checkPassword(Encryptor.encrypt(default_pass))){
			ConfigurationController.switchToEditPasswordView();
		}
		else{
			ActionMenuController.switchToActionMenuView();
			//SelectStationController.switchToSelectStationView();
		}
	}
	
	public static boolean checkAccess(){
		User user  = SystemController.system.logged_user;
		if (user.getRolen() == "ADMIN")
			return true;
		else
			JOptionPane.showMessageDialog(null, "You have no access here.", "No Access", JOptionPane.WARNING_MESSAGE);
			return false;
	}
	
	public static ArrayList<User> searchUser(String searchText, UserDAO.FindUser att){
		ArrayList<User> userList = new ArrayList<User>();
		userList = UserDAO.findUserByAttribute(att, searchText);
		return userList;
	}
	
	
	public static String changePrice(String measure_unit, double cost_per_unit) {
		//TODO Implementation
		return null;
	}
	
	public static String[] getStations() {
		BufferedReader br = null;
		String[] station_list = null;
		try {
			FileInputStream fis = new FileInputStream(new File("./resources/stations.txt"));
			UnicodeReader reader = new UnicodeReader(fis, "UTF-8");
			br = new BufferedReader(reader);
			String result = br.readLine();
			station_list = result.split(",");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			try {
				if (br != null) {
					br.close();
				}
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return station_list;
	}

	public String getSystem_station() {
		return system_station;
	}

	public void setSystem_station(String system_station) {
		this.system_station = system_station;
	}
}