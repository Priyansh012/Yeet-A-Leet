class Solution {
    //Better than O(N^2)
    //TC:O(NLogN)+O(N) and SC:O(N)
    /*public int majorityElement(int[] nums) {
        Map<Integer, Integer> elementCount = new HashMap<>();
        int max=0;
        int majorityElement=0;
        for(int i=0;i<nums.length;i++){
            elementCount.put(nums[i], elementCount.getOrDefault(nums[i],0)+1);
        }

        for(Map.Entry<Integer, Integer> element: elementCount.entrySet()){
            if(max<element.getValue()){
                max=element.getValue();
                majorityElement=element.getKey();
            }
        }

        return majorityElement;
    }*/

    //Optimized Soln with O(N) time and O(1) space
    //Moore's Voting Algorithm
    public int majorityElement(int[] nums) {
        int count=0;
        int majorElement=0;
        for(int i=0;i<nums.length;i++){
            if(count==0){
                majorElement=nums[i];
                count++;
            }
            else if(majorElement==nums[i])
                count++;
            else
                count--;
        }    

        return majorElement;

        //if we stop assuming that majority element exists all the time in the I/P
        /*
            int count2=0;
            for(int i=0;i<nums.length;i++){
                if(nums[i]==majorityElement)
                    count2++;
            }
            if(count2>(nums.length/2))
                return count2;
            
            return -1;
        */
    }
}