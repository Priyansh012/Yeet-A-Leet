class Pair{
    int first;
    int second;

    Pair(int _first, int _second){
        this.first=_first;
        this.second=_second;
    }
}

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<Pair>> adj= new ArrayList<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y)-> x.first-y.first);

        //graph is 1-indexed so 0 to <=n
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<times.length;i++){
            adj.get(times[i][0]).add(new Pair(times[i][1], times[i][2]));
        }

        //graph is 1 indexed, so distance matrix 0 to <=n
        int dist[] = new int [n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        //need to ignore 0th node and also mark src node k's distance as 0
        dist[0]=0;
        dist[k]=0;
        pq.add(new Pair(0, k));
        
        while(!pq.isEmpty()){
            Pair p= pq.poll();
            int node=p.second;
            int cost=p.first;


            for(Pair neighbor: adj.get(node)){
                int adjNode=neighbor.first;
                int edgeWt=neighbor.second;

                if(cost+edgeWt<dist[adjNode]){
                    dist[adjNode]=cost+edgeWt;
                    pq.add(new Pair(edgeWt+cost, adjNode));
                }
               
            }
        }

        int result=Integer.MIN_VALUE;
        for(int i=0;i<=n;i++){
            if(dist[i]==Integer.MAX_VALUE)
                return -1;
            result=Math.max(dist[i], result);
        }

        return result;
            
    }
}