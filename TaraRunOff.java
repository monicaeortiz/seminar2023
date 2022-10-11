import java.util.*;
public class TaraRunOff {


public static void main(String[] args) {
    //main method with test array
    // A should be the winner
        String[][] arrr = new String[][] {  {"A", "B", "C"},
        {"A", "B", "C"},
        {"B", "A", "C"},
        {"B", "A", "C"}
    }; 
    
    
    // calls the method that converts the inputted 2d array into an arraylist of arraylists
        ArrayList<ArrayList<String>>listt = arrToAL(arrr);
        TaraRunOff ir = new TaraRunOff();
        // runs the instant runoff method
        ir.instantRunoff(listt);
    

    }

    // method that converts the inputted 2d array into an array list of array lists
    public static ArrayList<ArrayList<String>> arrToAL (String[][] ballots) {
        // initializes a new arraylist
        ArrayList<ArrayList<String>> arr = new ArrayList<ArrayList<String>>();
        // iterates trhorugh the original array
        for (int i = 0; i<ballots.length; i++) {
         ArrayList<String> row = new ArrayList<String>();
            for (int j= 0; j<ballots[i].length; j++) {
                // adds each value in the array into the array list
                row.add(ballots[i][j]);
            }
         arr.add(row);
     }
     // returns the new arraylist of arraylists
     return arr;
    }

    // creates a class for each candidate w/ name and num of votes
    public class Candidate {
        public String candidateName;
        public int numVotes;

        // constructor method
        Candidate(String candidateName, int numVotes) {
            this.candidateName = candidateName;
            this.numVotes = numVotes;
        }

        public void setCandidateName(String name) {
            candidateName = name;
        }

        public void addVotes () {
            numVotes += 1;
        }

        public String getCandidateName() {
            return candidateName;
        }

        public int getVotes() {
            return numVotes;
        }

        // use this to reset the number of votes to 0 each time a candidate is eliminated
        public void setVotes() {
            numVotes = 0;
        }
    }

    
    // the actual method for instant runoff
      public void instantRunoff(ArrayList<ArrayList<String>> list) {
        // number of voters (aka rows)
        int numVoters = list.size();
        // number of candidates (aka columns)
        int numCandidates = list.get(0).size();
        
        // creates new array with all possible candidate objects (includes name and for now sets number of votes equal to 0)
        Candidate[] info = new Candidate[numCandidates];
        for (int j = 0; j<numCandidates; j++) {
            info[j] = new Candidate(list.get(0).get(j), 0); 
        }

        // adds votes for each candidate in the first column (first choice candidates)
        for (int i = 0; i<numVoters; i++) {
            for(int g = 0; g<info.length; g++) {
                if (list.get(i).get(0).equals(info[g].getCandidateName())) {
                    info[g].addVotes();
                  
            }
        }  
        }
      
       // creates boolean that is false until there is a majority
        boolean majority = false;
        // keeps track of the lowest number of votes
        int tempVotes = info[0].getVotes();
        // keeps track of the candidate w the lowest num votes 
        String lowestCandidate =  info[0].getCandidateName();
        // keeps track of how many candidates have been eliminated
        int numDroppedCands = 0;
       
        // keeps track of the index of the lowest scoring candidate
        int lowestIndex = 0;

        // while loop that runs while there is no majority or all but 1 have been eliminated
        while (majority == false) {
        for (int m = 0; m<info.length; m++) {
            // checks if the first candidate that appears in the first column has a majority
            if (tempVotes>numVoters/2) {
                System.out.println(lowestCandidate + " is the winner!");
                majority = true;
                // exits the entire loop and ends run of program
                System.exit(0);
            }
            // if no majority if the first candidate that appears is less than the current least amount of votes and it has not been eliminated
            // assigns the lowest vote to the current candidate
            else if (info[m].getVotes()<tempVotes && info[m].getCandidateName()!="") {
                tempVotes = info[m].getVotes();
                lowestCandidate = info[m].getCandidateName();
                lowestIndex = m;
            }
        }

        // eliminates all instances of the lowest candidate in the origianl list of votes by setting them to ""
        for (int k = 0; k<list.size(); k++) {
            for (int l = 0; l<list.get(0).size(); l++) {
                if (list.get(k).get(l).equals(lowestCandidate)) {
                    list.get(k).set(l, "");
                    info[lowestIndex].setCandidateName("");
                }
            }   
        }
       
        // num of dropped candidates increases by 1
        numDroppedCands+=1;

        // if all but one candidates have been dropped, then the reamining candidate wins
        if (numDroppedCands==list.size()-1) {
            for (int d = 0; d<info.length; d++) {
                if(info[d].getCandidateName()!="") {
                    System.out.println(info[d].getCandidateName() + " is the winner!");
                    majority = true;
                    System.exit(0);
                }
            }
        }

    // resets votes to zero for each candidate after each run down the column
        for (int i = 0; i<numVoters; i++) {
            for(int g = 0; g<info.length; g++) {
                info[g].setVotes();
                // only adds votes if the candidate has not been eliminated
                if (list.get(i).get(0).equals(info[g].getCandidateName()) && list.get(i).get(0) != "") {
                    info[g].addVotes();
                
                
            }
        }  
        }

        }

    }
    
}
        
