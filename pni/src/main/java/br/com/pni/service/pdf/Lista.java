package br.com.pni.service.pdf;

import java.io.FileOutputStream;
import java.io.IOException;
import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfWriter;

public class Lista {

    public void generatePDF(String nm) throws IOException {

        new Lista().setListInPDF("E://Documents (D)/lista de contratos com erro.pdf");
    }

    private void setListInPDF(String PDFPath) {
		try {

			Document document = new Document();
			PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(PDFPath));
			document.open();
			Font headingFont = new Font(Font.HELVETICA, 12, Font.BOLD);
			document.add(new Paragraph("Choices Are (Using Numbers)", headingFont));
			List list = new List(List.ORDERED);
			list.setIndentationLeft(20);
			// Add ListItem objects
			list.add(new ListItem("Aerobic"));
			list.add(new ListItem("Anaerobic"));
			list.add(new ListItem("Flexibility Training"));
			// Add the list
			document.add(list);

			document.add(new Paragraph("Choices Are (Unordered List)", headingFont));
			list = new List(List.UNORDERED, 14);
			// Add ListItem objects
			list.add(new ListItem("Aerobic"));
			list.add(new ListItem("Anaerobic"));
			list.add(new ListItem("Flexibility Training"));
			// Add the list
			document.add(list);

			document.add(new Paragraph("List with a nested list", headingFont));
			Font font = new Font(Font.HELVETICA, 12, Font.ITALIC, java.awt.Color.BLUE);
			list = new List(false, List.ALPHABETICAL);
			list.add(new ListItem("Aerobic"));
			List childList = new List();
			// bullet symbol for nested list
			childList.setListSymbol("\u2022");
			childList.setIndentationLeft(20);
			childList.add(new ListItem("Running", font));
			childList.add(new ListItem("Skipping", font));
			// adding nested list
			list.add(childList);
			// Add ListItem objects

			list.add(new ListItem("Anaerobic"));
			list.add(new ListItem("Flexibility Training"));
			// Add the list
			document.add(list);

			document.add(new Paragraph("List with Roman Numerals", headingFont));

			List romanList = new RomanList(List.LOWERCASE, 14);
			// Add ListItem objects
			romanList.add(new ListItem("Aerobic"));
			romanList.add(new ListItem("Anaerobic"));
			romanList.add(new ListItem("Flexibility Training"));
			document.add(romanList);
			document.close();
			writer.close();

		} catch (DocumentException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}