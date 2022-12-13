import java.util.*;

public class AITextGenPEC {
    public static void main(String[] args){
        //testing helper methods
        Map<String, List<String>> testMap = new HashMap<>();
        List<String> testValues1 = new ArrayList<>(Arrays.asList("bye", "my", "name"));
        List<String> testValues2 = new ArrayList<>(Arrays.asList("road", "street", "lane"));
        List<String> testValues3 = new ArrayList<>(Arrays.asList("love", "you", "thanks"));
        testMap.put("hello", testValues1);
        testMap.put("hey", testValues2);
        testMap.put("my", testValues3);
        String key = chooseBigramWord(testMap);
        System.out.println(key);
        System.out.println(chooseValue(testMap, key));


    }

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