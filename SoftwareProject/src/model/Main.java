package model;

import data_control.*;
import model.Price;
import model.Price.betalingsType;
import model.Ticket;

public class Main {

	public static void main(String[] args) {
		Customer c1 = new Customer("Onur", "Bugdayci", "jotithoofd", "a@b.c", "69");
		CustomerDAO cd1 = new CustomerDAO();
		cd1.createCustomer(c1);
	}
}