package unit_tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import data_control.*;
import model.*;

public class SubscriptionDAOTEST {
	SubscriptionDAO sd = new SubscriptionDAO();
	
	@Test
	public void testGetAllSubsCount() {
		//Ik check hier eventjes of het aantal items dat in de getAllSubs methode overeenstemt met wat er in de database zit.
		//Ik check ook ofdat een item in het lijst van het type Subscription is en dat de lijst niet leeg is.
		
		ArrayList<Subscription> sdlist = sd.getAllSubs();
		
		assertEquals(3, sdlist.size());
		assertEquals(true,  sdlist.get(0) != null && sdlist.get(0) instanceof Subscription);
	}
	
	@Test
	public void testFindSubById() {
		// Ik check hier ofdat de findSubById methode de subscription teruggeeeft met de waarden die we ervan verwachten.
		
		Subscription testObj = sd.findSubById(1);
		assertEquals(true, testObj.getId() == 1);
		assertEquals(true, testObj.getTicketType() == 1);
		assertEquals(true, testObj.getPrice() == 20.0);
		assertEquals(true, testObj.getCustomerId() == 1);
		assertEquals(true, testObj.getStartStation().equals("Zele"));
		assertEquals(true, testObj.getEndStation().equals("Brussel-Zuid"));
		assertEquals(true, testObj.getStartDate().toString().equals("2016-09-26"));
		assertEquals(true, testObj.getEndDate().toString().equals("2016-12-23"));

	}
	
}
