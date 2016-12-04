package model;

import data_control.SubscriptionPriceDAO;
import model.Price.betalingsType;

public class SubscriptionPrice {
	@Override
	public String toString() {
		return typeSubscription;
	}

	private int id;
	private String typeSubscription;
	private betalingsType typeBetaling;
	private double costPerUnit;
	private double lengthInMonths;
	
	public SubscriptionPrice(String typeSubscription, betalingsType typeBetaling, double costPerUnit, double lengthInMonths) {
		super();
		this.id = -1;
		this.typeSubscription = typeSubscription;
		this.typeBetaling = typeBetaling;
		this.costPerUnit = costPerUnit;
		this.lengthInMonths = lengthInMonths;
	}
	
	public SubscriptionPrice(int id, String typeSubscription, betalingsType typeBetaling, double costPerUnit, double lengthInMonths) {
		this(typeSubscription, typeBetaling, costPerUnit, lengthInMonths);
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
	public double getCostPerUnit() {
		return costPerUnit;
	}
	public void setCostPerUnit(double costPerUnit) {
		this.costPerUnit = costPerUnit;
	}

	public String getTypeSubscription() {
		return typeSubscription;
	}

	public void setTypeSubscription(String typeSubscription) {
		this.typeSubscription = typeSubscription;
	}

	public betalingsType getTypeBetaling() {
		return typeBetaling;
	}

	public void setTypeBetaling(betalingsType typeBetaling) {
		this.typeBetaling = typeBetaling;
	}
}