class Solution {

    //TC: O(NlogN)
    public int longestConsecutive(int[] nums) {
        if(nums.length==0)
            return 0;
        if(nums.length==1)
            return 1;
        Arrays.sort(nums);
        List<Integer> curSeq = new ArrayList<>();
        int max=0;
        curSeq.add(nums[0]);
        for(int i=1;i<nums.length;i++){
            if(nums[i]==nums[i-1]){
                continue;
            }
            if(nums[i]==nums[i-1]+1){
                curSeq.add(nums[i]);
            }
            else{
                curSeq.clear();
                curSeq.add(nums[i]);
            }
            max=Math.max(max, curSeq.size());
        }

        return Math.max(max,curSeq.size());
    }

    //TC: O(N)
    //public int longestConsecutive(int[] nums) {
    
    //}

}