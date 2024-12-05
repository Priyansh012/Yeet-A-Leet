class Solution {
    //TC: O(nlongn)
    //SC: O(1)
    /*public boolean containsDuplicate(int[] nums) {
        int n=nums.length;
        if(n==1)
            return false;

        Arrays.sort(nums);

        for(int i=0;i<n-1;i++){
            if(nums[i]==nums[i+1])
                return true;
        }

        return false;
    }*/

    //TC: O(n)
    //SC:O(n)
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for(int i=0;i<nums.length;i++){
            if(set.contains(nums[i]))
                return true;
            set.add(nums[i]);
        }


        return false;
    }
}