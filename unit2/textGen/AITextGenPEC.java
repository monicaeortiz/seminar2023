import java.util.*;
import java.io.*;

public class AITextGenPEC {
    public static void main(String[] args) throws FileNotFoundException{
        //testing helper methods
        Map<String, List<String>> testMap = new HashMap<>();
        List<String> testValues1 = new ArrayList<>(Arrays.asList("bye", "my", "name."));
        List<String> testValues2 = new ArrayList<>(Arrays.asList("road", "lane", "lane."));
        List<String> testValues3 = new ArrayList<>(Arrays.asList("love", "love", "thanks."));
        testMap.put("", testValues1);
        testMap.put("hey", testValues2);
        testMap.put("hi", testValues3);
        String key = chooseBigramWord(testMap);
        System.out.println(key);
        System.out.println(chooseValue(testMap, key));

        generateNewFile(testMap, 2);


    }

    public static void generateNewFile(Map<String, List<String>> bigrams, int numSentences) throws FileNotFoundException{
        //make an ArrayList that contains the punctuation
        ArrayList<String> punctuation = new ArrayList<>(Arrays.asList("?", ".", "!"));

        //make a prinstream
        String newFileName = "generatedFile.txt";

        //printstream to add words into generated file
        PrintStream p = new PrintStream(new FileOutputStream(newFileName, true));
        
        String firstWord = "";
        String follower = "";
        for(int i = 0; i<numSentences; i++){
            System.out.println("test1");
            //check that the current Value does not contain punctuation (the last character in follower is not found in punctuation)
            while(follower.length() == 0 || (punctuation.indexOf(follower.charAt(follower.length()-1)) == -1)){
                System.out.println("test2");
                //if start of sentence...
                if(firstWord == ""){
                    //...choose random bigram from keys in bigrams
                    firstWord = chooseBigramWord(bigrams);
                } else { 
                    //...else set the last value (follower) as the new firstWord
                    firstWord = follower;
                }
                //find the followers of the word and find values (choose a random one) i.e chooseValue
                follower = chooseValue(bigrams, firstWord);
                //add word to printstream file
                p.print(firstWord);
                //update the value of word
            }
        }
        //close printstream
        p.close();

    }

    // public static Map<String, List<String>> parseFile(File f) throws FileNotFoundException{
    //     //creating the map for our file 
    //     Map<String, List<String>> bigrams = new HashMap<>();
    //     String word = "";
    //     //create new scanner to read in file
    //     Scanner sc = new Scanner(f);
    //     //creating a list that will hold the current value (list) for each o the keys 
    //     ArrayList<String> currList = new ArrayList<>();
    //     while(sc.hasNext()){
    //         //creating the current word we're on to store as a key
    //         String currWord= sc.next();
    //         //gettnig the list that already exists for our key and setting it to currList
    //         if(bigrams.contains(word) == false){
    //             bigrams.put(word, currWord);
    //         } else {
    //             currList = bigrams.get(word);
    //             //adding the second word to the list of words (vlue) for the key 
    //             currList.add(currWord);
    //             //putting the current word as a key and the updated list as the value
    //             bigrams.put(word, currList);
    //         }
    //         //reassigning word to the next word
    //         word = currWord;
            
    //     }
    //     sc.close(); //closing our scanner
        
    //     return bigrams; //returning the results of our map 
    // }

    
    
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