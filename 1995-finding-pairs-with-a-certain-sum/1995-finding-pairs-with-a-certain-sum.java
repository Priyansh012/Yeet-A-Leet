class FindSumPairs {
    Map<Integer, Integer> freq1;
    Map<Integer, Integer> freq2;
    int [] nums2Copy;

    public FindSumPairs(int[] nums1, int[] nums2) {
        freq1=new HashMap<>();
        freq2=new HashMap<>();
        nums2Copy=nums2;

        for(int i=0;i<nums1.length;i++){
            freq1.put(nums1[i], freq1.getOrDefault(nums1[i], 0)+1);
        }
        
        for(int i=0;i<nums2.length;i++){
            freq2.put(nums2[i], freq2.getOrDefault(nums2[i], 0)+1);
        }
        
    }
    
    public void add(int index, int val) {
        int oldNum=nums2Copy[index];
        nums2Copy[index]+=val;
        int newNum=nums2Copy[index];
        freq2.put(newNum, freq2.getOrDefault(newNum, 0)+1);
        freq2.put(oldNum, freq2.get(oldNum)-1);
    }
    
    public int count(int tot) {
        int pairs=0;
        for(int freq: freq1.keySet()){
            if(freq2.containsKey(tot-freq)){
                pairs+=freq1.get(freq)*freq2.get(tot-freq);
            }
        }

        return pairs;
    }
}

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs obj = new FindSumPairs(nums1, nums2);
 * obj.add(index,val);
 * int param_2 = obj.count(tot);
 */