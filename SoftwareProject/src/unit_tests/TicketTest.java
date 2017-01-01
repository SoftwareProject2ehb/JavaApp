package unit_tests;

import static org.junit.Assert.*;

import org.junit.Test;

import model.*;

public class TicketTest {
	@Test
	public void testTicket() {
		Ticket t = new Ticket(3, "Standaard", true, 5.5, "Brussel-Zuid", "Antwerpen", null); // TODO change date format ?
		assertEquals(3, t.getId());
		assertEquals("Standaard", t.getTypeTicket());
		assertEquals(true, t.isOneWayTicket());
		assertEquals(true, t.getPrice() == 5.5);
		assertEquals("Brussel-Zuid", t.getStartStation());
		assertEquals("Anterpen", t.getEndStation());
		assertEquals(null, t.getDate()); // TODO change date format ?
		
		t = new Ticket("Standaard", true, 5.5, "Brussel-Zuid", "Antwerpen", null); // TODO change date format ?
		assertEquals(-1, t.getId());
		
		// TODO test null and incorrect values
	}
	
	@Test
	public void testSetId() {
		
	}
}
