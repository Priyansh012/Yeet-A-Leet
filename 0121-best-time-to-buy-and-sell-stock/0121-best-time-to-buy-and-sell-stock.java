class Solution {
    //brute force(got TLE)
   /* public int maxProfit(int[] prices) {
        int n=prices.length;
        int maxProfit=0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(maxProfit<prices[j]-prices[i])
                    maxProfit=prices[j]-prices[i];
            }
        }

        return maxProfit;
    }*/

    //sliding window
    public int maxProfit(int[] prices) {
        int left=0;
        int right=1;
        int maxProfit=0;
        int profit;
        //left=buy
        //right=sell
        while(right<prices.length){
            //profitable?
            if(prices[left]<prices[right]){
                profit=prices[right]-prices[left];
                maxProfit=Math.max(profit, maxProfit);
            }
            else
                //slide the window towards right
                left=right; 
            right++;  
        }
           
        return maxProfit;
    }
}