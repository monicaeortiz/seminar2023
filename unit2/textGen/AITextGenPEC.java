import java.util.*;
import java.io.*;

public class AITextGenPEC {
    public static void main(String[] commandLineArgs) throws FileNotFoundException{

        File f = commandLineArgs[0];
        Map<String, List<String>> bigrams = parseFile(f);
        Map<String, List<String>> nextFile = parseFile(next);
        generateNewFile(bigrams, 3);

        //generateNewFile(nextFile, 4);


    }

    public static void generateNewFile(Map<String, List<String>> bigrams, int numSentences) throws FileNotFoundException{
        //make an ArrayList that contains the punctuation
        ArrayList<String> punctuation = new ArrayList<>(Arrays.asList("?", ".", "!"));

        //make a prinstream
        String newFileName = "generatedFile.txt";

        //printstream to add words into generated file
        PrintStream p = new PrintStream(new FileOutputStream(newFileName, true));

        for(int i = 0; i<numSentences; i++){
            String firstWord = "";
            String follower = "";
            //check that the current Value does not contain punctuation (the last character in follower is not found in punctuation)
            while(follower.length() == 0 || (punctuation.indexOf(follower.substring(follower.length()-1)) == -1)){
                //if start of sentence...
                if(firstWord == ""){
                    //...choose random bigram from keys in bigrams
                    firstWord = chooseBigramWord(bigrams);
                    if(punctuation.indexOf(firstWord.substring(firstWord.length()-1)) != -1){
                        continue;
                    }
                } else { 
                    //...else set the last value (follower) as the new firstWord
                    firstWord = follower;
                }
                //find the followers of the word and find values (choose a random one) i.e chooseValue
                follower = chooseValue(bigrams, firstWord);
                //add word to printstream file
                p.print(firstWord + " ");
            }
            if(punctuation.indexOf(follower.substring(follower.length()-1)) != -1){
                p.print(follower + " ");
                p.println();
            }
        }
        //close printstream
        p.close();

    }

    public static Map<String, List<String>> parseFile(File f) throws FileNotFoundException{
        //creating the map for our file 
        Map<String, List<String>> bigrams = new HashMap<>();
        String word = "";
        //create new scanner to read in file
        Scanner sc = new Scanner(f);
        //creating a list that will hold the current value (list) for each o the keys 
        List<String> currList = new ArrayList<>();
        while(sc.hasNext()){
            //creating the current word we're on to store as a key
            String currWord= sc.next();
            //gettnig the list that already exists for our key and setting it to currList
            if(bigrams.containsKey(word) == false){
                bigrams.put(word, new ArrayList<String>(Arrays.asList(currWord)));
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

    
    //helper methods
    public static String chooseBigramWord(Map<String, List<String>> bigrams){
        //make key set into arrayList, using the keys as the input into the arrayList
        ArrayList<String> keys = new ArrayList<>(bigrams.keySet());
        //randomly find a key using math.random
        int range = keys.size();
        //return a random one of the keys
        return keys.get((int)(Math.random()*range));
    }

    public static String chooseValue(Map<String, List<String>> bigrams, String word){  
        //get the values
        List<String> values = bigrams.get(word);
        //find the length of the values
        //ramdomly find a value
        int range = values.size();
        return values.get((int)(Math.random()*range));
    }

}