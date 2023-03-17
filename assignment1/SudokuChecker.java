
/** Assignment 1 - Winter 2021
  * <p>
  * Problem 3
  * <p> 
  * In this problem, you will complete three methods to check if a SUDOKU game is valid or not.
  */
public class SudokuChecker{
   

  	/** checks if row 'row' is OK in the grid */	
    public static boolean checkRow(int row, byte[][] grid){
        //iterate through first 8 in row
        for(int i = 0; i < 8; i++){
          //iterate off the first value and check for matching values
          for (int j= i+1; j <9;j++){
            //if match return false
            if(grid[row][i]==grid[row][j]){
              return false;
            }
          }
          }
          return true;
        }
      

  	/** checks if column 'col' is OK in the grid */
    public static boolean checkColumn(int col, byte[][] grid){
      //iterate through first 9 in row
      for(int i = 0; i <9; i++){
        //oterate off the first value and check for matching values
        for(int j = i+1; j<8;j++){
          //if match return false
          if(grid[i][col]==grid[j][col]||grid[i][col]<1||grid[i][col]>9){
              return false;
        }
      }
     
      }
    return true;
    }
  	/** checks if the subregion 'region' is OK in the grid */
    public static boolean checkSubregion(int region, byte[][] grid){
      //set the rough row and final column value
      int subRow = 0;
      int subCol = 0;
    //use switch case as not allowed to use floor
    //use modulous to dividds the 9 region values into the 3 row values needed
    switch (region/3){
    
      case 1:
       subRow = 0;
        break;
      case 2:
        subRow = 3;
        break;
      case 3:
        subRow = 6;
        break;
      default:
        subrow = region/3
        
    }

    switch ((region)%3){
      case 0:
        subCol=0;
        break;
      case 1:
        subCol = 3;
        break;
      case 2:
        subCol =6;
        break;
  
    }
      
      // iterate through subregion by sub region
      for (int pos1 =0; pos1<3;pos1++){
        for (int pos2 =pos1+1; pos2<4;pos2++){
          //compare the values
          if (grid[subRow+pos1%3][subCol+pos1/3]==grid[subRow+pos2%3][subCol +pos2/3]){
            return false;
          }
        }
      }
        
      
      return true;
    }



    
    public static boolean check(byte[][] grid){
      // check the subregions
      for(int subregion=0; subregion<9; subregion++){  
        if( !checkSubregion(subregion, grid) ){
          return false;
        }
      }

      // check the rows
      for(int row=0; row<9; row++){                    
        if( !checkRow(row, grid) ){
          return false;
        }
      }

     // check the rows
     for(int col=0; col<9; col++){                    
        if( !checkColumn(col, grid) ){
          return false;
        }
      }
    
  		
  		// if we get this far then we conclude that the grid
  		// must be valid (because if it was not, we would have
  		// returned false somewhere above)
      return true;
    }
      


    public static void main(String[] args){

      System.out.print("example1 | expected output is true  | actual output is ");
      System.out.println(check(example1));

      System.out.print("example2 | expected output is false | actual output is ");
      System.out.println(check(example2));

    }


      /** sample valid game */
    public static byte[][] example1 = new byte[][]{
      {5,3,4,6,7,8,9,1,2},
      {6,7,2,1,9,5,3,4,8},
      {1,9,8,3,4,2,5,6,7},
      {8,5,9,7,6,1,4,2,3},
      {4,2,6,8,5,3,7,9,1},
      {7,1,3,9,2,4,8,5,6},
      {9,6,1,5,3,7,2,8,4},
      {2,8,7,4,1,9,6,3,5},
      {3,4,5,2,8,6,1,7,9}};

    /** sample invalid game */
    public static byte[][] example2 = new byte[][]{
      {5,3,4,6,7,8,9,1,2},
      {6,7,2,1,9,5,3,4,8},
      {1,9,8,3,4,2,5,6,7},
      {8,5,9,7,6,1,4,2,3},
      {4,2,6,8,5,3,7,9,1},
      {7,1,3,9,2,4,8,5,6},
      {9,6,1,5,3,7,2,8,3},
      {2,8,7,4,1,9,6,2,6},
      {3,4,5,2,8,6,1,8,8}};

  }