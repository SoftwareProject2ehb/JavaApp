package model;
import java.sql.Date;
import java.time.LocalDateTime;

import data_control.SubscriptionDAO;
import data_control.SubscriptionPriceDAO;

public class Subscription {
	
	private int id;
	private String type;
	private double price;
	private String startStation;
	private String endStation;
	private int customerId;
	private Date startDate;
	private Date endDate;
	private int active;

	public Subscription(String type, double price, int customerId, String endStation, String startStation,
			Date startDate, Date endDate) {
		this.id = -1;
		this.type = type;
		this.price = price;
		this.startStation = startStation;
		this.endStation = endStation;
		this.customerId = customerId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.active = 1;
	}
	
	public Subscription(String type, double price, int customerId, String endStation, String startStation,
			Date startDate, Date endDate, int active) {
		this(type, price, customerId, endStation, startStation, startDate, endDate);
		this.active = active;
	}
	
	public Subscription(int id, String type, double price, int customerId, String endStation, String startStation,
			Date startDate, Date endDate, int active) {
		this(type, price, customerId, endStation, startStation, startDate, endDate, active);
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSubscriptionType() {
		return type;
	}

	public void setSubscriptionType(String type) {
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
	
	public int getActive() {
		return this.active;
	}

	public void setActived(int active) {
		this.active = active;
	}
}