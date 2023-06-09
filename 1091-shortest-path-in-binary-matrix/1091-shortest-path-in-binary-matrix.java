class Pair{
    int row;
    int col;
    int length;

    Pair(int _row, int _col, int _length){
        this.row=_row;
        this.col=_col;
        this.length=_length;
    }

}
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int N = grid.length;
        Queue <Pair> q = new LinkedList<>();
        int visited [][] = new int [N][N];

        q.add(new Pair(0, 0, 1));
        visited[0][0]= 1;

        //8 directional move
        int deltaRow [] = {-1, 0, 1, 0, 1, -1, 1, -1};
        int deltaCol [] = {0, 1, 0, -1, 1, -1, -1, 1};

        while(!q.isEmpty()){
            Pair node=q.poll();
            int row=node.row;
            int col=node.col;
            int length=node.length;

            if(Math.min(row,col)<0  || Math.max(row,col)>=N
            || grid[row][col]==1){
                continue;
            }

            //if it reached the destination i.e grid[N][N]
            if(row==N-1 && col==N-1)
                return length;
            
            //traverse the node's eigth neighbors
            for(int i=0;i<8;i++){
                int nRow= row+deltaRow[i];
                int nCol= col+deltaCol[i];

                if(nRow>=0 && nRow<N && nCol>=0 && nCol<N && visited[nRow][nCol]==0 
                && grid[nRow][nCol]==0){
                    q.offer(new Pair(nRow, nCol, length+1));
                    visited[nRow][nCol]=1;
                }
            }
            
        }

        return -1;
    }
}