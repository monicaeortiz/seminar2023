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


    // public static Map scanFile (File textFile) {

    // }

    // public static void writeNewLine() {

    // }


    // public static String getRandomELement(String currentWord, Map <String, ArrayList <String>> bigrams) {

    // }


    public static String pickBigram(Map <String, ArrayList <String>> bigrams, String key) {

        return (bigrams.get(key)).get((int) (Math.random() * (bigrams.get(key).size() + 1)));






    }


    // public static String checkPunctuation(Map <String, ArrayList <String>> bigrams) {

    // }






}