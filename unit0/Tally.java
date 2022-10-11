import java.util.*;

public class Tally{

private String name;
private static int numItems = 0; 
private int[] ranks; 
private int sumRanks;
private int votes;
private static int totalVotes;

//some of these instance variables are not used, I was going to use them for additional methods, edge cases, etc. but ran out of time. 
//Will add this to the long list of things I will do if I ever come back to modify this


public Tally (String name, int numOptions){

this.name = name; 
ranks = new int[numOptions];
numItems++;

}

public int getNumRank(int place){

    return ranks[place];
}

public String toString(){

String toString = name + Arrays.toString(ranks);

return toString;

}

public void raiseTally(int i){

    ranks[i] ++;
   sumRanks += (i+1);
   votes ++;
   totalVotes++;
}

public int getSumRanks(){

    return sumRanks;
}


public String getName(){

return name;

}

public int getTotalVotes(){

return totalVotes;

}


public int getVotes(){

return votes;

}


}