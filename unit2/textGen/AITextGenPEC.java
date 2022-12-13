import java.util.*;
import java.util.io;

public class AITextGenPEC {
    public static void main(String[] args){

    }

    //methods

<<<<<<< HEAD
    public static void generateNewFile(Map<String, List<String>>){
        pass;
=======
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
>>>>>>> f0e3919e9666719661778013e9506a84aa78c54e

    }

    public static Map<String, List<String>> parseFile(File f){
        //creating the map for our file 
        Map<String, List<String>> bigrams = new HashMap<>();
        String word = "";
        //create new scanner to read in file
        Scanner sc = new Scanner(f);
        //creating a list that will hold the current value (list) for each o the keys 
        ArrayList<String> currList = new ArrayList<>();
        while(sc.hasNext()){
            //creating the current word we're on to store as a key
            String currWord= sc.next();
            //gettnig the list that already exists for our key and setting it to currList
            if(bigrams.contains(word) == false){
                bigrams.put(word, currWord);
            } else {
                currList = bigrams.get(word);
                //adding the second word to the list of words (vlue) for the key 
                currList.add(currWord);
                //putting the current word as a key and the updated list as the value
                bigrams.put(word, currList);
            }
            //reassigning word to the next word
            word = currWord;
            
        }
        sc.close(); //closing our scanner
        
        return bigrams; //returning the results of our map 
    }

    
    
    public static String chooseBigramWord(Map<String, List<String>> bigrams){
<<<<<<< HEAD
        Set<String> keys = bigrams.keySet();
        ArrayList<String> keyList = new ArrayList<>(keys);
=======
        //make key set into arrayList, using the keys as the input into the arrayList
        Collection<String> keys = new ArrayList<>(bigrams.keySet());
        //randomly find a key using math.random
        int range = keys.size();
        return keys.get((int)(Math.random()*range+0));
>>>>>>> f0e3919e9666719661778013e9506a84aa78c54e
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