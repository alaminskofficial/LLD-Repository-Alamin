package org.example;
//import java.io.*;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import com.itextpdf.text.DocumentException;
//import org.apache.pdfbox.pdmodel.PDDocument;
//import org.apache.pdfbox.pdmodel.PDPage;
//import org.apache.pdfbox.pdmodel.PDPageContentStream;
//import org.apache.pdfbox.pdmodel.font.PDType1Font;
//import org.apache.poi.xwpf.usermodel.*;
//import org.apache.pdfbox.pdmodel.font.PDFont;
//
//public class Main {
//    public static void main(String[] args) {
//        float yOffset = 0;
//
//        Map<String, String> textToReplace = new HashMap<>();
//        textToReplace.put("[BCA Name]", "alamin");
//        textToReplace.put("bc_name", "Novopay");
//        textToReplace.put("BC Contact No.", "08067778666");
//        textToReplace.put("[BCA Business Address]", "blr");
//        textToReplace.put("[Session Code]", "124");
//        textToReplace.put("[Training Date]", "123");
//        textToReplace.put("email", "ak");
//        textToReplace.put("BCA Training Session Code", "");
//        textToReplace.put("Insert BCA Code", ")");
//        textToReplace.put("Insert Poster Issue No", "corporateEntity.getId().toString()");
//        textToReplace.put("BCA Certificate Issue No", "corporateEntity.getId().toString()");
//
//        try (FileInputStream fis = new FileInputStream("C:\\Users\\alamin\\Downloads\\ybl_revised_marcom_bc_certificate_template.docx");
//             ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
//
//            XWPFDocument document = new XWPFDocument(fis);
//            processParagraphs(document, textToReplace);
//            processTables(document, textToReplace);
//            processFooters(document, textToReplace);
//            PDDocument pdfDocument = new PDDocument();
//            PDPage page = new PDPage();
//            pdfDocument.addPage(page);
//
//            // Create a content stream for the PDF page
//            PDPageContentStream contentStream = new PDPageContentStream(pdfDocument, page);
//            // Handle headers
//            XWPFHeader header = document.getHeaderList().get(0); // Get the first header
//            if (header != null) {
//                for (XWPFParagraph paragraph : header.getParagraphs()) {
//                    addParagraphToPdf(paragraph, contentStream, yOffset);
//                }
//            }
//
//            // Iterate through paragraphs and tables in the DOCX and add them to the PDF
//            for (XWPFParagraph paragraph : document.getParagraphs()) {
//                addParagraphToPdf(paragraph, contentStream, yOffset);
//            }
//
//            // Handle tables in the DOCX
//            List<XWPFTable> tables = document.getTables();
//            for (XWPFTable table : tables) {
//                addTableToPdf(table, contentStream, yOffset);
//            }
//            // Handle footers
//            XWPFFooter footer = document.getFooterList().get(0); // Get the first footer
//            if (footer != null) {
//                for (XWPFParagraph paragraph : footer.getParagraphs()) {
//                    addParagraphToPdf(paragraph, contentStream, yOffset);
//                }
//            }
//
//            // Close the content stream and save the PDF to a byte array
//            contentStream.close();
//            pdfDocument.save(baos);
//            pdfDocument.close();
//
//            // Save the PDF to a file
//            FileOutputStream fos = new FileOutputStream("C:\\Users\\alamin\\Downloads\\revised_marcom_document_final.pdf");
//            fos.write(baos.toByteArray());
//            fos.close();
//
//            System.out.println("PDF created successfully.");
//
//        } catch (DocumentException | IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    private static void processParagraphs(XWPFDocument doc, Map<String, String> textToReplace) {
//        for (XWPFParagraph paragraph : doc.getParagraphs()) {
//            for (XWPFRun run : paragraph.getRuns()) {
//                String text = run.getText(0);
//
//                if (text != null) {
//                    for (String key : textToReplace.keySet()) {
//                        if (text.contains(key)) {
//                            text = text.replace(key, textToReplace.get(key));
//                            run.setText(text, 0);
//                        }
//                    }
//                }
//            }
//        }
//    }
//
//    private static void processTables(XWPFDocument doc, Map<String, String> textToReplace) {
//        for (XWPFTable table : doc.getTables()) {
//            for (XWPFTableRow row : table.getRows()) {
//                for (XWPFTableCell cell : row.getTableCells()) {
//                    for (XWPFParagraph paragraph : cell.getParagraphs()) {
//                        for (XWPFRun run : paragraph.getRuns()) {
//                            String text = run.getText(0);
//
//                            if (text != null) {
//                                for (String key : textToReplace.keySet()) {
//                                    if (text.contains(key)) {
//                                        text = text.replace(key, textToReplace.get(key));
//                                        run.setText(text, 0);
//                                    }
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//        }
//    }
//
//    private static void processFooters(XWPFDocument doc, Map<String, String> textToReplace) {
//        for (XWPFFooter footer : doc.getFooterList()) {
//            List<XWPFParagraph> paragraphs = footer.getParagraphs();
//
//            for (XWPFParagraph paragraph : paragraphs) {
//                for (XWPFRun run : paragraph.getRuns()) {
//                    String text = run.getText(0);
//
//                    if (text != null) {
//                        for (String key : textToReplace.keySet()) {
//                            if (text.contains(key)) {
//                                text = text.replace(key, textToReplace.get(key));
//                                run.setText(text, 0);
//                            }
//                        }
//                    }
//                }
//            }
//        }
//    }
//
//    private static void addParagraphToPdf(XWPFParagraph paragraph, PDPageContentStream contentStream, float yOffset)
//            throws IOException, DocumentException {
//        PDFont pdfFont = PDType1Font.HELVETICA;
//        int fontSize = 12;
//
//        contentStream.setFont(pdfFont, fontSize);
//
//        contentStream.beginText();
//        float textHeight = fontSize / 2; // Adjust this value as needed
//
//        // Calculate the position based on yOffset and textHeight
//        float yPosition = 700 - yOffset - textHeight;
//
//        // Update the yOffset based on the text height
//        yOffset += textHeight;
//
//        contentStream.newLineAtOffset(100, yPosition);
//
//        // Replace control characters with spaces (or other suitable characters)
//        String sanitizedText = paragraph.getText().replaceAll("\\p{Cntrl}", " ");
//        contentStream.showText(sanitizedText);
//
//        contentStream.endText();
//    }
//
//
//    private static void addTableToPdf(XWPFTable table, PDPageContentStream contentStream, float yOffset)
//            throws IOException, DocumentException {
//        // Process the table rows and cells
//        List<XWPFTableRow> rows = table.getRows();
//        for (XWPFTableRow row : rows) {
//            // Calculate and update yOffset for each row
//            yOffset += calculateTableRowHeight(row);
//
//            List<XWPFTableCell> cells = row.getTableCells();
//            for (XWPFTableCell cell : cells) {
//                // Calculate and update yOffset for each cell
//                yOffset += calculateTableCellHeight(cell);
//
//                // Add the text from each cell to the PDF
//                addParagraphToPdf(cell.getParagraphs().get(0), contentStream, yOffset);
//            }
//        }
//    }
//
//    private static float calculateTableRowHeight(XWPFTableRow row) {
//        // Calculate the maximum cell height in the row
//        float maxCellHeight = 0;
//        for (XWPFTableCell cell : row.getTableCells()) {
//            float cellHeight = calculateTableCellHeight(cell);
//            if (cellHeight > maxCellHeight) {
//                maxCellHeight = cellHeight;
//            }
//        }
//        return maxCellHeight;
//    }
//
//    private static float calculateTableCellHeight(XWPFTableCell cell) {
//        // Calculate the height of the cell content
//        float cellHeight = 0;
//        for (XWPFParagraph paragraph : cell.getParagraphs()) {
//            cellHeight += 12 / 2; // Adjust this value as needed (font size 12)
//        }
//        return cellHeight;
//    }
//}
