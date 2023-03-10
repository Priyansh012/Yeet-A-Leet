//{ Driver Code Starts
import java.util.*;
import java.lang.Math;

class Sorting
{
	
	static void printArray(int arr[],int size)
	{
		int i;
		for(i=0;i<size;i++)
		System.out.print(arr[i]+" ");
	    System.out.println();
	}
	
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t= sc.nextInt();
		while(t>0)
		{
			int n = sc.nextInt();
			int a[] = new int[n];
		
			for(int i=0;i<n;i++)
			a[i]= sc.nextInt();
			
			 new Solution().insertionSort(a,n);
			 printArray(a,n);
			
		t--;
		}
		
	}
}
// } Driver Code Ends


class Solution
{
 //At each pass, it takes the ith element and inserts it at its correct postion
    /*
        Time Complexity:
        Best case: O(n)
        Worst case: O(n^2)
        Avg. case:  O(n^2)
    */
//Iterative solution
 /* public void insertionSort(int arr[], int n)
  {     
      for(int i=0;i<n;i++){
          insert(arr,i);
      }
      
  }
  
  static void insert(int arr[],int i)
  {     int j=i;
        int temp;
       while(j>0 && arr[j-1]>arr[j])
       {
           temp=arr[j];
           arr[j]=arr[j-1];
           arr[j-1]= temp;
           j--;
       }
  }*/
  
//Recursive Solution
    public void insertionSort(int arr[], int n){
        //base case
        if(n==1)
            return;
        insertionSort(arr,n-1);
        insert(arr,n-1);
    }
    static void insert(int arr[],int i){
        int j=i;
        int temp;
       while(j>0 && arr[j-1]>arr[j])
       {
           temp=arr[j];
           arr[j]=arr[j-1];
           arr[j-1]= temp;
           j--;
       }
    }
}

