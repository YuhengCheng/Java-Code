/** Assignment 1 - Winter 2021
  * <p>
  * Problem 2
  * <p>
  * The method returns an array of integers with size at least 1. The first value in the output array
  *is number of occurrences of the target in the array. This number may be zero or greater. If the
  *number of occurrences is n, then the next n values in the output array are the n starting positions
  *of these n occurrences
  */ 
//create FindAgain class
public class FindAgain{
    //create array
    public static int[] array = {1,2,3,1,2,4,1};
    //create sequence
    public static int[] sequence ={1,2};
    //create locateAllSequenceLocations method
    public static int[] locateAllSequenceLocations(int[] target, int[] array){
        //create match var to signal match
        boolean match = false;
        //craete counter for num of occurrecne
        int numOccurrence = 0;
        // create a temporary array which will be too big
        int[] draftLocation = new int[array.length -target.length+1];
        // check if array is longer than target
        if (array.length >= target.length){
        // iterate through the array
        for (int i = 0; i < array.length -target.length+1; i++){
            //iterate through the target
            for (int j = 0; j < target.length; j++){
                //check if values match
                if(array [i+j] == target[j]){
                    match = true;
                }else {
                    match = false;
                    break;
                }
                
            }
        //if matching update the temporary array with index
        if (match == true){
            numOccurrence += 1;
            draftLocation[numOccurrence] = i;
            match = false;
            }
        }
        //set 1st value as the # of occurrence
        draftLocation[0] = numOccurrence;
        //create return array
        int[] location = new int[numOccurrence+1];
        //fill return array
        for (int j = 0; j<numOccurrence+1;j++){
            location[j] = draftLocation[j];


        }
        return location;
        //return 0 if target length >array length
        }else{
            int[] misMatch ={0};
            return misMatch;
        }


    }


public static void main(String[] args){
        locateAllSequenceLocations( sequence,array);
        
    }


}