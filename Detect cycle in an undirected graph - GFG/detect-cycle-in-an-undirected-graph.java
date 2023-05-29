//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isCycle(V, adj);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends

//BFS

// class Pair{
//     int child;
//     int parent;

//     Pair(int _child, int _parent){
//         this.child=_child;
//         this.parent=_parent;
//     }
// }

// class Solution {
//     // Function to detect cycle in an undirected graph.
//     public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
//         boolean visited [] = new boolean [V]; //by default all will be false and hence not visited in our context
        
//         for(int i=0 ; i<V; i++){
//             //for multiple components in a graph
//             if(!visited[i])
//                 if(checkForCycle(i, V, adj, visited))
//                     return true;
//         }
        
//         return false;
//     }
    
    
//     private boolean checkForCycle(int src, int V, ArrayList<ArrayList<Integer>> adj, boolean visited []){
//         visited[src]=true;
//         Queue<Pair> q = new LinkedList<>();
//         q.offer(new Pair(src, -1));
        
//         while(!q.isEmpty()){
//             int node=q.peek().child;
//             int parent=q.peek().parent;
//             q.poll();
            
//             //traverse node's adj. list
//             for(int adjacentNode : adj.get(node)){
//                 if(visited[adjacentNode]==false){
//                     visited[adjacentNode]=true;
//                     q.offer(new Pair(adjacentNode, node));
//                 }
//                 //if the adj node of the node is not a parent and its already visited 
//                 //then its a cycle in an undirected graph since some other node has already visited
//                 else if(parent!=adjacentNode)
//                     return true;
//             }
//         }
        
//         return false;

//     }
// }


//DFS
class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        
        int visited [] = new int [V];
        
        for(int i=0;i<V;i++){
            if(visited[i]==0)
                if(dfs(i,-1, visited, adj)==true)
                    return true;
        }
        
        return false;
    }
    
    
    private boolean dfs(int node, int parent, int visited [] , ArrayList<ArrayList<Integer>> adj){
        
        visited[node]=1;
        
        for(int adjacentNode : adj.get(node)){
                if(visited[adjacentNode]==0){
                    if(dfs(adjacentNode, node, visited, adj)==true)
                        return true;
                }
                
                //if the adj node of the node is not a parent and its already visited 
                //then its a cycle in an undirected graph since some other node has already visited
                else if(parent!=adjacentNode)
                     return true;
            }
        
        return false;
    }

}    
    