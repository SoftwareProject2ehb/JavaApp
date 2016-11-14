package model;
import utilities.*;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.json.JSONException;
import org.json.JSONObject;

import data_control.*;
import model.Price.betalingsType;
import utilities.DateConverter;
import model.*;
import data_control.*;


public class Main {


	public static void main(String[] args) throws ParseException, JSONException, IOException {
	/*	JSONObject json = ApiAccesser.readJsonFromUrl("https://traintracks.online/api/Route/Zele/Brussel-Zuid");
		System.out.println("Jouw Verbindingen: Zele - Brussel-Zuid");
		
		JSONArray msg = (JSONArray) json.get("Routes");
		JSONObject ob1 = msg.getJSONObject(0);
		
		System.out.println(json.get("StepOn"));
		System.out.println(json.get("StepOff"));
		System.out.println();
		System.out.println(json.get("Routes"));*/
		
		SubscriptionDAO sd = new SubscriptionDAO();
		
		
		
		Subscription testObj = sd.findSubById(1);
		System.out.println(testObj.getId() + " " + testObj.getTicketType() + " " + testObj.getPrice() + " " +testObj.getCustomerId() + " " + testObj.getStartStation() + " " + testObj.getEndStation()
				
		+ " " +testObj.getStartDate() + " " + testObj.getEndDate());
	}
}