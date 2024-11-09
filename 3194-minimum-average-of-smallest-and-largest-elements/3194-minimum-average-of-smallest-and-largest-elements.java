class Solution {
    public double minimumAverage(int[] nums) {
        int left = 0, right = nums.length - 1;
        double result = Double.MAX_VALUE;

        Arrays.sort(nums);
        while (left < right) {
            result = Math.min(result, (double) (nums[left] + nums[right]) / 2);
            left++;
            right--;
        }

        return result;

    }
}