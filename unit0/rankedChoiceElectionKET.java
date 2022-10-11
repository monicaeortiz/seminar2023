import java.util.ArrayList;
import java.util.Arrays;

public class rankedChoiceElectionKET {

    /* needed in overall class --> 
    votes/ballots --> matrix where rows are ballots and cols are options/rankings
     - arraylist or array of arraylists (for instance runoff, want to be apple to remove options)
    */

    public static void main(String[] args){
        //initial tests
            //borda count
        //array of arraylists; 4 canidates
        int[][] arr = {
                        {3, 4, 2, 1}, //
                        {3, 1, 4, 2},
                        {1, 4, 2, 3}
                        // {3, 2, 1, 4},
                        // {2, 1, 3, 4},
                        // {2, 1, 3, 4},
                        // {1, 4, 2, 3},
                        // {2, 3, 1, 4},
                        // {1, 3, 2, 4}
                    };

        String[] names = {"you belong with me", "all too wel", "love story", "fifteen"};

        ArrayList<ArrayList<Integer>> votes = arrToAL(arr);
        System.out.print(votes);

        System.out.println(bordaCount(votes, names));
            //instant runoff
        
        String[][] rank = {
                        {"A", "B", "C"},
                        {"B", "C", "A"},
                        {"A", "C", "B"}
                        };

        ArrayList<String> letters = new ArrayList<>(Arrays.asList("A", "B", "C"));

        ArrayList<ArrayList<String>> rankings = arrToALStrings(rank);
        System.out.print(rankings);

        System.out.println(instantRunOff(rankings, letters));
        

       String[] lettersBC = {"A", "B", "C"};

        //tests --> 
            //#1 (both have same winner) --> C is winner for instant runoff, C would win for borda count
        
        String[][] forBothIR = {
                    {"B", "C", "A"},
                    {"A", "C", "B"},
                    {"C", "A", "B"},
                    {"C", "B", "A"}
                    };
        
        //borda count --> (didnt have time to make conversion method)
        int[][] forBothBC = {
            {2, 3, 1},
            {1, 3, 2},
            {3, 1, 2},
            {3, 2, 1}
        };

        ArrayList<ArrayList<Integer>> forBothBCAL = arrToAL(forBothBC);
        System.out.print(forBothBCAL);

        System.out.println(bordaCount(forBothBCAL, lettersBC));

        
        //instant runoff --> 
        ArrayList<ArrayList<String>> forBothIRAL = arrToALStrings(forBothIR);
        System.out.print(forBothIRAL);

        System.out.println(instantRunOff(forBothIRAL, letters));

            //#2 -->A would win for instant runoff, B for borda count
                     
                //A would win immediately (without any elimination)

        String[][] test2IR = {
                    {"A", "B", "C"},
                    {"A", "B", "C"},
                    {"B", "C", "A"},
                    {"B", "C", "A"},
                    {"A", "C", "B"}
                    };
        
        //borda count --> (didnt have time to make conversion method)
        int[][] test2BC = {
            {1, 2, 3},
            {1, 2, 3},
            {2, 3, 1},
            {2, 3, 1},
            {1, 3, 2}
        };

        ArrayList<ArrayList<Integer>> test2BCAL = arrToAL(test2BC);
        System.out.print(test2BCAL);

        System.out.println(bordaCount(test2BCAL, lettersBC));

        
        //instant runoff --> 
        ArrayList<ArrayList<String>> test2IRAL = arrToALStrings(test2IR);
        System.out.print(test2IRAL);

        System.out.println(instantRunOff(test2IRAL, letters));

            //B would win for instant Runoff, requires elimination step
        
        String[][] test2BIR = {
                            {"A", "C", "B"},
                            {"C", "B", "A"},
                            {"B", "C", "A"},
                            {"A", "B", "C"},
                            {"B", "C", "A"}
                            };

        //borda count --> (didnt have time to make conversion method)
        int[][] test2BBC = {
            {1, 3, 2},
            {3, 2, 1},
            {2, 3, 1},
            {1, 2, 3},
            {2, 3, 1}
        };

        ArrayList<ArrayList<Integer>> test2BBCAL = arrToAL(test2BBC);
        System.out.print(test2BBCAL);

        System.out.println(bordaCount(test2BBCAL, lettersBC));

        
        //instant runoff --> 
        ArrayList<ArrayList<String>> test2BIRAL = arrToALStrings(test2BIR);
        System.out.print(test2BIRAL);

        System.out.println(instantRunOff(test2BIRAL, letters));        

            //#3 --> tie
        
        String[][] tieIR = {
                    {"A", "B", "C"},
                    {"A", "B", "C"},
                    {"B", "A", "C"},
                    {"B", "A", "C"}
                    };
    
        //borda count --> (didnt have time to make conversion method)
        int[][] tieBC = {
            {1, 2, 3},
            {1, 2, 3},
            {2, 1, 3},
            {2, 1, 3}
        };

        ArrayList<ArrayList<Integer>> tieBCAL = arrToAL(tieBC);
        System.out.print(tieBCAL);

        System.out.println(bordaCount(tieBCAL, lettersBC));

        
        //instant runoff --> 
        ArrayList<ArrayList<String>> tieIRAL = arrToALStrings(tieIR);
        System.out.print(tieIRAL);

        System.out.println(instantRunOff(tieIRAL, letters));


    }
    //int lowest_count = 0;
    //rows = votes from person
    //cols = songs

