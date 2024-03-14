class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n=nums.length;
        int high=n-1, low=0, mid;

        if(n==1)
            return nums[0];
        while(low<=high){
            mid=low+(high-low)/2;

            //if mid is 0 and mid+1 element!=mid
            if(mid==0 && nums[mid]!=nums[mid+1]){
                return nums[0];
            }

            //if mid is n-1 and mid-1 elemnt!=mid
            else if(mid==n-1 && nums[mid]!=nums[mid-1]){
                return nums[n-1];
            }

            //if mid element != mid+1 && mid element not equal to mid-1 element
            else if(nums[mid]!=nums[mid+1] && nums[mid]!=nums[mid-1]){
                return nums[mid];
            }

            // if (even,odd) pair for duplicate elements index then we are in left half
            //eliminate left half and move to right
            else if((nums[mid]==nums[mid+1] && mid%2==0) || (nums[mid]==nums[mid-1] && mid%2!=0)){
                low=mid+1;
            }

            // if (odd, even) pair for duplicate elements index then we are in right half
            //eliminate right half and move to left
            else{
                high=mid-1;
            }
        }

        return nums[low];
    }
}