class Solution {
    public int findNumbers(int[] nums) {
        int count=0;
        int n=nums.length;
        String temp = "";
        for(int i=0;i<n;i++){
            temp= Integer.toString(nums[i]);
            if(temp.length()%2==0)
                count++;
        }

        return count;
    }
}