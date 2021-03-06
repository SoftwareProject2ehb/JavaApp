package utilities;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;


public class DateConverter {
	public static Date convert(String date) throws ParseException {
		java.util.Date utilDate = new SimpleDateFormat("dd/MM/yyyy").parse(date);
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
		if (LocalDate.now().getDayOfMonth() < 10)
			d += "0" + LocalDate.now().getDayOfMonth();
		else
			d += LocalDate.now().getDayOfMonth();
		d += "/";
		if ( LocalDate.now().getMonthValue() < 10)
			d += "0" +  LocalDate.now().getMonthValue();
		else
			d += LocalDate.now().getMonthValue();
		d += "/";
		d += LocalDate.now().getYear();
		
		return d;
	}
	
	public static String getDateOther() {
		String d = "";
		
		d += LocalDate.now().getYear();
		d += "-";
		d += LocalDate.now().getMonthValue();
		d += "-";
		d += LocalDate.now().getDayOfMonth();
		
		
		return d;
	}
	
	public static String getTime() {
		String t = "";
		int hour = LocalTime.now().getHour();
		int min = LocalTime.now().getMinute();
		
		t += (hour<10)?("0"+hour):hour;
		t += ":";
		t += (min<10)?("0"+min):min;
		
		return t;
	}
}
