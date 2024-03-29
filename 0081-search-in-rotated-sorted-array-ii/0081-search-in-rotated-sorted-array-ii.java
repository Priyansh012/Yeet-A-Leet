class Solution {
    public boolean search(int[] nums, int target) {
        int low=0, high=nums.length-1;
        int mid;

        while(low<=high){
            mid=low+(high-low)/2;
            if(nums[mid]==target)
                return true;
            if(nums[low]<nums[mid] || nums[high]<nums[mid]){ 
                if(target>=nums[low] && target<nums[mid]){
                    high=mid-1;
                }
                else
                    low=mid+1;       
            }
            else if(nums[low]>nums[mid] || nums[high]>nums[mid]){
                if(target<=nums[high] && target>nums[mid]){
                    low=mid+1;        
                }
                else
                    high=mid-1;
            }

            else
                high--;
            
        }

        return false;
    }
}