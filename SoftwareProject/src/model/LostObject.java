package model;

import java.sql.Date;
import java.sql.Timestamp;

import data_control.LostObjectDAO;

public class LostObject {
private int id;
private int user_id;
private String name;
private String place;
// TO DO SET DATE
private Timestamp date;
private boolean claimed;
private int user_id_claimed;
private String location_claimed;

private String name_claimed;
private Timestamp date_claimed;

//Constructor voor het maken van een found object
public LostObject(int user_id, String name, String place, Timestamp date) {
	super();
	this.user_id = user_id;
	this.name = name;
	this.place = place;
	this.date = date;
	this.id = LostObjectDAO.findNextId();
}
//Constructor voor het updaten van een bestaand object
public LostObject(int userID, String name, String place, Timestamp date, boolean claimed, int user_id_claimed, String location_claimed,String name_claimed,
		 Timestamp date_claimed) {
	this(userID, name, place, date);
	this.claimed = claimed;
	this.user_id_claimed = user_id_claimed;
	this.location_claimed = location_claimed;
	this.name_claimed = name_claimed;
	this.date_claimed = date_claimed;
	this.id = LostObjectDAO.findNextId();
}
//Constructor for the whole ost object

public LostObject(int id, int userid, String name, String place, Timestamp timefound, boolean claimed, int userclaimed,
		String location, String nameclaimed, Timestamp timeclaimed) {
	this.id = id;
	this.user_id = userid;
	this.name = name;
	this.place = place;
	this.date = timefound;
	this.claimed = claimed;
	this.user_id_claimed = userclaimed;
	this.location_claimed = location;
	this.name_claimed = nameclaimed;
	this.date_claimed = timeclaimed;
}
/*
public LostObject(int id, int user_id, String name, String place, Timestamp date, boolean claimed, int user_id_claimed, String location_claimed,String name_claimed, Timestamp date_claimed) {
	this(user_id, name, place, date, claimed, user_id_claimed, location_claimed, name_claimed, date_claimed);
	this.id = id;
}*/
public LostObject(String name, String place) {
	super();
	
	this.name = name;
	this.place = place;
	
}
public LostObject() {
	// TODO Auto-generated constructor stub
}
public boolean isClaimed() {
	return claimed;
}
public void setClaimed(boolean claimed) {
	this.claimed = claimed;
}
public String getNameClaimed() {
	return name_claimed;
}
public void setNameClaimed(String nameClaimed) {
	this.name_claimed = nameClaimed;
}
public Timestamp getDateClaimed() {
	return date_claimed;
}
public void setDateClaimed(Timestamp date_claimed) {
	this.date_claimed = date_claimed;
}

public int getID() {
	return id;
}
public int setID(int id) {
	if (id == 0)
		return ErrorCode.INCORRECT_PARAM;
	
	this.id = id;
	return 0;
}
public int getUserID() {
	return user_id;
}
public int setUserID(int user_id) {
	if (user_id == 0)
		return ErrorCode.INCORRECT_PARAM;
	
	this.user_id = user_id;
	return 0;
}
public String getName() {
	return name;
}
public int setName(String name) {
	if ( name == null)
		return ErrorCode.NULL_PARAM;
	
	this.name = name;
	return 0;
}
public String getPlace() {
	return place;
}
public int setPlace(String place) {
	if ( place == null)
		return 200;
	place = place;
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
	return user_id_claimed;
}
public void setUserIDClaimed(int user_id_claimed) {
	this.user_id_claimed = user_id_claimed;
}
public String getLocationClaimed() {
	return location_claimed;
}
public void setLocationClaimed(String location_claimed) {
	this.location_claimed = location_claimed;
}
@Override
public String toString() {
	return "ID=" + id + "\n userID=" + user_id + "\n name=" + name + "\n Place=" + place + "\n date=" + date
			+ "\n claimed=" + claimed +"\n User id that claimed = "+ user_id_claimed  +  "\nlocation claimed = "+ location_claimed  +"\n nameClaimed=" + name_claimed + "\n dateClaimed=" + date_claimed + "\n \n";
}


}