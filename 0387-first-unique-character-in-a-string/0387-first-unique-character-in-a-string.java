class Solution {
    public int firstUniqChar(String s) {
       HashMap<Character, Integer> map = new HashMap<Character,Integer>();
        int n= s.length();
        int index=-1;
        if(n==1)
            return 0;
        for(int i=0;i<n;i++){
            if(map.containsKey(s.charAt(i))){
                map.put(s.charAt(i),map.get(s.charAt(i))+1);
            }
            else
                map.put(s.charAt(i),1);
        }
          for(int i=0;i<n;i++){
             if(map.get(s.charAt(i))<2)
             {
                 index=i;
                 break;
             }
        }        
        return index;  
    }
}

/*
Optimal Solution
class Solution {
    public int firstUniqChar(String s) {
        int[] count = new int[26];
        int n = s.length();
        // build char count bucket : <charIndex, count>
        for (int i = 0; i < n; i++) {            
            int index = s.charAt(i) - 'a';
            count[index]++;
        }
        
        // find the index
        for (int i = 0; i < n; i++) {
            int index = s.charAt(i) - 'a';
            if (count[index] == 1) {
                return i;
            }
                
        }
        return -1;
    }
}
*/