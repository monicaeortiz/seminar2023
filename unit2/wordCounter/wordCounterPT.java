import java.util.*;
import java.io.*;
public class wordCounterPT {
public static void main(String[] commandLineArgs) throws FileNotFoundException {
    //make sure to take in a file, not just the string of pathname
    File f = new File("twilight.txt");
    System.out.println(countWords(f));
}

public static String cleanUp(String word) {
    word = word.toLowerCase();  // Force word to be in lowercase.
    word = word.replaceAll("[^A-Za-z]+", "");  // Remove any non-alphanumeric characters.
    return word;
  }

public static File countWords(File f) throws FileNotFoundException {
    //make map of strings and integers
    Map<String, Integer> wordCounts = new TreeMap<> ();
    //make an AL with all of the stopwords
    Set<String> stopWords = findStopWords("stopwords.txt");
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
    //return n largest values in the wordCounts values
    return mostCommonAsFile(wordCounts, 25);
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