class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<Integer> nums1NotIn2 = Arrays.stream(nums1).distinct().boxed().collect(Collectors.toList());
        List<Integer> nums2NotIn1 = Arrays.stream(nums2).distinct().boxed().collect(Collectors.toList());
        ArrayList<List<Integer>> answer = new ArrayList<List<Integer>>();
        answer.add(new ArrayList<>());
        answer.add(new ArrayList<>());
        for(int nums: nums1NotIn2){
            if(!nums2NotIn1.contains(nums))
            	answer.get(0).add(nums);
        }
        for(int nums: nums2NotIn1){
            if(!nums1NotIn2.contains(nums))
            	answer.get(1).add(nums);
        }
        return answer;
    }
}