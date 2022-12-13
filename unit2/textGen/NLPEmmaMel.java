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

    public static String pickBigram(Map<String, ArrayList<String>> bigrams){
        //calls getRandomElement
    }

    public static String getRandomElement(ArrayList<String> list){
    }
}