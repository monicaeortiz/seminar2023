import java.util.*;
// NOTES from class:
 // logical size vs physical size
 // logical size: how many items a client thinks are in the array
 // physical size: the actual amount of slots (client doesn't care about physical size)

 public class TarasList {
    String dataType = "String";
    private String[] mainArray = new String[5];
    private int logicalSize = 0;


    public String remove(int index) {
        // check if the given index is a valid index in the array (not larger than the length or negative)
        if (index>logicalSize||index<0) {
            // if not, return "-1"
            return "-1";
        }
        else {
            // saves the item that is to be removed in a String variable
            String toRemove = mainArray[index];
            // iterates through the array beginning at the index of the item to be removed and replaces each item with the one that follows it
            for (int i = index; i<logicalSize-1; i++) {
               mainArray[i] = mainArray[i+1];
            }
            // decrements the logical size of the array by one to signal that an item has been removed
            logicalSize--;
            // returns the item that was removed
            return toeRemove;
        }
    }

}