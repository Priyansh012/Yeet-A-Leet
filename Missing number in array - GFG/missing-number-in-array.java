//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().trim().split(" ");
            int[] array = new int[n - 1];
            for (int i = 0; i < n - 1; i++) {
                array[i] = Integer.parseInt(str[i]);
            }
            Solution sln = new Solution();
            System.out.println(sln.missingNumber(array, n));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int missingNumber(int array[], int n) {
        int temp;
        int i=0;
        int len=array.length;
        
        while(i<len){
            int correctPos=array[i]-1;
            if(array[i]<len && array[i]!=array[correctPos]){
                temp=array[i];
                array[i]=array[correctPos];
                array[correctPos]=temp;
            }
            else
                i++;
        }
    
        for(i=0;i<array.length;i++){
            if((array[i]!=i+1))
                return i+1;
        }
        
        return n;
    }
}