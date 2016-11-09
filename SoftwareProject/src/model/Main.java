package model;

import model.*;
import data_control.*;

public class Main {

	public static void main(String[] args) {
		CustomerDAO.createCustomer(new Customer("Bernd", "Wethmar", "a@w.be", "007", "Straatnaam"));
	}
}