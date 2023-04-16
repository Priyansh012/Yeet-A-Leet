class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int lw1=word1.length;
        int lw2=word2.length;
        StringBuilder str1= new StringBuilder();
        StringBuilder str2= new StringBuilder();

        if(lw1>=1){
            for(int i=0;i<lw1;i++){
                str1.append(word1[i]);
            }
        }
        if(lw2>=1){
            for(int i=0;i<lw2;i++){
                str2.append(word2[i]);
            }
        }        
        if(str1.compareTo(str2)==0)
            return true;
        else
            return false; 
    }
}