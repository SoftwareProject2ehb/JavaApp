package model;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.*;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import utilities.ApiAccesser;
import utilities.DateConverter;
import utilities.DistanceCalculator;
import utilities.StringFunctions;

public class Route {
	private ArrayList<ArrayList<RouteStation>> routes;
	private ArrayList<ArrayList<String>> transfer_stations;
	private ArrayList<RouteStation> queried_route = new ArrayList<RouteStation>();
	private String begin_station;
	private String eind_station;
	
	public Route(String begin_station, String eind_station) {
		routes = new ArrayList<ArrayList<RouteStation>>();
		transfer_stations = new ArrayList<ArrayList<String>>();
		this.begin_station = begin_station;
		this.eind_station = eind_station;

		ApiAccesser.opvragingRoute(begin_station, eind_station, routes, transfer_stations);
		fillQueriedRouteWithTransfers();
	}
	
	public void transfers () {
		for (ArrayList<String> transfers: transfer_stations) {
			for (String name: transfers) {
			System.out.println(name);
			}
			System.out.println();
			System.out.println("New TransferRoutes");
			System.out.println();
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
			System.out.println();
			
		}
	}
	
	public boolean fillQueriedRouteWithoutTransfers() {
		boolean eind = false;
		boolean start = false;
		for (int i=0;i<routes.size();i++) {
			if (eind) {
				break;
			}
			for (int k=0;i<routes.get(i).size();k++) {
				if (!start) {
					if (routes.get(i).get(k).getNaam().toLowerCase().contains(this.begin_station.toLowerCase())) {
						
						queried_route.add(routes.get(i).get(k));
						
						start = true;
					}
				}
				
				else if (start && !eind) {
					if (k > 14) {
						break;
					}
					if (routes.get(i).get(k).getNaam().toLowerCase().contains(this.eind_station.toLowerCase())) {
						queried_route.add(routes.get(i).get(k));
						eind = true;
						
						break;
					} else {
						queried_route.add(routes.get(i).get(k));
					}
				}
				
			}
		}
		
		
		return eind;
	}
	
	public void fillQueriedRouteWithTransfers() {
		
			boolean eind = false;
			boolean start = false;
			boolean queried_route_compleet = false;
			boolean transfer_gevonden = false;
			int route_index = -1;
			int station_index = -1;
			for (int i=0;i<routes.size();i++) {
				if (eind) {
					break;
				}
				for (int k=0;k<routes.get(i).size();k++) {
					if (routes.get(i).get(k).getNaam().toLowerCase().contains(eind_station.toLowerCase())){
						eind = true;
						route_index = i;
						station_index = k;
						break;
					}
				}
			}
			if (eind && route_index == 0) {
				fillQueriedRouteWithoutTransfers();
			}else if (eind) {
					int m = 1;
					
					for (int h=0;h<routes.size();h++) {
						
						if (queried_route_compleet) {
							break;
						}
						
						for (int f=0;f<routes.get(h).size();f++) {
							
							if (!start) {
								if (routes.get(h).get(f).getNaam().toLowerCase().contains(this.begin_station.toLowerCase())) {
									
									queried_route.add(routes.get(h).get(f));
									
									start = true;
								}
							}
							else if (h == route_index && f == station_index){
								queried_route.add(routes.get(h).get(f));
								queried_route_compleet = true;
								break;
							}
							else if (h == route_index && !transfer_gevonden) {
								queried_route.add(routes.get(h).get(f));
							}
							else if (routes.get(h).get(f).getNaam().toLowerCase().contains(transfer_stations.get(0).get(m).toLowerCase())) {
								queried_route.add(routes.get(h).get(f));
								if (!transfer_gevonden) {
									transfer_gevonden = true;
									break;
								} else {
									transfer_gevonden = false;
									m++;
								}
								
							}  else if (!transfer_gevonden)  {
								queried_route.add(routes.get(h).get(f));
							}
						}
					}
				
			}
		
	}
	
	public void showQueriedRoute() {
		
		for (RouteStation rs: this.queried_route) {
			System.out.println(rs.getNaam());
			System.out.println(rs.getCoordinates());
			System.out.println(rs.getArrivalTime());
			System.out.println(rs.getDepartureTime());
			System.out.println(rs.getArrivalPlatform());
			System.out.println(rs.getDeparturePlatform());
		}
	}
	
	public ArrayList<RouteStation> getQueriedRoute() {
		return this.queried_route;
	}
	
	public double calculateDistance() {
		double distance = 0;
		
		String station_1_coordinates;
		String station_2_coordinates;
		int count = 0;
		while (count < queried_route.size()-1) {
		
		station_1_coordinates = queried_route.get(count).getCoordinates();
		count++;
		station_2_coordinates = queried_route.get(count).getCoordinates();
			
			
		if (station_1_coordinates == "" || station_2_coordinates == "")
			return 0;
		
		double[] station_1_coordinates_dbl = StringFunctions.convertCoordinates(station_1_coordinates);
		double[] station_2_coordinates_dbl = StringFunctions.convertCoordinates(station_2_coordinates);
		
		distance += DistanceCalculator.distance(station_1_coordinates_dbl[0], station_1_coordinates_dbl[1], station_2_coordinates_dbl[0], station_2_coordinates_dbl[1], "K");
			
		}
		return distance;
	}
	
	public double calculateTime() {
		Timestamp station_1_time = null, station_2_time = null;
		
			try {
				station_1_time = DateConverter.timestampConverter(queried_route.get(0).getDepartureTime().replaceAll("T", " "));
				station_2_time = DateConverter.timestampConverter(queried_route.get(queried_route.size()-1).getArrivalTime().replaceAll("T", " "));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			// get time difference in seconds
		    long milliseconds = station_2_time.getTime() - station_1_time.getTime();
		    double seconds = (int) milliseconds / 1000;
		 
		    // calculate hours minutes and seconds
		    double hours = seconds / 3600;
		    
		    /* niet nodig
		    int minutes = (seconds % 3600) / 60;
		    seconds = (seconds % 3600) % 60;
		    */
		    
		    return hours;
		    
			
		
	}
	
	
}
