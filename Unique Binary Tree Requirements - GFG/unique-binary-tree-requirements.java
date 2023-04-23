//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int a=sc.nextInt();
            int b=sc.nextInt();
            
            Solution obj = new Solution();
            boolean ans = obj.isPossible(a,b);
            if(ans==true)
                System.out.println(1);
            else{
                System.out.println(0);
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    
    //to construct a unique tree from 2 traversals, atmost one traversal should be inorder.
    //then we can construct a unique binary tree because Left Root Right structure is a must to construct a unique binary tree
    //otherwise there can be many trees created
    public static boolean isPossible(int a, int b){
        if( (a==2 || b==2) && (a!=b) )
            return true;
        else
            return false;

    }
}