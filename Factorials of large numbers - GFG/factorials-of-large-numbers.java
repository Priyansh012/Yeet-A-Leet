//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GfG
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0)
        {
            int N = sc.nextInt();
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.factorial(N);
            for (Integer val: ans) 
                System.out.print(val); 
            System.out.println();
        }   
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static ArrayList<Integer> factorial(int N){
        //code here
        ArrayList<Integer> list = new ArrayList<Integer>();
        java.math.BigInteger factorial = new java.math.BigInteger("1");
        char c=' ';
        for (int i = 2; i <= N; i++)
            factorial = factorial.multiply(java.math.BigInteger.valueOf(i));
        
        String ans=factorial.toString();
        
        for(int i=0;i<ans.length();i++){
            c=ans.charAt(i);
            list.add(Integer.parseInt(String.valueOf(c)));
        }
        
        return list;

    }
}