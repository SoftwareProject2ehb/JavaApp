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
			return 200;
		
		this.typeTicket = typeTicket;
		return 0;
	}

	public String getStartStation() {
		return startStation;
	}

	public int setStartStation(String startStation) {
		if (startStation == null)
			return 200;
		
		this.startStation = startStation;
		return 0;
	}

	public String getEndStation() {
		return endStation;
	}

	public int setEndStation(String endStation) {
		if (endStation == null)
			return 200;

		this.endStation = endStation;
		return 0;
	}

	public double getPrice() {
		return price;
	}

	public int setPrice(double price) {
		if (price < 0)
			return 100;

		this.price = price;
		return 0;
	}
}