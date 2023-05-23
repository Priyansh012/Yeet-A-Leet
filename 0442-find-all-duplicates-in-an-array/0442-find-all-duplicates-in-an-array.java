class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i=0;i<nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        }
        for(int i=0;i<nums.length;i++){
            if(map.get(nums[i])==2){
                list.add(nums[i]);
                map.put(nums[i], -1);
            }
        }

        return list;
    }
}

//Optimal solution
// public class Solution {
//     // when find a number i, flip the number at position i-1 to negative. 
//     // if the number at position i-1 is already negative, i is the number that occurs twice.
    
//     public List<Integer> findDuplicates(int[] nums) {
//         List<Integer> res = new ArrayList<>();
//         for (int i = 0; i < nums.length; ++i) {
//             int index = Math.abs(nums[i])-1;
//             if (nums[index] < 0)
//                 res.add(Math.abs(index+1));
//             nums[index] = -nums[index];
//         }
//         return res;
//     }
// }
