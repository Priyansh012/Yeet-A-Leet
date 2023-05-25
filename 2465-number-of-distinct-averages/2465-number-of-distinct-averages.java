class Solution {
    public int distinctAverages(int[] nums) {
        double curAverage;
        ArrayList<Integer> list =new ArrayList<Integer>();
        for(int i:nums) {
            list.add(i);
        }  
        Collections.sort(list);
        ArrayList<Double> avgList = new ArrayList<>();

        while(list.size()!=0){
            curAverage=Math.floor(list.get(0)+list.get(list.size()-1))/2;
            if(!avgList.contains(curAverage)){
                avgList.add(curAverage);
            }
            list.remove(0);
            list.remove(list.size()-1);
        }

        return avgList.size();
    }
}

//Optimal Solution
// class Solution 
// {
//     public int distinctAverages(int[] nums) 
//     {
//         Arrays.sort(nums);
        
//         Set<Double> u = new HashSet<>();
//         int n = nums.length;
        
//         for(int i = 0; i < n/2; ++i)
//             u.add((nums[i] + nums[n-i-1]) / 2.0);

//         return u.size();
//     }
// }