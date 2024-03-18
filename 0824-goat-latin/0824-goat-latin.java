class Solution {
    public String toGoatLatin(String sentence) {
        String words [] = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<words.length;i++){

            //vowels
            if(words[i].charAt(0)=='a' || words[i].charAt(0)=='e' || words[i].charAt(0)=='i' || words[i].charAt(0)=='o' || words[i].charAt(0)=='u' || words[i].charAt(0)=='A' || words[i].charAt(0)=='E' 
            || words[i].charAt(0)=='I' || words[i].charAt(0)=='O' || words[i].charAt(0)=='U'){
                sb.append(words[i]);

            }

            //consonants
            else{
                sb.append(words[i].substring(1));
                sb.append(words[i].charAt(0));
            }

            sb.append("ma");
            for(int j=0;j<=i;j++){
                sb.append("a");
            }

            if(i<words.length-1)
                sb.append(" ");
        }

        return sb.toString();
    }
}