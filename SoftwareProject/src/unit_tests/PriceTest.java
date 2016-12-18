package unit_tests;

import static org.junit.Assert.*;
import org.junit.Test;

import model.*;
import model.Price.betalingsType;

public class PriceTest {
	@Test
	public void testPrice() {
		Price p = new Price(3, "Standaard", betalingsType.FIXED, 7);
		assertEquals(3, p.getId());
		assertEquals("Standaard", p.getTypeTicket());
		assertEquals(betalingsType.FIXED, p.getTypeBetaling());
		assertEquals(true, p.getCostPerUnit() == 7);
		
		p = new Price("Standaard", betalingsType.FIXED, 7);
		assertEquals(-1, p.getId());
		
		assertEquals(new Price(null, betalingsType.FIXED, 7), ErrorCode.NULL_PARAM);
		assertEquals(new Price("Standaard", null, 7), ErrorCode.NULL_PARAM);
		assertEquals(new Price(null, null, 7), ErrorCode.NULL_PARAM);
		assertEquals(new Price("Standaard", betalingsType.FIXED, -1), ErrorCode.INCORRECT_PARAM);
	}
	
	@Test
	public void testSetId() {
		Price p = new Price("Standaard", betalingsType.FIXED, 7);
		assertEquals(-1, p.getId());
		p.setId(5);
		assertEquals(5, p.getId());
		assertEquals(p.setId(-1), ErrorCode.INCORRECT_PARAM);
	}
	
	@Test
	public void testSetTypeTicket() {
		Price p = new Price(3, "", betalingsType.FIXED, 7);
		p.setTypeTicket("test");
		assertEquals("test", p.getTypeTicket());
		assertEquals(p.setTypeTicket(null), ErrorCode.NULL_PARAM);
	}
	
	@Test
	public void testSetTypeBetaling() {
		Price p = new Price(3, "Standaard", betalingsType.FIXED, 7);
		p.setTypeBetaling(betalingsType.PER_KM);
		assertEquals(betalingsType.PER_KM, p.getTypeBetaling());
		assertEquals(p.setTypeBetaling(null), ErrorCode.NULL_PARAM);
	}
	
	@Test
	public void testSetCostPerUnit() {
		Price p = new Price(3, "Standaard", betalingsType.FIXED, 7);
		p.setCostPerUnit(3);
		assertEquals(true, p.getCostPerUnit() == 3);
		assertEquals(p.setCostPerUnit(-1), ErrorCode.INCORRECT_PARAM);
	}
}