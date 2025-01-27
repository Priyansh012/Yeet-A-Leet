class Solution {
    public int findMin(int[] nums) {
        int result=nums[0];
        int left=0, right=nums.length-1;

        while(left<=right){
            //already sorted
            if(nums[left] < nums[right]){
                result=Math.min(nums[left], result);
                break;
            }
            int mid=left+(right-left)/2;
            result=Math.min(nums[mid], result);

            //rotation present -- so left half will contain the sorted max. portion of values
            //so we need to move towards right since our mid is in the left half
            if(nums[mid]>=nums[left]){
                left=mid+1;
            }

            //else we are already in the right half which contains min. portion of values
            //so we need to move towards left since our mid is in the right half
            else{
                right=mid-1;
            }
        }

        return result;
    }
}

/*class Solution {
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
}*/
