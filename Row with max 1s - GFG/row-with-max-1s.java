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
            int m = Integer.parseInt(inputLine[1]);
            int[][] arr = new int[n][m];
            inputLine = br.readLine().trim().split(" ");
        
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    arr[i][j] = Integer.parseInt(inputLine[i * m + j]);
                }
            }
            int ans = new Solution().rowWithMax1s(arr, n, m);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java



class Solution {
    int rowWithMax1s(int arr[][], int n, int m) {
        // code here
        int max=0;
        int count;
        int row=-1;
        for(int i=0;i<n;i++){
            count=0;
            for(int j=0;j<m;j++){
                if(arr[i][j]==1){
                    count+=1;
                }
            }
            if(max<count){
                row=i;
                max=count;
            }
            if(max==m)
                return i;
        }
        
        return row;
    }
}
/*//Another  solution
class Solution {
    int rowWithMax1s(int arr[][], int n, int m) {
        // code here
        int max=-1;
	        int count;
	        boolean flag=false;
	        int rowNumber=-1;
	        for(int i=0;i<n;i++){
	            count=0;
	            for(int j=0;j<m;j++){
	                if(arr[i][j]==1){
	                    flag=true;
	                    count++; 
	                }
	            }
	            if(max<count && flag==true) {
	            	max=count;
	                rowNumber=i;
	            }  
	        }
	        
        return rowNumber;
    }
}

*/
