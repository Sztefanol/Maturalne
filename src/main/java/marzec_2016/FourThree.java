package marzec_2016;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.*;

public class FourThree {
    public static void main(String[] args) throws FileNotFoundException {

        Set<Integer> uniqueGalleriesCount = new HashSet<>();

        String[] lineElements;
        String line;
        int galleryCount, surfaceCount;

        int lowestUniqueGalleriesCount = 0;
        String lowestUniqueGalleriesCity = null;

        int highestUniqueGalleriesCount = 0;
        String highestUniqueGalleriesCity = null;

        Scanner galleriesFile = GalleriesFileRead.read();
        PrintStream outputFile = new PrintStream("wynik4_3.txt");

        while (galleriesFile.hasNextLine()) {
            galleryCount = 0;
            surfaceCount = 0;

            line = galleriesFile.nextLine();
            lineElements = line.split(" ", 0);

            uniqueGalleriesCount.clear();

            for (int i = 2; i <= 142; i += 2) {
                if (lineElements[i].equals("0")) break;
                uniqueGalleriesCount.add(Integer.parseInt(lineElements[i]) * Integer.parseInt(lineElements[i + 1]));
            }
            if (uniqueGalleriesCount.size() < lowestUniqueGalleriesCount || lowestUniqueGalleriesCount == 0) {
                lowestUniqueGalleriesCount = uniqueGalleriesCount.size();
                lowestUniqueGalleriesCity = lineElements[1];
            }
            if (uniqueGalleriesCount.size() > highestUniqueGalleriesCount || highestUniqueGalleriesCount == 0) {
                highestUniqueGalleriesCount = uniqueGalleriesCount.size();
                highestUniqueGalleriesCity = lineElements[1];
            }
        }
        outputFile.printf("%s %d\n%s %d", highestUniqueGalleriesCity, highestUniqueGalleriesCount, lowestUniqueGalleriesCity, lowestUniqueGalleriesCount);
        outputFile.close();
    }
}
