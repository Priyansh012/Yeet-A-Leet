class Solution {
    public int[] separateDigits(int[] nums) {
        List<Integer> ans= new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            String temp= Integer.toString(nums[i]);
            for(int j=0;j<temp.length();j++){
                ans.add(temp.charAt(j) - '0');
            }
        }
        
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}