package model;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import org.json.JSONException;

import controller.*;
import utilities.ApiAccesser;
import view.BuySubscriptionView;
import view.FindSubscriptionView;

public class Main {

	public static void main(String[] args){
		//SystemController.startUp();
		Route rs = new Route("Zele", "Charleroi-sud");
		ArrayList<RouteStation> essentials = new ArrayList<RouteStation>(rs.getRouteEssentials());
		
		for (RouteStation stop: essentials) {
			System.out.println(stop.getNaam());
			System.out.println(stop.getArrivalTime());
			System.out.println(stop.getDepartureTime());
			System.out.println(stop.getArrivalPlatform());
			System.out.println(stop.getDeparturePlatform());
		}
	}
}