//{ Driver Code Starts
import java.util.*;

class Maxsum_Among_All_Rotations_Array
{
	public  static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t>0)
		{
			int n = sc.nextInt();
			int arr[] = new int[n];
			for(int i=0;i<n;i++)
				arr[i] = sc.nextInt();
			
			System.out.println(new GfG().max_sum(arr,n));
			
		t--;
		}
	}
	
}

// } Driver Code Ends


class GfG
{
    int max_sum(int A[], int n)
    {
	// Your code here
	    int sum=0;
	    int max=0;
	    int S0=0;
	    int SiPlus1=0;
	    for(int i=0;i<n;i++)
	    {
	        sum=sum+A[i];
	        S0=S0+i*A[i];
	    }
	    
	    int Si=S0;
	    max=S0;
	    
	    for(int i=0;i<n-1;i++){
	        SiPlus1 = Si + sum - n*A[n-i-1];
	        if(SiPlus1>max)
	            max=SiPlus1;
	        Si=SiPlus1;
	    }
	    
	    return max;
    }	
    
}
