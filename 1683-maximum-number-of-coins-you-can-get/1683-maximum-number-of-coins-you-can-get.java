class Solution {
    public int maxCoins(int[] piles) {
        int result=0;
        int left=0;
        int right=piles.length-1;

        Arrays.sort(piles);
        
        while(left<right){
            //choosing the last element as a pick by alice, second last by us and first by Bob
            //i.e Bob =left, yourself=right-1 and Alice=right
            result=result+piles[right-1];
            left+=1;
            right-=2;
        }

        return result;

    }
}