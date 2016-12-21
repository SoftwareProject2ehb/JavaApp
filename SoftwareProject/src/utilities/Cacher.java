package utilities;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import controller.SystemController;

public abstract class Cacher {

	private static String stationOfSystem;
	private static final String EXTENSION = ".json";
	private static final String PATH = "cache/";
	private static final Charset ENCODING = Charset.forName("UTF-8");
	
	public static String formatter(String from, String to)
	{
		String result = "cache_" + from.toLowerCase() + "_" + to.toLowerCase() + EXTENSION;
		return result;
	}
	
	public static String retrieve(String from, String to) throws IOException
	{
		String fileToRetrieve = Cacher.formatter(from, to);
		byte[] file = Files.readAllBytes(Paths.get(PATH + fileToRetrieve));
		return new String(file, ENCODING);
	}
	
	public static void delete(String from, String to) throws IOException
	{
		String fileToDelete = Cacher.formatter(from, to);
		Files.delete(Paths.get(PATH + fileToDelete));
	}
	
	public static void cache(String data, String from, String to) throws IOException
	{
		String fileToCache = Cacher.formatter(from, to);
		List<String> content = new ArrayList<String>();
		content.add(data);
		Files.write(Paths.get(PATH + fileToCache), content, ENCODING);
	}
	
	public static void cacheAll() throws MalformedURLException, IOException
	{
		List<String> stations = new ArrayList<String>(Arrays.asList(SystemController.getStations()));
		for(String s : stations)
		{
			try {
				cache(ApiAccesser.readJsonToCache(stationOfSystem, s), stationOfSystem, s);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void deleteAll()
	{
		File folder = new File("cache/");
		File[] allFiles = folder.listFiles();
		
		for (File file : allFiles) {
		    if (file.isFile()) {
		    	try {
					Files.delete(Paths.get(PATH + file.getName()));
				} catch (IOException e) {
					e.printStackTrace();
				}
		    }
		}


	}
	
	public static void setStationOfSystem(String station)
	{
		stationOfSystem = station;
	}
	
	public static String getStationOfSystem()
	{
		return stationOfSystem;
	}
}
