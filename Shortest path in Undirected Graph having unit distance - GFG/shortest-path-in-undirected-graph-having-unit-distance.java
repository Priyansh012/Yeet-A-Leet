//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m=sc.nextInt();
            int[][] edge = new int[m][2];
            for(int i=0;i<m;i++){
                edge[i][0]=sc.nextInt();
                edge[i][1]=sc.nextInt();
            }
            int src=sc.nextInt();
            Solution obj = new Solution();
            int res[] = obj.shortestPath(edge,n,m,src);
            for(int i=0;i<n;i++){
                System.out.print(res[i]+" ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


// via plain BFS
class Solution {
    
    public int[] shortestPath(int[][] edges,int n,int m ,int src) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        Queue<Integer> q= new LinkedList<>();
        //create empty adj list for each nodes starting from 0
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        
        //insert adj nodes by accessing the 2d edges array
        for(int i = 0; i < m; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        
        boolean[] visited = new boolean[n];
        visited[src] = true;
        int dist[] = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        q.add(src);
        
        
        while(!q.isEmpty()){
            int node= q.poll();
                
            for(int neighbor: adj.get(node)){
                if(!visited[neighbor]) {
                    visited[neighbor] = true;
                    q.add(neighbor);
                }
                
                //all the edges are of weight 1 unit hence +1 is done
                if(dist[node]+1< dist[neighbor])
                    dist[neighbor]=dist[node]+1;
            }
        }
        
        for(int i=0;i<n;i++){
            if(dist[i]==Integer.MAX_VALUE)
                dist[i]=-1;
        }
        
        return dist;
        
    }
}