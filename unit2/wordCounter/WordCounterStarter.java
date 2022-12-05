import java.util.*;
import java.io.*;


public class WordCounterStarter {

  public static void main(String[] args) throws FileNotFoundException {
  }

  /* Returns lowercase version of original word with all punctuation removed. */
  public static String cleanUp(String word) {
    word = word.toLowerCase();  // Force word to be in lowercase.
    word = word.replaceAll("[^A-Za-z]+", "");  // Remove any non-alphanumeric characters.
    return word;
  }

}