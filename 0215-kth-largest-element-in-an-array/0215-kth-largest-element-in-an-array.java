class Solution {
    //BruteForce
    // public int findKthLargest(int[] nums, int k) {
    //     int kthMax=Integer.MAX_VALUE;
    //     int n=nums.length;
    //     int prevMax=Integer.MIN_VALUE;
    //     List prevIndex = new ArrayList<>();
    //     int index=0;
    //     for(int i=0;i<k;i++){
    //         for(int j=0;j<n;j++){
    //             if(nums[j]>=prevMax && nums[j]<=kthMax && !prevIndex.contains(j)){
    //                 prevMax=nums[j];
    //                 index=j;
    //                 System.out.println(prevMax);
    //             }
    //         }
    //         kthMax=prevMax;
    //         prevMax=Integer.MIN_VALUE;
    //         prevIndex.add(index);
    //         System.out.println(kthMax+" ,"+index);
    //     }
    //     return kthMax;
    // }

    //Better Solution with Heap
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);

        for(int element:nums){
            pq.add(element);
        }

        int count=k-1;
        while(count>0){
            pq.remove();
            count--;
        }

        int result=pq.peek();
        return result;
    }
}