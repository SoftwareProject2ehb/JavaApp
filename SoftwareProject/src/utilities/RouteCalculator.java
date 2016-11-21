package utilities;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

import org.json.JSONArray;
import org.json.JSONObject;

public final class RouteCalculator {

	private RouteCalculator() {
	}
	
	//TODO Alle onderstaande methodes werken nog enkel bij een reis zonder overstappen. Deze moet nog worden aangepast om te kunnen werken met overstappen.
	
	public static String[] pathRoute(String station_1, String station_2) {
		String[] stops;
		
		try {
			JSONObject json_data = ApiAccesser.readJsonFromUrl("https://traintracks.online/api/Route/" + station_1 + "/" + station_2);
			JSONArray stations = json_data.getJSONArray("Routes").getJSONObject(0).getJSONArray("Trains").getJSONObject(0).getJSONObject("Stops").getJSONArray("Stations");
			stops = new String[stations.length()];
			
			for (int i = 0; i < stations.length() ; i++) {
				stops[i] = stations.getJSONObject(i).getString("Name");
			}
			
			return stops;
			
		} catch (IOException e) {
			return null;
		}
	}
	
	public static double calculateDistance(String station_1, String station_2) {
		double distance = 0;
		String station_1_coordinates = "";
		String station_2_coordinates = "";
		
		try {
			JSONObject json_data = ApiAccesser.readJsonFromUrl("https://traintracks.online/api/Route/" + station_1 + "/" + station_2);
			JSONArray stations = json_data.getJSONArray("Routes").getJSONObject(0).getJSONArray("Trains").getJSONObject(0).getJSONObject("Stops").getJSONArray("Stations");
			
			for (int i = 0; i < stations.length() ; i++) {
				if (station_1.equals(stations.getJSONObject(i).getString("Name"))) {
					station_1_coordinates = stations.getJSONObject(i).getString("Coordinates");
				} else if (station_2.equals(stations.getJSONObject(i).getString("Name"))) {
					station_2_coordinates = stations.getJSONObject(i).getString("Coordinates");
				}
			}
			
			if (station_1_coordinates == "" || station_2_coordinates == "")
				return 0;
			
			double[] station_1_coordinates_dbl = StringFunctions.convertCoordinates(station_1_coordinates);
			double[] station_2_coordinates_dbl = StringFunctions.convertCoordinates(station_2_coordinates);
			
			distance = DistanceCalculator.distance(station_1_coordinates_dbl[0], station_1_coordinates_dbl[1], station_2_coordinates_dbl[0], station_2_coordinates_dbl[1], "K");
			
		} catch (IOException e) {
			return 0;
		}
		return distance;
	}
	
	public static int calculateStations(String station_1, String station_2) {
		int station_1_index = -1, station_2_index = -1;
		try {
			JSONObject json_data = ApiAccesser.readJsonFromUrl("https://traintracks.online/api/Route/" + station_1 + "/" + station_2);
			JSONArray stations = json_data.getJSONArray("Routes").getJSONObject(0).getJSONArray("Trains").getJSONObject(0).getJSONObject("Stops").getJSONArray("Stations");
			
			for (int i = 0; i < stations.length() ; i++) {
				if (station_1.equals(stations.getJSONObject(i).getString("Name"))) {
					station_1_index = i;
				} else if (station_2.equals(stations.getJSONObject(i).getString("Name"))) {
					station_2_index = i;
				}
			}
			
			if (station_1_index == -1 || station_2_index == -1) {
				return 0;
			} else {
				return (station_1_index > station_2_index) ? (station_1_index - station_2_index) : (station_2_index - station_1_index);
			}
			
		} catch (IOException e) {
			return 0;
		}
	}
	
	/**
	 * 
	 * @return The value in hours, with minutes and seconds as a fraction of hours
	 */
	public static double calculateTime(String station_1, String station_2) {
		Timestamp station_1_time = null, station_2_time = null;
		try {
			JSONObject json_data = ApiAccesser.readJsonFromUrl("https://traintracks.online/api/Route/" + station_1 + "/" + station_2);
			//JSONObject json_data = ApiAccesser.readJsonFromUrl("http://dtsl.ehb.be/~bernd.wethmar/sp2.json");
			JSONArray stations = json_data.getJSONArray("Routes").getJSONObject(0).getJSONArray("Trains").getJSONObject(0).getJSONObject("Stops").getJSONArray("Stations");
			
			for (int i = 0; i < stations.length() ; i++) {
				if (station_1.equals(stations.getJSONObject(i).getString("Name"))) {
					station_1_time = StringFunctions.parseJSONTimestamp(stations.getJSONObject(i).getJSONObject("Time").getString("Departure"));
				} else if (station_2.equals(stations.getJSONObject(i).getString("Name"))) {
					station_2_time = StringFunctions.parseJSONTimestamp(stations.getJSONObject(i).getJSONObject("Time").getString("Arrival"));
				}
			}
			
			if (station_1_time == null || station_2_time == null) {
				return 0;
			} else {
				long total_time = station_2_time.getTime() - station_1_time.getTime();
				
				Date date = new Date ();
				date.setTime(total_time);
				
				//TODO Remove deprecated use of Date
				return (date.getHours() + (date.getMinutes() / 60.0) + (date.getSeconds() / 3600.0));
			}
			
		} catch (IOException e) {
			return 0;
		}
	}
}
