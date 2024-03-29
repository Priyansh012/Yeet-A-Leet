//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V; i++)
                list.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if (new Solution().isCyclic(V, list) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends


/*Complete the function below*/

//DFS
// class Solution {
//     // Function to detect cycle in a directed graph.
//     public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
//         int vis[] = new int[V];
//         int pathVis[] = new int[V];
        
//         //to visit all components in a graph
//         for(int i=0;i<V;i++){
//             if(vis[i]==0){
//                 if(dfsCycleCheck(i, vis, pathVis, adj)==true)
//                     return true;
//             }
//         }
//         return false;
//     }
    
//     private boolean dfsCycleCheck(int node, int vis[], int pathVis [], ArrayList<ArrayList<Integer>> adj){
//         vis[node]=1;
//         pathVis[node]=1;
        
//         //traverse adj nodes to check if they have cycle(i.e. vis[it]==1 and path[it]==1)
//         for(int it: adj.get(node)){
//             if(vis[it]==0){
//                 if(dfsCycleCheck(it, vis, pathVis, adj)==true)
//                     return true;
//             }
//             else if(pathVis[it]==1)
//                 return true;
                
//         }
        
//         //node neighbors left, so change path vis to 0 and return false
//         pathVis[node]=0;
//         return false;
//     }
// }


//BFS
class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        int inDegree[] = new int[V];
        Queue<Integer> q = new LinkedList<Integer>();
        
        //fill indegrees
        for(int i=0;i<V;i++){
            for(int adjNode: adj.get(i))
                inDegree[adjNode]++;
        }
        
        for(int i=0;i<V;i++){
            if(inDegree[i]==0)
                q.add(i);
        }
        
        int count=0;
        while(!q.isEmpty()){
            int node=q.poll();
            count++;
            for(int neighbor: adj.get(node)){
                inDegree[neighbor]--;
                if(inDegree[neighbor]==0){
                   q.add(neighbor);
                }
                    
            }
            
        }
        
        if(count==V)
            return false;
        
        return true;
    }
}