package model;

public class Address {
	String street;
	String number;
	String bus;
	int postalCode;
	String city;
	String country;
	
	public Address(String street, String number, String bus, int postalCode, String city, String country) {
		if (street == null || number == null || bus == null || city == null || country == null)
			throw new IllegalArgumentException();
		
		this.street = street;
		this.number = number;
		this.bus = bus;
		this.postalCode = postalCode;
		this.city = city;
		this.country = country;
	}
	
	public String getStreet() {
		return street;
	}

	public int setStreet(String street) {
		if (street == null)
			return ErrorCode.NULL_PARAM;
		
		this.street = street;
		return ErrorCode.NO_ERROR;
	}

	public String getNumber() {
		return number;
	}

	public int setNumber(String number) {
		if (number == null)
			return ErrorCode.NULL_PARAM;
		
		this.number = number;
		return ErrorCode.NO_ERROR;
	}

	public String getBus() {
		return bus;
	}

	public int setBus(String bus) {
		if (bus == null)
			return ErrorCode.NULL_PARAM;
		
		this.bus = bus;
		return ErrorCode.NO_ERROR;
	}

	public int getPostalCode() {
		return postalCode;
	}

	public int setPostalCode(int postalCode) {
		this.postalCode = postalCode;
		return ErrorCode.NO_ERROR;
	}

	public String getCity() {
		return city;
	}

	public int setCity(String city) {
		if (city == null)
			return ErrorCode.NULL_PARAM;
		
		this.city = city;
		return ErrorCode.NO_ERROR;
	}

	public String getCountry() {
		return country;
	}

	public int setCountry(String country) {
		if (country == null)
			return ErrorCode.NULL_PARAM;
		
		this.country = country;
		return ErrorCode.NO_ERROR;
	}
}