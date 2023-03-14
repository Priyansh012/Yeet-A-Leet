class Solution {
    public int findMin(int[] nums) {
        int low=0, high=nums.length-1;
        int mid;

        if(nums.length==1)
            return nums[low];
    
        while(low<=high){
            mid=low+ (high-low)/2;

            if(mid!=0 && nums[mid-1]>nums[mid])
                return nums[mid];

            if(nums[low]>nums[mid]){
                high=mid-1;      
            }

            else if(nums[mid]>nums[high]){
                low=mid+1;
            }

            else if(nums[mid+1]< nums[mid])
                return nums[mid+1];

            else
                return nums[low];
        }

        return nums[low];
    }
}