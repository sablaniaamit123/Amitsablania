import java.util.*;
class Node {

  int data;
  Node left, right;

  Node(int d)
  {
   data = d;
   left = right = null;
  }
}
class BST {
	  Node root;
	  BST()
	  {
	    root = null;
}
	  void inorder()
	  {
	    Utilinorder(this.root);
	  }

	  //function for inorder traversal of the tree
	  void Utilinorder(Node node)
	  {
	      if (node == null)
	      {
	       return;
	      }
	      
	    Utilinorder(node.left);
	    System.out.print(node.data + " ");
	    Utilinorder(node.right);
	  }

	  // This method mainly calls insert_element()
	  void insert(int key)
	   {
	      root = insert_element(root, key);
	   }

	  /*In BST, a recursive function for inserting a new key. */
	  Node insert_element(Node root, int key)
	  {
	    if (root == null)
	     {
	        root = new Node(key);
	        return root;
	     }
	     
	   /*Recure down the BST */
	    if (key < root.data)
	    {
	      root.left = insert_element(root.left, key);
	     }
	    else if (key > root.data)
	    {
	      root.right = insert_element(root.right, key);
	    }
	   return root;
	  }

	  ArrayList<Integer> treeToArrayList(Node node, ArrayList<Integer> list)
	  {
	     if (node == null)
	     {
	  	 return list;
	     }

	    treeToArrayList(node.left, list);
	    list.add(node.data);
	    treeToArrayList(node.right, list);

	    return list;
	  }

	  boolean checkPair(Node node, int target)
	  {
	    ArrayList<Integer> a1 = new ArrayList<Integer>();
	    ArrayList<Integer> a2 = treeToArrayList(node, a1);
	    int s = 0; 
	    int e = a2.size() - 1; 
	    
	    while (s < e) 
	      {
	      if (a2.get(s) + a2.get(e) == target)
	  	{
	        System.out.println("Pair with given sum is found: " + a2.get(s) + " + " + a2.get(e) + " "+ "= " + target); 
	  	   return true;
	  	}


	      if (a2.get(s) + a2.get(e) > target) // Decrement the End(e)
	  		{
	  		e--;
	  		}

	  	if (a2.get(s) + a2.get(e) < target) // Increment the Start(s)
	  		{
	  		s++;
	  		}
	  	}
	  	System.out.println("No such values are found in Balanced BST!");
	  	return false;
	  }


	  // Driver function
	  public static void main(String[] args)
	  {
	    BST balancetree= new BST();


	    balancetree.insert(10);
	    balancetree.insert(20);
	    balancetree.insert(30);
	    balancetree.insert(40);
	    balancetree.insert(50);
	    balancetree.insert(60);
	    balancetree.insert(70);


	    balancetree.checkPair(balancetree.root, 130);
	   }
	  }
