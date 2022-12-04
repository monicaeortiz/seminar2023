import java.util.*;
import java.io.*;
public class wordCounterPT {
public static void main(String[] commandLineArgs) throws FileNotFoundException {
    //command Line arguments
   
   String fileName = commandLineArgs[0];
 
    //make sure to take in a file, not just the string of pathname
    File f = new File(fileName);
    System.out.println(countWords(f));
    
}

public static String cleanUp(String word) {
    word = word.toLowerCase();  // Force word to be in lowercase.
    word = word.replaceAll("[^A-Za-z]+", "");  // Remove any non-alphanumeric characters.
    return word;
  }

public static String countWords(File f) throws FileNotFoundException {
    //make map of strings and integers
    Map<String, Integer> wordCounts = new HashMap<> ();
    //make an AL with all of the stopwords
    ArrayList<String> stopWords = findStopWords("stopwords.txt");
    //make a scanner to iterate through the file
    Scanner sc = new Scanner(f);
    //iterate through file using a while loop
    while(sc.hasNextLine()){
        //string scanner
        String currentLine = sc.nextLine();
        //iterate through current line with a LineScanner
        Scanner lineScan = new Scanner(currentLine);
        while(lineScan.hasNext()){
            String s = cleanUp(lineScan.next());
            wordCounts.put(s, wordCounts.getOrDefault(wordCounts.get(s),0)+1);
        }
    }
    //iterate through frequencies to find the largest value in the map, and return the key
    Collection<Integer> values = wordCounts.values();
    int maxValue = Collections.max(values);
    //given the max value find the key
    //makes a set of the keys
    Set <String> keys = wordCounts.keySet();
    String toRet = "";
    // iterate through keys
    for (String key1 : keys) {
        if (wordCounts.get(key1) == maxValue) {
            toRet = key1;
        }
    }
    return toRet;
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