    /* borda count --> 
    variables --> 
    - least count variable (to comparte the candiate totals to)
    
    iterations --> 
    - for loop to get all the values
        - once all values of a column are tallyed, compare to the least count variable (if less, becomes new variable)

    - returns the canidate with lowest total
    */

    public static String bordaCount(ArrayList<ArrayList<Integer>> votes, String[] canidates ){
        int[] totals = new int[votes.get(0).size()];
 
        //totals that stores the total borda count for each canidate
        //for loop going through votes array, then into arraylist to get totals at each index
            //add votes[i].get(j) to totals[j]
        for(int i = 0; i<votes.size(); i++){ 
            for(int j = 0; j<votes.get(i).size(); j++){
                totals[j] += votes.get(i).get(j);
            }
        }
        //test with the totals
        System.out.println(Arrays.toString(totals));
        //sets starting lowest total
        int lowestTotal = totals[0];
        //starting index of lowest total
        int index = 0;
        //looping through totals to find lowest total
        for(int i = 0; i<totals.length; i++){
            //comparisons
            if(totals[i] < lowestTotal){
                //resets lowest total
                lowestTotal = totals[i];
                //resets index
                index = i; 
                //testing index
                System.out.println(index);
            }

        }
        //returns index of the candidate/list
        return canidates[index];
    }

    /* instance runoff --> 
    variables --> 
    - lowest count variable
    - compare canidate --> the canidate with the lowest tally
    
    iterations --> 
    - for loop that compares all canidates to that compare canidate

    returns canidate with lowest total

    */

    /*
    1. first choices --> index at 0, first column
    2. wnat to know if one choice has majority; what is majority threshold
    - (num of ballots + 1)/2
    - if found, stop and return
    3. if no majority winner --> which first choice canidate has the LEAST first-choice votes
    4. delete all occurances 
    5. while loop back to the beginning 
    - to get out of loop:
        - break or return

    if tie, random pick
    allowed to assume there is no missing data

    String[][] --> ArrayList<ArrayList<String>>
    - for loop over the rows of original
    - make new arraylist for the row
    - loop through this row of the array 
        - add the completed row AL to my final AL<AL<String>>
    */

    //remove from rankings and candidates(maybe current candidates)
     
