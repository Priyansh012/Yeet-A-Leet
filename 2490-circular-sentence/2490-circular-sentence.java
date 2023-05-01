class Solution {
    public boolean isCircularSentence(String sentence) {
        if(sentence.charAt(0)!=sentence.charAt(sentence.length()-1))
            return false;
        String splitString [] = sentence.split(" ");
        int n=splitString.length;
        for(int i=0;i<n-1;i++){
            int charLastPointer = splitString[i].length()-1;
            if(splitString[i].charAt(charLastPointer)!=(splitString[i+1].charAt(0)))
                return false;
        }
        return true;
    }
}