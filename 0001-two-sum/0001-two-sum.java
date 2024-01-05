class Solution {
    /*public int[] twoSum(int[] nums, int target) {
        List<Integer> numsList = new ArrayList<>();
        int n=nums.length;

        for(int i=0;i<n;i++){
            numsList.add(nums[i]);
        }
        int index;
        for(int i=0;i<n;i++){
            index=numsList.indexOf(target-nums[i]);
            System.out.println(index);
            if(index!=-1 && index!=i){
                return new int [] {i, index};
            }
        }

        return new int [] {0,0};
    }*/

    //Optimal solution with 1 pass only using Hashmap
    //Elements as key and their index as values in Hashmap
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> indexedElements = new HashMap<>();

        for(int i=0;i<nums.length;i++){
            if(indexedElements.containsKey(target-nums[i])){
                return new int []{i, indexedElements.get(target-nums[i])};
            }
            else
                indexedElements.put(nums[i], i);
        }

        return new int [] {0,0};
    }

}