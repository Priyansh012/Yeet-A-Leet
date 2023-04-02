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
        for(int i=1;i<=n;i++){
            int countLeft=65;
            int countRight=65;
            //first half spaces
            for(int j=n;j>i;j--)
                System.out.print(" ");
            //first half asterisks
            for(int k=1;k<=i;k++){
                System.out.print((char)countLeft);
                countLeft+=1;
            }
            //second half asterisks
            for(int l=2;l<=i;l++){
                System.out.print((char)(countRight+i-2));
                countRight-=1;
            }
            
            System.out.println();
            
        }
    }
}