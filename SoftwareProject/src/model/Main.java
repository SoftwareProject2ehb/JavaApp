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

	public static void main(String[] args) throws JSONException, IOException, ParseException {
		//SystemController.startUp();
		ArrayList<ArrayList<RouteStation>> list = ApiAccesser.opvragingRoute("Lokeren", "Gent-Sint-Pieters", "21:00");
		System.out.println(list.size());
		
			for (RouteStation rs: list.get(0)) {
				System.out.println(rs.getNaam());
				System.out.println(rs.getCoordinates());
				System.out.println(rs.getDeparturePlatform());
				System.out.println(rs.getArrivalPlatform());
				System.out.println(rs.getArrivalTime());
				System.out.println(rs.getDepartureTime());
				System.out.println();
			}
			
			
			System.out.println();
			System.out.println("new Route");
			System.out.println();
			
			for (RouteStation rs: list.get(1)) {
				System.out.println(rs.getNaam());
				System.out.println(rs.getCoordinates());
				System.out.println(rs.getDeparturePlatform());
				System.out.println(rs.getArrivalPlatform());
				System.out.println(rs.getArrivalTime());
				System.out.println(rs.getDepartureTime());
				System.out.println();
			}
		
	}
}