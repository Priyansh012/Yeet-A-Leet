//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class Main {
	public static void main (String[] args) {
	    
	    //taking input using Scanner class
		Scanner sc=new Scanner(System.in);
		
		//taking total testcases
		int T=sc.nextInt();
		while(T-->0)
		{
		    //creating an object of class Print
		    Solution obj=new Solution();
		    int N;
		    
		    //input N
		    N=sc.nextInt();
		    
		    //calling printNos() methdo
		    //of class Print
		    obj.printNos(N);
		    System.out.println();
		    
		}
		
	}
}


// } Driver Code Ends


//User function Template for Java



class Solution
{
    int count=1;    
  public void printNos(int N)
    {
        //Your code here
        if(count==N+1)
            return;
        System.out.print(count+" ");
        count++;
        printNos(N);
    }
}

//via backtracking-- basically the function call will get stored in the stack trace 
//and print wont be executed unless it returns back to terminated the function call via base conditon.

/*class Solution
{
  public void printNos(int N)
    {
        // Base condition
        if(N == 0) return;
        // Recursive calling of a function
        printNos(N - 1);
        // Printing numbers
        System.out.print(N + " ");
    }
}*/


