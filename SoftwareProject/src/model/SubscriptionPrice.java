package model;

import data_control.SubscriptionPriceDAO;

public class SubscriptionPrice {
	private int id;
	private double lengthInMonths;
	private double price;
	
	public SubscriptionPrice(double lengthInMonths, double price) {
		super();
		this.id = -1;
		this.lengthInMonths = lengthInMonths;
		this.price = price;
	}
	
	public SubscriptionPrice(int id, double lengthInMonths, double price) {
		this(lengthInMonths, price);
		this.id = id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getLengthInMonths() {
		return this.lengthInMonths;
	}
	public void setLengthInMonths(double lengthInMonths) {
		this.lengthInMonths = lengthInMonths;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
}
