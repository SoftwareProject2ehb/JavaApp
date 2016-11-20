package utilities;

import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONObject;

public final class RouteCalculator {

	private RouteCalculator() {
	}
	
	public static void main(String[] args) {
		calculateDistance("Leuven", "Brugge");
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
		return 0;
	}
	
	/**
	 * 
	 * @return The value in hours, with minutes and seconds as a fraction of hours
	 */
	public static double calculateTime(String station_1, String station_2) {
		return 0;
	}
}
