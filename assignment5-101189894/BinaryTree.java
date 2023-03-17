import java.io.File;   
import java.util.Scanner; 

/**
*The card class represents a Binary Tree
* @author Yuheng Cheng
* @version 1.0
*/
public class BinaryTree {
	protected Node root = null;
    protected int  size = 0;
	private Node prevNode;
	/** Create a Binary Tree with size 0
    */
	public BinaryTree(){
		size = 0;
	}
	/** Create a Binary Tree with size 1 with the given string value
	*@param s is the string data of the Node
	*/
  public BinaryTree(String s){
		root = new Node(s);
		size = 1;
	}
	/** gets size of Tree
	*@return size of Tree
    */
	public int getSize(){ return this.size; }
	/** gets root of node
	*@return root
    */
	public Node getRoot(){ return this.root; }
	
	/**Determines if string is in tree recursively
	*@param target string to be found
	*@return true if found false if not
    */

	public boolean contains(String target){
		Node tempRoot = root;
		if( root == null ){ return false; }
		if( root.getData().equals(target) ){
			return true;
		}
		root = tempRoot.getLeft();
		boolean r1 = this.contains(target);
		root = tempRoot.getRight();
		boolean r2 = this.contains(target);
		root = tempRoot;
		return (r1||r2);
	}

	/**Determines if tree is bst
	*@return true if bst false if not
    */
	public boolean isBST(){
		prevNode = null;
		return bstHelper(this.root);
	}
	/**Help class for is bst
	*recursively checks current node against the "previous node" which is further up the tree to see if it still adheres to the conditions of being a bst
	*@param root node to compare
	*@return true if conditions are not broken false if they are
    */
	public boolean bstHelper(Node Root){
		if (Root != null){
			if (!bstHelper(Root.left)){
				return false;
			}
			if (prevNode != null && Root.getData().compareTo(prevNode.getData())== -1){
				return false;
			}
			prevNode = Root;
			return bstHelper(Root.right);
		}
		return true;
	}
	public void loadFromFile(String fname){
		BinaryTree bt = new BinaryTree();
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

	public void add(String s){
		addRandom(s);
	}

	
	/* add a node in a random place in the tree. */
	private void addRandom(String s){
		if(root == null && size == 0){
			root = new Node(s);
		}else{
		  Node tmp = root;
		  boolean left = Math.random() < 0.5; 
		  Node child = left ? tmp.getLeft() : tmp.getRight();
		  while(child != null){
			tmp = child;
			left = Math.random() < 0.5;
			child = left ? tmp.getLeft() : tmp.getRight();
		  }
		  // assert: child == null
		  // yea! we have a place to add s
		  if(left){
		  	tmp.setLeft(new Node(s));
		  }else{
			  tmp.setRight(new Node(s));
		  }
		}
		size += 1;
	}




	/** Computes the height of the binary tree
	  *
		* The height is the length of the longest path from
		* the root of the tree to any other node.
		*
		* @return the height of the tree
		*/
	public final int height(){
	  if( root == null ){ return -1; }
	  if( size == 1){ return 0; }
	  return heightRecursive(root);
	}
	protected final static int heightRecursive(Node root){
		if( root == null ){
			return -1;
		}
		int leftHeight = heightRecursive(root.getLeft());
		int rightHeight = heightRecursive(root.getRight());
		if( leftHeight < rightHeight){
			return 1 + rightHeight;
		}else{
			return 1 + leftHeight;
		}
	}


	public static void main(String[] args){
		BinaryTree t = new BinaryTree("cat");
		System.out.println("height = " + t.height() + ",  size = " + t.getSize());
		t.add("dog");
		t.add("eel");
		t.add("cow");
		t.add("rat");
		System.out.println("height = " + t.height() + ",  size = " + t.getSize());
		System.out.println(t);

		System.out.println("height = " + t.height() + ",  size = " + t.getSize());
		t.loadFromFile("sample.txt");
		System.out.println(t);


	}
	


	@Override
	public String toString() {
		return PrintBinaryTree.toString(this);
	}


}
