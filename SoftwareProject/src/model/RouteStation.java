package model;

public class RouteStation {
	private String naam;
	private String coordinates;
	private String arrivalTime;
	private String departureTime;
	private String arrivalPlatform;
	private String departurePlatform;
	
	public RouteStation(String naam, String coordinates, String arrivalTime, String departureTime, String arrivalPlatform,
			String departurePlatform) {
		super();
		this.naam = naam;
		this.coordinates = coordinates;
		this.arrivalTime = arrivalTime;
		this.departureTime = departureTime;
		this.arrivalPlatform = arrivalPlatform;
		this.departurePlatform = departurePlatform;
	}

	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

	public String getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(String coordinates) {
		this.coordinates = coordinates;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	public String getArrivalPlatform() {
		return arrivalPlatform;
	}

	public void setArrivalPlatform(String arrivalPlatform) {
		this.arrivalPlatform = arrivalPlatform;
	}

	public String getDeparturePlatform() {
		return departurePlatform;
	}

	public void setDeparturePlatform(String departurePlatform) {
		this.departurePlatform = departurePlatform;
	}
	
	
}
