class Solution {
    public int findCircleNum(int[][] isConnected) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

        for(int i = 0; i <isConnected.length; i++)
            adjList.add(new ArrayList<Integer>());

        //to convert adj. matrix to adj. list
        for(int i=0;i<isConnected.length;i++){
            for(int j=0;j<isConnected[i].length;j++){
                if(isConnected[i][j] == 1 && i!=j){
                    //since its an undirected graph and we will be traversing matrix[i][j] and matrix[j][i] separately so only adding it once in the adj list will work
                    adjList.get(i).add(j);
                }
            }
        }

        int visited [] = new int[isConnected.length];

        int count=0;
        for(int i=0;i<isConnected.length;i++){
            if(visited[i]==0){
                count++;
                dfs(i, visited, adjList);
            }
        }

        return count;
    }

    private static void dfs(int node, int visited [], ArrayList<ArrayList<Integer>> adj){
        visited[node] = 1;
        
        for(Integer it: adj.get(node)){
            if(visited[it]==0){
                dfs(it,visited, adj);
            }
        }
        
    }
}