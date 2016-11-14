package model;

import java.sql.Date;
import java.sql.Timestamp;

public class LostObject {
private int ID;
private int userID;
private String name;
private String Place;
// TO DO SET DATE
private Timestamp date;
private boolean claimed;
private int userIDClaimed;
private String locationClaimed;

private String nameClaimed;
private Timestamp dateClaimed;



public LostObject(int iD, int userID, String name, String place, Timestamp date, boolean claimed, int userIDClaimed, String locationClaimed,String nameClaimed,
		 Timestamp dateClaimed) {
	super();
	ID = iD;
	this.userID = userID;
	this.name = name;
	Place = place;
	this.date = date;
	this.claimed = claimed;
	this.userIDClaimed = userIDClaimed;
	this.locationClaimed = locationClaimed;
	this.nameClaimed = nameClaimed;
	this.dateClaimed = dateClaimed;
}
public boolean isClaimed() {
	return claimed;
}
public void setClaimed(boolean claimed) {
	this.claimed = claimed;
}
public String getNameClaimed() {
	return nameClaimed;
}
public void setNameClaimed(String nameClaimed) {
	this.nameClaimed = nameClaimed;
}
public Timestamp getDateClaimed() {
	return dateClaimed;
}
public void setDateClaimed(Timestamp dateClaimed) {
	this.dateClaimed = dateClaimed;
}
public LostObject(int userID, String name, String place) {
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
public Timestamp getDate() {
	return date;
} 
public int setDate(Timestamp date) {
	this.date = date;
	return 0;
}
public int getUserIDClaimed() {
	return userIDClaimed;
}
public void setUserIDClaimed(int userIDClaimed) {
	this.userIDClaimed = userIDClaimed;
}
public String getLocationClaimed() {
	return locationClaimed;
}
public void setLocationClaimed(String locationClaimed) {
	this.locationClaimed = locationClaimed;
}
@Override
public String toString() {
	return "ID=" + ID + "\n userID=" + userID + "\n name=" + name + "\n Place=" + Place + "\n date=" + date
			+ "\n claimed=" + claimed +"\n User id that claimed = "+userIDClaimed  +  "\nlocation claimed = "+locationClaimed  +"\n nameClaimed=" + nameClaimed + "\n dateClaimed=" + dateClaimed + "\n \n";
}


}