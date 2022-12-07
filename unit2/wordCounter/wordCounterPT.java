import java.util.*;
import java.io.*;
import java.io.IOException; 
public class wordCounterPT {
<<<<<<< HEAD
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
    
=======
public static void main(String[] commandLineArgs) throws FileNotFoundException {
    //make sure to take in a file, not just the string of pathname
    File f = new File("twilight.txt");
    System.out.println(countWords(f));
>>>>>>> 3a0452f7e1e2ce6a99a4e1e0bc1a7029526e3aee
}

public static String cleanUp(String word) {
    word = word.toLowerCase();  // Force word to be in lowercase.
    word = word.replaceAll("[^A-Za-z]+", "");  // Remove any non-alphanumeric characters.
    return word;
  }

<<<<<<< HEAD
public static String countWords(File f, Map <String, Integer> wordCounts) throws FileNotFoundException {
    Set <String> keysOfSet = wordCounts.keySet();
    for (String keys1 : keysOfSet) {
        wordCounts.put(keys1, 0);
    } 
    //make an AL with all of the stopwords
    ArrayList<String> stopWords = findStopWords("stopwords.txt");
=======
public static File countWords(File f, Map <String, Integer> wordCounts) throws FileNotFoundException {
    Map<String, Integer> wordCounts = new TreeMap<> ();
    Set<String> stopWords = findStopWords("stopwords.txt");
>>>>>>> 3a0452f7e1e2ce6a99a4e1e0bc1a7029526e3aee
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
            if(!stopWords.contains(s)){
            wordCounts.put(s, wordCounts.getOrDefault(wordCounts.get(s),0)+1);
            }
        }
    }
<<<<<<< HEAD
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
=======
    return mostCommonAsFile(wordCounts, 25)
>>>>>>> 3a0452f7e1e2ce6a99a4e1e0bc1a7029526e3aee
}

//create a set of all of the stop words in 'stopwords.txt'
public static Set<String> findStopWords(String pathname) throws FileNotFoundException{
    File f = new File(pathname);
    Set<String> stopWords = new HashSet<>();
    Scanner sc = new Scanner(f);
    while(sc.hasNextLine()){
        stopWords.add(sc.next());
    }
    return stopWords;
}

public static File f mostCommonAsFile(TreeMap<String, Integer> wordCounts, int n) throws FileNotFoundException{
    //write to a file of the first n words in the the TreeMap
    PrintStream p = new PrintStream(new FileOutputStream("mostCommonWords.txt", true));
    int x = n;
    Set<String> largestKeys = new HashSet<>();
    p.println("The top 25 most used words are: ");
    for(String word: wordCounts.keySet()){
        if(x>=0){
            p.println(word);
        }
        x--;
    }
    return p;
}
}