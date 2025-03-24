class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int m=triangle.size();
        int dp[][] = new int[m][m];

        for(int i=0;i<m;i++)
            Arrays.fill(dp[i], -1);

        return f(0, 0, triangle, m, dp);
    }

    private int f(int i, int j, List<List<Integer>> triangle, int m, int dp[][]){
        if(i==m-1)
            return triangle.get(m-1).get(j);
        if(dp[i][j]!=-1)
            return dp[i][j];
        int down = triangle.get(i).get(j) + f(i+1, j, triangle, m, dp);
        int diagonal = triangle.get(i).get(j) + f(i+1, j+1, triangle, m, dp);

        dp[i][j] =  Math.min(down, diagonal);
        return dp[i][j];
    }
}