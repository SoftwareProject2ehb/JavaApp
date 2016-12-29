package model;

import java.sql.Date;
import java.sql.Timestamp;


public class Train {




int id;
String start;
String arrival;
Timestamp startTime;
Timestamp arrivalTime;



public Train(int id, String start, String arrival, Timestamp startTime, Timestamp arrivalTime) {
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



public Timestamp getStartTime() {
	return startTime;
}



public void setStartTime(Timestamp startTime) {
	this.startTime = startTime;
}



public Timestamp getArrivalTime() {
	return arrivalTime;
}



public void Date(Timestamp arrivalTime) {
	this.arrivalTime = arrivalTime;
}


@Override
public String toString() {
	return "Train [id=" + id + ", start=" + start + ", arrival=" + arrival + ", startTime=" + startTime
			+ ", arrivalTime=" + arrivalTime + "]";
}


}