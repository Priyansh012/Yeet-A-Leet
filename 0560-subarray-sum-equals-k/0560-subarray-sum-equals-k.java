class Solution {
    public int subarraySum(int[] nums, int k) {
        int n=nums.length;
        Map<Integer, Integer> prefixMap= new HashMap<Integer, Integer>();
        int prefixSum=0, count=0;

        prefixMap.put(0, 1);

        for(int i=0;i<n;i++){
            //add current element to prefixSum
            prefixSum+=nums[i];
            // Calculate x-k:
            int revEngg=prefixSum-k;

            count+=prefixMap.getOrDefault(revEngg,0);
            
            //Update the count of prefixSum in the map.
            prefixMap.put(prefixSum, prefixMap.getOrDefault(prefixSum,0)+1);
        }

        return count;
    }
}