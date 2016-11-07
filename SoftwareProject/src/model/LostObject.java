package model;

import java.sql.Date;

public class LostObject {
private int ID;
private int userID;
private String name;
private String Place;
// TO DO SET DATE
private String date;
private boolean claimed;
private String nameClaimed;
private String dateClaimed;



public LostObject(int iD, int userID, String name, String place, String date, boolean claimed, String nameClaimed,
		String dateClaimed) {
	super();
	ID = iD;
	this.userID = userID;
	this.name = name;
	Place = place;
	this.date = date;
	this.claimed = claimed;
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
public String getDateClaimed() {
	return dateClaimed;
}
public void setDateClaimed(String dateClaimed) {
	this.dateClaimed = dateClaimed;
}
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
} // TO DO SET DATE
public String getDate() {
	return date;
} // TO DO SET DATE
public int setDate(String date) {
	this.date = date;
	return 0;
}
@Override
public String toString() {
	return "LostObject [ID=" + ID + ", userID=" + userID + ", name=" + name + ", Place=" + Place + ", date=" + date
			+ ", claimed=" + claimed + ", nameClaimed=" + nameClaimed + ", dateClaimed=" + dateClaimed + "]";
}


}