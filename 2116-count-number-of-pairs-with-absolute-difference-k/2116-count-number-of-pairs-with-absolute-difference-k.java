class Solution {
    public int countKDifference(int[] nums, int k) {
        int pairs=0;
        Map<Integer, Integer> freqMap = new HashMap<>();

        for(int num: nums){
            freqMap.put(num, freqMap.getOrDefault(num, 0)+1);
        }

        for(int key: freqMap.keySet()){
            if(freqMap.containsKey(key-k)){
                pairs+=freqMap.get(key)*freqMap.get(key-k);
            }
            // if(freqMap.containsKey(key+k)){
            //     pairs+=freqMap.get(key)*freqMap.get(key+k);
            // }
        }

        return pairs;

    }
}

//One pass solution
// class Solution {
//     public int countKDifference(int[] nums, int k) {
//         Map<Integer,Integer> map = new HashMap<>();
//         int res = 0;
        
//         for(int i = 0;i< nums.length;i++){
//             if(map.containsKey(nums[i]-k)){
//                 res+= map.get(nums[i]-k);
//             }
//             if(map.containsKey(nums[i]+k)){
//                 res+= map.get(nums[i]+k);
//             }
//             map.put(nums[i],map.getOrDefault(nums[i],0)+1);
//         }
        
        
//         return res;
//     }
// }