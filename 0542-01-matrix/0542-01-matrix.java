class Pair{
    int m;
    int n;
    int steps;

    Pair(int _m, int _n, int _steps){
        this.m=_m;
        this.n=_n;
        this.steps=_steps;
    }
}

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m=mat.length;
        int n=mat[0].length;

        int vis [][] = new int [m][n];
        int dist [][] = new int [m][n];

        Queue<Pair> q = new LinkedList<Pair>();

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==0){
                    q.offer(new Pair(i,j,0));
                    vis[i][j]=1;
                }
            }
        }

        //top, right, bottom, left
        int deltaRow [] = {-1, 0, +1, 0};
        int deltaCol [] = {0, +1, 0, -1};


        //bfs
        while(!q.isEmpty()){
            int row=q.peek().m;
            int col=q.peek().n;
            int steps=q.peek().steps;

            q.poll();

            dist[row][col]=steps;

            //traverse the nodes four neighbors
            for(int i=0;i<4;i++){
                int nRow= row+deltaRow[i];
                int nCol= col+deltaCol[i];

                if(nRow>=0 && nRow<m && nCol>=0 && nCol<n && vis[nRow][nCol]==0){
                    vis[nRow][nCol]=1;
                    q.offer(new Pair(nRow, nCol, steps+1));
                }
            }

        }

        return dist;

    }
}