
//Optimal Solution
class Solution {
    public int[] rearrangeArray(int[] nums) {
        int [] out = new int [nums.length];
        int j = 0;
        int k = 1;
        for(int i=0;i<nums.length;i++){
            if(nums[i] >= 0){
                out[j] = nums[i];
                j += 2;
            }else {
                out[k] = nums[i];
                k += 2;
            }
        }
        return out;
    }
}


//My Solution
// class Solution {
//     public int[] rearrangeArray(int[] nums) {
//         ArrayList<Integer> positiveList = new ArrayList<Integer>();
//         ArrayList<Integer> negativeList = new ArrayList<Integer>();
//         int n=nums.length;
//         int count=0;
//         for(int i=0;i<n;i++){
//             if(nums[i]<0)
//                 negativeList.add(nums[i]);
//             else
//                 positiveList.add(nums[i]);
//         }

//         while(count<n){
//             if(positiveList.size()!=0){
//                 nums[count]=positiveList.get(0);
//                 positiveList.remove(0);
//                 count++;
//             }
//             if(negativeList.size()!=0){
//                 nums[count]=negativeList.get(0);
//                 negativeList.remove(0);
//                 count++;
//             }
            
//         }

//         return nums;

//     }
// }