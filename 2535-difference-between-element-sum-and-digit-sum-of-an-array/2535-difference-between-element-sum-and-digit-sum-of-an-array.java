class Solution {
    public int differenceOfSum(int[] nums) {
       int elementSum=0;
       int n=nums.length;
       int digitSum=0;
       String numsToString="";
       for(int i=0;i<n;i++){
           elementSum=elementSum+nums[i];
           numsToString=Integer.toString(nums[i]);
           for(int j=0;j<numsToString.length();j++){
               digitSum=digitSum+Integer.parseInt(String.valueOf(numsToString.charAt(j)));
           }
       } 

       return Math.abs(elementSum-digitSum);
    }
}

//Optimal Solution
// class Solution {
//     public int differenceOfSum(int[] nums) {
//        int numsSum=0;
//        int digitSum=0;
//        for(int i=0;i<nums.length;i++) {
//           numsSum+=nums[i] ;
//           int num=nums[i];
//           if(num>=10){
//               while(num>0){
//                 digitSum+=num%10;
//                 num=num/10;
//               }
//           }
//            else{
//                digitSum+=num;
//            }
//        }
//       return Math.abs(numsSum-digitSum) ;
//     }
// }