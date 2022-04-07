package marzec_2016;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GalleriesFileRead {
    static Scanner read() throws FileNotFoundException {
        return new Scanner(new File("galerie_przyklad.txt"));
    }
}
