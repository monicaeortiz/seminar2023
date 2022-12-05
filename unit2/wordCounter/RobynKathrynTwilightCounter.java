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
        Scanner fileScan = new Scanner(f);
        // ArrayList<String> uniqueWords = new ArrayList<String>(); //will hold 
        // ArrayList<Integer> wordsCount = new ArrayList<Integer>();
        Map<String, Integer> wordFreq = new HashMap<>(); 

        while (fileScan.hasNextLine()) {
            String line = fileScan.nextLine();
            Scanner lineScan = new Scanner(line);
            while (lineScan.hasNext()) {
                String curWord = lineScan.next(); //gets each word as a token
                wordFreq.put(curWord, wordFreq.getOrDefault(curWord, 0) + 1); 
                }
            lineScan.close(); 
        }
        fileScan.close(); 

        Collection<String> uniqueWords = wordFreq.keySet(); //Collection holding all unique words
        String mostFreqWord = ""; 
        int largestValue = 0; 
        for (String curUniqueWord: uniqueWords) { //checking values 
            if (wordFreq.get(curUniqueWord)>largestValue) {
                largestValue = wordFreq.get(curUniqueWord); 
                mostFreqWord += curUniqueWord; 
            }
        } 

        System.out.println(mostFreqWord); 

        System.out.println("The most frequently used word is " + mostFreqWord); 
        
        
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
}


// Read file 
// Create Map<Strings, Integers> that holds all unique words and their frequencies & fill it 
// Create collection of values 
// Find top 10 values 
// Find words that correspond to top 10 values  