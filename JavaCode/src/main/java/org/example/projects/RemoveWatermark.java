package org.example;

//import java.io.IOException;
//import com.itextpdf.kernel.colors.ColorConstants;
//import com.itextpdf.kernel.font.PdfFont;
//import com.itextpdf.kernel.font.PdfFontFactory;
//import com.itextpdf.kernel.geom.Rectangle;
//import com.itextpdf.kernel.pdf.PdfDocument;
//import com.itextpdf.kernel.pdf.PdfPage;
//import com.itextpdf.kernel.pdf.PdfReader;
//import com.itextpdf.kernel.pdf.PdfWriter;
//import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
//
//
//
//public class RemoveWatermark {
//    public static void main(String[] args) throws IOException {
//        String inputPath = "C:\\Users\\alamin\\Downloads\\marcom_document_output.pdf";
//        String outputPath = "C:\\Users\\alamin\\Downloads\\marcom_document_output_final.pdf";
//
//        // Load PDF
//        PdfDocument pdfDoc = new PdfDocument(new PdfReader(inputPath), new PdfWriter(outputPath));
//
//        // Specify the font and size for replacement text
//        PdfFont font = PdfFontFactory.createFont();
//        float fontSize = 12;
//
//        // Replace text on each page
//        for (int pageNum = 1; pageNum <= pdfDoc.getNumberOfPages(); pageNum++) {
//            PdfPage page = pdfDoc.getPage(pageNum);
//            PdfCanvas canvas = new PdfCanvas(page);
//
//            String originalText = "Evaluation Warning : The document was created with Spire.PDF for Java.";
//            String replacementText = " ";
//
//            // Specify the rectangle for the replacement area (you may need to adjust coordinates)
//            Rectangle rectangle = new Rectangle(100, 400, 300, 50);
//
//            // Draw the replacement text with the specified font and size
//            canvas.setFontAndSize(font, fontSize);
//            //canvas.setFillColor(ColorConstants.BLACK);
//            canvas.rectangle(rectangle);
//            canvas.fill();
//            canvas.beginText();
//            canvas.setTextMatrix(rectangle.getLeft(), rectangle.getTop());
//            canvas.showText(replacementText);
//            canvas.endText();
//        }
//
//        pdfDoc.close();
//    }
//}

