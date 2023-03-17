import java.io.File;   
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.FileWriter; 
import java.io.*;
import java.util.*;
import java.util.ArrayList;

public class BST extends BinaryTree{

	// You MUST have a zero argument constructor that
	// creates an empty binary search tree
	// You can can add code to this if you want (or leave it alone).
  // We will create all BSTs for testing using this constructor 
  Stack<String> stack ;
  private String [] prtArr;
  private int prtCount;
  private Node[] balArr;
  private int balCount;
  public BST(){}
  /**Determines if string is in tree iteratively
	*@param target string to be found
	*@return true if found false if not
    */

  @Override
  public boolean contains(String s){
    return contHelper(root, s);
  }
  public boolean contHelper(Node Root,String s){

    while(Root != null){
      if(Root.getData().compareTo(s) == 0){
         return true;
        }
      if(Root.getData().compareTo(s) == 1){
        Root = Root.left;
      }else{
        Root= Root.right;
      }
    }
    return false;
  }
  

/**Adds node so it stays as a bst
	*@param s string  value of node to be added
    */

  @Override
  public void add(String s){
    this.root = addHelper(root,s);
  }
  /**Helper method for Add()
  *@param root node that will be compared to "s" value to determine placement(pointer)
	*@param s string value of node to be added
    */
  public Node addHelper(Node Root, String s){
    //base case
    if (Root == null)
        {
          //return new node if it is found to be a valid spot
          Root = new Node(s);
          return Root;
        }
         // compare s to current node if current is greater go to node to the left
        if (Root.getData().compareTo(s) == 1){
            Root.left = addHelper(Root.left, s);
        }
        // compare D to current node if current is lesser go to node to the left
        else if (Root.getData().compareTo(s) == -1){
            Root.right = addHelper(Root.right, s);
          } 
      return Root;
    }


  /**Balances the current BST
  *@return returns the balanced BSt
    */
  public BST makeBalanced(){
    //create new bst object
    BST returnBST = new BST();
    //create array to copy bst to
    balArr = new Node[size];
    //counter to use to fill up the array
    balCount = 0;
    fillBal(this.root);
     for(int i = 0; i < balArr.length; i++){
        System.out.println(balArr[i].getData());
        }
    returnBST.root = balanceHelper(balArr,0,this.size);
    return returnBST;
  }
  
  /**recurrs through a bst and fills array with the bst values inorder
	*@param Root node that is being checked
    */
  public void fillBal(Node Root){
    if(Root != null){
      fillBal(Root.left);
        balArr[balCount] = Root;
        balCount += 1;
      fillBal(Root.right); 
    }
    
  }
  /**iterates through the array and creates a balanced BST
	*@param arr sorted array
  *@param start "start" of indexs for a section of the tree
  *@param end "end" of indexs for a section of the tree
    */
  public Node balanceHelper(Node[] arr, int start, int end){
    //base case
    if(start > end){
      return null;
    }
    //establish middle to find root in array
    int mid = start +(end-start)/2;
    // create root of tree
    Node Root = new Node(arr[mid].getData());
    // recurr to left and right of tree to fill
    Root.left=balanceHelper(arr,start,mid-1);
    Root.right=balanceHelper(arr,mid+1,end);
    return Root;
  }
  /**writes a bst to a file
	*@param fname name of file bst will be written to
    */

  public boolean saveToFile(String fname){
    //create counter for indexing nodes
    prtCount = 1;
    //create array to copy bts to
    prtArr = new String[this.size];
    //set root
    prtArr[0]= root.getData();

    fillInt(this.root);
    fillLeaf(this.root);
    
    PrintWriter printWriter = null;
    try{
        printWriter = new PrintWriter(fname); 
        //iterate through array
        for(int i = 0; i < this.size; i++){
        printWriter.print(prtArr[i]+"\n");
        }
        printWriter.close();
        return true;

  }catch(IOException e){
     System.out.println("An error occured");
      printWriter.close();
      return false;
     }
  }
  /**fills up array with only internal nodes using recursion
	*@param root current node being checked
    */
  public void fillInt(Node Root){
     if(Root != null){
      fillInt(Root.left);
      if ((!isLeaf(Root))&& prtArr[0].compareTo(Root.getData()) !=0 ){
        prtArr[prtCount] = Root.getData();
        prtCount += 1;
      }
      fillInt(Root.right); 
    }
    }
     /**fills up array with only leaf nodes using recursion
	*@param root current node being checked
    */
  public void fillLeaf(Node Root){
     if(Root != null){
      fillLeaf(Root.left);
      if (isLeaf(Root)){
      prtArr[prtCount] = Root.getData();
      prtCount += 1;
      }
      fillLeaf(Root.right); 
    }
    }
  public boolean isLeaf(Node Root){
    return Root.getLeft() == null && Root.getRight() == null;
  }
  
  public void loadFromFile(String fname){
		BinaryTree bt = new BST();
		try{
			Scanner file = new Scanner( new File(fname) );
			while( file.hasNextLine()){
				bt.add(file.nextLine().strip());
			}
		}catch(Exception e){
			System.out.println("Something went wrong!!");
		}
		this.root = bt.root;
		this.size = bt.size;
	}

}
