package model;

<<<<<<< HEAD
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import data_control.*;
import model.Price;
import model.Price.betalingsType;
import utilities.DateConverter;
import model.Ticket;
=======
import model.*;
import data_control.*;
>>>>>>> refs/heads/master

public class Main {

<<<<<<< HEAD
	public static void main(String[] args) throws ParseException {
		SubscriptionDAO ad = new SubscriptionDAO();
=======
	public static void main(String[] args) {
>>>>>>> refs/heads/master
		
<<<<<<< HEAD
		String startd = "2016-10-13 12:33:12";
		String endd = "2016-10-25 14:33:12";
		
		//hi
		Subscription a = new Subscription(3, "seniorenticket", 69, 2, "Zele", "Hel", DateConverter.convert(startd), DateConverter.convert(endd));
=======
>>>>>>> refs/heads/master
	}
}