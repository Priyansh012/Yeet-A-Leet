//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[][] edge = new int[m][3];
			for (int i = 0; i < m; i++) {
				edge[i][0] = sc.nextInt();
				edge[i][1] = sc.nextInt();
				edge[i][2] = sc.nextInt();
			}
			Solution obj = new Solution();
			int res[] = obj.shortestPath(n, m,edge);
			for (int i = 0; i < n; i++) {
				System.out.print(res[i] + " ");
			}
			System.out.println();
		}
	}
}
// } Driver Code Ends
class Pair {

        int node;
        int weight;

        public Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }

}
//User function Template for Java
class Solution {
    
	public int[] shortestPath(int N,int M, int[][] edges) {

		List<List<Pair>> adj = new ArrayList<>();

        for(int i=0;i<N;i++) {
            adj.add(new ArrayList<Pair>());
        }
        
        //create adjList with weights
        for(int i=0;i<M;i++){
            //edges[][] is basically [u,v,weight];
            int u=edges[i][0];
            int v=edges[i][1];
            int wt=edges[i][2];
            
            adj.get(u).add(new Pair(v,wt));
        }
        
        //find the topoSort
        boolean visited [] = new boolean[N]; 
        Stack<Integer> st = new Stack<Integer>();

        for(int i=0;i<N;i++){
            if(visited[i]==false){
                 topoSort(i,visited,adj,st);
            }
        }
        
        //find the distance array
        int dist [] = new int[N];
        
        //first mark all the distance as infinity
        Arrays.fill(dist, (int) 1e9);
        
        //mark distance of src node from src node as 0
        dist[0]=0;
        
        while(!st.isEmpty()){
            int node=st.pop();
            
            for(int i=0; i<adj.get(node).size();i++){
                int v = adj.get(node).get(i).node;
                int wt= adj.get(node).get(i).weight;
                
                if(dist[node]+wt < dist[v]){
                    dist[v]=dist[node] + wt;
                }
            }
            
        }
        
        for(int i=0;i<N;i++)
            if(dist[i]==(int)1e9) 
                dist[i] = -1;
        
        return dist;
	}
	
	private static void topoSort(int node, boolean visited [], List<List<Pair>> adj, Stack<Integer> st){
        visited[node] = true;

        for(int i=0; i<adj.get(node).size();i++){
            int v = adj.get(node).get(i).node;
            if(visited[v]==false){
                topoSort(v,visited,adj,st);
            }
        }
        st.push(node);
    } 
}