class Solution {
    public int maxProfit(int[] prices) {
        
        //to choose the day for buying the stock
        int minPrice=Integer.MAX_VALUE;
        int maxProfit=0;
        
        for(int i=0;i<prices.length;i++){
            minPrice=Math.min(minPrice, prices[i]);
            maxProfit=Math.max(maxProfit, prices[i]-minPrice);
        }
        
        return maxProfit;
    }
}