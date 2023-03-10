//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;


// } Driver Code Ends
//User function Template for Java

//Iterative solution
/*class Solution
{
    //At each pass, push max to the last via adjacent swapping
    /*
        Time Complexity:
        Best case: O(n)
        Worst case: O(n^2)
        Avg. case:  O(n^2)
	public static void bubbleSort(int arr[], int n)
    {
        //code here
        int temp;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                if(arr[i]>arr[j]){
                temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
                }   
            }
            
        }
    }
}*/

//Recursive solution

class Solution{
    public static void bubbleSort(int arr[], int n){
        if(n==1)
            return;
        
        int count=0;
        
        for(int i=0;i<n-1;i++){
            if(arr[i]>arr[i+1]){
                int temp=arr[i];
                arr[i]=arr[i+1];
                arr[i+1]=temp;
                count+=1;
            }   
        }
        
        if(count==0)
            return;
        
        bubbleSort(arr,n-1);
    }   
}



//{ Driver Code Starts.

class Sorting
{
    //method to print the Elements of the array
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
	public static void main(String args[])
	{
	    //taking input using Scanner class
		Scanner sc = new Scanner(System.in);
		
		//taking total testcases
		int t = sc.nextInt();
		while(t>0)
		{
		    //taking total elements
			int n = sc.nextInt();
			
			//creating a new array of length n
			int arr[] = new int[n];
			
			//inserting elements to the array
			for(int i=0;i<n;i++)
			{
				arr[i] = sc.nextInt(); 
			}
			
			
			//calling bubbleSort() method
			new Solution().bubbleSort(arr,n);
			
			//calling printArray() method
			printArray(arr);
			
		t--;	
		}
	}

}
// } Driver Code Ends