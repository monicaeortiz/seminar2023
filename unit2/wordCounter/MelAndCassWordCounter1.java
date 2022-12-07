//shoudl be able to print out all of the words
//the most frequent word printed out 
//'n' most frequent words

import java.util.Scanner;
import java.io.*;
import java.util.*;

public class MelAndCassWordCounter1{
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

        Map<String,Integer> frequencyMap = new HashMap<>();


        //creating a list of the stop words read in from the stopwords.txt file 
        File stopWordsFile = new File("../stopwords.txt");
        Scanner stopWordsScanner = new Scanner(stopWordsFile);
        List<String> stopWordsList = new ArrayList<>();
        while (stopWordsScanner.hasNext()){
            stopWordsList.add(stopWordsScanner.nextLine());
        }

        //incrementing through each line 
        while(fileScan.hasNextLine()){
            //loading scanner and splitting our current line up into words in an array
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
                //if the key I'm trying to put onto my map (word) is in stopwords.txt list then dont add it else add
                if (stopWordsList.indexOf(currLineArr[i])==-1){
                    frequencyMap.put(currLineArr[i], frequencyMap.getOrDefault(currLineArr[i], 0) +1);
                }
            }

        }
        fileScan.close(); //closing the scanner

        //makign sure that the msot common word is not a blank (we ran into issues with this)
        frequencyMap.remove("");
        frequencyMap.remove(" ");

        //running the functions that print all of the words and their counts adn the functiont hat prints the most common word and its count
        //printing all of the keys and values assosciated in the map
        System.out.println(frequencyMap);
        //formattedWords(frequencyMap);
        // printing the top 25 most common words to a new file 
        writeInTop25(frequencyMap);

    }

//printing out all fo the unique words and the amount of times they appear in the script
    public static void formattedWords(Map<String, Integer> frequencyMap){
        //printing out each word and its count from the frequencyMap
        Set<String> keyList = frequencyMap.keySet();
        for (String key : keyList){
            System.out.println("Word: " + key + " Count: " + frequencyMap.get(key));
        }
    }

//cleaning up the words (formatting into lowercase and deleting all punctuation)
    public static String cleanUp(String word) {
        word = word.toLowerCase();  // Force word to be in lowercase.
         word = word.replaceAll("[^A-Za-z]+", "");  // Remove any non-alphanumeric characters.
         return word;
    }

//finding the most commonly used word
    public static void writeInTop25(Map<String, Integer> frequencyMap)throws FileNotFoundException{
        // creating a file that can be written to and will contain the list of the most frequently used 25 words
        PrintStream listOfTop25Words = new PrintStream("top25WordsList.txt");
        // Creating an arraylist of words that have already been used so they cannot be used again
        ArrayList <String> wordsAlreadyUsed = new ArrayList <> ();
        // creaitng a list of the key sin frequency map so it can be iterated through
        Collection <String> keysOfFrequencyMap = frequencyMap.keySet();
        // repeating these steps 25 times since we want the 25 most commonly used words
        for (int i = 0; i < 25; i++){
            int currMax = 0;
            String currMaxWord = "";
            for (String key : keysOfFrequencyMap){
                // only execute the following statements if the word hasn't already been written into the file
                if(wordsAlreadyUsed.indexOf(key) ==  -1 ){
                // if the current key was mentioned more times than current max word, it becomes the new current max word and currMax should be updated with its value
                    if(frequencyMap.get(key) > currMax){
                        currMax = frequencyMap.get(key);
                        currMaxWord = key;
                    }
                }
            }
                // adding the word to the words already used file so that the frequency map is not altered and the word is also not written to the file multiple times
                wordsAlreadyUsed.add(currMaxWord);
                listOfTop25Words.println(i + 1 + ". " + currMaxWord);
        }
    }
}