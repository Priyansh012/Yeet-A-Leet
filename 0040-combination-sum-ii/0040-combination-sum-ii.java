/*class Solution {
   public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        HashSet<List<Integer>> result = new HashSet<>();
        HashMap<Integer, Integer> indexWithValues = new HashMap<>();

        Arrays.sort(candidates);
        recursiveFunc(0, target, candidates, result, indexWithValues);
        List<List<Integer>> finalResult = new ArrayList<>(result);

        return finalResult;
    }

    public void recursiveFunc(int index, int target, int [] candidates,  
    HashSet<List<Integer>> result, HashMap<Integer, Integer> indexWithValues){

        if(index == candidates.length){
            if(target==0){
                List<Integer> currentList = new ArrayList<Integer>(indexWithValues.values());
                result.add(new ArrayList<>(currentList));
                return;
            }
            return;
        }

        //pick
        if(candidates[index]<=target && !indexWithValues.containsKey(index)){
            indexWithValues.put(index, candidates[index]);
            recursiveFunc(index, target-candidates[index], candidates, result, indexWithValues);
            indexWithValues.remove(index);
        }

        //do not pick
        recursiveFunc(index+1, target, candidates, result, indexWithValues);
    }

}*/


class Solution {
public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    List<List<Integer>> result = new ArrayList<>();
    Arrays.sort(candidates);
    backtrack(0, target, candidates, result, new ArrayList<>());

    return result;
}

public void backtrack(int index, int target, int [] candidates,  
List<List<Integer>> result, List<Integer> currentList){
    //no solution
    if(target < 0)
        return;

    // one of the combination sol found
    else if(target == 0) 
        result.add(new ArrayList<>(currentList));

    else{
        for (int i = index; i < candidates.length; i++) {

            //skipping future duplicates because when  i> index
            //those combination were already considered at the initial value of index
            //so no need to consider them again
            if(i > index && candidates[i] == candidates[i-1]) 
                continue;
            currentList.add(candidates[i]);
            backtrack(i+1, target - candidates[i], candidates, result, currentList);
            currentList.remove(currentList.size() - 1);
        }
    }
}
}