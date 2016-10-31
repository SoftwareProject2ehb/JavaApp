package model;

import model.Price;
import model.Price.betalingsType;
import model.Ticket;

public class Main {

	public static void main(String[] args) {
		Ticket t = new Ticket("Standaard Ticket", "Brussel-Zuid", "Antwerpen", 8.00);
		Price p = new Price("Standaard Ticket", betalingsType.PER_KM, 2.00);
		
		System.out.println("Ticket Info :\n" + t.getTicketInfo());
		System.out.println("Price Info :\n" + p.getPriceInfo());
	}
}