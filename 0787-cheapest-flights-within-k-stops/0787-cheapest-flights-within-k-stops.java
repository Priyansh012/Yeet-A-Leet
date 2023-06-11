class AdjPair{
    int node;
    int weight;

    AdjPair(int _node, int _weight){
        this.node=_node;
        this.weight=_weight;
    }
}

class StopsPair{
    int stops;
    int distance;
    int node;

    StopsPair(int _stops, int _node, int _distance){
        this.stops=_stops;
        this.distance=_distance;
        this.node=_node;
    }
}

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<AdjPair>> adj = new ArrayList<ArrayList<AdjPair>>();
        for(int i=0;i<n;i++)
            adj.add(new ArrayList<>());
        
        int totalEdges=flights.length;
        //creating adj list(node, weight) from the flights array
        for(int i=0;i<totalEdges;i++){
            adj.get(flights[i][0]).add(new AdjPair(flights[i][1], flights[i][2]));
        }

        Queue<StopsPair> q = new LinkedList<>();

        //stops, src, distance
        q.add(new StopsPair(0,src,0));

        int dist [] = new int[n];

        for(int i=0;i<n;i++)
            dist[i]=(int)(1e9);

        dist[src]=0;

        while(!q.isEmpty()){
            StopsPair it= q.peek();
            q.remove();
            int stops=it.stops;
            int cost=it.distance;
            int node=it.node;

            //stops should be atmost k hence we cant continue if its more than k stops
            if(stops>k)
                continue;

            for(AdjPair neighbor: adj.get(node)){
                int adjNode=neighbor.node;
                int edgeWt=neighbor.weight;

                if(cost+edgeWt<dist[adjNode] && stops<=k){
                    dist[adjNode]=cost+edgeWt;
                    q.offer(new StopsPair(stops+1, adjNode, cost+edgeWt));
                }
            }
        }

        if(dist[dst]==(int)(1e9))
            return -1;
        
        return dist[dst];
    }
}