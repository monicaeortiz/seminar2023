import java.util.Arrays;
import java.util.ArrayList;

public class ArraysPractice {
    public static void main(String[] a) {
        int[] temperatures = {60, 61, 70, 53};
        // Check that the return value of range matches expected value.
        System.out.println(range(temperatures) == 19);
        // Edge case - what if array has only 1 value?
        int[] one = {0};
        System.out.println(range(one) == 1);

        arrayListExtraPractice();
    }

    public static int range(int[] arr) {
        // Assumes arr has at least one element.
        int min = arr[0];
        int max = arr[0];

        // First, identify min and max values by looping through array.
        for (int a : arr) {  // Can use a for-each loop since we don't need indexes, only values.
            if (a > max) {
                max = a;
            }
            if (a < min) {
                min = a;
            }
        }
        return max - min + 1;
    }

    public static void modifyArray(int[] arr) {
        int move = arr[0];
        for (int i = 1; i < arr.length; i++) {
            arr[i - 1] = arr[i];
        }
        arr[arr.length - 1] = move;
    }

    public static void reverseArray(int[] arr) {
        // length / 2 is truncated (integer division).
        for (int i = 0; i < arr.length / 2; i++) {
            int a = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = a;
        }
    }

    public static void arrayListExtraPractice() {
        // #1.
        ArrayList<String> favSongs = new ArrayList<String>(Arrays.asList("call me maybe", "all that", "emotion", "cut to the feeling", "i really like you", "julien", "your type", "run away with me"));
        System.out.println("Some songs!");
        System.out.println(favSongs);
        // Part (a).
        // Logical size is 8. Physical size is NOT the same,
        // probably > 8 but client does not need to know exact
        // value!
        // Part (b).
        // Many ways to do this, here's an example.
        for (int i = 0; i < favSongs.size(); i++) {
            // Use string indexOf method to check if "a" in song name.
            if (favSongs.get(i).indexOf("a") != -1) {
                favSongs.remove(i);
                // Need to update the current index since we removed an element.
                // e.g. if we just removed item 0, we need to check the NEW item 0 on the next iteration of the loop.
                i--;
            }
        }
        System.out.println(favSongs);

        // #2.
        ArrayList<Integer> multiplesOf2 = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            multiplesOf2.add(i * 2);
        }
        System.out.println(multiplesOf2);

        // #3.
        // ArrayLists cannot store primitives (like ints!)
        // Need to use Integer class to wrap ints.
        // This line does not compile!
        // ArrayList<int› numbers = new ArrayList<>0;
    }

}