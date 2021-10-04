package firstJavaProgram;
import java.util.*;

public class HeapOperation
{

 private int[] heap;
 private int size;
 private int maxSize;

 private static final int front = 1;                  //Assigning heap array with 1 based indexing

 public HeapOperation(int maxSize)                        // Constructor used for initializing heap with given size( )
 {
 this.maxSize = maxSize;
 this.size = 0;
 heap = new int[this.maxSize + 1];
 heap[0] = Integer.MIN_VALUE;
 }

 //************************************
 
 private int parent(int idx)                       // Method for returning parent of the node
 {
 return idx / 2;
 }
 
 //************************************
 
 private int leftChild(int pos)                    //Method for returning left child of node
 {
 return (2 * pos);                                 //here we are using 1 based indexing i.e. 1->n
 }
 
 //************************************

 private int rightChild(int idx)                   //Method for returning right child of node
 {
 return (2 * idx) + 1;
 }
 
 //************************************

 private boolean isLeaf(int idx )                //Method for checking if node is leaf
 {
 if (idx >= (size / 2) && idx <= size) 
 return true;
 else
 return false;
 }
 
 //************************************

 private void swap(int x, int y)                 //Method for two nodes of the heap
 {
 int temp;
 temp = heap[x];
 heap[x] = heap[y];
 heap[y] = temp;
 }

 //************************************
 
 private void minHeapify(int idx)                //Heapify Function for minHeap
 { 
 
 if (!isLeaf(idx))   // If it is not a leaf node and greater than any of its child then we swap and call for minHeapify().
 { 
  if (heap[idx]>heap[leftChild(idx)] || heap[idx]>heap[rightChild(idx)]) 
  {
 if (heap[leftChild(idx)] < heap[rightChild(idx)]) //Swap with left child and call minHeapify()
   {
   swap(idx, leftChild(idx));
   minHeapify(leftChild(idx));
   }
   else                                            //else swap with right child and then call minHeapify()
    {
    swap(idx, rightChild(idx));
    minHeapify(rightChild(idx));
    }
  } 
  }  //Outer if ends
 }  //Method Ends

 //************************************
 
 public void insert(int element)                  //Method to insert a node into the heap
 {
  if (size >= maxSize) 
  return;
 
 heap[++size] = element;
 int current = size;
 
 while (heap[current] < heap[parent(current)]) 
    {
	 swap(current, parent(current));
	 current = parent(current);
	 }
 } //insert method() ends

 //************************************

 public void print()                             // Methods to print the heap.
 {
   for (int i = 1; i <= size / 2; i++)
   {
	System.out.print(" Parent : " + heap[i] + " Left Child : " + heap[2 * i] + " Right Child :" + heap[2 * i + 1]);
	System.out.println();
	}
 }

 //************************************
	
 public void minHeap()                       //Method for building the MinHeap
 {
  for (int pos = (size / 2); pos >= 1; pos--) 
   minHeapify(pos);
 }

 //************************************

 public void delete()                        //Method for deleting a node in Heap       
 {
  int popped = heap[front];
  System.out.println("Popped Element is :");
  heap[front] = heap[size--];
  minHeapify(front);
 }
 
 //************************************

 void callInsert(int[] a)                   //Method for calling the Insert function for calculating its execution Time
 { 
  HeapOperation hs = new HeapOperation(a.length);
	
   Scanner sc = new Scanner(System.in);
   
	 int n = sc.nextInt();
	 long startTime = System.nanoTime();
	 hs.insert(n);
	 long endTime = System.nanoTime();
	 System.out.println("Time taken for insertion is :");
	 System.out.println(endTime-startTime); 
 }
 
 //************************************
 
 void calldelete(int[] a)                //Method for calling the Delete function for calculating its exexution Time
 {
	 HeapOperation hs = new HeapOperation(a.length);
	 long startTime = System.nanoTime();
	 hs.delete();
	 long endTime = System.nanoTime();
	 System.out.println("Time taken for deletion is :");
	 System.out.println(endTime-startTime);
 }
 
 //***********************************************************************************************************************

 public static void main(String args[])    //Main Method to implement Heap operations and finally Heap Sorting
 {
	Random rand = new Random();
	Scanner sc = new Scanner(System.in);
	
	System.out.println("Enter the size of the heap to be created :-");
	 int n = sc.nextInt();
	HeapOperation hp = new HeapOperation(n);


	 int[] a=new int[n];
	 int[] c=new int[n];
	 int[] b=new int[n];

	
	 for(int i=0;i<a.length;i++)         //Random array C     
	   c[i]=rand.nextInt();
	 
	 for(int i=0;i<c.length;i++)
	  a[i]=c[i];
	 
	 Arrays.sort(a);                    //STL for creating the sorted array A (Increasing)

	 for(int i=0;i<a.length;i++)        //Creating the reverse sorted array B
	  b[i]=a[a.length-i-1];
	 
	System.out.println("************************* Performing Heap Operations ******************************************\n");
	 
	 int choice;                         
	 do
	 {
     System.out.println("*********************************************************************************************\n");
	 System.out.println("Please enter the Choices :-");
	 System.out.println("1.Insertion in Heap");
	 System.out.println("2.Deletion in Heaps");
	 System.out.println("3.Exit the Program !!!");
	 System.out.println("*********************************************************************************************\n");

	 choice = sc.nextInt();
	 switch(choice)
	 {
	 case 1: 
		     {
		      System.out.println("Enter the elements to be inserted in array B :-\n");
	          hp.callInsert(b);
	         System.out.println("Enter the elements to be inserted in array C :-\n");
	          hp.callInsert(c);
	         System.out.println("Enter the elements to be inserted in array A :-\n");
	          hp.callInsert(a);
	          break;
		     }
	          
	 case 2:
	          { 
		      System.out.println("Enter the elements to be deleted in array B :-\n");
	          hp.calldelete(b);
	         System.out.println("Enter the elements to be deleted in array C :-\n");
	          hp.calldelete(c);
	         System.out.println("Enter the elements to be deleted in array A :-\n");
	          hp.calldelete(a);
	          break;
             }
	          
	 case 3: System.out.println("Exit!!!");
	          break;
	          
	 default :System.out.println("Please enter a valid choice!!");
	  }
	 
	  }
	 while(choice!=3);
	 
	}//main() method ends
	} // class ends
