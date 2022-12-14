import java.util.*;
import java.io.*;
public class TaraKathrynAIRobot {

    public static void main (String[] args) throws FileNotFoundException, NumberFormatException {

        writeNewFile(scanFile(new File (args[0])), Integer.parseInt(args[1]), args[2]);
    }

//if the first word has punctiation, make the second word an empty string, and get a value from the empty string key
     public static Map<String, ArrayList<String>> scanFile (File textFile) throws FileNotFoundException {
        Map <String, ArrayList<String>> bigrams = new HashMap<>();//empty map, will be filled with bigrams
        ArrayList<String> starterWords = new ArrayList<String>();
        bigrams.put("", starterWords);
        Scanner fileScan = new Scanner(textFile);
        String firstWord = "";
        while(fileScan.hasNext()) { //keep getting strings from file one at a time
        String secondWord = fileScan.next(); //get the String in the file

            if (hasPunctiation(firstWord)){

                starterWords.add(secondWord);

                bigrams.put("", starterWords);

            }


            else if (!bigrams.containsKey(firstWord)) { //if firstWord does not exist, add firstWord as a key to the map
                ArrayList <String> values = new ArrayList <String> ();
                values.add(secondWord);
                bigrams.put(firstWord, values); //add secondWord to the value of firstWord
            }


            else {  // if firstWord already exists as a key in the map, get the current value and push the second word to the array list
                (bigrams.get(firstWord)).add(secondWord);
                //temp.add(secondWord);
            }

            firstWord = secondWord;//change firstWord to SecondWord
        }
        fileScan.close();
        return bigrams;
    }



     

    /*psuedocode

    1. pass in how many words we want the new file to be
    2. Start with an empty string and get bigrams of the empty string, as those words are likely to be sentence starters. 
    3. keep on getting the bigram of the word before, until we reach a word with punctuation at the end.
        increase the number of sentences by q
        and make the curWord an empty string, so we get a sentence starter word

    */



    public static void writeNewFile(Map <String, ArrayList<String>> bigrams, int numSentences, String fileName) throws FileNotFoundException{

        ArrayList<String> sentenceEnder = new ArrayList<>(Arrays.asList(".", "?", "!"));

        PrintStream p = new PrintStream(fileName);

        String newText = "";
        String curWord = "";
        String newWord = "";

        int curNumSentences = 0;

        while (curNumSentences < numSentences){

            newWord = pickBigram(bigrams, curWord);
            newText += newWord + " ";
            curWord = newWord;

                 if (hasPunctiation(curWord)){
                    curWord = "";
                    curNumSentences ++;
                 }

        }

        p.print(newText);

    }



/*pseudocode, lerning my lesson slowly but surely

1. use .get to get the arraylist(value) of a specific String (key)
2. Use Math.random to randomely generate a number (withing the indeices of the arrayList). 
Elements that appear more often in the arraylist will be more likely to show up
*/

    public static boolean hasPunctiation(String word){

         ArrayList<String> sentenceEnder = new ArrayList<>(Arrays.asList(".", "?", "!"));

          for (int i = 0; i < 3; i ++){
                 if (word.indexOf(sentenceEnder.get(i)) != -1){
                    return true;
                 }

          }

        return false;
    }

    public static String pickBigram(Map <String, ArrayList <String>> bigrams, String key) {

        return (bigrams.get(key)).get((int) (Math.random() * (bigrams.get(key).size())));//get the arraylist associated with the key and generate a random number that returns a random index of that arraylist

    }


}


