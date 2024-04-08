class Solution {

    //Bruteforce && Better(O(N^2)) approach
    /*public int maxSubArray(int[] nums) {
        int max=Integer.MIN_VALUE;
        int n=nums.length;

        for(int i=0;i<n;i++){
            int sum=0;
            for(int j=i;j<n;j++){
                //Bruteforce(O(N^3))
                // int sum=0;
                // for(int k=i;k<=j;k++){
                //     sum+=nums[k];
                // }
                //max=Math.max(sum, max);
                sum+=nums[j];
                max=Math.max(sum, max);
            }
        }

        return max;
    }*/

    //Optimal approach(Kadane's algo) O(N)
    public int maxSubArray(int[] nums) {
        int max=Integer.MIN_VALUE;
        int sum=0;
        int n=nums.length;

        for(int i=0;i<n;i++){
            sum+=nums[i];
            
            max=Math.max(sum, max);

            if(sum<0)
                sum=0;
        }
        
        return max;
    }
}