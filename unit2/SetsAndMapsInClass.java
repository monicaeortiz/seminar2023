import java.util.*;

public class SetsAndMapsInClass {

    public static void main(String[] args) throws Exception {
        exceptionThrowingExample(false);  // Change parameter to true to get the error message.

        HashSet<String> fruits = new HashSet<>();
        fruits.add("banana");
        fruits.add("orange");
        fruits.add("kiwi");
        fruits.add("banana");
        fruits.add("strawberry");
        System.out.println(fruits);

        String[] arr = fruits.toArray();

        for (String wo: arr){
            System.out.println(wo);
        }

        arr.add("la");

        // Set<Integer> nums = new HashSet<>(Arrays.asList(1, 2, 3, 4));
        // System.out.println(nums);

        // // How to iterate through a set:
        // Iterator<String> itr = fruits.iterator();
        // while (itr.hasNext()) {  // Still values left in iterator.
        //     String word = itr.next();
        //     System.out.println(word);
        // }
        // System.out.println();
        // // Second way:
        // for (String word : fruits) {
        //     System.out.println(word);
        // }

        // // Initialize 2 different sets.
        // Set<String> bowl1 = new HashSet<>(Arrays.asList("a", "b", "c"));
        // Set<String> bowl2 = new HashSet<>(Arrays.asList("b", "c", "d"));

        // Get the union/disjunction/OR of the two.
        // bowl1.addAll(bowl2);
        // System.out.println(bowl1);

        // Get the intersection/conjunction/AND of the two.
        // bowl1.retainAll(bowl2);
        // System.out.println(bowl1);

        // Get the set difference (what is in bowl1 but not in bowl2)
        // bowl1.removeAll(bowl2);
        // System.out.println(bowl1);

        // Check if bowl1 is a superset of bowl2.
        // System.out.println(bowl1.containsAll(bowl2));

        // Initialize a new map.
        Map<String, Double> salaries = new HashMap<>();
        // Keys are strings, and values are doubles.
        salaries.put("Ross", 100.0);
        salaries.put("Janice", 103.6);
        salaries.put("Chandler", 12000.0);

        salaries.put("Chandler", -1.0);

        // Iterate through the keys of the map.
        Set<String> names = salaries.keySet();
        System.out.println("Names in the map");
        for (String name : names) {
            System.out.println(name);
        }

        Collection<Double> money = salaries.values();
        // Iterate through the values of the map.
        for (Double salary : money) {
            System.out.println(salary);
        }

        birthdays();

        List<String> words = new ArrayList<String>(Arrays.asList("a", "a", "a", "b"));
        System.out.println("The list contains a word that appears at least 3 times: " + contains3(words));
    }

    public static void sortAndRemoveDuplicates(List<Integer> nums) {
        // Get only distinct elements first.
        Set<Integer> distinctElements = new HashSet<Integer>(nums);
		List<Integer> sortedList = new ArrayList<Integer>(distinctElements);
        // Sort the elements in sortedList.
		Collections.sort(sortedList);
        // Modify nums to contain the sorted elements.
        nums.clear();
        nums.addAll(sortedList);
    }

    public static void birthdays() {
        Map<String, String> birthdays = new HashMap<>();
        birthdays.put("TS", "Dec");
        birthdays.put("Eliza", "Nov");
        birthdays.put("Tara", "May");

        Set<String> names = birthdays.keySet();
        for (String name : names) {
            System.out.println(name + " was born on " + birthdays.get(name));
        }

    }

    public static boolean contains3(List<String> words) {
        // Create a frequency map - map of the counts of each word.
        Map<String, Integer> counts = new HashMap<>();
        // Populate it by iterating through words and adding each unique word
        // as the key.
        // The values will be the corresponding counts for each word.
        for (String word : words) {
            // Add the word to counts and update its corresponding value.
            counts.put(word, counts.getOrDefault(word, 0) + 1); 

            // ALTERNATIVELY:
            // if (counts.containsKey(word)) {
            //     // Get the previous count of this word in counts.
            //     int count = counts.get(word) + 1;
            //     // Update the map of counts.
            //     counts.put(word, count);
            // } else { // word is NOT in counts yet.
            //     counts.put(word, 1);
            // }
        }
        System.out.println(counts);
        // Is there a value in the dictionary that is >= 3.
        // Get all the values at once.
        Collection<Integer> countNums = counts.values();
        // Iterate through countNums.
        for (Integer count : countNums) {
            // If one of them is >= 3, return true.
            if (count >= 3) {
                return true;
            }
        }
        return false;
    }

    // Method to demonstrate how to throw an exception!
    public static void exceptionThrowingExample(boolean problem) throws Exception {
        if (problem) { // Some condition...
            throw new Exception("A specific error message goes here - what went wrong?");
        } else {
            System.out.println("Everything is fine");
        }
    }

}