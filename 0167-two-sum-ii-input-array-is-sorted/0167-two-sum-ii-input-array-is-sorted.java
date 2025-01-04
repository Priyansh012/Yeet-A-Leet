class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left=0, right=numbers.length-1;
        int result [] = new int [2];
        int sum=0;
        while(left<right){
            sum=numbers[left]+numbers[right];
            if(sum==target){
                //+1 because its 1-indexed array
                result[0]=left+1;
                result[1]=right+1;
                return result;
            }

            else if(sum<target){
                left+=1;
            }

            else{
                right-=1;
            }

        }

        return result;
    }
}