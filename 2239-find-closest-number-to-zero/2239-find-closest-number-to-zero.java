class Solution {
    public int findClosestNumber(int[] nums) {
        HashMap<Integer, Integer> numsDistance= new HashMap<Integer, Integer>();
        
        for(int i=0;i<nums.length;i++){
            numsDistance.put(nums[i], Math.abs(0-nums[i]));
        }

    Map.Entry<Integer, Integer> min = null;
    for (Map.Entry<Integer, Integer> entry : numsDistance.entrySet()) {
        if (min == null || min.getValue() > entry.getValue()) {
            min = entry;
        }
    }
    if(min.getKey()<0 && numsDistance.containsKey(Math.abs(min.getKey())))
        return Math.abs(min.getKey());
    return min.getKey();
    }
}