package org.example;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.TextPosition;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class GetCharLocationAndSize extends PDFTextStripper {

    private List<TextPosition> textList = new ArrayList<>();
    private float pageHeight;

    public GetCharLocationAndSize() throws IOException {
    }

    public static void main(String[] args) throws IOException {
        PDDocument document = null;
        String fileName = "C:\\Users\\alamin\\Downloads\\tdsExemptionletterTest.pdf"; // Replace with your PDF file path
        try {
            document = PDDocument.load(new File(fileName));
            GetCharLocationAndSize stripper = new GetCharLocationAndSize();
            stripper.setSortByPosition(true);
            stripper.setStartPage(0);
            stripper.setEndPage(document.getNumberOfPages());

            stripper.pageHeight = document.getPage(0).getMediaBox().getHeight();

            stripper.getText(document);

            // Sort text positions to maintain original order
            Collections.sort(stripper.textList, new TextPositionComparator());

            for (TextPosition text : stripper.textList) {
                System.out.println("Word: " + text.getUnicode());
                System.out.println("Coordinates (X,Y): (" + Math.round(text.getXDirAdj()) + "," + Math.round(stripper.pageHeight - text.getYDirAdj()) + ")");
//                System.out.println("Size (Width, Height): (" + text.getWidthDirAdj() + "," + text.getHeightDir() + ")");
            }
        } finally {
            if (document != null) {
                document.close();
            }
        }
    }

    @Override
    protected void processTextPosition(TextPosition text) {
        textList.add(text);
    }

    private static class TextPositionComparator implements Comparator<TextPosition> {
        @Override
        public int compare(TextPosition text1, TextPosition text2) {
            // Compare text positions by their Y coordinate (top-to-bottom order)
            float y1 = text1.getYDirAdj();
            float y2 = text2.getYDirAdj();
            if (y1 < y2) {
                return -1;
            } else if (y1 > y2) {
                return 1;
            } else {
                // If Y coordinates are the same, compare by X coordinate
                float x1 = text1.getXDirAdj();
                float x2 = text2.getXDirAdj();
                if (x1 < x2) {
                    return -1;
                } else if (x1 > x2) {
                    return 1;
                } else {
                    // If both X and Y coordinates are the same, maintain order
                    return 0;
                }
            }
        }
    }
}
