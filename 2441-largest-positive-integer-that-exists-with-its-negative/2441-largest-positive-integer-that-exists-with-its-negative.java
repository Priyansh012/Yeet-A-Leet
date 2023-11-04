class Solution {
    public int findMaxK(int[] nums) {
        Arrays.sort(nums);
        int left=0, right=nums.length-1;
        while(left<right){
            if(nums[left]!=nums[right] && Math.abs(nums[left])==Math.abs(nums[right]))
                return nums[right];
            
            else if(Math.abs(nums[left])>Math.abs(nums[right]))
                left++;
            else
                right--;
        }

        return -1;
    }
}