package model;

public class Ticket {
	String typeTicket;
	String startStation;
	String endStation;
	double price;
	
	public Ticket(String type, String start, String end, double price) {
		if (type == null || start == null || end == null || price < 0)
			throw new IllegalArgumentException();
		
		this.typeTicket = type;
		this.startStation = start;
		this.endStation = end;
		this.price = price;
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
}