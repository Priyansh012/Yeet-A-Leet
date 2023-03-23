//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int t=sc.nextInt();
		
		while(t-->0)
		{
		    int n=sc.nextInt();
		    int a[]=new int[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        a[i]=sc.nextInt();
		    }
		    int m=sc.nextInt();
		    Solution ob = new Solution();
		    System.out.println(ob.findPages(a,n,m));
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution 
{
    //Function to find minimum number of pages.
    public static int findPages(int[]A,int N,int M)
    {
        int max=0;
        int sum=0;
        
        for(int val: A){
            sum+=val;
            max= Math.max(max,val);
        }
        
        
        if(N==M)
            return max;
        if(M>N)
            return -1;
        int ans=-1;
        int low=max;
        int high=sum;
        
        while(low<=high){
            int mid=low+(high-low)/2;
            
            if(isPossible(A,mid,M,N)){
                ans=mid;
                high=mid-1;
            }
            else
                low=mid+1;
        }
        
        return ans;
    }
    
    public static boolean isPossible(int A [], int mid, int M, int N){
        int curSum=0;
        int curStudents=1;
        
        for(int i=0;i<N;i++){
            curSum+=A[i];
            
            if(curSum>mid){
                curSum=A[i];
                curStudents+=1;
            }
        }
        
        return (curStudents<=M);
        
    }
};