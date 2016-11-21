package model;

import java.awt.image.BufferedImage;
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
import java.util.Arrays;
import java.util.List;

import javax.imageio.ImageIO;

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

		// Create a document and add a page to it
		PDDocument document = new PDDocument();
		PDPage page = new PDPage();
		document.addPage( page );

		// Create a new font object selecting one of the PDF base fonts
		PDFont font = PDType1Font.HELVETICA_BOLD;

		// Start a new content stream which will "hold" the to be created content
		PDPageContentStream contentStream;

		contentStream = new PDPageContentStream(document, page);

		// Define a text content stream using the selected font, moving the cursor and drawing the text "Hello World"
		contentStream.beginText();
		contentStream.setFont(font, 12);
		contentStream.moveTextPositionByAmount(100, 700);

		String title = "Ticket" + t.getId() + "(" + t.getDate() + ").pdf";

		contentStream.drawString("Ticket nr " + t.getId());
		contentStream.newLineAtOffset(0, -15);
		contentStream.drawString("Prijs : € " + t.getPrice());
		contentStream.newLineAtOffset(0, -15);
		contentStream.drawString("Type : " + t.getTypeTicket());
		contentStream.newLineAtOffset(0, -15);
		if (t.isOneWayTicket())
			contentStream.drawString("ENKEL");
		else
			contentStream.drawString("HEEN EN TERUG");
		contentStream.newLineAtOffset(0, -15);
		contentStream.drawString("Van : " + t.getStartStation());
		contentStream.newLineAtOffset(0, -15);
		contentStream.drawString("Tot : " + t.getEndStation());
		contentStream.newLineAtOffset(0, -15);
		contentStream.drawString("Op : " + t.getDate());
		contentStream.endText();

		PDImageXObject ximage = null;
		BufferedImage awtImage = ImageIO.read( new File( image ) );
		ximage = PDImageXObject.createFromFile(image, document);
		contentStream.drawImage(ximage, 350, 575);

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

		PrinterJob job = PrinterJob.getPrinterJob();
		job.setPageable(new PDFPageable(document));
		if (job.printDialog()) {
			try {
				job.print();
			} catch (PrinterException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		/* Uncomment this to delete pdf after it was printed.
		Path path2 = FileSystems.getDefault().getPath(title);

		try {
			Files.delete(path2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		*/
	}

	public static void printSubscription(Subscription s) throws IOException {
		// TO GENERATE QR CODE
		String qrTxt = "S" + s.getId();
		String qrTitle = "SQR" + s.getId();
		QrCode.makeQrCode(qrTxt, qrTitle);
		String image = qrTitle + ".png";

		// Create a document and add a page to it
		PDDocument document = new PDDocument();
		PDPage page = new PDPage();
		document.addPage( page );

		// Create a new font object selecting one of the PDF base fonts
		PDFont font = PDType1Font.HELVETICA_BOLD;

		// Start a new content stream which will "hold" the to be created content
		PDPageContentStream contentStream;

		contentStream = new PDPageContentStream(document, page);

		// Define a text content stream using the selected font, moving the cursor and drawing the text "Hello World"
		contentStream.beginText();
		contentStream.setFont(font, 12);
		contentStream.moveTextPositionByAmount(100, 700);

		String title = "Abonnement" + s.getId() + "(" + s.getStartDate() + " to " + s.getEndDate() + ").pdf";

		contentStream.drawString("Abonnement nr " + s.getId());
		contentStream.newLineAtOffset(0, -15);
		contentStream.drawString("Prijs : € " + s.getPrice());
		contentStream.newLineAtOffset(0, -15);
		contentStream.drawString("Type : " + s.getTicketType());
		contentStream.newLineAtOffset(0, -15);
		contentStream.drawString("Van : " + s.getStartStation());
		contentStream.newLineAtOffset(0, -15);
		contentStream.drawString("Tot : " + s.getEndStation());
		contentStream.newLineAtOffset(0, -15);
		contentStream.drawString("Van : " + s.getStartDate());
		contentStream.newLineAtOffset(0, -15);
		contentStream.drawString("Tot : " + s.getEndDate());
		contentStream.endText();

		PDImageXObject ximage = null;
		BufferedImage awtImage = ImageIO.read( new File( image ) );
		ximage = PDImageXObject.createFromFile(image, document);
		contentStream.drawImage(ximage, 350, 575);

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

		PrinterJob job = PrinterJob.getPrinterJob();
		job.setPageable(new PDFPageable(document));
		if (job.printDialog()) {
			try {
				job.print();
			} catch (PrinterException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		/* Uncomment this to delete pdf after it was printed.
		Path path2 = FileSystems.getDefault().getPath(title);

		try {
			Files.delete(path2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		*/
	}
}