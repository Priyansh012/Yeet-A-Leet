class Solution {
    //Tabulation DP
    public int climbStairs(int n) {
        //base case
			if(n<=2)
				return n;
			int prev2=1;
			int prev=2;
			int curr=0;
			
			for(int i=2;i<n;i++) {
				curr=prev2+prev;
				prev2=prev;
				prev=curr;
			}
			
			return prev;
			}
}