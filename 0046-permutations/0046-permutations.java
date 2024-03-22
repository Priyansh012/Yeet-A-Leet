class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrackingFunc(0, nums, result);
        return result;
    }

    public void backtrackingFunc(int index, int [] nums, List<List<Integer>> result){

        if(index==nums.length){
            List<Integer> currentPermute = new ArrayList<>();
            for(int i=0; i<nums.length;i++)
                currentPermute.add(nums[i]);
            result.add(new ArrayList<>(currentPermute));
            return;
        }
        for(int i=index;i<nums.length;i++){
            swap(i, index, nums);
            backtrackingFunc(index+1, nums, result);
            swap(i, index, nums);
        }
            
        
    }

    private void swap(int a, int b, int nums []){
        int temp=nums[a];
        nums[a]=nums[b];
        nums[b] = temp;
    }
}