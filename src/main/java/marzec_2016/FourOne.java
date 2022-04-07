package marzec_2016;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.util.*;

public class FourOne {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner galleriesFile = GalleriesFileRead.read();
        PrintStream outputFile = new PrintStream("wynik4_1.txt");
        String line = "";
        String element;
        Map<String, Integer> citiesFrequency = new LinkedHashMap<>();

        while (galleriesFile.hasNextLine()) {
            line = galleriesFile.nextLine();
            element = line.split(" ", 2)[0];
            citiesFrequency.compute(element, (key, val) -> (val == null) ? 1: val + 1);
        }
        for (String key :
                citiesFrequency.keySet()) {
            outputFile.printf("%s %d\n", key, citiesFrequency.get(key));
        }
       outputFile.close();
    }
}
