import java.util.*;
import java.io.*;

public class FilesInClass {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("count = " + countValues("ints.txt"));
        countWords("twilight.txt");
    }

    // Prints the number of words in each line of a file.
    public static void countWords(String pathname) throws FileNotFoundException {
        File f = new File(pathname);
        Scanner fileScan = new Scanner(f);
        while (fileScan.hasNextLine()) {  // Goes through each line of file.
            String line = fileScan.nextLine();
            System.out.println(line);  // Print out one line.
            Scanner lineScan = new Scanner(line);
            int words = 0;  // Reset `words` for each new line.
            while (lineScan.hasNext()) {  // Go through each token (word) in one line.
                words++;
                lineScan.next();
            }
            System.out.println("Line has " + words + " words");
            System.out.println();
            lineScan.close();  // Done with this scanner!
        }
        fileScan.close();
    }

    // Counts the number of values in a file where each line contains one integer.
    public static int countValues(String pathname) throws FileNotFoundException {
        File f = new File(pathname);
        Scanner sc = new Scanner(f);
        int count = 0;
        while (sc.hasNextInt()) {
            sc.nextInt();
            count++;
        }
        sc.close();
        return count;
    }
}