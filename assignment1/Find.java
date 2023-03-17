/** Assignment 1 - Winter 2021
  * <p>
  * Problem 1
  * <p>
  * In the provided Find.java file, complete the locateSequence method. 
  * For a given target sequence (non-empty array of integers), the method 
  * searches the input array (of integers) to find an occurrence of the 
  * target sequence if it is present. If the sequence is present, the 
  * method returns the array index position of where it starts in the array. 
  * If the sequence is not present, the method returns -1.
  */
public class Find{
  
  /** Finds the last occurrence of the sequence in the array or indicates that 
    * the sequence is not present.
    * 
    * @param sequence is an array of one or more integers. 
    *        It is the target sequence we are looking for.
    * 
    * @param array is an array integers. 
    * 
    * @return the starting position of the last occurrence of the target sequence in the 
    *         array if it exists. Returns -1 otherwise.
    */
  public static int[] array = {1,2,3,1,2,4,1};
  public static int[] sequence ={1,2,3};
  //create locate sequence method
  public static int locateSequence(int[] sequence, int[] array){
    //create match to see if sequence matches
    boolean match = false;
    //set occurrence to default value if no matches
    int occurrence = -1;
    //create case if target longer than array
     if (sequence.length >array.length){
     return occurrence;
    }
    //iterate iterate through array
    for (int i = 0; i < array.length -sequence.length+1; i++){
      //iterate through seqience
      for (int j = 0; j < sequence.length; j++){
        //check sequence with array to see if its is match
          if(array [i+j] == sequence [j]){
            match = true;
          }else{
            match = false;
            break;
          }
        
      }
      //if match set occurrence to index
    if (match == true){
          occurrence = i;
          match = false;
        }
    
    }
    return occurrence;
  }
    public static void main(String[] args){
        locateSequence( sequence,array);
    }

}