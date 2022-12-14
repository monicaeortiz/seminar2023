import java.util.*;
import java.io.*;
public class NLPEmmaMel{
    public static void main(String[] args) throws FileNotFoundException{
        File f = new File("../textInputFiles/twilight.txt");
        printNewScript(f, 5);
    }

    public static void printNewScript(File f, int numSentences) throws FileNotFoundException{
        //read in file using a scanner
        Scanner sc = new Scanner(f);
        //create map to keep bigrams
        Map <String, ArrayList<String>> bigrams = new HashMap<>();

        //loop to keep going until there are no more lines in given file
        while(sc.hasNextLine()){
            //use .split to separate each line into an arraylist of words - get rid of spaces
                //keep punctuation on the word
            String[] line = sc.nextLine().split(" ");
            ArrayList<String> lineList = new ArrayList<>();
            lineList.add(" ");
            lineList.addAll(Arrays.asList(line));

            //loop through the length of the line and add words and followers to map
            for(int i=0; i<lineList.size(); i++){
                if(lineList.get(i).length() > 0){
                    // get the list of values that are already under bigrams
                    ArrayList<String> holderList = new ArrayList<>(); 
                    if(bigrams.keySet().contains(lineList.get(i))){
                        holderList = bigrams.get(lineList.get(i));

                    }          
                    if(i == lineList.size()-1){
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
        }
        sc.close();
        //create new file with printstream
        PrintStream p = new PrintStream("generatedFile.txt");
        //for loop to randomly pick bigrams from map and runs the numLines, which is amount of lines that are desired in new file
        int amountOfSentences = 0;
        //create boolean flag to determine if first word is start of new sentence
        boolean flag = true;
        while(amountOfSentences < numSentences){
            //orginal string of bigram - flag starts as true because first bigram should be the start of a sentence
            String bigram = pickBigram(bigrams, flag);
            p.print(bigram);
            // if there is a period, question mark, or exclamation point in the bigram, the sentence is over, add one to sentence count and make flag true to start a new sentence with the bigram
            if(bigram.indexOf(".") != -1 || bigram.indexOf("!") != -1 || bigram.indexOf("?") != -1){
                amountOfSentences++;
                flag = true;
            //if not the end of a sentence, make flag false to show you don't need a word that is a sentence starter
            } else {
                flag = false;
            }
        }
        p.close();
    }


    // returns a random bigram so that it can be added to the printstream
    public static String pickBigram(Map<String, ArrayList<String>> bigrams, boolean firstWord){
        // make a variable to hold the key set of the bigram map
        Set <String> keysOfMap = bigrams.keySet();
        // convert this variable to an array list (so that it has indexes, and random picker can be used), call this variable listOfKeys
        ArrayList <String> listOfKeys = new ArrayList <>(keysOfMap);
        //initalize chosen key as empty - which it will be if firstWord is true
        String chosenKey = "";
        // if it is the first word in a sentence, we want it to be one of the capital-lettered keys, we can ensure this using ASCII
        int numericalValueOfFirstLetterInWord = 0;
        if (firstWord){
            // if numericalValueOfFirstLetterInWord is greater than 90, it is a lowercase letter, 
            numericalValueOfFirstLetterInWord = 91;
            while(numericalValueOfFirstLetterInWord > 90 && !chosenKey.equals(" ")){
                chosenKey = getRandomElement(listOfKeys);
                numericalValueOfFirstLetterInWord = chosenKey.charAt(0);
            }
        }
        else{
            // if it is not the first word of a sentence, we want to ensure it is lower case
            while(numericalValueOfFirstLetterInWord < 97 && !chosenKey.equals(" ")){
                chosenKey = getRandomElement(listOfKeys);
                numericalValueOfFirstLetterInWord = chosenKey.charAt(0);
            }
        }
        // save all of the values associated with chosenKey to another arrayList (can call this listOfValues)
        ArrayList <String> listOfValues = bigrams.get(chosenKey);
        // use getRandomElement to get a random value from listOfValues (can call this chosenValue)
        String chosenValue = getRandomElement(listOfValues);
        // if chosen key ends a sentence - do not print a value (it will be a space)
        if(chosenKey.indexOf(".") != -1 || chosenKey.indexOf("!") != -1 || chosenKey.indexOf("?") != -1){
            return chosenKey + " " + chosenValue + " ";
        //if chosen key is a space - means it will start a sentence so only print value
        } else if(chosenKey == " "){
            return chosenValue + " ";
        } 
        //in all other cases print key and value
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