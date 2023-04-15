class Solution {
    public int numIdenticalPairs(int[] nums) {
        int count=0;
        for(int i=0;i<nums.length;i++)
            for(int j=1;j<nums.length;j++){
                if(nums[i] == nums[j] && i<j){
                    count++;
                }
            }
        return count;
    }
}

//Optimal approach
//     class Solution {
//     public int numIdenticalPairs(int[] nums) {
        
//         int ans = 0;
//         int[] count = new int[101];
        
//         for(int n: nums)
//             count[n]++;
        
//         for(int n: count)
//             ans += (n * (n - 1))/2;
        
//         return ans;
//     }
// }