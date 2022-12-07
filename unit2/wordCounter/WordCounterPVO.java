import java.util.*;
import java.io.*;
public class WordCounterPVO{
    public static void main(String[] commandLineArgs) throws FileNotFoundException {
        //make sure to take in a file, not just the string of pathname
        String fileName = commandLineArgs[0];
        File f = new File(fileName);
        countWords(f);
    }

    public static String cleanUp(String word){
        word = word.toLowerCase();  // Force word to be in lowercase.
        word = word.replaceAll("[^A-Za-z]+", "");  // Remove any non-alphanumeric characters.
        return word;
    }

    public static void countWords(File f) throws FileNotFoundException {
        Map<String, Integer> wordCounts = new HashMap<> ();
        Set<String> stopWords = findStopWords("stopwords.txt");
        //make a scanner to iterate through the file
        Scanner sc = new Scanner(f);
        //create a TreeMap of the sorted values of the counts
        while(sc.hasNextLine()){
            //string scanner
            String currentLine = sc.nextLine();
            //iterate through current line with a LineScanner
            Scanner lineScan = new Scanner(currentLine);
            while(lineScan.hasNext()){
                String s = cleanUp(lineScan.next());
                if(!stopWords.contains(s) && s.length() > 0){
                    wordCounts.put(s, wordCounts.getOrDefault(s,0)+1);
                }
            }
        }
        mostCommonInFile(wordCounts, 25);
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

    public static void mostCommonInFile(Map<String, Integer> words, int n) throws FileNotFoundException{
        PrintStream p = new PrintStream(new File ("mostCommonWords.txt"));
        p.println("The top " + n + " most used words are: ");
    
        //make an arraylist that contains all of the words that are already used
        ArrayList<String> usedWords = new ArrayList<>();

        //iterate through to find 'n' number of top words
        for(int i = 0; i<n; i++){
            //make temporary variables for the currentMax value and the currentMax word
            int currentMax = 0;
            String currentMaxWord = "";
            //iterate through the set of keys
            for(String key: words.keySet()){
                //determine if they key was already used, by seeing if it is in the arrayList of usedWords
                if(usedWords.indexOf(key) == -1){
                    //if the current value is greater than the current max
                    if(words.get(key) > currentMax){
                        //change the values of the temp variables
                        currentMax = words.get(key);
                        currentMaxWord = key;
                    }
                }
            }
            //add the current max word
            usedWords.add(currentMaxWord);
            //write to the file of the current max word
            p.println(currentMaxWord);
        }

    }
}