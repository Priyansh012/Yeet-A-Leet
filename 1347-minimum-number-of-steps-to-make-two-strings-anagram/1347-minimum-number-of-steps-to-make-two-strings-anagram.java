class Solution {
    public int minSteps(String s, String t) {
        HashMap<Character, Integer> mapS = new HashMap<Character, Integer>();
        HashMap<Character, Integer> mapT = new HashMap<Character, Integer>();        
        int count=0;
        for(int i=0;i<s.length();i++){
            mapS.put(s.charAt(i), mapS.getOrDefault(s.charAt(i),0)+1);
        }

        for(int i=0;i<t.length();i++){
            mapT.put(t.charAt(i), mapT.getOrDefault(t.charAt(i),0)+1);
        }

        for(char ch : mapT.keySet()) {
            if(mapS.get(ch) == null) 
                count+=mapT.get(ch); 
            else if(mapS.get(ch) < mapT.get(ch)) 
                count+=(mapT.get(ch) - mapS.get(ch)); 
        }    
      return count;  
    }
}