package utilities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Language {
	public enum LANGUAGE {DUTCH, FRENCH, ENGLISH};
	
	private static TreeMap<String, String> variables = new TreeMap<String, String>();
	private static LANGUAGE currentLanguage;
	
	public static void setLanguage(LANGUAGE language)
	{
		currentLanguage = language;
	}
	
	public static void refresh()
	{
		variables = null;
		variables = new TreeMap<String, String>();
		
		try {
			readFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void readFile() throws IOException
	{	
		String file = "nl.txt";
		switch(currentLanguage)
		{
		case DUTCH:
			file = "nl.txt";
			break;
		case FRENCH:
			file = "fr.txt";
			break;
		case ENGLISH:
			file = "en.txt";
			break;
		default:
			file = "nl.txt";
			break;
		}
		BufferedReader br = new BufferedReader(new FileReader("language-files/" + file));
		System.out.println(file);
		String line = null;
		while ((line = br.readLine()) != null) {
			Pattern p1 = Pattern.compile(".*\\$ *(.*) *\\$.*");
	        Matcher m1 = p1.matcher(line);
	        m1.find();
	        String key = m1.group(1);
	        Pattern p2 = Pattern.compile(".*\\\" *(.*) *\\\".*");
	        Matcher m2 = p2.matcher(line);
	        m2.find();
	        String value = m2.group(1);
			variables.put(key, value);
		}
		br.close();
	}
	
	public static String getString(String name)
	{
		return variables.get(name);
	}
}
