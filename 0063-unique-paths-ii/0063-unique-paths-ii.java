class Solution {
    //Recursion
    /*public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        
        return f(m-1, n-1, obstacleGrid);
    }
    
    private int f(int i, int j, int mat[][]){
        if(i>=0 && j>=0 && mat[i][j]==1)
            return 0;
        
        if(i==0 && j==0)
            return 1;
        
        if(i<0 || j<0)
            return 0;
        
        int up=f(i-1, j, mat);
        int left=f(i, j-1, mat);

        return up+left;
    }*/

    //Memoization
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int dp[][] = new int [m][n];
        
        for(int i=0;i<m;i++){
            Arrays.fill(dp[i], -1);
        }

        return f(m-1, n-1, obstacleGrid, dp);
    }
    
    private int f(int i, int j, int mat[][], int dp[][]){
        if(i>=0 && j>=0 && mat[i][j]==1)
            return 0;
        
        if(i==0 && j==0)
            return 1;
        
        if(i<0 || j<0)
            return 0;
        
        if(dp[i][j]!=-1)
            return dp[i][j];
        
        int up=f(i-1, j, mat, dp);
        int left=f(i, j-1, mat, dp);

        dp[i][j] = up+left;
        return dp[i][j];
    }
}