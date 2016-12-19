package utilities;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public abstract class Cacher {

	private static final String EXTENSION = ".txt";
	private static final String PATH = "../cache/";
	private static final Charset ENCODING = Charset.forName("UTF-8");
	
	public static String formatter(String from, String to)
	{
		String result = from + "-" + to + EXTENSION;
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
}
