import java.util.Arrays;
public class OurList{
    public String dataType = "String";
    private String[] mainArray =  new String[5];
    private int logicalSize = 0;

    public boolean add(String s){
        //check if there is space in main array 
            //if NOT need to create new array
                //create new arre of size 1.5 * mainArray.length
                //copy values from mainArray to newArray
                //reassign mainArray pointer
        if(logicalSize == mainArray.length){
            String [] subArray = new String[(int)(1.5*this.logicalSize)];
            for(int i=0; i<mainArray.length; i++){
                subArray[i] = mainArray[i];
            }
            mainArray = subArray;
        }

        //add s to end of main array
        //increment logicalSize
        //return boolean true indiciating I have successfully added
        mainArray[logicalSize] = s;
        logicalSize++;
        System.out.println(logicalSize);
        return true;
    }

    public String remove(int index){
        //create variable to store what object is being removed before array is altered
        String remove = mainArray[index];

        //create loop start from where u removed the element to move every element over
            //index into array at the point which the index is at
            //move over each element after the one removed
        for(int i=index; i<mainArray.length-1; i++){
            //if the following element to the one that is about to be altered = null then set current element = null
            if(mainArray[i+1] == null){
                mainArray[i] = null;
                break;
            //if the following element to the one that is about to be altered is the end of the array, set current element = to end element and end element = to null
            } else if(i+1 == mainArray.length-1){
                mainArray[i] = mainArray[i+1];
                mainArray[i+1] = null;
                //stop loop bc know you are at end of array
                break;
            //general portion of for loop to set current element = to following element
            } else {
            mainArray[i] = mainArray[i+1];
            }
        }
        //return string removed from array
        //reduce logical size by 1
        logicalSize--;
        return remove;
    }

    public int size(){
       return logicalSize; 
    }

}