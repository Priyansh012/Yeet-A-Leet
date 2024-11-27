class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int result [] = new int [2];
        int iterator=0;
        for(int i=0;i<nums.length;i++){
            if(!set.add(nums[i])){
                result[iterator]=nums[i];
                iterator++;
            }
             if(iterator==2)
                break;   
        }

        return result;
    }
}