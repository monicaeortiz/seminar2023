import java.io.*;
import java.util.*;

public class RobynKathrynTwilightCounter {
    public static void main (String[] commandLineArgs) throws FileNotFoundException{  
        String string = commandLineArgs[0]; 
        File filename = new File(string); 
        findPopWords(filename, 10); 
    }

    public static void findPopWords(File f, int numWords) throws FileNotFoundException{
        Scanner fileScan = new Scanner(f);
        ArrayList<String> uniqueWords = new ArrayList<String>(); //will hold 
        ArrayList<Integer> wordsCount = new ArrayList<Integer>();

        while (fileScan.hasNextLine()) {
            String line = fileScan.nextLine();
            Scanner lineScan = new Scanner(line);
            while (lineScan.hasNext()) {
                String curWord = lineScan.next(); //gets each word as a token
                curWord = cleanUp(curWord); //removes punctuation from token
                if (uniqueWords.indexOf(curWord) == -1) { //if the current word is unique
                    uniqueWords.add(curWord); 
                    wordsCount.add(1); 
                }
                else {
                    //find index of the word in wordsCount
                    int index = uniqueWords.indexOf(curWord); 
                    //get item at that index
                    int currWordCount = wordsCount.get(index); 
                    //increment that item 
                    wordsCount.set(index, currWordCount+1); 
                }
            }
            lineScan.close(); 
        }
        fileScan.close(); 

        ArrayList<String> mostUsedWords = new ArrayList<String>();
        ArrayList<Integer> mostUsedWordsCounts = new ArrayList<Integer>();

        for (int i=0; i<numWords; i++) {
            int high = wordsCount.get(0); 
            for (int j=0; j<wordsCount.size(); j++) {
                int temp = wordsCount.get(j); 
                if (temp>high) {
                    high = temp;
                }
            }

            mostUsedWords.add(uniqueWords.get(wordsCount.indexOf(high))); 
            mostUsedWordsCounts.add(wordsCount.get(wordsCount.indexOf(high))); 
            uniqueWords.remove(wordsCount.indexOf(wordsCount.indexOf(high)));
            wordsCount.remove(wordsCount.indexOf(high));
        }

        System.out.println("Top " + numWords + " most used words: " + mostUsedWords);
        System.out.println("  Their counts: " + mostUsedWordsCounts);
    
    }

    public static String cleanUp(String word) {
        word = word.toLowerCase();  // Force word to be in lowercase.
        word = word.replaceAll("[^A-Za-z]+", "");  // Remove any non-alphanumeric characters.
        return word;
    }


}

