class Solution {
    public int mostWordsFound(String[] sentences) {
        int output=0;
        for(int i=0;i<sentences.length;i++){
            if(output<sentences[i].length() - sentences[i].replaceAll(" ", "").length())
                output=sentences[i].length() - sentences[i].replaceAll(" ", "").length();
        }

        return output+1;
    }
}