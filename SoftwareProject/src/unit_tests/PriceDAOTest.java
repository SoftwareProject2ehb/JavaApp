package unit_tests;

import static org.junit.Assert.*;
import org.junit.Test;

import data_control.PriceDAO;
import model.Price;
import model.Price.betalingsType;

public class PriceDAOTest {
	Price p = new Price(99, "Test", betalingsType.FIXED, 7.5);
	
	@Test
	public void testCreatePrice() {
		p.setId(PriceDAO.createPrice(p));
		Price p2 = PriceDAO.findPriceByType("Test");
		assertEquals(p.getId(), p2.getId());
		assertEquals(true, p.getCostPerUnit() == p2.getCostPerUnit());
		assertEquals(p.getTypeBetaling(), p2.getTypeBetaling());
		assertEquals(p.getTypeTicket(), p2.getTypeTicket());
	}
	
	@Test
	public void testUpdatePrice() {
		p.setCostPerUnit(0.5);
		p.setTypeBetaling(betalingsType.PER_KM);
		PriceDAO.updatePrice(p);
		
		Price p2 = PriceDAO.findPriceByType("Test");
		assertEquals(p.getId(), p2.getId());
		assertEquals(true, p.getCostPerUnit() == p2.getCostPerUnit());
		assertEquals(p.getTypeBetaling(), p2.getTypeBetaling());
		assertEquals(p.getTypeTicket(), p2.getTypeTicket());
	}
}