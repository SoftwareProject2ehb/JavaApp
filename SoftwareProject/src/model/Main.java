package model;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import controller.SystemController;
import data_control.*;
import model.Price;
import model.Price.betalingsType;
import utilities.DateConverter;
import view.LoginView;
import view.PriceConfigView;
import view.SearchRouteView;
import model.Ticket;

import model.*;
import data_control.*;

public class Main {

	public static void main(String[] args) {
		System.out.println("Start.");
		
		Subscription s = new Subscription(1, 1, 50.00, 1, "Antwerpen", "Brussel-Zuid",
				new Date(1996, 9, 21), new Date(1996, 9, 21), 1);
		
		try {
			Printer.printSubscription(s);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Subscription printed.");
		
		TicketDAO tDAO = new TicketDAO();
		try {
			Printer.printTicket(tDAO.findTicketById(10));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Ticket printed.");
	}
}