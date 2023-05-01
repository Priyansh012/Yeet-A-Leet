class Solution {
    public boolean checkIfPangram(String sentence) {
        HashSet<Character> chars = new HashSet<Character>(); 
        for (char ch : sentence.toCharArray()) { 
            chars.add(ch); 
        } 
        if(chars.size()==26)
            return true;
        
        return false;

    }
}