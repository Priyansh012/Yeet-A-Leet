class Pair{
    int first;
    int second;

    Pair(int _first, int _second){
        this.first=_first;
        this.second=_second;
    }
}

//Dijkstra's
class Solution {
    public int countPaths(int n, int[][] roads) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        //Undirected graph adj. list with distance
        for(int i=0;i<roads.length;i++){
            adj.get(roads[i][0]).add(new Pair(roads[i][1], roads[i][2]));
            adj.get(roads[i][1]).add(new Pair(roads[i][0], roads[i][2]));
        }

        //min-heap
        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y) -> x.first-y.first);
        long dist[]= new long[n];
        long ways[]= new long[n];
        
        for(int i=0;i<n;i++){
            dist[i]=Long.MAX_VALUE;
        }

        dist[0]=0;
        ways[0]=1;

        //distance, node
        pq.add(new Pair(0,0));

        int mod=(int) 1e9+7;

        // Iterate through the graph with the help of priority queue just like Dijkstra's
        while (!pq.isEmpty()) {
            int dis = pq.peek().first;
            int node = pq.peek().second;
            pq.remove();

            for (Pair it : adj.get(node)) {
                int adjNode = it.first;
                int edW = it.second;

                // This ‘if’ condition signifies that this is the first
                // time we’re coming with this short distance, so we push
                // in PQ and keep the no. of ways the same.
                if (dis + edW < dist[adjNode]) {
                    dist[adjNode] = dis + edW;
                    pq.add(new Pair(dis + edW, adjNode));
                    ways[adjNode] = ways[node];
                } 

                // If we again encounter a node with the same short distance
                // as before, we simply increment the no. of ways.
                else if (dis + edW == dist[adjNode]) {
                    ways[adjNode] = (ways[adjNode] + ways[node]) % mod;
                }
            }
        }
        // Finally, we return the no. of ways to reach
        // (n-1)th node modulo 10^9+7.
        return (int)ways[n - 1] % mod;

    }
}