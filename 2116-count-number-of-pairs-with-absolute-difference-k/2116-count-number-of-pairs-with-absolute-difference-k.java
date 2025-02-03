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