class Solution {

    //Greedy Solution
    public boolean canJump(int[] nums) {
        int n=nums.length;
        int finishLine = n-1;

        for(int i=n-2; i>=0;i--){
            if(i+nums[i]>=finishLine){
                finishLine=i;
            }
        }

        return finishLine==0? true: false;

    }
}