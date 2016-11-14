package model;

import java.sql.Date;

public class Ticket {
	private int ID;
	private String typeTicket;
	private boolean oneWayTicket;
	private double price;
	private String startStation;
	private String endStation;
	private Date date;

	public Ticket(int ID, String type, boolean oneWayTicket, double price, String start, String end, Date date) {
		if (type == null || start == null || end == null || price < 0)
			throw new IllegalArgumentException();
		
		this.ID = ID;
		this.typeTicket = type;
		this.oneWayTicket = oneWayTicket;
		this.price = price;
		this.startStation = start;
		this.endStation = end;
		this.date = date;
	}
	
	public int getID() {
		return ID;
	}

	public int setID(int iD) {
		ID = iD;
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
}