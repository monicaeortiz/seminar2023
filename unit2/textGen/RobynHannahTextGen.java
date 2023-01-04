import java.util.*; 
import java.io.*;

public class RobynHannahTextGen {
    public static void main (String [] args) throws FileNotFoundException{
        File f = new File("smallTest.txt");
        System.out.println(populateMap(f));
        Map<String, List<String>> bigrams = populateMap(f); 
        
        sentenceBuilder(bigrams, "textGenTestOutput.txt"); 

    
    }

    //method to print output text to prinstream
    public static void sentenceBuilder (Map<String, List<String>> bigrams, String fileName) throws FileNotFoundException {
        String sentence = "";
        
        //gets a starter word by getting random word from list of words that follow an empty space 
        String word = getRandomElement(bigrams.get("")); 
        sentence += word + " "; 

        Set<String> keySet = bigrams.keySet(); 
        List<String> keys = new ArrayList<String>(keySet); //list of all keys 

        while (!endsSentence(word)) {
            word = getRandomElement(bigrams.get(word)); 
            sentence += word + " "; 
        }

        System.out.println(sentence); 
        
        // PrintStream p = new PrintStream(fileName);
        // p.print(sentence);
      
        //build a string by using getRandomElement 
        //make a printStream to print to a new file 
        //pick a starter word by getting a random follower of empty space
        //take the previous word and get its value list 
        //pick a random value from the array list 
        //repeat for number of 
    }
    
    //method to fill bigram map from input file
    public static Map<String, List<String>> populateMap (File f) throws FileNotFoundException{
        //will take input text and create bigrams map 
        Map<String, List<String>> bigrams = new HashMap<>(); 
        //make a new map
        //make scanners to read file and lines
        //make var called first word andmake empty string 
        //in the loop, put key and then values
        String word = "";
        Scanner scanner = new Scanner(f); 
        List<String> valueList = new ArrayList<>();
        while(scanner.hasNext()){
            //dont' call next twice 
            String currentKey = scanner.next();

            // check if current Key is in dictionary 
            if(bigrams.containsKey(word) == false){//if key is not already in the list


                bigrams.put(word,  new ArrayList<String>(Arrays.asList(currentKey)));
            }
                //bigrams.get(currentKey)

            else{//if key is in the list 
            //change the list first, then add the new list as the value
                //change the list first, then add the new list as the value
                valueList = bigrams.get(word);
                valueList.add(currentKey);
                bigrams.put(word,  valueList);

            }

            word = currentKey;
        }
        return bigrams;
    }

    //helper method for punctuation
    public static boolean endsSentence(String word) {
        //checks if a word has sentence ending punctuation, and returns true or false
        if(word.indexOf(".") == -1 && word.indexOf("!") == -1 && word.indexOf("?") == -1) {//if the word does not have punctuation
            return false;
        }
        //System.out.println(bigrams);
        //return bigrams; 
        return true;
    }

    //helper method to get a random string from a list (to be used in sentenceBuilder) 
    public static String getRandomElement (List<String> strings) {
        return strings.get((int)(Math.random()*(strings.size()))); 
    }
}
