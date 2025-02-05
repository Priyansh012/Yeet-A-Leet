class Solution {
    //Bruteforce
    /*public long countFairPairs(int[] nums, int lower, int upper) {
        long sum=0;
        long count=0;

        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                sum=nums[i]+nums[j];
                if(sum>=lower && sum<=upper)
                    count+=1L;
            }
        }

        return count;
    }*/

    public long countFairPairs(int[] nums, int lower, int upper) {
       Arrays.sort(nums);
       long result=0;

        for(int i=0;i<nums.length;i++){
            int low=lower-nums[i];
            int up=upper-nums[i];

            result+=
            (
                binarySearch(i+1, nums.length-1, up+1, nums) -
                binarySearch(i+1, nums.length-1, low, nums)
            );
        }

        return result;
    }

    private long binarySearch(int low, int high, int target, int nums []){
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]>=target){
                high=mid-1;
            }
            else
                low=mid+1;
        }

        return low;
    }

}