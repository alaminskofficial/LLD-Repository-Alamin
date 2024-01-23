package org.example;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.TextPosition;

import java.io.*;
import java.util.List;

public class GetWordLocationAndSize extends PDFTextStripper {

    public GetWordLocationAndSize() throws IOException {
    }

    public static void main(String[] args) throws IOException {
        PDDocument document = null;
        String fileName = "C:\\Users\\alamin\\Downloads\\ak.pdf";
        try {
            document = PDDocument.load(new File(fileName));
            PDFTextStripper stripper = new GetWordLocationAndSize();
            stripper.setSortByPosition(true);
            stripper.setStartPage(0);
            stripper.setEndPage(document.getNumberOfPages());

            Writer dummy = new OutputStreamWriter(new ByteArrayOutputStream());
            stripper.writeText(document, dummy);
        } finally {
            if (document != null) {
                document.close();
            }
        }
    }

    @Override
    protected void writeString(String string, List<TextPosition> textPositions) throws IOException {
        StringBuilder wordBuilder = new StringBuilder();
        for (TextPosition text : textPositions) {
            String character = text.getUnicode();

            // Check if the character is a space, indicating a new word
            if (character.equals(" ")) {
                if (wordBuilder.length() > 0) {
                    // Process the completed word
                    processWord(wordBuilder.toString(), textPositions);
                    wordBuilder.setLength(0); // Clear the word builder
                }
            } else {
                // Append the character to the word
                wordBuilder.append(character);
            }
        }

        // Process the last word if not empty
        if (wordBuilder.length() > 0) {
            processWord(wordBuilder.toString(), textPositions);
        }
    }

    private void processWord(String word, List<TextPosition> textPositions) {
        // Initialize variables to hold rounded coordinates
        long minX = Long.MAX_VALUE;
        long minY = Long.MAX_VALUE;
        long maxX = Long.MIN_VALUE;
        long maxY = Long.MIN_VALUE;

        float totalWidth = 0;
        float maxHeight = 0;

        for (TextPosition text : textPositions) {
            String character = text.getUnicode();
            if (character.equals(word)) {
                // Round the coordinates to long values
                long x = Math.round(text.getXDirAdj());
                long y = Math.round(text.getYDirAdj());
                float width = text.getWidthDirAdj();
                float height = text.getHeightDir();

                // Update coordinates and size
                minX = Math.min(minX, x);
                minY = Math.min(minY, y);
                maxX = Math.max(maxX, x + Math.round(width));
                maxY = Math.max(maxY, y + Math.round(height));
                totalWidth += width;
                maxHeight = Math.max(maxHeight, height);
            }
        }

        // Print word details (rounded coordinates and size)
        System.out.println("Word: " + word);
        System.out.println("Coordinates (X,Y): (" + minX + "," + minY + ")");
        System.out.println("Size (Width, Height): (" + totalWidth + "," + maxHeight + ")\n");
    }

}
