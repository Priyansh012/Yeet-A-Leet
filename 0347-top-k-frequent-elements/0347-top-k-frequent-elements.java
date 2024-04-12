class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int result [] = new int[k];
        for(int i=0;i<nums.length;i++){
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>(
            (entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()) 
        );

        maxHeap.addAll(map.entrySet());

        for(int i=0;i<k;i++){
            result[i]=maxHeap.poll().getKey();
        }

        return result;
    }
}