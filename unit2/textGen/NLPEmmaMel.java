public class NLPEmmaMel{
    public static void main(String[] args){
    }

    public static void printNewScript(String pathname, int numLines){
        //read in file using a scanner
        //create new file with printstream
        //loop to keep going until there are no more lines in given file
            //use .split to separate each line into an arraylist of words - get rid of spaces
                //keep punctuation on the word
            //loop through the length of the line and add words and followers to map
        //for loop to randomly pick bigrams from map and runs the numLines, which is amount of lines that are desired in new file
            //use pickBigram method and print it to new file
    }
    // returns a random bigram so that it can be added to the printstream
    public static String pickBigram(Map<String, ArrayList<String>> bigrams){
        // make a variable to hold the key set of the bigram map
        // convert this variable to an array list (so that it has indexes, and random picker can be used), call this variable listOfKeys
        // feed listOfKeys into getRandomElement, save this to a variable chosenKey
        // save all of the values associated with chosenKey to another arrayList (can call this listOfValues)
        // use getRandomElement to get a random value from listOfValues (can call this chosenValue)
        // return a string formatted as follows: chosenKey + " " + chosenValue (this is a bigram)
    }
    // picks a random element from an array list
    public static String getRandomElement(ArrayList<String> list){
        // use Math.Random to pick a random index (utilize size of list to make sure all elements of list could be chosen)
        // return the element held at that random index using .get() method
    }
}