package model;
import java.sql.Date;
import java.time.LocalDateTime;

public class Subscription {
	private int id;
	private String ticketType;
	private double price;
	private String startStation;
	private String endStation;
	private int customerId;
	private Date startDate;
	private Date endDate;
	
	public Subscription(int id, String ticketType, double price, int customerId, String startStation, String endStation,
			Date startDate, Date endDate) {
		super();
		this.id = id;
		this.ticketType = ticketType;
		this.price = price;
		this.startStation = startStation;
		this.endStation = endStation;
		this.customerId = customerId;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTicketType() {
		return ticketType;
	}

	public void setTicketType(String ticketType) {
		this.ticketType = ticketType;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
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

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	
}
