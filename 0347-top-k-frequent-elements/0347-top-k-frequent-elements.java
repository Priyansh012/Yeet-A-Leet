class Solution {

    // O(nlogK)--Heap better solution compared to sorting
    // public int[] topKFrequent(int[] nums, int k) {
    // Map<Integer, Integer> elementsFrequency = new HashMap<>();
    // int result [] = new int [k];

    // for(int i=0;i<nums.length;i++){
    // elementsFrequency.put(nums[i], elementsFrequency.getOrDefault(nums[i], 0)+1);
    // }

    // //descending order
    // PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>(
    // (a, b) -> b.getValue().compareTo(a.getValue())
    // );

    // maxHeap.addAll(elementsFrequency.entrySet());

    // for(int i=0;i<k;i++){
    // result[i]=maxHeap.poll().getKey();
    // }

    // return result;
    // }

    // O(n)-- bucket sort, special case of sorting in O(n)
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> elementsFrequency = new HashMap<>();
        int result[] = new int[k];
        // frequency bucket(list of array) and not list of list because the size is
        // fixed
        // n+1 because we will store 0 count as well
        List<Integer>[] freq = new List[nums.length + 1];

        // creating empty frequency bucket so that we can add same frequency elements to
        // that key
        // key here is the count and the values will be a list where all similar count
        // elements will be stored
        for (int i = 0; i < freq.length; i++) {
            freq[i] = new ArrayList<>();
        }

        for (int i = 0; i < nums.length; i++) {
            elementsFrequency.put(nums[i], elementsFrequency.getOrDefault(nums[i], 0) + 1);
        }

        // mapping frequency as a key in the bucket and keys as list of values
        for (Map.Entry<Integer, Integer> entry : elementsFrequency.entrySet()) {
            freq[entry.getValue()].add(entry.getKey());
        }

        int index = 0;
        for (int i = freq.length - 1; i > 0 && index < k; i--) {
            for (int n : freq[i]) {
                result[index++] = n;
                if (index == k) {
                    return result;
                }
            }
        }

        return result;
    }
}