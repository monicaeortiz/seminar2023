import java.util.*; 
import java.io.*;

public class RobynHannahTextGen {
    public static void main (String [] args) throws FileNotFoundException{
        File f = new File("smallTest.txt");
        System.out.println(populateMap(f));
        Map<String, List<String>> bigrams = populateMap(f); 
        
        sentenceBuilder(bigrams, 10); //generating 10 sentences of a sample 

    
    }

    //method to print output text to prinstream
    public static void sentenceBuilder (Map<String, List<String>> bigrams, int numSentences) throws FileNotFoundException {
        String sentence = "";
        int sentenceCounter =0;
        String generatedFile = "hdGeneratedFile.txt";//new file to write generated text to
        PrintStream p = new PrintStream(new FileOutputStream(generatedFile, true));
        while(sentenceCounter < numSentences){
            //gets a starter word by getting random word from list of words that follow an empty space 
            String firstWord = getRandomElement(bigrams.get("")); 
            sentence += firstWord + " "; 

            Set<String> keySet = bigrams.keySet(); 
            List<String> keys = new ArrayList<String>(keySet); //list of all keys 
            String nextWord = "";//get followers of first word
            while(endsSentence(nextWord) == false){
                //get random word from the list of followers of firstWord
                nextWord = getRandomElement(bigrams.get(firstWord));
                sentence += nextWord + " ";
                firstWord = nextWord; //make firstWord nextWord so above steps can keep repeating for each new word until it ends a sentence
            }
            sentenceCounter ++;//keeping track of how many sentences have been generated 
        }
        p.print(sentence);
        p.close(); 
    }
    
    //method to fill bigram map from input file
    public static Map<String, List<String>> populateMap (File f) throws FileNotFoundException{
        
        Map<String, List<String>> bigrams = new HashMap<>(); 
        String word = "";
        Scanner scanner = new Scanner(f); 
        List<String> valueList = new ArrayList<>();
        while(scanner.hasNext()){
            //getting each token in the file 
            String currentKey = scanner.next();
            // check if currentKey is in dictionary 
            if(bigrams.containsKey(word) == false){//if key is not already in the list
                bigrams.put(word,  new ArrayList<String>(Arrays.asList(currentKey)));// you need to make a new arrayList since this is the first time the key is appearing
            }

            else{//if key is already in the list 
                //change the list first, then add the new list as the value
                valueList = bigrams.get(word);
                valueList.add(currentKey);
                bigrams.put(word,  valueList);
            }

            if (endsSentence(currentKey) ) {
                word = ""; //this makes sure that all first words of a sentence will follow the empty space key in the map
            }
            else {
                word = currentKey;
            }
        }
        scanner.close();
        return bigrams;
    }

    //helper method for punctuation
    public static boolean endsSentence(String word) {
        //checks if a word has sentence ending punctuation, and returns true or false
        if(word.indexOf(".") == -1 && word.indexOf("!") == -1 && word.indexOf("?") == -1) {//if the word does not have punctuation
            return false;
        } 
        return true;
    }

    //helper method to get a random string from a list (to be used in sentenceBuilder) 
    public static String getRandomElement (List<String> strings) {
        return strings.get((int)(Math.random()*(strings.size()))); 
    }
}
