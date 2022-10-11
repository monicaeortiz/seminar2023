// Melina Salame and Hannah Dwyer
import java.util.*;
public class HMRankings {
    public static void main (String [] args){
        // Test Case 1: Song names
        String [] songNames = {"You belong with me", "All too well", "Love Story", "Fifteen"};
        /* col 1 is the votes for You Belong with Me, col 2 is the votes for All too well, col 3 is the votes for 
        love story, col 4 is the votes for Fifteen. According to Borda Count, Love Story should win */
        int [][] songBordaCountTest = {{3, 4, 2, 1}, {3, 1, 4, 2}, {1, 4, 2, 3}, {3, 2, 1, 4}};
        System.out.println("Winner of Borda Count for Songs: " + bordaCount(songBordaCountTest, songNames));
        // Test Case 2: Fav foods
        String [] favFoodNames = {"Ice Cream", "Pizza", "Pasta"};
        /* col 1 is the votes for ice cream, col 2 is the votes for pizza, col 3 is the votes for pasta. Pasta
        should win. */
        int [][] favFoodsBordaCountTest = {{1, 3, 2}, {3, 2, 1}, {2, 3, 1}};
        System.out.println("Winner of Borda Count for Foods: " + bordaCount(favFoodsBordaCountTest, favFoodNames));
        // Test Case 3: Favorite Colors
        String [] favColorNames = {"Blue", "Green"};
        int [][] favColorBordaCountTest = {{1, 2}, {2, 1}, {1, 2}, {2, 1}, {2, 1}};
        System.out.println("Winner of Borda Count for Colors: " + bordaCount(favColorBordaCountTest, favColorNames));
        /* col 1 is the votes for blue, col 2 is the votes for green. Green should win. */
        

        // IR Test Case 1: Fav Fruits. Pear is supposed to win. 0 is apple, 1 is Pear, 2 is banana
        String [] fruitNames = {"Apple", "Pear", "Banana"};
        int [][] fruitNamesIRTest= {{0, 2, 1}, {2, 0, 1}, {1, 2, 0}, {1, 0, 2}};
        System.out.println("Winner of Instant Runoff Fruits: " + instantRunoff(fruitNamesIRTest, fruitNames));

        // IR Test Case 2: Math should win
        String [] favClasses = {"Math", "Comp-Sci"};
        int [][] favClassesIRTest = {{0, 1}, {1, 0}, {0, 1}};
        System.out.println("Winner of Instant Runoff for Favorite Classes: " + instantRunoff(favClassesIRTest, favClasses));

        // IR Test Case 3: NY Should win
        String [] favStates = {"Kentucky", "Wisconsin", "CT", "NY"};
        int [][] favStatesIRTest = {{3, 2, 0, 1}, {1, 2, 0, 3}, {3, 2, 1, 0}};
        System.out.println("Winner of Instant Runoff for Favorite States: " + instantRunoff(favStatesIRTest, favStates));

    }

    //method to convert 2d array to a 2d arraylist of arraylists
    public static ArrayList <ArrayList <Integer>> convertToList (int [][] mat){
        ArrayList <ArrayList <Integer>> toRet = new ArrayList <ArrayList <Integer>> ();
        for (int r = 0; r < mat.length; r++){
            ArrayList <Integer> temp = new ArrayList <Integer> ();
            for (int c = 0; c < mat[r].length; c++){
                temp.add(mat[r][c]);
            }
            toRet.add(temp);
            }
            return toRet;
        }
    
    /* does borda count method on a 2d array of ints and returns the string that is the name of the winner 
    paramater 1: mat: a 2d array representing all of the votes.
    parameter 2: names, an array of strings containing all of the options in the mat array
    */
    public static String bordaCount(int [][] mat, String [] names){
        // counter array will hold the sums of each column
        int [] counterArray = new int [names.length];
        // convert mat to a list
        ArrayList <ArrayList <Integer>> votes = convertToList(mat);
        for(int c = 0; c < mat[0].length; c++){
            int colSum = 0;
            for (int r = 0; r < mat.length; r++){
                colSum = colSum + votes.get(r).get(c);
            }
            counterArray[c] = colSum;
        }
        int min = counterArray[0];
        int savedIndex = 0;
        // now find the column that has the lowest value (aka it should win bc more people voted it as #1/#2 etc)
        for(int i = 0; i < counterArray.length; i++){
            if (counterArray[i] < min){
                min = counterArray[i];
                savedIndex = i;
            }
        }
        // becasue the indexes of counter array each correspond to a name in the names array, returning names[savedIndex returns the name of the song that should win
        return names[savedIndex];
    }
    //paramater 1: mat: a 2d array representing all of the votes.
    //parameter 2: names, an array of strings containing all of the options in the mat array


            // Ranked choice
        /* 
        1. Look at only first choices and see if one hit the majority threshold (majority threshold = # ballots (rows) + 1/ 2), if they hit
        the majority then you can be done/ there doesn't need to be a new winner
        2. If there is no majority, winner, find the option with the least number of first choice votes(least frequency)
        3. Which first choice candidate has the least 1st-choice votes
        4. delete all occurences of the worst one (appears least)
        !!!!! do it again !!!!! */
    public static String instantRunoff (int [][] mat, String [] names){
        int majorityThreshold = (mat.length + 1)/2;
        ArrayList <ArrayList <Integer>> ballots = convertToList(mat);
        /* this will hold the amount of votes in a particular rank (first place, etc.) for each element of the different options from names. 
        */
        int [] counterList = new int [names.length];
        boolean shouldIContinue= true;
        while (shouldIContinue){
            for(int r = 0; r < ballots.size(); r++){
                ArrayList <Integer> holderArray= ballots.get(r);
                int holderIndex = holderArray.get((int) 0);
                //updating counterList each time to hold the amount of occurences of each element
                counterList[holderIndex] = counterList[holderIndex] + 1;
            }
            // go through counterlist to see if any songs have reached the majority threshold
            int leastVotes = counterList[0];
            int indexWithLeastVotes = 0;
            for(int i = 0; i < counterList.length; i++){
                if (counterList[i] > majorityThreshold){
                    return names[i];
                }
                // this loop also keeps track of the element with the least votes so that if no majority threshold was reached, it can be used later
                if(counterList[i] < leastVotes){
                    leastVotes = counterList[i];
                    indexWithLeastVotes = i;
                }
            }
            // if there is no majority, remove the element in the dataset with the least votes
            String leastFrequent = names[indexWithLeastVotes];
            for(int r = ballots.size() - 1; r >= 0; r--){
                for(int c = ballots.get(r).size() - 1; c >= 0; c--){
                    if(ballots.get(r).get(c) == indexWithLeastVotes){
                        ballots.get(r).remove(c);
                    }
                }
            }
        }
        return "";
    }
}