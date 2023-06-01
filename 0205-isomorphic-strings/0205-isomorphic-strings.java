class Solution {
    public String transformedString(String str){
        Map<Character, Integer> charIndex = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<str.length();i++){
            if(!charIndex.containsKey(str.charAt(i)))
                charIndex.put(str.charAt(i), i);

            sb.append(charIndex.get(str.charAt(i)));
            sb.append(" ");
        }
        return sb.toString();
    }

    public boolean isIsomorphic(String s, String t) {
        return transformedString(s).equals(transformedString(t));
    }
}