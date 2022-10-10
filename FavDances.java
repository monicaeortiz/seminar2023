import java.util.*;
public class FavDances {

    /* Ballet wins for both instant runoff and Jazz would win for Borda count */
    /* Our data is an arraylist of arraylists of strings, and it is in ballot format */
    /* In this dataset there are four options for the favorite types of dance - Jazz, Ballet, Interprative, and Tap */
    /* If you are trying to determine the thrid/fourth place winners in this data using borda count Interprative and Tap will tie, in this case use Instant Runoff to determine 
    the winner */
    ArrayList <ArrayList <String>> favDances = new ArrayList<ArrayList <String>> ();
    /
    ArrayList <Integer> r1 = new ArrayList <Integer> ();
    r1.add("Ballet");
    r1.add("Jazz");
    r1.add("Tap");
    r1.add("Interprative");
  
    ArrayList <Integer> r2 = new ArrayList <Integer> ();
    r2.add("Tap");
    r2.add("Jazz");
    r2.add("Interprative");
    r2.add("Ballet");
  
    ArrayList <Integer> r3 = new ArrayList <Integer> ();
    r3.add("Ballet");
    r3.add("Jazz");
    r3.add("Interprative");
    r3.add("Tap");
  
    ArrayList <Integer> r4 = new ArrayList <Integer> ();
    r4.add("Jazz");
    r4.add("Interprative");
    r4.add("Tap");
    r4.add("Ballet");
  
    ArrayList <Integer> r5 = new ArrayList <Integer> ();
    r5.add("Ballet");
    r5.add("Jazz");
    r5.add("Interprative");
    r5.add("Tap");
    
    favDances.add(r1);
    favDances.add(r2);
    favDances.add(r3);
    favDances.add(r4);
    favDances.add(r5);

}