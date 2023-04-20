class Solution {
    public char repeatedCharacter(String s) {
        HashMap<Character, Integer> map = new HashMap<Character,Integer>();
        int n= s.length();
        char result=' ';
        for(int i=0;i<n;i++){
            if(map.containsKey(s.charAt(i))){
                result=s.charAt(i);
                break;
            }
            else
                map.put(s.charAt(i),1);
        }
        return result;
    }
}