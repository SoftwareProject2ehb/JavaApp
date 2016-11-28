package unit_tests;

import static org.junit.Assert.*;

import java.sql.Timestamp;
import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.LogFile;

public class LogFileTest {
	
	private LogFile log;

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testConstructor() {
		Timestamp date = new Timestamp(new Date().getTime());
		log = new LogFile("aanmaken ticket", date, 1);
		assertTrue(log.getDescription().equals("aanmaken ticket"));
		assertTrue(log.getTime().equals(date));
		assertTrue(log.getUserID() == 1);
		assertTrue(log.getLogFileID() == -1);
	}
	
	@Test 
	public void testGettersAndSetters() {
		Timestamp date = new Timestamp(new Date().getTime());
		log = new LogFile("aanmaken ticket", date, 1);
		log.setDescription("aanmaken user");
		assertTrue(log.getDescription().equals("aanmaken user"));
		
		long time = 7000000000000L;
		Date date2 = new Date(time);
		//log.setTime(date2);
		assertTrue(log.getTime().equals(date2));
		
		log.setLogFileID(100);
		assertTrue(log.getLogFileID() == 100);
		
		log.setUserID(33);
		assertTrue(log.getUserID() == 33);
	}

}
