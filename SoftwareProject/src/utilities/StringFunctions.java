package utilities;

import java.sql.Timestamp;
import java.text.ParseException;

public final class StringFunctions {

	private StringFunctions() {}
	
	/**
	 * 
	 * @param coordinates The coordinates are entered in the format "EE...EE, NN...NN" 
	 * @return Will return the double conversion of the coordinates, with latitude first (N°) and longtitude second (E°)
	 */
	public static double[] convertCoordinates(String coordinates) {
		String[] array = coordinates.split(", ");
		array[0] = array[0].substring(0, 1) + "." + array[0].substring(1, array[0].length());
		array[1] = array[1].substring(0, 2) + "." + array[1].substring(2, array[1].length());
		
		double[] return_array = new double[2];
		
		return_array[0] = Double.parseDouble(array[1]);
		return_array[1] = Double.parseDouble(array[0]);
		
		return return_array;
		
	}
	
	public static Timestamp parseJSONTimestamp(String timestamp) {
		int year = Integer.parseInt(timestamp.substring(0,4));
		int month = Integer.parseInt(timestamp.substring(5,7));
		int day = Integer.parseInt(timestamp.substring(8,10));
		
		int hours = Integer.parseInt(timestamp.substring(11,13));
		int minutes = Integer.parseInt(timestamp.substring(14,16));
		int seconds = Integer.parseInt(timestamp.substring(17,19));
		
		try {
			return DateConverter.timestampConverter(year + "-" + month + "-" + day + " " + hours + ":" + minutes + ":" + seconds);
		} catch (ParseException e) {
			return null;
		}
	}
}
