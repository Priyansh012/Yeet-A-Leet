//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().split(" ");

            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            int[] ans = new Solve().findTwoElement(a, n);
            System.out.println(ans[0] + " " + ans[1]);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solve {
    int[] findTwoElement(int arr[], int n) {
        //X - repeating number
        //Y - missing number
        int result[]= new int[2];
        long N=n;
        //sum of all natural numbers
        long sN= (N*(N+1))/2;
        //sum of squares of all natural numbers
        long s2N=(N*(N+1)*(2*N+1))/6;
        //sum of elements in the array
        long s=0;
        //sum of squares of all elements in the array
        long s2=0;
        for(int i=0;i<n;i++){
            s+=(long)arr[i];
            s2+=(long)arr[i]*(long)arr[i];
        }
        
        //this will give X-Y
        long val1=s-sN;
        //this will give (X+Y)(X-Y)
        long val2=s2-s2N;
        //this will give X+Y
        val2=val2/val1;
        //2X
        long X=(val2+val1)/2;
        long Y=val2-X;
        
        result[0]=(int)X;
        result[1]=(int)Y;
        
        
        return result;
        
    }
}