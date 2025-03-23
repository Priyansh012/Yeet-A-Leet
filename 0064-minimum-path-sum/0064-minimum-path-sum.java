class Solution {
    // Recursion approach
    /*public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        return f(m - 1, n - 1, grid);
    }

    private int f(int i, int j, int[][] grid) {
        if (i == 0 && j == 0)
            return grid[i][j];

        if (i < 0 || j < 0)
            return Integer.MAX_VALUE;

        int up = f(i - 1, j, grid);
        int left = f(i, j - 1, grid);

        int minPrev = Math.min(up, left);
        return grid[i][j] + minPrev;
    }*/

    //Memoization
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int dp [][] = new int[m][n];

        for(int i=0;i<m;i++){
            Arrays.fill(dp[i], -1);
        }

        return f(m - 1, n - 1, grid, dp);
    }

    private int f(int i, int j, int[][] grid, int [][] dp) {
        if (i == 0 && j == 0)
            return grid[i][j];

        if (i < 0 || j < 0)
            return Integer.MAX_VALUE;

        //overlapping subproblems
        if(dp[i][j]!=-1)
            return dp[i][j];

        int up = f(i - 1, j, grid, dp);
        int left = f(i, j - 1, grid, dp);

        int minPrev = Math.min(up, left);
        dp[i][j] = grid[i][j] + minPrev;
        return dp[i][j];
    }
}
