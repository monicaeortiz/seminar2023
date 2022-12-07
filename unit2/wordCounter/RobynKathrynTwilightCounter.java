import java.io.*;
import java.util.*;
//Robyn and Kathryn

public class RobynKathrynTwilightCounter {
    public static void main (String[] commandLineArgs) throws FileNotFoundException{  
        String string = commandLineArgs[0]; 
        File filename = new File(string); 
        findPopWords(filename, 25, "popWords.txt"); 
    }

    public static void findPopWords(File f, int numWords, String fileName) throws FileNotFoundException{
        Map<String, Integer> wordFreq = new HashMap<>(); 
        Set<String> highestCountWords = new HashSet<>();


        Set<String> stopWords = new HashSet<>(); //creates set to hold stop words
        File stopWordsFile = new File("../stopwords.txt"); 
        Scanner stopWScanner = new Scanner(stopWordsFile); 

        //fills set of stop words 
        while (stopWScanner.hasNextLine()) {
            String curStopW = stopWScanner.nextLine();//gets each word as a token 
            stopWords.add(curStopW); 
        }
        stopWScanner.close(); 



        Scanner fileScan = new Scanner(f);

        while (fileScan.hasNextLine()) {
            // String line = fileScan.nextLine();
            // Scanner lineScan = new Scanner(line);
            String[] row = fileScan.nextLine().split(" "); //takes a line, gets rid of spaces, and puts elements in an array
            for (int k = 0; k < row.length; k++) {
                String curWord = row[k]; 
                curWord = cleanUp(curWord);//removing punctuation
                if (!stopWords.contains(curWord)) { //if the current word is a stop word, do not add in to the map 
                    wordFreq.put(curWord, wordFreq.getOrDefault(curWord, 0) + 1);//either increase the value of the key by 1, or add the word into the map and set the default value to 1
                }
            }
        }
        fileScan.close(); 

        List<String> uniqueWords = new ArrayList<>(wordFreq.keySet());

        PrintStream p = new PrintStream (fileName);//prinstream to print our most frequent words to a file

        for (int l = 0; l < numWords; l++){
        String mostFreqWord = uniqueWords.get(0); //initializing most frequent word to the first element in our list
        int largestValue = wordFreq.get(mostFreqWord); //largest value intitialized to the value of mostFreqWord

            for (int i = uniqueWords.size() - 1; i >= 0; i--) { //checking values 
                if (wordFreq.get(uniqueWords.get(i)) > largestValue) { //if we find a more frequent word, replace mostFreqWord and largestValue accordingly
                largestValue = wordFreq.get(uniqueWords.get(i)); 
                mostFreqWord = uniqueWords.get(i); 
                
                }
            }

            p.println(l + " place: " + mostFreqWord);
            uniqueWords.remove(mostFreqWord);//remove the mostFreqWord from the list, no longer included in comparisons

        }

    }
    
    

    public static String cleanUp(String word) {
        word = word.toLowerCase();  // Force word to be in lowercase.
        word = word.replaceAll("[^A-Za-z]+", "");  // Remove any non-alphanumeric characters.
        return word;
    }

}


// Read file 
// Create Map<Strings, Integers> that holds all unique words and their frequencies & fill it 
// Create collection of values 
// Find top 10 values 
// Find words that correspond to top 10 values  