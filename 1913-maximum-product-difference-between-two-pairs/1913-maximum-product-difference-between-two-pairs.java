class Solution {
    public int maxProductDifference(int[] nums) {
        int max,wx,yz;
        int n=nums.length;
        int secondLastIndex=n-2;
        int prevIndex=n-1;
        Arrays.sort(nums);
        wx= nums[prevIndex]*nums[secondLastIndex];
        yz=nums[0]*nums[1];
        return wx-yz;
    }
}

/*Optimal solution O(n)
class Solution {
    public int maxProductDifference(int[] nums) {
        int max1 = Integer.MIN_VALUE;
        int max2 = max1;

        int min1 = Integer.MAX_VALUE;
        int min2 = min1;
        for (int i = 0; i < nums.length; i++) {
            if (max1 < nums[i]) {
                max2 = max1;
                max1 = nums[i];
            } else if(nums[i] > max2)
                max2 = nums[i];

            if(min1 > nums[i]){
                min2 = min1;
                min1 = nums[i];
            }else if (nums[i] < min2)
                min2 = nums[i];
        }
        
        return (max1 * max2) - (min1 * min2);
    }
}
*/