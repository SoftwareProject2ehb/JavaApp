package unit_tests;

import static org.junit.Assert.*;

import org.junit.Test;

import model.User;

public class UserTest {
	
	@Test
	/*
	 * test getter en setter voor ID
	 */
	public void testSetID() {

		User test = new User(0, null, null, null, null, null, null, null, false, null, null, null, 0, null, null);
		int ID = 3;
		test.setUserID(ID);
		assertEquals(test.getUserID(), ID);
	}
	
	@Test
	public void testGetID() {
		User test = new User(0, null, null, null, null, null, null, null, false, null, null, null, 0, null, null);
		int givID = 5;
		test.setUserID(5);
		int result = test.getUserID();
		assertEquals(givID, result);
	}
	
	@Test
	/*
	 * test getter en setter voor voornaam
	 */
	public void testSetVoornaam() {
		User test = new User(0, null, null, null, null, null, null, null, false, null, null, null, 0, null, null);
		String voornaam = "test";
		test.setFirstName(voornaam);
		assertEquals(test.getFirstName(), voornaam);
	}
	
	@Test
	public void testGetVoornaam() {
		User test = new User(0, null, null, null, null, null, null, null, false, null, null, null, 0, null, null);
		String givVoornaam = "mohamed";
		test.setFirstName("mohamed");
		String result = test.getFirstName();
		assertEquals(givVoornaam, result);
	}
	
	@Test
	/*
	 * test setter en getter voor password
	 */
	public void testSetPassword() {
		User test = new User(0, null, null, null, null, null, null, null, false, null, null, null, 0, null, null);
		String testPassword = "pass";
		test.setPassword(testPassword);
		assertEquals(test.getPassword(), testPassword);
	}
	
	@Test
	public void testGetPassword() {
		User test = new User(0, null, null, null, null, null, null, null, false, null, null, null, 0, null, null);
		String givPassword = "pass1";
		test.setPassword("pass1");
		String result = test.getPassword();
		assertEquals(givPassword, result);
	}
	
	@Test
	/*
	 * test getter en setter voor phone
	 */
	public void testSetPhone() {
		User test = new User(0, null, null, null, null, null, null, null, false, null, null, null, 0, null, null);
		String phone = "0999";
		test.setPhone(phone);
		assertEquals(test.getPhone(), phone);
	}
	
	@Test
	public void testGetPhone() {
		User test = new User(0, null, null, null, null, null, null, null, false, null, null, null, 0, null, null);
		String phone = "0999";
		test.setPhone("0999");
		String result = test.getPhone();
		assertEquals(phone, result);
	}

}
