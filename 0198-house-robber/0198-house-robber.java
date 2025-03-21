class Solution {

    /* Recursion approach : TC: O(2^N), SC: O(N)+O(N)
    public int rob(int[] nums) {
        int n=nums.length;
        return f(n-1, nums);
    }

    //recursion function
    private int f(int index, int [] nums){
        if(index==0)
            return nums[index];
        
        if(index<0)
            return 0;
        
        int pick = nums[index] + f(index-2, nums);
        int notPick = 0 + f(index-1, nums);
    
        return Math.max(pick, notPick);
    }*/

    //Memoization appraoch : TC: O(N), SC: O(N)+O(N)
    /*public int rob(int[] nums) {
        int n=nums.length;
        int dp [] = new int [n];
        Arrays.fill(dp, -1);
        return f(n-1, nums, dp);
    }

    private int f(int index, int [] nums, int [] dp){
        if(index==0)
            return nums[index];
        
        if(index<0)
            return 0;
        
        //overlapping sub problem
        if(dp[index]!=-1)
            return dp[index];
        
        int pick = nums[index] + f(index-2, nums, dp);
        int notPick = 0 + f(index-1, nums, dp);
    
        dp[index] = Math.max(pick, notPick);

        return dp[index];
    }*/

    //Tabulation appraoch : TC: O(N), SC: O(N)
    public int rob(int[] nums) {
        int n=nums.length;
        int dp [] = new int [n];
        Arrays.fill(dp, -1);

        // base cases
        dp[0] = nums[0];
        int negative = 0;
        
        for(int i=1; i<n; i++){
            if(dp[i]!=-1)
                return dp[i];
            
            int pick = nums[i];
            if(i>1)
                pick+=dp[i-2];
            else
                pick+=negative;
            
            int notPick = 0 + dp[i-1];
    
            dp[i] = Math.max(pick, notPick);
        }

        return dp[n-1];
    }
}