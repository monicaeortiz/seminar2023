import java.util.*;

public class Tally{

private String name;
private static int numItems = 0; 
private int[] ranks; 
private int sumRanks;
private int votes;
private static int totalVotes;


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