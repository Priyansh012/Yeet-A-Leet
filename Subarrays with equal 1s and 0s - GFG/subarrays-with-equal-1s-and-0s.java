//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.lang.*;
import java.io.*;
class Driverclass
 {
	public static void main (String[] args) {
	   
	   Scanner in = new Scanner(System.in);
	   int t= in.nextInt();
	   while(t-->0){
	       
	       int n = in.nextInt();
	       int [] arr= new int[n];
	       for(int i=0;i<n;i++) {
	           arr[i] = in.nextInt();
	       }
	       System.out.println(new Solution().countSubarrWithEqualZeroAndOne(arr, n));
	   }
	 }
}


// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to count subarrays with 1s and 0s.
    static int countSubarrWithEqualZeroAndOne(int arr[], int n)
    {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        int newArr [] = new int[n];
        int sum=0;
        int result=0;
        map.put(0,1);
        for(int i=0;i<n;i++){
            newArr[i] = (arr[i]==0)? -1 : 1;
        }
        
        for(int i=0;i<n;i++){
            sum = sum+newArr[i];
            if(map.containsKey(sum)){
                result = result + map.get(sum);
                map.put(sum, map.get(sum)+1);
            }
            else{
                map.put(sum,1);
            }
        }
        
        return result;
    }
}


