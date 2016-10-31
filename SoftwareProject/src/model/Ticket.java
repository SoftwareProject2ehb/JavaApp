package model;

public class Ticket {
	String typeTicket;
	String startStation;
	String endStation;
	double price;
	
	public Ticket(String type, String start, String end, double price) {
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

	public void setTypeTicket(String typeTicket) {
		this.typeTicket = typeTicket;
	}

	public String getStartStation() {
		return startStation;
	}

	public void setStartStation(String startStation) {
		this.startStation = startStation;
	}

	public String getEndStation() {
		return endStation;
	}

	public void setEndStation(String endStation) {
		this.endStation = endStation;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}