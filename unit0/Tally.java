import java.util.*;

public class Tally{

public String name;
public static int numItems = 0; 
int[] ranks; 
public int sum;


public Tally (String name, int numOptions){

this.name = name; 
ranks = new int[numOptions];

}

public int getNumRank(int place){

    return ranks[place-1];
}

public String toString(){

String toString = name + Arrays.toString(ranks);

return toString;

}

public void raiseTally(int i){

    ranks[i] ++;
}



// public Tally get(String name){

//     return 


// }
}