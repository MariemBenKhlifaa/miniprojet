package tn.esprit.projet.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Optional;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.CMYKColor;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.xhtmlrenderer.pdf.ITextRenderer;

import tn.esprit.projet.entities.Contrat;

import javax.servlet.http.HttpServletResponse;

@Service

public class PdfService {
    private static final String PDF_RESOURCES = "/templates/";
    private SpringTemplateEngine templateEngine;
    Contrat contrat;



    public void generate(List<Contrat> contratList, HttpServletResponse response) throws DocumentException, IOException {

        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());
        document.open();
        Font fontTiltle = FontFactory.getFont(FontFactory.TIMES_ROMAN);
        fontTiltle.setSize(20);
        Paragraph paragraph1 = new Paragraph("List of the Contrat", fontTiltle);
        paragraph1.setAlignment(Paragraph.ALIGN_CENTER);
        document.add(paragraph1);
        PdfPTable table = new PdfPTable(5);
        table.setWidthPercentage(100);
        table.setWidths(new int[]{3, 3, 3, 3,3});
        table.setSpacingBefore(5);
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(CMYKColor.BLUE);
        cell.setPadding(6);
        Font font = FontFactory.getFont(FontFactory.TIMES_ROMAN);
        font.setColor(CMYKColor.WHITE);
        cell.setPhrase(new Phrase("ID contrat ", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("SPECIALITE", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("DATE DEBUT", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("DATE FIN", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase(" Montant ", font));
        table.addCell(cell);
        for (Contrat contrat : contratList) {

            table.addCell(String.valueOf(contrat.getIdContrat()));
            table.addCell(String.valueOf(contrat.getSpecialite()));
            table.addCell(String.valueOf(contrat.getDateDebutContrat()));
            table.addCell(String.valueOf(contrat.getDateFinContrat()));
            table.addCell(String.valueOf(contrat.getMontantContrat()));
        }
        document.add(table);
        document.close();
    }

}