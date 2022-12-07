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
        //file name to be imported 
        String filename = args[0];
        //parsing through file
        ArrayList<String> allWords = parseList(filename);
        //make map for file words and counts; (words = keys, counts = values)
        Map<String, Integer> wordCounts = new HashMap<>();
        //al with stopwords to compare to allWords
        ArrayList<String> stopWords = parseList("stopwords.txt");
        //al that will be printed at the end with 25 of the top words in the file
        ArrayList<String> topWords = new ArrayList<>();

        for(int i=0; i<allWords.size(); i++){
            //make current word lowercase in order to match to stopwords
            String currentWord = cleanUp(allWords.get(i));
            if(currentWord.length() > 1){
            //if stopWords does not contain current word then add to wordCounts
                if(stopWords.indexOf(currentWord) == -1){
                        //if wordCounts already contains the word, add 1 to current count - if not make default 0 (+1)
                        wordCounts.put(currentWord, wordCounts.getOrDefault(currentWord, 0)+1);
                }
            }
        }

        //loop to find top word in wordCounts and add to topWord al - then remove word from wordCounts to get next highest
        for(int i=0; i<25; i++){
            //find current topWord
            String currentWord = getWord(wordCounts);
            //add current top word to al
            topWords.add(currentWord);
            //remove top word from al
            wordCounts.remove(currentWord);
        }

        //string of new file name
        String newFileName = "mostUsedWordsInTwlight.txt";

        //printstream to add top words to the new file (named string above)
        PrintStream p = new PrintStream(new FileOutputStream(newFileName, true));
        p.println("The top 25 most used words are: ");
        //loop to rank top 25 most used words in order
        for(int i=0; i<topWords.size(); i++){
            p.println(i+1 + ". " + topWords.get(i));

        }
        //close printstream
        p.close();
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
        String mostCommonWord = "";
        //set of the keys from counts map
        Set<String> keys = counts.keySet();
        //for loop to find the largest word in counts
        for(String key: keys){
            //if current word value is greater than current largestNum (default as 0 until changed)...
            if(counts.get(key) > largestNum){
                //...make that current word value the new largestNum
                largestNum = counts.get(key);
                //...make current word key the to be returned String
                mostCommonWord = key;
            }
        }
        //word to be returned
        // String word = noDuplicates.get(index);
        return mostCommonWord;
    }

    //imported function
    public static String cleanUp(String word) {
    word = word.toLowerCase();  // Force word to be in lowercase.
    word = word.replaceAll("[^A-Za-z]+", "");  // Remove any non-alphanumeric characters.
    return word;
  }
}