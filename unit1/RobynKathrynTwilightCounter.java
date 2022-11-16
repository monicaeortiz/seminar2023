import java.io.*;
import java.util.*;

public class RobynKathrynTwilightCounter {
    public static void main (String[] commandLineArgs) throws FileNotFoundException{  
        //File filename = new File(commandLineArgs(0)); 
        File filename = new File("babyTwilight.txt"); 
        popularNumsCounter(filename, 10); 
    }



    public static void findPopWords(File f, int numWords) throws FileNotFoundException{
        Scanner fileScan = new Scanner(f);
        ArrayList<String> uniqueWords = new ArrayList<String>(); //will hold 
        ArrayList<Integer> wordsCount = new ArrayList<Integer>();

        while (fileScan.hasNextLine()) {
        String line = fileScan.nextLine();
        Scanner lineScan = new Scanner(line);
            while (lineScan.hasNext()) {
                String curWord = lineScan.next();
                curWord = cleanUp(curWord); 
                if (uniqueWords.indexOf(curWord) == -1) {
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
        System.out.println(uniqueWords); 
        System.out.println(wordsCount); 


        Boolean updateMade = true; 
        ArrayList<String> mostUsedWords = new ArrayList<String>();
        for (int i =0; i<10; i++) {
            int high = 0; 
            for (int j=0; j<wordsCount.size(); j++) {
                int temp = wordsCount.get(j); 
                if (temp>high) {
                    high = temp;

                }
                System.out.println(high); 
            }
            System.out.println(high); 
            mostUsedWords.add(uniqueWords.get(wordsCount.indexOf(high))); 
            wordsCount.remove(high); 
            uniqueWords.remove(wordsCount.indexOf(high)); 
        }
        System.out.println(mostUsedWords); 

        
    }

    public static String cleanUp(String word) {
        word = word.toLowerCase();  // Force word to be in lowercase.
        word = word.replaceAll("[^A-Za-z]+", "");  // Remove any non-alphanumeric characters.
        return word;
    }


}


/* Pseudocode for TwilightCounter method:  
Go through the entire file, add every inique word to the arrayList
if an occurence of a word is found, add to parallel Integer ArrayList

ArrayList of the words in the file
Parallel ArrayList of integers

pass in number of popular words you want

parse through file with Scanner
parse through every line with scanner
Check each word
    ArraySplice? 
    Arrays.asList

Find the word with the highest count




*/