//shoudl be able to print out all of the words
//the most frequent word printed out 
//'n' most frequent words

import java.util.Scanner;
import java.io.*;
import java.util.*;

public class SetsAndMaps{
    public static void main (String[] commandLineArgs) throws FileNotFoundException{
        //taking in the filename as a command line argument so that we can run any file we want 
        String fileName = commandLineArgs[0];
        //runnning with the filename entered in the command line 
        commonWord(fileName);
    }

//prints out the most commonly used word and all of the words and their counts 
    public static void commonWord (String fileName) throws FileNotFoundException{
        //makes file using the filename entered in command line and run through parameter
        File f = new File (fileName);
        //making scanner to scan through file 
        Scanner fileScan = new Scanner(f);

        //making arraylists to hold the unique words (as strings) and the number of times those unique words are mentioned
        ArrayList<String> uniqueWords = new ArrayList<>();
        ArrayList<Integer> counter = new ArrayList<>();

        //incrementing through each line 
        while(fileScan.hasNextLine()){
            //loding scanner and splitting our current line up into words in an array
            String currLine = fileScan.nextLine();
            //making each line into an array so that we can access individual words and splitting it by spaces
            String [] currLineArr = currLine.split(" ");

            //making all the words in the line cleaned up +similar format
            for (int i=0; i<currLineArr.length; i++){
                //cleaning up the word before we check for frequency
                String cleanWord = cleanUp(currLineArr[i]);
                //replacing old word with cleaned up word
                currLineArr[i] = cleanWord;
            }

            //iterating through the current line array
            for(int i = 0; i < currLineArr.length; i++){
                //if the word hasnt already been counted/ it's the first occurence of the word, add 
                if(uniqueWords.indexOf(currLineArr[i]) == -1){
                    //adding the new word to the list of unique words
                    uniqueWords.add(currLineArr[i]);
                    //adding a counter in the arraylist for the new word and setting it to 0- will be incremented after the for loop
                    counter.add(1);
                }
                else {
                    //incrementing the count if the word already exsits in uniqueWords
                    int indexOfWord = uniqueWords.indexOf(currLineArr[i]);
                    Integer newCount = counter.get(indexOfWord) + 1;
                    counter.set(indexOfWord, newCount);
                }
            }

        }
        fileScan.close(); //closing the scanner

        //makign sure that the msot common word is not a blank (we ran into issues with this)
        int indexOfSpace = uniqueWords.indexOf("");
        uniqueWords.remove(indexOfSpace);
        counter.remove(indexOfSpace);

        //running the functions that print all of the words and their counts adn the functiont hat prints the most common word and its count
        formattedWords(uniqueWords, counter);
        printMostCommonWord(uniqueWords, counter);

    }

//printing out all fo the unique words and the amount of times they appear in the script
    public static void formattedWords(ArrayList<String> uniqueWords, ArrayList<Integer> counter){
        //printing out each word and its count in the parrallel arraylist
        for (int i =0; i<uniqueWords.size();i++){
            System.out.println("Word: " + uniqueWords.get(i) + " Count: " + counter.get(i));
        }
    }

//cleaning up the words (formatting into lowercase and deleting all punctuation)
    public static String cleanUp(String word) {
        word = word.toLowerCase();  // Force word to be in lowercase.
         word = word.replaceAll("[^A-Za-z]+", "");  // Remove any non-alphanumeric characters.
         return word;
    }

//finding the most commonly used word
    public static void printMostCommonWord(ArrayList<String> uniqueWords, ArrayList<Integer> counter){
            //finding the max of the counter arraylist 
            int currMax = 0;
            for (int i=0; i<counter.size();i++){
                if (currMax<counter.get(i)){
                    currMax= counter.get(i);
                }
            }
            //getting teh index of the max of the counter arraylist
            int indexOfCurrMax = counter.indexOf(currMax);
            //using that index to find the assosciated word in the parallel arraylist 
            //printing the result
            System.out.println("The most commonly used word in this file is " + uniqueWords.get(indexOfCurrMax)  + " and it it mentioned " + currMax);
    }
}