// Student surname: 
// Student name: 
// Student number:
// CSC211 2022 Practical 4
// File name: BinarySearchTreeTester.java


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BinarySearchTreeTester 
{
    public static void main(String[] args)
    {
        BinarySearchTree bst = new BinarySearchTree();
        
        try
        {
            // you may modify the filepath, but not the filename
            File file = new File("C:\\Users\\reign\\IdeaProjects\\Prac4\\src\\netflix_titles_alternative.csv");
            
            Scanner token = new Scanner(file);
            token.nextLine();                       
            while(token.hasNext())                  
            {
              String line = token.nextLine();              
              String tmp[] = line.split(";"); 
              String type = tmp[0];
              String title = tmp[1];
              int releaseYear = Integer.parseInt(tmp[2]);
              bst.insert(type, title, releaseYear);
             }
             token.close();
        }
            
        catch(FileNotFoundException e)
        {
            System.out.println(e.getMessage());
            System.exit(0);
        }
      
        /* driver program to test your code: do not modify below*/ 
        System.out.println("What is the height of the BST?"); 
        System.out.println("" + bst.height(bst.getRoot())); // [1 mark if output is correct]
        System.out.println();
        System.out.println("Is the BST an AVL tree?");
        System.out.println(bst.isAVLTree(bst.getRoot())); // [1 mark if output is correct]
        System.out.println();
        System.out.println("Is the BST full?");
        System.out.println(bst.isFull(bst.getRoot())); // [1 mark if output is correct]
        System.out.println();
        System.out.println("In-order traversal of BST:");
        System.out.println();
        bst.printInOrder(bst.getRoot());     // [1 mark if output is correct]
        System.out.println();
        System.out.println("-----end of program-----");
     
  
    }
}
// end of file