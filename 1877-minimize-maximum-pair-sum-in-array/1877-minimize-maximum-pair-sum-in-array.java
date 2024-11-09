class Solution {
    public int minPairSum(int[] nums) {
        int result=Integer.MIN_VALUE;
        int left=0, right=nums.length-1;

        Arrays.sort(nums);
        
        while(left<right){
            result=Math.max(result, nums[left]+nums[right]);
            left++;
            right--;
        }

        return result;
    }
}