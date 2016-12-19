package unit_tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.Stop;

public class StopTest {
	
	private Stop stop;

	@Before
	public void setUp() throws Exception {
		stop = new Stop(7890, 10, "Tienen", 3);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testConstructor() {
		assertTrue(stop.getTrainID() == 7890);
		assertTrue(stop.getStopID() == 10);
		assertTrue(stop.getName().equals("Tienen"));
		assertTrue(stop.getPlatform() == 3);
	}
	
	@Test
	public void testSettersAndGetters() {
		stop.setName("Leuven");
		assertTrue(stop.getName().equals("Leuven"));
		
		stop.setPlatform(5);
		assertTrue(stop.getPlatform() == 5);
		
		stop.setStopID(15);
		assertTrue(stop.getStopID() == 15);
		
		stop.setTrainID(1234);
		assertTrue(stop.getTrainID() == 1234);
	}

}
