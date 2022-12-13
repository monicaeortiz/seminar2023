public class AITextGenPec {

    public static void main(String[] args){

    }

    //methods

    public static void generateNewFile(Map<String, List<String>>){
        pass;

    }

    public static Map<String, List<String>> parseFile(File f){
        //creating the map for our file 
        Map<String, List<String>> bigrams = new HashMap<>();
        String word = "";
        //create new scanner to read in file
        Scanner sc = new Scanner(f);
        //creating a list that will hold the current value (list) for each o the keys 
        ArrayList<String> currList = new ArrayList<>();
        while(sc.hasNext()){
            //creating the current word we're on to store as a key
            String currWord= sc.next();
            //gettnig the list that already exists for our key and setting it to currList
            if(bigrams.contains(word) == false){
                bigrams.put(word, currWord);
            } else {
                currList = bigrams.get(word);
                //adding the second word to the list of words (vlue) for the key 
                currList.add(currWord);
                //putting the current word as a key and the updated list as the value
                bigrams.put(word, currList);
            }
            //reassigning word to the next word
            word = currWord;
            
        }
        sc.close(); //closing our scanner
        
        return bigrams; //returning the results of our map 
    }

    
    
    public static String chooseBigramWord(Map<String, List<String>> bigrams){
        Set<String> keys = bigrams.keySet();
        ArrayList<String> keyList = new ArrayList<>(keys);
    }

    public static String chooseValue(Map<String, List<String>> bigrams, String word){
        pass;
    }

    //extra helper methods
    public static String findPunctuation(Map<String, String> bigrams){
        pass;
    }

    
    
}