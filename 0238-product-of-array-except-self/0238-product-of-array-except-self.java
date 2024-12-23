class Solution {
    //Output is basically prefix*postfix array
    //O(N) Tc and SC=O(1) because no need to create prefix and postfix array
    public int[] productExceptSelf(int[] nums) {
        int output [] = new int [nums.length];

        output[0]=1;

        //compute prefix array
        int prefix=1;
        for(int i=0;i<nums.length;i++){ 
            output[i]=prefix;
            prefix=prefix*nums[i];
        }

        //compute postfix array
        int postfix=1;
        for(int i=nums.length-1;i>=0;i--){
            output[i]=output[i]*postfix;
            postfix=postfix*nums[i];
        }


        return output;

    }
}