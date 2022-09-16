import java.util.Arrays;

public class ArraysPractice {
    public static void main(String[] a) {
        int[] temperatures = {60, 61, 70, 53};
        // Check that the return value of range matches expected value.
        System.out.println(range(temperatures) == 19);
        // Edge case - what if array has only 1 value?
        int[] one = {0};
        System.out.println(range(one) == 1);
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

}