class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> characterToCount = new HashMap<Character, Integer>();
        int left;
        int max=0;
        int count;
        int n=s.length();
        int right;
        if(n==0)
            return 0;
        if(n==1)
            return 1;
        for(left=0;left<n-1;left++){
            characterToCount.put(s.charAt(left),1);
            count=1;
            right=left+1;
            while(!characterToCount.containsKey(s.charAt(right))){
                characterToCount.put(s.charAt(right),1);
                count++;
                right++;
                if(right>n-1)
                    break;
            }
            if(max<count)
                max=count;
            characterToCount.clear();
        }

        return max;
    }
}