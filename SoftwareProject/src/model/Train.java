package model;

import java.sql.Date;
import java.time.LocalDateTime;

public class Train {
int id;
String start;
String arrival;
Date startTime;
Date arrivalTime;



public Train(int id, String start, String arrival, Date startTime, Date arrivalTime) {
	super();
	
	this.id = id;
	this.start = start;
	this.arrival = arrival;
	this.startTime = startTime;
	this.arrivalTime = arrivalTime;
}



public int getId() {
	return id;
}



public void setId(int id) {
	this.id = id;
}



public String getStart() {
	return start;
}



public void setStart(String start) {
	this.start = start;
}



public String getArrival() {
	return arrival;
}



public void setArrival(String arrival) {
	this.arrival = arrival;
}



public Date getStartTime() {
	return startTime;
}



public void setStartTime(Date startTime) {
	this.startTime = startTime;
}



public Date getArrivalTime() {
	return arrivalTime;
}



public void Date(Date arrivalTime) {
	this.arrivalTime = arrivalTime;
}


}