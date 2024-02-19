class Solution {
    //Recursion -- Bruteforce
    //TC- exponential
    //SC- auxilary stack soace
    /*public int uniquePaths(int m, int n) {
        int result= countUniquePaths(0, 0, m,n);

        return result;
    }*/

    /*public int countUniquePaths(int i, int j, int m, int n){
        
        //out of bound
        if(i>=m || j>=n)
            return 0;

        //finish is reached
        if(i==m-1 && j==n-1)
            return 1;
        
        //else move down once and move right recursively till end/boundary of grid is reached 
        else return countUniquePaths(i+1,j, m, n)+countUniquePaths(i,j+1, m, n);
    }*/

    //DP -- Better
    //TC - O(mn)
    //SC - O(mn)
    /*public int uniquePaths(int m, int n) {
        int dp [][]= new int[m][n];

        //initial all grids of dp with -1
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }
        int result= countUniquePaths(0, 0, m,n, dp);
        return result;
    }

    public int countUniquePaths(int i, int j, int m, int n, int dp [][]){
        
        //out of bound
        if(i>=m || j>=n)
            return 0;

        //finish is reached
        if(i==m-1 && j==n-1)
            return 1;
        
        //if value already present, do not traverse downwards, use that value
        if(dp[i][j]!=-1)
            return dp[i][j];
        //else move down once and move right recursively till end/boundary of grid is reached
        //and insert the value into the dp array so that in future we can use that value
        else return dp[i][j]=countUniquePaths(i+1,j, m, n, dp)+countUniquePaths(i,j+1, m, n, dp);
    }*/

    //Combinatorics -- Optimal
    //TC- O(m-1) or O(n-1)
    //SC- O(1)
    //NCr formula for Combinations
    public int uniquePaths(int m, int n) {
        //m-1+n-1
        int N= m+n-2;
        int r= Math.min(m-1,n-1);
        double result=1;

        for(int i=1;i<=r;i++){
            result=result*(N-r+i)/i;
        }

        return (int)result;
    }
}