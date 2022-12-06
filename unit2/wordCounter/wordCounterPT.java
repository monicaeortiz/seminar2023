import java.util.*;
import java.io.*;
public class wordCounterPT {
public static void main(String[] args) throws FileNotFoundException {
    //command Line arguments
   
   String fileName = "macbeth.txt";
 
    //make sure to take in a file, not just the string of pathname
    File f = new File(fileName);
    Map<String, Integer> wordCounts = new HashMap<> ();
    for (int i = 0; i<25; i++) {
        System.out.println(countWords(f, wordCounts));
        //System.out.println(wordCounts);
    }
    
}

public static String cleanUp(String word) {
    word = word.toLowerCase();  // Force word to be in lowercase.
    word = word.replaceAll("[^A-Za-z]+", "");  // Remove any non-alphanumeric characters.
    return word;
  }

public static String countWords(File f, Map <String, Integer> wordCounts) throws FileNotFoundException {
    Set <String> keysss = wordCounts.keySet();
    for (String keys1 : keysss) {
        wordCounts.put(keys1, 0);
    }
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
            // check if s is in stopWords
            if (stopWords.indexOf(s) == -1) {
                wordCounts.put(s, wordCounts.getOrDefault(s,0)+1);
            }
            
          
        }
    }
    //System.out.println(wordCounts);
    //iterate through frequencies to find the largest value in the map, and return the key
    Collection<Integer> values = wordCounts.values();
    int maxValue = Collections.max(values);
    //given the max value find the key
    //makes a set of the keys
    Set <String> keys = wordCounts.keySet();
    String toRet = "";
    // iterate through keys to find the key to return
    for (String key1 : keys) {
        if (wordCounts.get(key1) >= maxValue) {
            toRet = key1;
        }
    }
    wordCounts.remove(toRet);
    //System.out.println(wordCounts);
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