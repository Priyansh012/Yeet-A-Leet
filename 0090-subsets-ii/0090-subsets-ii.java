class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        HashSet<List<Integer>> result = new HashSet<>();
        recursiveFunc(0, nums, new ArrayList<>(), nums.length, result);
        List<List<Integer>> finalResult = new ArrayList<>(result);
        return finalResult;
    }
    
    void recursiveFunc(int index, int [] arr, ArrayList<Integer> tempList, 
    int N, HashSet<List<Integer>> result){
        
        //if N in reached in the tree, then add that list to the result
        //and return and continue the recursive func
        if(index==N){
            Collections.sort(tempList);
            result.add(tempList);
            return;
        }
        
        //Pick the element
        // Create a copy of tempList and add the current element
        ArrayList<Integer> tempListWithCurrent = new ArrayList<>(tempList);
        tempListWithCurrent.add(arr[index]);
        recursiveFunc(index + 1, arr, tempListWithCurrent, N, result);

        // Scenario 2: Don't pick the element
        // Proceed with recursion without adding the current element
        recursiveFunc(index + 1, arr, tempList, N, result);
    }    
}