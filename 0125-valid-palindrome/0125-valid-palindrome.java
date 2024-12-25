class Solution {
    public boolean isPalindrome(String s) {
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
    }
}