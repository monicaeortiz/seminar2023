/*count variables, lowest count variable wins
returns

*/

//ArrayList<array> votes = new ArrayList<>();

//int [][] votes = new int [9][4];
import java.util.*;

public class KathrynVote {

  public static void main(String[] args) {
    //   int[][] votes = { { 2, 2, 2 }, { 1, 3, 3 }, { 0, 0, 4 } };
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

    String[][] tsBallots = {
      {
        "Fifteen",
        "Love Story",
        "You Belong With Me",
        "All Too Well (10 Minute Version)",
      },
      {
        "All Too Well (10 Minute Version)",
        "Fifteen",
        "You Belong With Me",
        "Love Story",
      },
      {
        "You Belong With Me",
        "Love Story",
        "Fifteen",
        "All Too Well (10 Minute Version)",
      },
      {
        "Love Story",
        "All Too Well (10 Minute Version)",
        "You Belong With Me",
        "Fifteen",
      },
      {
        "All Too Well (10 Minute Version)",
        "You Belong With Me",
        "Love Story",
        "Fifteen",
      },
      {
        "All Too Well (10 Minute Version)",
        "You Belong With Me",
        "Love Story",
        "Fifteen",
      },
      {
        "You Belong With Me",
        "Love Story",
        "Fifteen",
        "All Too Well (10 Minute Version)",
      },
      {
        "Love Story",
        "You Belong With Me",
        "All Too Well (10 Minute Version)",
        "Fifteen",
      },
      {
        "You Belong With Me",
        "Love Story",
        "All Too Well (10 Minute Version)",
        "Fifteen",
      },
    };

    //test cases

    //robyn and patricia test cases

    //all tests had predicted output except foer #2 of Robyn and Patricia's

    //1. simple cases

    int[][] rankings1 = { { 3, 2, 4, 1 }, { 1, 4, 3, 2 }, { 4, 1, 2, 3 } };
    String[][] ballots1 = {
      { "C", "B", "D", "A" },
      { "A", "D", "C", "B" },
      { "D", "A", "B", "C" },
    };
    String[] categories1 = { "A", "B", "C", "D" };

    System.out.println(bordaCount(rankings1, categories1));
    System.out.println(bordaCount(convertArrays(rankings1, categories1)));
    System.out.println(bordaCount(ballots1));
    System.out.println(instantRunoff(ballots1));
    System.out.println(instantRunoff(convertArrays(rankings1, categories1)));

    //2. borda/IR give different winners
    //I got the same winners for both...
    int[][] rankings2 = { { 3, 2, 4, 1 }, { 1, 4, 2, 3 }, { 2, 3, 4, 1 } };
    String[][] ballots2 = {
      { "C", "B", "D", "A" },
      { "A", "D", "B", "C" },
      { "B", "C", "D", "A" },
    };

    System.out.println(bordaCount(rankings2, categories1));
    System.out.println(bordaCount(convertArrays(rankings2, categories1)));
    System.out.println(bordaCount(ballots2));
    System.out.println(instantRunoff(ballots2));
    System.out.println(instantRunoff(convertArrays(rankings2, categories1)));

    //3. tie
    //both methods choose different winners, winner is selected by the order of the array
    int[][] rankings3 = { { 1, 2 }, { 2, 1 } };
    String[][] ballots3 = { { "A", "B" }, { "B", "A" } };

    System.out.println(bordaCount(rankings3, categories1));
    System.out.println(bordaCount(convertArrays(rankings3, categories1)));
    System.out.println(bordaCount(ballots3));
    System.out.println(instantRunoff(ballots3));
    System.out.println(instantRunoff(convertArrays(rankings3, categories1)));

    // cass and emma's examples
    // one simple case (each row is one person's ballot with the candidates in order of preference)
    // borda count winner: c
    // IR winnner: c
    String[][] rankings4 = {
      { "A", "B", "C" },
      { "C", "B", "A" },
      { "C", "A", "B" },
      { "B", "C", "A" },
    };

    System.out.println(bordaCount(rankings4));
    System.out.println(instantRunoff(rankings4));
    System.out.println(recursiveInstantRunoff(rankings4));

    // borda count != IR
    // each row is one person's ballot with the candidates in order of preference
    // borda count winner: B
    // IR winner: A
    String[][] rankings5 = {
      { "A", "B", "C" },
      { "A", "B", "C" },
      { "A", "B", "C" },
      { "B", "C", "A" },
      { "B", "C", "A" },
    };

    System.out.println(bordaCount(rankings5));
    System.out.println(instantRunoff(rankings5));

    // exact tie!
    //borda count winner: tie and randomly selected winner
    //IR winner: tie and randomly selected winner
    String[][] rankings6 = {
      { "A", "B", "C" },
      { "A", "B", "C" },
      { "B", "C", "A" },
      { "B", "C", "A" },
      { "C", "A", "B" },
      { "C", "A", "B" },
    };

    System.out.println(bordaCount(rankings6));
    System.out.println(instantRunoff(rankings6));

    //TEK
    //1.
    //C is winner for instant runoff, C would win for borda count

    String[][] rankings7 = {
      { "B", "C", "A" },
      { "A", "C", "B" },
      { "C", "A", "B" },
      { "C", "B", "A" },
    };

    // System.out.println(bordaCount(rankings7));
    // System.out.println(instantRunoff(rankings7));

    //2.
    //A would win for instant runoff, B for borda count
    //A would win immediately without any elimination
    String[][] rankings8 = {
      { "A", "B", "C" },
      { "A", "B", "C" },
      { "B", "C", "A" },
      { "B", "C", "A" },
      { "A", "C", "A" },
    };

    System.out.println(bordaCount(rankings8));
    System.out.println(instantRunoff(rankings8));

    String[][] rankings9 = {
      //     //B would win for instant Runoff, requires elimination step
      { "A", "C", "B" },
      { "C", "B", "A" },
      { "B", "C", "A" },
      { "A", "B", "C" },
      { "B", "C", "A" },
    };

    System.out.println(bordaCount(rankings9));
    System.out.println(instantRunoff(rankings9));

    //3.
    //A and B would tie

    String[][] rankings10 = {
      { "A", "B", "C" },
      { "A", "B", "C" },
      { "B", "A", "C" },
      { "B", "A", "C" },
    };

    System.out.println(bordaCount(rankings10));
    System.out.println(instantRunoff(rankings10));
  }
  

