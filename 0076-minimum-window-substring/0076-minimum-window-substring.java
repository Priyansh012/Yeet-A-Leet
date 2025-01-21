class Solution {
    public String minWindow(String s, String t) {
        if (t.isEmpty()) return "";

        Map<Character, Integer> countT = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        //use toCharArray instead of charAt/normal for loop for better readability
        for (char c : t.toCharArray()) {
            countT.put(c, countT.getOrDefault(c, 0) + 1);
        }

        int have=0, need=countT.size();
        int result [] ={-1, -1};
        int resLen=Integer.MAX_VALUE;
        int left=0;

        for(int right=0;right<s.length();right++){
            char c=s.charAt(right);
            window.put(c, window.getOrDefault(c, 0) + 1);

            if(countT.containsKey(c) && window.get(c).equals(countT.get(c)))
                have+=1;
            
            while(have==need){
                if((right-left+1)<resLen)
                {
                    resLen=right-left+1;
                    result[0]=left;
                    result[1]=right;
                }


                char leftChar=s.charAt(left);
                window.put(leftChar, window.get(leftChar)-1);
                if(countT.containsKey(leftChar) && window.get(leftChar)<countT.get(leftChar))
                    have-=1;
                
                left+=1;
            }
        }

        return resLen==Integer.MAX_VALUE?"":s.substring(result[0], result[1]+1);
    }
}