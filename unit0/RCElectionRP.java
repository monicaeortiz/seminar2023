//Robyn O'Connor and Patricia Von Oiste (worked on code together)
import java.util.*;

public class RCElectionRP {
    public static void main(String[] args){
        int[][] votesTest = {{3, 4, 2, 1},
            {3, 1, 4, 2},
            {1, 4, 2, 3},
            {3, 2, 1, 4},
            {2, 1, 3, 4},
            {2, 1, 3, 4},
            {1, 4, 2, 3},
            {2, 3, 1, 4},
            {1, 3, 2, 4}};
        String[] choicesTest = {"You Belong With Me", "All Too Well (10 Minute Version)", "Love Story", "Fifteen"};
        ArrayList<String> choicesTest2 = new ArrayList<String>(Arrays.asList("You Belong With Me", "All Too Well (10 Minute Version)", "Love Story", "Fifteen"));
        String[][] votesTest2 =  {
            {"You Belong With Me", "Love Story", "Fifteen", "All Too Well (10 Minute Version)"},
            {"Love Story", "You Belong With Me", "All Too Well (10 Minute Version)", "Fifteen"}, 
            {"Fifteen", "You Belong With Me", "Love Story", "All Too Well (10 Minute Version)"}
        }; 
        System.out.println(BordaCount(votesTest, choicesTest));
        System.out.println(InstantRunoff(votesTest2, choicesTest2)); 
    }

    public static String BordaCount(int[][] votes, String[] choices){
       //initialize an array that will contain all the counts of each individual column (same length as the first element in votes)
        int[] counts = new int[votes[0].length];

        //iterate through the 2D matrix votes using double for loop
        for(int i = 0; i<votes.length;i++){
            for(int j = 0; j<votes[0].length; j++){
                //increment counts to contain the sum of each column
                counts[j] += votes[i][j];
            }
        }

        //determine which value in the array 'counts' is the lowest
            //set temporary values for min and index as 0 and the first index
        int min = counts[0];
        int index = 0;
        for(int k = 0; k<counts.length;k++){
            if(counts[k]<min){
                min = counts[k];
                index = k;
            }
        }
        //return corresponding index to choices based on the minimum values, from string array
        System.out.println(Arrays.toString(counts));
        return choices[index];
    }

    public static String InstantRunoff(String[][] votesArr, ArrayList<String> choices) {
        ArrayList<ArrayList<String>> votes = convert(votesArr); 
        boolean notReachedMajority = true; 
        String winner = ""; 
        while (notReachedMajority == true) {
            ArrayList<Integer> counter = new ArrayList<Integer>(); //will hold many first choice votes for each song
            for (int i=0; i<choices.size(); i++) {
                counter.add(0); 
            }
            for (int j=0; j<votes.size(); j++) {
                String temp = votes.get(j).get(0); //pulls every value from first column, setting it equal to temp 
                int index = choices.indexOf(temp);
                counter.set(index, counter.get(index)+1); //finds index of temp (ex. Fifteen is index 3 in choices); increments the num at that index in the counter array
            }
            int min = counter.get(0); 
            String minCand = choices.get(0); 
            for (int x = 0; x<counter.size(); x++) {
                if (counter.get(x) >= (votes.size()/2 + 1)) {
                    winner = choices.get(x); 
                    return winner; 
                }
                else {
                    if (counter.get(x)< min) {
                        min = counter.get(x); //for when there is no majority first place, determines which candidate got the least votes in the first column 
                        minCand = choices.get(x); 
                    }
                }
            }
            // Remove all occurrences of minCand from each ballot, which is each AL in the larger AL.
            for (int y=0; y<votes.size(); y++) {
                votes.get(y).remove(minCand); //removes lowest candidates
            }
            counter.remove(choices.indexOf(minCand)); //removes the index of lowest candidate
            choices.remove(minCand);
        }  
        return ""; 
    }
    
    public static int[][] ballotsToRankings(String[][] ballots, ArrayList<String> candidates){
        int[][] rankings = new int[ballots.length][ballots[0].length];
        for(int i = 0; i<ballots.length; i++){
            for(int j = 0; j<ballots[0].length; j++){
                //iterate through the ballots array
                String current = ballots[i][j];
                //find the index of the current value in the ballots array in the candidates array
                int index = candidates.indexOf(current);
                rankings[i][j] = index + 1;
            }
        }
        return rankings;
    }
    
    public static String[][] rankingsToBallots(int[][] rankings, ArrayList<String> candidates){
        String[][] ballots = new String[rankings.length][rankings[0].length];
        for(int i = 0; i<rankings.length; i++){
            for(int j = 0; j<rankings[0].length; j++){
                int current = rankings[i][j];
                ballots[i][j] = candidates.get(current-1);
            }
        }
        return ballots;
    }
   
    public static ArrayList<ArrayList<String>> convert(String[][] votes){
        //use a for loop to iterate through rows of 2d array
        ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
        for(int i = 0; i<votes.length;i++){
            //make a new AL for the row called 'temp'
            ArrayList <String> temp = new ArrayList <String>();
            for(int j = 0; j<votes[0].length;j++){
                 //loop through this row of the array (add every single element of new ArrayList row)
                temp.add(votes[i][j]);

            }
            //add completed AL consisting of values in row 'temp' to final arrayList 'list'
            list.add(temp);
        }
        return list;
    }
}

//TO DO:
//* check if convert works 
//* check if InstantRunoff works
    //* what if no one votes for D as first place? Remove all D's? or remove all C's?

 //TEST: 
            //one simple case 
            //one where you know Borda Count would win (Borda and IR produce different winners)
            //tie 


//Instant RunOff pseudocode 
        //convert 
        //data represents song at each ranking
        //look at the first ranking for every ballot looking at the first column (index 0 in each sub array)
        //see if any vote has a majority threshold (number of ballots+1)/2
            //if yes, then break
        //no majority winner, find the option with least number of votes

        //which 1st choice candidate has the lesat 1st choice and votes

        //delete all occurances of least choice

        //go back to beginning in while loop (not incrementing any counter variable, repeat process while you have not used the majority)