  public static String bordaCount(int[][] votes, String[] categories) { //with int 2d array
    //technically don't need this method because I can convert the array, bur it is still goot to have around to double check
    int[] sums = new int[votes[1].length];

    for (int i = 0; i < votes.length; i++) {
      for (int j = 0; j < votes[1].length; j++) {
        sums[j] += votes[i][j]; //adding up all the vote values of each candidate
      }
    }

    return categories[findSmallest(sums)]; //the candidate with the smallest number wins
  }

  public static String bordaCount(String[][] ballots) { //with String 2d array
    //Was thinking of making a private static tally variable for the Tally class but I thought no because I'm not going to be able to initialize it to a value with certainty (correct me if I'm wrong please)

    ArrayList<Tally> ranks = convertArrays(ballots);

    Tally curWinner = ranks.get(0); //setting it to the first element to start off

    for (int i = 0; i < ranks.size(); i++) {
      if (ranks.get(i).getSumRanks() <= curWinner.getSumRanks()) { //if the ranking number is lower, aka they are better ranked
        curWinner = ranks.get(i);
      }
    }

    return curWinner.getName(); //return name of the winner
  }

  /* Pseudocode
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

  //should i make a new object
  //array list of student objects
  //iterate through objects and add numbers to array

  public static String instantRunoff(String[][] arr) {
    int[] sums; //declaring an array

    ArrayList<Tally> ranks = convertArrays(arr);

    int threshold = 0;

    while (ranks.size() > 1) {
      //for (int l = 0; l < 3; l++){

      sums = new int[ranks.size()]; //will be pointing to a new array every time a candidate is deleted

      threshold = (arr.length + 1) / 2; //minmum number of votes needed to win

      for (int i = 0; i < ranks.size(); i++) { //if any of the elements have the majority
        if (ranks.get(i).getNumRank(0) >= threshold) {

          return ranks.get(i).getName();
        }
      }

      for (int j = 0; j < ranks.size(); j++) {
        sums[j] = ranks.get(j).getNumRank(0); //adding up the number of first place votes for each candidate
      }

      arr = remove(arr, ranks.get(findSmallest(sums)).getName()); //removing all occurences of the candidate with the least first place finishes
      ranks = convertArrays(arr); //the tally array list no longer has the removed candidate
    }

    return ranks.get(0).getName(); //the last candidate left is the one who eins (elimination)
  }




  public static int findSmallest(int[] arr) { //returns index of the smallest number
    int index = 0; //
    int smallest = arr[0];
    for (int i = 0; i < arr.length; i++) {
      if ((arr[i] <= smallest)) { //checking if element is smaller
        smallest = arr[i]; //updates each time a smaller number is found
        index = i; //records index of smallest number
      }
    }

    return index;
  }

  public static String recursiveInstantRunoff(String[][] arr) {

    ArrayList<Tally> ranks = convertArrays(arr);
    int[] sum = new int[ranks.size()];

  if (ranks.size() == 1){

    return ranks.get(0).getName();

  }

    int threshold = (arr.length + 1) / 2;;
      for (int i = 0; i < ranks.size(); i++) { //if any of the elements have the majority
      sum[i] = ranks.get(i).getNumRank(0);
        if (ranks.get(i).getNumRank(0) >= threshold) {
          return ranks.get(i).getName();
        }

      }

      arr = remove(arr, ranks.get(findSmallest(sum)).getName()); //removing all occurences of the candidate with the least first place finishes
      return (recursiveInstantRunoff(arr));

  }





  

  public static ArrayList<Tally> convertArrays(String[][] ballots) { //converting a 2d array to an array list of Tally objects.As said before, I want to try this again with a 2d array list
    ArrayList<Tally> ballotTallies = new ArrayList<>();

    for (int i = 0; i < ballots[0].length; i++) { //number of columns aka number of candidates
      ballotTallies.add(new Tally(ballots[0][i], ballots[0].length)); //initializing Tally objects with their name, and the length of their instance array
    }

    for (int j = 0; j < ballots.length; j++) {
      for (int k = 0; k < ballots[j].length; k++) {
        for (int l = 0; l < ballotTallies.size(); l++) {
          if (ballots[j][k].equals((ballotTallies.get(l).getName()))) { //if the name founs in the 2d array is the name of the tally object
            ballotTallies.get(l).raiseTally(k); //raiseTally increases many values, including number votes held in the instance array
          }
        }
      }
    }
    return ballotTallies;
  }

  public static String[][] convertArrays(int[][] options, String[] categories) { //taking the integer 2d array lists that correspond to certain dandidates and converting it into a ballot format
    String[][] alteredArr = new String[options.length][options[0].length]; //same dimensions as the int 2d array

    for (int i = 0; i < options.length; i++) {
      for (int j = 0; j < options[i].length; j++) {
        alteredArr[i][j] = categories[options[i][j] - 1]; //each element of opstions corresponds to a category, but I had to add one because array indexes start at 0
      }

    
    }
      return alteredArr;
  }

  public static String[][] remove(String[][] ballots, String remove) { //was originally trying to make convertArrays an overloaded method that would ignore a particular candidate. I gave up after 2 hours, will try again in the future if I have the chance.
    String[][] alteredArr = new String[ballots.length][ballots[0].length - 1];

    ArrayList<ArrayList<String>> votes = new ArrayList<>(); //making a 2d String ArrayList

    for (int k = 0; k < ballots.length; k++) {
      ArrayList<String> temp = new ArrayList<String>(Arrays.asList(ballots[k])); //sinitializing an array list and setting the elements to those of an index of ballots
      temp.remove(remove); //remove all occurences (assuming one, no repeats) of the candidate to be removed
      votes.add(temp); //adding it to the array list of array lists
    }

    for (int i = 0; i < votes.size(); i++) { //copying the array list into a 2d array, honestly, I could have wrote it with a 2d array list in mind and it could have been easier, but next time!
      for (int j = 0; j < votes.get(i).size(); j++) {
        alteredArr[i][j] = votes.get(i).get(j);
      }
        
    }
  return alteredArr;
 
  }
}
  


