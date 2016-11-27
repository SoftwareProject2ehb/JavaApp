package model;

import java.sql.Date;

import com.sun.org.apache.bcel.internal.generic.GOTO;

import data_control.PriceDAO;
import data_control.TicketDAO;
import utilities.RouteCalculator;

public class Ticket {
	private int id;
	private String typeTicket;
	private boolean oneWayTicket;
	private double price;
	private String startStation;
	private String endStation;
	private Date date;

	public Ticket(int id, String type, boolean oneWayTicket, double price, String start, String end, Date date) {
		this(type, oneWayTicket, price, start, end, date);
		this.id = id;
	}
	
	public Ticket(String type, boolean oneWayTicket, double price, String start, String end, Date date) {
		if (type == null || start == null || end == null || price < 0)
			throw new IllegalArgumentException();
		
		this.id = -1;
		this.typeTicket = type;
		this.oneWayTicket = oneWayTicket;
		this.price = price;
		this.startStation = start;
		this.endStation = end;
		this.date = date;
	}
	
	public int getId() {
		return id;
	}

	public int setId(int id) {
		this.id = id;
		return ErrorCode.NO_ERROR;
	}

	public String getTicketInfo() {
		return typeTicket + " van " + startStation + " tot " + endStation + " : €" + price;
	}
	
	public String getTypeTicket() {
		return typeTicket;
	}

	public int setTypeTicket(String typeTicket) {
		if (typeTicket == null)
			return ErrorCode.NULL_PARAM;
		
		this.typeTicket = typeTicket;
		return ErrorCode.NO_ERROR;
	}

	public String getStartStation() {
		return startStation;
	}

	public int setStartStation(String startStation) {
		if (startStation == null)
			return ErrorCode.NULL_PARAM;
		
		this.startStation = startStation;
		return ErrorCode.NO_ERROR;
	}

	public String getEndStation() {
		return endStation;
	}

	public int setEndStation(String endStation) {
		if (endStation == null)
			return ErrorCode.NULL_PARAM;

		this.endStation = endStation;
		return ErrorCode.NO_ERROR;
	}

	public double getPrice() {
		return price;
	}

	public int setPrice(double price) {
		if (price < 0)
			return ErrorCode.INCORRECT_PARAM;

		this.price = price;
		return ErrorCode.NO_ERROR;
	}
	
	public Date getDate() {
		return date;
	}

	public int setDate(Date date) {
		if (date == null)
			return ErrorCode.NULL_PARAM;
		
		this.date = date;
		return ErrorCode.NO_ERROR;
	}

	public boolean isOneWayTicket() {
		return oneWayTicket;
	}

	public int setOneWayTicket(boolean oneWayTicket) {
		this.oneWayTicket = oneWayTicket;
		return ErrorCode.NO_ERROR;
	}
	
	public static double calculatePrice(String ticket_type, boolean one_way, String start_station, String end_station) {
		Price type = PriceDAO.findPriceByType(ticket_type);
		double price;
		
			switch (type.typeBetaling) {
			case PER_HOUR:
				price = type.costPerUnit * RouteCalculator.calculateTime(start_station, end_station); 
				break;
				
			case PER_KM:
				price = type.costPerUnit * RouteCalculator.calculateDistance(start_station, end_station); 
				break;
				
			case PER_STATION:
				price = type.costPerUnit * RouteCalculator.calculateStations(start_station, end_station); 
				break;
			default:
				price = 0;
				break;
			}
			
			if (!one_way) {
				price = price * 2;
			}
			
			return price;
	}
}