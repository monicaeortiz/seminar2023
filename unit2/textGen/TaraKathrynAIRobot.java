import java.util.*;
import java.io.*;
public class TaraKathrynAIRobot {

    public static void main (String[] args) throws FileNotFoundException {

        File test = new File("AITest.txt");
    
        ArrayList<String> words = new ArrayList<String>(Arrays.asList("a", "b", "c", "d", "e"));

        Map<String, ArrayList<String>> salaries = new HashMap<>();//can't have just Map on left side bc Map is an interface, HashMap implements a map interface
        salaries.put("Ms. Z", words);//keys must be unique
        salaries.put("Mr. A", words);
        salaries.put("Ms. Sandes", words);
        salaries.put("Person", words);
        salaries.put("Ross", words);
        salaries.put("Janice", words);
        salaries.put("Chandler", words);
        salaries.put("Chandler", words);//will UPDATE the value at Chandler

        //System.out.println(pickBigram(salaries, "Person"));
        //System.out.println(pickBigram(salaries, "Janice"));

        System.out.println(scanFile(test));
       

    }


     public static Map<String, ArrayList<String>> scanFile (File textFile) throws FileNotFoundException {
        Map <String, ArrayList<String>> bigrams = new HashMap<>();//empty map, will be filled with bigrams
        Scanner fileScan = new Scanner(textFile);
        String firstWord = "";
        while(fileScan.hasNext()) { //keep getting strings from file one at a time
            String secondWord = fileScan.next(); //get the String in the file
            if (!bigrams.containsKey(firstWord)) { //if firstWord does not exist, add firstWord as a key to the map
                ArrayList <String> values = new ArrayList <String> (); // makes array list for the values
                values.add(secondWord); // adds secondWord to the arraylist
                bigrams.put(firstWord, values); //add the new arraylist to the value of firstWord
            }
            else {  // if firstWord already exists as a key in the map, get the current value and push the second word to the array list
                ArrayList temp = bigrams.get(firstWord);
                temp.add(secondWord);
            }
            firstWord = secondWord; //change firstWord to SecondWord
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



    /*public static void writeNewFile(Map <String, ArrayList<String>> bigrams int numSentences, String fileName) {

        ArrayList<String> sentenceEnder = new ArrayList<>(Arrays.asList(".", "?", "!"));

        PrintStream p = new PrintStream(fileName);

        String newText = "";
        String curWord = "";
        String newWord = "";

        int curNumSentences = 0;

        while (curNumSentences <= numSentences){

            newWord = pickBigram(bigrams, curWord);
            newText += newWord;
            curWord = newWord;

            for (int i = 0; i < 3; i ++){
                 if (curWord.indexOf(sentenceEnder.get(i)) != -1){
                    curWord = "";
                    curNumSentences ++;
                 }

            }
        }

        p.print(newText);

    }



/*pseudocode, lerning my lesson slowly but surely

1. use .get to get the arraylist(value) of a specific String (key)
2. Use Math.random to randomely generate a number (withing the indeices of the arrayList). 
Elements that appear more often in the arraylist will be more likely to show up

*/

    public static String pickBigram(Map <String, ArrayList <String>> bigrams, String key) {

        return (bigrams.get(key)).get((int) (Math.random() * (bigrams.get(key).size() + 1)));//get the arraylist associated with the key and generate a random number that returns a random index of that arraylist
        // if it has punctuation, get word from the empty string key
    }


    // public static String checkPunctuation(Map <String, ArrayList <String>> bigrams) {



    // }


/* do while loop

get the first word in the file
add it to the map



next loop
add a value to the previous string, which is the current word




*/


}


