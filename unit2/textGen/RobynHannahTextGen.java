import java.util.*; 
import java.io.*;

public class RobynHannahTextGen {
    public static void main (String [] args) throws FileNotFoundException{
        File f = new File("smallTest.txt");
        populateMap(f);
        
    }

    public static String sentenceBuilder (Map<String, List> bigrams) {
    //will print output text to prinstream
    //build a string by using getRandomElement 
    return "";
    }

    public static Map<String, List> populateMap (File f) throws FileNotFoundException{
        //will take input text and create bigrams map 
        Map<String, List> bigrams = new HashMap<>(); 
        //make a new map

        //make scanners to read file and lines
        //make var called first word andmake empty string 
        //in the loop, put key and then values
        String firstWord = "";
        Scanner scanner = new Scanner(f); 
        while(scanner.hasNext()){
            //dont' call next twice 
            String currentKey = firstWord;
            String currentValue = scanner.next();
            // check if current Key is in dictionary 
            if(bigrams.containsKey(currentKey)){
                bigrams.put(currentKey, (bigrams.get(currentKey)).add(currentValue));
            }
                //if it is, currentKey.get.add(currentValue)

            else{
                bigrams.put(currentKey,  new ArrayList<String>(Arrays.asList(currentValue)));
            
            //else, add currentKey as key and make a new arrya list and put in value 

            /*System.out.println("current key is: " + currentKey + " and current value is: " + currentValue);
            System.out.println((bigrams.get(currentKey)).length());
            bigrams.put(currentKey, bigrams.getOrDefault(currentKey, (bigrams.get(currentKey)).add(currentValue)));*/
            //update first word to value that was just added to old key 
        }
            firstWord = currentValue;
        }
        System.out.println(bigrams);
        return bigrams; 
        
    
        //for each word the scanner gets, add it to the map as a key unless it already exists getOrDefault and then add the second part of the bigram
        //do next twice 

        //map returned by method to be used in sentenceBuilder and getRandomElement

    public static String getRandomElement (List<String> strings) {
        return strings.get((int)* Math.random()*(strings.length)); 
        //helper method to be used in sentenceBuilder
        //will choose a random value from a list of values (that corresponds to a key in bigrams) 
        return "";
    }


    /*//helper method for punctuation 
    public static boolean endsSentence(String word){
        //returns true if the word marks the end of a sentence 
        if(word.substring(word.length() -1).equals(".") || word.substring(word.length() -1).equals("!") || word.substring(word.length()-1).equals("?")){
            return true;
        }
        return false; 
    }*/
}
}

    
    