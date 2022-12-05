import java.util.*;
import java.io.*;
public class WordCounterEE{
//have an arraylist that holds everyword in the script
//go through each line and then each word within the lines
//use scanners
//then w each word, add to existing arraylist if not already there
    //if AL.indexOf(i) = -1
//have a parallel array that has the counts of each word (same length as noDuplicates array)


//need AL with all words in entire script (w/ duplicates)
//need AL with all words (w/out duplicates)
//AL parallel to noDuplicates AL with count of how many times each word was said
//return index of largest value in count; overall return word at that index

    public static void main(String[] args) throws FileNotFoundException{
        String filename = args[0];
        ArrayList<String> allWords = parseList(filename);
        Map<String, Integer> wordCounts = new HashMap<>();
        Set<String> keys = new HashSet<>(Arrays.asList(allWords));
        for(String key: keys){
            wordCounts.put(key, wordCounts.getOrDefault(key, 0)+1);
        }
        
        System.out.println("The most used word in Twilight is: " + getWord(wordCounts));
    }

    public static ArrayList<String> parseList(String pathname) throws FileNotFoundException{
        //create new scanner to read in file
        Scanner sc = new Scanner(new File(pathname));
        //initalize empty arraylist to hold all the worlds in the file
        ArrayList<String> words = new ArrayList<>();
        //loop that will run until there are no more lines left in the file
        while(sc.hasNextLine()){
            //create a variable to hold the specific line
            String line = sc.nextLine();
            //create an array with every individual word in the line 
            String[] arrLine = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
            //create arraylist of array of line
            ArrayList<String> alOfLine = new ArrayList<>(Arrays.asList(arrLine));
            //individual scanner to read in a string of each line
            Scanner scn = new Scanner(line);
            //while there is another word in the line, add the word to the broad words arraylist
            while(scn.hasNext()){
                words.add(scn.next());
            }
            scn.close();
        }
        sc.close();
        return words;
    }

    //method to go through values in counts AL, get the index, and return the value at that index in noDuplicates AL (the most common word)
    public static String getWord(Map<String, Integer> counts){
        //comparison variable
        int largestNum = 0;
        //index that will be used to get returned word
        int place = 0;
        Set<String> key = counts.keySet();
        for(String key: keys){
            if(counts.get(key) > largestNum){
                largentNum = counts.get(key);
                place = key;
            }
        }
        //word to be returned
        // String word = noDuplicates.get(index);
        return place;
    }
}