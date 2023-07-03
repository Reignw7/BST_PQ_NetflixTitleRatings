// Student surname: 
// Student name: 
// Student number:
// CSC211 2022 Practical 4
// File name: PriorityQueue.java

import java.util.Comparator;
import java.util.NoSuchElementException;

public class PriorityQueue
{
    /* attributes */
    private int currentSize; // Number of elements in heap
    private PriorityQueueNode [ ] PQ; // The priority queue array
    private static final int DEFAULT_CAPACITY = 2>>14;
    private Comparator<? super PriorityQueueNode> cmp; // object to compare to instances of PriorityQueueNode

    /* default constructor */
    public PriorityQueue( )
    {
        currentSize = 0;
        cmp = null;
        PQ = new PriorityQueueNode [DEFAULT_CAPACITY + 1];
    }


    /* getter methods for attributes */
    public int getSize( )
    {
        return currentSize;
    }

   /* methods from Practical 4 (Phase 3) */

    public boolean add( PriorityQueueNode x ) // [ 4 marks ]
    {
        //checking for an empty case
        if (currentSize == 0) {
            currentSize++;
            doubleArray();
            int xPosition = currentSize;
            PQ[xPosition] = x;
            return true;
        }
        //adjusting the array length before adding
        if (currentSize >= PQ.length - 1) {
            doubleArray();
        }
            currentSize++;
            int xPosition = currentSize;
            PQ[xPosition] = x;
            while (PQ[xPosition].getRating() > PQ[xPosition / 2].getRating()) {
                swapReferences(PQ, xPosition, xPosition / 2);
                xPosition = xPosition / 2;
                if(xPosition/2==0){
                    break;
                }
            }
            return true;
        }



    public PriorityQueueNode remove( ) // [ 2 marks ]
    { 
        PriorityQueueNode maxItem = PQ[1]; //Finding the max item
        PQ[1] = null;
        swapReferences(PQ, 1, currentSize);
        currentSize--; //adjusting the new size of the heap
        percolateDown(1);
        return maxItem; //returning the deleted node
    }
    
    private void percolateDown( int hole ) // [ 6 marks ]
    {
        int child;
        PriorityQueueNode tempNode = PQ[hole]; //initialising the hole

        for( ; hole*2<=currentSize;hole= child){
            child = hole*2;
            if(child<currentSize){
                //checking which node is larger
                if(PQ[child].getRating() < PQ[child++].getRating()){
                    child++;
                }
                if(tempNode.getRating() < PQ[child].getRating()){
                    swapReferences(PQ, hole,child); //swapping the hole with the node
                } else{
                    break;
                }
            }
        }
    }


    public void display() // [ 6 marks ]
    {

        //testing for an empty tree case
        if (PQ[1] == null){
            System.out.println("Is empty...");
        }

        int start = 1;
        int end=1;
        StringBuilder builder = new StringBuilder(PQ.length);

        //printing each level of the heap
        for(; start <= PQ.length; start= end){
            if(start == 1){
                System.out.print("  " + PQ[start].getRating() + "   " );
                end= end*2;
            }else{
                end= end*2;
                for(; start<end;start++){
                    if(PQ[start] == null){
                        System.out.print("  " +" - "+"  " );
                    }else{
                        System.out.print("  " + PQ[start].getRating() + "   " );
                    }
                }
            }
            System.out.println();
        }


    }
    
    /* auxiliary methods: you may use the below methods to help you write your code, if necessary */
    private int compare( PriorityQueueNode lhs, PriorityQueueNode rhs )
    { 
        if(cmp == null)
        {
            return ((Comparable)lhs).compareTo(rhs);
        }
        else
        {
            return cmp.compare(lhs, rhs);
        }
    }
    
    public void swapReferences(PriorityQueueNode [] a, int p, int q)
    {
        PriorityQueueNode tmp = a[p];
        a[p] = a[q];
        a[q] = tmp;
    }
    
    public void doubleArray( )
    { 
        PriorityQueueNode [ ] newArray;
        newArray =  new PriorityQueueNode[ PQ.length * 2 ];
        for( int i = 0; i < PQ.length; i++ )
            newArray[ i ] = PQ[ i ];
        PQ = newArray;
    }
    
    public PriorityQueueNode element( )
    { 
        if(isEmpty())
        {
            throw new NoSuchElementException();
        }
        return PQ[1];
    }
    
    public void clear( )
    { 
        currentSize = 0;
    }
    
    public boolean isEmpty()
    {
        return currentSize==0;
    }


} 
// end of file


