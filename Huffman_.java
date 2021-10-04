/* Huffman Code impented which uses Greedy Algorithm */

package firstJavaProgram;
import java.util.*;


class Huff_Node   //class for implementing basic structure of the node 
{
	int value;
	char ch;

	Huff_Node left;
	Huff_Node right;
}


//comparator class for making the minimum heap
class MyComparator implements Comparator<Huff_Node>  
{
	
 public int compare(Huff_Node x, Huff_Node y) 
	{
	 return x.value - y.value;
	}
} 




public class Huffman_  //Main class to implement Huffman Code 
{

 public static void printCode(Huff_Node root, String s)
 {
	 
   if (root.left == null && root.right == null && Character.isLetter(root.ch)) 
   {
	 System.out.println(root.ch + ":" + s);
	 return;
   }
   
	 printCode(root.left, s + "0");
	 printCode(root.right, s + "1");
 }
 
 

 public static void main(String[] args)  //Main Method
 {
	 
    Scanner sc = new Scanner(System.in);
    
	 int n = 6;
	 char[] charArray = { 'a', 'b', 'c', 'd', 'e', 'f' };
	 int[] charfreq = new int[n];
	
	 System.out.print("Please Enter frequency of the following characters :-\n");

	for (int i = 0; i < n; i++) 
	{
	 System.out.print(charArray[i] + " : ");
	 charfreq[i] = sc.nextInt();
	}

	System.out.println();
	System.out.println("The following characters with their code-word are as follows :-");
	PriorityQueue<Huff_Node> q = new PriorityQueue<Huff_Node>(n, new MyComparator());

		
    for (int i = 0; i < n; i++)
    {
	 Huff_Node hn = new Huff_Node();

	  hn.ch = charArray[i];
	  hn.value = charfreq[i];

	  hn.left = null;
	  hn.right = null;
	  q.add(hn);
	  
	 }

    Huff_Node root = null;
	  
	while (q.size() > 1)
	{
		Huff_Node x = q.peek();
		q.poll();

		Huff_Node y = q.peek();
		q.poll();
		
		Huff_Node f = new Huff_Node();
		f.value = x.value + y.value;
		f.ch = '-';
		f.left = x;
		f.right = y;
		root = f;
		q.add(f);
		
	 }
	
	printCode(root, "");
	
	}//main method ends
}    //Class  Huffman_ ends
