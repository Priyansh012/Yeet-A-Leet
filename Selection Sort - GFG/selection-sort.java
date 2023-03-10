//{ Driver Code Starts
import java.util.*;

class GFG
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t>0)
		{
			int n = sc.nextInt();
			int arr[] = new int[n]; 
			for(int i=0;i<n;i++)
			{
				arr[i] = sc.nextInt();
			}
		
			Solution obj = new Solution();
			obj.selectionSort(arr, n);
			
			for(int i=0;i<n;i++)
		    	System.out.print(arr[i]+" ");
		    System.out.println();
			t--;
		}
		
	}
}

// } Driver Code Ends


class Solution
{   
    //At each pass, select min and put it at the first via a select function which finds min of sub arrays.
    /*
        Time Complexity:
        Best case: O(n^2)
        Worst case: O(n^2)
        Avg. case:  O(n^2)
    */
	void selectionSort(int arr[], int n)
	{   int temp;
	    int minPos;
	    for(int i=0;i<n-1;i++){
	       minPos=select(arr,i);
	       temp=arr[i];
	       arr[i]=arr[minPos];
	       arr[minPos]=temp;
	    }
	}
	
	int  select(int arr[], int i){
	    int min=i;
	    int n=arr.length;
	    
	    for(int start=i+1;start<n;start++){
	        if(arr[min]>arr[start]){
	            min=start;
	        }
	    }
	    
	    return min;
	}
}