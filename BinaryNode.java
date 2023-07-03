// Student surname: Walker
// Student name: Reign
// Student number: 4144021
// CSC211 2022 Practical 4
// File name: BinaryNode.java

public class BinaryNode 
{
    /* attributes */
    private String type;
    private String title;
    private int releaseYear;
    private BinaryNode left;
    private BinaryNode right;

    /* default constructor */
    public BinaryNode()
    {
        this.type = "";
        this.title = "";
        this.releaseYear = 0;
        this.left = null;
        this.right = null;
    }
    
    /* parameterised constructor */
    public BinaryNode(String type, String title, int releaseYear) 
    {
        this.type = type;
        this.title = title;
        this.releaseYear = releaseYear;
        this.left = null;
        this.right = null;
    }

    /* getter and setter methods for attributes */
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getReleaseYear()
    {
        return this.releaseYear;
    }
    
    public void setReleaseYear(int releaseYear)
    {
       this.releaseYear = releaseYear;
    }
    
    public BinaryNode getLeft() {
        return left;
    }

    public void setLeft(BinaryNode left) {
        this.left = left;
    }

    public BinaryNode getRight() {
        return right;
    }

    public void setRight(BinaryNode right) {
        this.right = right;
    }
}
//end of file
