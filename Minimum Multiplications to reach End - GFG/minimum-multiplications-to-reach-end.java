//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            int start = sc.nextInt();
            int end = sc.nextInt();

            Solution ob = new Solution();
            int ans = ob.minimumMultiplications(a, start, end);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends

class Pair{
    int steps;
    int node;
    
    Pair(int _steps, int _node){
        this.steps=_steps;
        this.node=_node;
    }
}

//Dijkstra
class Solution {
    int minimumMultiplications(int[] arr, int start, int end) {

        Queue<Pair> q= new LinkedList<>();
        q.offer(new Pair(0, start));
        
        int[] dist = new int[100000]; 
        
        for(int i=0;i<dist.length;i++)
            dist[i]=(int)1e9;
        
        dist[start]=0;
        
        int n=arr.length;
        int mod=100000;
        
        while(!q.isEmpty()){
            Pair p=q.poll();
            int node=p.node;
            int steps=p.steps;
            
            for(int i=0;i<n;i++){
                //multiply node with arr elements and mod it
                int num=(arr[i]*node)%mod;
                if(steps+1<dist[num]){
                    dist[num]=steps+1;
                    
                    if(num==end)
                        return steps+1;
                    //add new generated number with steps into the q
                    q.offer(new Pair(steps+1, num));
                }
            }
            
        }
        
        return -1;

    }
}
