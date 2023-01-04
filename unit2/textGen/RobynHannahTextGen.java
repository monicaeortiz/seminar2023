import java.util.*; 
import java.io.*;

public class RobynHannahTextGen {
    public static void main (String [] args) throws FileNotFoundException{
        File f = new File("smallTest.txt");
        System.out.println(populateMap(f));
        
    }

    public static String sentenceBuilder (Map<String, List> bigrams) {
    //will print output text to prinstream
    //build a string by using getRandomElement 
    //make a printStream to print to a new file 
    //pick a starter word by getting a random follower of empty space
    //take the previous word and get its value list 
    //pick a random value from the array list 
    //repeat for number of 
    return "";
    }

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
                valueList = bigrams.get(word);
                valueList.add(currentKey);
                bigrams.put(word,  valueList);
            
            }
            
            word = currentKey;
        }
        //System.out.println(bigrams);
        //return bigrams; 
        
    
        //for each word the scanner gets, add it to the map as a key unless it already exists getOrDefault and then add the second part of the bigram
        //do next twice 

        //map returned by method to be used in sentenceBuilder and getRandomElement

        /*public static String getRandomElement (List<String> strings) {
        //helper method to be used in sentenceBuilder
        //will choose a random value from a list of values (that corresponds to a key in bigrams) 
        return "";
        }

        //helper method for punctuation 
        public static boolean endsSentence(String word){
        //returns true if the word marks the end of a sentence 
        if(word.substring(word.length() -1).equals(".") || word.substring(word.length() -1).equals("!") || word.substring(word.length()-1).equals("?")){
            return true;
        }
        return false; 
        }*/
        return bigrams;
        }
        
    }


    
    
