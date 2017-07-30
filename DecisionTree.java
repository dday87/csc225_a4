import jsjf.*;
import java.util.*;
import java.io.*;

/**
 * The DecisionTree class uses the LinkedBinaryTree class to implement 
 * a binary decision tree. Tree elements are read from a given file and  
 * then the decision tree can be evaluated based on user input using the
 * evaluate method. 
 * 
 * @author Java Foundations
 * @version 4.0
 * @param <T>
 */
public class DecisionTree<T> extends LinkedBinaryTree<T>
{
    public LinkedBinaryTree<String> tree;
    
    /**
     * Builds the decision tree based on the contents of the given file
     *
     * @param filename the name of the input file
     * @throws FileNotFoundException if the input file is not found
     */
    public DecisionTree(String filename) throws FileNotFoundException
    {
        File inputFile = new File(filename);
        Scanner scan = new Scanner(inputFile);
        int numberNodes = scan.nextInt();
        scan.nextLine();
        int root = 0, left, right;
        
        // This creates a List of LinkedBinaryTrees then uses a for loop to populate the
        java.util.ArrayList<LinkedBinaryTree<String>> nodes = new java.util.ArrayList<LinkedBinaryTree<String>>();
        for (int i = 0; i < numberNodes; i++)
            nodes.add(i,new LinkedBinaryTree<String>(scan.nextLine()));
        
        do{
            root = scan.nextInt();
            left = scan.nextInt();
            right = scan.nextInt();
            
            // I rewrote the node setting portion of this in an attempt to debug and find
            // why the program was casting a node to a string. My search led me to getLeft()
            // and getRight() methods in LinkedBinaryTree
            nodes.set(root, new LinkedBinaryTree<String>((nodes.get(root)).getRootElement()));
            nodes.get(root).getRootNode().setLeft(nodes.get(left).getRootNode());
            nodes.get(root).getRootNode().setRight(nodes.get(right).getRootNode());
            
        } while (scan.hasNext());
        
        // This creates an unbalanced tree to test the balanceTree() method on
//        nodes.get(3).getRootNode().setLeft(nodes.get(5).getRootNode());  // Uncomment these lines when testing DecisionTree and the balanceTree()
//        nodes.get(3).getRootNode().setRight(null);					   // Uncomment these lines when testing DecisionTree and the balanceTree()
        
        tree = nodes.get(root);
    }

    /**
     *  Follows the decision tree based on user responses.
     */
    public void evaluate()
    {
        LinkedBinaryTree<String> current = tree;
        Scanner scan = new Scanner(System.in);
        System.out.println ("The current size of our tree is " + current.size());
        System.out.println ("The current height of our tree is " + current.getHeight());  
        while (current.size() > 0)
        {
            System.out.println (current.getRootElement());
            if (scan.nextLine().equalsIgnoreCase("N"))
            {
                current = current.getLeft();
                System.out.println ("The current size of our tree is " + current.size());
            	System.out.println ("The current height of our tree is " + current.getHeight());            	
            }
            else
            {
                current = current.getRight();
            	System.out.println ("The current size of our tree is " + current.size());
            	System.out.println ("The current height of our tree is " + current.getHeight());               	
            }
        }
        System.out.println (current.getRootElement());
        
    }
    public void balanceTree()
    {
    	// Iterates through our list and creates
        Iterator<T> itr = iteratorInOrder();
        java.util.ArrayList<T> list = new java.util.ArrayList<T>();
        
        // While the iterator has another index that isn't null it will keep adding to our list
        while (itr.hasNext())
        {
        	list.add(itr.next());
        }
        
        // This method recursively builds a new tree using the middle index as root
        balanceTree(0, list.size(), list);
        
    }
    BinaryTreeNode<T> balanceTree(int lower , int upper , List<T> elements){
        //no more nodes can be produced on this path
        if(lower < upper)
        {

        //build node from the middle-element of the elements
        int middle = (lower + upper) / 2;
        BinaryTreeNode<T> root = new BinaryTreeNode<T>(elements.get(middle));

        //build left and right child for the according pieces of the array/list
        root.setLeft(balanceTree(lower , middle - 1 , elements));
        root.setRight(balanceTree(middle + 1 , upper , elements));

        return root;
        }
        else
        {
        	return null;
        }
    }
    
    
}