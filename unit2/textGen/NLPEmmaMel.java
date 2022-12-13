public class NLPEmmaMel{
    public static void main(String[] args){
    }

    public static void printNewScript(File f, int numLines){
        //read in file using a scanner
        Scanner sc = new Scanner(dataset);
        //create map to keep bigrams
        Map<String, ArrayList<String>> bigrams = new HashMap<>();

        //loop to keep going until there are no more lines in given file
        while(sc.hasNextLine()){
            //use .split to separate each line into an arraylist of words - get rid of spaces
                //keep punctuation on the word
            String[] line = sc.nextLine().split(",");
            ArrayList<String> lineList = new ArrayList<>(Arrays.asList(line));
            //loop through the length of the line and add words and followers to map
            for(int i=0; i<lineList.size(); i++){
                if(i == lineList.size()-1){
                    //how do you add one to arraylist of values in same line?
                    bigrams.put(lineList.get(i), .add(""));
                }
                    //how do you add one to arraylist of values in same line?
                bigrams.put(lineList.get(i), .add(lineList.get(i+1)));
            }     
        }
        sc.close();
        //create new file with printstream
        PrintStream p = new PrintStream("Generate file");
        //for loop to randomly pick bigrams from map and runs the numLines, which is amount of lines that are desired in new file
        int counter =0;
        while(counter < numLines){
            String bigram = pickBigram(bigrams);
            //print bigram to new file
            p.print(bigram);
            if(bigram.indexOf(" ") == -1){
                counter++;
                p.println();
            }
        }
        p.close();
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