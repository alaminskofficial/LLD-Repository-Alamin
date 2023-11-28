package org.example;

//import java.io.ByteArrayOutputStream;
//import com.lowagie.text.pdf.BaseFont;
//import com.lowagie.text.pdf.PdfContentByte;
//import com.lowagie.text.pdf.PdfReader;
//import com.lowagie.text.pdf.PdfStamper;
//
//public class ReplaceContentInPdf {
//    public static void main(String[] args) {
//        try {
//            PdfReader reader = new PdfReader(samplePath);
//            if(reader!=null) {
//                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//                PdfStamper stamper = new PdfStamper(reader, byteArrayOutputStream);
//                BaseFont baseFont = BaseFont.createFont(BaseFont.HELVETICA_BOLD, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
//                for (int i = 1; i <= reader.getNumberOfPages(); i++) {
//
//                    if (i == 1) {
//                        PdfContentByte firstPage = stamper.getOverContent(i);
//                        firstPage.beginText();
//                        firstPage.setFontAndSize(baseFont, 11);
//                        firstPage.setTextMatrix(436, 642);
//                        firstPage.showText((String) dateFormat.format(corporateEntity.getCreatedOn()));
//                        firstPage.setTextMatrix(157, 642);
//                        firstPage.showText(corporateEntity.getCode());
//                        firstPage.setTextMatrix(170, 596);
//                        firstPage.showText("Mr./Mrs. " + userName);
//                        firstPage.setTextMatrix(215, 576);
//                        firstPage.showText(distributorType);
//                        firstPage.setTextMatrix(420, 555);
//                        firstPage.showText((String) dateFormat.format(corporateEntity.getCreatedOn()));
//                        firstPage.setTextMatrix(40, 300);
//                        firstPage.showText(line1);
//                        firstPage.setTextMatrix(40, 286);
//                        firstPage.showText(line2);
//                        firstPage.setTextMatrix(40, 272);
//                        firstPage.showText((String) officeAddressMap.get("vtc") + " - " + pincode);
//                        firstPage.setTextMatrix(143, 89);
//                        firstPage.showText(": " + (String) dateFormat.format(currentDate));
//                        firstPage.setTextMatrix(476, 90);
//                        firstPage.showText(": Bengaluru");
//                        firstPage.endText();
//                    }
//                }
//                stamper.close();
//                byte[] pdf_bytes = byteArrayOutputStream.toByteArray();
//                return pdf_bytes;
//            }
//        } catch (Exception e) {
//            LOGGER.error("Found Some issue in generating pdf ", e);
//            throw new NovopayFatalException("NR-220150");
//        }
//    }
//}
