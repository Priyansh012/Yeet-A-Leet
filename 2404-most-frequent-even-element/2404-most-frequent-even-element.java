class Solution {
    //TC O(2N)
    //SC O(N)
    //two pass
    /*public int mostFrequentEven(int[] nums) {
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
    }*/

    //one pass
    public int mostFrequentEven(int[] A) {
        HashMap<Integer,Integer> mp= new HashMap<>();
        int val=1000000,freq=0;
        for(var i:A){
            //if even element
            if(i%2==0){
                //increase frequency in map
                int curr= mp.getOrDefault(i,0)+1;
                mp.put(i,curr);
                //Update smallest with greatest frequency
                if(curr>freq || curr==freq && i<val){
                    val=i;
                    freq=curr;
                }
            }
        }
        return freq==0? -1 : val;
    }


}