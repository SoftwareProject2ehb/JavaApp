package utilities;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.*;

import javax.swing.text.html.HTMLDocument.Iterator;

import java.io.*;
import org.json.*;

import model.RouteStation;

public abstract class ApiAccesser {
	
	/*
	 *Sites die ik gebruikt heb voor referentie:
	 *
	 *http://www.codingpedia.org/ama/how-to-handle-403-forbidden-http-status-code-in-java/
	 *voor errorcode 403 op te lossen
	 *http://stackoverflow.com/questions/4308554/simplest-way-to-read-json-from-a-url-in-java
	 *voor json te parsen via url
	 */
	
	// In dit bestand wordt alle informatie dat opgevraagd wordt van de api in een String gegoten en teruggegeven
	private static String readAll(Reader rd) throws IOException {
	    StringBuilder sb = new StringBuilder();
	    int cp;
	    while ((cp = rd.read()) != -1) {
	      sb.append((char) cp);
	    }
	    return sb.toString();
	  }
	
	// Deze methode opent de connectie met de api en geeft een json object terug met behulp van de hiervoor vermelde methode readAll.
	  public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
		  URLConnection openConnection = new URL(url).openConnection();
		  
		  // Deze code is van belang omdat dit de aanvraagt maskeert alsof we het via een browser vragen en
		  // voorkomt de 403 error.
			openConnection.addRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:25.0) Gecko/20100101 Firefox/25.0");
			InputStream is = openConnection.getInputStream();
	    try {
	      BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
	      String jsonText = readAll(rd);
	      JSONObject json = new JSONObject(jsonText);
	      return json;
	    } finally {
	      is.close();
	    }
	  }
	  
	 // Ik moet hier nog een stuk code schrijven om efficiënt informatie te verkijgen van het json object.
	 // Ook heb je een aparte json library nodig om dit te laten werken en ik zal die ook uploaden op de drive.
	  
	  
	  // Een route tussen a en b bevat veel meer informatie dan alleen de naam van het station dus
	  // ik ga nog een klasse moeten aanmaken die dat informatie kan opvangen 
	  // dus het returntype zal meer iets zijn zoals ArrayList<RouteStop>
	  public static void opvragingRoute(String a, String b, ArrayList<ArrayList<RouteStation>> routes, ArrayList<String> transfer_stations){
		 
		  ArrayList<RouteStation> stops;
		 
  
		  try {
		  JSONObject json_data = ApiAccesser.readJsonFromUrl("https://traintracks.online/api/Route/" + a + "/" + b);
		  
		  	/*
			String localTime = DateConverter.getDateOther() + " " + time + ":00";
			
			Timestamp ts = DateConverter.timestampConverter(localTime);
			*/
			for (int k=0;k<json_data.getJSONArray("Routes").getJSONObject(0).getJSONArray("Trains").length();k++) {
				stops = new ArrayList<RouteStation>();
				if (json_data.getJSONArray("Routes").getJSONObject(0).getJSONArray("Trains").length() < 1) {
					break;
				}
			
				JSONArray stations = json_data.getJSONArray("Routes").getJSONObject(0).getJSONArray("Trains").getJSONObject(k).getJSONObject("Stops").getJSONArray("Stations");
				JSONArray transfers_opslag = json_data.getJSONArray("Routes").getJSONObject(0).getJSONArray("TransferStations");
				for (int l=0;l<transfers_opslag.length();l++) {
					transfer_stations.add(transfers_opslag.getJSONObject(l).get("TransferAt").toString());
				}
				
				
				
				for (int i = 0; i < stations.length(); i++) {
					
					
					if (i == stations.length()-1) {
						RouteStation rs = new RouteStation (
								stations.getJSONObject(i).getString("Name"),
								stations.getJSONObject(i).getString("Coordinates"),
								stations.getJSONObject(i).getJSONObject("Time").getString("Arrival"),
								null,
								Integer.parseInt(stations.getJSONObject(i).getString("ArrivalPlatform")),
								0
								);
						
						stops.add(rs);
						
					} else if (i == 0) {
						RouteStation rs = new RouteStation (
								stations.getJSONObject(i).getString("Name"),
								stations.getJSONObject(i).getString("Coordinates"),
								null,
								stations.getJSONObject(i).getJSONObject("Time").getString("Departure"),
								0,
								Integer.parseInt(stations.getJSONObject(i).getString("DeparturePlatform"))
								);
						
						stops.add(rs);
						
					}else if (i < stations.length()-1) {
						RouteStation rs = new RouteStation (
								stations.getJSONObject(i).getString("Name"),
								stations.getJSONObject(i).getString("Coordinates"),
								stations.getJSONObject(i).getJSONObject("Time").getString("Arrival"),
								stations.getJSONObject(i).getJSONObject("Time").getString("Departure"),
								Integer.parseInt(stations.getJSONObject(i).getString("ArrivalPlatform")),
								Integer.parseInt(stations.getJSONObject(i).getString("DeparturePlatform"))
								);
						
						stops.add(rs);
					}
					
				}
				routes.add(stops);
				
			}
		  } catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			
			
		  

	  }

}
