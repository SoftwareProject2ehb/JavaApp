package model;

public class SubscriptionType {
	private int id;
	private String name;
	private double factor;
	
	public SubscriptionType(int id, String name, double factor) {
		super();
		this.id = id;
		this.name = name;
		this.factor = factor;
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
