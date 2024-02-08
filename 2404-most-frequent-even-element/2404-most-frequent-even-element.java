class Solution {
    public int mostFrequentEven(int[] nums) {
        Map<Integer, Integer> elementsCount = new HashMap<>();
        int max=-1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]%2==0){
                elementsCount.put(nums[i], elementsCount.getOrDefault(nums[i],0)+1);
            }
        }
        elementsCount.forEach((key, value) -> System.out.println(key + " " + value));

        int curMaxFrequency=0;
        for(Map.Entry<Integer, Integer> element: elementsCount.entrySet()){
            if(element.getValue()>curMaxFrequency){
                max=element.getKey();
                curMaxFrequency=element.getValue();
            }

            //tie case
            if(element.getValue()==curMaxFrequency && element.getKey()<max){
                max=element.getKey();
            }
        }

        return max;
    }
}