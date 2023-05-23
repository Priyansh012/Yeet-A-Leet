class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> majorityMap = new HashMap<Integer, Integer>();
        int result=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            majorityMap.put(nums[i], majorityMap.getOrDefault(nums[i],0)+1);
        }

         for (Map.Entry<Integer,Integer> mapElement : majorityMap.entrySet()) {
             if(mapElement.getValue()>(n/2)){
                result= mapElement.getKey();
                break;
             }
        }

        return result;
    }
}