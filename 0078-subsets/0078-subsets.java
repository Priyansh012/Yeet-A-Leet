class Solution {
    
    //Backtracking recursion
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        printUniqueElements(list, new ArrayList<>(), nums, 0);
        return list;
    }
    
    private void printUniqueElements(List<List<Integer>> list, List<Integer> tempList, int [] nums, int ind){
        if(nums.length == ind){
            list.add(new ArrayList<>(tempList));    
            return;
        }
        tempList.add(nums[ind]);
        printUniqueElements(list, tempList, nums, ind+1);
        tempList.remove(tempList.size()-1);
        printUniqueElements(list, tempList, nums, ind+1);
    }
}