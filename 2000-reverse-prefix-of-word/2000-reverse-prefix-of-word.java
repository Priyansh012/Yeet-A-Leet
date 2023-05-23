class Solution {
    public String reversePrefix(String word, char ch) {
        int index=word.indexOf(ch);
        if(index<0)
            return word;
        else{
            StringBuilder revPrefix = new StringBuilder();
            revPrefix=revPrefix.append(word.substring(0,index+1));
            revPrefix.reverse();
            revPrefix.append(word.substring(index+1));
            return revPrefix.toString();
        }    


    }
}