class Solution {

    //bruteforce will be O(n*m)

    //now better but some elements will be visited twice
    /*public int lengthOfLongestSubstring(String s) {
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
    }*/

    //optimal O(n) TC and O(m) SC
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> charSet = new HashSet<>();
        int l = 0;
        int res = 0;

        for (int r = 0; r < s.length(); r++) {
            while (charSet.contains(s.charAt(r))) {
                charSet.remove(s.charAt(l));
                l++;
            }
            charSet.add(s.charAt(r));
            res = Math.max(res, r - l + 1);
        }
        return res;
    }
}