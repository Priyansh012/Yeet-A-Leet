class Solution {
    public List<List<String>> partition(String s) {
        List<String> partitionList = new ArrayList<>();
        List<List<String>> result = new ArrayList<>();

        backtrackingFunc(0, partitionList, result, s);

        return result;
    }

    public void backtrackingFunc(int index, List<String> partitionList, 
    List<List<String>> result, String s){

        if(index==s.length()){
            result.add(new ArrayList<>(partitionList));
            return;
        }

        for(int i=index;i<s.length();i++){
            if(isPalindrome(s, index, i)){
                partitionList.add(s.substring(index, i+1));
                backtrackingFunc(i+1, partitionList, result, s);
                partitionList.remove(partitionList.size()-1);
            }
        }

    }

    public boolean isPalindrome(String s, int start, int end){
        String original =s.substring(start,end+1);
        StringBuilder rev= new StringBuilder(original);
        rev=rev.reverse();
        if(original.equals(rev.toString())){
            return true;
        }
        return false;
    }
}