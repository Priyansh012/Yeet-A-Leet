class Solution {
    public int numberOfSubstrings(String s) {
        int n=s.length();
        int charArray [] = new int[3];
        int count=0;
        int start=0;
        int end=0;

        while(end<n){
            
            charArray[s.charAt(end)-'a']++;
            while(charArray[0]>0 && charArray[1]>0 && charArray[2]>0){
                charArray[s.charAt(start)-'a']--;
                count+=(n-end);
                start++;
            }
            end++;
        }

        return count;
    }
}