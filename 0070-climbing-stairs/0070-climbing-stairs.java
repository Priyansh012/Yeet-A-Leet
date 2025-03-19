class Solution {
    // Recursion approach (Simple but inefficient for large n)
    /*
    public int climbStairsRecursion(int n) {
        return climb(n);
    }

    private int climb(int n) {
        if (n == 0) return 1;
        if (n == 1) return 1;
        return climb(n - 1) + climb(n - 2);
    }
    */

    // Memoization (Top-Down Dynamic Programming)
    /*
    public int climbStairsMemoization(int n) {
        int[] memo = new int[n + 1];
        return climb(n, memo);
    }

    private int climb(int n, int[] memo) {
        if (n == 0) return 1;
        if (n == 1) return 1;
        if (memo[n] != 0) return memo[n];
        memo[n] = climb(n - 1, memo) + climb(n - 2, memo);
        return memo[n];
    }
    */

    // Tabulation (Bottom-Up Dynamic Programming)
    /*
    public int climbStairsTabulation(int n) {
        if (n == 0) return 1;
        if (n == 1) return 1;
        
        int[] dp = new int[n + 1];
        dp[0] = 1; // Base case: 1 way to reach step 0 (staying put)
        dp[1] = 1; // Base case: 1 way to reach step 1
        
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2]; // sum of the previous two steps
        }
        
        return dp[n];
    }
    */

    // Space Optimization (Space complexity reduced to O(1))
    public int climbStairs(int n) {
        if (n == 0) return 1;
        if (n == 1) return 1;

        int prev2 = 1, prev1 = 1;
        for (int i = 2; i <= n; i++) {
            int current = prev1 + prev2;
            prev2 = prev1;
            prev1 = current;
        }

        return prev1;
    }
}