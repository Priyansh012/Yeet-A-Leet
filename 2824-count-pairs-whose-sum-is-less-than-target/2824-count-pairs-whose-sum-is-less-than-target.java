class Solution {
    //Bruteforce, O(n^2)
   /* public int countPairs(List<Integer> nums, int target) {
        int result=0;
        int left=0;

        Collections.sort(nums);
        while(left<nums.size()-1){
            for(int right=left+1;right<nums.size();right++){
                if((nums.get(left)+nums.get(right))>=target)
                    break;
                result+=1;
            }
            left+=1;
        }

        return result;
    }
*/

    //Two pointers
    public int countPairs(List<Integer> nums, int target) {
        int left=0, right=nums.size()-1;
        int result=0;

        Collections.sort(nums);

        while(left<right){
            if(nums.get(left)+nums.get(right)<target){
                result+=(right-left);
                left+=1;
            }

            else{
                right-=1;
            }

        }

        return result;
    }
}