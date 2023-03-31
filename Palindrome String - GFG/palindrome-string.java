//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.isPalindrome(S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    int isPalindrome(String S) {
        // code here
        int n=S.length();
        
        if(n==0)
            return 1;
        
        return recursivePalindrome(S, 0, n-1);
    }
    
    int recursivePalindrome(String str, int start, int end){
        if(start==end)
            return 1;
        
        if(str.charAt(start)!=str.charAt(end))
            return 0;
        
        if(start < end+1)
            return recursivePalindrome(str, start+1, end-1);
            
        return 1;
    }
};