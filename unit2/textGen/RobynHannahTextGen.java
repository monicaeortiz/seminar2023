import java.util.*; 
import java.io.*;

public class RobynHannahTextGen {
    public static void main (String [] args) throws FileNotFoundException{
        File f = new File("smallTest.txt");
        System.out.println(populateMap(f));
        Map<String, List<String>> bigrams = populateMap(f); 
        
        sentenceBuilder(bigrams, "smallTest.txt", 10); 

    
    }

    //method to print output text to prinstream
    public static void sentenceBuilder (Map<String, List<String>> bigrams, String fileName, int numSentences) throws FileNotFoundException {
        String sentence = "";
        int sentenceCounter =0;
        String generatedFile = "hdGeneratedFile.txt";
        PrintStream p = new PrintStream(new FileOutputStream(generatedFile, true));
        while(sentenceCounter < numSentences){
            //gets a starter word by getting random word from list of words that follow an empty space 
            String firstWord = getRandomElement(bigrams.get("")); 
            sentence += firstWord + " "; 
            //above does the first word of every sentence

            Set<String> keySet = bigrams.keySet(); 
            List<String> keys = new ArrayList<String>(keySet); //list of all keys 
            String nextWord = "";//get followers of first word
            while(endsSentence(nextWord) == false){
                //get random word from the list of followers of firstWord
                nextWord = getRandomElement(bigrams.get(firstWord));
                sentence += nextWord + " ";
                firstWord = nextWord; 
                //above steps need to repeat until nextWord has punctuation
            }
            /*while (!endsSentence(firstWord)) {
            String nextWord = getRandomElement(bigrams.get(firstWord)); 
            sentence += nextWord + " "; 
            nextWord = getRandomElement(bigrams.get(nextWord));
            }*/
            sentenceCounter ++;
            
            
        }
        p.print(sentence);
        //get a random value from the list of "" to be the first word of the sentence. add to string
        //nextWord = bigrams.get(firstWord) -- gets value list of previos word
        //now get a random value from nextWord's value list and add to string. 
        p.close();
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
            //don't call next twice 
            String currentKey = scanner.next();
            // check if current Key is in dictionary 
            if(bigrams.containsKey(word) == false){//if key is not already in the list
                bigrams.put(word,  new ArrayList<String>(Arrays.asList(currentKey)));
            }

            else{//if key is in the list 
            //change the list first, then add the new list as the value
                //change the list first, then add the new list as the value
                valueList = bigrams.get(word);
                valueList.add(currentKey);
                bigrams.put(word,  valueList);

            }

            if (endsSentence(currentKey) ) {
                word = ""; 
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
        //System.out.println(bigrams);
        //return bigrams; 
        return true;
    }

    //helper method to get a random string from a list (to be used in sentenceBuilder) 
    public static String getRandomElement (List<String> strings) {
        return strings.get((int)(Math.random()*(strings.size()))); 
    }
}
