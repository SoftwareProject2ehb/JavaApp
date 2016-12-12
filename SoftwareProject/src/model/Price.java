package model;

import java.security.InvalidParameterException;
import java.util.ArrayList;

import data_control.PriceDAO;

public class Price {
	public enum betalingsType {
		PER_STATION, PER_KM, PER_HOUR, FIXED;
		
		@Override
		public String toString() {
			switch(this) {
			case PER_STATION: return "station";
			case PER_KM: return "km";
			case PER_HOUR: return "hour";
			case FIXED: return "fixed";
			default: throw new IllegalArgumentException();
			}
		}
		
		public String toCapsString() {
			switch(this) {
			case PER_STATION: return "PER_STATION";
			case PER_KM: return "PER_KM";
			case PER_HOUR: return "PER_HOUR";
			case FIXED: return "FIXED";
			default: throw new IllegalArgumentException();
			}
		}
		
		public static betalingsType stringToBetalingsType(String s) throws InvalidParameterException{
			if (s.toUpperCase().equals("PER_STATION") || s.toUpperCase().equals("STATION")) {
				return betalingsType.PER_STATION;
			} else if (s.toUpperCase().equals("PER_KM") || s.toUpperCase().equals("KM")) {
				return betalingsType.PER_KM;
			} else if (s.toUpperCase().equals("PER_HOUR") || s.toUpperCase().equals("HOUR")) {
				return betalingsType.PER_HOUR;
			} else if (s.toUpperCase().equals("FIXED")) {
				return betalingsType.FIXED;
			} else {
				throw new InvalidParameterException();
			}
		}
		
		public static ArrayList<betalingsType> getAll() {
			ArrayList<betalingsType> list = new ArrayList<betalingsType>();
			
			for (betalingsType bt : betalingsType.values()) {
				list.add(bt);
			}
			
			return list;
		}
		
		public static ArrayList<String> getAllAsString() {
			ArrayList<String> list = new ArrayList<String>();
			
			for (betalingsType bt : betalingsType.values()) {
				list.add(bt.toString());
			}
			
			return list;
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
		this.id = -1;
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
	
	@Override
	public String toString() {
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
