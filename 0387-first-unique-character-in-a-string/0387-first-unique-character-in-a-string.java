class Solution {
    public int firstUniqChar(String s) {
        Map<Character, Integer> frequencyMap= new HashMap();
   
        for(int i=0; i<s.length();i++){
            char c=s.charAt(i);
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0)+1);
        }

        for(int i=0; i<s.length();i++){
            if(frequencyMap.get(s.charAt(i))==1)
                return i;
        }

        return -1;
         
    }
}