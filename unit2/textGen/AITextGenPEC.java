import java.util.*;
import java.util.io;

public class AITextGenPEC {
    public static void main(String[] args){

    }

    //methods

    public static void generateNewFile(Map<String, List<String>> bigrams, int numSentences){
        //make an ArrayList that contains the punctuation
        ArrayList<String> punctation = new ArrayList<>(Arrays.asList("?", ".", "!"));

        //make a prinstream
        
        String firstWord = "";
        String follower = "";
        for(int i = 0; i<numSentences; i++){
            //check that the current Value does not contain punctuation (the last character in follower is not found in punctuation)
            while(punctuation.indexOf(follower.charAt(follower.length-1)) == -1){
                //first, find randomly generated word which is the key i.e chooseBigramWord 
                firstWord = chooseBigramWord(bigrams);
                //find the followers of the word and find values (choose a random one) i.e chooseValue
                
                //update the value of word
            }
        }

    }

    public static Map<String, List<String>> parseFile(File f){
        Map<String, String> bigrams = new HashMap<>();
    }
    
    public static String chooseBigramWord(Map<String, List<String>> bigrams){
        //make key set into arrayList, using the keys as the input into the arrayList
        Collection<String> keys = new ArrayList<>(bigrams.keySet());
        //randomly find a key using math.random
        int range = keys.size();
        return keys.get((int)(Math.random()*range+0));
    }

    public static String chooseValue(Map<String, List<String>> bigrams, String word){  
        //get the values
        Collection<String> values = bigrams.get(word);
        //find the length of the values

        //ramdomly find a value
        int range = values.size();
        return values.get((int)(Math.random()*range+0));
    }

    //extra helper methods
    public static String findPunctuation(Map<String, String> bigrams){
        pass;
    }

    
    
}