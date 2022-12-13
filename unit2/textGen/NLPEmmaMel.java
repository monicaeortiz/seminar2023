import java.util.*;
import java.io.*;
public class NLPEmmaMel{
    public static void main(String[] args) throws FileNotFoundException{
        File f = new File("practiceFile.txt");
        printNewScript(f, 20);
    }

    public static void printNewScript(File f, int numSentences) throws FileNotFoundException{
        //read in file using a scanner
        Scanner sc = new Scanner(f);
        //create map to keep bigrams
        Map<String, ArrayList<String>> bigrams = new HashMap<>();

        //loop to keep going until there are no more lines in given file
        while(sc.hasNextLine()){
            //use .split to separate each line into an arraylist of words - get rid of spaces
                //keep punctuation on the word
            String[] line = sc.nextLine().split(" ");
            ArrayList<String> lineList = new ArrayList<>(Arrays.asList(line));
            //loop through the length of the line and add words and followers to map
            for(int i=0; i<lineList.size(); i++){
                // get the list of values that are already under bigrams
                ArrayList<String> holderList = new ArrayList<>(); 
                if(bigrams.keySet().contains(lineList.get(i))){
                    holderList = bigrams.get(lineList.get(i));

                }          
                if(i == lineList.size()-1){
                    //how do you add one to arraylist of values in same line?
                    // adding a blank space to the list
                    holderList.add(" ");
                    bigrams.put(lineList.get(i), holderList);
                }
                else{
                    holderList.add(lineList.get(i+1));
                    // updating the map with the bigram
                    bigrams.put(lineList.get(i), holderList);
                }
            }     
        }
        sc.close();
        //create new file with printstream
        PrintStream p = new PrintStream("generatedFile.txt");
        //for loop to randomly pick bigrams from map and runs the numLines, which is amount of lines that are desired in new file
        int amountOfSentences = 0;
        while(amountOfSentences < numSentences){
            String bigram = pickBigram(bigrams);
            //print bigram to new file
            p.print(bigram);
            // if there is a period, question mark, or exclamation point in the bigram, the sentence is over, add one to sentence count
            if(bigram.indexOf(".") != -1 || bigram.indexOf("!") != -1 || bigram.indexOf("?") != -1){
                amountOfSentences++;
            }
        }
        p.close();
    }


    // returns a random bigram so that it can be added to the printstream
    public static String pickBigram(Map<String, ArrayList<String>> bigrams){
        // make a variable to hold the key set of the bigram map
        Set <String> keysOfMap = bigrams.keySet();
        // convert this variable to an array list (so that it has indexes, and random picker can be used), call this variable listOfKeys
        ArrayList <String> listOfKeys = new ArrayList <>(keysOfMap);
        // feed listOfKeys into getRandomElement, save this to a variable chosenKey
        String chosenKey = getRandomElement(listOfKeys);
        // save all of the values associated with chosenKey to another arrayList (can call this listOfValues)
        ArrayList <String> listOfValues = bigrams.get(chosenKey);
        // use getRandomElement to get a random value from listOfValues (can call this chosenValue)
        String chosenValue = getRandomElement(listOfValues);
        // return a string formatted as follows: chosenKey + " " + chosenValue (this is a bigram)
        if(chosenKey.indexOf(".") != -1 || chosenKey.indexOf("!") != -1 || chosenKey.indexOf("?") != -1){
            return chosenKey + " ";
        }
        return chosenKey + " " + chosenValue + " ";
    }

    
    // picks a random element from an array list
    public static String getRandomElement(ArrayList<String> list){
        // use Math.Random to pick a random index (utilize size of list to make sure all elements of list could be chosen)
        int range = list.size();
        int index = (int) (Math.random() * range);
        // return the element held at that random index using .get() method
        return list.get(index);
    }
}