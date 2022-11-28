import java.util.*;

public class SetsAndMapsInClass {

    public static void main(String[] args) {
        HashSet<String> fruits = new HashSet<>();
        fruits.add("banana");
        fruits.add("orange");
        fruits.add("kiwi");
        fruits.add("banana");
        fruits.add("strawberry");
        System.out.println(fruits);

        Set<Integer> nums = new HashSet<>(Arrays.asList(1, 2, 3, 4));
        System.out.println(nums);

        // How to iterate through a set:
        Iterator<String> itr = fruits.iterator();
        while (itr.hasNext()) {  // Still values left in iterator.
            String word = itr.next();
            System.out.println(word);
        }
        System.out.println();
        // Second way:
        for (String word : fruits) {
            System.out.println(word);
        }

        // Initialize 2 different sets.
        Set<String> bowl1 = new HashSet<>(Arrays.asList("a", "b", "c"));
        Set<String> bowl2 = new HashSet<>(Arrays.asList("b", "c", "d"));

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
}