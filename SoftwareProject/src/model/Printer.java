package model;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;

public class Printer {
	public static void printTicket(Ticket t) {
		String txt = "";

		txt += "Ticket nr " + t.getID() + "\t\t";
		txt += "Prijs : €" + t.getPrice() + "\n";
		txt += "Type : " + t.getTypeTicket() + "\t";
		if (t.isOneWayTicket())
			txt += "ENKEL" + "\n";
		else
			txt += "HEEN EN TERUG" + "\n";
		txt += "Van : " + t.getStartStation() + "\t\t";
		txt += "Tot : " + t.getEndStation() + "\n";
		txt += "Op : " + t.getDate() + "\n";
		
		try {
		    Files.write(Paths.get("Ticket" + t.getID() + "(" + t.getDate() + ").txt"), txt.getBytes());
		} catch (IOException e) {
		    e.printStackTrace();
		}
	}
	
	public static void printSubscription(Subscription s) {
		String txt = "";

		txt += "Abonnement nr " + s.getId() + "\t\t";
		txt += "Prijs : €" + s.getPrice() + "\n";
		txt += "Type : " + s.getTicketType() + "\n";
		
		txt += "Van : " + s.getStartStation() + "\t\t";
		txt += "Tot : " + s.getEndStation() + "\n";
		txt += "Van : " + s.getStartDate() + "\t";
		txt += "Tot : " + s.getEndDate() + "\n";
		
		try {
		    Files.write(Paths.get("Abonnement" + s.getId() + "(" + s.getStartDate() + " to " + s.getEndDate() + ").txt"), txt.getBytes());
		} catch (IOException e) {
		    e.printStackTrace();
		}
	}
}