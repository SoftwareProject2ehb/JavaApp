/**
 * To write this class I used the pdfbox documentation (https://pdfbox.apache.org/1.8/cookbook/documentcreation.html) and some advices from stackoverflow
 */
package model;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

import javax.imageio.ImageIO;
import javax.print.PrintService;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.apache.pdfbox.printing.PDFPageable;

import utilities.QrCode;

public class Printer {
	public static void printTicket(Ticket t) throws IOException {
		// TO GENERATE QR CODE
		String qrTxt = "T" + t.getId();
		String qrTitle = "TQR" + t.getId();
		QrCode.makeQrCode(qrTxt, qrTitle);
		String image = qrTitle + ".png";
		String timeStamp = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new java.util.Date());
		String euro = "\u20ac";
		// Create a document and add a page to it
		PDDocument document = new PDDocument();
		PDPage page = new PDPage();
		document.addPage( page );

		// Create a new font object selecting one of the PDF base fonts
		PDFont font = PDType1Font.HELVETICA_BOLD;
		// Start a new content stream which will "hold" the to be created content
		PDPageContentStream contentStream;

		contentStream = new PDPageContentStream(document, page);
		//draw rectangle
		contentStream.setNonStrokingColor(200, 200, 200);
		contentStream.fillRect(0, 750, 700, 50);
		contentStream.setNonStrokingColor(Color.GRAY);
		contentStream.fillRect(0, 560, 700, 10);
		//draw lines
		contentStream.drawLine(0, 750, 700, 750);
		contentStream.drawLine(420, 850, 420, 570);
		//contentStream.drawLine(0, 570, 700, 570);
		//contentStream.drawLine(0, 530, 700, 530);
		//ticket Number
		contentStream.setNonStrokingColor(Color.BLACK);
		contentStream.beginText();
		contentStream.setFont(font, 16);
		contentStream.moveTextPositionByAmount(30, 765);
		contentStream.drawString("Ticket Nr " + t.getId());
		contentStream.endText();
		//date
		contentStream.setNonStrokingColor(134,51,51);
		contentStream.beginText();
		contentStream.setFont(font, 12);
		contentStream.moveTextPositionByAmount(455, 765);
		contentStream.drawString(timeStamp);
		contentStream.endText();
		// Define a text content stream using the selected font, moving the cursor and drawing the text "Hello World"
		contentStream.setNonStrokingColor(134,51,51);
		contentStream.beginText();
		contentStream.setFont(font, 12);
		contentStream.moveTextPositionByAmount(60, 700);
		
		String title = "Ticket" + t.getId() + "(" + t.getDate() + ").pdf";
		
		contentStream.drawString("Prijs : ");
		contentStream.newLineAtOffset(0, -15);
		contentStream.drawString("Type : ");
		contentStream.newLineAtOffset(0, -15);
		contentStream.drawString("Van : ");
		contentStream.newLineAtOffset(0, -15);
		contentStream.drawString("Tot : ");
		contentStream.newLineAtOffset(0, -15);
		contentStream.drawString("Op : ");
		contentStream.newLineAtOffset(0, -15);
		contentStream.newLineAtOffset(0, -15);
		if (t.isOneWayTicket())
			contentStream.drawString("GELDIG VOOR EEN ENKEL REIS");
		else
			contentStream.drawString("GELDIG VOOR EEN HEEN EN TERUG REIS");
		contentStream.endText();

		contentStream.setNonStrokingColor(Color.BLACK);
		contentStream.beginText();
		contentStream.setFont(font, 12);
		contentStream.moveTextPositionByAmount(110, 700);
		double prijs = t.getPrice();
		double new_prijs = Math.floor(prijs * 100) / 100;
		contentStream.drawString(euro + " " + new_prijs);
		contentStream.newLineAtOffset(0, -15);
		contentStream.drawString("" + t.getTypeTicket());
		contentStream.newLineAtOffset(0, -15);
		contentStream.drawString("" + t.getStartStation());
		contentStream.newLineAtOffset(0, -15);
		contentStream.drawString("" + t.getEndStation());
		contentStream.newLineAtOffset(0, -15);
		contentStream.drawString("" + t.getDate());
		contentStream.endText();

		
		PDImageXObject ximage = null;
		BufferedImage awtImage = ImageIO.read( new File( image ) );
		ximage = PDImageXObject.createFromFile(image, document);
		contentStream.drawImage(ximage, 430, 575);

		// Make sure that the content stream is closed:
		contentStream.close();

		// Save the results and ensure that the document is properly closed:
		document.save(title);
		document.close();

		Path path = FileSystems.getDefault().getPath(image);

