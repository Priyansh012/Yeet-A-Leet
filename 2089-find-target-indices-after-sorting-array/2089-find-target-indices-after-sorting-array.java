class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        ArrayList<Integer> result = new ArrayList<Integer>();

        Arrays.sort(nums);

        for(int i=0;i<nums.length;i++){
            if(nums[i]==target)
                result.add(i);
        }

        return result;
    }
}