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
		if (typeTicket == null || typeBetaling == null || cpu < 0)
			throw new IllegalArgumentException();
		
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

	public int setTypeTicket(String typeTicket) {
		if (typeTicket == null)
			return 200;
		
		this.typeTicket = typeTicket;
		return 0;
	}

	public betalingsType getTypeBetaling() {
		return typeBetaling;
	}

	public int setTypeBetaling(betalingsType typeBetaling) {
		if (typeBetaling == null)
			return 200;
		
		this.typeBetaling = typeBetaling;
		return 0;
	}

	public double getCostPerUnit() {
		return costPerUnit;
	}

	public int setCostPerUnit(double costPerUnit) {
		if (costPerUnit < 0)
			return 100;
		
		this.costPerUnit = costPerUnit;
		return 0;
	}
}
