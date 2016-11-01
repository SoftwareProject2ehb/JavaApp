package model;

import java.sql.Date;

public class LostObject {
private int ID;
private int userID;
private String name;
private String Place;
private String date;




public LostObject(int userID, String name, String place, String date) {
	super();
	this.userID = userID;
	this.name = name;
	this.Place = place;
	this.date = date;
}
public int getID() {
	return ID;
}
public int setID(int iD) {
	if (iD == 0)
		return 200;
	
	
	
	
	this.ID = iD;
	return 0;
}
public int getUserID() {
	return userID;
}
public int setUserID(int userID) {
	if (userID == 0)
		return 200;
	
	this.userID = userID;
	return 0;
}
public String getName() {
	return name;
}
public int setName(String name) {
	if ( name == null)
		return 200;
	
	
	this.name = name;
	return 0;
}
public String getPlace() {
	return Place;
}
public int setPlace(String place) {
	if ( place == null)
		return 200;
	Place = place;
	return 0;
}
public String getDate() {
	return date;
}
public int setDate(String date) {
	this.date = date;
	return 0;
}
}