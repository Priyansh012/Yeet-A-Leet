class Solution {
    public String replaceDigits(String s) {
        int n=s.length();
        int character;
        StringBuilder str = new StringBuilder(s);
        for(int i=1;i<n;i++){
            if(Character.isDigit(str.charAt(i))){
                character= str.charAt(i-1);
                character = character+Character.getNumericValue(str.charAt(i));
                str.setCharAt(i, (char) character);
            }
        }

        return str.toString();
    }
}