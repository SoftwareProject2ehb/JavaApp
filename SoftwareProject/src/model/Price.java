package model;

public class Price {
	public enum betalingsType {
		PER_STATION, PER_KM, PER_HOUR, PER_ZONE;
		
		@Override
		public String toString() {
			switch(this) {
			case PER_STATION: return "station";
			case PER_KM: return "km";
			case PER_HOUR: return "hour";
			case PER_ZONE: return "zone";
			default: throw new IllegalArgumentException();
			}
		}
	};
	
	String typeTicket;
	betalingsType typeBetaling;
	double costPerUnit;
	
	public Price (String typeTicket, betalingsType bt, double cpu) {
		this.typeTicket = typeTicket;
		this.typeBetaling = bt;
		this.costPerUnit = cpu;
	}

	public String getPriceInfo() {
		return typeTicket + " : €" + costPerUnit + " / " + typeBetaling.toString();
	}
	
	public String getTypeTicket() {
		return typeTicket;
	}

	public void setTypeTicket(String typeTicket) {
		this.typeTicket = typeTicket;
	}

	public betalingsType getTypeBetaling() {
		return typeBetaling;
	}

	public void setTypeBetaling(betalingsType typeBetaling) {
		this.typeBetaling = typeBetaling;
	}

	public double getCostPerUnit() {
		return costPerUnit;
	}

	public void setCostPerUnit(double costPerUnit) {
		this.costPerUnit = costPerUnit;
	}
}
