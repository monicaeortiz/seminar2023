<<<<<<< HEAD
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
                    // //find index of the word in wordsCount
                    // int index = uniqueWords.indexOf(curWord); 
                    // //get item at that index
                    // int currWordCount = wordsCount.get(index); 
                    // //increment that item 
                    // wordsCount.set(index, currWordCount+1); 

                    wordsCount.set(uniqueWords.indexOf(curWord), wordsCount.get(uniqueWords.indexOf(curWord))+1); 
                }
            }
            lineScan.close(); 
        }
        fileScan.close(); 

        ArrayList<String> mostUsedWords = new ArrayList<String>();
        ArrayList<Integer> mostUsedWordsCounts = new ArrayList<Integer>();

        for (int i = 0; i < numWords; i++) {

            mostUsedWords.add(uniqueWords.get(findLargest(wordsCount)));
            mostUsedWordsCounts.add(wordsCount.get(findLargest(wordsCount))); 
            uniqueWords.remove(uniqueWords.get(findLargest(wordsCount)));
            wordsCount.remove(wordsCount.get(findLargest(wordsCount)));
        }
        System.out.println("Top " + numWords + " most used words: " + mostUsedWords);
        System.out.println("  Their counts: " + mostUsedWordsCounts);


    }

    public static String cleanUp(String word) {
        word = word.toLowerCase();  // Force word to be in lowercase.
        word = word.replaceAll("[^A-Za-z]+", "");  // Remove any non-alphanumeric characters.
        return word;
    }


    public static int findLargest(ArrayList<Integer> arr) { //returns index of the smallest number
    int index = 0; //
    int largest = arr.get(0); //starting with the largest possible number

    for (int i = 0; i < arr.size(); i++) {
      if (arr.get(i) > largest) { //checking it element does not equal -1
        largest = arr.get(i); //updates each time a smaller number is found
        index = i; //records index of smallest number
      }

  }

    return index;
}
}
=======
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
                    // //find index of the word in wordsCount
                    // int index = uniqueWords.indexOf(curWord); 
                    // //get item at that index
                    // int currWordCount = wordsCount.get(index); 
                    // //increment that item 
                    // wordsCount.set(index, currWordCount+1); 

                    wordsCount.set(uniqueWords.indexOf(curWord), wordsCount.get(uniqueWords.indexOf(curWord))+1); 
                }
            }
            lineScan.close(); 
        }
        fileScan.close(); 

        ArrayList<String> mostUsedWords = new ArrayList<String>();
        ArrayList<Integer> mostUsedWordsCounts = new ArrayList<Integer>();

        for (int i = 0; i < numWords; i++) {

            mostUsedWords.add(uniqueWords.get(findLargest(wordsCount)));
            mostUsedWordsCounts.add(wordsCount.get(findLargest(wordsCount))); 
            uniqueWords.remove(uniqueWords.get(findLargest(wordsCount)));
            wordsCount.remove(wordsCount.get(findLargest(wordsCount)));
        }
        System.out.println("Top " + numWords + " most used words: " + mostUsedWords);
        System.out.println("  Their counts: " + mostUsedWordsCounts);


    }

    public static String cleanUp(String word) {
        word = word.toLowerCase();  // Force word to be in lowercase.
        word = word.replaceAll("[^A-Za-z]+", "");  // Remove any non-alphanumeric characters.
        return word;
    }


    public static int findLargest(ArrayList<Integer> arr) { //returns index of the smallest number
    int index = 0; //
    int largest = arr.get(0); //starting with the largest possible number

    for (int i = 0; i < arr.size(); i++) {
      if (arr.get(i) > largest) { //checking it element does not equal -1
        largest = arr.get(i); //updates each time a smaller number is found
        index = i; //records index of smallest number
      }

  }

    return index;
}
}
>>>>>>> 3d6a1363c58fd7e7f2198dc450c5076729cf3fc5