    public static String instantRunOff(ArrayList<ArrayList<String>> rankings, ArrayList<String> canidates){
        int majorityTheshold = (rankings.size()/2) +1;
        
        boolean notReach = true;
        String winner = "";
        while(notReach == true){
        //array holding how many times each canidate is said
        int[] count = new int[canidates.size()];
        //set initial canidate with occuring least
        int least = count[0];
        //canidate least occuring (default)
        String leastCanidate = "";
            for(int i = 0; i<rankings.get(i).size(); i++){
                //temp variable for canidate said to compare to canidate list; gets canidate in first column
                String temp = rankings.get(i).get(0); 
                //increments the count of that canidate by 1
                count[canidates.indexOf(temp)]++;
            }
            //compares all values in count
            for(int i = 0; i<canidates.size(); i++){
                if(count[i]>=majorityTheshold){
                    winner += canidates.get(i);
                    notReach = false;
                    break;
                }
                else{
                    if(count[i]<least){
                        //sets the canidate with least votes
                        least = count[i];
                        leastCanidate += canidates.get(i);
                    }
                }
            }
            //nested for loop removing least occuring canidate
            for(int i = 0; i<rankings.size(); i++){
                for(int j = 0; j<rankings.get(i).size(); j++){
                    if(rankings.get(i).get(j).equals(leastCanidate)){
                        rankings.get(i).remove(j);
                    }
                }
            }
            canidates.remove(leastCanidate);
            //break/return out of the while loop
        }
        return winner;
    }   

    /*
    test cases --> 
    1. one simple test case
    2. borda/instant runoff result in different winners
    3. tie edge case

    gitHub  -->
    1. label/describe the test
    2. explain format of test

    */

    //method to convert integer matrixes to arraylist of arraylists of integers
    private static ArrayList<ArrayList<Integer>> arrToAL(int[][] ballots){
        //new overall arraylist created
        ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
        for(int i = 0;i<ballots.length; i++){
            //inside arraylist created to get the elements within ballots
            ArrayList<Integer> row = new ArrayList<Integer>();
            for(int j = 0; j<ballots[i].length; j++){
                row.add(ballots[i][j]);
            }
            //adding smaller arraylists to overall arraylist
            arr.add(row);
        }
        return arr;
    }

    //method to convert String matrixes to arraylist of arraylists of Strings
    private static ArrayList<ArrayList<String>> arrToALStrings(String[][] list){
        //new overall arraylist created
        ArrayList<ArrayList<String>> arr = new ArrayList<ArrayList<String>>();
        for(int i = 0;i<list.length; i++){
            ArrayList<String> row = new ArrayList<String>();
            //inside arraylist created to get the elements within canidates
            for(int j = 0; j<list[i].length; j++){
                row.add(list[i][j]);
            }
            //adding smaller arraylists to overall arraylist
            arr.add(row);
        }
        //returns overall arraylist
        return arr;
    }

}
/*
    public static String instantRunOff(ArrayList<ArrayList<String>> rankings, ArrayList<String> canidates){
        //number of canidates (columns)
        int numCanids = canidates.size();
        String winner = "";


        //creates threshold for what canidate has to reach to win
        int majorityTheshold = (rankings.size()/2) +1;
        //creates boolean that is true until majority
        boolean notReach = true;
        //keeps track of the lowest number of votes (default)
        int tempVotes = rankings.get(0);
        //keeps track of canidate with least votes (default)
        String lowestCand = "";
        //keeps trakc of how many canidates have been eliminated
        int numDroppped = 0;

        //keeps track fo the index of the lowest scoring canidate
        int lowestIndex = 0;

        //while loop runs while majority is true or all but 1 have been eliminated
        while(notReach == true){
            for(int i = 0; i<rankings.size(); i++){
                if(count[i]>=majorityTheshold){
                    winner += canidates.get(i);
                    notReach = false;
                    break;
            }
            for(int i = 0; i<canidates.size(); i++){
                if(count[i]>=majorityTheshold){
                    winner = canidates.get(i);
                    notReach = false;
                    break;
                }
                else{
                    //set initial canidate with occuring least
                    int least = count[0];
                    //compares all values in count
                    if(count[i]<least){
                        //sets the canidate with least votes
                        least = count[i];
                        leastCanidate = canidates.get(i);
                    }
                }
            }
            //nested for loop removing least occuring canidate
            for(int i = 0; i<rankings.size(); i++){
                for(int j = 0; j<rankings.get(i).size(); j++){
                    if(rankings.get(i).get(j).equals(leastCanidate)){
                        rankings.get(i).remove(j);
                    }
                }
            }
            canidates.remove(leastCanidate);
            //break/return out of the while loop
        }
        }
        return winner;
    }  
*/