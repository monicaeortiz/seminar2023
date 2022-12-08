import java.util.*;
import java.io.*;
public class wordCounterHT {
public static void main(String[] args) throws FileNotFoundException {
   // creates a file from the text file
    String fileName = "macbeth.txt";
    File f = new File(fileName);

    // generates empty map for unique words and their counts
    Map<String, Integer> wordCounts = new HashMap<> ();

    // generates AL of stop words
    ArrayList<String> stopWords = findStopWords("stopwords.txt");

    // creates a file to append top 25 words to
    File top25Words = new File("C:\\Users\\Documents\\csSeminar\\onlineSeminar\\unit2\\wordCounter\\top25Words.txt");

    // scanning the text file
    Scanner sc = new Scanner(f);
    while(sc.hasNextLine()){
        //string scanner
        String currentLine = sc.nextLine();
        //iterate through current line with a LineScanner
        Scanner lineScan = new Scanner(currentLine);
        while(lineScan.hasNext()) {
            String s = cleanUp(lineScan.next());
            // check if s is in stopWords
            if (stopWords.indexOf(s) == -1) {
                // if not, add current word as a key to the map, and inceement its value by 1
                wordCounts.put(s, wordCounts.getOrDefault(s,0)+1);
            } 
        }
    }
    // creates print stream for our top 25 words text file
    PrintStream p = new PrintStream(new FileOutputStream("top25Words.txt"), true);

    // iterates through main method 25 times to get top 25 words
    for (int i = 0; i<25; i++) {
        // saves return value of our main method (most popular word) to a variable
        String popularWord = countWords(f, wordCounts);
        // removes the most popular word from the map
        wordCounts.remove(popularWord);
        // writes the most popular word to a file
        p.println(popularWord);
    }
}

// clean up method
public static String cleanUp(String word) {
    word = word.toLowerCase();  // Force word to be in lowercase.
    word = word.replaceAll("[^A-Za-z]+", "");  // Remove any non-alphanumeric characters.
    return word;
}

// main method: takes in text file and current map of unique words and their occurrences as parameter
public static String countWords(File f, Map <String, Integer> wordCounts) throws FileNotFoundException {
    //makes a collection of all the values in the map
    Collection<Integer> values = wordCounts.values();
    // finds max value
    int maxValue = Collections.max(values);
    //makes a set of the keys
    Set <String> keys = wordCounts.keySet();
    // initializes empty string to return
    String toRet = "";
    // iterate through keys to find the key that has the largest value to return
    for (String key1 : keys) {
        if (wordCounts.get(key1) >= maxValue) {
            toRet = key1;
        }
    }
    // returns most popular word
    return toRet;
}


//creating an arrayList with all of the words in the stopwords.txt
public static ArrayList<String> findStopWords(String pathname) throws FileNotFoundException {
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