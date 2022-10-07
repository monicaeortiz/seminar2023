/*count variables, lowest count variable wins
returns

*/

//ArrayList<array> votes = new ArrayList<>();

//int [][] votes = new int [9][4];
import java.util.*;

public class KathrynVote{


  public static void main(String[] args) {
    int[][] votes = { { 2, 2, 2 }, { 1, 3, 3 }, { 0, 0, 4 } };
    int[][] ts = {
      { 3, 4, 2, 1 },
      { 3, 1, 4, 2 },
      { 1, 4, 2, 3 },
      { 3, 2, 1, 4 },
      { 2, 1, 3, 4 },
      { 2, 1, 3, 4 },
      { 1, 4, 2, 3 },
      { 2, 3, 1, 4 },
      { 1, 3, 2, 4 },
    };

    String[] tsSongs = {
    "You Belong With Me",
    "All Too Well",
    "Love Story",
    "Fifteen",
  };

  String[] tsBallots = {
    {"Fifteen", "Love Story", "You Belong With Me", "All Too Well (10 Minute Version)"}, 
    {"All Too Well (10 Minute Version)", "Fifteen", "You Belong With Me", "Love Story"}, 
    {"You Belong With Me", "Love Story", "Fifteen", "All Too Well (10 Minute Version)"}, 
    {"Love Story", "All Too Well (10 Minute Version)", "You Belong With Me", "Fifteen"}, 
    {"All Too Well (10 Minute Version)", "You Belong With Me", "Love Story", "Fifteen"},
    {"All Too Well (10 Minute Version)", "You Belong With Me", "Love Story", "Fifteen"}, 
    {"You Belong With Me", "Love Story", "Fifteen", "All Too Well (10 Minute Version)"},
    {"Love Story", "You Belong With Me", "All Too Well (10 Minute Version)", "Fifteen"}, 
    {"You Belong With Me", "Love Story", "All Too Well (10 Minute Version)", "Fifteen"}
};
    /*

222
133
004


*/

    System.out.println(bordaCount(ts, tsSongs));
  }
//work on this
  public static String bordaCount (int[][] votes, String[] categories) { //add up sum of each column
    int[] sums = new int[votes[1].length];

    for (int j = 0; j < votes[1].length; j++) {
      for (int i = 0; i < votes.length; i++) {
        sums[j] += votes[i][j];
      }
    }

    System.out.println(Arrays.toString(sums));

    return categories[findSmallest(sums)];
  }

  public static int findSmallest(int[] arr) { //returns index of the smallest number
    int index = 0; //
    int smallest = arr[0];

    for (int i = 0; i < arr.length; i++) {
      if (arr[i] <= smallest) { //checking it element does not equal -1
        smallest = arr[i]; //updates each time a smaller number is found
        index = i; //records inde of smallest number
      }
    }

    return index;
  }

  // public static String instantRunoff(String [][] arr){

/*
You want an array that calculates the choices for every song, because a song won't show up if it has no first choice

1. look at first placeranking for each ballot, look down index zero (first column) of each array
2. does any choice have a majority? what is the  majority threshold

reasign majority value after each iteration

(#ballots + 1) / 2 //if any song has five votes, they are winner
//assume there is no missing data

3. if there is no majority winner, find option with LEAST number of first place votes
//what if there is a tie?" hmmmmm go to second choice to decide?
4. Which first choice candidate has the least first choce votes
5. Delete all occurences of worst song
6. Repeat, for or while loop?, second choice will become first choice for some
//while loop, you don't know how many times, not iterating or incremating, repeat process while something is true, while majority == false

break or return to get our of while loop

7. Is there a majority?

String[][] --> ArrayList<ArrayList<String>>


1. for loop over rows
2. make a new AL for the row
3. loop through this row of the array, 
Arrays.asList index of 2d array of names
add completed row AL to my final AL<Al<String>>

use both arrays maybe


Have a Tally object for each
take the ballot array, and add place to each tally object
 
  */

  public static Tally instantRunoff (String[][] ballots, int ranking){

    //should i make a new object
    //array list of student objects
    //iterate through objects and add numbers to array


  }
}

//find min for ballot object

