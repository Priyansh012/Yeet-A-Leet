//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            //br.readLine();
            String s;
            s = br.readLine();
            
            Solution obj = new Solution();
            int res = obj.beautySum(s);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int beautySum(String s) {
        // code here
        int result=0;
        int n=s.length();
        
        //starting from 2 because we dont want to include only non-zero beauty of strings.
        for(int windowSize=2;windowSize<n;windowSize++){
            int i=0;
            int j=windowSize;
            int freq [] = new int [26];
            for(int k=i;k<=j;k++){
                freq[s.charAt(k)-'a']++; 
            }
            
            result+=beauty(freq);
            j++;
            
        //update our sliding window, add next char and remove the first char from the window
            while(j<n){
                freq[s.charAt(j)-'a']++;
                freq[s.charAt(i)-'a']--;
                result+=beauty(freq);
                i++;
                j++;
                
            }
        
        }
        
        return result;    
    }
    
    public static int beauty(int freq []){
        int minFreq=Integer.MAX_VALUE;
        int maxFreq=Integer.MIN_VALUE;
        
        for(int i:freq){
            if(i!=0){
                minFreq=Math.min(minFreq, i);
                maxFreq=Math.max(maxFreq, i);    
            }
        }
        
        return maxFreq-minFreq;
    }
}
        
