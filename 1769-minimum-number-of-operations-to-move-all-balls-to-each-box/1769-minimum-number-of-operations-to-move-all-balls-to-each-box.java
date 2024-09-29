class Solution {
    //O(n^2)
   /* public int[] minOperations(String boxes) {
        int moves;
        int [] result = new int [boxes.length()];
        for(int i=0;i<boxes.length();i++){
            moves=0;
            for(int j=0;j<boxes.length();j++){
                if(j!=i && boxes.charAt(j)-'0'==1){
                    int diff=Math.abs(j-i);
                    moves=moves+diff;
                }
            }
            result[i]=moves;
        }

        return result;
    }*/

    //O(n)
    public int[] minOperations(String boxes) {
        int [] result = new int [boxes.length()];
        int operations=0, count=0;

        for(int i=0;i<boxes.length();i++){
            result[i]+=operations;
            count+=boxes.charAt(i)-'0';
            operations+=count;
        }

        operations=0; count=0;

        for(int i=boxes.length()-1;i>-1;i--){
            result[i]+=operations;
            count+=boxes.charAt(i)-'0';
            operations+=count;
        }

        return result;
    }
}