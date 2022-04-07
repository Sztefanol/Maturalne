package marzec_2016;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FourTwo {
    public static void main(String[] args) throws FileNotFoundException {

        String[] lineElements;
        String line;
        int galleryCount, surfaceCount;

        Scanner galleriesFile = GalleriesFileRead.read();
        PrintStream outputFile = new PrintStream("wynik4_2.txt");

        while (galleriesFile.hasNextLine()) {
            galleryCount = 0;
            surfaceCount = 0;

            line = galleriesFile.nextLine();
            lineElements = line.split(" ", 0);

            for (int i = 2; i <= 142; i += 2) {
                if (lineElements[i].equals("0")) break;
                surfaceCount += Integer.parseInt(lineElements[i]) * Integer.parseInt(lineElements[i + 1]);
                galleryCount++;
            }
            outputFile.printf("%s %d %d\n", lineElements[1], surfaceCount, galleryCount);
        }
        outputFile.close();
    }
}