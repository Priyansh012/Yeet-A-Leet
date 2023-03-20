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
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            new Solution().rearrange(arr, n);
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function Template for Java




class Solution {
    void rearrange(int arr[], int n) {
        // code here
        ArrayList<Integer> positiveList = new ArrayList<Integer>();
        ArrayList<Integer> negativeList = new ArrayList<Integer>();
        int count=0;
        for(int i=0;i<n;i++){
            if(arr[i]>=0)
                positiveList.add(arr[i]);
            else
                negativeList.add(arr[i]);
        }

        while(count<n){
            if(positiveList.isEmpty()!=true){
                arr[count]=positiveList.get(0);
                positiveList.remove(0);
                count++;
            }
            
            if(negativeList.isEmpty()!=true) {
               arr[count]=negativeList.get(0);
               negativeList.remove(0);
               count++;
            }
        }    
        
    }
}