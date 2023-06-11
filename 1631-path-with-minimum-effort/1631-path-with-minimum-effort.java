class Pair{
    int row;
    int col;
    int distance;

    Pair(int _distance, int _row, int _col){
        this.row=_row;
        this.col=_col;
        this.distance=_distance;
    }

}

//Dijkstra's Algo
class Solution {
    public int minimumEffortPath(int[][] heights) {
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x,y) -> x.distance - y.distance);

        int m=heights.length;
        int n=heights[0].length;
        int dist [][] = new int [m][n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dist[i][j]=(int)1e9;
            }
        }

        dist[0][0]=0;
        pq.add(new Pair(0, 0, 0));
        //4 directional move
        int deltaRow [] = {-1, 0, 1, 0};
        int deltaCol [] = {0, 1, 0, -1};

        while(!pq.isEmpty()){
            Pair node= pq.poll();

            int row=node.row;
            int col=node.col;
            int diff=node.distance;

            if(row==m-1 && col==n-1)
                return diff;

            //traverse the node's four neighbors
            for(int i=0;i<4;i++){
                int nRow= row+deltaRow[i];
                int nCol= col+deltaCol[i];

                if(nRow>=0 && nRow<m && nCol>=0 && nCol<n){
                    int nEffort=Math.max(Math.abs(heights[row][col] - heights[nRow][nCol])
                    , diff);
                    if(nEffort<dist[nRow][nCol]){
                        dist[nRow][nCol]=nEffort;
                        pq.offer(new Pair(nEffort, nRow, nCol));
                    }
                }
                    
            }
        }
        return 0;
    }
}