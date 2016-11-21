package unit_tests;

import static org.junit.Assert.*;
import org.junit.Test;

import model.*;

public class CustomerTest {

	public static void main(String[] args) {
		
	}
	
	@Test
	public void testCustomer() {
		Customer customer = new Customer("Bernd", "Wethmar", "b@w.be", "0000", "Straat");
		assertEquals(customer.getFirstName(), "Bernd");
		assertEquals(customer.getLastName(), "Wethmar");
		assertEquals(customer.getEmail(), "b@w.be");
		assertEquals(customer.getPhone(), "0000");
		assertEquals(customer.getAddress(), "Straat");
	}
	
	@Test
	public void testSetID() {
		Customer customer = new Customer("", "", "", "", "");
		customer.setId(5);
		assertEquals(customer.getId(), 5);
		assertEquals(customer.setId(1000000), ErrorCode.INCORRECT_PARAM);
		assertEquals(customer.setId(-1), ErrorCode.INCORRECT_PARAM);
	}
	
	@Test
	public void testSetName() {
		Customer customer = new Customer("", "", "", "", "");
		customer.setName("Bernd", "Wethmar");
		assertEquals(customer.getFirstName(), "Bernd");
		assertEquals(customer.getLastName(), "Wethmar");
		
		//Checks for NULL
		assertEquals(customer.setName(null, null), ErrorCode.NULL_PARAM);
		assertEquals(customer.setName("Bernd", null), ErrorCode.NULL_PARAM);
		assertEquals(customer.setName(null, "Wethmar"), ErrorCode.NULL_PARAM);
		
		//Checks for underbounds
		assertEquals(customer.setName("", "Wethmar"), ErrorCode.INCORRECT_PARAM);
		assertEquals(customer.setName("Bernd", ""), ErrorCode.INCORRECT_PARAM);
		assertEquals(customer.setName("", ""), ErrorCode.INCORRECT_PARAM);
		
		//Checks for overbounds
		assertEquals(customer.setName("TestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTest", "Wethmar"), ErrorCode.INCORRECT_PARAM);
		assertEquals(customer.setName("Bernd", "TestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTest"), ErrorCode.INCORRECT_PARAM);
		assertEquals(customer.setName("TestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTest", "TestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTest"), ErrorCode.INCORRECT_PARAM);
	}
	
	@Test
	public void testSetEmail() {
		Customer customer = new Customer("", "", "", "", "");
		customer.setEmail("b@w.be");
		assertEquals(customer.getEmail(), "b@w.be");
		assertEquals(customer.setEmail(null), ErrorCode.NULL_PARAM);
		assertEquals(customer.setEmail(""), ErrorCode.INCORRECT_PARAM);
		assertEquals(customer.setEmail("TestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTest"), ErrorCode.INCORRECT_PARAM);
	}
	
	@Test
	public void testSetPhone() {
		Customer customer = new Customer("", "", "", "", "");
		customer.setPhone("0000");
		assertEquals(customer.getPhone(), "0000");
		assertEquals(customer.setPhone(null), ErrorCode.NULL_PARAM);
		assertEquals(customer.setPhone(""), ErrorCode.INCORRECT_PARAM);
		assertEquals(customer.setPhone("123456789012345678901"), ErrorCode.INCORRECT_PARAM);
	}
	
	@Test
	public void testSetAddress() {
		Customer customer = new Customer("", "", "", "", "");
		customer.setAddress("Straat");
		assertEquals(customer.getAddress(), "Straat");
		assertEquals(customer.setAddress(null), ErrorCode.NULL_PARAM);
		assertEquals(customer.setAddress(""), ErrorCode.INCORRECT_PARAM);
		assertEquals(customer.setAddress("TestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTest"), ErrorCode.INCORRECT_PARAM);
	}
	
}