		try {
			Files.delete(path);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void printSubscription(Subscription s) throws IOException {
		// TO GENERATE QR CODE
		String qrTxt = "S" + s.getId();
		String qrTitle = "SQR" + s.getId();
		QrCode.makeQrCode(qrTxt, qrTitle);
		String image = qrTitle + ".png";
		String timeStamp = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new java.util.Date());
		// Create a document and add a page to it
		PDDocument document = new PDDocument();
		PDPage page = new PDPage();
		document.addPage( page );

		// Create a new font object selecting one of the PDF base fonts
		PDFont font = PDType1Font.HELVETICA_BOLD;

		// Start a new content stream which will "hold" the to be created content
		PDPageContentStream contentStream;

		contentStream = new PDPageContentStream(document, page);
		
		//draw rectangle
		contentStream.setNonStrokingColor(200, 200, 200);
		contentStream.fillRect(0, 750, 700, 50);
		contentStream.setNonStrokingColor(Color.GRAY);
		contentStream.fillRect(0, 560, 700, 10);
		//draw lines
		contentStream.drawLine(0, 750, 700, 750);
		contentStream.drawLine(420, 850, 420, 570);
		//contentStream.drawLine(0, 570, 700, 570);
		//contentStream.drawLine(0, 530, 700, 530);
		//abonnement Number
		contentStream.setNonStrokingColor(Color.BLACK);
		contentStream.beginText();
		contentStream.setFont(font, 16);
		contentStream.moveTextPositionByAmount(30, 765);
		contentStream.drawString("Abonnement Nr " + s.getId());
		contentStream.endText();
		//date
		contentStream.setNonStrokingColor(134,51,51);
		contentStream.beginText();
		contentStream.setFont(font, 12);
		contentStream.moveTextPositionByAmount(455, 765);
		contentStream.drawString(timeStamp);
		contentStream.endText();		

		// Define a text content stream using the selected font, moving the cursor and drawing the text "Hello World"
		contentStream.setNonStrokingColor(134,51,51);
		contentStream.beginText();
		contentStream.setFont(font, 12);
		contentStream.moveTextPositionByAmount(60, 700);

		String title = "Abonnement" + s.getId() + "(" + s.getStartDate() + " to " + s.getEndDate() + ").pdf";

		contentStream.drawString("PRIJS: ");
		contentStream.newLineAtOffset(0, -15);
		contentStream.drawString("TYPE : ");
		contentStream.newLineAtOffset(0, -15);
		contentStream.drawString("VAN : ");
		contentStream.newLineAtOffset(0, -15);
		contentStream.drawString("TOT : ");
		contentStream.endText();

		contentStream.beginText();
		contentStream.setFont(font, 13);
		contentStream.moveTextPositionByAmount(60, 620);
		contentStream.drawString("GELDIG VAN :");
		contentStream.endText();

		contentStream.beginText();
		contentStream.setFont(font, 13);
		contentStream.moveTextPositionByAmount(260, 620);
		contentStream.drawString("TOT : ");
		contentStream.endText();
		
		contentStream.beginText();
		contentStream.setFont(font, 13);
		contentStream.setNonStrokingColor(Color.BLACK);
		contentStream.moveTextPositionByAmount(115, 600);
		contentStream.drawString("" + s.getStartDate());
		contentStream.endText();
		
		contentStream.beginText();
		contentStream.setFont(font, 13);
		contentStream.moveTextPositionByAmount(262, 600);
		contentStream.drawString("" + s.getEndDate());
		contentStream.endText();
		
		contentStream.beginText();
		contentStream.setFont(font, 12);
		contentStream.moveTextPositionByAmount(110, 700);
		double prijs = s.getPrice();
		double new_prijs = Math.floor(prijs * 100) / 100;
		contentStream.drawString("" + new_prijs);
		contentStream.newLineAtOffset(0, -15);
		contentStream.drawString("" + s.getSubscriptionType());
		contentStream.newLineAtOffset(0, -15);
		contentStream.drawString("" + s.getStartStation());
		contentStream.newLineAtOffset(0, -15);
		contentStream.drawString("" + s.getEndStation());
		contentStream.endText();
		
		PDImageXObject ximage = null;
		BufferedImage awtImage = ImageIO.read( new File( image ) );
		ximage = PDImageXObject.createFromFile(image, document);
		contentStream.drawImage(ximage, 430, 575);

		// Make sure that the content stream is closed:
		contentStream.close();

		// Save the results and ensure that the document is properly closed:
		document.save(title);
		document.close();

		Path path = FileSystems.getDefault().getPath(image);

		try {
			Files.delete(path);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}