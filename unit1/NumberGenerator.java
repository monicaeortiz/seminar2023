import java.io.*;
import java.util.*;

public class NumberGenerator {

  public static void main(String[] args) throws FileNotFoundException {
    /*
    all parameter values are decimal
    createNums(both Versions) ( 
                    int firstInt: first number in range,  
                    int lastInt: last number in range , 
                    int startRow: the number you want your rows to start at (difference of firstInt and startRow CANNOT be greater than the row length)
                    int rowLength: length of Rrow
                    int[] bases: bases you want to conver to, 16 (hexadecimal) is the highest number, also bases obviously cannot be negative or 0, or 1
                    String name: name of file you want to write to, relative or absolute, whatever works 
                    )

    createNumVersion1CSV(
                        int firstInt: see above
                        int lastInt: see above
                        int[] bases: see above
                        String name: relative/absolute pathname of file you are passing in/want to create
                        String delimiter: delimiter for your csv file
                        )
    



    */

  }

  public static void createNumsVersion1(
    int firstInt,
    int lastInt,
    int startRow,
    int rowLength,
    int[] bases,
    String name
  ) throws FileNotFoundException {
    PrintStream p = new PrintStream(name);

    if (
      (startRow < firstInt) ||
      ((startRow - firstInt) > rowLength) ||
      (startRow > lastInt) ||
      (firstInt > lastInt) ||
      (lastInt < firstInt) ||
      !checkValidBases(bases)
    ) {
      p.print("You did not follow the instructions. How dare you");
    } else {
      int length = convertDec(lastInt, bases[findSmallest(bases)]).length();
      int rowValue = startRow - firstInt;
      //int limit = (lastInt - startRow) / rowLength;

      for (int i = firstInt; i < lastInt; i += rowValue) {
        if (i == firstInt + rowValue) {
          rowValue = rowLength;
        }
        for (int k = 0; k < bases.length; k++) {
          p.print(formatNicely(bases[k] + "", length));
          //p.print(bases[k]);
          for (int j = i; j < i + rowValue; j++) {
            if (j > lastInt) {
              break;
            }

            p.print(formatNicely(convertDec(j, bases[k]), length) + "  ");
          }
          p.println();
        }

        p.println();
      }
    }

    p.close();
  }

  public static void createNumsVersion2(
    int firstInt,
    int lastInt,
    int startRow,
    int rowLength,
    int[] bases,
    String name
  ) throws FileNotFoundException {
    PrintStream p = new PrintStream(name);

    if (
      (startRow < firstInt) ||
      ((startRow - firstInt) > rowLength) ||
      (startRow > lastInt) ||
      (firstInt > lastInt) ||
      (lastInt < firstInt) ||
      !checkValidBases(bases)
    ) {
      p.print("You did not follow the instructions. How dare you");
    } else {
      int rowValue = 0;

      for (int k = 0; k < bases.length; k++) {
        rowValue = startRow - firstInt;
        int length = convertDec(lastInt, bases[k]).length();

        for (int i = firstInt; i < lastInt; i += rowValue) {
          p.print(formatNicely(bases[k] + "", length));

          for (int j = i; j < i + rowValue; j++) {
            if (j > lastInt) {
              break;
            }

            p.print(formatNicely(convertDec(j, bases[k]), length) + "  ");
          }
          p.println();

          rowValue = rowLength;
        }

        p.println();
      }
    }

    p.close();
  }

  public static void createNumVersion1CSV(
    int firstInt,
    int lastInt,
    int[] bases,
    String name,
    String delimiter
  ) throws FileNotFoundException {
    PrintStream p = new PrintStream(name);

    if (
      (firstInt > lastInt) || (lastInt < firstInt) || !checkValidBases(bases)
    ) {
      p.print("You did not follow the instructions. How dare you");
    } else {
      int length = convertDec(lastInt, bases[findSmallest(bases)]).length();
      String delimit = delimiter;
      //int limit = (lastInt - startRow) / rowLength;

      for (int j = 0; j < bases.length; j++) {
        if (j == bases.length - 1) {
          delimit = "";
        }

        p.print(bases[j] + "" + delimit);
      }

      p.println();

      for (int i = firstInt; i <= lastInt; i++) {
        delimit = delimiter;
        for (int k = 0; k < bases.length; k++) {
          if (k == bases.length - 1) {
            delimit = "";
          }

          p.print(convertDec(i, bases[k]) + delimit);
        }

        p.println();
      }

      p.println();
    }
  }

  //  public static void createNumVersion1CSV(int start, int end, int[] bases) throws FileNotFoundException{
  //         PrintStream p = new PrintStream("generateNums2.csv");
  //         String delimiter = "";

  //         for (int i = start; i < end; i+=10){
  //             for (int k = 0; k < bases.length; k++){
  //             for (int j = i; j < i+10; j++){

  //                     p.print(convertDec(j, bases[k]) + "  ");

  //                 }
  //                 p.println();

  //             }
  //             p.println();

  //         }

  //       p.close();

  // }

  // public static void ascendingNums(File f){

  // }

  // public static void checkAscendingDec(int dec){
  //     Arraylist<Integer> digits = new ArrayList<>();
  //     //int ones = dec%10;

  //     while (dec > 0){
  //         digits.add(0, num%10);
  //         num = num / 10;
  //     }
  //     //hundreds, ten to the first, ten to the 2nd

  // }

  //public static void isAscending()

  public static String formatNicely(String s, int length) {
    int numSpaces = length - s.length();
    String spaces = "";
    for (int i = 0; i < numSpaces / 2; i++) {
      spaces += " ";
    }

    if (numSpaces % 2 == 0) {
      return spaces + s + spaces;
    } else {
      return spaces + " " + s + spaces;
    }
  }

  public static boolean checkValidBases(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      if ((arr[i] > 16) || (arr[i] < 2)) {
        return false;
      }
    }

    return true;
  }

  public static String convertDec(int decimal, int base) { //credit to javapoint
    int rem;
    String newNum = "";
    char hexchars[] = {
      '0',
      '1',
      '2',
      '3',
      '4',
      '5',
      '6',
      '7',
      '8',
      '9',
      'A',
      'B',
      'C',
      'D',
      'E',
      'F',
    };
    while (decimal > 0) {
      rem = decimal % base;
      newNum = hexchars[rem] + newNum;
      decimal = decimal / base;
    }
    return newNum;
  }

  public static int findSmallest(int[] arr) { //returns index of the smallest number
    int index = 0; //
    int smallest = arr[0]; //starting eith the largest possible number

    for (int i = 0; i < arr.length; i++) {
      if (arr[i] < smallest) { //checking it element does not equal -1
        smallest = arr[i]; //updates each time a smaller number is found
        index = i; //records index of smallest number
      }
    }

    return index;
  }
}
