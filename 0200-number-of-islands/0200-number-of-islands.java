class Solution {
    //Connected component problem, can be done easily via DFS
    public int numIslands(char[][] grid) {
        int islands=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]=='1'){
                    islands+=1;
                    dfs(grid,i,j, grid.length, grid[i].length);
                }
            }
        }

        return islands;
    }

    public void dfs(char[][] grid, int row, int col, int m, int n){
        //base condition to break recursion
        if(row<0 || row>=m || col<0 || col>=n || grid[row][col]=='0'){
            return;
        }

        grid[row][col]='0';
        //recursive dfs call for neighbors
        //top
        dfs(grid, row-1, col, m, n);
        //right
        dfs(grid, row, col+1, m, n);
        //bottom
        dfs(grid, row+1, col, m, n);
        //left
        dfs(grid, row, col-1, m, n);
    }
}