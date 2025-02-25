class Solution {
    public int findPeakElement(int[] nums) {
        int left=0, right=nums.length-1;

        while(left<=right){
            int mid=left+(right-left)/2;

            //move towards left side if left of mid is greater
            if(mid>0 && nums[mid]<nums[mid-1])
                right=mid-1;
            
             //move towards right side if right of mid is greater
            else if(mid<nums.length-1 && nums[mid]<nums[mid+1])
                left=mid+1;
            else
                return mid;
        }

        return 0;
    }
}