class Solution {
    //TC: O(N)
    //SC:O(N)
    /*public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                sb.append(Character.toLowerCase(c));
            }
        }

        if(sb.isEmpty() || sb.length()==1)
            return true;
        
        //In-Built method approach
        // String original = sb.toString(); 
        // String reversed = sb.reverse().toString();

        // if(original.equals(reversed))
        //     return true;

        //Two-pointer approach
        int start=0;
        int end=sb.length()-1;
        while(start<end)
        {
            if(sb.charAt(start)!=sb.charAt(end))
                return false;
            
            start+=1;
            end-=1;
        }
        return true;
    }*/
    
    public boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;

        while (l < r) {
            while (l < r && !alphaNum(s.charAt(l))) {
                l++;
            }
            while (r > l && !alphaNum(s.charAt(r))) {
                r--;
            }
            if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))) {
                return false;
            }
            l++; r--;
        }
        return true;
    }

    public boolean alphaNum(char c) {
        return (c >= 'A' && c <= 'Z' || 
                c >= 'a' && c <= 'z' || 
                c >= '0' && c <= '9');
    }
}