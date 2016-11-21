package model;

public class SubscriptionPrice {
	private int id;
	private double lengthInMonths;
	private double price;
	public SubscriptionPrice(int id, double lengthInMonths, double price) {
		super();
		this.id = id;
		this.lengthInMonths = lengthInMonths;
		this.price = price;
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
