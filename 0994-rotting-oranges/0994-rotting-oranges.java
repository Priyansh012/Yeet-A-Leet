class Pair{
    int row;
    int col;
    int time;

    Pair(int _row, int _col, int _time){
        this.row=_row;
        this.col=_col;
        this.time=_time;
    }
}

class Solution {
    //BFS approach since every iteration will rotten the neighbor of the start node(or node with 2 value)
    public int orangesRotting(int[][] grid) {
        //rows
        int m= grid.length;
        //cols
        int n=grid[0].length;

        Queue<Pair> q = new LinkedList<>();
        int visited [][] = new int [m][n];
        int countFresh=0;
        
        //computing start nodes(ie. rotten nodes and marking them as visited)
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                    q.offer(new Pair(i,j,0));
                    //mark it as 2 to indicate its already rotten and visited
                    visited[i][j]=2;
                }
                else{
                    //mark it as 0 to indicate not rotten and not visited
                    visited[i][j]=0;
                }
                if(grid[i][j]==1)
                    countFresh++;
            }
        }
        

        //BFS
        int tm=0;
        // change in top, right, bottom, left
        int deltaRow [] = {-1, 0, +1, 0};
        int deltaCol [] = {0, +1, 0, -1};
        int convertToRottCount=0;
        while(!q.isEmpty()){
            //fetch the front of queues to compute BFS
            int row= q.peek().row;
            int col=q.peek().col;
            int time=q.peek().time;
            tm= Math.max(tm, time);
            //pop the front element
            q.poll();

            //rott neighbors(4 neighbors: top, right, bottom, left)
            for(int i=0;i<4;i++){
                int neighRow= row+deltaRow[i];
                int neighCol=col+deltaCol[i];

                //check for valid neighbors(ie. not outside grid( 0 to m/n) && fresh orange and not visited)
                if(neighRow>=0 && neighRow<m && neighCol>=0 && neighCol<n
                && grid[neighRow][neighCol]==1 && visited[neighRow][neighCol]==0){
                    q.offer(new Pair(neighRow, neighCol, time+1));
                    visited[neighRow][neighCol]=2;
                    convertToRottCount++;
                }
            }

        }

        if(countFresh!=convertToRottCount)
            return -1;
        
        return tm;
    }
}