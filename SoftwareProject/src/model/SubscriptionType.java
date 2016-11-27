package model;

import data_control.SubscriptionTypeDAO;

public class SubscriptionType {
	private int id;
	private String name;
	private double factor;
	
	public SubscriptionType(String name, double factor) {
		super();
		this.id = -1;
		this.name = name;
		this.factor = factor;
	}
	
	public SubscriptionType(int id, String name, double factor) {
		this(name, factor);
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getFactor() {
		return factor;
	}

	public void setFactor(double factor) {
		this.factor = factor;
	}
	
	
}
