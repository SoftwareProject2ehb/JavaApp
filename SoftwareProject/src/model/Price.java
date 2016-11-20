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
		
		public static betalingsType stringToBetalingsType(String s) {
			if (s.toUpperCase() == "PER_STATION") {
				return betalingsType.PER_STATION;
			}
			if (s.toUpperCase() == "PER_KM") {
				return betalingsType.PER_KM;
			}
			if (s.toUpperCase() == "PER_HOUR") {
				return betalingsType.PER_HOUR;
			}
			if (s.toUpperCase() == "PER_ZONE") {
				return betalingsType.PER_ZONE;
			}
			
			return null;
		}
	};
	
	int id;
	String typeTicket;
	betalingsType typeBetaling;
	double costPerUnit;
	
	public Price (String typeTicket, betalingsType bt, double cpu) throws IllegalArgumentException {
		if (typeTicket == null || cpu < 0)
			throw new IllegalArgumentException();
		
		this.typeTicket = typeTicket;
		this.typeBetaling = bt;
		this.costPerUnit = cpu;
	}
	
	public Price (int id, String typeTicket, betalingsType bt, double cpu) throws IllegalArgumentException {
		this(typeTicket,bt,cpu);
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public int setId(int id) {
		this.id = id;
		return ErrorCode.NO_ERROR;
	}

	public String getPriceInfo() {
		return typeTicket + " : €" + costPerUnit + " / " + typeBetaling.toString();
	}
	
	public String getTypeTicket() {
		return typeTicket;
	}

	public int setTypeTicket(String typeTicket) {
		if (typeTicket == null)
			return ErrorCode.NULL_PARAM;
		
		this.typeTicket = typeTicket;
		return ErrorCode.NO_ERROR;
	}

	public betalingsType getTypeBetaling() {
		return typeBetaling;
	}

	public int setTypeBetaling(betalingsType typeBetaling) {
		/*if (typeBetaling == null)
			return ErrorCode.NULL_PARAM;*/
		
		this.typeBetaling = typeBetaling;
		return ErrorCode.NO_ERROR;
	}

	public double getCostPerUnit() {
		return costPerUnit;
	}

	public int setCostPerUnit(double costPerUnit) {
		if (costPerUnit < 0)
			return ErrorCode.INCORRECT_PARAM;
		
		this.costPerUnit = costPerUnit;
		return ErrorCode.NO_ERROR;
	}
}
