import java.util.*;
import java.io.*;
import java.io.IOException; 
public class wordCounterPT {
public static void main(String[] args) throws FileNotFoundException {
   
   String fileName = "macbeth.txt";
    File f = new File(fileName);
    // makes a new file for top 25 words
    File top25Words = new File("C:\\Users\\Documents\\csSeminar\\onlineSeminar\\unit2\\wordCounter\\top25Words.txt");
    Map<String, Integer> wordCounts = new HashMap<> ();
    String popularWord;
    for (int i = 0; i<25; i++) {
        popularWord = countWords(f, wordCounts);
        System.out.println(popularWord);
        // removes the most popualr word from the map each round
        wordCounts.remove(popularWord);
         // writing top 25 words to file (each round = 1 new word)
        try {
            FileWriter writeToFile = new FileWriter("top25Words.txt");
            writeToFile.write(popularWord);
            writeToFile.close();
           } catch (IOException exception) {
            System.out.println("An error occurred.");
            exception.printStackTrace();
           }
        }
        System.out.println(wordCounts);
    
}

public static String cleanUp(String word) {
    word = word.toLowerCase();  // Force word to be in lowercase.
    word = word.replaceAll("[^A-Za-z]+", "");  // Remove any non-alphanumeric characters.
    return word;
  }

public static String countWords(File f, Map <String, Integer> wordCounts) throws FileNotFoundException {
    Set <String> keysOfSet = wordCounts.keySet();
    for (String keys1 : keysOfSet) {
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