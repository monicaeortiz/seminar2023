import java.util.Arrays;
public class ourList {
    //public so client can check datatype
    public String datatype = "String";
    //engineering component of course --> pros and cons of having big array
        //too big --> costly and takes up memory
        //too small --> not enough space
    //main array HAS to be private
    private String[] mainArray = new String[5];
    //physcial size --> 20 (20 slots available)
    //logical size --> 0 (nothing is there)
    //private
    private int logicalSize = 0; 
    
    public boolean add(String s){
        //check if there is space in mainArray
            // add s to the end of mainArray
            //need to increment logical size
            //return boolean true to indicate successful add
        //no space
            //create a new array mainArray.length*1.5
            //copy values from mainArray to new array
            //reassign mainArray to new array
            //need to increment logical size
            //return boolean true to indicate successful add
        if(logicalSize <= mainArray.length){
            mainArray[logicalSize] = s;
        } else {
            String[] arr = new String[(int)((mainArray.length)*1.5)];
            for(int i = 0; i<mainArray.length; i++){
                arr[i] = mainArray[i];
            }
            mainArray = arr;
            mainArray[logicalSize] = s;
        }
        logicalSize++;
        return true; 
    }

    public boolean add(int index, String s){
        if(logicalSize <= mainArray.length){
            mainArray[index] = s;
        } else {
            String[] arr = new String[(int)((mainArray.length)*1.5)];
            for(int i = 0; i<mainArray.length; i++){
                arr[i] = mainArray[i];
            }
            mainArray = arr;
            mainArray[index] = s;
        }
        logicalSize++;
        return true; 
    }

    public String get(int index){
        for(int i = 0; i<mainArray.length; i++){
            if(i == index){
                return mainArray[i];
            }
        }
        return "invalid index";
    }

    public String get(int index, String s){
        for(int i = index; i<mainArray.length; i++){
            if(mainArray[i].equals(s)){
                return mainArray[i];
            }
        }
        return "invalid index";
    }

<<<<<<< HEAD
    public int size(){
        return mainArray.length;
=======
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
>>>>>>> 57bb331b7b29e8e995d86416ba1314895eaf8dbd
    }

    public static void main(String[] args){
        String[] arr = {"a", "b", "c", "d", "e"};
        arr.add("g");
        System.out.println(Arrays.toString(arr));
        arr.add(5, "f");
        System.out.println(Arrays.toString(arr));

        arr.get(5);
        System.out.println(Arrays.toString(arr));
    }

}