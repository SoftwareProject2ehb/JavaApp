package model;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import data_control.*;
import model.Price;
import model.Price.betalingsType;
import utilities.DateConverter;
import view.LoginView;
import model.Ticket;

import model.*;
import data_control.*;

public class Main {

	public static void main(String[] args) {
		CustomerDAO.createCustomer(new Customer("Bernd", "Wethmar", "a@w.be", "007", "Straatnaam"));

	}
}