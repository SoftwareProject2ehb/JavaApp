package model;


import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import data_control.*;
import model.Price;
import model.Price.betalingsType;
import utilities.DateConverter;
import model.Ticket;

import model.*;
import data_control.*;


public class Main {


	public static void main(String[] args) throws ParseException {
		SubscriptionDAO ad = new SubscriptionDAO();
		String startd = "2016-10-13 12:33:12";
		String endd = "2016-10-25 14:33:12";
		
		//hi
		Subscription a = ad.findSubById(2);
		ad.setActive(a);
	}
}