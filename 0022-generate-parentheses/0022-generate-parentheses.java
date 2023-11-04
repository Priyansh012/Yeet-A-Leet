class Solution {
    public List<String> generateParenthesis(int n) {
        //add ( - when openCount < n
        //add ) - when closedCount < openCount
        //well-formed parentheses - openCount = closedCount = n

        List<String> ans = new ArrayList<>();
        backtrack(0, 0, "", ans, n);
        return ans;
    } 

    public void backtrack(int openCount, int closedCount, String str, List<String> ans, int n){
        // base case
        if(openCount == closedCount && openCount == n){
            ans.add(str);
        }

        if(openCount < n){
            backtrack(openCount+1, closedCount, str+"(", ans, n);
        }

        if(closedCount < openCount){
            backtrack(openCount, closedCount+1, str+")", ans, n);
        }    
    }

}