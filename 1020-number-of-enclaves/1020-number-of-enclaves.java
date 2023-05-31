class Solution {
    public int numEnclaves(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int vis[][]= new int[m][n];
        int deltaRow[]= {-1, 0, +1, 0};
        int deltaCol[]= {0, +1, 0, -1};
        int count=0;

        //traverse boundary grids and mark 1s as visited since they can move out of grid
        //traverse rows(for each row go to all cols)
        for(int j=0;j<n;j++){
            //first row
            if(grid[0][j]==1 && vis[0][j]==0)
                dfs(0, j, grid, vis, deltaRow, deltaCol, m, n);
            
            //last row
            if(grid[m-1][j]==1 && vis[m-1][j]==0)
                dfs(m-1, j, grid, vis, deltaRow, deltaCol, m, n);
        }

        //traverse cols(for each cols, go to all the rows)
        for(int i=0;i<m;i++){
            //first col
            if(grid[i][0]==1 && vis[i][0]==0)
                dfs(i, 0, grid, vis, deltaRow, deltaCol, m, n);

            //last col
            if(grid[i][n-1]==1 && vis[i][n-1]==0)
                dfs(i, n-1, grid, vis, deltaRow, deltaCol, m, n);
        }

        //now count the non visited 1s in the grid and return count 
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1 && vis[i][j]==0){
                    vis[i][j]=1;
                    count+=1;
                }
            }
        }

        return count;
    }

    private void dfs(int row, int col, int grid [][], int vis [][], 
    int deltaRow [], int deltaCol[], int m, int n){

        vis[row][col]=1;

        //visit its four neighbors 
        for(int i=0;i<4;i++){
            int nRow=row+deltaRow[i];
            int nCol=col+deltaCol[i];

            if(nRow>=0 && nRow<m && nCol>=0 && nCol<n && grid[nRow][nCol]==1 && vis[nRow][nCol]==0){
                dfs(nRow, nCol, grid, vis, deltaRow, deltaCol, m, n);
            }
        }

    }
}