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

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

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
	  
	  public static JSONObject readJsonFromLocal(String a, String b){
		  
		  JSONObject jsonn = null;
	      BufferedReader rdd;
		try {
				rdd = new BufferedReader(new FileReader("offline_files/offlinejsondoc_" + a.toLowerCase() + "_" + b.toLowerCase() + ".json"));
				String jsonText = readAll(rdd);
				jsonn = new JSONObject(jsonText);
				return jsonn;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	     
	   return jsonn;
	  }
	  
	 // Ik moet hier nog een stuk code schrijven om efficiënt informatie te verkijgen van het json object.
	 // Ook heb je een aparte json library nodig om dit te laten werken en ik zal die ook uploaden op de drive.
	  
	  
	  // Een route tussen a en b bevat veel meer informatie dan alleen de naam van het station dus
	  // ik ga nog een klasse moeten aanmaken die dat informatie kan opvangen 
	  // dus het returntype zal meer iets zijn zoals ArrayList<RouteStop>
	  public static void opvragingRoute(String a, String b, ArrayList<ArrayList<RouteStation>> routes, ArrayList<ArrayList<String>> transfer_stations){
		 
		  ArrayList<RouteStation> stops = new ArrayList<RouteStation>();
		  ArrayList<String> transfers_per_route = new ArrayList<String>();
		  ArrayList<JSONArray> stations = new ArrayList<JSONArray>();
		  try {
		  JSONObject json_data = ApiAccesser.readJsonFromUrl("https://traintracks.online/api/Route/" + a + "/" + b);
		  //JSONObject json_data = ApiAccesser.readJsonFromLocal(a, b);
		  
		  	
		  JSONArray transfers_opslag = json_data.getJSONArray("Routes").getJSONObject(0).getJSONArray("TransferStations");
		  
		  
			for (int k=0;k<json_data.getJSONArray("Routes").getJSONObject(0).getJSONArray("Trains").length();k++) {
				
				
				
				stations.add( json_data.getJSONArray("Routes").getJSONObject(0).getJSONArray("Trains").getJSONObject(k).getJSONObject("Stops").getJSONArray("Stations"));
				
				
				
				for (int i = 0; i < stations.get(k).length(); i++) {
					
					
					
				 stops.add( new RouteStation (
							stations.get(k).getJSONObject(i).getString("Name"),
							stations.get(k).getJSONObject(i).getString("Coordinates"),
							stations.get(k).getJSONObject(i).getJSONObject("Time").get("Arrival").toString(),
							stations.get(k).getJSONObject(i).getJSONObject("Time").get("Departure").toString(),
							stations.get(k).getJSONObject(i).get("ArrivalPlatform").toString(),
							stations.get(k).getJSONObject(i).get("DeparturePlatform").toString()
							));
					
					
				
					
				}
				routes.add(new ArrayList<>(stops));
				transfers_per_route.add(transfers_opslag.getJSONObject(k).get("TransferAt").toString());
				stops.clear();
				
			}
			transfer_stations.add(new ArrayList<String>(transfers_per_route));
			
		  } catch (JSONException e) {
				e.printStackTrace();
			} catch (IOException e) {
				stops.removeAll(stops);
				transfer_stations.removeAll(transfer_stations);
			}
	  }

}
