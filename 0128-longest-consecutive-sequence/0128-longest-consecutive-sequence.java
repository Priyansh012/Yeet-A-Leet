class Solution {

    //TC: O(NlogN)
   /* public int longestConsecutive(int[] nums) {
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
    }*/

    //TC: O(N)
    public int longestConsecutive(int[] nums) {
        int n=nums.length;
        if(n==0)
            return 0;
        int longest=1;
        Set<Integer> set = new HashSet<>();

        for(int num:nums){
            set.add(num);
        }

        for(int num:set){
            
            if(!set.contains(num-1)){
                int count=1;
                int x=num;
                while(set.contains(x+1)){
                    x+=1;
                    count+=1;
                }
                longest=Math.max(longest, count);
            }  
        }
        return longest;
    }

}