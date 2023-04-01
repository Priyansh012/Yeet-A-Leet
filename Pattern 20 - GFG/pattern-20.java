//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Main {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            Solution obj = new Solution();
            obj.printTriangle(n);
        }
    }
}
// } Driver Code Ends


class Solution {

    void printTriangle(int n) {
        // code here
        //top
        for(int i=1;i<=n;i++){
            //left triangle
            for(int j=1;j<=i;j++){
                System.out.print("*");
            }
            
            //spaces after the left triangle pattern
            for(int k=n-1;k>=i;k--){
              System.out.print(" ");      
            }

            //spaces before the right triangle pattern
            for(int l=n-1;l>=i;l--){
              System.out.print(" ");      
            }
            
            //System.out.print(" ");
            
            //right triangle
            for(int m=i;m>0;m--){
                System.out.print("*");
            }
            
            System.out.println();
        }
        
        //bottm
        for(int i=n-1;i>0;i--){
            
            //left triangle
            for(int j=i;j>0;j--)
                System.out.print("*");
            
            //spaces after the left triangle pattern
            for(int k=n;k>i;k--)
              System.out.print(" ");      
            
            //spaces before the right triangle pattern
            for(int l=n;l>i;l--)
                System.out.print(" ");
            
            //right triangle
            for(int m=i;m>0;m--)
                System.out.print("*");
    
            System.out.println();
        }
        

    }
}