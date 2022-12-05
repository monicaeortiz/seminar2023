import java.util.*;
import java.io.*;
public class wordCounterPT {
public static void main(String[] commandLineArgs) throws FileNotFoundException {
    //command Line arguments
   
   String fileName = commandLineArgs[0];
 
    //make sure to take in a file, not just the string of pathname
    File f = new File(fileName);
    System.out.println(countWords(f));

    //findStopWords("stopwords.txt");
}

public static String cleanUp(String word) {
    word = word.toLowerCase();  // Force word to be in lowercase.
    word = word.replaceAll("[^A-Za-z]+", "");  // Remove any non-alphanumeric characters.
    return word;
  }

public static String countWords(File f) throws FileNotFoundException {
    //make an AL with all of the stopwords
    ArrayList<String> stopWords = findStopWords("stopwords.txt");
    //make AL to hold the words and counts
    ArrayList<String> words = new ArrayList<> ();
    ArrayList<Integer> counts = new ArrayList<> ();

    //make a scanner to iterate through the file
    Scanner sc = new Scanner(f);
    //iterate through file using a while loop
    while(sc.hasNextLine()){
        //string scanner
        String current = sc.nextLine();
        //iterate through current line with a LineScanner
        Scanner lineScan = new Scanner(current);
        while(lineScan.hasNext()){
            String s = cleanUp(lineScan.next());
            //if it doesn't exists (meaning the index is -1) and it is not in stop words (index is also equal to -1)
            if(stopWords.indexOf(s) == -1 || s.equals("")){
                if(words.indexOf(s) == -1){
                    words.add(s);
                    counts.add(1);
                }
                int index = words.indexOf(s);
                counts.set(index, counts.get(index)+1);
            }
        }
    }
    //find the index of the largest using helper method and return the words
    int index = findLargest(counts);

    // remove weird character from words and counts.
    words.remove(index);
    counts.remove(index);

    //find new index with the changed words and counts
    index = findLargest(counts);
    return  words.get(index);
}

//helper method to find the largest value in the arrayList
public static int findLargest (ArrayList <Integer> counts ) {
    int largest = counts.get(0);
    int index = 0;
    for (int i = 0; i<counts.size(); i++) {
        if (counts.get(i) > largest) {
            largest = counts.get(i);
            index = i;
        }
    }
    return index;
}

//creating an arrayList with all of the words in the stopwords.txt
public static ArrayList<String> findStopWords(String pathname) throws FileNotFoundException{
    //create an arrayList with all of the words in the file
    File f = new File(pathname);
    ArrayList<String> stopWords = new ArrayList <> ();
    Scanner sc = new Scanner(f);
    while(sc.hasNextLine()){
        stopWords.add(sc.next());
    }
    return stopWords;
}
}