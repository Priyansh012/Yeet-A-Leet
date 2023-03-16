//{ Driver Code Starts
//Initial Template for Java



import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int x = Integer.parseInt(inputLine[1]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().count(arr, n, x);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java



class Solution {
    int count(int[] arr, int n, int x) {
        // code here
        int index=binarySearch(arr,n,x);
        if(index==-1)
            return 0;
        
        int count=1;
        //check left side of our mid
        int left=index-1;
        while(left>=0 && arr[left]==x){
            count+=1;
            left-=1;
        }
        
        //check right side of our mid
        int right=index+1;
        while(right<n && arr[right]==x){
            count+=1;
            right+=1;
        }
        
        return count;
    }
    
    public int binarySearch(int[] arr, int n, int x){
        int low=0, high=n-1;
        int mid=0;
        while(low<=high){
            mid=low+(high-low)/2;
            if(arr[mid]==x)
                return mid;
            else if(arr[mid]<x)
                low=mid+1;
            else
                high=mid-1;
        }
        return -1;
    }
}