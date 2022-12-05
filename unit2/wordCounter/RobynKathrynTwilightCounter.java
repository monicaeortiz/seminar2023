import java.io.*;
import java.util.*;
//Robyn and Kathryn

public class RobynKathrynTwilightCounter {
    public static void main (String[] commandLineArgs) throws FileNotFoundException{  
        String string = commandLineArgs[0]; 
        File filename = new File(string); 
        findPopWords(filename, 10); 
    }

    public static void findPopWords(File f, int numWords) throws FileNotFoundException{
        // ArrayList<String> uniqueWords = new ArrayList<String>(); //will hold 
        // ArrayList<Integer> wordsCount = new ArrayList<Integer>();
        Map<String, Integer> wordFreq = new HashMap<>(); 

        Set<String> highestCountWords = new HashSet<>();

        int highestCount = 0;


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
            String line = fileScan.nextLine();
            Scanner lineScan = new Scanner(line);
            while (lineScan.hasNext()) {
                String curWord = lineScan.next(); //gets each word as a token
                curWord = cleanUp(curWord);
                if (!(stopWords.contains(curWord))) { //if the current word is not a stop word, do not add in to the map 
                    wordFreq.put(curWord, wordFreq.getOrDefault(curWord, 0) + 1);
                }
            }
            lineScan.close(); 
        }
        fileScan.close(); 


        Set<String> uniqueWords = wordFreq.keySet(); //Collection holding all unique words 
        String mostFreqWord = ""; 
        int largestValue = 0; 
        for (String curUniqueWord: uniqueWords) { //checking values 
            if (wordFreq.get(curUniqueWord) > largestValue) {
                largestValue = wordFreq.get(curUniqueWord); 
                
                System.out.println("HELLO" + curUniqueWord); 
                mostFreqWord = curUniqueWord; 
                //System.out.println("Most freq: "+ mostFreqWord); 
            }
        } 
        
        System.out.println(mostFreqWord); 

        // Map<String, Integer> highestWordCounts = new TreeMap<>();
        // int largestCount = 0;
        // for ()


        // Set<String> mostUsedWords = new HashSet<String>();
        // Set<Integer> mostUsedWordsCounts = new HashSet<Integer>();

        // for (int i = 0; i < numWords; i++) {

        //     mostUsedWords.add(uniqueWords.get(findLargest(wordsCount)));
        //     mostUsedWordsCounts.add(wordsCount.get(findLargest(wordsCount))); 
        //     uniqueWords.remove(uniqueWords.get(findLargest(wordsCount)));
        //     wordsCount.remove(wordsCount.get(findLargest(wordsCount)));
        // }
        // System.out.println("Top " + numWords + " most used words: " + mostUsedWords);
        // System.out.println("  Their counts: " + mostUsedWordsCounts);


    }

    public static String cleanUp(String word) {
        word = word.toLowerCase();  // Force word to be in lowercase.
        word = word.replaceAll("[^A-Za-z]+", "");  // Remove any non-alphanumeric characters.
        return word;
    }

    public static String findSmallest(Map <String, Integer> map) {
        Collection<String> words = map.keySet();
        int highestCount = 0;
        String highestWord = "";
        int count = 0;

            for (String word: words){
                if (count == 0){
                    highestCount = map.get(word);
                    count ++;
                }
                if (map.get(word) < highestCount){
                    highestCount = map.get(word);
                    highestWord = word;
                }
            }
        return highestWord;
    }

}
//     public static int findLargest(ArrayList<Integer> arr) { //returns index of the smallest number
//     int index = 0; //
//     int largest = arr.get(0); //starting with the largest possible number

//     for (int i = 0; i < arr.size(); i++) {
//       if (arr.get(i) > largest) { //checking it element does not equal -1
//         largest = arr.get(i); //updates each time a smaller number is found
//         index = i; //records index of smallest number
//       }

//   }

   // return index;


// Read file 
// Create Map<Strings, Integers> that holds all unique words and their frequencies & fill it 
// Create collection of values 
// Find top 10 values 
// Find words that correspond to top 10 values  