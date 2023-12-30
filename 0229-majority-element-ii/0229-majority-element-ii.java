class Solution {
   /* public List<Integer> majorityElement(int[] nums) {
       Map<Integer, Integer> elementCount = new HashMap<>();
       List<Integer> result = new ArrayList<>();
       for(int i=0;i<nums.length;i++){
           elementCount.put(nums[i], elementCount.getOrDefault(nums[i], 0)+1);
       }

       for(Map.Entry<Integer, Integer> element: elementCount.entrySet()){
           if(element.getValue()>(nums.length/3)){
               result.add(element.getKey());
           }
           if(result.size()==2)
            break;
       } 

       return result;
    }*/

    //Optimal Solution via Moore's Voting algorithm
    //we know that there will be at max 2 majority elements which are present >n/3 times
    public List<Integer> majorityElement(int[] nums) {
        
        int count1=0;
        int count2=0;
        int majorElement1=0, majorElement2=0;
        List<Integer> result = new ArrayList<>();

        for(int i=0;i<nums.length;i++){
            if(count1==0 && nums[i]!=majorElement2){
                majorElement1=nums[i];
                count1++;
            }

            else if(count2==0 && nums[i]!=majorElement1){
                majorElement2=nums[i];
                count2++;
            }

            else if(nums[i]==majorElement1)
                count1++;
            
            else if(nums[i]==majorElement2)
                count2++;
            
            else{
                count1--;
                count2--;
            }
        }

        count1=0;
        count2=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==majorElement1){
                count1++;
            }

            else if(nums[i]==majorElement2)
                count2++;
        }
        if(count1>(nums.length/3))
            result.add(majorElement1);
        
        if(count2>(nums.length/3))
            result.add(majorElement2);

        return result;
    }
}