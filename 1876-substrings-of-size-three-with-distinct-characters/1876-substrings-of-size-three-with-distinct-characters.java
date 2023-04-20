class Solution {
    public int countGoodSubstrings(String s) {
        int right=0;
        int count=0;
        int n= s.length();
        if(n<3)
            return 0;
        for(int left=0;left<n-2;left++){
            right=left+2;
            if(s.charAt(left)!=s.charAt(left+1) && s.charAt(left)!=s.charAt(right) && s.charAt(left+1)!=s.charAt(right)){
                count++;
            }
        }

        return count;
    }
}