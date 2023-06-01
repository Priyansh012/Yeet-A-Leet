class Solution {
    public boolean isBipartite(int[][] graph) {
        int V=graph.length;
        int color [] = new int [V];

        System.out.println(graph);
        for(int i=0;i<V;i++){
            color[i]=-1;
        }

        for(int i=0;i<V;i++){
            if(color[i]==-1){
                if(dfs(i, 0, color, graph)==false)
                    return false;
            }
        }

        return true;
    }

    private boolean dfs(int node, int nodeColor, int color [], int graph[][]){
        color[node]=nodeColor;
        for(int neighbor: graph[node]){
            if(color[neighbor]==-1){
                if(dfs(neighbor, 1-nodeColor, color, graph)==false)
                    return false;
            }

            else if(color[neighbor]==nodeColor)
                return false;

        }

        return true;
    }
}