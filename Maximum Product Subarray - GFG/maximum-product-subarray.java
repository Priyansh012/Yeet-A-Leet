//{ Driver Code Starts
import java.io.*;
import java.util.*;

  public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            String[] inputLine = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            System.out.println(new Solution().maxProduct(arr, n));
        }
    }
}

// } Driver Code Ends


class Solution {
    // Function to find maximum product subarray
    long maxProduct(int[] arr, int n) {
        // code here
        long maxPositive=arr[0];
        long maxNegative=arr[0];
        long maxProduct=arr[0];
        long temp=0;
        if(n==1)
            return maxProduct;
        for(int i=1;i<n;i++){
            if(arr[i] < 0){
                temp= maxPositive;
                maxPositive = maxNegative;
                maxNegative = temp;
            }
            maxNegative = Math.min(arr[i], maxNegative*arr[i]);
            maxPositive = Math.max(arr[i], maxPositive*arr[i]);
            maxProduct = Math.max(maxProduct, maxPositive);
        }
     return maxProduct;   
    }
}