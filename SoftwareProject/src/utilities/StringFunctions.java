package utilities;

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
}
