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

		txt += "Ticket nr " + t.getID() + "\n";
		txt += "Type : " + t.getTypeTicket() + "\n";
		if (t.isOneWayTicket())
			txt += "ENKEL" + "\n";
		else
			txt += "HEEN EN TERUG" + "\n";
		txt += "Van : " + t.getStartStation() + "\n";
		txt += "Tot : " + t.getEndStation() + "\n";
		txt += "Op : " + t.getDate() + "\n";
		txt += "Prijs : €" + t.getPrice() + "\n";
		
		try {
		    Files.write(Paths.get("ticket.txt"), txt.getBytes());
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
		/*
		try{
		    PrintWriter writer = new PrintWriter("treinticket.txt", "UTF-8");
		    
			writer.println("Ticket nr " + t.getID());
			writer.println("Type : " + t.getTypeTicket());
			if (t.isOneWayTicket())
				writer.println("ENKEL");
			else
				writer.println("HEEN EN TERUG");
			writer.println("Van : " + t.getStartStation());
			writer.println("Tot : " + t.getEndStation());
			writer.println("Op : " + t.getDate());
			writer.println("Prijs : €" + t.getPrice());
			
			writer.close();
		} catch (Exception e) {
			   // do something
			}
			*/
	}
}