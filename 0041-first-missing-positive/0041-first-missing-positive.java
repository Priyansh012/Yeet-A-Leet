class Solution {
    public int firstMissingPositive(int[] nums) {
        int correctIndex, temp;
        int size=nums.length;
        for(int i=0;i<size;i++){
            correctIndex=nums[i]-1;
            while(nums[i]>0 && nums[i]<=size && nums[i]!=nums[correctIndex]){
                temp=nums[i];
                nums[i]=nums[correctIndex];
                nums[correctIndex]=temp;
                correctIndex=nums[i]-1;
            }
        }
        
        for(int i=0;i<size;i++){
            if(nums[i]!=i+1)
                return i+1;
        }
        
        return size+1;
    }
}