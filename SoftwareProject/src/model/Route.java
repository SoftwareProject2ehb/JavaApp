package model;

import java.io.IOException;
import java.text.ParseException;
import java.util.*;

import org.json.JSONException;

import utilities.ApiAccesser;

public class Route {
	private ArrayList<ArrayList<RouteStation>> routes;
	private ArrayList<String> transfer_stations;
	private ArrayList<RouteStation> queried_route;
	private String begin_station;
	private String eind_station;
	
	public Route(String begin_station, String eind_station) {
		routes = new ArrayList<ArrayList<RouteStation>>();
		transfer_stations = new ArrayList<String>();

		ApiAccesser.opvragingRoute(begin_station, eind_station, routes, transfer_stations);
	
	}
	
	public void transfers () {
		for (String name: transfer_stations) {
			System.out.println(name);
		}
	}
	
	public void routes () {
		for (ArrayList<RouteStation> route: routes) {
			for (RouteStation rs: route) {
				System.out.println(rs.getNaam());
				System.out.println(rs.getCoordinates());
				System.out.println(rs.getArrivalTime());
				System.out.println(rs.getDepartureTime());
				System.out.println(rs.getArrivalPlatform());
				System.out.println(rs.getDeparturePlatform());
			}
			
			System.out.println();
			System.out.println("New Route");
		}
	}
}
