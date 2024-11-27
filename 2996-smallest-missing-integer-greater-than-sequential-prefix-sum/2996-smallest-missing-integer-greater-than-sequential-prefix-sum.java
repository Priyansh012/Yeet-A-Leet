class Solution {
    public int missingInteger(int[] nums) {
        int sum=nums[0];
        int result=0;
        int iterator=0;
        for(int i=1;i<nums.length;i++){
            if(nums[i-1]+1==nums[i]){
                sum+=nums[i];
            }
            else{
                iterator=i;
                if(i==1)
                    sum+=1;
                break;
            }
        }
        Arrays.sort(nums);
        result=sum;
        while(iterator<nums.length){
            if(nums[iterator]==sum){
                sum+=1;
            }

            iterator+=1;
        }

        return sum;
    }
}