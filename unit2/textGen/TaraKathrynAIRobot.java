import java.util.*;
import java.io.*;
public class TaraKathrynAIRobot {

    // MAIN METHOD
    public static void main (String[] args) throws FileNotFoundException, NumberFormatException {
        // calls the writeNewFile method, takes in command line arg for file input, num sentences that the user wants to generate, and name of the new file they want to add the new text to
        writeNewFile(scanFile(new File (args[0])), Integer.parseInt(args[1]), args[2]);
    }

    //if the first word has punctiation, make the second word an empty string, and get a value from the empty string key
   // creates a map with all the unique words in the file as keys and their following words as a list of values
    public static Map<String, ArrayList<String>> scanFile (File textFile) throws FileNotFoundException {
        Map <String, ArrayList<String>> bigrams = new HashMap<>(); // empty map, will be filled with bigrams
        ArrayList<String> starterWords = new ArrayList<String>(); // empty arraylist for all the values that start a sentence
        bigrams.put("", starterWords); // puts the arraylist for starter words as a value for the space
        Scanner fileScan = new Scanner(textFile);
        String firstWord = "";
        while(fileScan.hasNext()) { // keep getting strings from file one at a time
            String secondWord = fileScan.next(); // get the string in the file

            if (hasPunctiation(firstWord)) { // calls the hasPunctuation method to check if the current word could be a word that ends the sentence
                starterWords.add(secondWord); // if so, the next word would start a new sentence and thus is added to the list of starter words
                bigrams.put("", starterWords); // the updated list with starter words is added to the map
            }
            else if (!bigrams.containsKey(firstWord)) { // if firstWord does not exist, add firstWord as a key to the map
                ArrayList <String> values = new ArrayList <String> (); // creates a list for the values of this unique word
                values.add(secondWord); // adds the following word to the list
                bigrams.put(firstWord, values); // add secondWord to the value of firstWord
            } else {  // if firstWord already exists as a key in the map, get the current value and push the second word to the array list
                (bigrams.get(firstWord)).add(secondWord);
            }
            firstWord = secondWord;//change firstWord to SecondWord
        }
        fileScan.close();
        return bigrams;
    }

    // writes new text into a new file; generates num sentences that the user desires
    public static void writeNewFile (Map <String, ArrayList<String>> bigrams, int numSentences, String fileName) throws FileNotFoundException{
        ArrayList<String> sentenceEnder = new ArrayList<>(Arrays.asList(".", "?", "!")); // creates a list of possible characters that may end a sentence
        PrintStream p = new PrintStream(fileName);

        String newText = ""; 
        String curWord = "";
        String newWord = "";
        int curNumSentences = 0; 

        while (curNumSentences < numSentences) { // runs until reached user-inputted desired num of sentences
            newWord = pickBigram(bigrams, curWord); // calls the pickBigram method to pick a random word from the list that is assigned to the current word and assigns it to newWord
            newText += newWord + " "; // adds the new word to the text string and a space
            curWord = newWord; // assigns the new word to current word
            if (hasPunctiation(curWord)) { // checks if the curren word has punctuation
                curWord = ""; // if so, assigns current word to a space so that the next word can start a new sentence
                newText += "\n"; // makes new line for the next sentence in the file so that each sentence is its own line
                curNumSentences ++; // increments the num of sentences that have been generated
            }

        }
        p.print(newText);
    }


    // checks if the current word has punctuation attached to it (does it end a sentence) and returns a boolean
    public static boolean hasPunctiation (String word) {
        ArrayList<String> sentenceEnder = new ArrayList<>(Arrays.asList(".", "?", "!")); // creates a list of possible characters that may end a sentence
            for (int i = 0; i < 3; i ++) { // iterates through the list
                if (word.indexOf(sentenceEnder.get(i)) != -1){ // checks if the word has any of the 3 possible sentence ender punctuation
                    return true;
                }

            }
        return false;
    }



    // for each word, picks a random value from the list assigned to the key word and returns it
    public static String pickBigram (Map <String, ArrayList <String>> bigrams, String key) {
        return (bigrams.get(key)).get((int) (Math.random() * (bigrams.get(key).size())));// get the list associated with the key and generate a random number that returns a random index of that arraylist
    }


}


