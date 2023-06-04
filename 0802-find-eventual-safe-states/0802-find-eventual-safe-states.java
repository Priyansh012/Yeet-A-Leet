class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<List<Integer>> adjReverse = new ArrayList<>();
        int V=graph.length;
        int inDegree [] = new int[V];
        for(int i=0;i<V;i++){
            adjReverse.add(new ArrayList<>());
        }

        //creating a new adjlist in reverse order from adj matrix
        for(int i=0;i<V;i++){
            for(int neighbor: graph[i]){
                //basically changing the edge direction
                //or we can say, we are inversing the adj. list
                adjReverse.get(neighbor).add(i);
                //so now outdegree becomes inDegree so increment inDegree
                inDegree[i]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        List<Integer> safeNodes = new ArrayList<>();

        for(int i=0;i<V;i++){
            if(inDegree[i]==0)
                q.add(i);
        }

        while(!q.isEmpty()){
            int node = q.poll();
            safeNodes.add(node);

            for(int neighbor: adjReverse.get(node)){
                inDegree[neighbor]--;
                if(inDegree[neighbor]==0)
                    q.add(neighbor);
            }
        }

        Collections.sort(safeNodes);

        return safeNodes;
    }
}