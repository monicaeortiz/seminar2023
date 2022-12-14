import java.util.*;
public class TaraKathrynAIRobot {

    public static void main (String[] args) {
    
        ArrayList<String> words = new ArrayList<>(Arrays.asList("a", "b", "c", "d", "e"));

        Map<String, ArrayList<String>> salaries = new HashMap<>();//can't have just Map on left side bc Map is an interface, HashMap implements a map interface
        salaries.put("Ms. Z", words);//keys must be unique
        salaries.put("Mr. A", words);
        salaries.put("Ms. Sandes", words);
        salaries.put("Person", words);
        salaries.put("Ross", words);
        salaries.put("Janice", words);
        salaries.put("Chandler", words);
        salaries.put("Chandler", words);//will UPDATE the value at Chandler

        System.out.println(pickBigram(salaries, "Person"));
        System.out.println(pickBigram(salaries, "Janice"));


       

    }


     public static Map<String, ArrayList<String>> scanFile (File textFile) {
        Map <String, ArrayList<String>> bigrams = new HashMap<>();//empty map, will be filled with bigrams
        Scanner fileScan = new Scanner(textFile);
        String firstWord = "";
        while(fileScan.hasNext()) { //keep getting strings from file one at a time
            String secondWord = fileScan.next(); //get the String in the file
            if (!bigrams.containsKey(firstWord)) { //if firstWord does not exist, add firstWord as a key to the map
                bigrams.put(firstWord, secondWord); //add secondWord to the value of firstWord
                firstWord = secondWord; //change firstWord to SecondWord
            }
            else {  // if firstWord already exists as a key in the map, get the current value and push the second word to the array list
                ArrayList temp = bigrams.get(firstWord);
                temp.add(secondWord);
            }
        }
        fileScan.close();
    }
     

    // public static void writeNewLine() {

    // }





    public static String pickBigram(Map <String, ArrayList <String>> bigrams, String key) {

        return (bigrams.get(key)).get((int) (Math.random() * (bigrams.get(key).size() + 1)));//get the arraylist associated with the key and generate a random number that returns a random index of that arraylist

    }


    // public static String checkPunctuation(Map <String, ArrayList <String>> bigrams) {

    // }






}


