import java.util.*;
public class MelinaKathrynMethods{
   public String dataType = "String";
   public String [] mainArray = new String[5];
   private int logicalSize = 0;


public static void main (String[] args){
 
MelinaKathrynGetMethod list = new MelinaKathrynGetMethod();
 
list.add("rat");
list.add("bat");
list.add("cat");
list.add("sat");
list.add("gnat");
list.add("pat");
list.add("at");
 
System.out.println(Arrays.toString(list.mainArray));
 
System.out.println(list.get(0));
 
System.out.println(list.get(6));
 
System.out.println(list.indexOf("at"));
 
System.out.println(list.indexOf("rat"));
 
System.out.println(list.indexOf("not in array"));
 
}
  
public String get (int i){
 
return mainArray[i]; //will have an out of bounds error if i is too large
   
}
 
public int indexOf (String s){
 
for (int i = 0; i < mainArray.length; i++){
  
   if (mainArray[i].equals(s)){
 
       return i;
   }
   
}
 
return -1;
 
}
 
 

 
public boolean add (String s){
       // if there is space in mainArray, do this stuff
       if (logicalSize < mainArray.length){
 
            mainArray[logicalSize] = s;
 
       }
else{//no space in main array
 
       String [] holderArray = new String[(int) (mainArray.length * 1.5)];
       for(int i = 0; i < mainArray.length; i++){
               holderArray[i] = mainArray[i];
        
           }
           holderArray[mainArray.length] = s;
           mainArray = holderArray;
 
}
   logicalSize++;
     return true;
  
 
}
}