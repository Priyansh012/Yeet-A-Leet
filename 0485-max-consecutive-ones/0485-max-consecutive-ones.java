class Solution {
    //O(N*N)
   /* public int findMaxConsecutiveOnes(int[] nums) {
        int left=0;
        int right=0;
        int max=0;
        int curCount=0;

        while(left<nums.length){
            while(right<nums.length && nums[right]!=0){
                curCount+=1;
                right+=1;
            }
            max=Math.max(curCount,max);
    
            left+=1;
            right=left;
            curCount=0;
        }        

        return max;
    }*/

    public int findMaxConsecutiveOnes(int[] nums) {
        int max=0;
        int sum=0;
        int n=nums.length;
        
        for(int i=0;i<n;i++){
            sum+=nums[i];
            if(nums[i]==0)
                sum=0;
            else
                max=Math.max(sum,max);
        }

        return max;

    }
}