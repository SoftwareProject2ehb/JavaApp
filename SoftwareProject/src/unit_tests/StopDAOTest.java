package unit_tests;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import data_control.StopDAO;
import model.Stop;

public class StopDAOTest {
	
	private Stop stop;

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCreateStop() {
		stop = new Stop(1, "Nossegem", 1);
		StopDAO.createStop(stop);
		Stop stop2 = StopDAO.getLatestEntry();
		assertTrue(stop.getName().equals(stop2.getName()));
		assertTrue(stop.getTrainID() == stop2.getTrainID());
		assertTrue(stop.getPlatform() == stop2.getPlatform());
		assertTrue(stop.getStopID() == -1 && stop2.getStopID() > 0);
	}
	
	@Test
	public void testUpdateStop() {
		Stop stop2 = StopDAO.getLatestEntry();
		stop = new Stop(2, stop2.getStopID(), "Landen", 3);
		StopDAO.updateStop(stop);
		stop2 = StopDAO.getLatestEntry();
		assertTrue(stop.getName().equals(stop2.getName()));
		assertTrue(stop.getTrainID() == stop2.getTrainID());
		assertTrue(stop.getPlatform() == stop2.getPlatform());
		assertTrue(stop.getStopID() == stop2.getStopID());
	}
	
	@Test
	public void testFindStopByID() {
		Stop stop2 = StopDAO.getLatestEntry();
		stop = StopDAO.findStopById(stop2.getStopID());
		assertTrue(stop.getName().equals(stop2.getName()));
		assertTrue(stop.getTrainID() == stop2.getTrainID());
		assertTrue(stop.getPlatform() == stop2.getPlatform());
		assertTrue(stop.getStopID() == stop2.getStopID());
	}
	
	@Test
	public void testGetAllStops() {
		Stop stop2 = StopDAO.getLatestEntry();
		List<Stop> stops = StopDAO.getAllStops();
		assertTrue(stops.size() == stop2.getStopID());
	}

}
