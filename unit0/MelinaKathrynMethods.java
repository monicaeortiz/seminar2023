import java.util.*;

public class MelinaKathrynMethods {

  public String dataType = "String";
  public String[] mainArray = new String[5];
  private int logicalSize = 0;

  public static void main(String[] args) {
    MelinaKathrynMethods list = new MelinaKathrynMethods();

    list.add("rat");
    list.add("bat");
    list.add("cat");
    list.add("sat");
    list.add("gnat");
    list.add("pat");
    list.add("at");

    System.out.println(Arrays.toString(list.mainArray));

    System.out.println(list.get(0));

    System.out.println(list.get(6));

    System.out.println(list.kathrynIndexOf("at"));

    System.out.println(list.melinaIndexOf("rat"));

    System.out.println(list.melinaIndexOf("not in array"));

    list.add(0, "cat");

    list.add(8, "rat"); //this index does not exist

    System.out.println(Arrays.toString(list.mainArray));
  }

  public String get(int i) {
    return mainArray[i]; //will have an out of bounds error if i is too large
  }

  public int kathrynIndexOf(String s) {
    for (int i = 0; i < mainArray.length; i++) {
      if (mainArray[i].equals(s)) {
        return i;
      }
    }

    return -1;
  }

  public int melinaIndexOf(String s) {
    for (int i = 0; i < mainArray.length; i++) {
      if (mainArray[i] != null && mainArray[i].equals(s)) {
        return i;
      }
    }
    // if that string does not exist within main array, return -1
    return -1;
  }

  public boolean add(String s) {
    // if there is space in mainArray, do this stuff
    if (logicalSize < mainArray.length) {
      mainArray[logicalSize] = s;
    } 
    
    else { //no space in main array
      String[] holderArray = new String[(int) (mainArray.length * 1.5)];
      for (int i = 0; i < mainArray.length; i++) {
        holderArray[i] = mainArray[i];
      }
      holderArray[mainArray.length] = s;
      mainArray = holderArray;
    }
    logicalSize++;
    return true;
  }

  public boolean add(int i, String s) { //assuming user doesn't insert it into an index that doesn't exist
    // just creating a new array with one greater each time
    int increase = 0;

    String[] holderArray = new String[mainArray.length + 1];
    for (int j = 0; j < mainArray.length; j++) {
      if (j == i) {
        holderArray[j] = s;
        increase = 1;
      }

      holderArray[j + increase] = mainArray[j];
    }
    mainArray = holderArray;
    logicalSize++;
    return true;
  }
}
