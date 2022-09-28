import java.util.*;

public class MelinaKathrynMethods {

  public String dataType = "String";
  public String[] mainArray = new String[5];
  private int logicalSize = 0;

//just method headers for now

  public String get(int i) {}

  public int indexOf(String s) {
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
}
