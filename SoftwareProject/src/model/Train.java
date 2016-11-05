package model;

import java.time.LocalDateTime;

public class Train {
int trainId;
String start;
String arrival;
LocalDateTime startTime;
LocalDateTime arrivalTime;



public Train(int trainId, String start, String arrival, LocalDateTime startTime, LocalDateTime arrivalTime) {
	super();
	this.trainId = trainId;
	this.start = start;
	this.arrival = arrival;
	this.startTime = startTime;
	this.arrivalTime = arrivalTime;
}



public int getTrainId() {
	return trainId;
}



public void setTrainId(int trainId) {
	this.trainId = trainId;
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



public LocalDateTime getStartTime() {
	return startTime;
}



public void setStartTime(LocalDateTime startTime) {
	this.startTime = startTime;
}



public LocalDateTime getArrivalTime() {
	return arrivalTime;
}



public void setArrivalTime(LocalDateTime arrivalTime) {
	this.arrivalTime = arrivalTime;
}


}