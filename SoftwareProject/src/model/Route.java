package model;

import java.io.IOException;
import java.text.ParseException;
import java.util.*;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import utilities.ApiAccesser;

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
						transfer_gevonden = false;
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
							} else if (h == route_index)  {
								queried_route.add(routes.get(h).get(f));
							}
							
							else if (routes.get(h).get(f).getNaam().toLowerCase().contains(transfer_stations.get(0).get(m).toLowerCase())) {
								queried_route.add(routes.get(h).get(f));
								transfer_gevonden = true;
								m++;
								break;
							}  else  {
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
	
	
}
