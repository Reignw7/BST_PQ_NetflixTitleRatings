// Student surname: Walker
// Student name: Reign
// Student number: 4144021
// CSC211 2022 Practical 4
// File name: BinarySearchTree.java

public class BinarySearchTree extends BinaryNode
{
    /* attributes */
    private BinaryNode root;
    private int size;
    
    /* constructor */
    public BinarySearchTree()
    {
        root = null;
    }
    
    /* getter methods for attributes */
    public int getSize()
    {
        return size;
    }
    public BinaryNode getRoot()
    {
        return root;
    }
    
    /* methods from Practical 3 (Phase 2) */
    
    public void insert(String theType, String theTitle, int theReleaseYear)
    {
        BinaryNode x = new BinaryNode(theType, theTitle, theReleaseYear);
        BinaryNode tempNode = root;

        if(root != null){

            //While loop that find the nearest appropriate leaf in the BST
            while(true){
                //checking if the current node is less than the node to be inserted
                if(tempNode.getTitle().compareTo(x.getTitle())<=0){
                    //Checking if the right node is null
                    if(tempNode.getRight() ==null){
                        tempNode.setRight(x); //inserting the node
                        break;
                    }
                    tempNode = tempNode.getRight();
                    //tempNode.getTitle().compareTo(x.getTitle())>0
                }else{
                    if(tempNode.getLeft() == null){
                        tempNode.setLeft(x);
                        break;
                    }else{
                        tempNode = tempNode.getLeft();
                    }
                }
            }
        }else{
            root = x;
            return;
        }
    }
    
    public void remove(String title)
    {

        //creating a temporary node to traverse BST
        BinaryNode tempNode = root;
        BinaryNode removeNode = find(title);

        if(tempNode != null){
            if(removeNode.getTitle() == title){
                if(removeNode.getRight()==null && removeNode.getLeft()== null){
                    removeNode=null;
                }
            }
        }
    }
    
    public BinaryNode find(String x)
    {
        //creating a temporary node to traverse BST
        BinaryNode tempNode = root;

        if(root==null){
            return null;
        }

        if(root != null){
            //traversing through BST to find a match
            while(true) {
                if(tempNode.getTitle().compareTo(x)<0){
                    tempNode = tempNode.getRight();
                    //if the new node to be checked is null then break
                    if(tempNode == null){
                        System.out.println("There is no such title in the library");
                        return null;
                    }
                }else if(tempNode.getTitle().compareTo(x)>0){
                    tempNode = tempNode.getLeft();
                    //if the new node to be checked is null then break
                    if(tempNode == null){
                        System.out.println("There is no such title in the library");
                        return null;
                    }
                }else{
                    System.out.println("The " + tempNode.getType() + " " + tempNode.getTitle() + " was released " + tempNode.getReleaseYear());
                    return tempNode; //returns the node that has the match
                }
            }
        }

        System.out.println("There is no such title in the library");
        return null; //Match not found
    }
   
    
    public void printInOrder(BinaryNode x)
    {
        if(x.getLeft() !=null){
            printInOrder(x.getLeft()); //recursion to get result
        }

        System.out.println(x.getTitle());

        if(x.getRight() != null){
            printInOrder(x.getRight());//recursion to get result
        }
    }
   
    /* methods from Practical 4 (Phase 3) */
    

    
    public int height(BinaryNode x) // [ 2 marks ]
    {
        if(x ==null){
            return -1; //IF the root node is null
        }

       int heightLeft = height(x.getLeft());
        int heightRight = height(x.getRight());

        if(heightLeft > heightRight){
            return heightLeft + 1; //using recursion to get height

        } else {
                return heightRight + 1; //using recursion to get height
        }
    }
    
    public boolean isFull(BinaryNode t) // [ 2 marks ]
    {
        //checking whether root is a leaf
      if(t == null){
          return true;
      }

      else if(t != null){
          //checking whether the node is a leaf
          if(t.getLeft() == null && t.getRight()==null){
              return  true;
          }
          //if the node has a left and right child then recursion is used to checked if they are full
          if(t.getLeft() != null && t.getRight() != null){
              return isFull(t.getLeft()) && isFull(t.getRight());
          }
    }
      return false;
    }
    
    public boolean isAVLTree(BinaryNode t) // [ 2 marks]
    {
        if(t == null){
            return true;
        }

        //initialising the balancing factor
        int balanceChecker=-1;
        if(t.getLeft()==null && t.getRight()==null){
            balanceChecker=1;
        };

        int heightLeft;
        if(t.getLeft() != null){
            isAVLTree(t.getLeft());
        }

        int heightRight;
        if(t.getRight() != null){
            isAVLTree(t.getRight());
        }

        heightLeft = height(t.getLeft());
        heightRight = height(t.getRight());

        if(Math.abs(heightLeft - heightRight) <=1){
            balanceChecker=maxHeight(t); //calculating the balancing factor
        }

        //determining if the tree is a AVL tree
        if(balanceChecker == -1){
            return false;
        }else if(balanceChecker >= 1){
            return true;
        }
        return false;
    }
    
    
    /* auxiliary methods: you may use the below methods to help you write your code, if necessary */
    public void makeEmpty()
    {
        root = null;
    }
    
    public Boolean isEmpty()
    {
        return root==null;
    }

    private BinaryNode elementAt(BinaryNode t)
    {
        return t == null ? null : t;
    }

    public int maxHeight(BinaryNode t){
        if (t == null){
            return 0;
        }else{
            return Math.max(height(t.getRight()), height(t.getLeft())) + 1;
        }
    }
    
}
// end of file