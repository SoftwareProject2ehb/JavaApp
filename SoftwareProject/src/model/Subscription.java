package model;
import java.sql.Date;
import java.time.LocalDateTime;

public class Subscription {
	public enum subscription_type {
		JONGERENTICKET, SENIORENTICKET, FUNHOUR;
		
		@Override
		public String toString() {
			switch (this) {
			case JONGERENTICKET: return "JONGERENTICKET";
			case SENIORENTICKET: return "SENIORENTICKET";
			case FUNHOUR: return "FUNHOUR";
			default: throw new IllegalArgumentException();
			}
		}
		
		public static subscription_type stringToBetalingsType(String s) {
			if (s.toUpperCase() == "JONGERENTICKET") {
				return subscription_type.JONGERENTICKET;
			}
			if (s.toUpperCase() == "SENIORENTICKET") {
				return subscription_type.SENIORENTICKET;
			}
			if (s.toUpperCase() == "FUNHOUR") {
				return subscription_type.FUNHOUR;
			}
			
			return null;
		}
	}
	
	private int id;
	private subscription_type type;
	private double price;
	private String startStation;
	private String endStation;
	private int customerId;
	private Date startDate;
	private Date endDate;
	
	public Subscription(subscription_type type, double price, int customerId, String endStation, String startStation,
			Date startDate, Date endDate) {
		this.type = type;
		this.price = price;
		this.startStation = startStation;
		this.endStation = endStation;
		this.customerId = customerId;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	
	public Subscription(int id, subscription_type type, double price, int customerId, String endStation, String startStation,
			Date startDate, Date endDate) {
		this(type, price, customerId, endStation, startStation, startDate, endDate);
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTicketType() {
		return type.toString();
	}

	public void setTicketType(subscription_type type) {
		this.type = type;
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
	
	public static double calculatePrice() {
		return 0.0;
	}
	
}
