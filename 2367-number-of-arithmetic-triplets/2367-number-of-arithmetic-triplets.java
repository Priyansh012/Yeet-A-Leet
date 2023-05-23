class Solution {
    public int arithmeticTriplets(int[] nums, int diff) {
        HashSet<Integer> visited = new HashSet<Integer>();
        int count=0;
        int n=nums.length;
        for(int i=0;i<n;i++){

            if(visited.contains(nums[i]-diff) && visited.contains(nums[i]-diff*2))
                count++;
            visited.add(nums[i]);
        }

        return count;
    }
}