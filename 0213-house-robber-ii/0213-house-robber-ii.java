class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1)
            return nums[0];
        
        List<Integer> temp = new ArrayList<>();
        List<Integer> temp2 = new ArrayList<>();

        for(int i=0; i<n; i++){
            if(i!=0)
                temp.add(nums[i]);
            
            if(i!=n-1)
                temp2.add(nums[i]);
        }

        return Math.max(maxOfNonAdj(temp), maxOfNonAdj(temp2));
    }

    //Tabulation appraoch with space opt : TC: O(N), SC: O(1)
    public int maxOfNonAdj(List<Integer> nums) {
        int n=nums.size();
        // base cases
        int prev=nums.get(0);
        int prev2=0;
        int negative = 0;
        
        for(int i=1; i<n; i++){
            int pick = nums.get(i);
            if(i>1)
                pick+=prev2;
            else
                pick+=negative;
            
            int notPick = 0 + prev;
    
            int curi = Math.max(pick, notPick);
            prev2=prev;
            prev=curi;
        }

        return prev;
    }
}