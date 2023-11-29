package org.example;
//import com.itextpdf.text.Phrase;
//import org.apache.poi.xwpf.model.XWPFHeaderFooterPolicy;
//import org.apache.poi.xwpf.usermodel.*;
//
//import com.itextpdf.text.Document;
//import com.itextpdf.text.PageSize;
//import com.itextpdf.text.Paragraph;
//import com.itextpdf.text.pdf.PdfWriter;
//import com.itextpdf.text.pdf.PdfPTable;
//import com.itextpdf.text.pdf.PdfPCell;
//import com.itextpdf.text.pdf.draw.LineSeparator;
//import com.itextpdf.text.BaseColor;
//import com.itextpdf.text.Element;
//
//
//import java.io.*;
//import java.util.List;
//
//public class DocxToPdf {
//
//    public static void main(String[] args) {
//        try {
//            FileInputStream docxInputStream = new FileInputStream("C:\\template.docx");
//            XWPFDocument document = new XWPFDocument(docxInputStream);
//
//            Document pdfDocument = new Document(PageSize.A4);
//            PdfWriter pdfWriter = PdfWriter.getInstance(pdfDocument, new FileOutputStream("C:\\certificate_template_output.pdf"));
//            pdfDocument.open();
//
//            // Process the main content (paragraphs and tables)
//            processDocumentContent(document, pdfDocument);
//
//            // Process headers and footers
//            processHeadersAndFooters(document, pdfDocument, pdfWriter);
//
//            pdfDocument.close();
//
//            System.out.println("Word to PDF conversion completed successfully.");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    private static void processDocumentContent(XWPFDocument document, Document pdfDocument) throws Exception {
//        List<XWPFParagraph> paragraphs = document.getParagraphs();
//        for (XWPFParagraph paragraph : paragraphs) {
//            processParagraph(paragraph, pdfDocument);
//        }
//
//        List<XWPFTable> tables = document.getTables();
//        for (XWPFTable table : tables) {
//            processTable(table, pdfDocument);
//        }
//    }
//
//    private static void processParagraph(XWPFParagraph paragraph, Document pdfDocument) throws Exception {
//        List<XWPFRun> runs = paragraph.getRuns();
//        for (XWPFRun run : runs) {
//            String text = run.getText(0);
//            if (text != null) {
//                pdfDocument.add(new Paragraph(text));
//            }
//        }
//    }
//
//    private static void processTable(XWPFTable table, Document pdfDocument) throws Exception {
//        PdfPTable pdfTable = new PdfPTable(3);
//        pdfTable.setWidthPercentage(100);
//
//        for (XWPFTableRow row : table.getRows()) {
//            for (XWPFTableCell cell : row.getTableCells()) {
//                pdfTable.addCell(new PdfPCell(new Phrase(cell.getText())));
//            }
//        }
//
//        pdfDocument.add(pdfTable);
//    }
//
//    private static void processHeadersAndFooters(XWPFDocument document, Document pdfDocument, PdfWriter pdfWriter) throws Exception {
//        XWPFHeaderFooterPolicy headerFooterPolicy = document.getHeaderFooterPolicy();
//
//        // Process header
//        XWPFHeader header = headerFooterPolicy.getDefaultHeader();
//        if (header != null) {
//            processHeaderFooter(header, pdfDocument, pdfWriter);
//        }
//
//        // Process footer
//        XWPFFooter footer = headerFooterPolicy.getDefaultFooter();
//        if (footer != null) {
//            processHeaderFooter(footer, pdfDocument, pdfWriter);
//        }
//    }
//
//    private static void processHeaderFooter(XWPFHeaderFooter headerFooter, Document pdfDocument, PdfWriter pdfWriter) throws Exception {
//        List<XWPFParagraph> paragraphs = headerFooter.getParagraphs();
//        for (XWPFParagraph paragraph : paragraphs) {
//            processParagraph(paragraph, pdfDocument);
//        }
//
//        // Add an empty line to separate header/footer from the main content
//        pdfDocument.add(new Paragraph(" "));
//
//        // Add a horizontal line to visually separate header/footer from the main content
//        pdfDocument.add(new LineSeparator(0.5f, 100, BaseColor.BLACK, Element.ALIGN_CENTER, -2));
//    }
//}

