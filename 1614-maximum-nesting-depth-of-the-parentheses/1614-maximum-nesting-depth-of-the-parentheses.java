class Solution {
    public int maxDepth(String s) {
        int maxCount=0;
        int count=0;
        for(int right=0;right<s.length();right++){
            if(s.charAt(right)=='('){
                count++;
                maxCount=Math.max(maxCount,count);
            }
            else if(s.charAt(right)==')'){
                count--;
            }
        }
        return maxCount;
    }
}