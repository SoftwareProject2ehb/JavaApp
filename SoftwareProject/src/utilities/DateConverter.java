package utilities;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;


public class DateConverter {
	public static Date convert(String date) throws ParseException {
		java.util.Date utilDate = new SimpleDateFormat("yyyy-MM-dd").parse(date);
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		return sqlDate;
	}
	
	public static Timestamp timestampConverter (String timestampp) throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    java.util.Date parsedDate = dateFormat.parse(timestampp);
	    Timestamp timestamp = new java.sql.Timestamp(parsedDate.getTime());
	    return timestamp;
	}
	
	public static String getDate() {
		String d = "";
		
		d += LocalDate.now().getDayOfMonth();
		d += "/";
		d += LocalDate.now().getMonthValue();
		d += "/";
		d += LocalDate.now().getYear();
		
		return d;
	}
	
	public static String getTime() {
		String t = "";
		
		t += LocalTime.now().getHour();
		t += ":";
		t += LocalTime.now().getMinute();
		
		return t;
	}
}
