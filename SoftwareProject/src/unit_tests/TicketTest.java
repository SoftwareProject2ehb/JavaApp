package unit_tests;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.Test;

import model.*;

public class TicketTest {
	@Test
	public void testTicket() {
		Ticket t = new Ticket(3, "Standaard", true, 5.5, "Brussel-Zuid", "Antwerpen", new Date(1, 1, 2017));
		assertEquals(3, t.getId());
		assertEquals("Standaard", t.getTypeTicket());
		assertEquals(true, t.isOneWayTicket());
		assertEquals(true, t.getPrice() == 5.5);
		assertEquals("Brussel-Zuid", t.getStartStation());
		assertEquals("Antwerpen", t.getEndStation());
		assertEquals(new Date(1, 1, 2017), t.getDate());
		
		t = new Ticket("Standaard", true, 5.5, "Brussel-Zuid", "Antwerpen", new Date(1, 1, 2017));
		assertEquals(-1, t.getId());
	}
	
	@Test
	public void testSetId() {
		Ticket t = new Ticket(3, "Standaard", true, 5.5, "Brussel-Zuid", "Antwerpen", new Date(1, 1, 2017));
		t.setId(5);
		assertEquals(t.getId(), 5);
	}
	
	@Test
	public void testSetTypeTicket() {
		Ticket t = new Ticket(3, "Standaard", true, 5.5, "Brussel-Zuid", "Antwerpen", new Date(1, 1, 2017));
		t.setTypeTicket("test");
		assertEquals(t.getTypeTicket(), "test");
		assertEquals(t.setTypeTicket(null), ErrorCode.NULL_PARAM);
	}
	
	@Test
	public void testSetOneWayTicket() {
		Ticket t = new Ticket(3, "Standaard", true, 5.5, "Brussel-Zuid", "Antwerpen", new Date(1, 1, 2017));
		t.setOneWayTicket(false);
		assertEquals(t.isOneWayTicket(), false);
	}
	
	@Test
	public void testSetPrice() {
		Ticket t = new Ticket(3, "Standaard", true, 5.5, "Brussel-Zuid", "Antwerpen", new Date(1, 1, 2017));
		t.setPrice(2.5);
		assertEquals(true, t.getPrice() == 2.5);
		assertEquals(t.setPrice(-1), ErrorCode.INCORRECT_PARAM);
	}
	
	@Test
	public void testSetStartStation() {
		Ticket t = new Ticket(3, "Standaard", true, 5.5, "Brussel-Zuid", "Antwerpen", new Date(1, 1, 2017));
		t.setStartStation("test");
		assertEquals(t.getStartStation(), "test");
		assertEquals(t.setStartStation(null), ErrorCode.NULL_PARAM);
	}
	
	@Test
	public void testSetEndStation() {
		Ticket t = new Ticket(3, "Standaard", true, 5.5, "Brussel-Zuid", "Antwerpen", new Date(1, 1, 2017));
		t.setEndStation("test");
		assertEquals(t.getEndStation(), "test");
		assertEquals(t.setEndStation(null), ErrorCode.NULL_PARAM);
	}
	
	@Test
	public void testSetDate() {
		Ticket t = new Ticket(3, "Standaard", true, 5.5, "Brussel-Zuid", "Antwerpen", new Date(1, 1, 2017));
		t.setDate(new Date(2, 2, 2016));
		assertEquals(t.getDate(), new Date(2, 2, 2016));
		assertEquals(t.setDate(null), ErrorCode.NULL_PARAM);
	}
}
