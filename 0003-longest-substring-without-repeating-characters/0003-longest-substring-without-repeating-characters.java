class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int left=0, right=0, max=0;
        int flag=0;

        if(s.length()==1)
            return 1;
        
        while(right<s.length()){
            if(set.contains(s.charAt(right))){
                left+=1;
                right=left;
                set.clear();
                set.add(s.charAt(right));
                flag=1;
            }

            else{
                set.add(s.charAt(right));
            }
            right+=1;
            max=Math.max(max, right-left);
        }

        return flag==0?right-left:max;
    }
}